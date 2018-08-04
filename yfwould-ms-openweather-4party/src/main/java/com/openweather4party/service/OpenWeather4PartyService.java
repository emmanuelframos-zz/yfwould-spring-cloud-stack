package com.openweather4party.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.openweather4party.api.builder.WeatherSearchParamsBuilder;
import com.openweather4party.api.dto.WeatherDTO;
import com.openweather4party.api.dto.WeatherFilterDTO;
import com.openweather4party.api.parser.WeatherParser;
import com.openweather4party.api.validator.WeatherFilterValidator;
import com.openweather4party.config.OpenWeaterConfig;
import com.openweather4party.exception.BusinessException;
import com.openweather4party.integration.dto.weather.OpenWeatherDTO;
import com.openweather4party.integration.service.OpenWeatherIntegrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OpenWeather4PartyService {

    private static final Logger logger = LoggerFactory.getLogger(OpenWeather4PartyService.class);

    @Autowired
    private OpenWeatherIntegrationService openWeatherIntegrationService;

    @Autowired
    private WeatherParser weatherParser;

    @Autowired
    private WeatherFilterValidator weatherFilterValidator;

    @Autowired
    private WeatherSearchParamsBuilder weatherSearchParamsBuilder;

    @Autowired
    private OpenWeaterConfig openWeaterConfig;

    @HystrixCommand(commandKey = "fallback_weather", fallbackMethod = "findDefaultWeather")
    public WeatherDTO findWeather(WeatherFilterDTO weatherFilterDTO) throws BusinessException {

        logger.info("Validating weather filter {}.", weatherFilterDTO);

        weatherFilterValidator.validate(weatherFilterDTO);

        logger.info("Building search params for filter {}.", weatherFilterDTO);

        Map<String, String> params = weatherSearchParamsBuilder.buildParams(weatherFilterDTO);

        logger.info("Searching weather on Open Weather with filter {}.", weatherFilterDTO);

        OpenWeatherDTO weatherDTO = openWeatherIntegrationService.findWeather(params);

        logger.info("Converting  weather to domain.");

        return weatherParser.toDomain(weatherDTO);
    }

    private WeatherDTO findDefaultWeather(WeatherFilterDTO weatherFilterDTO) throws BusinessException {

        logger.info("Getting default weather.");

        WeatherDTO weatherDTO = new WeatherDTO();
        weatherDTO.temperature = openWeaterConfig.getDefaultTemperature();

        return weatherDTO;
    }
}