package com.spring20201220.controller;

import com.spring20201220.model.GreetingWord;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/helloworld")
public class HelloworldAPI {
    @RequestMapping(value = "/greeting", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public GreetingWord greeting(@RequestParam("name") String name){

        return new GreetingWord(name,"Hi ");
    }
}
