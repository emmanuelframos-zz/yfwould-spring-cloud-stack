package com.goodweather.api.builder;

import com.goodweather.api.dto.WeatherFilterDTO;
import com.goodweather.config.OpenWeaterConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WeatherSearchParamsBuilder {

    @Autowired
    private OpenWeaterConfig openWeaterConfig;

    public Map<String, String> buildParams(WeatherFilterDTO weatherFilterDTO){

        Map<String, String> params = new HashMap<>();

        if (weatherFilterDTO.hasCityName()){
            params.put(openWeaterConfig.getCityKey(), weatherFilterDTO.cityName);
        }

        if (weatherFilterDTO.hasLatitude()){
            params.put(openWeaterConfig.getLatitudeKey(), weatherFilterDTO.latitude.toString());
        }

        if (weatherFilterDTO.hasLongitude()){
            params.put(openWeaterConfig.getLongitudeKey(), weatherFilterDTO.longitude.toString());
        }

        return params;
    }
}