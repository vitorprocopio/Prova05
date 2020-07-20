package br.com.contmatic.empresa;

import java.util.Set;

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

import br.com.contmatic.endereco.Endereco;
// TODO: Auto-generated Javadoc
//import br.com.contmatic.validacao.ValidaCnpj;

/**
 * The Class Empresa.
 */
public class Empresa {

    /** The codigo. */
    @NotEmpty(message = "Não deve aceitar código nulo nem vazio")
    @Pattern(regexp = "\\d{1,5}", message = "Código inválido")
    private String codigo;

    /** The cnpj. */
    @CNPJ
    @NotNull(message = "Cnpj não pode ser nulo")
    private String cnpj;

    /** The nome fantasia. */
    @Size(max = 100)
    @NotBlank(message = "Nome fantasia não pode ser nulo nem vazio")
    @Pattern(regexp = "^['A-ZÀ-Úa-zà-ú0-9!@#$%&*-+_§.,;]['A-ZÀ-Ú a-zà-ú0-9!@#$%&*-+_§.,;]{0,98}['A-ZÀ-Úa-zà-ú0-9!@#$%&*-+_§.,;]$", message = "Nome fantasia inválido")
    private String nomeFantasia;

    /** The razao social. */
    @Size(max = 100)
    @NotBlank(message = "Razão social não pode ser nulo nem vazio")
    @Pattern(regexp = "^[0-9A-ZÀ-Úa-zà-ú'!@#$%&*-+_§.,;][ 0-9A-ZÀ-Úa-zà-ú'!@#$%&*-+_§.,;]{0,98}[0-9A-ZÀ-Úa-zà-ú'!@#$%&*-+_§.,;]$", message = "Razão social inválido")
    private String razaoSocial;

    /** The enderecos. */
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
        // verificaTamanhoAte5(codigo);
        // verificaContemSomenteNumeros(codigo);
        // verificaCampoVazio(codigo);
        this.codigo = codigo;
    }

    // private void verificaTamanhoAte5(String campo) {
    // if(campo.length() > 5) {
    // throw new IllegalArgumentException("Este campo deve ter no máximo 5 dígitos");
    // }
    // }

    // private void verificaCampoVazio(String campo) {
    // if(campo.isEmpty()) {
    // throw new IllegalArgumentException("Este campo não deve ser vazio");
    // }
    // }

    // private void verificaContemSomenteNumeros(String campo) {
    // for(char palavra: campo.toCharArray()) {
    // if(!Character.isDigit(palavra)) {
    // throw new IllegalArgumentException("Só deve conter números");
    // }
    // }
    // }

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

    // private void verificaTamanhoCnpj(String cnpj) {
    // if(cnpj.length() != 14) {
    // throw new IllegalArgumentException("O número da agência deve ter 4 dígitos");
    // }
    // }
    //
    // private void verificaTodosDigitosRepetidos(String cnpj) {
    // if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222") || cnpj.equals("33333333333333") || cnpj.equals("44444444444444") ||
    // cnpj.equals("55555555555555")|| cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888") || cnpj.equals("99999999999999")) {
    // throw new IllegalArgumentException("Os digítos do CNPJ não podem ser todos repetidos");
    // }
    // }

    // private void verificaCampoNulo(String campo) {
    // if (campo == null) {
    // throw new IllegalArgumentException("Esse campo não pode ser nulo");
    // }
    // }

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
        // verificaCampoVazio(nomeFantasia);
        // verificaEspacoInicio(nomeFantasia);
        // verificaTamanhoAteCem(nomeFantasia);
        this.nomeFantasia = nomeFantasia;
    }

    // private void verificaEspacoInicio(String campo) {
    // if(campo.charAt(0) == ' ') {
    // throw new IllegalArgumentException("O campo não deve começar com espaços");
    // }
    // }

    // private void verificaTamanhoAteCem(String campo) {
    // if(campo.length() > 100) {
    // throw new IllegalArgumentException("O campo deve ter até 100 caracteres");
    // }
    // }

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
        // verificaCampoNulo(razaoSocial);
        // verificaCampoVazio(razaoSocial);
        // verificaEspacoInicio(razaoSocial);
        // verificaTamanhoAteCem(razaoSocial);
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
        // verificaEnderecoNulo(endereco);
        this.enderecos = enderecos;
    }

    // private void verificaEnderecoNulo(Endereco endereco) {
    // if (endereco == null) {
    // throw new IllegalArgumentException("Esse campo não pode ser nulo");
    // }
    // }

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
        if (!(obj instanceof Cliente)) {
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
