package com.goodweather4party.exception;

public enum ExceptionMessages {

    GENERIC("An error ocurred");

    private String message;

    ExceptionMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}