package br.com.contmatic.endereco;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.contmatic.annotations.Post;
import br.com.contmatic.annotations.Put;
import br.com.contmatic.enums.Estado;

// TODO: Auto-generated Javadoc
/**
 * The Class Endereco.
 */
public class Endereco {

    /** The cep. */
    @Pattern(regexp = "\\d{8}", message = "O CEP deve conter somente 8 digítos numéricos", groups = {Post.class, Put.class})
    @NotNull(message = "Não deve conter CEP nulo", groups = {Post.class, Put.class})
    private String cep;

    /** The rua. */
    @Pattern(regexp = "^[A-ZÀ-Úa-zà-ú_0-9][A-ZÀ-Ú a-zà-ú_0-9']{0,98}[A-ZÀ-Úa-zà-ú_0-9]$", message = "A rua deve ter até 100 caracteres alfanuméricos", groups = {Post.class, Put.class})
    @NotBlank(message = "Não deve aceitar rua nulo nem vazio", groups = {Post.class, Put.class})
    private String rua;

    /** The numero. */
    @Min(value = 1, message = "O número deve ser maior ou igual a 1", groups = {Post.class, Put.class})
    @Max(value = 99999, message = "O número deve ser menor ou igual a 99999", groups = {Post.class, Put.class})
    @NotNull(message = "Não deve conter número nulo", groups = {Post.class, Put.class})
    private Integer numero;

    /** The complemento. */
    @Size(max = 50, groups = {Post.class, Put.class})
    @Pattern(regexp = "^[A-ZÀ-Úa-zà-ú0-9]{0,1}[A-ZÀ-Ú a-zà-ú_0-9]{0,48}[A-ZÀ-Úa-zà-ú0-9]{0,1}$", message = "O complemento deve ter até 50 caracteres alfanumericos", groups = {Post.class, Put.class})
    private String complemento;

    /** The bairro. */
    @Size(max = 50)
    @Pattern(regexp = "^[A-ZÀ-Úa-zà-ú0-9][A-ZÀ-Ú a-zà-ú_0-9]{0,48}[A-ZÀ-Úa-zà-ú0-9]$", message = "O bairro deve ter até 50 caracteres alfanumericos", groups = {Post.class, Put.class})
    @NotBlank(message = "Não deve conter bairro nulo", groups = {Post.class, Put.class})
    private String bairro;

    /** The cidade. */
    @Pattern(regexp = "^[A-ZÀ-Úa-zà-ú][A-ZÀ-Ú a-zà-ú]{0,48}[A-Za-zA-ZÀ-Úa-zà-ú]$", message = "A cidade deve ter até 50 caracteres alfanumericos", groups = {Post.class, Put.class})
    @NotBlank(message = "Não deve conter cidade nula nem vazia", groups = {Post.class, Put.class})
    private String cidade;

    /** The uf. */
    @Valid
    @NotNull(message = "Não deve conter UF nulo", groups = {Post.class, Put.class})
    private Estado uf;

    /** The pais. */
    @Pattern(regexp = "^[A-ZÀ-Úa-zà-ú][A-ZÀ-Ú a-zà-ú-.,'()&]{0,53}[A-Za-zA-ZÀ-Úa-zà-ú.()]$", message = "O país deve ter até 55 caracteres alfanumericos", groups = {Post.class, Put.class})
    @NotBlank(message = "Não deve conter país nulo", groups = {Post.class, Put.class})
    private String pais;

    /**
     * Instantiates a new endereco.
     *
     * @param cep the cep
     * @param rua the rua
     * @param numero the numero
     * @param complemento the complemento
     * @param bairro the bairro
     * @param cidade the cidade
     * @param uf the uf
     * @param pais the pais
     */
    public Endereco(String cep, String rua, Integer numero, String complemento, String bairro, String cidade, Estado uf, String pais) {
        this.setCep(cep);
        this.setRua(rua);
        this.setNumero(numero);
        this.setComplemento(complemento);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setUf(uf);
        this.setPais(pais);
    }

    /**
     * Gets the cep.
     *
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * Sets the cep.
     *
     * @param cep the new cep
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * Gets the rua.
     *
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * Sets the rua.
     *
     * @param rua the new rua
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * Gets the numero.
     *
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * Sets the numero.
     *
     * @param numero the new numero
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * Gets the complemento.
     *
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * Sets the complemento.
     *
     * @param complemento the new complemento
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * Gets the bairro.
     *
     * @return the bairro
     */
    //
    public String getBairro() {
        return bairro;
    }

    /**
     * Sets the bairro.
     *
     * @param bairro the new bairro
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * Gets the cidade.
     *
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Sets the cidade.
     *
     * @param cidade the new cidade
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * Gets the uf.
     *
     * @return the uf
     */
    public Estado getUf() {
        return uf;
    }

    /**
     * Sets the uf.
     *
     * @param uf the new uf
     */
    public void setUf(Estado uf) {
        this.uf = uf;
    }

    /**
     * Gets the pais.
     *
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * Sets the pais.
     *
     * @param pais the new pais
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.cep).append(this.cidade).build();
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Endereco)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        final Endereco outro = (Endereco) obj;
        return new EqualsBuilder().append(this.cep, outro.cep).append(this.cidade, outro.cidade).isEquals();
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
