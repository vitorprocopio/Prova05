package br.com.contmatic.empresa;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.six2six.fixturefactory.Fixture;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ClienteTest {

    private Cliente cliente;

    // @Before
    // public void init() {
    // contato = new Contato("12345678", "987654321", "123456789", "email@contato.com.br");
    // endereco = new Endereco("01234567", "Rua 1 de Abril", 1, "Bloco 1 Apto 102", "Bairro Um", "São Paulo", Estado.SP, "Brasil");
    // data = LocalDate.of(1970, 4, 6);
    // cliente = new Cliente("101", "Ana Maria", data, "12345678909", endereco, contato);
    // }

    @BeforeClass
    public static void load() {
        new ClienteTemplate().load();
    }

    @Before
    public void init() {
        cliente = Fixture.from(Cliente.class).gimme("valido");
    }

    @Test
    public void nao_deve_aceitar_codigo_invalido() {
        cliente.getCodigo();
        assertFalse(ValidaCliente.valida(Fixture.from(Cliente.class).gimme("codigoInvalido")));
    }
    
    @Test
    public void nao_deve_aceitar_codigo_nulo() {
        cliente.setCodigo(null);
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_codigo_em_branco() {
        cliente.setCodigo("   ");
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_codigo_vazio() {
        cliente.setCodigo("");
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_codigo_com_mais_de_cinco_digitos() {
        cliente.setCodigo("100000");
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_codigo_com_letras() {
        cliente.setCodigo("123a");
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_codigo_com_caracteres_especiais() {
        cliente.setCodigo("1234@");
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_codigo_com_espacos() {
        cliente.setCodigo("12 34");
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void deve_aceitar_codigo_nao_nulo_com_ate_5_digitos_numericos() {
        assertTrue(ValidaCliente.valida(cliente));
    }
    
    @Test
    public void nao_deve_aceitar_nome_invalido() {
        cliente.getCodigo();
        assertFalse(ValidaCliente.valida(Fixture.from(Cliente.class).gimme("nomeInvalido")));
    }

    @Test
    public void nao_deve_aceitar_nome_nulo() {
        cliente.setNome(null);
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_espaco_no_comeco_do_nome() {
        cliente.setNome(" Ana");
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_espaco_no_final_do_nome() {
        cliente.setNome("Ana ");
        assertFalse(ValidaCliente.valida(cliente));
    }
    
    @Test
    public void nao_deve_aceitar_nome_em_branco() {
        cliente.setNome("  ");
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_nome_vazio() {
        cliente.setNome("");
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_nome_com_numeros() {
        cliente.setNome("Ana 1");
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_nome_com_caracteres_especiais() {
        cliente.setNome("@Ana");
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_nome_maior_que_cem_caracteres() {
        String maior = "a";
        for(int i = 0 ; i < 100 ; i++) {
            maior += "a";
        }
        cliente.setNome(maior);
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void deve_aceitar_nome_nao_nulo_somente_com_letras_e_espacos_de_1_até_100_caracteres() {
        assertTrue(ValidaCliente.valida(cliente));
    }
    
    @Test
    public void nao_deve_aceitar_cpf_invalido() {
        cliente.getCodigo();
        assertFalse(ValidaCliente.valida(Fixture.from(Cliente.class).gimme("cpfInvalido")));
    }

    @Test
    public void nao_deve_aceitar_cpf_nulo() {
        cliente.setCpf(null);
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_cpf_com_todos_os_digitos_repetidos() {
        String repetido = "";
        for(int i = 0 ; i < 10 ; i++) {
            for(int cont = 0 ; cont < 11 ; cont++) {
                repetido += Integer.toString(i);
            }
            cliente.setCpf(repetido);
            repetido = "";
            assertFalse(ValidaCliente.valida(cliente));
        }
    }

    @Test
    public void nao_deve_aceitar_numero_do_cpf_em_branco() {
        cliente.setCpf("           ");
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_numero_do_cpf_vazio() {
        cliente.setCpf("");
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_cpf_com_espacos() {
        cliente.setCpf("12345 67890");
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_cpf_com_letras() {
        cliente.setCpf("123456789xy");
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_cpf_com_caracteres_especiais() {
        cliente.setCpf("123456789@@");
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_cpf_com_menos_de_onze_digitos() {
        cliente.setCpf("1234567890");
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_cpf_com_mais_de_onze_digitos() {
        cliente.setCpf("123456789091");
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_cpf_com_decimo_digito_invalido() {
        cliente.setCpf("12345678989");
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_cpf_com_decimo_primeiro_digito_invalido() {
        cliente.setCpf("12345678901");
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void deve_aceitar_cpf_valido_somente_com_11_digitos_numericos() {
        assertTrue(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_data_nascimento_invalida() {
        cliente.getCodigo();
        assertFalse(ValidaCliente.valida(Fixture.from(Cliente.class).gimme("dataNascimentoInvalido")));
    }
    
    @Test
    public void nao_deve_aceitar_data_nascimento_nula() {
        cliente.setDataNascimento(null);
        assertFalse(ValidaCliente.valida(cliente));
    }
    
    @Test
    public void nao_deve_aceitar_data_nascimento_anterior_a_01_01_1900() {
        cliente.setDataNascimento(LocalDate.of(1899, 12, 31));
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_data_nascimento_posterior_ou_igual_a_data_atual() {
        cliente.setDataNascimento(LocalDate.now().plusDays(1));
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void deve_aceitar_data_nascimento_nao_nula_a_partir_de_01_01_1900_ate_data_ontem() {
        assertTrue(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_endereco_nulo() {
        cliente.setEndereco(null);
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void deve_aceitar_endereco_nao_nulo_de_acordo_com_as_regras_da_classe_endereco() {
        assertTrue(ValidaCliente.valida(cliente));
    }

    @Test
    public void nao_deve_aceitar_contato_nulo() {
        cliente.setContato(null);
        assertFalse(ValidaCliente.valida(cliente));
    }

    @Test
    public void deve_aceitar_contato_nao_nulo_de_acordo_com_as_regras_da_classe_contato() {
        assertTrue(ValidaCliente.valida(cliente));
    }

}
