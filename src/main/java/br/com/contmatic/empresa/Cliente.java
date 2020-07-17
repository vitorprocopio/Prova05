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
//import br.com.contmatic.validacao.ValidaCpf;

public class Cliente {

    @Pattern(regexp = "[0-9]{1,5}", message = "Código inválido")
    @NotEmpty(message = "Não deve aceitar código nulo nem vazio")
    private String codigo;

    @Pattern(regexp = "^[A-ZÀ-Úa-zà-ú]['A-ZÀ-Ú a-zà-ú]{0,98}[A-Za-zA-ZÀ-Úa-zà-ú]$", message = "Nome inválido")
    @NotBlank(message = "Não deve aceitar nome nulo nem vazio")
    private String nome;

    @Past(message = "A data de nascimento deve ser anterior a data atual")
    @NotNull(message = "A data de nascimento não deve ser nula")
    @DataApos1900
    private LocalDate dataNascimento;

    @CPF
    @NotNull(message = "Não deve aceitar cpf nulo")
    private String cpf;

    @Valid
    @NotNull(message = "Não deve aceitar endereco nulo")
    private Set<Endereco> enderecos;

    @Valid
    @NotNull(message = "Não deve aceitar contato nulo")
    private Set<Contato> contatos;

    public Cliente(String codigo, String nome, LocalDate dataNascimento, String cpf, Set<Endereco> enderecos, Set<Contato> contatos) {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setDataNascimento(dataNascimento);
        this.setCpf(cpf);
        this.setEnderecos(enderecos);
        this.setContatos(contatos);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        // verificaCampoNulo(codigo);
        // verificaTamanhoMenorQue6(codigo);
        // verificaContemSomenteNumeros(codigo);
        // verificaCampoVazio(codigo);
        this.codigo = codigo;
    }

    // private void verificaTamanhoMenorQue6(String campo) {
    // if(campo.length() > 5) {
    // throw new IllegalArgumentException("Este campo deve ter no máximo 5 dígitos");
    // }
    // }
    //
    // private void verificaCampoVazio(String campo) {
    // if(campo.isEmpty()) {
    // throw new IllegalArgumentException("Este campo não deve ser vazio");
    // }
    // }
    //
    // private void verificaContemSomenteNumeros(String campo) {
    // for(char palavra: campo.toCharArray()) {
    // if(!Character.isDigit(palavra)) {
    // throw new IllegalArgumentException("Só deve conter números");
    // }
    // }
    // }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        // verificaCampoNulo(nome);
        // verificaCampoVazio(nome);
        // verificaEspacoInicio(nome);
        // verificaContemSomenteLetras(nome);
        // verificaTamanhoAteCem(nome);
        this.nome = nome;
    }

    // private void verificaEspacoInicio(String campo) {
    // if(campo.charAt(0) == ' ') {
    // throw new IllegalArgumentException("O campo não deve começar com espaços");
    // }
    // }
    //
    // private void verificaContemSomenteLetras(String campo) {
    // for(char palavra: campo.toCharArray()) {
    // if(!(Character.isAlphabetic(palavra) || Character.isSpaceChar(palavra))) {
    // throw new IllegalArgumentException("Só deve conter letras");
    // }
    // }
    // }
    //
    // private void verificaTamanhoAteCem(String campo) {
    // if(campo.length() > 100) {
    // throw new IllegalArgumentException("O campo deve ter até 100 caracteres");
    // }
    // }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        // verificaDataNula(dataNascimento);
        // verificaDataNascimento(dataNascimento);
        this.dataNascimento = dataNascimento;
    }

    // private void verificaDataNascimento(LocalDate dataNascimento) {
    // if(dataNascimento.isBefore(LocalDate.of(1900, 1, 1)) || dataNascimento.isAfter(LocalDate.now())) {
    // throw new IllegalArgumentException("Coloque uma data a partir de 01/01/1900 e não ultrapasse a data de hoje");
    // }
    // }
    //
    // private void verificaDataNula(LocalDate dataNascimento) {
    // if(dataNascimento == null) {
    // throw new IllegalArgumentException("O campo não deve ser nulo");
    // }
    // }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        // verificaCampoNulo(cpf);
        // verificaTodosDigitosRepetidos(cpf);
        // verificaTamanhoCpf(cpf);
        // verificaContemSomenteNumeros(cpf);
        // ValidaCpf.validaCpf(cpf);
        this.cpf = cpf;
    }

    // private void verificaCampoNulo(String campo) {
    // if (campo == null) {
    // throw new IllegalArgumentException("Esse campo não pode ser nulo");
    // }
    // }
    //
    // private void verificaTamanhoCpf(String cpf) {
    // if(cpf.length() != 11) {
    // throw new IllegalArgumentException("O número do CPF deve ter 11 dígitos");
    // }
    // }
    //
    // private void verificaTodosDigitosRepetidos(String cpf) {
    // if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")||
    // cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999")) {
    // throw new IllegalArgumentException("Os digítos do CPF não podem ser todos repetidos");
    // }
    // }

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<Endereco> enderecos) {
        // verificaEnderecoNulo(endereco);
        this.enderecos = enderecos;
    }

    // private void verificaEnderecoNulo(Endereco endereco) {
    // if (endereco == null) {
    // throw new IllegalArgumentException("Esse campo não pode ser nulo");
    // }
    // }

    public Set<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(Set<Contato> contatos) {
        // verificaContatoNulo(contato);
        this.contatos = contatos;
    }

    // private void verificaContatoNulo(Contato contato) {
    // if (contato == null) {
    // throw new IllegalArgumentException("Esse campo não pode ser nulo");
    // }
    // }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.cpf).build();
    }

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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
