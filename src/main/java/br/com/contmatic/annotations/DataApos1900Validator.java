package br.com.contmatic.annotations;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DataApos1900Validator implements ConstraintValidator<DataApos1900, LocalDate> {

    public boolean isValid(LocalDate data, ConstraintValidatorContext cvc) {
        if (data != null && data.isBefore(LocalDate.of(1900, 1, 1))) {
            return false;
        }
        return true;
    }
}
