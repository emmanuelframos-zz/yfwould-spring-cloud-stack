package com.goodweather4party.integration.openweather.service;

import com.goodweather4party.api.dto.PlaylistFilter;
import com.goodweather4party.integration.openweather.dto.ExternalWeatherDTO;
import com.goodweather4party.integration.openweather.dto.ExternalWeatherFilterDTO;
import com.goodweather4party.integration.openweather.parser.ExternalWeatherFilterParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenWeather4PartyIntegrationService {

    @Autowired
    private OpenWeather4PartyClient openWeather4PartyClient;

    @Autowired
    private ExternalWeatherFilterParser externalWeatherFilterParser;

    public ExternalWeatherDTO findWeather(PlaylistFilter playlistFilter) {
        ExternalWeatherFilterDTO externalWeatherFilterDTO = externalWeatherFilterParser.toExternal(playlistFilter);
        return openWeather4PartyClient.findWeather(
                externalWeatherFilterDTO.cityName,
                externalWeatherFilterDTO.latitude,
                externalWeatherFilterDTO.longitude
        );
    }
}