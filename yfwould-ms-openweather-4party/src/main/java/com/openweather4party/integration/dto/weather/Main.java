
package com.openweather4party.integration.dto.weather;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Main implements Serializable {

    @JsonProperty("temp")
    public Integer temp;

    @JsonProperty("pressure")
    public Integer pressure;

    @JsonProperty("humidity")
    public Integer humidity;

    @JsonProperty("temp_min")
    public Integer tempMin;

    @JsonProperty("temp_max")
    public Integer tempMax;

}