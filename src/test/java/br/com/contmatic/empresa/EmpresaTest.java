package br.com.contmatic.empresa;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.six2six.fixturefactory.Fixture;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EmpresaTest {

    private Empresa empresa;
    // private Endereco endereco;

    @BeforeClass
    public static void load() {
        new EmpresaTemplate().load();
    }

    @Before
    public void init() {
        empresa = Fixture.from(Empresa.class).gimme("valido");
    }

    // @Before
    // public void init () {
    // endereco = new Endereco ("03315000", "Rua Padre Estevão Pernet", 215, null, "Tatuapé", "São Paulo", Estado.SP, "Brasil");
    // empresa = new Empresa("303", "58119371000177", "Contmatic", "Softmatic Ltda.", endereco);
    // }

    @Test
    public void nao_deve_aceitar_codigo_invalido() {
        empresa.getCodigo();
        assertFalse(ValidaEmpresa.valida(Fixture.from(Empresa.class).gimme("codigoInvalido")));
    }

    @Test
    public void nao_deve_aceitar_codigo_nulo() {
        empresa.setCodigo(null);
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_codigo_em_branco() {
        empresa.setCodigo("   ");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_codigo_vazio() {
        empresa.setCodigo("");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_codigo_com_mais_de_cinco_digitos() {
        empresa.setCodigo("100000");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_codigo_com_letras() {
        empresa.setCodigo("123a");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_codigo_com_caracteres_especiais() {
        empresa.setCodigo("1234@");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_codigo_com_espacos() {
        empresa.setCodigo("12 34");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void deve_aceitar_codigo_nao_nulo_com_ate_5_digitos_numericos() {
        empresa.getCodigo();
        assertTrue(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_cnpj_invalido() {
        empresa.getCnpj();
        assertFalse(ValidaEmpresa.valida(Fixture.from(Empresa.class).gimme("cnpjInvalido")));
    }

    @Test
    public void nao_deve_aceitar_cnpj_nulo() {
        empresa.setCnpj(null);
        assertFalse(ValidaEmpresa.valida(empresa));
    }

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

    @Test
    public void nao_deve_aceitar_numero_do_cnpj_em_branco() {
        empresa.setCnpj("              ");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_numero_do_cnpj_vazio() {
        empresa.setCnpj("");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_cnpj_com_espacos() {
        empresa.setCnpj("5811937 000177");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_cnpj_com_letras() {
        empresa.setCnpj("5811937100017a");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_cnpj_com_caracteres_especiais() {
        empresa.setCnpj("5811937100017@");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_cnpj_com_menos_de_onze_digitos() {
        empresa.setCnpj("5811937100017");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_cnpj_com_mais_de_onze_digitos() {
        empresa.setCnpj("581193710001777");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_cnpj_com_decimo_terceiro_digito_invalido() {
        empresa.setCnpj("58119371000167");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_cnpj_com_decimo_quarto_digito_invalido() {
        empresa.setCnpj("58119371000178");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void deve_aceitar_cnpj_valido() {
        empresa.getCnpj();
        assertTrue(ValidaEmpresa.valida(empresa));
    }
    
    @Test
    public void nao_deve_aceitar_nome_fantasia_invalido() {
        empresa.getCnpj();
        assertFalse(ValidaEmpresa.valida(Fixture.from(Empresa.class).gimme("nomeFantasiaInvalido")));
    }

    @Test
    public void nao_deve_aceitar_nome_fantasia_nulo() {
        empresa.setNomeFantasia(null);
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_espaco_no_comeco_do_nome_fantasia() {
        empresa.setNomeFantasia(" Contmatic");
        assertFalse(ValidaEmpresa.valida(empresa));
    }
    
    @Test
    public void nao_deve_aceitar_espaco_no_final_do_nome_fantasia() {
        empresa.setNomeFantasia("Contmatic ");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_nome_fantasia_em_branco() {
        empresa.setNomeFantasia("  ");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_nome_fantasia_vazio() {
        empresa.setNomeFantasia("");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_nome_fantasia_maior_que_cem_caracteres() {
        String maior = "a";
        for(int i = 0 ; i < 100 ; i++) {
            maior += "a";
        }
        empresa.setNomeFantasia(maior);
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void deve_aceitar_nome_fantasia_nao_nulo_somente_com_letras_e_espacos_de_1_até_100_caracteres() {
        empresa.getNomeFantasia();
        assertTrue(ValidaEmpresa.valida(empresa));
    }
    
    @Test
    public void nao_deve_aceitar_razao_social_invalido() {
        empresa.getCnpj();
        assertFalse(ValidaEmpresa.valida(Fixture.from(Empresa.class).gimme("razaoSocialInvalido")));
    }

    @Test
    public void nao_deve_aceitar_razao_social_nulo() {
        empresa.setRazaoSocial(null);
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_espaco_no_comeco_do_razao_social() {
        empresa.setRazaoSocial(" Softmatic Ltda.");
        assertFalse(ValidaEmpresa.valida(empresa));
    }
    
    @Test
    public void nao_deve_aceitar_espaco_no_final_da_razao_social() {
        empresa.setNomeFantasia("Contmatic ");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_razao_social_em_branco() {
        empresa.setRazaoSocial("  ");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_razao_social_vazio() {
        empresa.setRazaoSocial("");
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_razao_social_maior_que_cem_caracteres() {
        String maior = "a";
        for(int i = 0 ; i < 100 ; i++) {
            maior += "a";
        }
        empresa.setRazaoSocial(maior);
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void deve_aceitar_razao_social_nao_nulo_de_1_até_100_caracteres() {
        assertTrue(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void nao_deve_aceitar_endereco_nulo() {
        empresa.setEnderecos(null);
        assertFalse(ValidaEmpresa.valida(empresa));
    }

    @Test
    public void deve_aceitar_endereco_nao_nulo_de_acordo_com_as_regras_da_classe_endereco() {
        assertTrue(ValidaEmpresa.valida(empresa));
    }

}
