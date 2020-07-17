package br.com.contmatic.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = HorarioEntradaValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface HorarioEntrada {
    
    String message() default "Coloque um horário de entrada entre 07:00:00 e 18:00:00";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
