package com.goodweatherpartytime.service;

import com.goodweatherpartytime.api.dto.PlaylistDTO;
import com.goodweatherpartytime.api.dto.PlaylistFilterDTO;
import com.goodweatherpartytime.api.parser.PlaylistParser;
import com.goodweatherpartytime.api.validator.PlaylistFilterValidator;
import com.goodweatherpartytime.integration.goodweather.dto.ExternalWeatherDTO;
import com.goodweatherpartytime.integration.goodweather.service.GoodWeatherIntegrationService;
import com.goodweatherpartytime.integration.partytime.dto.ExternalPlaylistDTO;
import com.goodweatherpartytime.integration.partytime.service.PartyTimeIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodWeatherPartyTimeService {

    @Autowired
    private GoodWeatherIntegrationService goodWeatherIntegrationService;

    @Autowired
    private PartyTimeIntegrationService partyTimeIntegrationService;

    @Autowired
    private PlaylistSelectorService playlistSelectorService;

    @Autowired
    private PlaylistFilterValidator playlistFilterValidator;

    @Autowired
    private PlaylistParser playlistParser;

    public PlaylistDTO suggestPlaylist(PlaylistFilterDTO playlistFilterDTO) {

        playlistFilterValidator.validate(playlistFilterDTO);

        ExternalWeatherDTO externalWeatherDTO = this.goodWeatherIntegrationService.findWeather(playlistFilterDTO);

        String playlistId = playlistSelectorService.selectPlaylist(externalWeatherDTO.temperature);

        ExternalPlaylistDTO externalPlaylistDTO = partyTimeIntegrationService.findPlaylistById("75xCstiSIcVdmbsxLoC92t");

        return playlistParser.toDomain(externalPlaylistDTO);
    }
}