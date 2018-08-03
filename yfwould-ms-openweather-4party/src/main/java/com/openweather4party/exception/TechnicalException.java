package com.openweather4party.exception;

public class TechnicalException extends RuntimeException {

    private ExceptionMessages exceptionMessage;

    public TechnicalException(ExceptionMessages exceptionMessage){
        super(exceptionMessage.getMessage());
        this.exceptionMessage = exceptionMessage;
    }

    public ExceptionMessages getExceptionMessage(){
        return this.exceptionMessage;
    }
}