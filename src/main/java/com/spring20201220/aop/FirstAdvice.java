package com.spring20201220.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FirstAdvice {
    @Before("greeting()")
    public void adviceGreeting(){
        System.out.println("#######################Executing Advice on HelloworldAPI.greeting(String)#######################");
    }

    @Pointcut("execution(public com.spring20201220.model.GreetingWord com.spring20201220.controller.HelloworldAPI.greeting(String))")
    public void greeting(){}
}
