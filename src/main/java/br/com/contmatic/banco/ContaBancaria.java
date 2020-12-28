package br.com.contmatic.banco;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.contmatic.annotations.Post;
import br.com.contmatic.annotations.Put;

// TODO: Auto-generated Javadoc
/**
 * The Class ContaBancaria.
 */
public class ContaBancaria {

    /** The titular. */
    @Pattern(regexp = "^[A-ZÀ-Úa-zà-ú]['A-ZÀ-Ú a-zà-ú.]{0,98}[A-Za-zA-ZÀ-Úa-zà-ú]$", message = "Titular inválido", groups = {Post.class, Put.class})
    @NotEmpty(message = "O titular não deve ser nulo nem vazio", groups = {Post.class, Put.class})
    private String titular;

    /** The numero. */
    @Pattern(regexp = "\\d{1,20}", message = "Numero da conta inválido", groups = {Post.class, Put.class})
    @NotEmpty(message = "O número da conta não deve ser nulo nem vazio", groups = {Post.class, Put.class})
    private String numero;

    /** The agencia. */
    @Pattern(regexp = "\\d{4}", message = "Numero da agência inválido", groups = {Post.class, Put.class})
    @NotEmpty(message = "A agência não deve ser nula nem vazia", groups = {Post.class, Put.class})
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
        this.titular = titular;
    }

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
        this.agencia = agencia;
    }

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
