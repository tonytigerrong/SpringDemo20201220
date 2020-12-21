package com.spring20201220.controller;

import com.spring20201220.exception.GreetingNotfoundException;
import com.spring20201220.model.Exception404Msg;
import com.spring20201220.model.GreetingWord;
import com.spring20201220.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloworldAPI {

    @Autowired
    GreetingService greetingService;

    @RequestMapping(value = "/greeting", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public GreetingWord greeting(@RequestParam("name") String name){
        return greetingService.getGreetingWord(name);
    }

    @ExceptionHandler(value = { GreetingNotfoundException.class })
    public ResponseEntity<Exception404Msg> requestNotAvairable(HttpServletRequest request , Exception ex){
//        return new Exception404Msg(404,"Not Found");
        return new ResponseEntity<Exception404Msg>(
                new Exception404Msg(404,"Not Found"), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
