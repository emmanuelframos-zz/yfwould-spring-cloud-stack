package com.openweather4party.integration;

import com.openweather4party.Application;
import com.openweather4party.api.OpenWeather4PartyAPI;
import com.openweather4party.api.dto.WeatherFilterDTO;
import com.openweather4party.exception.BusinessException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class OpenWeather4PartyAPITest {

    @Autowired
    private OpenWeather4PartyAPI openWeather4PartyAPI;

    @Test
    public void testFindWeatherCityNameOK() throws BusinessException {

        WeatherFilterDTO weatherFilterDTO = new WeatherFilterDTO();
        weatherFilterDTO.cityName = "Curitiba";

        openWeather4PartyAPI.findWeather(weatherFilterDTO);

    }

    @Test
    public void testFindWeatherLatLongNameOK() throws BusinessException {

        WeatherFilterDTO weatherFilterDTO = new WeatherFilterDTO();
        weatherFilterDTO.latitude = 500;
        weatherFilterDTO.longitude = 500;

        openWeather4PartyAPI.findWeather(weatherFilterDTO);

    }
}