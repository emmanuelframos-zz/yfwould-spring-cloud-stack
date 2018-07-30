package com.goodweatherpartytime.integration.goodweather.parser;

import com.goodweatherpartytime.api.dto.PlaylistFilterDTO;
import com.goodweatherpartytime.integration.goodweather.dto.ExternalWeatherFilterDTO;
import org.springframework.stereotype.Component;

@Component
public class ExternalWeatherFilterParser {

    public ExternalWeatherFilterDTO toExternal(PlaylistFilterDTO playlistFilterDTO){
        ExternalWeatherFilterDTO externalFilter = new ExternalWeatherFilterDTO();
        externalFilter.cityName = playlistFilterDTO.cityName;
        externalFilter.latitude = playlistFilterDTO.latitude;
        externalFilter.longitude = playlistFilterDTO.longitude;
        return externalFilter;
    }
}
