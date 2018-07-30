package com.goodweatherpartytime.integration.goodweather.service;

import com.goodweatherpartytime.integration.goodweather.dto.ExternalWeatherDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="openweather-goodweather")
public interface GoodWeatherClient {

    @GetMapping("/api/v1/weather")
    ExternalWeatherDTO findWeather(@RequestParam("cityName") String cityName,
                                   @RequestParam("latitude") Integer latitude,
                                   @RequestParam("longitude") Integer longitude);

}
