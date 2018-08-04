package com.goodweather4party.exception;

public enum ExceptionMessages {

    GENERIC("An error ocurred"),
    INVALID_PARAMS("You must send params: cityName or latitude and longitude "),
    ONLY_CITY_NAME("When you send city name, latitude or longitude should not be sent"),
    MISS_LATITUDE("When you send longitude, latitude should be sent"),
    MISS_LONGITUDE("When you send latitude, longitude should be sent"),
    INVALID_WEATHER("Invalid weather"),
    INVALID_PLAYLIST("Invalid playlist"),
    INVALID_TRACKS("Invalid tracks"),
    INVALID_ARTIST("Invalid artist"),
    INVALID_TRACK_NAME("Invalid track name"),
    PLAYLIST_ID_NOT_FOUND_IN_CACHE("PLaylist id not found in cache");

    private String message;

    ExceptionMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}