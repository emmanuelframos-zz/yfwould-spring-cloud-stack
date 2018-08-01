package com.goodweather4party.api.dto;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Objects;

public class PlaylistFilterDTO implements Serializable {

    public String cityName;

    public Integer latitude;

    public Integer longitude;

    public boolean hasCityName(){
        return !StringUtils.isEmpty(this.cityName);
    }

    public boolean hasLatitude(){
        return !Objects.isNull(this.latitude);
    }

    public boolean hasLongitude(){
        return !Objects.isNull(this.longitude);
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }
}