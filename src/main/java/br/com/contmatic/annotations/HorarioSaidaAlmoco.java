package br.com.contmatic.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = HorarioSaidaAlmocoValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface HorarioSaidaAlmoco {
    
    String message() default "Coloque um horário de saido do almoço entre 11:00:00 e 14:00:00";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}