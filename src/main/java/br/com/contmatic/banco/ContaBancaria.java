package br.com.contmatic.banco;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

// TODO: Auto-generated Javadoc
/**
 * The Class ContaBancaria.
 */
public class ContaBancaria {
    
	/** The titular. */
	@Pattern(regexp = "^[A-ZÀ-Úa-zà-ú]['A-ZÀ-Ú a-zà-ú]{0,98}[A-Za-zA-ZÀ-Úa-zà-ú]$", message = "Titular inválido")
    @NotEmpty(message = "O titular não deve ser nulo nem vazio")
    private String titular;
    
	/** The numero. */
	@Pattern(regexp = "\\d{1,20}", message = "Numero da conta inválido")
    @NotEmpty(message = "O número da conta não deve ser nulo nem vazio")
    private String numero; 
    
	/** The agencia. */
	@Pattern(regexp = "\\d{4}", message = "Numero da agência inválido")
    @NotEmpty(message = "A agência não deve ser nula nem vazia")
    private String agencia;
    
    /**
     * Instantiates a new conta bancaria.
     *
     * @param titular the titular
     * @param numero the numero
     * @param agencia the agencia
     */
    public ContaBancaria(String titular, String numero, String agencia) {
        this.setTitular(titular);
        this.setNumero(numero);
        this.setAgencia(agencia);
    }

    /**
     * Gets the titular.
     *
     * @return the titular
     */
    public String getTitular() {
        return titular;
    }

    /**
     * Sets the titular.
     *
     * @param titular the new titular
     */
    public void setTitular(String titular) {
//        verificaCampoNulo(titular);
//        verificaCampoVazio(titular);
//        verificaEspacoInicio(titular);
//        verificaContemSomenteLetras(titular);
//        verificaTamanhoAteCem(titular);
        this.titular = titular;
    }

//    private void verificaTamanhoAteCem(String campo) {
//        if(campo.length() > 100) {
//        throw new IllegalArgumentException("O campo deve ter até 100 caracteres");
//        }
//    }
//    
//    private void verificaEspacoInicio(String campo) {
//        if(campo.charAt(0) == ' ') {
//            throw new IllegalArgumentException("O campo não deve começar com espaços");
//        }
//    }
//
//    private void verificaCampoVazio(String campo) {
//        if(campo.isEmpty()) {
//            throw new IllegalArgumentException("Este campo não deve ser vazio");
//        }
//    }

    /**
 * Gets the numero.
 *
 * @return the numero
 */
public String getNumero() {
        return numero;
    }

    /**
     * Sets the numero.
     *
     * @param numero the new numero
     */
    public void setNumero(String numero) {
//        verificaCampoNulo(numero);
//        verificaCampoVazio(numero);
//        verificaEspacoInicio(numero);
//        verificaContemSomenteNumeros(numero);
//        verificaTamanhoMenorVinte(numero);
        this.numero = numero;
    }

    /**
     * Gets the agencia.
     *
     * @return the agencia
     */
    public String getAgencia() {
        return agencia;
    }

    /**
     * Sets the agencia.
     *
     * @param agencia the new agencia
     */
    public void setAgencia(String agencia) {
//        verificaCampoNulo(agencia);
//        verificaAgenciaQuatroDigitos(agencia);
//        verificaContemSomenteNumeros(agencia);
//        verificaCampoVazio(titular);
//        verificaEspacoInicio(titular);
        this.agencia = agencia;
    }
    
//    private void verificaTamanhoMenorVinte(String campo) {
//        if(campo.length() > 20) {
//        throw new IllegalArgumentException("O campo deve ter até 20 caracteres");
//        }
//    }
//    
//    private void verificaContemSomenteNumeros(String campo) {
//        for(char palavra: campo.toCharArray()) {
//            if(!Character.isDigit(palavra)) {
//                throw new IllegalArgumentException("Só deve conter números");
//            }
//        }
//    }
//
//    private void verificaContemSomenteLetras(String campo) {
//        for(char palavra: campo.toCharArray()) {
//            if(!(Character.isAlphabetic(palavra) || Character.isSpaceChar(palavra))) {
//                throw new IllegalArgumentException("Só deve conter letras");
//            }
//        }
//    }
//    
//    private void verificaAgenciaQuatroDigitos(String agencia) {
//        if(agencia.length() != 4) {
//            throw new IllegalArgumentException("O número da agência deve ter 4 dígitos");
//        }
//    }
//
//    private void verificaCampoNulo(String campo) {
//        if (campo == null) {
//            throw new IllegalArgumentException("O campo não deve ser nulo");
//        }
//    }

    /**
 * Hash code.
 *
 * @return the int
 */
@Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.agencia).append(numero).build();
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ContaBancaria)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        final ContaBancaria outro = (ContaBancaria) obj;
        return new EqualsBuilder().append(this.agencia, outro.agencia).append(this.numero, outro.numero).isEquals();
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
    
}
