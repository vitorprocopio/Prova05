package br.com.contmatic.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

// TODO: Auto-generated Javadoc
/**
 * The Interface HorarioEntrada.
 */
@Documented
@Constraint(validatedBy = HorarioEntradaValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface HorarioEntrada {
    
    /**
     * Message.
     *
     * @return the string
     */
    String message() default "Coloque um horário de entrada entre 07:00:00 e 18:00:00";
    
    /**
     * Groups.
     *
     * @return the class[]
     */
    Class<?>[] groups() default {};
    
    /**
     * Payload.
     *
     * @return the class<? extends payload>[]
     */
    Class<? extends Payload>[] payload() default {};

}
