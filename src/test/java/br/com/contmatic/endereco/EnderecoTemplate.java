package br.com.contmatic.endereco;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;

import com.github.javafaker.Faker;

import br.com.contmatic.enums.Estado;

// TODO: Auto-generated Javadoc
/**
 * The Class EnderecoTemplate.
 */
public class EnderecoTemplate {

    public static String randomCepValido() {
        return RandomStringUtils.randomNumeric(8);
    }

    public static String randomCepInvalido() {
        return RandomStringUtils.randomAlphanumeric(1, 12);
    }

    public static String randomRuaValida() {
        Faker faker = new Faker();
        String rua = faker.address().streetName();
        return rua;
    }

    public static String randomRuaInvalida() {
        return RandomStringUtils.randomAlphanumeric(1, 40);
    }

    public static Integer randomNumeroValido() {
        Random aleatorio = new Random();
        int numero = aleatorio.nextInt(99999) + 1;
        return numero;
    }

    public static Integer randomNumeroInvalido() {
        Random aleatorio = new Random();
        int numero = aleatorio.nextInt(100000) + 1;
        return numero;
    }

    public static String randomAlfanumericoAte50() {
        return RandomStringUtils.randomAlphanumeric(2, 51);
    }
    
    public static String randomAlfanumericoMais50() {
        return RandomStringUtils.randomAlphanumeric(52, 60);
    }

    public static String randomCidadeValida() {
        Faker faker = new Faker();
        String cidade = faker.address().cityName();
        return cidade;
    }
    
    public static String randomCidadeInvalida() {
        return RandomStringUtils.randomAlphanumeric(1, 40);
    }

    public static Estado randomUfValido() {
        Estado ufValido = Estado.randomUF();
        return ufValido;
    }

    public static String randomPaisValido() {
        Faker faker = new Faker();
        String pais = faker.address().country();
        return pais;
    }
    
    public static String randomPaisInvalido() {
        return RandomStringUtils.randomAlphanumeric(1, 40);
    }

    public static EasyRandomParameters enderecoValido() {
        EasyRandomParameters enderecoValido = new EasyRandomParameters()
                .randomize(FieldPredicates.named("cep").and(FieldPredicates.inClass(Endereco.class)), () -> randomCepValido())
                .randomize(FieldPredicates.named("rua").and(FieldPredicates.inClass(Endereco.class)), () -> randomRuaValida())
                .randomize(FieldPredicates.named("numero").and(FieldPredicates.inClass(Endereco.class)), () -> randomNumeroValido())
                .randomize(FieldPredicates.named("complemento").and(FieldPredicates.inClass(Endereco.class)), () -> randomAlfanumericoAte50())
                .randomize(FieldPredicates.named("bairro").and(FieldPredicates.inClass(Endereco.class)), () -> randomAlfanumericoAte50())
                .randomize(FieldPredicates.named("cidade").and(FieldPredicates.inClass(Endereco.class)), () -> randomCidadeValida())
                .randomize(FieldPredicates.named("uf").and(FieldPredicates.inClass(Endereco.class)), () -> randomUfValido())
                .randomize(FieldPredicates.named("pais").and(FieldPredicates.inClass(Endereco.class)), () -> randomPaisValido());
        return enderecoValido;
    }
    
    public static EasyRandomParameters enderecoInvalido() {
        EasyRandomParameters enderecoInvalido = new EasyRandomParameters()
                .randomize(FieldPredicates.named("cep").and(FieldPredicates.inClass(Endereco.class)), () -> randomCepInvalido())
                .randomize(FieldPredicates.named("rua").and(FieldPredicates.inClass(Endereco.class)), () -> randomRuaInvalida())
                .randomize(FieldPredicates.named("numero").and(FieldPredicates.inClass(Endereco.class)), () -> randomNumeroInvalido())
                .randomize(FieldPredicates.named("complemento").and(FieldPredicates.inClass(Endereco.class)), () -> randomAlfanumericoMais50())
                .randomize(FieldPredicates.named("bairro").and(FieldPredicates.inClass(Endereco.class)), () -> randomAlfanumericoMais50())
                .randomize(FieldPredicates.named("cidade").and(FieldPredicates.inClass(Endereco.class)), () -> randomCidadeInvalida())
                .randomize(FieldPredicates.named("uf").and(FieldPredicates.inClass(Endereco.class)), () -> randomUfValido())
                .randomize(FieldPredicates.named("pais").and(FieldPredicates.inClass(Endereco.class)), () -> randomPaisInvalido());
        return enderecoInvalido;
    }

    // /**
    // * Load.
    // */
    // @Override
    // public void load() {
    // Fixture.of(Endereco.class).addTemplate("valido", new Rule() {
    // {
    // add("cep", random("35995255", "28277152", "37602544", "38280822"));
    // add("rua", random("Rua Um", "Rua Dois", "Avenida Dez", "Rodovia Trezentos"));
    // add("numero", random("3599", "28", "62544", "99999"));
    // add("complemento", random("Bloco 01", "Apto 201", "Bloco A", "2 andar"));
    // add("bairro", random("Bairro Um", "Bairro 23", "Jardim Alto", "Parque Baixo"));
    // add("cidade", random("São Bernardo do Campo", "Osaco", "São Paulo", "Vitória"));
    // add("uf", random(Estado.AC, Estado.SP, Estado.DF, Estado.MG));
    // add("pais", random("Brasil", "EUA", "República Dominicana", "Congo"));
    // }
    // });
    // Fixture.of(Endereco.class).addTemplate("cepInvalido").inherits("valido", new Rule() {
    // {
    // add("cep", random("@1234567", "12 34567", "4321123#", "12&34567", "123456", "-1"));
    // }
    // });
    // Fixture.of(Endereco.class).addTemplate("ruaInvalido").inherits("valido", new Rule() {
    // {
    // add("rua", random("Rua #Um", "@Rua Um", "Rua Costa & Silva", "", " Rua Um", " ", "Rua Um "));
    // }
    // });
    // Fixture.of(Endereco.class).addTemplate("numeroInvalido").inherits("valido", new Rule() {
    // {
    // add("numero", random(-1, 100000, -99000, -10, 150456));
    // }
    // });
    // Fixture.of(Endereco.class).addTemplate("complementoInvalido").inherits("valido", new Rule() {
    // {
    // add("complemento", random("Bloco #01", "Apto. 201", "@Bloco A", "2º andar"));
    // }
    // });
    // Fixture.of(Endereco.class).addTemplate("bairroInvalido").inherits("valido", new Rule() {
    // {
    // add("bairro", random("Bairro #Um", "@Bairro Um", "Bairro Costa & Silva", "", " Bairro Um", " ", "Bairro Um "));
    // }
    // });
    // Fixture.of(Endereco.class).addTemplate("cidadeInvalido").inherits("valido", new Rule() {
    // {
    // add("cidade", random("Cidade #Um", "@Cidade Um", "Cidade Costa & Silva", "", " Cidade Um", " ", "Cidade Um "));
    // }
    // });
    // Fixture.of(Endereco.class).addTemplate("paisInvalido").inherits("valido", new Rule() {
    // {
    // add("pais", random("País #Um", "@País Um", "País Costa & Silva", "", " País Um", " ", "País Um "));
    // }
    // });
    // }
}
