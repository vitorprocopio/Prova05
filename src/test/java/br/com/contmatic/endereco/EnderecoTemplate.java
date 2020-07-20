package br.com.contmatic.endereco;

import br.com.contmatic.enums.Estado;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

// TODO: Auto-generated Javadoc
/**
 * The Class EnderecoTemplate.
 */
public class EnderecoTemplate implements TemplateLoader {

    /**
     * Load.
     */
    @Override
    public void load() {
        Fixture.of(Endereco.class).addTemplate("valido", new Rule() {
            {
                add("cep", random("35995255", "28277152", "37602544", "38280822"));
                add("rua", random("Rua Um", "Rua Dois", "Avenida Dez", "Rodovia Trezentos"));
                add("numero", random("3599", "28", "62544", "99999"));
                add("complemento", random("Bloco 01", "Apto 201", "Bloco A", "2 andar"));
                add("bairro", random("Bairro Um", "Bairro 23", "Jardim Alto", "Parque Baixo"));
                add("cidade", random("São Bernardo do Campo", "Osaco", "São Paulo", "Vitória"));
                add("uf", random(Estado.AC, Estado.SP, Estado.DF, Estado.MG));
                add("pais", random("Brasil", "EUA", "República Dominicana", "Congo"));
            }
        });
        Fixture.of(Endereco.class).addTemplate("cepInvalido").inherits("valido", new Rule() {
            {
                add("cep", random("@1234567", "12 34567", "4321123#", "12&34567", "123456", "-1"));
            }
        });
        Fixture.of(Endereco.class).addTemplate("ruaInvalido").inherits("valido", new Rule() {
            {
                add("rua", random("Rua #Um", "@Rua Um", "Rua Costa & Silva", "", " Rua Um", " ", "Rua Um "));
            }
        });
        Fixture.of(Endereco.class).addTemplate("numeroInvalido").inherits("valido", new Rule() {
            {
                add("numero", random(-1, 100000, -99000, -10, 150456));
            }
        });
        Fixture.of(Endereco.class).addTemplate("complementoInvalido").inherits("valido", new Rule() {
            {
                add("complemento", random("Bloco #01", "Apto. 201", "@Bloco A", "2º andar"));
            }
        });
        Fixture.of(Endereco.class).addTemplate("bairroInvalido").inherits("valido", new Rule() {
            {
                add("bairro", random("Bairro #Um", "@Bairro Um", "Bairro Costa & Silva", "", " Bairro Um", " ", "Bairro Um "));
            }
        });
        Fixture.of(Endereco.class).addTemplate("cidadeInvalido").inherits("valido", new Rule() {
            {
                add("cidade", random("Cidade #Um", "@Cidade Um", "Cidade Costa & Silva", "", " Cidade Um", " ", "Cidade Um "));
            }
        });
        Fixture.of(Endereco.class).addTemplate("paisInvalido").inherits("valido", new Rule() {
            {
                add("pais", random("País #Um", "@País Um", "País Costa & Silva", "", " País Um", " ", "País Um "));
            }
        });
    }
}
