package com.openweather4party.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenWeaterConfig {

    @Value("${openweather.url}")
    private String url;

    @Value("${openweather.params.apikeyKey}")
    private String apikeyKey;

    @Value("${openweather.params.apikeyValue}")
    private String apikeyValue;

    @Value("${openweather.params.temperatureUnityKey}")
    private String temperatureUnityKey;

    @Value("${openweather.params.temperatureUnityValue}")
    private String temperatureUnityValue;

    @Value("${openweather.params.latKey}")
    private String latitudeKey;

    @Value("${openweather.params.longKey}")
    private String longitudeKey;

    @Value("${openweather.params.cityKey}")
    private String cityKey;

    @Value("${openweather.services.weather}")
    private String weatherService;

    @Value("${openweather.defaultTemperature}")
    private Integer defaultTemperature;

    public String getUrl() {
        return url;
    }

    public String getApikeyKey() {
        return apikeyKey;
    }

    public String getApikeyValue() {
        return apikeyValue;
    }

    public String getTemperatureUnityKey() {
        return temperatureUnityKey;
    }

    public String getTemperatureUnityValue() {
        return temperatureUnityValue;
    }

    public String getLatitudeKey() {
        return latitudeKey;
    }

    public String getLongitudeKey() {
        return longitudeKey;
    }

    public String getCityKey() {
        return cityKey;
    }

    public String getWeatherService() {
        return weatherService;
    }

    public Integer getDefaultTemperature() {
        return defaultTemperature;
    }
}