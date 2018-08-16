package com.goodweather4party.api.dto;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class PlaylistFilter {

    private String cityName;

    private Integer latitude;

    private Integer longitude;

    private PlaylistFilter(){}

    public static PlaylistFilter build(){
        return new PlaylistFilter();
    }

    public boolean hasCityName(){
        return !StringUtils.isEmpty(this.cityName);
    }

    public boolean hasLatitude(){
        return !Objects.isNull(this.latitude);
    }

    public boolean hasLongitude(){
        return !Objects.isNull(this.longitude);
    }

    public boolean hasLatitudeAndLogitude(){
        return this.hasLatitude() && this.hasLongitude();
    }

    public boolean hasNoParams(){
        return !this.hasLatitude() && !this.hasLongitude() && !this.hasCityName();
    }

    public PlaylistFilter cityName(String cityName){
        this.cityName = cityName;
        return this;
    }

    public PlaylistFilter latitude(Integer latitude){
        this.latitude = latitude;
        return this;
    }

    public PlaylistFilter longitude(Integer longitude){
        this.longitude = longitude;
        return this;
    }

    public String getCityName() {
        return cityName;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public String toString(){
        return String.format("CityName=%s, Latitude=%d, Longitude=%d", cityName, latitude, longitude);
    }
}