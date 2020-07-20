package br.com.contmatic.empresa;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import br.com.contmatic.banco.ContaBancaria;
import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.endereco.EnderecoTemplate;
import br.com.contmatic.enums.Estado;
import br.com.contmatic.enums.Genero;
import br.com.contmatic.hora.Horario;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

// TODO: Auto-generated Javadoc
/**
 * The Class FuncionarioTemplate.
 */
public class FuncionarioTemplate implements TemplateLoader {

    /** The conta 1. */
    ContaBancaria conta1 = new ContaBancaria("João", "123", "4567");
    
    /** The conta 2. */
    ContaBancaria conta2 = new ContaBancaria("José", "321", "7654");
    
    /** The horario 1. */
    Horario horario1 = new Horario (new LocalTime(9, 00, 00), new LocalTime(12, 00, 00), new LocalTime(13, 00, 00), new LocalTime(18, 00, 00));
    
    /** The horario 2. */
    Horario horario2 = new Horario (new LocalTime(7, 00, 00), new LocalTime(11, 00, 00), new LocalTime(12, 00, 00), new LocalTime(16, 00, 00));;

    /** The enderecos. */
    Set<Endereco> enderecos = new HashSet<>();
    
    /** The endereco 1. */
    Endereco endereco1 = new Endereco("01234567", "Rua 1 de Abril", 1, "Bloco 1 Apto 102", "Bairro Um", "São Paulo", Estado.SP, "Brasil");
    
    /** The endereco 2. */
    Endereco endereco2 = new Endereco ("03315000", "Rua Padre Estevão Pernet", 215, null, "Tatuapé", "São Paulo", Estado.SP, "Brasil");
    
    /**
     * Load.
     */
    @Override
    public void load() {
        new EnderecoTemplate().load();

        for(int i = 0 ; i < 5 ; i++) {
            enderecos.add(Fixture.from(Endereco.class).gimme("valido"));
        }
        Fixture.of(Funcionario.class).addTemplate("valido", new Rule() {
            {
                add("nome", name());
                add("nomeMae", name());
                add("nomePai", name());
                add("codigo", random("123", "1", "99998", "4321", "15900", "0"));
                add("dataNascimento", random(new LocalDate(1970, 4, 6), new LocalDate(1986, 01, 06)));
                add("cpf", random("87743097064", "19939474008", "99893313082", "27459389080"));
                add("sexo", random(Genero.F, Genero.M, Genero.O));
                add("salario", random(3500.77, 00.00, 497.00, 72412.00, 13457.99, 99999.99));
                add("horario", random(horario1, horario2));
                add("enderecos", enderecos);
                add("conta", random(conta1, conta2));

            }
        });
        Fixture.of(Funcionario.class).addTemplate("codigoInvalido").inherits("valido", new Rule() {
            {
                add("codigo", random("@1234", "12 34", "Cod01", "4321#", "12&34", "123456", "-1"));
            }
        });
        Fixture.of(Funcionario.class).addTemplate("nomeInvalido").inherits("valido", new Rule() {
            {
                add("nome", random("@João", "#José", "Pedro 01", "Joan@", "Maria & Joaquim"));
            }
        });
        Fixture.of(Funcionario.class).addTemplate("dataNascimentoInvalido").inherits("valido", new Rule() {
            {
                add("dataNascimento", random(new LocalDate(1889, 12, 31), new LocalDate(2021, 12, 31), LocalDate.now(), LocalDate.now().plusDays(1)));
            }
        });
        Fixture.of(Funcionario.class).addTemplate("cpfInvalido").inherits("valido", new Rule() {
            {
                add("cpf", random("", "           ", " 13084850001", " 1308485001", "0", "-1", "-99999", "-100000", "100000", "13084850001", "77831284835", "7783128483A", "Z7831284834", "@7783128483", "7783 284834"));
            }
        });
        Fixture.of(Funcionario.class).addTemplate("salarioInvalido").inherits("valido", new Rule() {
            {
                add("salario", random(-1.00, -99999.00, 100000.00));
            }
        });
    }
}
