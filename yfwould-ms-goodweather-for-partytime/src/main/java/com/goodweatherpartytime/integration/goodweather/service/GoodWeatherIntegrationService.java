package com.goodweatherpartytime.integration.goodweather.service;

import com.goodweatherpartytime.api.dto.PlaylistFilterDTO;
import com.goodweatherpartytime.integration.goodweather.dto.ExternalWeatherDTO;
import com.goodweatherpartytime.integration.goodweather.dto.ExternalWeatherFilterDTO;
import com.goodweatherpartytime.integration.goodweather.parser.ExternalWeatherFilterParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodWeatherIntegrationService {

    @Autowired
    private GoodWeatherClient goodWeatherClient;

    @Autowired
    private ExternalWeatherFilterParser externalWeatherFilterParser;

    public ExternalWeatherDTO findWeather(PlaylistFilterDTO playlistFilterDTO) {
        ExternalWeatherFilterDTO externalWeatherFilterDTO = externalWeatherFilterParser.toExternal(playlistFilterDTO);
        return goodWeatherClient.findWeather(
                externalWeatherFilterDTO.cityName,
                externalWeatherFilterDTO.latitude,
                externalWeatherFilterDTO.longitude
        );
    }
}