package com.spotify4party.integration.handler;

import com.spotify4party.exception.ExceptionMessages;
import com.spotify4party.exception.TechnicalException;
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