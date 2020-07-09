package br.com.contmatic.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = DataApos1900Validator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface DataApos1900 {
    
    String message() default "Insira uma data a partir de 01/01/1900";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
