package com.goodweather4party.api.parser;

import com.goodweather4party.api.dto.WeatherDTO;
import com.goodweather4party.integration.dto.weather.OpenWeatherDTO;
import org.springframework.stereotype.Component;

@Component
public class WeatherParser {

    public WeatherDTO toDomain(OpenWeatherDTO openWeatherDTO) {
        WeatherDTO weatherDTO = new WeatherDTO();
        weatherDTO.temperature = openWeatherDTO.main.temp;
        return weatherDTO;
    }
}
