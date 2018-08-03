package com.openweather4party.api.parser;

import com.openweather4party.api.dto.WeatherDTO;
import com.openweather4party.integration.dto.weather.OpenWeatherDTO;
import org.springframework.stereotype.Component;

@Component
public class WeatherParser {

    public WeatherDTO toDomain(OpenWeatherDTO openWeatherDTO) {
        WeatherDTO weatherDTO = new WeatherDTO();
        weatherDTO.temperature = openWeatherDTO.main.temp;
        return weatherDTO;
    }
}
