package br.com.contmatic.empresa;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;

import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.endereco.EnderecoTemplate;
import br.com.contmatic.validacao.GeraCnpj;

// TODO: Auto-generated Javadoc
/**
 * The Class EmpresaTemplate.
 */
public class EmpresaTemplate {

    /** The enderecos. */
    private static Set<Endereco> enderecos = new HashSet<>();
    
//    public static Integer randomCodigoValido() {
//        Random aleatorio = new Random();
//        int codigo = aleatorio.nextInt(99999) + 1;
//        return codigo;
//    }
    
    public static String randomCodigoValido() {
        return RandomStringUtils.randomNumeric(1, 5);
    }
    
    public static String randomCodigoInvalido() {
        return RandomStringUtils.randomAlphanumeric(6, 10);
    }

    public static String randomCnpjValido() {
        String cnpjValido = GeraCnpj.geraCnpj();
        return cnpjValido;
        }
    
    public static String randomCnpjInvalido() {
        return RandomStringUtils.randomAlphanumeric(1, 15);
    }
    
    public static String randomNomeFantasiaValido() {
        return RandomStringUtils.randomAlphanumeric(3, 51);
    }
    
    public static String randomRazaoSocialValida() {
        return RandomStringUtils.randomAlphanumeric(3, 51);
    }
    
    public static String randomAlfanumericoMais50() {
        return RandomStringUtils.randomAlphanumeric(52, 60);
    }
    
    public static Set<Endereco> randomEnderecosValidos() {
        for(int i = 0 ; i < 5 ; i++) {
            EasyRandom enderecoValido = new EasyRandom(EnderecoTemplate.enderecoValido());
            enderecos.add(enderecoValido.nextObject(Endereco.class));
        }
        return enderecos;
    }
    
    public static EasyRandomParameters empresaValida() {
        EasyRandomParameters empresaValida = new EasyRandomParameters()
                .randomize(FieldPredicates.named("codigo").and(FieldPredicates.inClass(Empresa.class)), () -> randomCodigoValido())
                .randomize(FieldPredicates.named("cnpj").and(FieldPredicates.inClass(Empresa.class)), () -> randomCnpjValido())
                .randomize(FieldPredicates.named("nomeFantasia").and(FieldPredicates.inClass(Empresa.class)), () -> randomNomeFantasiaValido())
                .randomize(FieldPredicates.named("razaoSocial").and(FieldPredicates.inClass(Empresa.class)), () -> randomRazaoSocialValida())
                .randomize(FieldPredicates.named("enderecos").and(FieldPredicates.inClass(Empresa.class)), () -> randomEnderecosValidos());
        return empresaValida;
    }
    
    public static EasyRandomParameters empresaInvalida() {
        EasyRandomParameters empresaInvalida = new EasyRandomParameters()
                .randomize(FieldPredicates.named("codigo").and(FieldPredicates.inClass(Empresa.class)), () -> randomCodigoInvalido())
                .randomize(FieldPredicates.named("cnpj").and(FieldPredicates.inClass(Empresa.class)), () -> randomCnpjInvalido())
                .randomize(FieldPredicates.named("nomeFantasia").and(FieldPredicates.inClass(Empresa.class)), () -> randomAlfanumericoMais50())
                .randomize(FieldPredicates.named("razaoSocial").and(FieldPredicates.inClass(Empresa.class)), () -> randomAlfanumericoMais50())
                .randomize(FieldPredicates.named("enderecos").and(FieldPredicates.inClass(Empresa.class)), () -> randomEnderecosValidos());
        return empresaInvalida;
    }

    /**
     * Load.
     */
//    @Override
//    public void load() {
//
//        new EnderecoTemplate().load();
//
//        for(int i = 0 ; i < 5 ; i++) {
//            enderecos.add(Fixture.from(Endereco.class).gimme("valido"));
//        }
//        Fixture.of(Empresa.class).addTemplate("valido", new Rule() {
//            {
//                add("codigo", random("123", "0009", "99999", "4321", "1", "095", "0000"));
//                add("nomeFantasia", name());
//                add("razaoSocial", name());
//                add("cnpj", cnpj());
//                add("enderecos", enderecos);
//            }
//        });
//        Fixture.of(Empresa.class).addTemplate("codigoInvalido").inherits("valido", new Rule() {
//            {
//                add("codigo", random("@1234", "12 34", "Cod01", "4321#", "12&34", "123456", "-1"));
//            }
//        });
//        Fixture.of(Empresa.class).addTemplate("cnpjInvalido").inherits("valido", new Rule() {
//            {
//                add("cnpj", random("0", "-1", "-99999", "-100000", "100000", "13084850001234", "77831284835875", "7783128483111A", "Z7834781284834", "@7736483128483", "7749683 284834"));
//            }
//        });
//        Fixture.of(Empresa.class).addTemplate("razaoSocialInvalido").inherits("valido", new Rule() {
//            {
//                add("razaoSocial", random("", "   ", " Pedro 01", "Maria & Joaquim "));
//            }
//        });
//        Fixture.of(Empresa.class).addTemplate("nomeFantasiaInvalido").inherits("valido", new Rule() {
//            {
//                add("nomeFantasia", random("", "   ", " Pedro 01", "Maria & Joaquim "));
//            }
//        });
//    }

}
