package br.com.contmatic.empresa;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class ValidaEmpresa.
 */
public class ValidaEmpresa {

    /**
     * Procura erro.
     *
     * @param empresa the empresa
     * @param mensagemProcurada the mensagem procurada
     * @return true, if successful
     */
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

    /**
     * Valida.
     *
     * @param empresa the empresa
     * @return true, if successful
     */
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
