package br.com.contmatic.contato;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.six2six.fixturefactory.Fixture;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ContatoTest {

    private Contato contato;

    // @Before
    // public void init() {
    // contato = new Contato("12345678", "987654321", "123456789", "email@contato.com.br");
    // }

    @BeforeClass
    public static void load() {
        new ContatoTemplate().load();
    }

    @Before
    public void init() {
        contato = Fixture.from(Contato.class).gimme("valido");
    }

    @Test
    public void nao_deve_aceitar_telefone_invalido() {
        contato.getTelefone();
        assertFalse(ValidaContato.valida(Fixture.from(Contato.class).gimme("telefoneInvalido")));
    }

    @Test
    public void nao_deve_aceitar_telefone_com_menos_8_dígitos() {
        contato.setTelefone("1234567");
        assertFalse(ValidaContato.valida(contato));
    }

    @Test
    public void nao_deve_aceitar_telefone_com_mais_8_dígitos() {
        contato.setTelefone("123456789");
        assertFalse(ValidaContato.valida(contato));
    }

    @Test
    public void nao_deve_aceitar_telefone_com_letras() {
        contato.setTelefone("1234567a");
        assertFalse(ValidaContato.valida(contato));
    }

    @Test
    public void nao_deve_aceitar_telefone_com_caracteres_especiais() {
        contato.setTelefone("1234567@");
        assertFalse(ValidaContato.valida(contato));
    }

    @Test
    public void nao_deve_aceitar_telefone_com_espacos() {
        contato.setTelefone(" 234 678");
        assertFalse(ValidaContato.valida(contato));
    }

    @Test
    public void deve_aceitar_telefone_somente_com_8_digitos_numericos() {
        assertTrue(ValidaContato.valida(contato));
    }

    @Test
    public void nao_deve_aceitar_celular_invalido() {
        contato.getTelefone();
        assertFalse(ValidaContato.valida(Fixture.from(Contato.class).gimme("celularInvalido")));
    }
    
    @Test
    public void nao_deve_aceitar_celular_com_mais_9_dígitos() {
        contato.setCelular("1234567890");
        assertFalse(ValidaContato.valida(contato));
    }

    @Test
    public void nao_deve_aceitar_celular_com_menos_9_dígitos() {
        contato.setCelular("12345678");
        assertFalse(ValidaContato.valida(contato));
    }

    @Test
    public void nao_deve_aceitar_celular_com_letras() {
        contato.setTelefone("1234567a");
        assertFalse(ValidaContato.valida(contato));
    }

    @Test
    public void nao_deve_aceitar_celular_com_caracteres_especiais() {
        contato.setTelefone("12345678@");
        assertFalse(ValidaContato.valida(contato));
    }

    @Test
    public void nao_deve_aceitar_celular_com_espacos() {
        contato.setTelefone(" 234 6789");
        assertFalse(ValidaContato.valida(contato));
    }

    @Test
    public void deve_aceitar_celular_somente_com_8_digitos_numericos() {
        assertTrue(ValidaContato.valida(contato));
    }

    @Test
    public void nao_deve_aceitar_recado_invalido() {
        contato.getTelefone();
        assertFalse(ValidaContato.valida(Fixture.from(Contato.class).gimme("recadoInvalido")));
    }
    
    @Test
    public void nao_deve_aceitar_recado_com_mais_9_dígitos() {
        contato.setRecado("1234567890");
        assertFalse(ValidaContato.valida(contato));
    }

    @Test
    public void nao_deve_aceitar_recado_com_menos_8_dígitos() {
        contato.setRecado("1234567");
        assertFalse(ValidaContato.valida(contato));
    }

    @Test
    public void nao_deve_aceitar_recado_com_letras() {
        contato.setTelefone("1234567a");
        assertFalse(ValidaContato.valida(contato));
    }

    @Test
    public void nao_deve_aceitar_recado_com_caracteres_especiais() {
        contato.setTelefone("12345678@");
        assertFalse(ValidaContato.valida(contato));
    }

    @Test
    public void nao_deve_aceitar_recado_com_espacos() {
        contato.setTelefone(" 234 6789");
        assertFalse(ValidaContato.valida(contato));
    }

    @Test
    public void deve_aceitar_recado_somente_com_8_digitos_numericos() {
        assertTrue(ValidaContato.valida(contato));
    }
    
    @Test
    public void nao_deve_aceitar_email_invalido() {
        contato.getEmail();
        assertFalse(ValidaContato.valida(Fixture.from(Contato.class).gimme("emailInvalido")));
    }

    @Test
    public void nao_deve_aceitar_email_com_mais_250_caracteres() {
        String letra = "a";
        for(int i = 0 ; i < 250 ; i++) {
            letra += "a";
        }
        contato.setEmail(letra);
        assertFalse(ValidaContato.valida(contato));
    }

    @Test
    public void nao_deve_aceitar_email_com_espacos() {
        contato.setEmail("email @contato.com.br");
        assertFalse(ValidaContato.valida(contato));
    }

    @Test
    public void deve_aceitar_email_sem_espacos_ate_250_caracteres() {
        assertTrue(ValidaContato.valida(contato));
    }

}
