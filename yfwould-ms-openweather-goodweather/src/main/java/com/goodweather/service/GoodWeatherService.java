package com.goodweather.service;

import com.goodweather.api.builder.WeatherSearchParamsBuilder;
import com.goodweather.api.dto.WeatherDTO;
import com.goodweather.api.dto.WeatherFilterDTO;
import com.goodweather.api.parser.WeatherParser;
import com.goodweather.api.validator.WeatherFilterValidator;
import com.goodweather.exception.BusinessException;
import com.goodweather.integration.dto.weather.OpenWeatherDTO;
import com.goodweather.integration.service.OpenWeatherIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GoodWeatherService {

    @Autowired
    private OpenWeatherIntegrationService openWeatherIntegrationService;

    @Autowired
    private WeatherParser weatherParser;

    @Autowired
    private WeatherFilterValidator weatherFilterValidator;

    @Autowired
    private WeatherSearchParamsBuilder weatherSearchParamsBuilder;

    public WeatherDTO findWeather(WeatherFilterDTO weatherFilterDTO) throws BusinessException {

        weatherFilterValidator.validate(weatherFilterDTO);

        Map<String, String> params = weatherSearchParamsBuilder.buildParams(weatherFilterDTO);

        OpenWeatherDTO weatherDTO = openWeatherIntegrationService.findWeather(params);

        return weatherParser.toDomain(weatherDTO);
    }
}