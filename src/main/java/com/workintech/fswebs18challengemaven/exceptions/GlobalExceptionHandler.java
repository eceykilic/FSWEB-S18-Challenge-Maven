package com.workintech.fswebs18challengemaven.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    public ResponseEntity<CardErrorResponse> handleException(CardException cardException){
        log.error("");
        CardErrorResponse errorResponse=new CardErrorResponse(cardException.getMessage());
        return new ResponseEntity<>(errorResponse,cardException.getHttpStatus());
    }

    public ResponseEntity<CardErrorResponse> handleException(Exception exception){
        log.error("");
        CardErrorResponse errorResponse=new CardErrorResponse(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}