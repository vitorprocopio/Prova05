package br.com.contmatic.contato;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

// TODO: Auto-generated Javadoc
/**
 * The Class ContatoTemplate.
 */
public class ContatoTemplate implements TemplateLoader {

    /**
     * Load.
     */
    @Override
    public void load() {
        Fixture.of(Contato.class).addTemplate("valido", new Rule() {
            {
                add("telefone", random("35995255", "28277152", "37602544", "38280822"));
                add("celular", random("996427678", "992789063", "991831949", "997169786"));
                add("recado", random("35995255", "28277152", "37602544", "38280822"));
                add("email", random("email123@contato.com", "email_123@contato.com.br", "email.123@contato.com", "485554@contato.com.br"));
            }
        });
        Fixture.of(Contato.class).addTemplate("telefoneInvalido").inherits("valido", new Rule() {
            {
                add("telefone", random("@1234567", "12 34567", "4321123#", "12&34567", "123456", "-1"));
            }
        });
        Fixture.of(Contato.class).addTemplate("celularInvalido").inherits("valido", new Rule() {
            {
                add("celular", random("@12345671", "12 345672", "34321123#", "412&34567", "123456", "-1"));
            }
        });
        Fixture.of(Contato.class).addTemplate("recadoInvalido").inherits("valido", new Rule() {
            {
                add("recado", random("@1234567", "12 34567", "4321123#", "12&34567", "123456", "-1"));
            }
        });
        Fixture.of(Contato.class).addTemplate("emailInvalido").inherits("valido", new Rule() {
            {
                add("email", random("@1234567", "@contato.com", "432 1123@contato.com", "12&34567contato.com", "123456#contato.com", "-1", "email123"));
            }
        });

    }
}
