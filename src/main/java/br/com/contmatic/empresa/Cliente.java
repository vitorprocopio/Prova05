package br.com.contmatic.empresa;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.br.CPF;
import org.joda.time.LocalDate;

import br.com.contmatic.annotations.DataApos1900;
import br.com.contmatic.contato.Contato;
import br.com.contmatic.endereco.Endereco;
// TODO: Auto-generated Javadoc
//import br.com.contmatic.validacao.ValidaCpf;

/**
 * The Class Cliente.
 */
public class Cliente {

    /** The codigo. */
    @Pattern(regexp = "[0-9]{1,5}", message = "Código inválido")
    @NotEmpty(message = "Não deve aceitar código nulo nem vazio")
    private String codigo;

    /** The nome. */
    @Pattern(regexp = "^[A-ZÀ-Úa-zà-ú]['A-ZÀ-Ú a-zà-ú]{0,98}[A-Za-zA-ZÀ-Úa-zà-ú]$", message = "Nome inválido")
    @NotBlank(message = "Não deve aceitar nome nulo nem vazio")
    private String nome;

    /** The data nascimento. */
    @Past(message = "A data de nascimento deve ser anterior a data atual")
    @NotNull(message = "A data de nascimento não deve ser nula")
    @DataApos1900
    private LocalDate dataNascimento;

    /** The cpf. */
    @CPF
    @NotNull(message = "Não deve aceitar cpf nulo")
    private String cpf;

    /** The enderecos. */
    @Valid
    @NotNull(message = "Não deve aceitar endereco nulo")
    private Set<Endereco> enderecos;

    /** The contatos. */
    @Valid
    @NotNull(message = "Não deve aceitar contato nulo")
    private Set<Contato> contatos;

    /**
     * Instantiates a new cliente.
     *
     * @param codigo the codigo
     * @param nome the nome
     * @param dataNascimento the data nascimento
     * @param cpf the cpf
     * @param enderecos the enderecos
     * @param contatos the contatos
     */
    public Cliente(String codigo, String nome, LocalDate dataNascimento, String cpf, Set<Endereco> enderecos, Set<Contato> contatos) {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setDataNascimento(dataNascimento);
        this.setCpf(cpf);
        this.setEnderecos(enderecos);
        this.setContatos(contatos);
    }

    /**
     * Gets the codigo.
     *
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Sets the codigo.
     *
     * @param codigo the new codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Gets the nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the nome.
     *
     * @param nome the new nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Gets the data nascimento.
     *
     * @return the data nascimento
     */
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Sets the data nascimento.
     *
     * @param dataNascimento the new data nascimento
     */
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Gets the cpf.
     *
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Sets the cpf.
     *
     * @param cpf the new cpf
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Gets the enderecos.
     *
     * @return the enderecos
     */
    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    /**
     * Sets the enderecos.
     *
     * @param enderecos the new enderecos
     */
    public void setEnderecos(Set<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    /**
     * Gets the contatos.
     *
     * @return the contatos
     */
    public Set<Contato> getContatos() {
        return contatos;
    }

    /**
     * Sets the contatos.
     *
     * @param contatos the new contatos
     */
    public void setContatos(Set<Contato> contatos) {
        this.contatos = contatos;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.cpf).build();
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cliente)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        final Cliente outro = (Cliente) obj;
        return new EqualsBuilder().append(this.cpf, outro.cpf).isEquals();
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
