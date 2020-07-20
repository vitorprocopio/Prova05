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

import br.com.contmatic.enums.Estado;

// TODO: Auto-generated Javadoc
/**
 * The Class Endereco.
 */
public class Endereco {
    
	/** The cep. */
	@Pattern(regexp = "\\d{8}", message = "O CEP deve conter somente 8 digítos numéricos")
	@NotNull(message = "Não deve conter CEP nulo")
    private String cep;
    
	/** The rua. */
	@Pattern(regexp = "^[A-ZÀ-Úa-zà-ú_0-9][A-ZÀ-Ú a-zà-ú_0-9]{0,98}[A-ZÀ-Úa-zà-ú_0-9]$", message = "A rua deve ter até 100 caracteres alfanuméricos")
    @NotBlank(message = "Não deve aceitar rua nulo nem vazio")
    private String rua;
    
	/** The numero. */
	@Min(value = 1, message = "O número deve ser maior ou igual a 1")
	@Max(value = 99999, message = "O número deve ser menor ou igual a 99999")
	@NotNull(message = "Não deve conter número nulo")
    private Integer numero; 
    
	/** The complemento. */
	@Size(max=50)
	@Pattern(regexp = "^[A-ZÀ-Úa-zà-ú0-9]{0,1}[A-ZÀ-Ú a-zà-ú_0-9]{0,48}[A-ZÀ-Úa-zà-ú0-9]{0,1}$", message = "O complemento deve ter até 50 caracteres alfanumericos")
    private String complemento;
    
	/** The bairro. */
	@Size(max=50)
    @Pattern(regexp = "^[A-ZÀ-Úa-zà-ú0-9][A-ZÀ-Ú a-zà-ú_0-9]{0,48}[A-ZÀ-Úa-zà-ú0-9]$", message = "O bairro deve ter até 50 caracteres alfanumericos")
	@NotBlank(message = "Não deve conter bairro nulo")
    private String bairro;
    
    /** The cidade. */
    @Pattern(regexp = "^[A-ZÀ-Úa-zà-ú][A-ZÀ-Ú a-zà-ú]{0,48}[A-Za-zA-ZÀ-Úa-zà-ú]$", message = "A cidade deve ter até 50 caracteres alfanumericos")
	@NotBlank(message = "Não deve conter cidade nula nem vazia")
    private String cidade;
    
    /** The uf. */
    @Valid
	@NotNull(message = "Não deve conter UF nulo")
    private Estado uf;
    
	/** The pais. */
	@Pattern(regexp = "^[A-ZÀ-Úa-zà-ú][A-ZÀ-Ú a-zà-ú]{0,48}[A-Za-zA-ZÀ-Úa-zà-ú]$", message = "O país deve ter até 50 caracteres alfanumericos")
	@NotBlank(message = "Não deve conter país nulo")
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
//        verificaCampoNulo(cep);
//        verificaCampoVazio(cep);
//        verificaTamanhoCep(cep);
//        verificaContemEspacos(cep);
//        verificaContemSomenteNumeros(cep);
        this.cep = cep;
    }
    
//    private void verificaContemSomenteLetrasEDigitos(String campo) {
//        for(char palavra: campo.toCharArray()) {
//            if(!(Character.isLetterOrDigit(palavra) || Character.isSpaceChar(palavra))) {
//                throw new IllegalArgumentException("Não deve conter caracteres especiais");
//            }
//        }
//    }

//    private void verificaContemEspacos(String campo) {
//        for(char palavra: campo.toCharArray()) {
//            if(Character.isSpaceChar(palavra)) {
//                throw new IllegalArgumentException("Não deve ter espaço");
//            }
//        }
//    }
//
//    private void verificaContemSomenteNumeros(String campo) {
//        for(char digito: campo.toCharArray()) {
//            if(!Character.isDigit(digito)) {
//                throw new IllegalArgumentException("Só deve conter números");
//            } 
//        }
//    }
//
//    private void verificaTamanhoCep(String cep) {
//        if(cep.length() != 8) {
//            throw new IllegalArgumentException("O CEP deve conter 8 dígitos"); 
//         }
//    }
//    
//    private void verificaCampoNulo(String campo) {
//        if (campo == null) {
//            throw new IllegalArgumentException("O número do campo não deve ser nulo");
//        }
//    }
//    
//    private void verificaCampoVazio(String campo) {
//        if(campo.isEmpty()) {
//            throw new IllegalArgumentException("Este campo não deve ser vazio");
//        }
//    }
    
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
//        verificaCampoNulo(rua);
//        verificaCampoVazio(rua);
//        verificaEspacoInicio(rua);
//        verificaTamanhoRua(rua);
//        verificaContemSomenteLetrasEDigitos(rua);
        this.rua = rua;
    }
    
//    private void verificaEspacoInicio(String campo) {
//        if(campo.charAt(0) == ' ') {
//            throw new IllegalArgumentException("O campo não deve começar com espaços nem conter somente espaços");
//        }
//    }
//    
//    private void verificaTamanhoRua(String rua) {
//        if(rua.length() > 100) {
//            throw new IllegalArgumentException("O campo deve conter até 100 caracteres"); 
//         }
//    }
    
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
//        if(numero < 0 || numero > 99999) {
//            throw new IllegalArgumentException("O número deve ser de 0 até 99999");
//        }
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
//        if(complemento != null) {
//        verificaTamanhoAteCinquenta(complemento);
//        verificaContemSomenteLetrasEDigitos(complemento);
        this.complemento = complemento;
        }
    
//    private void verificaTamanhoAteCinquenta(String campo) {
//        if(campo.length() > 50) {
//            throw new IllegalArgumentException("O campo deve conter até 100 caracteres"); 
//        }
//    }
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
//        verificaCampoNulo(bairro);
//        verificaCampoVazio(bairro);
//        verificaTamanhoAteCinquenta(bairro);
//        verificaEspacoInicio(bairro);
//        verificaContemSomenteLetrasEDigitos(bairro);
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
//        verificaCampoNulo(cidade);
//        verificaCampoVazio(cidade);
//        verificaEspacoInicio(cidade);
//        verificaTamanhoAteCinquenta(cidade);
//        verificaContemSomenteLetrasEDigitos(cidade);
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
//        verificaCampoNulo(uf);        
//        verificaContemSomenteLetras(uf);
//        verificaTamanhoUf(uf);
        this.uf = uf;
    }
    
//    private void verificaContemSomenteLetras(String campo) {
//        for(char digito: campo.toCharArray()) {
//            if(!Character.isLetter(digito)) {
//                throw new IllegalArgumentException("Só deve conter letras");
//            } 
//        }
//    }
//    
//    private void verificaTamanhoUf(String uf) {
//        if(uf.length() != 2) {
//            throw new IllegalArgumentException("O CEP deve conter 8 dígitos"); 
//         }
//    }
    
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
//        verificaCampoNulo(pais);   
//        verificaCampoVazio(pais);
//        verificaEspacoInicio(pais);
//        verificaTamanhoAteCinquenta(pais);
//        verificaContemSomenteAlfabeto(pais);
        this.pais = pais;
    }
    
//    private void verificaContemSomenteAlfabeto(String campo) {
//        for(char palavra: campo.toCharArray()) {
//            if(!(Character.isAlphabetic(palavra) || Character.isSpaceChar(palavra))) {
//                throw new IllegalArgumentException("Só deve conter letras");
//            }
//        }
//    }
    
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
