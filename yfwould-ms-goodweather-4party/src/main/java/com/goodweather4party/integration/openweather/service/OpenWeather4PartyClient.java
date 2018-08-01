package com.goodweather4party.integration.openweather.service;

import com.goodweather4party.integration.openweather.dto.ExternalWeatherDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="ms-openweather-4party")
public interface OpenWeather4PartyClient {

    @GetMapping("/api/v1/weather")
    ExternalWeatherDTO findWeather(@RequestParam("cityName") String cityName,
                                   @RequestParam("latitude") Integer latitude,
                                   @RequestParam("longitude") Integer longitude);

}
