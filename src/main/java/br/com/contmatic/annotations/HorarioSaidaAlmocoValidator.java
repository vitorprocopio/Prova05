package br.com.contmatic.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.joda.time.LocalTime;

public class HorarioSaidaAlmocoValidator implements ConstraintValidator<HorarioSaidaAlmoco, LocalTime> {

    public boolean isValid(LocalTime horario, ConstraintValidatorContext cvc) {
        if (horario != null && (horario.isBefore(new LocalTime(11, 00, 00)) || horario.isAfter(new LocalTime(14, 00, 00)))) {
            return false;
        }
        return true;
    }

}
