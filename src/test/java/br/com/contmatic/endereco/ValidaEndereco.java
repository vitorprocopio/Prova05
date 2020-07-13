package br.com.contmatic.endereco;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidaEndereco {
    
    public static boolean ProcuraErro(Endereco endereco, String mensagemProcurada) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Endereco>> violacoes = validator.validate(endereco);
        for(ConstraintViolation<Endereco> constraintViolation : violacoes) {
            String mensagemErro = constraintViolation.getMessage();
            if (mensagemErro.equals(mensagemProcurada)) {
                return false;
            }
        }
        return true;
    }

    public static boolean valida(Endereco endereco) {
        System.out.println(endereco);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Endereco>> violacoes = validator.validate(endereco);
        for(ConstraintViolation<Endereco> constraintViolation : violacoes) {
            System.out.println(constraintViolation.getMessage());
            return false;
        }
        return true;
    }

}
