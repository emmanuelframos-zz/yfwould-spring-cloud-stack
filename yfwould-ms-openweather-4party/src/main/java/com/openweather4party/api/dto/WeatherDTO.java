package com.openweather4party.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherDTO implements Serializable {

    public Integer temperature;

}