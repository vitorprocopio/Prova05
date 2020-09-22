package br.com.contmatic.contato;

import org.apache.commons.lang3.RandomStringUtils;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;

import com.github.javafaker.Faker;

// TODO: Auto-generated Javadoc
/**
 * The Class ContatoTemplate.
 */
public class ContatoTemplate {
    
    public static String randomTelefoneValido() {
        return RandomStringUtils.randomNumeric(8);
    }
    
    public static String randomTelefoneInvalido() {
        return RandomStringUtils.randomAlphanumeric(1, 11);
    }
    
    public static String randomCelularValido() {
        return RandomStringUtils.randomNumeric(9);
    }
    
    public static String randomCelularInvalido() {
        return RandomStringUtils.randomAlphanumeric(1, 12);
    }
    
    public static String randomNumeroValido() {
        return RandomStringUtils.randomNumeric(1, 20);
    }
    
    public static String randomNumeroInvalido() {
        return RandomStringUtils.randomAlphanumeric(1, 23);
    }
    
    public static String randomEmailValido() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        return email;
    }
    
    public static String randomEmailInvalido() {
        return RandomStringUtils.randomAlphanumeric(1, 40);
    }
    
    public static EasyRandomParameters contatoValido() {
        EasyRandomParameters contatoValido = new EasyRandomParameters()
                .randomize(FieldPredicates.named("telefone").and(FieldPredicates.inClass(Contato.class)), () -> randomTelefoneValido())
                .randomize(FieldPredicates.named("celular").and(FieldPredicates.inClass(Contato.class)), () -> randomCelularValido())
                .randomize(FieldPredicates.named("recado").and(FieldPredicates.inClass(Contato.class)), () -> randomTelefoneValido())
                .randomize(FieldPredicates.named("email").and(FieldPredicates.inClass(Contato.class)), () -> randomEmailValido());
        return contatoValido;
    }
    
    public static EasyRandomParameters contatoInvalido() {
        EasyRandomParameters contatoInvalido = new EasyRandomParameters()
                .randomize(FieldPredicates.named("telefone").and(FieldPredicates.inClass(Contato.class)), () -> randomTelefoneInvalido())
                .randomize(FieldPredicates.named("celular").and(FieldPredicates.inClass(Contato.class)), () -> randomCelularInvalido())
                .randomize(FieldPredicates.named("recado").and(FieldPredicates.inClass(Contato.class)), () -> randomTelefoneInvalido())
                .randomize(FieldPredicates.named("email").and(FieldPredicates.inClass(Contato.class)), () -> randomEmailInvalido());
        return contatoInvalido;
    }

    /**
     * Load.
     */
//    @Override
//    public void load() {
//        Fixture.of(Contato.class).addTemplate("valido", new Rule() {
//            {
//                add("telefone", random("35995255", "28277152", "37602544", "38280822"));
//                add("celular", random("996427678", "992789063", "991831949", "997169786"));
//                add("recado", random("35995255", "28277152", "37602544", "38280822"));
//                add("email", random("email123@contato.com", "email_123@contato.com.br", "email.123@contato.com", "485554@contato.com.br"));
//            }
//        });
//        Fixture.of(Contato.class).addTemplate("telefoneInvalido").inherits("valido", new Rule() {
//            {
//                add("telefone", random("@1234567", "12 34567", "4321123#", "12&34567", "123456", "-1"));
//            }
//        });
//        Fixture.of(Contato.class).addTemplate("celularInvalido").inherits("valido", new Rule() {
//            {
//                add("celular", random("@12345671", "12 345672", "34321123#", "412&34567", "123456", "-1"));
//            }
//        });
//        Fixture.of(Contato.class).addTemplate("recadoInvalido").inherits("valido", new Rule() {
//            {
//                add("recado", random("@1234567", "12 34567", "4321123#", "12&34567", "123456", "-1"));
//            }
//        });
//        Fixture.of(Contato.class).addTemplate("emailInvalido").inherits("valido", new Rule() {
//            {
//                add("email", random("@1234567", "@contato.com", "432 1123@contato.com", "12&34567contato.com", "123456#contato.com", "-1", "email123"));
//            }
//        });
//
//    }
}
