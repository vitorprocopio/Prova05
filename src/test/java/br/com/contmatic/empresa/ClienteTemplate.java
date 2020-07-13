package br.com.contmatic.empresa;

import java.time.LocalDate;

import br.com.contmatic.contato.Contato;
import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.enums.Estado;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ClienteTemplate implements TemplateLoader {

    Endereco endereco1 = new Endereco("01234567", "Rua 1 de Abril", 1, "Bloco 1 Apto 102", "Bairro Um", "São Paulo", Estado.SP, "Brasil");
    Endereco endereco2 = new Endereco("03315000", "Rua Padre Estevão Pernet", 215, null, "Tatuapé", "São Paulo", Estado.SP, "Brasil");
    Contato contato1 = new Contato("12345678", "987654321", "123456789", "email_1@contato.com.br");
    Contato contato2 = new Contato("12345679", "987654322", "223456789", "email_2@contato.com.br");

    @Override
    public void load() {
        Fixture.of(Cliente.class).addTemplate("valido", new Rule() {
            {
                add("nome", name());
                add("codigo", random("123", "1", "99998", "4321", "15900", "0"));
                add("dataNascimento", random(LocalDate.of(1970, 4, 6), LocalDate.of(1986, 01, 06)));
                add("cpf", random("87743097064", "19939474008", "99893313082", "27459389080"));
                add("endereco", random(endereco1, endereco2));
                add("contato", random(contato1, contato2));

            }
        });
        Fixture.of(Cliente.class).addTemplate("codigoInvalido").inherits("valido", new Rule() {
            {
                add("codigo", random("@1234", "12 34", "Cod01", "4321#", "12&34", "123456", "-1"));
            }
        });
        Fixture.of(Cliente.class).addTemplate("nomeInvalido").inherits("valido", new Rule() {
            {
                add("nome", random("@João", "#José", "Pedro 01", "Joan@", "Maria & Joaquim"));
            }
        });
        Fixture.of(Cliente.class).addTemplate("dataNascimentoInvalido").inherits("valido", new Rule() {
            {
                add("dataNascimento", random(LocalDate.of(1889, 12, 31), LocalDate.of(2021, 12, 31), LocalDate.now(), LocalDate.now().plusDays(1)));
            }
        });
        Fixture.of(Cliente.class).addTemplate("cpfInvalido").inherits("valido", new Rule() {
            {
                add("cpf", random("", "           ", " 13084850001", " 1308485001", "0", "-1", "-99999", "-100000", "100000", "13084850001", "77831284835", "7783128483A", "Z7831284834", "@7783128483", "7783 284834"));
            }
        });
    }
}
