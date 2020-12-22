package com.spring20201220.config;

import com.spring20201220.exception.GreetingNotfoundException;
import com.spring20201220.model.Exception404Msg;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(value = { GreetingNotfoundException.class })
    public ResponseEntity<Exception404Msg> requestNotAvairable(HttpServletRequest request , Exception ex){
        return new ResponseEntity<Exception404Msg>(
                new Exception404Msg(4004,"Not Found"), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = { ConstraintViolationException.class })
    public ResponseEntity<Exception404Msg> validationError(HttpServletRequest request, Exception ex){
        return new ResponseEntity<>( new Exception404Msg(4005,"validation error"), new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
    }
}
