package com.spring20201220.service;

import com.spring20201220.exception.GreetingNotfoundException;
import com.spring20201220.model.GreetingWord;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GreetingService {
    public GreetingWord getGreetingWord(String name){
        if(name.equals("tony")){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Foo Not Found", new GreetingNotfoundException("Not found greeting"));
        }else{
            return new GreetingWord("Hi ",name);
        }
    }

}
