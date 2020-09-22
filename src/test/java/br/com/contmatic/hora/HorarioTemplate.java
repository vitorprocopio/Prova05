package br.com.contmatic.hora;

import java.util.concurrent.ThreadLocalRandom;

import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import org.joda.time.Hours;
import org.joda.time.LocalTime;

// TODO: Auto-generated Javadoc
/**
 * The Class HorarioTemplate.
 */
public class HorarioTemplate {
    
    public static LocalTime randomEntrada() {
        int hours = Hours.hoursBetween(new LocalTime(7, 00, 00), new LocalTime(18, 00, 00)).getHours();
        LocalTime randomEntrada = new LocalTime(7, 00, 00).plusHours(ThreadLocalRandom.current().nextInt(hours+1));
        return randomEntrada;
    }
    
    public static LocalTime randomEntradaInvalida() {
        int hours = Hours.hoursBetween(new LocalTime(18, 01, 00), new LocalTime(23, 59, 59)).getHours();
        LocalTime randomEntradaInvalida = new LocalTime(18, 01, 00).plusHours(ThreadLocalRandom.current().nextInt(hours+1));
        return randomEntradaInvalida;
    }
    
    public static LocalTime randomSaidaAlmoco() {
        int hours = Hours.hoursBetween(new LocalTime(11, 00, 00), new LocalTime(14, 00, 00)).getHours();
        LocalTime randomSaidaAlmoco = new LocalTime(11, 00, 00).plusHours(ThreadLocalRandom.current().nextInt(hours+1));
        return randomSaidaAlmoco;
    }
    
    public static LocalTime randomSaidaAlmocoInvalida() {
        int hours = Hours.hoursBetween(new LocalTime(14, 01, 00), new LocalTime(23, 59, 59)).getHours();
        LocalTime randomSaidaAlmocoInvalida = new LocalTime(14, 01, 00).plusHours(ThreadLocalRandom.current().nextInt(hours+1));
        return randomSaidaAlmocoInvalida;
    }
    
    public static LocalTime randomRetornoAlmoco() {
        int hours = Hours.hoursBetween(new LocalTime(12, 00, 00), new LocalTime(15, 00, 00)).getHours();
        LocalTime randomRetornoAlmoco = new LocalTime(12, 00, 00).plusHours(ThreadLocalRandom.current().nextInt(hours+1));
        return randomRetornoAlmoco;
    }
    
    public static LocalTime randomRetornoAlmocoInvalido() {
        int hours = Hours.hoursBetween(new LocalTime(15, 01, 00), new LocalTime(23, 59, 59)).getHours();
        LocalTime randomRetornoAlmocoInvalida = new LocalTime(15, 01, 00).plusHours(ThreadLocalRandom.current().nextInt(hours+1));
        return randomRetornoAlmocoInvalida;
    }
    
    public static LocalTime randomSaida() {
        int hours = Hours.hoursBetween(new LocalTime(18, 00, 00), new LocalTime(20, 00, 00)).getHours();
        LocalTime randomSaida = new LocalTime(18, 00, 00).plusHours(ThreadLocalRandom.current().nextInt(hours+1));
        return randomSaida;
    }

    public static LocalTime randomSaidaInvalida() {
        int hours = Hours.hoursBetween(new LocalTime(20, 01, 00), new LocalTime(23, 59, 59)).getHours();
        LocalTime randomSaidaInvalida = new LocalTime(20, 01, 00).plusHours(ThreadLocalRandom.current().nextInt(hours+1));
        return randomSaidaInvalida;
    }
    
    public static EasyRandomParameters horarioValido() {
        EasyRandomParameters horarioValido = new EasyRandomParameters()
                .randomize(FieldPredicates.named("entrada").and(FieldPredicates.inClass(Horario.class)), () -> randomEntrada())
                .randomize(FieldPredicates.named("saidaAlmoco").and(FieldPredicates.inClass(Horario.class)), () -> randomSaidaAlmoco())
                .randomize(FieldPredicates.named("retornoAlmoco").and(FieldPredicates.inClass(Horario.class)), () -> randomRetornoAlmoco())
                .randomize(FieldPredicates.named("saida").and(FieldPredicates.inClass(Horario.class)), () -> randomSaida());
        return horarioValido;
    }
    
    public static EasyRandomParameters horarioInvalido() {
        EasyRandomParameters horarioValido = new EasyRandomParameters()
                .randomize(FieldPredicates.named("entrada").and(FieldPredicates.inClass(Horario.class)), () -> randomEntradaInvalida())
                .randomize(FieldPredicates.named("saidaAlmoco").and(FieldPredicates.inClass(Horario.class)), () -> randomSaidaAlmocoInvalida())
                .randomize(FieldPredicates.named("retornoAlmoco").and(FieldPredicates.inClass(Horario.class)), () -> randomRetornoAlmocoInvalido())
                .randomize(FieldPredicates.named("saida").and(FieldPredicates.inClass(Horario.class)), () -> randomSaidaInvalida());
        return horarioValido;
    }
//    /**
//     * Load.
//     */
//    @Override
//    public void load() {
//        Fixture.of(Horario.class).addTemplate("valido", new Rule() {
//            {
//                add("entrada", random(new LocalTime(7, 00, 00), new LocalTime(8, 30, 00), new LocalTime(9, 00, 00)));
//                add("saidaAlmoco", random(new LocalTime(11, 00, 00), new LocalTime(12, 00, 00), new LocalTime(13, 30, 00)));
//                add("retornoAlmoco", random(new LocalTime(12, 00, 00), new LocalTime(12, 30, 00), new LocalTime(15, 00, 00)));
//                add("saida", random(new LocalTime(18, 00, 00), new LocalTime(19, 30, 00), new LocalTime(20, 00, 00)));
//            }
//        });
//        Fixture.of(Horario.class).addTemplate("entradaInvalido").inherits("valido", new Rule() {
//            {
//                add("entrada", random(new LocalTime(6, 59, 59), new LocalTime(18, 00, 01), new LocalTime(19, 59, 59)));
//            }
//        });
//        Fixture.of(Horario.class).addTemplate("saidaAlmocoInvalido").inherits("valido", new Rule() {
//            {
//                add("saidaAlmoco", random(new LocalTime(10, 59, 59), new LocalTime(14, 00, 01), new LocalTime(14, 59, 59)));
//            }
//        });
//        Fixture.of(Horario.class).addTemplate("retornoAlmocoInvalido").inherits("valido", new Rule() {
//            {
//                add("retornoAlmoco", random(new LocalTime(11, 59, 59), new LocalTime(11, 30, 01), new LocalTime(15, 59, 59)));
//            }
//        });
//        Fixture.of(Horario.class).addTemplate("saidaInvalido").inherits("valido", new Rule() {
//            {
//                add("saida", random(new LocalTime(6, 59, 59), new LocalTime(7, 59, 59), new LocalTime(20, 00, 01)));
//            }
//        });
//    }

}
