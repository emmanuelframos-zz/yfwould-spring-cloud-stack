package com.partytime.exception;

public enum ExceptionMessages {

    GENERAL("An error ocurred"),
    /** Always there, sure.**/
    ERROR_ON_SPOTIFY("Error on spotify"),
    INVALID_PLAYLIST_ID("Invalid playlist id");

    private String message;

    ExceptionMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}