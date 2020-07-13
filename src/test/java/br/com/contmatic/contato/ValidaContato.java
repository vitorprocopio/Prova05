package br.com.contmatic.contato;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidaContato {
    
    public static boolean ProcuraErro(Contato contato, String mensagemProcurada) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Contato>> violacoes = validator.validate(contato);
        for(ConstraintViolation<Contato> constraintViolation : violacoes) {
            String mensagemErro = constraintViolation.getMessage();
            if (mensagemErro.equals(mensagemProcurada)) {
                return false;
            }
        }
        return true;
    }

    public static boolean valida(Contato contato) {
        System.out.println(contato);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Contato>> violacoes = validator.validate(contato);
        for(ConstraintViolation<Contato> constraintViolation : violacoes) {
            System.out.println(constraintViolation.getMessage());
            return false;
        }
        return true;
    }

}
