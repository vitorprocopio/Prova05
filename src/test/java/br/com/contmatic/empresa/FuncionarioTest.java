package br.com.contmatic.empresa;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.six2six.fixturefactory.Fixture;
import nl.jqno.equalsverifier.EqualsVerifier;

// TODO: Auto-generated Javadoc
/**
 * The Class FuncionarioTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class FuncionarioTest {

    /** The funcionario. */
    private Funcionario funcionario;

    /**
     * Load.
     */
    @BeforeClass
    public static void load() {
        new FuncionarioTemplate().load();
    }

    /**
     * Init.
     */
    @Before
    public void init() {
        funcionario = Fixture.from(Funcionario.class).gimme("valido");
    }

    /**
     * Nao deve aceitar codigo invalido.
     */
    @Test
    public void nao_deve_aceitar_codigo_invalido() {
        funcionario.getCodigo();
        assertFalse(ValidaFuncionario.valida(Fixture.from(Funcionario.class).gimme("codigoInvalido")));
    }

    /**
     * Nao deve aceitar codigo nulo.
     */
    @Test
    public void nao_deve_aceitar_codigo_nulo() {
        funcionario.setCodigo(null);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar codigo em branco.
     */
    @Test
    public void nao_deve_aceitar_codigo_em_branco() {
        funcionario.setCodigo("   ");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar codigo vazio.
     */
    @Test
    public void nao_deve_aceitar_codigo_vazio() {
        funcionario.setCodigo("");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar codigo com mais de cinco digitos.
     */
    @Test
    public void nao_deve_aceitar_codigo_com_mais_de_cinco_digitos() {
        funcionario.setCodigo("100000");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar codigo com letras.
     */
    @Test
    public void nao_deve_aceitar_codigo_com_letras() {
        funcionario.setCodigo("123a");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar codigo com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_codigo_com_caracteres_especiais() {
        funcionario.setCodigo("1234@");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar codigo com espacos.
     */
    @Test
    public void nao_deve_aceitar_codigo_com_espacos() {
        funcionario.setCodigo("12 34");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Deve aceitar codigo nao nulo com ate 5 digitos numericos.
     */
    @Test
    public void deve_aceitar_codigo_nao_nulo_com_ate_5_digitos_numericos() {
        assertTrue(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar nome invalido.
     */
    @Test
    public void nao_deve_aceitar_nome_invalido() {
        funcionario.getCodigo();
        assertFalse(ValidaFuncionario.valida(Fixture.from(Funcionario.class).gimme("nomeInvalido")));
    }

    /**
     * Nao deve aceitar nome nulo.
     */
    @Test
    public void nao_deve_aceitar_nome_nulo() {
        funcionario.setNome(null);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar espaco no comeco do nome.
     */
    @Test
    public void nao_deve_aceitar_espaco_no_comeco_do_nome() {
        funcionario.setNome(" Ana");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar espaco no final do nome.
     */
    @Test
    public void nao_deve_aceitar_espaco_no_final_do_nome() {
        funcionario.setNome("Ana ");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar nome em branco.
     */
    @Test
    public void nao_deve_aceitar_nome_em_branco() {
        funcionario.setNome("  ");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar nome vazio.
     */
    @Test
    public void nao_deve_aceitar_nome_vazio() {
        funcionario.setNome("");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar nome com numeros.
     */
    @Test
    public void nao_deve_aceitar_nome_com_numeros() {
        funcionario.setNome("Ana 1");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar nome com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_nome_com_caracteres_especiais() {
        funcionario.setNome("@Ana");
        assertFalse(ValidaFuncionario.valida(funcionario));
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
        funcionario.setNome(maior);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Deve aceitar nome nao nulo somente com letras e espacos de 1 até 100 caracteres.
     */
    @Test
    public void deve_aceitar_nome_nao_nulo_somente_com_letras_e_espacos_de_1_até_100_caracteres() {
        assertTrue(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar nome da mae nulo.
     */
    @Test
    public void nao_deve_aceitar_nome_da_mae_nulo() {
        funcionario.setNomeMae(null);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar espaco no comeco do nome da mae.
     */
    @Test
    public void nao_deve_aceitar_espaco_no_comeco_do_nome_da_mae() {
        funcionario.setNomeMae(" Francisca");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar espaco no final do nome da mae.
     */
    @Test
    public void nao_deve_aceitar_espaco_no_final_do_nome_da_mae() {
        funcionario.setNomeMae("Francisca ");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar nome da mae em branco.
     */
    @Test
    public void nao_deve_aceitar_nome_da_mae_em_branco() {
        funcionario.setNomeMae("  ");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar nome da mae vazio.
     */
    @Test
    public void nao_deve_aceitar_nome_da_mae_vazio() {
        funcionario.setNomeMae("");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar nome da mae com numeros.
     */
    @Test
    public void nao_deve_aceitar_nome_da_mae_com_numeros() {
        funcionario.setNomeMae("Francisca 1");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar nome da mae com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_nome_da_mae_com_caracteres_especiais() {
        funcionario.setNomeMae("@Francisca");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar nome da mae maior que cem caracteres.
     */
    @Test
    public void nao_deve_aceitar_nome_da_mae_maior_que_cem_caracteres() {
        String maior = "a";
        for(int i = 0 ; i < 100 ; i++) {
            maior += "a";
        }
        funcionario.setNomeMae(maior);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Deve aceitar nome da mae nao nulo somente com letras e espacos de 1 até 100 caracteres.
     */
    @Test
    public void deve_aceitar_nome_da_mae_nao_nulo_somente_com_letras_e_espacos_de_1_até_100_caracteres() {
        assertTrue(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar espaco no comeco do nome do pai.
     */
    @Test
    public void nao_deve_aceitar_espaco_no_comeco_do_nome_do_pai() {
        funcionario.setNomePai(" Antonio");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar nome do pai com numeros.
     */
    @Test
    public void nao_deve_aceitar_nome_do_pai_com_numeros() {
        funcionario.setNomePai("Antonio 1");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar nome do pai com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_nome_do_pai_com_caracteres_especiais() {
        funcionario.setNomePai("@Antonio");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar nome do pai maior que cem caracteres.
     */
    @Test
    public void nao_deve_aceitar_nome_do_pai_maior_que_cem_caracteres() {
        String maior = "a";
        for(int i = 0 ; i < 100 ; i++) {
            maior += "a";
        }
        funcionario.setNomePai(maior);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Deve aceitar nome do pai nao nulo somente com letras e espacos de 1 até 100 caracteres.
     */
    @Test
    public void deve_aceitar_nome_do_pai_nao_nulo_somente_com_letras_e_espacos_de_1_até_100_caracteres() {
        assertTrue(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar cpf invalido.
     */
    @Test
    public void nao_deve_aceitar_cpf_invalido() {
        funcionario.getCodigo();
        assertFalse(ValidaFuncionario.valida(Fixture.from(Funcionario.class).gimme("cpfInvalido")));
    }

    /**
     * Nao deve aceitar cpf nulo.
     */
    @Test
    public void nao_deve_aceitar_cpf_nulo() {
        funcionario.setCpf(null);
        assertFalse(ValidaFuncionario.valida(funcionario));
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
            funcionario.setCpf(repetido);
            repetido = "";
            assertFalse(ValidaFuncionario.valida(funcionario));
        }
    }

    /**
     * Nao deve aceitar numero do cpf em branco.
     */
    @Test
    public void nao_deve_aceitar_numero_do_cpf_em_branco() {
        funcionario.setCpf("           ");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar numero do cpf vazio.
     */
    @Test
    public void nao_deve_aceitar_numero_do_cpf_vazio() {
        funcionario.setCpf("");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar cpf com espacos.
     */
    @Test
    public void nao_deve_aceitar_cpf_com_espacos() {
        funcionario.setCpf("12345 67890");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar cpf com letras.
     */
    @Test
    public void nao_deve_aceitar_cpf_com_letras() {
        funcionario.setCpf("123456789xy");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar cpf com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_cpf_com_caracteres_especiais() {
        funcionario.setCpf("123456789@@");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar cpf com menos de onze digitos.
     */
    @Test
    public void nao_deve_aceitar_cpf_com_menos_de_onze_digitos() {
        funcionario.setCpf("1234567890");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar cpf com mais de onze digitos.
     */
    @Test
    public void nao_deve_aceitar_cpf_com_mais_de_onze_digitos() {
        funcionario.setCpf("123456789091");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar cpf com decimo digito invalido.
     */
    @Test
    public void nao_deve_aceitar_cpf_com_decimo_digito_invalido() {
        funcionario.setCpf("12345678989");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar cpf com decimo primeiro digito invalido.
     */
    @Test
    public void nao_deve_aceitar_cpf_com_decimo_primeiro_digito_invalido() {
        funcionario.setCpf("12345678901");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Deve aceitar cpf valido somente com 11 digitos numericos.
     */
    @Test
    public void deve_aceitar_cpf_valido_somente_com_11_digitos_numericos() {
        assertTrue(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar data nascimento invalida.
     */
    @Test
    public void nao_deve_aceitar_data_nascimento_invalida() {
        funcionario.getCodigo();
        assertFalse(ValidaFuncionario.valida(Fixture.from(Funcionario.class).gimme("dataNascimentoInvalido")));
    }

    /**
     * Nao deve aceitar data nascimento nula.
     */
    @Test
    public void nao_deve_aceitar_data_nascimento_nula() {
        funcionario.setDataNascimento(null);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar data nascimento anterior a 01 01 1900.
     */
    @Test
    public void nao_deve_aceitar_data_nascimento_anterior_a_01_01_1900() {
        funcionario.setDataNascimento(new LocalDate(1899, 12, 31));
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar data nascimento posterior ou igual a data atual.
     */
    @Test
    public void nao_deve_aceitar_data_nascimento_posterior_ou_igual_a_data_atual() {
        funcionario.setDataNascimento(LocalDate.now().plusDays(1));
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Deve aceitar data nascimento nao nula a partir de 01 01 1900 ate data ontem.
     */
    @Test
    public void deve_aceitar_data_nascimento_nao_nula_a_partir_de_01_01_1900_ate_data_ontem() {
        assertTrue(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar endereco nulo.
     */
    @Test
    public void nao_deve_aceitar_endereco_nulo() {
        funcionario.setEnderecos(null);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Deve aceitar endereco nao nulo de acordo com as regras da classe endereco.
     */
    @Test
    public void deve_aceitar_endereco_nao_nulo_de_acordo_com_as_regras_da_classe_endereco() {
        assertTrue(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar sexo nulo.
     */
    @Test
    public void nao_deve_aceitar_Sexo_nulo() {
        funcionario.setSexo(null);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Deve aceitar sexo nao nulo de acordo com enum genero.
     */
    @Test
    public void deve_aceitar_Sexo_nao_nulo_de_acordo_com_enum_genero() {
        assertTrue(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar salario invalido.
     */
    @Test
    public void nao_deve_aceitar_salario_invalido() {
        funcionario.getSalario();
        assertFalse(ValidaFuncionario.valida(Fixture.from(Funcionario.class).gimme("salarioInvalido")));
    }

    /**
     * Nao deve aceitar salario maior igual que 100000.
     */
    @Test
    public void nao_deve_aceitar_salario_maior_igual_que_100000() {
        funcionario.setSalario(100000.00);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar salario negativo.
     */
    @Test
    public void nao_deve_aceitar_salario_negativo() {
        funcionario.setSalario(-0.1);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Deve aceitar salario até 99999.
     */
    @Test
    public void deve_aceitar_salario_até_99999() {
        assertTrue(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar conta nulo.
     */
    @Test
    public void nao_deve_aceitar_conta_nulo() {
        funcionario.setConta(null);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Deve aceitar conta nao nulo de acordo com as regras da classe conta.
     */
    @Test
    public void deve_aceitar_conta_nao_nulo_de_acordo_com_as_regras_da_classe_conta() {
        assertTrue(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Nao deve aceitar horario nulo.
     */
    @Test
    public void nao_deve_aceitar_horario_nulo() {
        funcionario.setHorario(null);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    /**
     * Deve aceitar horario nao nulo de acordo com as regras da classe horario.
     */
    @Test
    public void deve_aceitar_horario_nao_nulo_de_acordo_com_as_regras_da_classe_horario() {
        assertTrue(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.simple().forClass(Funcionario.class).withIgnoredFields("codigo", "nome", "dataNascimento", "nomeMae", "nomePai", "salario", "conta", "horario", "sexo", "enderecos").verify();
    }

}
