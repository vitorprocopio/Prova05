package br.com.contmatic.endereco;

import br.com.contmatic.enums.Estado;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EnderecoTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Endereco.class).addTemplate("valido", new Rule() {
            {
                add("cep", random("035995255", "028277152", "137602544", "938280822"));
                add("rua", random("Rua Um", "Rua Dois", "Avenida Dez", "Rodovia Trezentos"));
                add("numero", random("3599", "28", "62544", "99999"));
                add("complemento", random("Bloco 01", "Apto 201", "Bloco A", "2 andar"));
                add("bairro", random("Bairro Um", "Bairro 23", "Jardim Alto", "Parque Baixo"));
                add("cidade", random("São Bernardo do Campo", "Osaco", "São Paulo", "Vitória"));
                add("estado", random(Estado.AC, Estado.SP, Estado.DF, Estado.MG));
                add("pais", random("Brasil", "EUA", "República Dominicana", "Congo"));
            }
        });
        Fixture.of(Endereco.class).addTemplate("cepInvalido").inherits("valido", new Rule() {
            {
                add("telefone", random("@1234567", "12 34567", "4321123#", "12&34567", "123456", "-1"));
            }
        });
        Fixture.of(Endereco.class).addTemplate("ruaInvalido").inherits("valido", new Rule() {
            {
                add("celular", random("@12345671", "12 345672", "34321123#", "412&34567", "123456", "-1"));
            }
        });
        Fixture.of(Endereco.class).addTemplate("numeroInvalido").inherits("valido", new Rule() {
            {
                add("recado", random("@1234567", "12 34567", "4321123#", "12&34567", "123456", "-1"));
            }
        });
        Fixture.of(Endereco.class).addTemplate("complementoInvalido").inherits("valido", new Rule() {
            {
                add("email", random("@1234567", "@contato.com", "432 1123@contato.com", "12&34567contato.com", "123456#contato.com", "-1", "email123"));
            }
        });
        Fixture.of(Endereco.class).addTemplate("bairroInvalido").inherits("valido", new Rule() {
            {
                add("telefone", random("@1234567", "12 34567", "4321123#", "12&34567", "123456", "-1"));
            }
        });
        Fixture.of(Endereco.class).addTemplate("cidadeInvalido").inherits("valido", new Rule() {
            {
                add("celular", random("@12345671", "12 345672", "34321123#", "412&34567", "123456", "-1"));
            }
        });
        Fixture.of(Endereco.class).addTemplate("paisInvalido").inherits("valido", new Rule() {
            {
                add("email", random("@1234567", "@contato.com", "432 1123@contato.com", "12&34567contato.com", "123456#contato.com", "-1", "email123"));
            }
        });

    }
}
