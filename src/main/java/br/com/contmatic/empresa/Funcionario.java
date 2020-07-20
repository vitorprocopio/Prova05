package br.com.contmatic.empresa;

import java.util.Set;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
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
import br.com.contmatic.banco.ContaBancaria;
import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.enums.Genero;
import br.com.contmatic.hora.Horario;

// TODO: Auto-generated Javadoc
/**
 * The Class Funcionario.
 */
public class Funcionario {

    /** The codigo. */
    @NotEmpty(message = "Não deve aceitar código nulo nem vazio")
    @Pattern(regexp = "\\d{0,5}", message = "Código inválido")
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

    /** The nome mae. */
    @Pattern(regexp = "^[A-ZÀ-Úa-zà-ú]['A-ZÀ-Ú a-zà-ú]{0,98}[A-Za-zA-ZÀ-Úa-zà-ú]$", message = "Nome mãe inválido")
    @NotBlank(message = "Não deve aceitar nome da mãe nulo nem vazio")
    private String nomeMae;

    /** The nome pai. */
    @Pattern(regexp = "^[A-ZÀ-Úa-zà-ú]['A-ZÀ-Ú a-zà-ú]{0,98}[A-Za-zA-ZÀ-Úa-zà-ú]$", message = "Nome pai inválido")
    @NotBlank(message = "Não deve aceitar nome do pai nulo nem vazio")
    private String nomePai;

    /** The cpf. */
    @CPF
    @NotNull(message = "Não deve aceitar cpf nulo")
    private String cpf;

    /** The sexo. */
    @NotNull(message = "Não deve aceitar sexo nulo")
    private Genero sexo;

    /** The enderecos. */
    @NotNull(message = "Não deve aceitar endereço nulo")
    private Set<Endereco> enderecos;

    /** The salario. */
    @DecimalMin(value = "0.00", message = "O valor do salário não pode ser negativo")
    @Digits(integer = 5, fraction = 2, message = "O valor do salário está inválido")
    private double salario;

    /** The horario. */
    @NotNull(message = "Não deve aceitar horário nulo")
    private Horario horario;

    /** The conta. */
    @NotNull(message = "Não deve aceitar Conta Bancaria nulo")
    private ContaBancaria conta;

    /**
     * Instantiates a new funcionario.
     *
     * @param codigo the codigo
     * @param nome the nome
     * @param dataNascimento the data nascimento
     * @param nomeMae the nome mae
     * @param nomePai the nome pai
     * @param cpf the cpf
     * @param sexo the sexo
     * @param salario the salario
     * @param enderecos the enderecos
     * @param conta the conta
     * @param horario the horario
     */
    public Funcionario(String codigo, String nome, LocalDate dataNascimento, String nomeMae, String nomePai, String cpf, Genero sexo, double salario, Set<Endereco> enderecos, ContaBancaria conta,
                       Horario horario) {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setDataNascimento(dataNascimento);
        this.setNomeMae(nomeMae);
        this.setNomePai(nomePai);
        this.setCpf(cpf);
        this.setSexo(sexo);
        this.setSalario(salario);
        this.setEnderecos(enderecos);
        this.setConta(conta);
        this.setHorario(horario);
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
        // verificaCampoNulo(codigo);
        // verificaTamanhoMenorQue6(codigo);
        // verificaContemSomenteNumeros(codigo);
        // verificaCampoVazio(codigo);
        this.codigo = codigo;
    }

    // private void verificaCampoNulo(String campo) {
    // if(campo == null) {
    // throw new IllegalArgumentException("Este campo não deve ser nulo");
    // }
    // }
    //
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
    /**
     * Gets the data nascimento.
     *
     * @return the data nascimento
     */
    //
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Sets the data nascimento.
     *
     * @param dataNascimento the new data nascimento
     */
    public void setDataNascimento(LocalDate dataNascimento) {
        // verificaDataNula(dataNascimento);
        // verificaDataNascimento(dataNascimento);
        this.dataNascimento = dataNascimento;
    }
    //
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

