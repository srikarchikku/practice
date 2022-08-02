package com.project.springboot.CustomValidation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DateConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DatePattern {

    String message() default "Date format is not Valid(YYYY-MM-DD) ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
