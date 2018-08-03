package com.openweather4party.api;

import com.openweather4party.api.dto.WeatherDTO;
import com.openweather4party.api.dto.WeatherFilterDTO;
import com.openweather4party.exception.BusinessException;
import com.openweather4party.service.OpenWeather4PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OpenWeather4PartyAPI {

    @Autowired
    private OpenWeather4PartyService openWeather4PartyService;

    @GetMapping("/weather")
    public WeatherDTO findWeather(WeatherFilterDTO weatherFilterDTO) throws BusinessException {
        return openWeather4PartyService.findWeather(weatherFilterDTO);
    }
}