package com.openweather4party.exception;

public enum ExceptionMessages {

    GENERIC("An error ocurred"),
    ERROR_ON_OPEN_WEATHER("Error on Open Wheater"),
    INVALID_PARAMS("You must send params: cityName or latitude and longitude "),
    ONLY_CITY_NAME("When you send city name, latitude or longitude should not be sent"),
    MISS_LATITUDE("When you send longitude, latitude should be sent"),
    MISS_LONGITUDE("When you send latitude, longitude should be sent");

    private String message;

    ExceptionMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}