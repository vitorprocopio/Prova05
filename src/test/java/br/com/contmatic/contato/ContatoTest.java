package br.com.contmatic.contato;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.jeasy.random.EasyRandom;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import nl.jqno.equalsverifier.EqualsVerifier;

// TODO: Auto-generated Javadoc
/**
 * The Class ContatoTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ContatoTest {

    /** The contato. */
    private Contato contato;
    
    private Contato invalido;
    
    @Before
    public void init() {
        EasyRandom contatoValido = new EasyRandom(ContatoTemplate.contatoValido());
        contato = contatoValido.nextObject(Contato.class);
        System.out.println(contato);
    }

//    /**
//     * Load.
//     */
//    @BeforeClass
//    public static void load() {
//        new ContatoTemplate().load();
//    }
//
//    /**
//     * Init.
//     */
//    @Before
//    public void init() {
//        contato = Fixture.from(Contato.class).gimme("valido");
//    }

    /**
     * Nao deve aceitar telefone invalido.
     */
    @Test
    public void nao_deve_aceitar_telefone_invalido() {
        EasyRandom contatoInvalido = new EasyRandom(ContatoTemplate.contatoInvalido());
        invalido = contatoInvalido.nextObject(Contato.class);
        contato.getTelefone();
        assertFalse(ValidaContato.valida(invalido));
    }

    /**
     * Nao deve aceitar telefone com menos 8 dígitos.
     */
    @Test
    public void nao_deve_aceitar_telefone_com_menos_8_dígitos() {
        contato.setTelefone("1234567");
        assertFalse(ValidaContato.valida(contato));
    }

    /**
     * Nao deve aceitar telefone com mais 8 dígitos.
     */
    @Test
    public void nao_deve_aceitar_telefone_com_mais_8_dígitos() {
        contato.setTelefone("123456789");
        assertFalse(ValidaContato.valida(contato));
    }

    /**
     * Nao deve aceitar telefone com letras.
     */
    @Test
    public void nao_deve_aceitar_telefone_com_letras() {
        contato.setTelefone("1234567a");
        assertFalse(ValidaContato.valida(contato));
    }

    /**
     * Nao deve aceitar telefone com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_telefone_com_caracteres_especiais() {
        contato.setTelefone("1234567@");
        assertFalse(ValidaContato.valida(contato));
    }

    /**
     * Nao deve aceitar telefone com espacos.
     */
    @Test
    public void nao_deve_aceitar_telefone_com_espacos() {
        contato.setTelefone(" 234 678");
        assertFalse(ValidaContato.valida(contato));
    }

    /**
     * Deve aceitar telefone somente com 8 digitos numericos.
     */
    @Test
    public void deve_aceitar_telefone_somente_com_8_digitos_numericos() {
        assertTrue(ValidaContato.valida(contato));
    }

    /**
     * Nao deve aceitar celular invalido.
     */
    @Test
    public void nao_deve_aceitar_celular_invalido() {
        EasyRandom contatoInvalido = new EasyRandom(ContatoTemplate.contatoInvalido());
        invalido = contatoInvalido.nextObject(Contato.class);
        contato.getTelefone();
        assertFalse(ValidaContato.valida(invalido));
    }

    /**
     * Nao deve aceitar celular com mais 9 dígitos.
     */
    @Test
    public void nao_deve_aceitar_celular_com_mais_9_dígitos() {
        contato.setCelular("1234567890");
        assertFalse(ValidaContato.valida(contato));
    }

    /**
     * Nao deve aceitar celular com menos 9 dígitos.
     */
    @Test
    public void nao_deve_aceitar_celular_com_menos_9_dígitos() {
        contato.setCelular("12345678");
        assertFalse(ValidaContato.valida(contato));
    }

    /**
     * Nao deve aceitar celular com letras.
     */
    @Test
    public void nao_deve_aceitar_celular_com_letras() {
        contato.setTelefone("1234567a");
        assertFalse(ValidaContato.valida(contato));
    }

    /**
     * Nao deve aceitar celular com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_celular_com_caracteres_especiais() {
        contato.setTelefone("12345678@");
        assertFalse(ValidaContato.valida(contato));
    }

    /**
     * Nao deve aceitar celular com espacos.
     */
    @Test
    public void nao_deve_aceitar_celular_com_espacos() {
        contato.setTelefone(" 234 6789");
        assertFalse(ValidaContato.valida(contato));
    }

    /**
     * Deve aceitar celular somente com 8 digitos numericos.
     */
    @Test
    public void deve_aceitar_celular_somente_com_8_digitos_numericos() {
        assertTrue(ValidaContato.valida(contato));
    }

    /**
     * Nao deve aceitar recado invalido.
     */
    @Test
    public void nao_deve_aceitar_recado_invalido() {
        EasyRandom contatoInvalido = new EasyRandom(ContatoTemplate.contatoInvalido());
        invalido = contatoInvalido.nextObject(Contato.class);
        contato.getTelefone();
        assertFalse(ValidaContato.valida(invalido));
    }

    /**
     * Nao deve aceitar recado com mais 9 dígitos.
     */
    @Test
    public void nao_deve_aceitar_recado_com_mais_9_dígitos() {
        contato.setRecado("1234567890");
        assertFalse(ValidaContato.valida(contato));
    }

    /**
     * Nao deve aceitar recado com menos 8 dígitos.
     */
    @Test
    public void nao_deve_aceitar_recado_com_menos_8_dígitos() {
        contato.setRecado("1234567");
        assertFalse(ValidaContato.valida(contato));
    }

    /**
     * Nao deve aceitar recado com letras.
     */
    @Test
    public void nao_deve_aceitar_recado_com_letras() {
        contato.setTelefone("1234567a");
        assertFalse(ValidaContato.valida(contato));
    }

    /**
     * Nao deve aceitar recado com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_recado_com_caracteres_especiais() {
        contato.setTelefone("12345678@");
        assertFalse(ValidaContato.valida(contato));
    }

    /**
     * Nao deve aceitar recado com espacos.
     */
    @Test
    public void nao_deve_aceitar_recado_com_espacos() {
        contato.setTelefone(" 234 6789");
        assertFalse(ValidaContato.valida(contato));
    }

    /**
     * Deve aceitar recado somente com 8 digitos numericos.
     */
    @Test
    public void deve_aceitar_recado_somente_com_8_digitos_numericos() {
        assertTrue(ValidaContato.valida(contato));
    }

    /**
     * Nao deve aceitar email invalido.
     */
    @Test
    public void nao_deve_aceitar_email_invalido() {
        EasyRandom contatoInvalido = new EasyRandom(ContatoTemplate.contatoInvalido());
        invalido = contatoInvalido.nextObject(Contato.class);
        contato.getEmail();
        assertFalse(ValidaContato.valida(invalido));
    }

    /**
     * Nao deve aceitar email com mais 250 caracteres.
     */
    @Test
    public void nao_deve_aceitar_email_com_mais_250_caracteres() {
        String letra = "a";
        for(int i = 0 ; i < 250 ; i++) {
            letra += "a";
        }
        contato.setEmail(letra);
        assertFalse(ValidaContato.valida(contato));
    }

    /**
     * Nao deve aceitar email com espacos.
     */
    @Test
    public void nao_deve_aceitar_email_com_espacos() {
        contato.setEmail("email @contato.com.br");
        assertFalse(ValidaContato.valida(contato));
    }

    /**
     * Deve aceitar email sem espacos ate 250 caracteres.
     */
    @Test
    public void deve_aceitar_email_sem_espacos_ate_250_caracteres() {
        assertTrue(ValidaContato.valida(contato));
    }
    
    @Test
    public void equalsContract() {
        EqualsVerifier.simple().forClass(Contato.class).verify();
    }

}
