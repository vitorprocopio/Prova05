package br.com.contmatic.annotations;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.joda.time.LocalDate;

import com.google.common.base.Optional;

// TODO: Auto-generated Javadoc
/**
 * The Class DataApos1900Validator.
 */
public class DataApos1900Validator implements ConstraintValidator<DataApos1900, LocalDate> {

    /**
     * Checks if is valid.
     *
     * @param data the data
     * @param cvc the cvc
     * @return true, if is valid
     */
    public boolean isValid(LocalDate data, ConstraintValidatorContext cvc) {
        Optional<LocalDate> optData = Optional.fromNullable(data);
        return !optData.or(LocalDate.now()).isBefore(new LocalDate(1900, 1, 1));
    }
    
}
