package br.com.contmatic.banco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.jeasy.random.EasyRandom;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import nl.jqno.equalsverifier.EqualsVerifier;

// TODO: Auto-generated Javadoc
/**
 * The Class ContaBancariaTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ContaBancariaTest {

    /** The conta. */

    private ContaBancaria conta;
    
    private ContaBancaria invalida;

    /**
     * Load.
     */

    @Before
    public void init() {
        EasyRandom contaValida = new EasyRandom(BancoTemplate.contaValida());
        conta = contaValida.nextObject(ContaBancaria.class);
        System.out.println(conta);
    }

    /**
     * Init.
     */
    // @Before
    // public void init() {
    // conta = Fixture.from(ContaBancaria.class).gimme("valido");
    // }

    // private String randomAgencia() {
    // return RandomStringUtils.randomNumeric(4);
    // }
    //
    // @Test
    // public void givenDefaultConfiguration_thenGenerateSingleObject() {
    // EasyRandomParameters parameters = new EasyRandomParameters()
    // .randomize(FieldPredicates.named("agencia").and(FieldPredicates.inClass(ContaBancaria.class)), this::randomAgencia)
    // .randomize(FieldPredicates.named("numero").and(FieldPredicates.inClass(ContaBancaria.class)), () -> "1");
    //
    // EasyRandom generator = new EasyRandom(parameters);
    // conta = generator.nextObject(ContaBancaria.class);
    // System.out.println(conta);
    // }

    /**
     * Nao deve aceitar titular invalido.
     */
    @Test
    public void nao_deve_aceitar_titular_invalido() {
        EasyRandom contaInvalida = new EasyRandom(BancoTemplate.contaInvalida());
        invalida = contaInvalida.nextObject(ContaBancaria.class);
        conta.getTitular();
        assertFalse(ValidaBanco.valida(invalida));
    }

    /**
     * Nao deve aceitar titular nulo.
     */
    @Test(timeout = 500)
    public void nao_deve_aceitar_titular_nulo() {
        conta.setTitular(null);
        assertFalse(ValidaBanco.valida(conta));
    }

    /**
     * Nao deve aceitar espaco no comeco do nome do titular.
     */
    @Test
    public void nao_deve_aceitar_espaco_no_comeco_do_nome_do_titular() {
        conta.setTitular(" José");
        assertFalse(ValidaBanco.valida(conta));

    }

    /**
     * Nao deve aceitar nome do titular em branco.
     */
    @Test
    public void nao_deve_aceitar_nome_do_titular_em_branco() {
        conta.setTitular("  ");
        assertFalse(ValidaBanco.valida(conta));
    }

    /**
     * Nao deve aceitar titular vazio.
     */
    @Test
    public void nao_deve_aceitar_titular_vazio() {
        conta.setTitular("");
        assertFalse(ValidaBanco.valida(conta));
    }

    /**
     * Nao deve aceitar titular com numeros.
     */
    @Test
    public void nao_deve_aceitar_titular_com_numeros() {
        conta.setTitular("Jose 1");
        assertFalse(ValidaBanco.valida(conta));
    }

    /**
     * Nao deve aceitar titular com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_titular_com_caracteres_especiais() {
        conta.setTitular("@José");
        assertFalse(ValidaBanco.valida(conta));
    }

    /**
     * Deve aceitar titular nao nulo somente com letras e espacos de 1 até 100 caracteres.
     */
    @Test
    public void deve_aceitar_titular_nao_nulo_somente_com_letras_e_espacos_de_1_até_100_caracteres() {
        assertTrue(ValidaBanco.valida(conta));
    }

    /**
     * Nao deve aceitar titular maior que cem caracteres.
     */
    @Test
    public void nao_deve_aceitar_titular_maior_que_cem_caracteres() {
        String maior = "a";
        for(int i = 0 ; i < 100 ; i++) {
            maior += "a";
        }
        conta.setTitular(maior);
        assertFalse(ValidaBanco.valida(conta));
    }

    /**
     * Nao deve aceitar numero invalido.
     */
    @Test
    public void nao_deve_aceitar_numero_invalido() {
        EasyRandom contaInvalida = new EasyRandom(BancoTemplate.contaInvalida());
        invalida = contaInvalida.nextObject(ContaBancaria.class);
        conta.getNumero();
        assertFalse(ValidaBanco.valida(invalida));
    }

    /**
     * Nao deve aceitar numero nulo.
     */
    @Test
    public void nao_deve_aceitar_numero_nulo() {
        conta.setNumero(null);
        assertFalse(ValidaBanco.valida(conta));
    }

    /**
     * Nao deve aceitar espaco no comeco do numero da conta.
     */
    @Test
    public void nao_deve_aceitar_espaco_no_comeco_do_numero_da_conta() {
        conta.setNumero(" 123");
        assertFalse(ValidaBanco.valida(conta));
    }

    /**
     * Nao deve aceitar numero da conta em branco.
     */
    @Test
    public void nao_deve_aceitar_numero_da_conta_em_branco() {
        conta.setNumero("  ");
        assertFalse(ValidaBanco.valida(conta));
    }

    /**
     * Nao deve aceitar numero da conta vazio.
     */
    @Test
    public void nao_deve_aceitar_numero_da_conta_vazio() {
        conta.setNumero("");
        assertFalse(ValidaBanco.valida(conta));
    }

    /**
     * Nao deve aceitar numero da conta maior que vinte caracteres.
     */
    @Test
    public void nao_deve_aceitar_numero_da_conta_maior_que_vinte_caracteres() {
        String maior = "1";
        for(int i = 0 ; i < 20 ; i++) {
            maior += "1";
        }
        conta.setNumero(maior);
        assertFalse(ValidaBanco.valida(conta));
    }

    /**
     * Nao deve aceitar numero da conta com letras.
     */
    @Test
    public void nao_deve_aceitar_numero_da_conta_com_letras() {
        conta.setNumero("123a");
        assertFalse(ValidaBanco.valida(conta));
    }

    /**
     * Nao deve aceitar numero da conta com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_numero_da_conta_com_caracteres_especiais() {
        conta.setNumero("#123");
        assertFalse(ValidaBanco.valida(conta));
    }

    /**
     * Deve aceitar somente numero da conta nao nulo com até 20 digitos numericos.
     */
    @Test
    public void deve_aceitar_somente_numero_da_conta_nao_nulo_com_até_20_digitos_numericos() {
        conta.setNumero("123");
        assertTrue(ValidaBanco.valida(conta));
    }

    /**
     * Nao deve aceitar agencia invalido.
     */
    @Test
    public void nao_deve_aceitar_agencia_invalido() {
        EasyRandom contaInvalida = new EasyRandom(BancoTemplate.contaInvalida());
        invalida = contaInvalida.nextObject(ContaBancaria.class);
        conta.getAgencia();
        assertFalse(ValidaBanco.valida(invalida));
    }

    /**
     * Nao deve aceitar agencia nulo.
     */
    @Test
    public void nao_deve_aceitar_agencia_nulo() {
        conta.setAgencia(null);
        assertFalse(ValidaBanco.valida(conta));
    }

    /**
     * Nao deve aceitar espaco no comeco do numero da agencia.
     */
    @Test
    public void nao_deve_aceitar_espaco_no_comeco_do_numero_da_agencia() {
        conta.setAgencia(" 4567");
        assertFalse(ValidaBanco.valida(conta));
    }

    /**
     * Nao deve aceitar numero da agencia em branco.
     */
    @Test
    public void nao_deve_aceitar_numero_da_agencia_em_branco() {
        conta.setAgencia("  ");
        assertFalse(ValidaBanco.valida(conta));
    }

    /**
     * Nao deve aceitar numero da agencia vazio.
     */
    @Test
    public void nao_deve_aceitar_numero_da_agencia_vazio() {
        conta.setAgencia("");
        assertFalse(ValidaBanco.valida(conta));
    }

    /**
     * Nao deve aceitar agencia com letras.
     */
    @Test
    public void nao_deve_aceitar_agencia_com_letras() {
        conta.setAgencia("456a");
        assertFalse(ValidaBanco.valida(conta));
    }

    /**
     * Nao deve aceitar agencia com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_agencia_com_caracteres_especiais() {
        conta.setAgencia("456%");
        assertFalse(ValidaBanco.valida(conta));
    }

    /**
     * Nao deve aceitar agencia com numero negativo.
     */
    @Ignore
    @Test
    public void nao_deve_aceitar_agencia_com_numero_negativo() {
        conta.setAgencia("-4567");
    }

    /**
     * Deve aceitar agencia nao nula somente com quatro digitos numericos.
     */
    @Test
    public void deve_aceitar_agencia_nao_nula_somente_com_quatro_digitos_numericos() {
        assertTrue(ValidaBanco.valida(conta));
    }

    /**
     * Nao deve aceitar agencia com menos de quatro digitos.
     */
    @Test
    public void nao_deve_aceitar_agencia_com_menos_de_quatro_digitos() {
        conta.setAgencia("456");
        assertFalse(ValidaBanco.valida(conta));
    }

    /**
     * Nao deve aceitar agencia com mais de quatro digitos.
     */
    @Test
    public void nao_deve_aceitar_agencia_com_mais_de_quatro_digitos() {
        conta.setAgencia("45678");
        assertFalse(ValidaBanco.valida(conta));
    }

    /**
     * Testa propriedade reflexiva equals.
     */
    @Test
    public void testa_propriedade_reflexiva_equals() {
        assertEquals(conta, conta);
    }

    /**
     * Testa propriedade simetrica equals.
     */
    @Test
    public void testa_propriedade_simetrica_equals() {
        ContaBancaria conta1 = new ContaBancaria("José", "123", "4567");
        ContaBancaria conta2 = new ContaBancaria("José", "123", "4567");
        assertEquals(conta1, conta2);
        assertEquals(conta2, conta1);
    }

    /**
     * Testa propriedade transitiva equals.
     */
    @Test
    public void testa_propriedade_transitiva_equals() {
        ContaBancaria conta0 = new ContaBancaria("José", "123", "4567");
        ContaBancaria conta1 = new ContaBancaria("José", "123", "4567");
        ContaBancaria conta2 = new ContaBancaria("José", "123", "4567");
        assertEquals(conta0, conta1);
        assertEquals(conta1, conta2);
        assertEquals(conta0, conta2);
    }

    /**
     * Testa consistencia null equals.
     */
    @Test
    public void testa_consistencia_null_equals() {
        assertFalse(conta.equals(null));
    }

    /**
     * Equals deve retornar false se titular igual numero e agencia diferentes.
     */
    @Test
    public void equals_deve_retornar_false_se_titular_igual_numero_e_agencia_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("José", "321", "7654");
        assertNotEquals(conta, conta1);
    }

    /**
     * Equals deve retornar false se titular numero e agencia diferentes.
     */
    @Test
    public void equals_deve_retornar_false_se_titular_numero_e_agencia_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("Joao", "321", "7654");
        assertNotEquals(conta, conta1);
    }

    /**
     * Equals deve retornar false se titular e numero igual e agencia diferentes.
     */
    @Test
    public void equals_deve_retornar_false_se_titular_e_numero_igual_e_agencia_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("José", "123", "7654");
        assertNotEquals(conta, conta1);
    }

    /**
     * Equals deve retornar false se titular e agencia igual e numero diferentes.
     */
    @Test
    public void equals_deve_retornar_false_se_titular_e_agencia_igual_e_numero_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("José", "321", "4567");
        assertNotEquals(conta, conta1);
    }

    /**
     * Equals deve retornar false se titular e agencia diferentes e numero igual.
     */
    @Test
    public void equals_deve_retornar_false_se_titular_e_agencia_diferentes_e_numero_igual() {
        ContaBancaria conta1 = new ContaBancaria("Joao", "123", "7654");
        assertNotEquals(conta, conta1);
    }

    /**
     * Equals deve retornar false se titular e numero diferentes e agencia igual.
     */
    @Test
    public void equals_deve_retornar_false_se_titular_e_numero_diferentes_e_agencia_igual() {
        ContaBancaria conta1 = new ContaBancaria("Joao", "321", "4567");
        assertNotEquals(conta, conta1);
    }

    /**
     * Equals deve retornar true se numero e agencia iguais e titular diferente.
     */
    @Test
    public void equals_deve_retornar_true_se_numero_e_agencia_iguais_e_titular_diferente() {
        ContaBancaria conta0 = new ContaBancaria("Jose", "123", "4567");
        ContaBancaria conta1 = new ContaBancaria("Joao", "123", "4567");
        assertEquals(conta0, conta1);
    }

    /**
     * Equals deve retornar true se numero agencia e titular iguais.
     */
    @Test
    public void equals_deve_retornar_true_se_numero_agencia_e_titular_iguais() {
        ContaBancaria conta0 = new ContaBancaria("José", "123", "4567");
        ContaBancaria conta1 = new ContaBancaria("José", "123", "4567");
        assertEquals(conta0, conta1);
    }

    /**
     * Hashcode deve ser diferente se titular igual numero e agencia diferentes.
     */
    @Test
    public void hashcode_deve_ser_diferente_se_titular_igual_numero_e_agencia_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("José", "321", "7654");
        assertNotEquals(conta.hashCode(), conta1.hashCode());
    }

    /**
     * Hashcode deve ser diferente se titular numero e agencia diferentes.
     */
    @Test
    public void hashcode_deve_ser_diferente_se_titular_numero_e_agencia_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("Joao", "321", "7654");
        assertNotEquals(conta.hashCode(), conta1.hashCode());
    }

    /**
     * Hashcode deve ser diferente se titular e numero igual e agencia diferentes.
     */
    @Test
    public void hashcode_deve_ser_diferente_se_titular_e_numero_igual_e_agencia_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("José", "123", "7654");
        assertNotEquals(conta.hashCode(), conta1.hashCode());
    }

    /**
     * Hashcode deve ser diferente se titular e agencia igual e numero diferentes.
     */
    @Test
    public void hashcode_deve_ser_diferente_se_titular_e_agencia_igual_e_numero_diferentes() {
        ContaBancaria conta1 = new ContaBancaria("José", "321", "4567");
        assertNotEquals(conta.hashCode(), conta1.hashCode());
    }

    /**
     * Hashcode deve ser diferente se titular e agencia diferentes e numero igual.
     */
    @Test
    public void hashcode_deve_ser_diferente_se_titular_e_agencia_diferentes_e_numero_igual() {
        ContaBancaria conta1 = new ContaBancaria("Joao", "123", "7654");
        assertNotEquals(conta.hashCode(), conta1.hashCode());
    }

    /**
     * Hashcode deve ser diferente se titular e numero diferentes e agencia igual.
     */
    @Test
    public void hashcode_deve_ser_diferente_se_titular_e_numero_diferentes_e_agencia_igual() {
        ContaBancaria conta1 = new ContaBancaria("Joao", "321", "4567");
        assertNotEquals(conta.hashCode(), conta1.hashCode());
    }

    /**
     * Hashcode deve ser igual se numero e agencia iguais e titular diferente.
     */
    @Test
    public void hashcode_deve_ser_igual_se_numero_e_agencia_iguais_e_titular_diferente() {
        ContaBancaria conta0 = new ContaBancaria("José", "123", "4567");
        ContaBancaria conta1 = new ContaBancaria("Joao", "123", "4567");
        assertEquals(conta0.hashCode(), conta1.hashCode());
    }

    /**
     * Hashcode deve ser igual se numero agencia e titular iguais.
     */
    @Test
    public void hashcode_deve_ser_igual_se_numero_agencia_e_titular_iguais() {
        ContaBancaria conta0 = new ContaBancaria("José", "123", "4567");
        ContaBancaria conta1 = new ContaBancaria("José", "123", "4567");
        assertEquals(conta0.hashCode(), conta1.hashCode());
    }

    /**
     * Deve conter o valor do numero da conta na string gerada.
     */
    @Test
    public void deve_conter_o_valor_do_numero_da_conta_na_string_gerada() {
        String toStringConta = conta.toString();
        assertTrue(toStringConta.contains(conta.getNumero()));
    }

    /**
     * Deve conter o valor do numero da agencia na string gerada.
     */
    @Test
    public void deve_conter_o_valor_do_numero_da_agencia_na_string_gerada() {
        String toStringConta = conta.toString();
        assertTrue(toStringConta.contains(conta.getAgencia()));
    }

    /**
     * Deve conter o valor do nome do titular na string gerada.
     */
    @Test
    public void deve_conter_o_valor_do_nome_do_titular_na_string_gerada() {
        String toStringConta = conta.toString();
        assertTrue(toStringConta.contains(conta.getTitular()));
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.simple().forClass(ContaBancaria.class).withIgnoredFields("titular").verify();
    }

}
