package br.com.contmatic.empresa;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.br.CNPJ;

import br.com.contmatic.annotations.Post;
import br.com.contmatic.annotations.Put;
import br.com.contmatic.endereco.Endereco;
// TODO: Auto-generated Javadoc
//import br.com.contmatic.validacao.ValidaCnpj;

/**
 * The Class Empresa.
 */
public class Empresa {

    /** The codigo. */
    
    @NotEmpty(message = "Não deve aceitar código nulo nem vazio", groups = {Post.class, Put.class})
    @Pattern(regexp = "\\d{1,5}", message = "Código inválido", groups = {Post.class, Put.class})
    private String codigo;

    /** The cnpj. */
    @CNPJ(groups = {Post.class, Put.class})
    @NotNull(message = "Cnpj não pode ser nulo", groups = {Post.class, Put.class})
    private String cnpj;

    /** The nome fantasia. */
    @Size(max = 100, groups = {Post.class, Put.class})
    @NotBlank(message = "Nome fantasia não pode ser nulo nem vazio", groups = {Post.class, Put.class})
    @Pattern(regexp = "^['A-ZÀ-Úa-zà-ú0-9!@#$%&*-+_§.,;]['A-ZÀ-Ú a-zà-ú0-9!@#$%&*-+_§.,;]{0,98}['A-ZÀ-Úa-zà-ú0-9!@#$%&*-+_§.,;]$", message = "Nome fantasia inválido", groups = {Post.class, Put.class})
    private String nomeFantasia;

    /** The razao social. */
    @Size(max = 100, groups = {Post.class, Put.class})
    @NotBlank(message = "Razão social não pode ser nulo nem vazio", groups = {Post.class, Put.class})
    @Pattern(regexp = "^[0-9A-ZÀ-Úa-zà-ú'!@#$%&*-+_§.,;][ 0-9A-ZÀ-Úa-zà-ú'!@#$%&*-+_§.,;]{0,98}[0-9A-ZÀ-Úa-zà-ú'!@#$%&*-+_§.,;]$", message = "Razão social inválido", groups = {Post.class, Put.class})
    private String razaoSocial;

    /** The enderecos. */
    @Valid
    @NotNull(message = "Endereço não pode ser nulo")
    private Set<Endereco> enderecos;

    /**
     * Instantiates a new empresa.
     *
     * @param codigo the codigo
     * @param cnpj the cnpj
     * @param nomeFantasia the nome fantasia
     * @param razaoSocial the razao social
     * @param enderecos the enderecos
     */
    public Empresa(String codigo, String cnpj, String nomeFantasia, String razaoSocial, Set<Endereco> enderecos) {
        this.setCodigo(codigo);
        this.setCnpj(cnpj);
        this.setNomeFantasia(nomeFantasia);
        this.setRazaoSocial(razaoSocial);
        this.setEnderecos(enderecos);
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
     * Gets the cnpj.
     *
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Sets the cnpj.
     *
     * @param cnpj the new cnpj
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * Gets the nome fantasia.
     *
     * @return the nome fantasia
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     * Sets the nome fantasia.
     *
     * @param nomeFantasia the new nome fantasia
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    /**
     * Gets the razao social.
     *
     * @return the razao social
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * Sets the razao social.
     *
     * @param razaoSocial the new razao social
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
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
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.cnpj).build();
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Empresa)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        final Empresa outro = (Empresa) obj;
        return new EqualsBuilder().append(this.cnpj, outro.cnpj).isEquals();
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
