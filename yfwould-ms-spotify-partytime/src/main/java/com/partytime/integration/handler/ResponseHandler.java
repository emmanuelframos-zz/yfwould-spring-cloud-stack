package com.partytime.integration.handler;

import com.partytime.exception.ExceptionMessages;
import com.partytime.exception.TechnicalException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseHandler {

    public <T> T handleResponse(ResponseEntity<T> response){
        if (!response.getStatusCode().is2xxSuccessful())
            throw new TechnicalException(ExceptionMessages.ERROR_ON_SPOTIFY);

        return response.getBody();
    }
}