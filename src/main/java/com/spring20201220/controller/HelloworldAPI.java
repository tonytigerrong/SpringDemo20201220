package com.spring20201220.controller;

import com.spring20201220.model.GreetingWord;
import com.spring20201220.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldAPI {

    @Autowired
    GreetingService greetingService;

    @RequestMapping(value = "/greeting", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public GreetingWord greeting(@RequestParam("name") String name){
        return greetingService.getGreetingWord(name);
    }


}
