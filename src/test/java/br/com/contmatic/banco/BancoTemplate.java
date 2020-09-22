package br.com.contmatic.banco;

import org.apache.commons.lang3.RandomStringUtils;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;

import com.github.javafaker.Faker;

// TODO: Auto-generated Javadoc
/**
 * The Class BancoTemplate.
 */
public class BancoTemplate {

    public static String randomAgenciaValida() {
        return RandomStringUtils.randomNumeric(4);
    }

    public static String randomAgenciaInvalida() {
        return RandomStringUtils.randomAlphanumeric(5, 7);
    }

    public static String randomNumeroValido() {
        return RandomStringUtils.randomNumeric(1, 20);
    }

    public static String randomNumeroInvalido() {
        return RandomStringUtils.randomNumeric(21, 24);
    }

    public static String randomTitularValido() {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        return name + firstName + lastName;
    }

    public static String randomTitularInvalido() {
        return RandomStringUtils.randomAlphanumeric(101, 105);
    }

    public static EasyRandomParameters contaValida() {
        EasyRandomParameters contaValida = new EasyRandomParameters()
                .randomize(FieldPredicates.named("agencia").and(FieldPredicates.inClass(ContaBancaria.class)), () -> randomAgenciaValida())
                .randomize(FieldPredicates.named("numero").and(FieldPredicates.inClass(ContaBancaria.class)), () -> randomNumeroValido())
                .randomize(FieldPredicates.named("titular").and(FieldPredicates.inClass(ContaBancaria.class)), () -> randomTitularValido());
        return contaValida;
    }

    public static EasyRandomParameters contaInvalida() {
        EasyRandomParameters contaInvalida = new EasyRandomParameters()
                .randomize(FieldPredicates.named("agencia").and(FieldPredicates.inClass(ContaBancaria.class)), () -> randomAgenciaInvalida())
                .randomize(FieldPredicates.named("numero").and(FieldPredicates.inClass(ContaBancaria.class)), () -> randomNumeroInvalido())
                .randomize(FieldPredicates.named("titular").and(FieldPredicates.inClass(ContaBancaria.class)), () -> randomTitularInvalido());
        return contaInvalida;
    }

    /**
     * Load.
     */
    // @Override
    // public void load() {
    // Fixture.of(ContaBancaria.class).addTemplate("valido", new Rule() {
    // {
    // add("titular", name());
    // add("numero", random("123", "1", "99998", "4321", "000123456789", "15900"));
    // add("agencia", random("1234", "0009", "9999", "4321", "0001", "0951", "0000"));
    // }
    // });
    // Fixture.of(ContaBancaria.class).addTemplate("titularInvalido").inherits("valido", new Rule() {
    // {
    // add("titular", random("@João", "#José", "Pedro 01", "Joan@", "Maria & Joaquim"));
    // }
    // });
    // Fixture.of(ContaBancaria.class).addTemplate("numeroInvalido").inherits("valido", new Rule() {
    // {
    // add("numero", random("@João", "#José", "Pedro 01", "Joan@", "Maria & Joaquim"));
    // }
    // });
    // Fixture.of(ContaBancaria.class).addTemplate("agenciaInvalido").inherits("valido", new Rule() {
    // {
    // add("agencia", random("@João", "#José", "Pedro 01", "Joan@", "Maria & Joaquim"));
    // }
    // });

}
