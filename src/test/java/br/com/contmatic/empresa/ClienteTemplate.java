package br.com.contmatic.empresa;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.LocalDate;

import br.com.contmatic.contato.Contato;
import br.com.contmatic.contato.ContatoTemplate;
import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.endereco.EnderecoTemplate;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ClienteTemplate implements TemplateLoader {

    Set<Contato> contatos = new HashSet<>();

    Set<Endereco> enderecos = new HashSet<>();

    @Override
    public void load() {
        new EnderecoTemplate().load();
        
        new ContatoTemplate().load();
        
        for(int i = 0 ; i < 5 ; i++) {
            enderecos.add(Fixture.from(Endereco.class).gimme("valido"));
        }
        for(int i = 0 ; i < 5 ; i++) {
            contatos.add(Fixture.from(Contato.class).gimme("valido"));
        }
        Fixture.of(Cliente.class).addTemplate("valido", new Rule() {
            {
                add("nome", name());
                add("codigo", random("123", "1", "99998", "4321", "15900", "0"));
                add("dataNascimento", random(new LocalDate(1970, 4, 6), new LocalDate(1986, 01, 06)));
                add("cpf", random("87743097064", "19939474008", "99893313082", "27459389080"));
                add("enderecos", enderecos);
                add("contatos", contatos);

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
                add("dataNascimento", random(new LocalDate(1889, 12, 31), new LocalDate(2021, 12, 31), LocalDate.now(), LocalDate.now().plusDays(1)));
            }
        });
        Fixture.of(Cliente.class).addTemplate("cpfInvalido").inherits("valido", new Rule() {
            {
                add("cpf", random("", "           ", " 13084850001", " 1308485001", "0", "-1", "-99999", "-100000", "100000", "13084850001", "77831284835", "7783128483A", "Z7831284834", "@7783128483",
                    "7783 284834"));
            }
        });
    }
}
