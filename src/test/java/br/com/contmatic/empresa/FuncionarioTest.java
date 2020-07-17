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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class FuncionarioTest {

    private Funcionario funcionario;
    // private LocalDate data;
    // private Endereco endereco;
    // private ContaBancaria conta;
    // private Horario horario;
    // private LocalTime entrada = LocalTime.of(8, 00, 00);
    // private LocalTime saidaAlmoco = LocalTime.of(12, 30, 00);
    // private LocalTime retornoAlmoco = LocalTime.of(13, 30, 00);
    // private LocalTime saida = LocalTime.of(18, 00, 00);

    // @Before
    // public void init() {
    // horario = new Horario(entrada, saidaAlmoco, retornoAlmoco, saida);
    // conta = new ContaBancaria("Joana Pereira","321","7654");
    // endereco = new Endereco("01234567", "Rua 1 de Abril", 1, "Bloco 1 Apto 102", "Bairro Um", "São Paulo", Estado.SP, "Brasil");
    // data = LocalDate.of(1986,01,06);
    // funcionario = new Funcionario("54", "Joana Pereira", data, "Francisca Pereira", "Antonio Pereira", "12345678909", Genero.F, 3500.77, endereco, conta);
    // }

    @BeforeClass
    public static void load() {
        new FuncionarioTemplate().load();
    }

    @Before
    public void init() {
        funcionario = Fixture.from(Funcionario.class).gimme("valido");
    }

    @Test
    public void nao_deve_aceitar_codigo_invalido() {
        funcionario.getCodigo();
        assertFalse(ValidaFuncionario.valida(Fixture.from(Funcionario.class).gimme("codigoInvalido")));
    }

    @Test
    public void nao_deve_aceitar_codigo_nulo() {
        funcionario.setCodigo(null);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_codigo_em_branco() {
        funcionario.setCodigo("   ");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_codigo_vazio() {
        funcionario.setCodigo("");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_codigo_com_mais_de_cinco_digitos() {
        funcionario.setCodigo("100000");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_codigo_com_letras() {
        funcionario.setCodigo("123a");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_codigo_com_caracteres_especiais() {
        funcionario.setCodigo("1234@");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_codigo_com_espacos() {
        funcionario.setCodigo("12 34");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void deve_aceitar_codigo_nao_nulo_com_ate_5_digitos_numericos() {
        assertTrue(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_nome_invalido() {
        funcionario.getCodigo();
        assertFalse(ValidaFuncionario.valida(Fixture.from(Funcionario.class).gimme("nomeInvalido")));
    }

    @Test
    public void nao_deve_aceitar_nome_nulo() {
        funcionario.setNome(null);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_espaco_no_comeco_do_nome() {
        funcionario.setNome(" Ana");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_espaco_no_final_do_nome() {
        funcionario.setNome("Ana ");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_nome_em_branco() {
        funcionario.setNome("  ");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_nome_vazio() {
        funcionario.setNome("");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_nome_com_numeros() {
        funcionario.setNome("Ana 1");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_nome_com_caracteres_especiais() {
        funcionario.setNome("@Ana");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_nome_maior_que_cem_caracteres() {
        String maior = "a";
        for(int i = 0 ; i < 100 ; i++) {
            maior += "a";
        }
        funcionario.setNome(maior);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void deve_aceitar_nome_nao_nulo_somente_com_letras_e_espacos_de_1_até_100_caracteres() {
        assertTrue(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_nome_da_mae_nulo() {
        funcionario.setNomeMae(null);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_espaco_no_comeco_do_nome_da_mae() {
        funcionario.setNomeMae(" Francisca");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_espaco_no_final_do_nome_da_mae() {
        funcionario.setNomeMae("Francisca ");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_nome_da_mae_em_branco() {
        funcionario.setNomeMae("  ");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_nome_da_mae_vazio() {
        funcionario.setNomeMae("");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_nome_da_mae_com_numeros() {
        funcionario.setNomeMae("Francisca 1");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_nome_da_mae_com_caracteres_especiais() {
        funcionario.setNomeMae("@Francisca");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_nome_da_mae_maior_que_cem_caracteres() {
        String maior = "a";
        for(int i = 0 ; i < 100 ; i++) {
            maior += "a";
        }
        funcionario.setNomeMae(maior);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void deve_aceitar_nome_da_mae_nao_nulo_somente_com_letras_e_espacos_de_1_até_100_caracteres() {
        assertTrue(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_espaco_no_comeco_do_nome_do_pai() {
        funcionario.setNomePai(" Antonio");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_nome_do_pai_com_numeros() {
        funcionario.setNomePai("Antonio 1");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_nome_do_pai_com_caracteres_especiais() {
        funcionario.setNomePai("@Antonio");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_nome_do_pai_maior_que_cem_caracteres() {
        String maior = "a";
        for(int i = 0 ; i < 100 ; i++) {
            maior += "a";
        }
        funcionario.setNomePai(maior);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void deve_aceitar_nome_do_pai_nao_nulo_somente_com_letras_e_espacos_de_1_até_100_caracteres() {
        assertTrue(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_cpf_invalido() {
        funcionario.getCodigo();
        assertFalse(ValidaFuncionario.valida(Fixture.from(Funcionario.class).gimme("cpfInvalido")));
    }

    @Test
    public void nao_deve_aceitar_cpf_nulo() {
        funcionario.setCpf(null);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

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

    @Test
    public void nao_deve_aceitar_numero_do_cpf_em_branco() {
        funcionario.setCpf("           ");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_numero_do_cpf_vazio() {
        funcionario.setCpf("");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_cpf_com_espacos() {
        funcionario.setCpf("12345 67890");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_cpf_com_letras() {
        funcionario.setCpf("123456789xy");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_cpf_com_caracteres_especiais() {
        funcionario.setCpf("123456789@@");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_cpf_com_menos_de_onze_digitos() {
        funcionario.setCpf("1234567890");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_cpf_com_mais_de_onze_digitos() {
        funcionario.setCpf("123456789091");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_cpf_com_decimo_digito_invalido() {
        funcionario.setCpf("12345678989");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_cpf_com_decimo_primeiro_digito_invalido() {
        funcionario.setCpf("12345678901");
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void deve_aceitar_cpf_valido_somente_com_11_digitos_numericos() {
        assertTrue(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_data_nascimento_invalida() {
        funcionario.getCodigo();
        assertFalse(ValidaFuncionario.valida(Fixture.from(Funcionario.class).gimme("dataNascimentoInvalido")));
    }

    @Test
    public void nao_deve_aceitar_data_nascimento_nula() {
        funcionario.setDataNascimento(null);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_data_nascimento_anterior_a_01_01_1900() {
        funcionario.setDataNascimento(new LocalDate(1899, 12, 31));
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_data_nascimento_posterior_ou_igual_a_data_atual() {
        funcionario.setDataNascimento(LocalDate.now().plusDays(1));
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void deve_aceitar_data_nascimento_nao_nula_a_partir_de_01_01_1900_ate_data_ontem() {
        assertTrue(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_endereco_nulo() {
        funcionario.setEnderecos(null);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void deve_aceitar_endereco_nao_nulo_de_acordo_com_as_regras_da_classe_endereco() {
        assertTrue(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_Sexo_nulo() {
        funcionario.setSexo(null);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void deve_aceitar_Sexo_nao_nulo_de_acordo_com_enum_genero() {
        assertTrue(ValidaFuncionario.valida(funcionario));
    }
    
    @Test
    public void nao_deve_aceitar_salario_invalido() {
        funcionario.getSalario();
        assertFalse(ValidaFuncionario.valida(Fixture.from(Funcionario.class).gimme("salarioInvalido")));
    }

    @Test
    public void nao_deve_aceitar_salario_maior_igual_que_100000() {
        funcionario.setSalario(100000.00);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_salario_negativo() {
        funcionario.setSalario(-0.1);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void deve_aceitar_salario_até_99999() {
        assertTrue(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_conta_nulo() {
        funcionario.setConta(null);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void deve_aceitar_conta_nao_nulo_de_acordo_com_as_regras_da_classe_conta() {
        assertTrue(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void nao_deve_aceitar_horario_nulo() {
        funcionario.setHorario(null);
        assertFalse(ValidaFuncionario.valida(funcionario));
    }

    @Test
    public void deve_aceitar_horario_nao_nulo_de_acordo_com_as_regras_da_classe_horario() {
        assertTrue(ValidaFuncionario.valida(funcionario));
    }

}
