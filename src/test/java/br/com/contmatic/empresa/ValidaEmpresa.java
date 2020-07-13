package br.com.contmatic.empresa;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidaEmpresa {

    public static boolean ProcuraErro(Empresa empresa, String mensagemProcurada) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Empresa>> violacoes = validator.validate(empresa);
        for(ConstraintViolation<Empresa> constraintViolation : violacoes) {
            String mensagemErro = constraintViolation.getMessage();
            if (mensagemErro.equals(mensagemProcurada)) {
                return false;
            }
        }
        return true;
    }

    public static boolean valida(Empresa empresa) {
        System.out.println(empresa);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Empresa>> violacoes = validator.validate(empresa);
        for(ConstraintViolation<Empresa> constraintViolation : violacoes) {
            System.out.println(constraintViolation.getMessage());
            return false;
        }
        return true;
    }
    
}
