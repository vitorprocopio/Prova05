package br.com.contmatic.banco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.six2six.fixturefactory.Fixture;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ContaBancariaTest {

    private ContaBancaria conta;

    @BeforeClass
    public static void load() {
        new BancoTemplate().load();
    }

    @Before
    public void init() {
        conta = Fixture.from(ContaBancaria.class).gimme("valido");
    }

    @Test
    public void nao_deve_aceitar_titular_invalido() {
        conta.getTitular();
        assertFalse(ValidaBanco.valida(Fixture.from(ContaBancaria.class).gimme("titularInvalido")));
    }

    @Test(timeout = 500)
    public void nao_deve_aceitar_titular_nulo() {
        conta.setTitular(null);
        assertFalse(ValidaBanco.valida(conta));
    }

    @Test
    public void nao_deve_aceitar_espaco_no_comeco_do_nome_do_titular() {
        conta.setTitular(" José");
        assertFalse(ValidaBanco.valida(conta));

    }

    @Test
    public void nao_deve_aceitar_nome_do_titular_em_branco() {
        conta.setTitular("  ");
        assertFalse(ValidaBanco.valida(conta));
    }

    @Test
    public void nao_deve_aceitar_titular_vazio() {
        conta.setTitular("");
        assertFalse(ValidaBanco.valida(conta));
    }

    @Test
    public void nao_deve_aceitar_titular_com_numeros() {
        conta.setTitular("Jose 1");
        assertFalse(ValidaBanco.valida(conta));
    }

    @Test
    public void nao_deve_aceitar_titular_com_caracteres_especiais() {
        conta.setTitular("@José");
        assertFalse(ValidaBanco.valida(conta));
    }

    @Test
    public void deve_aceitar_titular_nao_nulo_somente_com_letras_e_espacos_de_1_até_100_caracteres() {
        assertTrue(ValidaBanco.valida(Fixture.from(ContaBancaria.class).gimme("valido")));
    }

    @Test
    public void nao_deve_aceitar_titular_maior_que_cem_caracteres() {
        String maior = "a";
        for(int i = 0 ; i < 100 ; i++) {
            maior += "a";
        }
        conta.setTitular(maior);
        assertFalse(ValidaBanco.valida(conta));
    }

    @Test
    public void nao_deve_aceitar_numero_invalido() {
        conta.getTitular();
        assertFalse(ValidaBanco.valida(Fixture.from(ContaBancaria.class).gimme("numeroInvalido")));
    }

    @Test
    public void nao_deve_aceitar_numero_nulo() {
        conta.setNumero(null);
        assertFalse(ValidaBanco.valida(conta));
    }

    @Test
    public void nao_deve_aceitar_espaco_no_comeco_do_numero_da_conta() {
        conta.setNumero(" 123");
        assertFalse(ValidaBanco.valida(conta));
    }

    @Test
    public void nao_deve_aceitar_numero_da_conta_em_branco() {
        conta.setNumero("  ");
        assertFalse(ValidaBanco.valida(conta));
    }

    @Test
    public void nao_deve_aceitar_numero_da_conta_vazio() {
        conta.setNumero("");
        assertFalse(ValidaBanco.valida(conta));
    }

    @Test
    public void nao_deve_aceitar_numero_da_conta_maior_que_vinte_caracteres() {
        String maior = "1";
        for(int i = 0 ; i < 20 ; i++) {
            maior += "1";
        }
        conta.setNumero(maior);
        assertFalse(ValidaBanco.valida(conta));
    }

    @Test
    public void nao_deve_aceitar_numero_da_conta_com_letras() {
        conta.setNumero("123a");
        assertFalse(ValidaBanco.valida(conta));
    }

    @Test
    public void nao_deve_aceitar_numero_da_conta_com_caracteres_especiais() {
        conta.setNumero("#123");
        assertFalse(ValidaBanco.valida(conta));
    }

    @Test
    public void deve_aceitar_somente_numero_da_conta_nao_nulo_com_até_20_digitos_numericos() {
        conta.setNumero("123");
        assertTrue(ValidaBanco.valida(Fixture.from(ContaBancaria.class).gimme("valido")));
    }

    @Test
    public void nao_deve_aceitar_agencia_invalido() {
        conta.getTitular();
        assertFalse(ValidaBanco.valida(Fixture.from(ContaBancaria.class).gimme("agenciaInvalido")));
    }

    @Test
    public void nao_deve_aceitar_agencia_nulo() {
        conta.setAgencia(null);
        assertFalse(ValidaBanco.valida(conta));
    }

    @Test
    public void nao_deve_aceitar_espaco_no_comeco_do_numero_da_agencia() {
        conta.setAgencia(" 4567");
        assertFalse(ValidaBanco.valida(conta));
    }

    @Test
    public void nao_deve_aceitar_numero_da_agencia_em_branco() {
        conta.setAgencia("  ");
        assertFalse(ValidaBanco.valida(conta));
    }

    @Test
    public void nao_deve_aceitar_numero_da_agencia_vazio() {
        conta.setAgencia("");
        assertFalse(ValidaBanco.valida(conta));
    }

    @Test
    public void nao_deve_aceitar_agencia_com_letras() {
        conta.setAgencia("456a");
        assertFalse(ValidaBanco.valida(conta));
    }

    @Test
    public void nao_deve_aceitar_agencia_com_caracteres_especiais() {
        conta.setAgencia("456%");
        assertFalse(ValidaBanco.valida(conta));
    }

    @Ignore
    @Test
    public void nao_deve_aceitar_agencia_com_numero_negativo() { // faz sentido esse teste?
        conta.setAgencia("-4567");
    }

    @Test
    public void deve_aceitar_agencia_nao_nula_somente_com_quatro_digitos_numericos() {
        assertTrue(ValidaBanco.valida(Fixture.from(ContaBancaria.class).gimme("valido")));
    }

    @Test
    public void nao_deve_aceitar_agencia_com_menos_de_quatro_digitos() {
        conta.setAgencia("456");
        assertFalse(ValidaBanco.valida(conta));
    }

    @Test
    public void nao_deve_aceitar_agencia_com_mais_de_quatro_digitos() {
        conta.setAgencia("45678");
        assertFalse(ValidaBanco.valida(conta));
    }

    @Test
    public void testa_propriedade_reflexiva_equals() {
        assertEquals(conta, conta);
    }

    @Test
    public void testa_propriedade_simetrica_equals() {
        ContaBancaria conta1 = new ContaBancaria("José", "123", "4567");
        ContaBancaria conta2 = new ContaBancaria("José", "123", "4567");
        assertEquals(conta1, conta2);
        assertEquals(conta2, conta1);
    }

    @Test
    public void testa_propriedade_transitiva_equals() {
        ContaBancaria conta0 = new ContaBancaria("José", "123", "4567");
        ContaBancaria conta1 = new ContaBancaria("José", "123", "4567");
        ContaBancaria conta2 = new ContaBancaria("José", "123", "4567");
        assertEquals(conta0, conta1);
        assertEquals(conta1, conta2);
        assertEquals(conta0, conta2);
    }

    @Test
    public void testa_consistencia_null_equals() {
        assertFalse(conta.equals(null));
    }

    @Test
    public void equals_deve_retornar_false_se_titular_igual_numero_e_agencia_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("José", "321", "7654");
        assertNotEquals(conta, conta1);
    }

    @Test
    public void equals_deve_retornar_false_se_titular_numero_e_agencia_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("Joao", "321", "7654");
        assertNotEquals(conta, conta1);
    }

    @Test
    public void equals_deve_retornar_false_se_titular_e_numero_igual_e_agencia_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("José", "123", "7654");
        assertNotEquals(conta, conta1);
    }

    @Test
    public void equals_deve_retornar_false_se_titular_e_agencia_igual_e_numero_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("José", "321", "4567");
        assertNotEquals(conta, conta1);
    }

    @Test
    public void equals_deve_retornar_false_se_titular_e_agencia_diferentes_e_numero_igual() {
        ContaBancaria conta1 = new ContaBancaria("Joao", "123", "7654");
        assertNotEquals(conta, conta1);
    }

    @Test
    public void equals_deve_retornar_false_se_titular_e_numero_diferentes_e_agencia_igual() {
        ContaBancaria conta1 = new ContaBancaria("Joao", "321", "4567");
        assertNotEquals(conta, conta1);
    }

    @Test
    public void equals_deve_retornar_true_se_numero_e_agencia_iguais_e_titular_diferente() {
        ContaBancaria conta0 = new ContaBancaria("Jose", "123", "4567");
        ContaBancaria conta1 = new ContaBancaria("Joao", "123", "4567");
        assertEquals(conta0, conta1);
    }

    @Test
    public void equals_deve_retornar_true_se_numero_agencia_e_titular_iguais() {
        ContaBancaria conta0 = new ContaBancaria("José", "123", "4567");
        ContaBancaria conta1 = new ContaBancaria("José", "123", "4567");
        assertEquals(conta0, conta1);
    }

    @Test
    public void hashcode_deve_ser_diferente_se_titular_igual_numero_e_agencia_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("José", "321", "7654");
        assertNotEquals(conta.hashCode(), conta1.hashCode());
    }

    @Test
    public void hashcode_deve_ser_diferente_se_titular_numero_e_agencia_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("Joao", "321", "7654");
        assertNotEquals(conta.hashCode(), conta1.hashCode());
    }

    @Test
    public void hashcode_deve_ser_diferente_se_titular_e_numero_igual_e_agencia_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("José", "123", "7654");
        assertNotEquals(conta.hashCode(), conta1.hashCode());
    }

    @Test
    public void hashcode_deve_ser_diferente_se_titular_e_agencia_igual_e_numero_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("José", "321", "4567");
        assertNotEquals(conta.hashCode(), conta1.hashCode());
    }

    @Test
    public void hashcode_deve_ser_diferente_se_titular_e_agencia_diferentes_e_numero_igual() {
        ContaBancaria conta1 = new ContaBancaria("Joao", "123", "7654");
        assertNotEquals(conta.hashCode(), conta1.hashCode());
    }

    @Test
    public void hashcode_deve_ser_diferente_se_titular_e_numero_diferentes_e_agencia_igual() {
        ContaBancaria conta1 = new ContaBancaria("Joao", "321", "4567");
        assertNotEquals(conta.hashCode(), conta1.hashCode());
    }

    @Test
    public void hashcode_deve_ser_igual_se_numero_e_agencia_iguais_e_titular_diferente() {
        ContaBancaria conta0 = new ContaBancaria("José", "123", "4567");
        ContaBancaria conta1 = new ContaBancaria("Joao", "123", "4567");
        assertEquals(conta0.hashCode(), conta1.hashCode());
    }

    @Test
    public void hashcode_deve_ser_igual_se_numero_agencia_e_titular_iguais() {
        ContaBancaria conta0 = new ContaBancaria("José", "123", "4567");
        ContaBancaria conta1 = new ContaBancaria("José", "123", "4567");
        assertEquals(conta0.hashCode(), conta1.hashCode());
    }

    @Test
    public void deve_conter_o_valor_do_numero_da_conta_na_string_gerada() {
        String toStringConta = conta.toString();
        assertTrue(toStringConta.contains(conta.getNumero()));
    }

    @Test
    public void deve_conter_o_valor_do_numero_da_agencia_na_string_gerada() {
        String toStringConta = conta.toString();
        assertTrue(toStringConta.contains(conta.getAgencia()));
    }

    @Test
    public void deve_conter_o_valor_do_nome_do_titular_na_string_gerada() {
        String toStringConta = conta.toString();
        assertTrue(toStringConta.contains(conta.getTitular()));
    }

}