    /**
     * Gets the nome mae.
     *
     * @return the nome mae
     */
    public String getNomeMae() {
        return nomeMae;
    }

    /**
     * Sets the nome mae.
     *
     * @param nomeMae the new nome mae
     */
    public void setNomeMae(String nomeMae) {
        // verificaCampoNulo(nomeMae);
        // verificaCampoVazio(nomeMae);
        // verificaEspacoInicio(nomeMae);
        // verificaContemSomenteLetras(nomeMae);
        // verificaTamanhoAteCem(nomeMae);
        this.nomeMae = nomeMae;
    }

    /**
     * Gets the nome pai.
     *
     * @return the nome pai
     */
    public String getNomePai() {
        return nomePai;
    }

    /**
     * Sets the nome pai.
     *
     * @param nomePai the new nome pai
     */
    public void setNomePai(String nomePai) {
        // verificaEspacoInicio(nomePai);
        // verificaContemSomenteLetras(nomePai);
        // verificaTamanhoAteCem(nomePai);
        this.nomePai = nomePai;
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
        // verificaCampoNulo(cpf);
        // verificaTamanhoCpf(cpf);
        // verificaContemSomenteNumeros(cpf);
        // verificaTodosDigitosRepetidos(cpf);
        // ValidaCpf.validaCpf(cpf);
        this.cpf = cpf;
    }

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

    /**
     * Gets the sexo.
     *
     * @return the sexo
     */
    public Genero getSexo() {
        return sexo;
    }

    /**
     * Sets the sexo.
     *
     * @param sexo the new sexo
     */
    public void setSexo(Genero sexo) {
        // verificaCampoNulo(sexo);
        // verificaTamanhoIgualUm(sexo);
        // verificaSexo(sexo);
        this.sexo = sexo;
    }

    // private void verificaTamanhoIgualUm(String sexo) {
    // if(sexo.length() != 1) {
    // throw new IllegalArgumentException("Tamanho inválido: Escreva F (Feminino), M (Masculino) ou O (Outro)");
    // }
    // }
    //
    // private void verificaSexo(String sexo) {
    // if (sexo.equals("F") || sexo.equals("M") || sexo.equals("O")) {
    // } else {
    // throw new IllegalArgumentException("Escreva F (Feminino), M (Masculino) ou O (Outro)");
    // }
    // }

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
    // if(endereco == null) {
    // throw new IllegalArgumentException("Este campo não deve ser nulo");
    // }
    // }

    /**
     * Gets the salario.
     *
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Sets the salario.
     *
     * @param salario the new salario
     */
    public void setSalario(double salario) {
        // verificaSalario(salario);
        this.salario = salario;
    }

    // private void verificaSalario(double salario) {
    // if(salario < 0 || salario > 99999) {
    // throw new IllegalArgumentException("O salário vai de 0 até 99999 reais");
    // }
    // }

    /**
     * Gets the horario.
     *
     * @return the horario
     */
    public Horario getHorario() {
        return horario;
    }

    /**
     * Sets the horario.
     *
     * @param horario the new horario
     */
    public void setHorario(Horario horario) {
        // verificaHorarioNulo(horario);
        this.horario = horario;
    }

    // private void verificaHorarioNulo(Horario horario) {
    // if(horario == null) {
    // throw new IllegalArgumentException("Este campo não deve ser nulo");
    // }
    // }

    /**
     * Gets the conta.
     *
     * @return the conta
     */
    public ContaBancaria getConta() {
        return conta;
    }

    /**
     * Sets the conta.
     *
     * @param conta the new conta
     */
    public void setConta(ContaBancaria conta) {
        // verificaContaNulo(conta);
        this.conta = conta;
    }

    // private void verificaContaNulo(ContaBancaria conta) {
    // if(conta == null) {
    // throw new IllegalArgumentException("Este campo não deve ser nulo");
    // }
    // }

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
        if (!(obj instanceof Funcionario)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        final Funcionario outro = (Funcionario) obj;
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
