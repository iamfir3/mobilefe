package com.mobilebe.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {ApiException.class})
    public ResponseEntity<Object> exception(ApiException apiException, WebRequest webRequest){
        return new ResponseEntity<>(apiException.getMessage(),new HttpHeaders(),apiException.getStatus());

    }
}
