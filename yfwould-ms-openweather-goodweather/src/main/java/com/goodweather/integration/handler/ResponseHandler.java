package com.goodweather.integration.handler;

import com.goodweather.exception.ExceptionMessages;
import com.goodweather.exception.TechnicalException;
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