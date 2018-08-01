package com.goodweather.api;

import com.goodweather.api.dto.WeatherDTO;
import com.goodweather.api.dto.WeatherFilterDTO;
import com.goodweather.exception.BusinessException;
import com.goodweather.service.GoodWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GoodWeatherAPI {

    @Autowired
    private GoodWeatherService goodWeatherService;

    @GetMapping("/weather")
    public WeatherDTO findWeather(WeatherFilterDTO weatherFilterDTO) throws BusinessException {
        return goodWeatherService.findWeather(weatherFilterDTO);
    }
}