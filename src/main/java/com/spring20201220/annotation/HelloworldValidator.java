package com.spring20201220.annotation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HelloworldValidator implements ConstraintValidator<IHelloworldValidator,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        System.out.println("**********value which need to be validated*************" + value + "******************************");
        return value.equals("tony") || value.equals("GreetingNotfoundException") || value.equals("david");
    }

    @Override
    public void initialize(IHelloworldValidator constraintAnnotation) {

    }
}
