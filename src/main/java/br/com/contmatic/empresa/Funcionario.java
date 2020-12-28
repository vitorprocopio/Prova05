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
import br.com.contmatic.annotations.Post;
import br.com.contmatic.annotations.Put;
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
    @NotEmpty(message = "Não deve aceitar código nulo nem vazio", groups = Put.class)
    @Pattern(regexp = "\\d{0,5}", message = "Código inválido", groups = Put.class)
    private String codigo;

    /** The nome. */
    @Pattern(regexp = "^[A-ZÀ-Úa-zà-ú]['A-ZÀ-Ú a-zà-ú.]{0,98}[A-Za-zA-ZÀ-Úa-zà-ú]$", message = "Nome inválido", groups = {Post.class, Put.class})
    @NotBlank(message = "Não deve aceitar nome nulo nem vazio", groups = {Post.class, Put.class})
    private String nome;

    /** The data nascimento. */
    @Past(message = "A data de nascimento deve ser anterior a data atual", groups = {Post.class, Put.class})
    @NotNull(message = "A data de nascimento não deve ser nula", groups = {Post.class, Put.class})
    @DataApos1900
    private LocalDate dataNascimento;

    /** The nome mae. */
    @Pattern(regexp = "^[A-ZÀ-Úa-zà-ú.]['A-ZÀ-Ú a-zà-ú.]{0,98}[A-Za-zA-ZÀ-Úa-zà-ú.]$", message = "Nome mãe inválido", groups = {Post.class, Put.class})
    @NotBlank(message = "Não deve aceitar nome da mãe nulo nem vazio", groups = {Post.class, Put.class})
    private String nomeMae;

    /** The nome pai. */
    @Pattern(regexp = "^[A-ZÀ-Úa-zà-ú]['A-ZÀ-Ú a-zà-ú.]{0,98}[A-Za-zA-ZÀ-Úa-zà-ú]$", message = "Nome pai inválido", groups = {Post.class, Put.class})
    @NotBlank(message = "Não deve aceitar nome do pai nulo nem vazio", groups = {Post.class, Put.class})
    private String nomePai;

    /** The cpf. */
    @CPF(groups = Post.class)
    @NotNull(message = "Não deve aceitar cpf nulo", groups = Post.class)
    private String cpf;

    /** The sexo. */
    @NotNull(message = "Não deve aceitar sexo nulo", groups = {Post.class, Put.class})
    private Genero sexo;

    /** The enderecos. */
    @NotNull(message = "Não deve aceitar endereço nulo", groups = {Post.class, Put.class})
    private Set<Endereco> enderecos;

    /** The salario. */
    @DecimalMin(value = "0.00", message = "O valor do salário não pode ser negativo", groups = {Post.class, Put.class})
    @Digits(integer = 5, fraction = 2, message = "O valor do salário está inválido", groups = {Post.class, Put.class})
    private double salario;

    /** The horario. */
    @NotNull(message = "Não deve aceitar horário nulo", groups = {Post.class, Put.class})
    private Horario horario;

    /** The conta. */
    @NotNull(message = "Não deve aceitar Conta Bancaria nulo", groups = {Post.class, Put.class})
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
        this.dataNascimento = dataNascimento;
    }

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
        this.cpf = cpf;
    }

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
        this.sexo = sexo;
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
        this.salario = salario;
    }

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
        this.horario = horario;
    }

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
        this.conta = conta;
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
