package com.spring20201220.config;

import com.spring20201220.exception.GreetingNotfoundException;
import com.spring20201220.model.Exception404Msg;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(value = { GreetingNotfoundException.class })
    public ResponseEntity<Exception404Msg> requestNotAvairable(HttpServletRequest request , Exception ex){
//        return new Exception404Msg(404,"Not Found");
        return new ResponseEntity<Exception404Msg>(
                new Exception404Msg(404,"Not Found"), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
