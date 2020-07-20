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
 * The Interface HorarioSaidaAlmoco.
 */
@Documented
@Constraint(validatedBy = HorarioSaidaAlmocoValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface HorarioSaidaAlmoco {
    
    /**
     * Message.
     *
     * @return the string
     */
    String message() default "Coloque um horário de saido do almoço entre 11:00:00 e 14:00:00";
    
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