
package com.openweather4party.integration.dto.weather;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenWeatherDTO implements Serializable {

    @JsonProperty("main")
    public Main main;

}
