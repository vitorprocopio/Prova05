package br.com.contmatic.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.joda.time.LocalTime;

import com.google.common.base.Optional;

// TODO: Auto-generated Javadoc
/**
 * The Class HorarioRetornoAlmocoValidator.
 */
public class HorarioRetornoAlmocoValidator implements ConstraintValidator<HorarioRetornoAlmoco, LocalTime> {

    /**
     * Checks if is valid.
     *
     * @param horario the horario
     * @param cvc the cvc
     * @return true, if is valid
     */
    public boolean isValid(LocalTime horario, ConstraintValidatorContext cvc) {
        Optional<LocalTime> optHorario = Optional.fromNullable(horario);
        return !(optHorario.or(LocalTime.now()).isBefore(new LocalTime(12, 00, 00)) || optHorario.or(LocalTime.now()).isAfter(new LocalTime(15, 00, 00)));
    }

}
