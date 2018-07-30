package com.goodweather.api.parser;

import com.goodweather.api.dto.WeatherDTO;
import com.goodweather.integration.dto.weather.OpenWeatherDTO;
import org.springframework.stereotype.Component;

@Component
public class WeatherParser {

    public WeatherDTO toDomain(OpenWeatherDTO openWeatherDTO) {
        WeatherDTO weatherDTO = new WeatherDTO();
        weatherDTO.temperature = openWeatherDTO.main.temp;
        return weatherDTO;
    }
}
