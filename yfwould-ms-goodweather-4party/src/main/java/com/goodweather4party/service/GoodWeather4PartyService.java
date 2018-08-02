package com.goodweather4party.service;

import com.goodweather4party.api.dto.PlaylistDTO;
import com.goodweather4party.api.dto.PlaylistFilterDTO;
import com.goodweather4party.api.parser.PlaylistParser;
import com.goodweather4party.api.validator.PlaylistFilterValidator;
import com.goodweather4party.config.RedisConfig;
import com.goodweather4party.domain.TrackStyles;
import com.goodweather4party.exception.BusinessException;
import com.goodweather4party.integration.openweather.dto.ExternalWeatherDTO;
import com.goodweather4party.integration.openweather.service.OpenWeather4PartyIntegrationService;
import com.goodweather4party.integration.redis.service.RedisService;
import com.goodweather4party.integration.spotify.dto.ExternalPlaylistDTO;
import com.goodweather4party.integration.spotify.service.Spotify4PartyIntegrationService;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodWeather4PartyService {

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

    public PlaylistDTO suggestPlaylist(PlaylistFilterDTO playlistFilterDTO) throws BusinessException {

        playlistFilterValidator.validate(playlistFilterDTO);

        ExternalWeatherDTO externalWeatherDTO = this.openWeather4PartyIntegrationService.findWeather(playlistFilterDTO);

        TrackStyles trackStyle = trackStyleSelector.selectPlaylist(externalWeatherDTO.temperature);

        ExternalPlaylistDTO externalPlaylistDTO = this.getPLaylist(trackStyle);

        return playlistParser.toDomain(externalPlaylistDTO);
    }

    private ExternalPlaylistDTO getPLaylist(TrackStyles trackStyle){

        String playlistInCache = redisService.get(redisConfig.getPlaylistKey().concat(trackStyle.name()));

        if (!StringUtils.isEmpty(playlistInCache)){
            return gson.fromJson(playlistInCache, ExternalPlaylistDTO.class);
        }

        String playlistId = redisService.get(trackStyle.name());

        ExternalPlaylistDTO externalPlaylistDTO = spotify4PartyIntegrationService.findPlaylistById(playlistId);

        redisService.put(redisConfig.getPlaylistKey().concat(trackStyle.name()), gson.toJson(externalPlaylistDTO));

        return externalPlaylistDTO;
    }
}