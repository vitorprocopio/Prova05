package br.com.contmatic.empresa;

import java.time.LocalDate;

import br.com.contmatic.endereco.Endereco;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EmpresaTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Empresa.class).addTemplate("valido", new Rule() {
            {
                add("codigo", random("123", "0009", "99999", "4321", "1", "095", "0000"));
                add("nome", name());
                add("nomeFantasia", name());
                add("RazaoSocial", name());
                add("cnpj", cnpj());
                add("endereco", one(Endereco.class, "valid"));
            }
        });
        Fixture.of(Empresa.class).addTemplate("nomeInvalido").inherits("valido", new Rule() {
            {
                add("nome", random("@João", "#José", "Pedro 01", "Joan@", "Maria & Joaquim"));
            }
        });
        Fixture.of(Empresa.class).addTemplate("nomeMaeInvalido").inherits("valido", new Rule() {
            {
                add("nome", random("@João", "#José", "Pedro 01", "Joan@", "Maria & Joaquim"));
            }
        });
        Fixture.of(Empresa.class).addTemplate("nomePaiInvalido").inherits("valido", new Rule() {
            {
                add("nome", random("@João", "#José", "Pedro 01", "Joan@", "Maria & Joaquim"));
            }
        });
        Fixture.of(Empresa.class).addTemplate("dataNascimentoInvalido").inherits("valido", new Rule() {
            {
                add("dataNascimento", random(LocalDate.of(1889, 12, 31), LocalDate.of(2021, 12, 31), LocalDate.now(), LocalDate.now().plusDays(1)));
            }
        });
        Fixture.of(Empresa.class).addTemplate("cpfInvalido").inherits("valido", new Rule() {
            {
                add("cpf", random("0", "-1", "-99999", "-100000", "100000", "13084850001", "77831284835", "7783128483A", "Z7831284834", "@7783128483", "7783 284834"));
            }
        });
        Fixture.of(Empresa.class).addTemplate("enderecoInvalido").inherits("valido", new Rule() {
            {
                add("endereco", random("Bloco #01", "Apto. 201", "@Bloco A", "2º andar"));
            }
        });
    }

}
