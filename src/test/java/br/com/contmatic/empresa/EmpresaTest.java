package br.com.contmatic.empresa;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.six2six.fixturefactory.Fixture;

// TODO: Auto-generated Javadoc
/**
 * The Class EmpresaTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EmpresaTest {

    /** The empresa. */
    private Empresa empresa;

    /**
     * Load.
     */
    @BeforeClass
    public static void load() {
        new EmpresaTemplate().load();
    }

    /**
     * Init.
     */
    @Before
    public void init() {
        empresa = Fixture.from(Empresa.class).gimme("valido");
    }

    /**
     * Nao deve aceitar codigo invalido.
     */
    @Test
    public void nao_deve_aceitar_codigo_invalido() {
        empresa.getCodigo();
        assertFalse(ValidaEmpresa.valida(Fixture.from(Empresa.class).gimme("codigoInvalido")));
    }

    /**
     * Nao deve aceitar codigo nulo.
     */
    @Test
    public void nao_deve_aceitar_codigo_nulo() {
        empresa.setCodigo(null);
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar codigo em branco.
     */
    @Test
    public void nao_deve_aceitar_codigo_em_branco() {
        empresa.setCodigo("   ");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar codigo vazio.
     */
    @Test
    public void nao_deve_aceitar_codigo_vazio() {
        empresa.setCodigo("");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar codigo com mais de cinco digitos.
     */
    @Test
    public void nao_deve_aceitar_codigo_com_mais_de_cinco_digitos() {
        empresa.setCodigo("100000");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar codigo com letras.
     */
    @Test
    public void nao_deve_aceitar_codigo_com_letras() {
        empresa.setCodigo("123a");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar codigo com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_codigo_com_caracteres_especiais() {
        empresa.setCodigo("1234@");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar codigo com espacos.
     */
    @Test
    public void nao_deve_aceitar_codigo_com_espacos() {
        empresa.setCodigo("12 34");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Deve aceitar codigo nao nulo com ate 5 digitos numericos.
     */
    @Test
    public void deve_aceitar_codigo_nao_nulo_com_ate_5_digitos_numericos() {
        empresa.getCodigo();
        assertTrue(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar cnpj invalido.
     */
    @Test
    public void nao_deve_aceitar_cnpj_invalido() {
        empresa.getCnpj();
        assertFalse(ValidaEmpresa.valida(Fixture.from(Empresa.class).gimme("cnpjInvalido")));
    }

    /**
     * Nao deve aceitar cnpj nulo.
     */
    @Test
    public void nao_deve_aceitar_cnpj_nulo() {
        empresa.setCnpj(null);
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar cnpj com todos os digitos repetidos.
     */
    @Test
    public void nao_deve_aceitar_cnpj_com_todos_os_digitos_repetidos() {
        String repetido = "";
        for(int i = 0 ; i < 10 ; i++) {
            for(int cont = 0 ; cont < 14 ; cont++) {
                repetido += Integer.toString(i);
            }
            empresa.setCnpj(repetido);
            repetido = "";
        }
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar numero do cnpj em branco.
     */
    @Test
    public void nao_deve_aceitar_numero_do_cnpj_em_branco() {
        empresa.setCnpj("              ");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar numero do cnpj vazio.
     */
    @Test
    public void nao_deve_aceitar_numero_do_cnpj_vazio() {
        empresa.setCnpj("");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar cnpj com espacos.
     */
    @Test
    public void nao_deve_aceitar_cnpj_com_espacos() {
        empresa.setCnpj("5811937 000177");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar cnpj com letras.
     */
    @Test
    public void nao_deve_aceitar_cnpj_com_letras() {
        empresa.setCnpj("5811937100017a");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar cnpj com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_cnpj_com_caracteres_especiais() {
        empresa.setCnpj("5811937100017@");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar cnpj com menos de onze digitos.
     */
    @Test
    public void nao_deve_aceitar_cnpj_com_menos_de_onze_digitos() {
        empresa.setCnpj("5811937100017");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar cnpj com mais de onze digitos.
     */
    @Test
    public void nao_deve_aceitar_cnpj_com_mais_de_onze_digitos() {
        empresa.setCnpj("581193710001777");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar cnpj com decimo terceiro digito invalido.
     */
    @Test
    public void nao_deve_aceitar_cnpj_com_decimo_terceiro_digito_invalido() {
        empresa.setCnpj("58119371000167");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar cnpj com decimo quarto digito invalido.
     */
    @Test
    public void nao_deve_aceitar_cnpj_com_decimo_quarto_digito_invalido() {
        empresa.setCnpj("58119371000178");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Deve aceitar cnpj valido.
     */
    @Test
    public void deve_aceitar_cnpj_valido() {
        empresa.getCnpj();
        assertTrue(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar nome fantasia invalido.
     */
    @Test
    public void nao_deve_aceitar_nome_fantasia_invalido() {
        empresa.getCnpj();
        assertFalse(ValidaEmpresa.valida(Fixture.from(Empresa.class).gimme("nomeFantasiaInvalido")));
    }

    /**
     * Nao deve aceitar nome fantasia nulo.
     */
    @Test
    public void nao_deve_aceitar_nome_fantasia_nulo() {
        empresa.setNomeFantasia(null);
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar espaco no comeco do nome fantasia.
     */
    @Test
    public void nao_deve_aceitar_espaco_no_comeco_do_nome_fantasia() {
        empresa.setNomeFantasia(" Contmatic");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar espaco no final do nome fantasia.
     */
    @Test
    public void nao_deve_aceitar_espaco_no_final_do_nome_fantasia() {
        empresa.setNomeFantasia("Contmatic ");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar nome fantasia em branco.
     */
    @Test
    public void nao_deve_aceitar_nome_fantasia_em_branco() {
        empresa.setNomeFantasia("  ");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar nome fantasia vazio.
     */
    @Test
    public void nao_deve_aceitar_nome_fantasia_vazio() {
        empresa.setNomeFantasia("");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar nome fantasia maior que cem caracteres.
     */
    @Test
    public void nao_deve_aceitar_nome_fantasia_maior_que_cem_caracteres() {
        String maior = "a";
        for(int i = 0 ; i < 100 ; i++) {
            maior += "a";
        }
        empresa.setNomeFantasia(maior);
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Deve aceitar nome fantasia nao nulo somente com letras e espacos de 1 até 100 caracteres.
     */
    @Test
    public void deve_aceitar_nome_fantasia_nao_nulo_somente_com_letras_e_espacos_de_1_até_100_caracteres() {
        empresa.getNomeFantasia();
        assertTrue(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar razao social invalido.
     */
    @Test
    public void nao_deve_aceitar_razao_social_invalido() {
        empresa.getCnpj();
        assertFalse(ValidaEmpresa.valida(Fixture.from(Empresa.class).gimme("razaoSocialInvalido")));
    }

    /**
     * Nao deve aceitar razao social nulo.
     */
    @Test
    public void nao_deve_aceitar_razao_social_nulo() {
        empresa.setRazaoSocial(null);
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar espaco no comeco do razao social.
     */
    @Test
    public void nao_deve_aceitar_espaco_no_comeco_do_razao_social() {
        empresa.setRazaoSocial(" Softmatic Ltda.");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar espaco no final da razao social.
     */
    @Test
    public void nao_deve_aceitar_espaco_no_final_da_razao_social() {
        empresa.setNomeFantasia("Contmatic ");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar razao social em branco.
     */
    @Test
    public void nao_deve_aceitar_razao_social_em_branco() {
        empresa.setRazaoSocial("  ");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar razao social vazio.
     */
    @Test
    public void nao_deve_aceitar_razao_social_vazio() {
        empresa.setRazaoSocial("");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar razao social maior que cem caracteres.
     */
    @Test
    public void nao_deve_aceitar_razao_social_maior_que_cem_caracteres() {
        String maior = "a";
        for(int i = 0 ; i < 100 ; i++) {
            maior += "a";
        }
        empresa.setRazaoSocial(maior);
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Deve aceitar razao social nao nulo de 1 até 100 caracteres.
     */
    @Test
    public void deve_aceitar_razao_social_nao_nulo_de_1_até_100_caracteres() {
        assertTrue(ValidaEmpresa.valida(empresa));
    }

    /**
     * Nao deve aceitar endereco nulo.
     */
    @Test
    public void nao_deve_aceitar_endereco_nulo() {
        empresa.setEnderecos(null);
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    /**
     * Deve aceitar endereco nao nulo de acordo com as regras da classe endereco.
     */
    @Test
    public void deve_aceitar_endereco_nao_nulo_de_acordo_com_as_regras_da_classe_endereco() {
        assertTrue(ValidaEmpresa.valida(empresa));
    }

}
