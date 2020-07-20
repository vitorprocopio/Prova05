package br.com.contmatic.hora;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.joda.time.LocalTime;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.six2six.fixturefactory.Fixture;

// TODO: Auto-generated Javadoc
/**
 * The Class HorarioTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HorarioTest {
    
    /** The horario. */
    private Horario horario;
//    private LocalTime entrada = new LocalTime(8, 00, 00);
//    private LocalTime saidaAlmoco = new LocalTime(12, 30, 00);
//    private LocalTime retornoAlmoco = new LocalTime(13, 30, 00);
//    private LocalTime saida = new LocalTime(18, 00, 00);
//    
//    @Before
//    public void init() {
//        horario = new Horario(entrada, saidaAlmoco, retornoAlmoco, saida);
//    }
    
    /**
 * Load.
 */
@BeforeClass
    public static void load() {
        new HorarioTemplate().load();
    }

    /**
     * Init.
     */
    @Before
    public void init() {
        horario = Fixture.from(Horario.class).gimme("valido");
    }
    
    /**
     * Finalize.
     */
    @After
    public void finalize() {
        System.out.println("Teste realizado");
    }
    
    /**
     * Nao deve aceitar entrada invalido.
     */
    @Test
    public void nao_deve_aceitar_entrada_invalido() {
        horario.getEntrada();
        assertFalse(ValidaHorario.valida(Fixture.from(Horario.class).gimme("entradaInvalido")));
    }
    
    /**
     * Nao deve aceitar entrada nulo.
     */
    @Test
    public void nao_deve_aceitar_entrada_nulo() {
        horario.setEntrada(null);
        assertFalse(ValidaHorario.valida(horario));
    }
    
    /**
     * Nao deve aceitar horario anterior a 07 00 00.
     */
    @Test
    public void nao_deve_aceitar_horario_anterior_a_07_00_00() {
        horario.setEntrada(new LocalTime(6,59,59));
        assertFalse(ValidaHorario.valida(horario));
    }
    
    /**
     * Nao deve aceitar horario posterior a 18 00 00.
     */
    @Test
    public void nao_deve_aceitar_horario_posterior_a_18_00_00() {
        horario.setEntrada(new LocalTime(18,00,01));
        assertFalse(ValidaHorario.valida(horario));
    }
    
    /**
     * Deve aceitar entrada nao nulo entre 07 00 00 e 18 00 00.
     */
    @Test
    public void deve_aceitar_entrada_nao_nulo_entre_07_00_00_e_18_00_00() {
        assertTrue(ValidaHorario.valida(horario));
    }
    
    /**
     * Nao deve aceitar saida almoco invalido.
     */
    @Test
    public void nao_deve_aceitar_saida_almoco_invalido() {
        horario.getSaidaAlmoco();
        assertFalse(ValidaHorario.valida(Fixture.from(Horario.class).gimme("saidaAlmocoInvalido")));
    }
    
    /**
     * Nao deve aceitar saida almoco nulo.
     */
    @Test
    public void nao_deve_aceitar_saida_almoco_nulo() {
        horario.setSaidaAlmoco(null);
        assertFalse(ValidaHorario.valida(horario));
    }
    
    /**
     * Nao deve aceitar saida almoco anterior a 11 00 00.
     */
    @Test
    public void nao_deve_aceitar_saida_almoco_anterior_a_11_00_00() {
        horario.setSaidaAlmoco(new LocalTime(10,59,59));
        assertFalse(ValidaHorario.valida(horario));
    }
    
    /**
     * Nao deve aceitar saida almoco posterior a 14 00 00.
     */
    @Test
    public void nao_deve_aceitar_saida_almoco_posterior_a_14_00_00() {
        horario.setSaidaAlmoco(new LocalTime(14,00,01));
        assertFalse(ValidaHorario.valida(horario));
    }
    
    /**
     * Deve aceitar saida almoco nao nulo entre 11 00 00 e 14 00 00.
     */
    @Test
    public void deve_aceitar_saida_almoco_nao_nulo_entre_11_00_00_e_14_00_00() {
        assertTrue(ValidaHorario.valida(horario));
    }
    
    /**
     * Nao deve aceitar retorno almoco invalido.
     */
    @Test
    public void nao_deve_aceitar_retorno_almoco_invalido() {
        horario.getRetornoAlmoco();
        assertFalse(ValidaHorario.valida(Fixture.from(Horario.class).gimme("retornoAlmocoInvalido")));
    }
    
    /**
     * Nao deve aceitar retorno almoco nulo.
     */
    @Test
    public void nao_deve_aceitar_retorno_almoco_nulo() {
        horario.setRetornoAlmoco(null);
        assertFalse(ValidaHorario.valida(horario));
    }
    
    /**
     * Nao deve aceitar retorno almoco anterior a 12 00 00.
     */
    @Test
    public void nao_deve_aceitar_retorno_almoco_anterior_a_12_00_00() {
        horario.setRetornoAlmoco(new LocalTime(11,59,59));
        assertFalse(ValidaHorario.valida(horario));
    }
    
    /**
     * Nao deve aceitar retorno almoco posterior a 15 00 00.
     */
    @Test
    public void nao_deve_aceitar_retorno_almoco_posterior_a_15_00_00() {
        horario.setRetornoAlmoco(new LocalTime(15,00,01));
        assertFalse(ValidaHorario.valida(horario));
    }
    
    /**
     * Deve aceitar retorno almoco nao nulo entre 12 00 00 e 15 00 00.
     */
    @Test
    public void deve_aceitar_retorno_almoco_nao_nulo_entre_12_00_00_e_15_00_00() {
        assertTrue(ValidaHorario.valida(horario));
    }
    
    /**
     * Nao deve aceitar saida invalido.
     */
    @Test
    public void nao_deve_aceitar_saida_invalido() {
        horario.getSaida();
        assertFalse(ValidaHorario.valida(Fixture.from(Horario.class).gimme("saidaInvalido")));
    }
    
    /**
     * Nao deve aceitar saida nulo.
     */
    @Test
    public void nao_deve_aceitar_saida_nulo() {
        horario.setSaida(null);
        assertFalse(ValidaHorario.valida(horario));
    }
    
    /**
     * Nao deve aceitar saida anterior a 8 00 00.
     */
    @Test
    public void nao_deve_aceitar_saida_anterior_a_8_00_00() {
        horario.setSaida(new LocalTime(7,59,59));
        assertFalse(ValidaHorario.valida(horario));
    }
    
    /**
     * Nao deve aceitar saida posterior a 20 00 00.
     */
    @Test
    public void nao_deve_aceitar_saida_posterior_a_20_00_00() {
        horario.setSaida(new LocalTime(20,00,01));
        assertFalse(ValidaHorario.valida(horario));
    }
    
    /**
     * Deve aceitar saida nao nulo entre 8 00 00 e 20 00 00.
     */
    @Test
    public void deve_aceitar_saida_nao_nulo_entre_8_00_00_e_20_00_00() {
        assertTrue(ValidaHorario.valida(horario));
    }

}
