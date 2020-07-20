package br.com.contmatic.empresa;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class ValidaFuncionario.
 */
public class ValidaFuncionario {
    
    /**
     * Procura erro.
     *
     * @param funcionario the funcionario
     * @param mensagemProcurada the mensagem procurada
     * @return true, if successful
     */
    public static boolean ProcuraErro(Funcionario funcionario, String mensagemProcurada) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Funcionario>> violacoes = validator.validate(funcionario);
        for(ConstraintViolation<Funcionario> constraintViolation : violacoes) {
            String mensagemErro = constraintViolation.getMessage();
            if (mensagemErro.equals(mensagemProcurada)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Valida.
     *
     * @param funcionario the funcionario
     * @return true, if successful
     */
    public static boolean valida(Funcionario funcionario) {
        System.out.println(funcionario);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Funcionario>> violacoes = validator.validate(funcionario);
        for(ConstraintViolation<Funcionario> constraintViolation : violacoes) {
            System.out.println(constraintViolation.getMessage());
            return false;
        }
        return true;
    }

}
