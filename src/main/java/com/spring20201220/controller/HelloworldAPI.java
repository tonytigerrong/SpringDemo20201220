package com.spring20201220.controller;

import com.spring20201220.annotation.IHelloworldValidator;
import com.spring20201220.model.EmailRegisterForm;
import com.spring20201220.model.GreetingWord;
import com.spring20201220.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
public class HelloworldAPI {

    @Autowired
    GreetingService greetingService;

    @RequestMapping(value = "/greeting", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public GreetingWord greeting(@RequestParam("name") @IHelloworldValidator String name
                                 ){
        return greetingService.getGreetingWord(name);
    }

    @RequestMapping(value = "/email", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public EmailRegisterForm emailCombinationValidation(@RequestBody @Valid EmailRegisterForm emailRegisterForm){
        return emailRegisterForm;
    }


}
