package com.goodweather4party.service;

import com.goodweather4party.api.dto.PlaylistDTO;
import com.goodweather4party.api.dto.PlaylistFilterDTO;
import com.goodweather4party.api.parser.PlaylistParser;
import com.goodweather4party.api.validator.PlaylistFilterValidator;
import com.goodweather4party.integration.openweather.dto.ExternalWeatherDTO;
import com.goodweather4party.integration.openweather.service.OpenWeather4PartyIntegrationService;
import com.goodweather4party.integration.spotify.dto.ExternalPlaylistDTO;
import com.goodweather4party.integration.spotify.service.Spotify4PartyIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodWeatherPartyTimeService {

    @Autowired
    private OpenWeather4PartyIntegrationService openWeather4PartyIntegrationService;

    @Autowired
    private Spotify4PartyIntegrationService spotify4PartyIntegrationService;

    @Autowired
    private PlaylistSelectorService playlistSelectorService;

    @Autowired
    private PlaylistFilterValidator playlistFilterValidator;

    @Autowired
    private PlaylistParser playlistParser;

    public PlaylistDTO suggestPlaylist(PlaylistFilterDTO playlistFilterDTO) {

        playlistFilterValidator.validate(playlistFilterDTO);

        ExternalWeatherDTO externalWeatherDTO = this.openWeather4PartyIntegrationService.findWeather(playlistFilterDTO);

        String playlistId = playlistSelectorService.selectPlaylist(externalWeatherDTO.temperature);

        ExternalPlaylistDTO externalPlaylistDTO = spotify4PartyIntegrationService.findPlaylistById("75xCstiSIcVdmbsxLoC92t");

        return playlistParser.toDomain(externalPlaylistDTO);
    }
}