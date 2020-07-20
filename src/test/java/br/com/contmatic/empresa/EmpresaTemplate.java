package br.com.contmatic.empresa;

import java.util.HashSet;
import java.util.Set;

import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.endereco.EnderecoTemplate;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

// TODO: Auto-generated Javadoc
/**
 * The Class EmpresaTemplate.
 */
public class EmpresaTemplate implements TemplateLoader {

    /** The enderecos. */
    Set<Endereco> enderecos = new HashSet<>();

    /**
     * Load.
     */
    @Override
    public void load() {

        new EnderecoTemplate().load();

        for(int i = 0 ; i < 5 ; i++) {
            enderecos.add(Fixture.from(Endereco.class).gimme("valido"));
        }
        Fixture.of(Empresa.class).addTemplate("valido", new Rule() {
            {
                add("codigo", random("123", "0009", "99999", "4321", "1", "095", "0000"));
                add("nomeFantasia", name());
                add("razaoSocial", name());
                add("cnpj", cnpj());
                add("enderecos", enderecos);
                // add("endereco", one(Endereco.class, "valido"));
            }
        });
        Fixture.of(Empresa.class).addTemplate("codigoInvalido").inherits("valido", new Rule() {
            {
                add("codigo", random("@1234", "12 34", "Cod01", "4321#", "12&34", "123456", "-1"));
            }
        });
        Fixture.of(Empresa.class).addTemplate("cnpjInvalido").inherits("valido", new Rule() {
            {
                add("cnpj", random("0", "-1", "-99999", "-100000", "100000", "13084850001234", "77831284835875", "7783128483111A", "Z7834781284834", "@7736483128483", "7749683 284834"));
            }
        });
        Fixture.of(Empresa.class).addTemplate("razaoSocialInvalido").inherits("valido", new Rule() {
            {
                add("razaoSocial", random("", "   ", " Pedro 01", "Maria & Joaquim "));
            }
        });
        Fixture.of(Empresa.class).addTemplate("nomeFantasiaInvalido").inherits("valido", new Rule() {
            {
                add("nomeFantasia", random("", "   ", " Pedro 01", "Maria & Joaquim "));
            }
        });
    }

}
