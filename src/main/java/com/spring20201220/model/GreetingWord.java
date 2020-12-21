package com.spring20201220.model;


public class GreetingWord {
   private String greetingStart = "Hello ";
   private String name;

    public String getGreetingStart() {
        return greetingStart;
    }

    public void setGreetingStart(String greetingStart) {
        this.greetingStart = greetingStart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GreetingWord(String greetingStart, String name) {
        this.greetingStart = greetingStart;
        this.name = name;
    }
}
