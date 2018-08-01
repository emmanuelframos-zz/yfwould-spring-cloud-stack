package com.partytime.exception;

import com.partytime.api.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<ErrorDTO> handleBusinessException(BusinessException ex) {
        return new ResponseEntity<>(
                ErrorDTO.build().message(ex.getExceptionMessage().getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({TechnicalException.class})
    public ResponseEntity handleTechnicalException(TechnicalException ex) {
        return new ResponseEntity<>(ErrorDTO.build().message(ex.getExceptionMessage().getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity handleGenericException(Exception ex) {
        return new ResponseEntity<>(ExceptionMessages.GENERAL.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}