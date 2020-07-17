package br.com.contmatic.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.joda.time.LocalTime;

public class HorarioSaidaValidator implements ConstraintValidator<HorarioSaida, LocalTime> {

    public boolean isValid(LocalTime horario, ConstraintValidatorContext cvc) {
        if (horario != null && (horario.isBefore(new LocalTime(8, 00, 00)) || horario.isAfter(new LocalTime(20, 00, 00)))) {
            return false;
        }
        return true;
    }

}
