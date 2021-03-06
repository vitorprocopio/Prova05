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
 * The Interface HorarioSaida.
 */
@Documented
@Constraint(validatedBy = HorarioSaidaValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface HorarioSaida {
    
    /**
     * Message.
     *
     * @return the string
     */
    String message() default "Coloque um horário de saída entre 08:00:00 e 20:00:00";
    
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
