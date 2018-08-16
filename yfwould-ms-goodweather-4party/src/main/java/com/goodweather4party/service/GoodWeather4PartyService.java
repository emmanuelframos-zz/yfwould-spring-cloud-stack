package com.goodweather4party.service;

import com.goodweather4party.api.dto.PlaylistDTO;
import com.goodweather4party.api.dto.PlaylistFilter;
import com.goodweather4party.api.parser.PlaylistParser;
import com.goodweather4party.api.validator.PlaylistFilterValidator;
import com.goodweather4party.builder.PlaylistBuilder;
import com.goodweather4party.config.RedisConfig;
import com.goodweather4party.domain.TrackStyles;
import com.goodweather4party.exception.BusinessException;
import com.goodweather4party.exception.ExceptionMessages;
import com.goodweather4party.integration.openweather.dto.ExternalWeatherDTO;
import com.goodweather4party.integration.openweather.service.OpenWeather4PartyIntegrationService;
import com.goodweather4party.integration.redis.service.RedisService;
import com.goodweather4party.integration.spotify.dto.ExternalPlaylistDTO;
import com.goodweather4party.integration.spotify.service.Spotify4PartyIntegrationService;
import com.google.gson.Gson;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodWeather4PartyService {

    private static final Logger logger = LoggerFactory.getLogger(GoodWeather4PartyService.class);

    @Autowired
    private OpenWeather4PartyIntegrationService openWeather4PartyIntegrationService;

    @Autowired
    private Spotify4PartyIntegrationService spotify4PartyIntegrationService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisConfig redisConfig;

    @Autowired
    private TrackStyleSelector trackStyleSelector;

    @Autowired
    private PlaylistFilterValidator playlistFilterValidator;

    @Autowired
    private PlaylistParser playlistParser;

    private Gson gson = new Gson();

    @HystrixCommand(commandKey ="fallback_suggestPlaylist", fallbackMethod = "suggestDefaultPlaylist")
    public PlaylistDTO suggestPlaylist(PlaylistFilter playlistFilter) throws BusinessException {

        logger.info("Validating playlist filter {}.", playlistFilter);

        playlistFilterValidator.validate(playlistFilter);

        logger.info("Searching weather with filter {}.", playlistFilter);

        ExternalWeatherDTO externalWeatherDTO = this.openWeather4PartyIntegrationService.findWeather(playlistFilter);

        logger.info("Selecting playlist with filter {}.", playlistFilter);

        TrackStyles trackStyle = trackStyleSelector.selectPlaylist(externalWeatherDTO.temperature);

        logger.info("Getting playlist with filter {}.", playlistFilter);

        ExternalPlaylistDTO externalPlaylistDTO = this.getPlaylist(trackStyle);

        logger.info("Converting playlist to domain.");

        return playlistParser.toDomain(externalPlaylistDTO);
    }

    private ExternalPlaylistDTO getPlaylist(TrackStyles trackStyle) throws BusinessException {

        String playlistInCache = redisService.get(redisConfig.getPlaylistKey().concat(trackStyle.name()));

        if (!StringUtils.isEmpty(playlistInCache)){
            return gson.fromJson(playlistInCache, ExternalPlaylistDTO.class);
        }

        String playlistId = redisService.get(trackStyle.name());

        if (StringUtils.isEmpty(playlistId))
            throw new BusinessException(ExceptionMessages.PLAYLIST_ID_NOT_FOUND_IN_CACHE);

        ExternalPlaylistDTO externalPlaylistDTO = spotify4PartyIntegrationService.findPlaylistById(playlistId);

        redisService.put(redisConfig.getPlaylistKey().concat(trackStyle.name()), gson.toJson(externalPlaylistDTO));

        return externalPlaylistDTO;
    }

    public PlaylistDTO suggestDefaultPlaylist(PlaylistFilter playlistFilter) throws BusinessException {
        return PlaylistBuilder.buildPlaylist();
    }
}