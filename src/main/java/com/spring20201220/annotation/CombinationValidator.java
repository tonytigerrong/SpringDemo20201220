package com.spring20201220.annotation;

import com.spring20201220.model.EmailRegisterForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CombinationValidator implements ConstraintValidator<ICombinationValidator, EmailRegisterForm> {
    private String field;
    private String fieldMatch;

    @Override
    public boolean isValid(EmailRegisterForm value, ConstraintValidatorContext context) {
        System.out.println("$$$$$$$$$$$$$$$$$ Value need to be validated"+value.getEmail()+"   $$$   "+value.getEmailConfirm());
        boolean result = false;
        if(value.getEmail().equals(value.getEmailConfirm())){
            result = true;
        }else{

        }
        return result;
    }

    @Override
    public void initialize(ICombinationValidator constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }
}
