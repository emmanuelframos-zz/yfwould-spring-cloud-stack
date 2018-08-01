package com.partytime.exception;

public class BusinessException extends Exception {

    private ExceptionMessages exceptionMessage;

    public BusinessException(ExceptionMessages exceptionMessage){
        super(exceptionMessage.getMessage());
        this.exceptionMessage = exceptionMessage;
    }

    public ExceptionMessages getExceptionMessage(){
        return this.exceptionMessage;
    }
}