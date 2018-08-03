package com.spotify4party.exception;

public enum ExceptionMessages {

    GENERIC("An error ocurred"),
    ACCESS_TOKEN_EMPTY("Access token is empty"),
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