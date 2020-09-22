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

import br.com.contmatic.contato.Contato;
import br.com.contmatic.contato.ContatoTemplate;
import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.endereco.EnderecoTemplate;
import br.com.contmatic.validacao.GeraCpf;

// TODO: Auto-generated Javadoc
/**
 * The Class ClienteTemplate.
 */
public class ClienteTemplate {

    /** The contatos. */
    private static Set<Contato> contatos = new HashSet<>();

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

    public static LocalDate randomDataValida() {
        return LocalDate.now().minus(Period.days((new Random().nextInt(365 * 70))));
    }
    
    public static LocalDate randomDataInvalida() {
        return LocalDate.now().plus(Period.days((new Random().nextInt(365 * 70))));
    }

    public static Set<Endereco> randomEnderecosValidos() {
        for(int i = 0 ; i < 3 ; i++) {
            EasyRandom enderecoValido = new EasyRandom(EnderecoTemplate.enderecoValido());
            enderecos.add(enderecoValido.nextObject(Endereco.class));
        }
        return enderecos;
    }

    public static Set<Contato> randomContatosValidos() {
        for(int i = 0 ; i < 3 ; i++) {
            EasyRandom contatoValido = new EasyRandom(ContatoTemplate.contatoValido());
            contatos.add(contatoValido.nextObject(Contato.class));
        }
        return contatos;
    }

    public static EasyRandomParameters clienteValido() {
        EasyRandomParameters clienteValido = new EasyRandomParameters()
                .randomize(FieldPredicates.named("codigo").and(FieldPredicates.inClass(Cliente.class)), () -> randomCodigoValido())
                .randomize(FieldPredicates.named("nome").and(FieldPredicates.inClass(Cliente.class)), () -> randomNomeValido())
                .randomize(FieldPredicates.named("dataNascimento").and(FieldPredicates.inClass(Cliente.class)), () -> randomDataValida())
                .randomize(FieldPredicates.named("cpf").and(FieldPredicates.inClass(Cliente.class)), () -> randomCpfValido())
                .randomize(FieldPredicates.named("enderecos").and(FieldPredicates.inClass(Cliente.class)), () -> randomEnderecosValidos())
                .randomize(FieldPredicates.named("contatos").and(FieldPredicates.inClass(Cliente.class)), () -> randomContatosValidos());
        return clienteValido;
    }
    
    public static EasyRandomParameters clienteInvalido() {
        EasyRandomParameters clienteInvalido = new EasyRandomParameters()
                .randomize(FieldPredicates.named("codigo").and(FieldPredicates.inClass(Cliente.class)), () -> randomCodigoInvalido())
                .randomize(FieldPredicates.named("nome").and(FieldPredicates.inClass(Cliente.class)), () -> randomNomeInvalido())
                .randomize(FieldPredicates.named("dataNascimento").and(FieldPredicates.inClass(Cliente.class)), () -> randomDataInvalida())
                .randomize(FieldPredicates.named("cpf").and(FieldPredicates.inClass(Cliente.class)), () -> randomCpfInvalido())
                .randomize(FieldPredicates.named("enderecos").and(FieldPredicates.inClass(Cliente.class)), () -> randomEnderecosValidos())
                .randomize(FieldPredicates.named("contatos").and(FieldPredicates.inClass(Cliente.class)), () -> randomContatosValidos());
        return clienteInvalido;
    }

    // /**
    // * Load.
    // */
    // @Override
    // public void load() {
    // new EnderecoTemplate().load();
    //
    //// new ContatoTemplate().load();
    //
    // for(int i = 0 ; i < 5 ; i++) {
    // enderecos.add(Fixture.from(Endereco.class).gimme("valido"));
    // }
    // for(int i = 0 ; i < 5 ; i++) {
    // contatos.add(Fixture.from(Contato.class).gimme("valido"));
    // }
    // Fixture.of(Cliente.class).addTemplate("valido", new Rule() {
    // {
    // add("nome", name());
    // add("codigo", random("123", "1", "99998", "4321", "15900", "0"));
    // add("dataNascimento", random(new LocalDate(1970, 4, 6), new LocalDate(1986, 01, 06)));
    // add("cpf", random("87743097064", "19939474008", "99893313082", "27459389080"));
    // add("enderecos", enderecos);
    // add("contatos", contatos);
    // }
    // });
    // Fixture.of(Cliente.class).addTemplate("codigoInvalido").inherits("valido", new Rule() {
    // {
    // add("codigo", random("@1234", "12 34", "Cod01", "4321#", "12&34", "123456", "-1"));
    // }
    // });
    // Fixture.of(Cliente.class).addTemplate("nomeInvalido").inherits("valido", new Rule() {
    // {
    // add("nome", random("@João", "#José", "Pedro 01", "Joan@", "Maria & Joaquim"));
    // }
    // });
    // Fixture.of(Cliente.class).addTemplate("dataNascimentoInvalido").inherits("valido", new Rule() {
    // {
    // add("dataNascimento", random(new LocalDate(1889, 12, 31), new LocalDate(2021, 12, 31), LocalDate.now(), LocalDate.now().plusDays(1)));
    // }
    // });
    // Fixture.of(Cliente.class).addTemplate("cpfInvalido").inherits("valido", new Rule() {
    // {
    // add("cpf", random("", " ", " 13084850001", " 1308485001", "0", "-1", "-99999", "-100000", "100000", "13084850001", "77831284835", "7783128483A", "Z7831284834", "@7783128483",
    // "7783 284834"));
    // }
    // });
    // }
}
