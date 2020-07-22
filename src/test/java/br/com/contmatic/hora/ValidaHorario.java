package br.com.contmatic.hora;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class ValidaHorario.
 */
public class ValidaHorario {

    /**
     * Procura erro.
     *
     * @param horario the horario
     * @param mensagemProcurada the mensagem procurada
     * @return true, if successful
     */
    public static boolean ProcuraErro(Horario horario, String mensagemProcurada) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Horario>> violacoes = validator.validate(horario);
        for(ConstraintViolation<Horario> constraintViolation : violacoes) {
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
     * @param horario the horario
     * @return true, if successful
     */
    public static boolean valida(Horario horario) {
        System.out.println(horario);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Horario>> violacoes = validator.validate(horario);
        for(ConstraintViolation<Horario> constraintViolation : violacoes) {
            System.out.println(constraintViolation.getMessage());
            return false;
        }
        return true;
    }

}
