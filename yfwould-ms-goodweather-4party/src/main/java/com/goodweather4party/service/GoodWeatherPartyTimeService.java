package com.goodweather4party.service;

import com.goodweather4party.api.dto.PlaylistDTO;
import com.goodweather4party.api.dto.PlaylistFilterDTO;
import com.goodweather4party.api.parser.PlaylistParser;
import com.goodweather4party.api.validator.PlaylistFilterValidator;
import com.goodweather4party.integration.goodweather.dto.ExternalWeatherDTO;
import com.goodweather4party.integration.goodweather.service.GoodWeatherIntegrationService;
import com.goodweather4party.integration.partytime.dto.ExternalPlaylistDTO;
import com.goodweather4party.integration.partytime.service.PartyTimeIntegrationService;
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