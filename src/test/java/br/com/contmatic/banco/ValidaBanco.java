package br.com.contmatic.banco;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import br.com.contmatic.annotations.Post;
import br.com.contmatic.annotations.Put;

// TODO: Auto-generated Javadoc
/**
 * The Class ValidaBanco.
 */
public class ValidaBanco {

    /**
     * Procura erro.
     *
     * @param conta the conta
     * @param mensagemProcurada the mensagem procurada
     * @return true, if successful
     */
    public static boolean ProcuraErro(ContaBancaria conta, String mensagemProcurada) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ContaBancaria>> violacoes = validator.validate(conta);
        for(ConstraintViolation<ContaBancaria> constraintViolation : violacoes) {
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
     * @param conta the conta
     * @return true, if successful
     */
    public static boolean valida(ContaBancaria conta) {
        System.out.println(conta);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ContaBancaria>> violacoes = validator.validate(conta, Post.class, Put.class);
        for(ConstraintViolation<ContaBancaria> constraintViolation : violacoes) {
            System.out.println(constraintViolation.getMessage());
            return false;
        }
        return true;
    }

}
