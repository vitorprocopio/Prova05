package br.com.contmatic.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.joda.time.LocalTime;

public class HorarioRetornoAlmocoValidator implements ConstraintValidator<HorarioRetornoAlmoco, LocalTime> {

    public boolean isValid(LocalTime horario, ConstraintValidatorContext cvc) {
        if (horario != null && (horario.isBefore(new LocalTime(12, 00, 00)) || horario.isAfter(new LocalTime(15, 00, 00)))) {
            return false;
        }
        return true;
    }

}
