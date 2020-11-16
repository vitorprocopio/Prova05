package br.com.contmatic.empresa;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import org.joda.time.LocalDate;
import org.joda.time.Period;

import com.github.javafaker.Faker;

import br.com.contmatic.banco.BancoTemplate;
import br.com.contmatic.banco.ContaBancaria;
import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.endereco.EnderecoTemplate;
import br.com.contmatic.enums.Genero;
import br.com.contmatic.hora.Horario;
import br.com.contmatic.hora.HorarioTemplate;
import br.com.contmatic.validacao.GeraCpf;

// TODO: Auto-generated Javadoc
/**
 * The Class FuncionarioTemplate.
 */
public class FuncionarioTemplate {
    
    private static Horario horario;

    /** The contatos. */
    private static ContaBancaria conta;

    /** The enderecos. */
    private static Set<Endereco> enderecos = new HashSet<>();

    public static String randomCodigoValido() {
        return RandomStringUtils.randomNumeric(1, 5);
    }

    public static String randomCodigoInvalido() {
        return RandomStringUtils.randomAlphanumeric(6, 10);
    }
    
    public static String randomNomeValido() {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        return name + firstName + lastName;
    }

    public static String randomNomeInvalido() {
        return RandomStringUtils.randomAlphanumeric(101, 105);
    }
    
    public static String randomCpfValido() {
        String cpfValido = GeraCpf.geraCpf();
        return cpfValido;
    }
    
    public static String randomCpfInvalido() {
        return RandomStringUtils.randomAlphanumeric(1, 15);
    }
    
    public static Genero randomSexoValido() {
        Genero sexoValido = Genero.randomSexo();
        return sexoValido;
    }

    public static LocalDate randomDataValida() {
        return LocalDate.now().minus(Period.days((new Random().nextInt(365 * 70))));
    }
    
    public static LocalDate randomDataInvalida() {
        return LocalDate.now().plus(Period.days((new Random().nextInt(365 * 70))));
    }
    
    public static double randomSalarioValido() {
        double numero = Math.round((Math.random() * 99999.99) * 100.00) / 100.00;
        return numero;
    }
    
    public static double randomSalarioInvalido() {
        double numero = Math.round((Math.random() * 100000.00) * 100.00) / 100.00;
        return numero;
    }
    
    public static Set<Endereco> randomEnderecosValidos() {
        for(int i = 0 ; i < 3 ; i++) {
            EasyRandom enderecoValido = new EasyRandom(EnderecoTemplate.enderecoValido());
            enderecos.add(enderecoValido.nextObject(Endereco.class));
        }
        return enderecos;
    }
    
    public static Horario randomHorario() {
        EasyRandom horarioValido = new EasyRandom(HorarioTemplate.horarioValido());
        horario = horarioValido.nextObject(Horario.class);
        return horario;
    }

    public static ContaBancaria randomContaValida() {
        EasyRandom contaValida = new EasyRandom(BancoTemplate.contaValida());
        conta = contaValida.nextObject(ContaBancaria.class);
        return conta;
    }

    public static EasyRandomParameters funcionarioValido() {
        EasyRandomParameters funcionarioValido = new EasyRandomParameters()
                .randomize(FieldPredicates.named("codigo").and(FieldPredicates.inClass(Funcionario.class)), () -> randomCodigoValido())
                .randomize(FieldPredicates.named("nome").and(FieldPredicates.inClass(Funcionario.class)), () -> randomNomeValido())
                .randomize(FieldPredicates.named("nomeMae").and(FieldPredicates.inClass(Funcionario.class)), () -> randomNomeValido())
                .randomize(FieldPredicates.named("nomePai").and(FieldPredicates.inClass(Funcionario.class)), () -> randomNomeValido())
                .randomize(FieldPredicates.named("dataNascimento").and(FieldPredicates.inClass(Funcionario.class)), () -> randomDataValida())
                .randomize(FieldPredicates.named("cpf").and(FieldPredicates.inClass(Funcionario.class)), () -> randomCpfValido())
                .randomize(FieldPredicates.named("sexo").and(FieldPredicates.inClass(Funcionario.class)), () -> randomSexoValido())
                .randomize(FieldPredicates.named("horario").and(FieldPredicates.inClass(Funcionario.class)), () -> randomHorario())
                .randomize(FieldPredicates.named("salario").and(FieldPredicates.inClass(Funcionario.class)), () -> randomSalarioValido())
                .randomize(FieldPredicates.named("enderecos").and(FieldPredicates.inClass(Funcionario.class)), () -> randomEnderecosValidos())
                .randomize(FieldPredicates.named("conta").and(FieldPredicates.inClass(Funcionario.class)), () -> randomContaValida());
        return funcionarioValido;
    }
    
    public static EasyRandomParameters funcionarioInvalido() {
        EasyRandomParameters funcionarioInvalido = new EasyRandomParameters()
                .randomize(FieldPredicates.named("codigo").and(FieldPredicates.inClass(Funcionario.class)), () -> randomCodigoInvalido())
                .randomize(FieldPredicates.named("nome").and(FieldPredicates.inClass(Funcionario.class)), () -> randomNomeInvalido())
                .randomize(FieldPredicates.named("nomeMae").and(FieldPredicates.inClass(Funcionario.class)), () -> randomNomeInvalido())
                .randomize(FieldPredicates.named("nomePai").and(FieldPredicates.inClass(Funcionario.class)), () -> randomNomeInvalido())
                .randomize(FieldPredicates.named("dataNascimento").and(FieldPredicates.inClass(Funcionario.class)), () -> randomDataInvalida())
                .randomize(FieldPredicates.named("cpf").and(FieldPredicates.inClass(Funcionario.class)), () -> randomCpfInvalido())
                .randomize(FieldPredicates.named("sexo").and(FieldPredicates.inClass(Funcionario.class)), () -> randomSexoValido())
                .randomize(FieldPredicates.named("horario").and(FieldPredicates.inClass(Funcionario.class)), () -> randomHorario())
                .randomize(FieldPredicates.named("salario").and(FieldPredicates.inClass(Funcionario.class)), () -> randomSalarioInvalido())
                .randomize(FieldPredicates.named("enderecos").and(FieldPredicates.inClass(Funcionario.class)), () -> randomEnderecosValidos())
                .randomize(FieldPredicates.named("conta").and(FieldPredicates.inClass(Funcionario.class)), () -> randomContaValida());
        return funcionarioInvalido;
    }
}
