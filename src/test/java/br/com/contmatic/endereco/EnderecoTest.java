package br.com.contmatic.endereco;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.six2six.fixturefactory.Fixture;
import nl.jqno.equalsverifier.EqualsVerifier;

// TODO: Auto-generated Javadoc
/**
 * The Class EnderecoTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EnderecoTest {

    /** The endereco. */
    private Endereco endereco;

    /**
     * Load.
     */
    @BeforeClass
    public static void load() {
        new EnderecoTemplate().load();
    }

    /**
     * Init.
     */
    @Before
    public void init() {
        endereco = Fixture.from(Endereco.class).gimme("valido");
    }

    /**
     * Nao deve aceitar cep invalido.
     */
    @Test
    public void nao_deve_aceitar_cep_invalido() {
        endereco.getCep();
        assertFalse(ValidaEndereco.valida(Fixture.from(Endereco.class).gimme("cepInvalido")));
    }

    /**
     * Nao deve aceitar cep nulo.
     */
    @Test
    public void nao_deve_aceitar_cep_nulo() {
        endereco.setCep(null);
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar cep em branco.
     */
    @Test
    public void nao_deve_aceitar_cep_em_branco() {
        endereco.setCep(" ");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar cep vazio.
     */
    @Test
    public void nao_deve_aceitar_cep_vazio() {
        endereco.setCep("");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar cep com menos de oito digitos.
     */
    @Test
    public void nao_deve_aceitar_cep_com_menos_de_oito_digitos() {
        endereco.setCep("123");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar cep com mais de oito digitos.
     */
    @Test
    public void nao_deve_aceitar_cep_com_mais_de_oito_digitos() {
        endereco.setCep("1234567890");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar cep com letras.
     */
    @Test
    public void nao_deve_aceitar_cep_com_letras() {
        endereco.setCep("1234567a");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar cep com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_cep_com_caracteres_especiais() {
        endereco.setCep("1234567@");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar cep com espacos.
     */
    @Test
    public void nao_deve_aceitar_cep_com_espacos() {
        endereco.setCep("1234 678");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Deve aceitar cep somente com 8 digitos numericos.
     */
    @Test
    public void deve_aceitar_cep_somente_com_8_digitos_numericos() {
        assertTrue(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar rua invalida.
     */
    @Test
    public void nao_deve_aceitar_rua_invalida() {
        endereco.getRua();
        assertFalse(ValidaEndereco.valida(Fixture.from(Endereco.class).gimme("ruaInvalido")));
    }

    /**
     * Nao deve aceitar rua nulo.
     */
    @Test
    public void nao_deve_aceitar_rua_nulo() {
        endereco.setRua(null);
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar nome da rua em branco.
     */
    @Test
    public void nao_deve_aceitar_nome_da_rua_em_branco() {
        endereco.setRua("   ");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar rua vazio.
     */
    @Test
    public void nao_deve_aceitar_rua_vazio() {
        endereco.setRua("");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar rua com menos de oito digitos.
     */
    @Ignore
    @Test
    public void nao_deve_aceitar_rua_com_menos_de_oito_digitos() {
        endereco.setRua("456");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar rua com mais de 100 digitos.
     */
    @Test
    public void nao_deve_aceitar_rua_com_mais_de_100_digitos() {
        String maior = "1";
        for(int i = 0 ; i < 100 ; i++) {
            maior += "1";
        }
        endereco.setRua(maior);
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar rua com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_rua_com_caracteres_especiais() {
        endereco.setRua("Rua Costa & Silva");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Deve aceitar rua nao nulo de 1 até 100 caracteres alfanumericos e espacos.
     */
    @Test
    public void deve_aceitar_rua_nao_nulo_de_1_até_100_caracteres_alfanumericos_e_espacos() {
        assertTrue(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar numero invalido.
     */
    @Test
    public void nao_deve_aceitar_numero_invalido() {
        endereco.getNumero();
        assertFalse(ValidaEndereco.valida(Fixture.from(Endereco.class).gimme("numeroInvalido")));
    }

    /**
     * Nao deve aceitar numero nulo.
     */
    @Test
    public void nao_deve_aceitar_numero_nulo() {
        endereco.setNumero(null);
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar numero maior que 99999.
     */
    @Test
    public void nao_deve_aceitar_numero_maior_que_99999() {
        endereco.setNumero(100000);
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar numero negativo.
     */
    @Test
    public void nao_deve_aceitar_numero_negativo() {
        endereco.setNumero(-1);
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Deve aceitar numero até 99999.
     */
    @Test
    public void deve_aceitar_numero_até_99999() {
        assertTrue(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar complemento invalido.
     */
    @Test
    public void nao_deve_aceitar_complemento_invalido() {
        endereco.getComplemento();
        assertFalse(ValidaEndereco.valida(Fixture.from(Endereco.class).gimme("complementoInvalido")));
    }

    /**
     * Nao deve aceitar complemento com mais de 50 digitos.
     */
    @Test
    public void nao_deve_aceitar_complemento_com_mais_de_50_digitos() {
        String maior = "1";
        for(int i = 0 ; i < 50 ; i++) {
            maior += "1";
        }
        endereco.setComplemento(maior);
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar complemento com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_complemento_com_caracteres_especiais() {
        endereco.setRua("Bloco #1 Apto. 102");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Deve aceitar complemento de 1 até 50 caracteres alfanumericos e espacos.
     */
    @Test
    public void deve_aceitar_complemento_de_1_até_50_caracteres_alfanumericos_e_espacos() {
        assertTrue(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar bairro invalido.
     */
    @Test
    public void nao_deve_aceitar_bairro_invalido() {
        endereco.getBairro();
        assertFalse(ValidaEndereco.valida(Fixture.from(Endereco.class).gimme("bairroInvalido")));
    }

    /**
     * Nao deve aceitar nome do bairro em branco.
     */
    @Test
    public void nao_deve_aceitar_nome_do_bairro_em_branco() {
        endereco.setBairro(" ");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar bairro com menos de oito digitos.
     */
    @Ignore
    @Test
    public void nao_deve_aceitar_bairro_com_menos_de_oito_digitos() {
        endereco.setBairro("456");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar bairro nulo.
     */
    @Test
    public void nao_deve_aceitar_bairro_nulo() {
        endereco.setBairro(null);
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar bairro vazio.
     */
    @Test
    public void nao_deve_aceitar_bairro_vazio() {
        endereco.setBairro("");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar bairro com mais de 50 digitos.
     */
    @Test
    public void nao_deve_aceitar_bairro_com_mais_de_50_digitos() {
        String maior = "1";
        for(int i = 0 ; i < 50 ; i++) {
            maior += "1";
        }
        endereco.setBairro(maior);
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar bairro com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_bairro_com_caracteres_especiais() {
        endereco.setBairro("Bairro #1");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Deve aceitar bairro nao nulo de 1 até 100 caracteres alfanumericos e espacos.
     */
    @Test
    public void deve_aceitar_bairro_nao_nulo_de_1_até_100_caracteres_alfanumericos_e_espacos() {
        assertTrue(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar cidade invalido.
     */
    @Test
    public void nao_deve_aceitar_cidade_invalido() {
        endereco.getCidade();
        assertFalse(ValidaEndereco.valida(Fixture.from(Endereco.class).gimme("cidadeInvalido")));
    }

    /**
     * Nao deve aceitar cidade nulo.
     */
    @Test
    public void nao_deve_aceitar_Cidade_nulo() {
        endereco.setCidade(null);
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar cidade em branco.
     */
    @Test
    public void nao_deve_aceitar_cidade_em_branco() {
        endereco.setCidade(" ");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar cidade vazio.
     */
    @Test
    public void nao_deve_aceitar_Cidade_vazio() {
        endereco.setCidade("");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar cidade com mais de 50 digitos.
     */
    @Test
    public void nao_deve_aceitar_Cidade_com_mais_de_50_digitos() {
        String maior = "1";
        for(int i = 0 ; i < 50 ; i++) {
            maior += "1";
        }
        endereco.setCidade(maior);
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar cidade com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_Cidade_com_caracteres_especiais() {
        endereco.setCidade("S@o Paulo");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Deve aceitar cidade nao nulo de 1 até 50 caracteres alfanumericos e espacos.
     */
    @Test
    public void deve_aceitar_Cidade_nao_nulo_de_1_até_50_caracteres_alfanumericos_e_espacos() {
        assertTrue(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar U F nulo.
     */
    @Test
    public void nao_deve_aceitar_UF_nulo() {
        endereco.setUf(null);
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Deve aceitar U F valido conforme enum estado.
     */
    @Test
    public void deve_aceitar_UF_valido_conforme_enum_estado() {
        assertTrue(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar pais invalido.
     */
    @Test
    public void nao_deve_aceitar_pais_invalido() {
        endereco.getCep();
        assertFalse(ValidaEndereco.valida(Fixture.from(Endereco.class).gimme("paisInvalido")));
    }

    /**
     * Nao deve aceitar pais nulo.
     */
    @Test
    public void nao_deve_aceitar_Pais_nulo() {
        endereco.setPais(null);
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar pais em branco.
     */
    @Test
    public void nao_deve_aceitar_pais_em_branco() {
        endereco.setPais(" ");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar pais vazio.
     */
    @Test
    public void nao_deve_aceitar_Pais_vazio() {
        endereco.setPais("");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar pais com mais de 50 digitos.
     */
    @Test
    public void nao_deve_aceitar_Pais_com_mais_de_50_digitos() {
        String maior = "1";
        for(int i = 0 ; i < 50 ; i++) {
            maior += "1";
        }
        endereco.setPais(maior);
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar pais com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_Pais_com_caracteres_especiais() {
        endereco.setPais("Republica Dominican@");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Nao deve aceitar pais com numeros.
     */
    @Test
    public void nao_deve_aceitar_Pais_com_numeros() {
        endereco.setPais("Republica 1");
        assertFalse(ValidaEndereco.valida(endereco));
    }

    /**
     * Deve aceitar pais nao nulo de 1 até 50 caracteres alfabeticos e espacos.
     */
    @Test
    public void deve_aceitar_Pais_nao_nulo_de_1_até_50_caracteres_alfabeticos_e_espacos() {
        assertTrue(ValidaEndereco.valida(endereco));
    }
    
    @Test
    public void equalsContract() {
        EqualsVerifier.simple().forClass(Endereco.class).withIgnoredFields("rua", "numero", "complemento", "bairro", "uf", "pais").verify();
    }

}
