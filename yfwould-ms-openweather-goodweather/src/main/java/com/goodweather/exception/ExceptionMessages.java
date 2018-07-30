package com.goodweather.exception;

public enum ExceptionMessages {

    GENERAL("An error ocurred");

    private String message;

    ExceptionMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}