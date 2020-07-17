package br.com.contmatic.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = HorarioSaidaValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface HorarioSaida {
    
    String message() default "Coloque um horário de saída entre 08:00:00 e 20:00:00";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
