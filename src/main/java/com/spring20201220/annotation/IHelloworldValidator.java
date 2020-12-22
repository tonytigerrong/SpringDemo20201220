package com.spring20201220.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = HelloworldValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface IHelloworldValidator {
    String message() default "Invalid Helloworld message";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
