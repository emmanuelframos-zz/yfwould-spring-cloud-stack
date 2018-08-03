package com.openweather4party.integration.handler;

import com.openweather4party.exception.ExceptionMessages;
import com.openweather4party.exception.TechnicalException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseHandler {

    public <T> T handleResponse(ResponseEntity<T> response){
        if (!response.getStatusCode().is2xxSuccessful())
            throw new TechnicalException(ExceptionMessages.ERROR_ON_OPEN_WEATHER);

        return response.getBody();
    }
}