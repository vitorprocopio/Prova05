package br.com.contmatic.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.joda.time.LocalTime;

public class HorarioEntradaValidator implements ConstraintValidator<HorarioEntrada, LocalTime> {

    public boolean isValid(LocalTime horario, ConstraintValidatorContext cvc) {
        if (horario != null && (horario.isBefore(new LocalTime(07, 00, 00)) || horario.isAfter(new LocalTime(18, 00, 00)))) {
            return false;
        }
        return true;
    }
}

