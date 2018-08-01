package com.goodweather4party.integration.openweather.parser;

import com.goodweather4party.api.dto.PlaylistFilterDTO;
import com.goodweather4party.integration.openweather.dto.ExternalWeatherFilterDTO;
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
