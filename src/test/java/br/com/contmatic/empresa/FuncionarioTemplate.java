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

    // /** The conta 1. */
    // ContaBancaria conta1 = new ContaBancaria("João", "123", "4567");
    //
    // /** The conta 2. */
    // ContaBancaria conta2 = new ContaBancaria("José", "321", "7654");
    //
    // /** The horario 1. */
    // Horario horario1 = new Horario(new LocalTime(9, 00, 00), new LocalTime(12, 00, 00), new LocalTime(13, 00, 00), new LocalTime(18, 00, 00));
    //
    // /** The horario 2. */
    // Horario horario2 = new Horario(new LocalTime(7, 00, 00), new LocalTime(11, 00, 00), new LocalTime(12, 00, 00), new LocalTime(16, 00, 00));;
    //
    // /** The enderecos. */
    // Set<Endereco> enderecos = new HashSet<>();
    //
    // /** The endereco 1. */
    // Endereco endereco1 = new Endereco("01234567", "Rua 1 de Abril", 1, "Bloco 1 Apto 102", "Bairro Um", "São Paulo", Estado.SP, "Brasil");
    //
    // /** The endereco 2. */
    // Endereco endereco2 = new Endereco("03315000", "Rua Padre Estevão Pernet", 215, null, "Tatuapé", "São Paulo", Estado.SP, "Brasil");

    /**
     * Load.
     */
    // @Override
    // public void load() {
    // new EnderecoTemplate().load();
    //
    // for(int i = 0 ; i < 5 ; i++) {
    // enderecos.add(Fixture.from(Endereco.class).gimme("valido"));
    // }
    // Fixture.of(Funcionario.class).addTemplate("valido", new Rule() {
    // {
    // add("nome", name());
    // add("nomeMae", name());
    // add("nomePai", name());
    // add("codigo", random("123", "1", "99998", "4321", "15900", "0"));
    // add("dataNascimento", random(new LocalDate(1970, 4, 6), new LocalDate(1986, 01, 06)));
    // add("cpf", random("87743097064", "19939474008", "99893313082", "27459389080"));
    // add("sexo", random(Genero.F, Genero.M, Genero.O));
    // add("salario", random(3500.77, 00.00, 497.00, 72412.00, 13457.99, 99999.99));
    // add("horario", random(horario1, horario2));
    // add("enderecos", enderecos);
    // add("conta", random(conta1, conta2));
    //
    // }
    // });
    // Fixture.of(Funcionario.class).addTemplate("codigoInvalido").inherits("valido", new Rule() {
    // {
    // add("codigo", random("@1234", "12 34", "Cod01", "4321#", "12&34", "123456", "-1"));
    // }
    // });
    // Fixture.of(Funcionario.class).addTemplate("nomeInvalido").inherits("valido", new Rule() {
    // {
    // add("nome", random("@João", "#José", "Pedro 01", "Joan@", "Maria & Joaquim"));
    // }
    // });
    // Fixture.of(Funcionario.class).addTemplate("dataNascimentoInvalido").inherits("valido", new Rule() {
    // {
    // add("dataNascimento", random(new LocalDate(1889, 12, 31), new LocalDate(2021, 12, 31), LocalDate.now(), LocalDate.now().plusDays(1)));
    // }
    // });
    // Fixture.of(Funcionario.class).addTemplate("cpfInvalido").inherits("valido", new Rule() {
    // {
    // add("cpf", random("", " ", " 13084850001", " 1308485001", "0", "-1", "-99999", "-100000", "100000", "13084850001", "77831284835", "7783128483A", "Z7831284834", "@7783128483",
    // "7783 284834"));
    // }
    // });
    // Fixture.of(Funcionario.class).addTemplate("salarioInvalido").inherits("valido", new Rule() {
    // {
    // add("salario", random(-1.00, -99999.00, 100000.00));
    // }
    // });
    // }
}
