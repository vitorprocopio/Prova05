package br.com.contmatic.empresa;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class ValidaCliente.
 */
public class ValidaCliente {

    /**
     * Procura erro.
     *
     * @param cliente the cliente
     * @param mensagemProcurada the mensagem procurada
     * @return true, if successful
     */
    public static boolean ProcuraErro(Cliente cliente, String mensagemProcurada) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Cliente>> violacoes = validator.validate(cliente);
        for(ConstraintViolation<Cliente> constraintViolation : violacoes) {
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
     * @param cliente the cliente
     * @return true, if successful
     */
    public static boolean valida(Cliente cliente) {
        System.out.println(cliente);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Cliente>> violacoes = validator.validate(cliente);
        for(ConstraintViolation<Cliente> constraintViolation : violacoes) {
            System.out.println(constraintViolation.getMessage());
            return false;
        }
        return true;
    }

}
