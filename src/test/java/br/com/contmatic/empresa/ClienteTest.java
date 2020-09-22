package br.com.contmatic.empresa;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.jeasy.random.EasyRandom;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import nl.jqno.equalsverifier.EqualsVerifier;

// TODO: Auto-generated Javadoc
/**
 * The Class ClienteTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ClienteTest {

    /** The cliente. */
    private Cliente cliente;
    
    private Cliente invalido;
    
    @Before
    public void init() {
        EasyRandom clienteValido = new EasyRandom(ClienteTemplate.clienteValido());
        cliente = clienteValido.nextObject(Cliente.class);
        System.out.println(cliente);
    }

//    /**
//     * Load.
//     */
//    @BeforeClass
//    public static void load() {
//        new ClienteTemplate().load();
//    }
//
//    /**
//     * Init.
//     */
//    @Before
//    public void init() {
//        cliente = Fixture.from(Cliente.class).gimme("valido");
//    }

    /**
     * Nao deve aceitar codigo invalido.
     */
    @Test
    public void nao_deve_aceitar_codigo_invalido() {
        EasyRandom clienteInvalido = new EasyRandom(ClienteTemplate.clienteInvalido());
        invalido = clienteInvalido.nextObject(Cliente.class);
        cliente.getCodigo();
        assertFalse(ValidaCliente.valida(invalido));
    }

    /**
     * Nao deve aceitar codigo nulo.
     */
    @Test
    public void nao_deve_aceitar_codigo_nulo() {
        cliente.setCodigo(null);
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar codigo em branco.
     */
    @Test
    public void nao_deve_aceitar_codigo_em_branco() {
        cliente.setCodigo("   ");
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar codigo vazio.
     */
    @Test
    public void nao_deve_aceitar_codigo_vazio() {
        cliente.setCodigo("");
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar codigo com mais de cinco digitos.
     */
    @Test
    public void nao_deve_aceitar_codigo_com_mais_de_cinco_digitos() {
        cliente.setCodigo("100000");
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar codigo com letras.
     */
    @Test
    public void nao_deve_aceitar_codigo_com_letras() {
        cliente.setCodigo("123a");
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar codigo com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_codigo_com_caracteres_especiais() {
        cliente.setCodigo("1234@");
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar codigo com espacos.
     */
    @Test
    public void nao_deve_aceitar_codigo_com_espacos() {
        cliente.setCodigo("12 34");
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Deve aceitar codigo nao nulo com ate 5 digitos numericos.
     */
    @Test
    public void deve_aceitar_codigo_nao_nulo_com_ate_5_digitos_numericos() {
        assertTrue(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar nome invalido.
     */
    @Test
    public void nao_deve_aceitar_nome_invalido() {
        EasyRandom clienteInvalido = new EasyRandom(ClienteTemplate.clienteInvalido());
        invalido = clienteInvalido.nextObject(Cliente.class);
        cliente.getNome();
        assertFalse(ValidaCliente.valida(invalido));
    }

    /**
     * Nao deve aceitar nome nulo.
     */
    @Test
    public void nao_deve_aceitar_nome_nulo() {
        cliente.setNome(null);
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar espaco no comeco do nome.
     */
    @Test
    public void nao_deve_aceitar_espaco_no_comeco_do_nome() {
        cliente.setNome(" Ana");
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar espaco no final do nome.
     */
    @Test
    public void nao_deve_aceitar_espaco_no_final_do_nome() {
        cliente.setNome("Ana ");
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar nome em branco.
     */
    @Test
    public void nao_deve_aceitar_nome_em_branco() {
        cliente.setNome("  ");
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar nome vazio.
     */
    @Test
    public void nao_deve_aceitar_nome_vazio() {
        cliente.setNome("");
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar nome com numeros.
     */
    @Test
    public void nao_deve_aceitar_nome_com_numeros() {
        cliente.setNome("Ana 1");
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar nome com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_nome_com_caracteres_especiais() {
        cliente.setNome("@Ana");
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar nome maior que cem caracteres.
     */
    @Test
    public void nao_deve_aceitar_nome_maior_que_cem_caracteres() {
        String maior = "a";
        for(int i = 0 ; i < 100 ; i++) {
            maior += "a";
        }
        cliente.setNome(maior);
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Deve aceitar nome nao nulo somente com letras e espacos de 1 até 100 caracteres.
     */
    @Test
    public void deve_aceitar_nome_nao_nulo_somente_com_letras_e_espacos_de_1_até_100_caracteres() {
        assertTrue(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar cpf invalido.
     */
    @Test
    public void nao_deve_aceitar_cpf_invalido() {
        EasyRandom clienteInvalido = new EasyRandom(ClienteTemplate.clienteInvalido());
        invalido = clienteInvalido.nextObject(Cliente.class);
        cliente.getCpf();
        assertFalse(ValidaCliente.valida(invalido));
    }

    /**
     * Nao deve aceitar cpf nulo.
     */
    @Test
    public void nao_deve_aceitar_cpf_nulo() {
        cliente.setCpf(null);
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar cpf com todos os digitos repetidos.
     */
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

    /**
     * Nao deve aceitar numero do cpf em branco.
     */
    @Test
    public void nao_deve_aceitar_numero_do_cpf_em_branco() {
        cliente.setCpf("           ");
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar numero do cpf vazio.
     */
    @Test
    public void nao_deve_aceitar_numero_do_cpf_vazio() {
        cliente.setCpf("");
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar cpf com espacos.
     */
    @Test
    public void nao_deve_aceitar_cpf_com_espacos() {
        cliente.setCpf("12345 67890");
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar cpf com letras.
     */
    @Test
    public void nao_deve_aceitar_cpf_com_letras() {
        cliente.setCpf("123456789xy");
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar cpf com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_cpf_com_caracteres_especiais() {
        cliente.setCpf("123456789@@");
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar cpf com menos de onze digitos.
     */
    @Test
    public void nao_deve_aceitar_cpf_com_menos_de_onze_digitos() {
        cliente.setCpf("1234567890");
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar cpf com mais de onze digitos.
     */
    @Test
    public void nao_deve_aceitar_cpf_com_mais_de_onze_digitos() {
        cliente.setCpf("123456789091");
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar cpf com decimo digito invalido.
     */
    @Test
    public void nao_deve_aceitar_cpf_com_decimo_digito_invalido() {
        cliente.setCpf("12345678989");
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar cpf com decimo primeiro digito invalido.
     */
    @Test
    public void nao_deve_aceitar_cpf_com_decimo_primeiro_digito_invalido() {
        cliente.setCpf("12345678901");
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Deve aceitar cpf valido somente com 11 digitos numericos.
     */
    @Test
    public void deve_aceitar_cpf_valido_somente_com_11_digitos_numericos() {
        assertTrue(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar data nascimento invalida.
     */
    @Test
    public void nao_deve_aceitar_data_nascimento_invalida() {
        EasyRandom clienteInvalido = new EasyRandom(ClienteTemplate.clienteInvalido());
        invalido = clienteInvalido.nextObject(Cliente.class);
        cliente.getDataNascimento();
        assertFalse(ValidaCliente.valida(invalido));
    }

    /**
     * Nao deve aceitar data nascimento nula.
     */
    @Test
    public void nao_deve_aceitar_data_nascimento_nula() {
        cliente.setDataNascimento(null);
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar data nascimento anterior a 01 01 1900.
     */
    @Test
    public void nao_deve_aceitar_data_nascimento_anterior_a_01_01_1900() {
        cliente.setDataNascimento(new LocalDate(1899, 12, 31));
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar data nascimento posterior ou igual a data atual.
     */
    @Test
    public void nao_deve_aceitar_data_nascimento_posterior_ou_igual_a_data_atual() {
        cliente.setDataNascimento(LocalDate.now().plusDays(1));
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Deve aceitar data nascimento nao nula a partir de 01 01 1900 ate data ontem.
     */
    @Test
    public void deve_aceitar_data_nascimento_nao_nula_a_partir_de_01_01_1900_ate_data_ontem() {
        assertTrue(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar endereco nulo.
     */
    @Test
    public void nao_deve_aceitar_endereco_nulo() {
        cliente.setEnderecos(null);
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Deve aceitar endereco nao nulo de acordo com as regras da classe endereco.
     */
    @Test
    public void deve_aceitar_endereco_nao_nulo_de_acordo_com_as_regras_da_classe_endereco() {
        assertTrue(ValidaCliente.valida(cliente));
    }

    /**
     * Nao deve aceitar contato nulo.
     */
    @Test
    public void nao_deve_aceitar_contato_nulo() {
        cliente.setContatos(null);
        assertFalse(ValidaCliente.valida(cliente));
    }

    /**
     * Deve aceitar contato nao nulo de acordo com as regras da classe contato.
     */
    @Test
    public void deve_aceitar_contato_nao_nulo_de_acordo_com_as_regras_da_classe_contato() {
        assertTrue(ValidaCliente.valida(cliente));
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.simple().forClass(Cliente.class).withIgnoredFields("codigo", "nome", "dataNascimento", "enderecos", "contatos").verify();
    }
}
