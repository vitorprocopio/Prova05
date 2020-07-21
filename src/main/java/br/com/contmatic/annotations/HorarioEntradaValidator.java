package br.com.contmatic.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.joda.time.LocalTime;

import com.google.common.base.Optional;

// TODO: Auto-generated Javadoc
/**
 * The Class HorarioEntradaValidator.
 */
public class HorarioEntradaValidator implements ConstraintValidator<HorarioEntrada, LocalTime> {

    /**
     * Checks if is valid.
     *
     * @param horario the horario
     * @param cvc the cvc
     * @return true, if is valid
     */
    public boolean isValid(LocalTime horario, ConstraintValidatorContext cvc) {
        Optional<LocalTime> optHorario = Optional.fromNullable(horario);
        return !(optHorario.or(LocalTime.now()).isBefore(new LocalTime(07, 00, 00)) || optHorario.or(LocalTime.now()).isAfter(new LocalTime(18, 00, 00)));
    }

//    public boolean isValid(LocalTime horario, ConstraintValidatorContext cvc) {
//        if (horario != null && (horario.isBefore(new LocalTime(07, 00, 00)) || horario.isAfter(new LocalTime(18, 00, 00)))) {
//            return false;
//        }
//        return true;
//    }
}

