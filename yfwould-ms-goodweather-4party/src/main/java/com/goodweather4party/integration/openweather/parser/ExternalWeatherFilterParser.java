package com.goodweather4party.integration.openweather.parser;

import com.goodweather4party.api.dto.PlaylistFilter;
import com.goodweather4party.integration.openweather.dto.ExternalWeatherFilterDTO;
import org.springframework.stereotype.Component;

@Component
public class ExternalWeatherFilterParser {

    public ExternalWeatherFilterDTO toExternal(PlaylistFilter playlistFilter){
        ExternalWeatherFilterDTO externalFilter = new ExternalWeatherFilterDTO();
        externalFilter.cityName = playlistFilter.getCityName();
        externalFilter.latitude = playlistFilter.getLatitude();
        externalFilter.longitude = playlistFilter.getLongitude();
        return externalFilter;
    }
}
