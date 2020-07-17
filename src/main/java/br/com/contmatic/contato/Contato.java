package br.com.contmatic.contato;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Contato {
    
	@Pattern(regexp = "\\d{8}", message = "O telefone deve conter somente 8 digítos numéricos")
    private String telefone;
    
	@Pattern(regexp = "\\d{9}", message = "O celular deve conter somente 9 digítos numéricos")
	private String celular;
    
	@Pattern(regexp = "\\d{8,9}", message = "O número para contato deve conter somente 8 ou 9 digítos numéricos")
    private String recado;
    
    @Email(message = "O endereço de email é inválido")
    private String email;
    
    public Contato(String telefone, String celular, String recado, String email) {
        this.setTelefone(telefone);
        this.setCelular(celular);
        this.setRecado(recado);
        this.setEmail(email);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
//        if(telefone != null) {
//        verificaTamanhoTelefone(telefone);
//        verificaContemSomenteNumeros(telefone);
//        }
    	this.telefone = telefone;
    }
    
//    private void verificaContemSomenteNumeros(String campo) {
//        for(char palavra: campo.toCharArray()) {
//            if(!Character.isDigit(palavra)) {
//                throw new IllegalArgumentException("Só deve conter números");
//            }
//        }
//    }
//
//    private void verificaTamanhoTelefone(String telefone) {
//        if(telefone.length() != 8) {
//           throw new IllegalArgumentException("O número deve conter 8 dígitos"); 
//        }
        
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
//        if(celular != null) {
//        verificaTamanhoCelular(celular);
//        verificaContemSomenteNumeros(celular);
//        }
//    }
//
//    private void verificaTamanhoCelular(String celular) {
//        if(celular.length() != 9) {
//            throw new IllegalArgumentException("O número deve conter 9 dígitos"); 
//         }
        this.celular = celular;
    }

    public String getRecado() {
        return recado;
    }

    public void setRecado(String recado) {
//        if(recado != null) {
//        verificaTamanhoRecado(recado);
//        verificaContemSomenteNumeros(recado);
//        }
//    }
//
//    private void verificaTamanhoRecado(String recado) {
//        if(recado.length() < 8 || recado.length() > 9) {
//            throw new IllegalArgumentException("O número deve conter 8 ou 9 dígitos"); 
//         }
        this.recado = recado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
//        if(email != null) {
//        verificaTamanhoEmail(email);
//        }
//    }
//
//    private void verificaTamanhoEmail(String email) {
//        if(email.length() > 250) {
//            throw new IllegalArgumentException("O email deve ter até 100 caracteres");
//        }
//        for(char palavra: email.toCharArray()) {
//            if(Character.isSpaceChar(palavra)) {
//                throw new IllegalArgumentException("Não deve ter espaço");
//            }
//        }
        this.email = email;
    }
    
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
    
}
