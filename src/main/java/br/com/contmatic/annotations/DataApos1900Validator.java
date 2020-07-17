package br.com.contmatic.annotations;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.joda.time.LocalDate;

public class DataApos1900Validator implements ConstraintValidator<DataApos1900, LocalDate> {

    public boolean isValid(LocalDate data, ConstraintValidatorContext cvc) {
        if (data != null && data.isBefore(new LocalDate(1900, 1, 1))) {
            return false;
        }
        return true;
    }
}
