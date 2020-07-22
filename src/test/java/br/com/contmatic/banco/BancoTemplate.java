package br.com.contmatic.banco;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

// TODO: Auto-generated Javadoc
/**
 * The Class BancoTemplate.
 */
public class BancoTemplate implements TemplateLoader {

    /**
     * Load.
     */
    @Override
    public void load() {
        Fixture.of(ContaBancaria.class).addTemplate("valido", new Rule() {
            {
                add("titular", name());
                add("numero", random("123", "1", "99998", "4321", "000123456789", "15900"));
                add("agencia", random("1234", "0009", "9999", "4321", "0001", "0951", "0000"));
            }
        });
        Fixture.of(ContaBancaria.class).addTemplate("titularInvalido").inherits("valido", new Rule() {
            {
                add("titular", random("@João", "#José", "Pedro 01", "Joan@", "Maria & Joaquim"));
            }
        });
        Fixture.of(ContaBancaria.class).addTemplate("numeroInvalido").inherits("valido", new Rule() {
            {
                add("numero", random("@João", "#José", "Pedro 01", "Joan@", "Maria & Joaquim"));
            }
        });
        Fixture.of(ContaBancaria.class).addTemplate("agenciaInvalido").inherits("valido", new Rule() {
            {
                add("agencia", random("@João", "#José", "Pedro 01", "Joan@", "Maria & Joaquim"));
            }
        });

    }
}
