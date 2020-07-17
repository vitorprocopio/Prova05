package br.com.contmatic.hora;

import org.joda.time.LocalTime;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class HorarioTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Horario.class).addTemplate("valido", new Rule() {
            {
                add("entrada", random(new LocalTime(7, 00, 00), new LocalTime(8, 30, 00), new LocalTime(9, 00, 00)));
                add("saidaAlmoco", random(new LocalTime(11, 00, 00), new LocalTime(12, 00, 00), new LocalTime(13, 30, 00)));
                add("retornoAlmoco", random(new LocalTime(12, 00, 00), new LocalTime(12, 30, 00), new LocalTime(15, 00, 00)));
                add("saida", random(new LocalTime(18, 00, 00), new LocalTime(19, 30, 00), new LocalTime(20, 00, 00)));
            }
        });
        Fixture.of(Horario.class).addTemplate("entradaInvalido").inherits("valido", new Rule() {
            {
                add("entrada", random(new LocalTime(6,59,59), new LocalTime(18,00,01), new LocalTime(19,59,59)));
            }
        });
        Fixture.of(Horario.class).addTemplate("saidaAlmocoInvalido").inherits("valido", new Rule() {
            {
                add("saidaAlmoco", random(new LocalTime(10,59,59), new LocalTime(14,00,01), new LocalTime(14,59,59)));
            }
        });
        Fixture.of(Horario.class).addTemplate("retornoAlmocoInvalido").inherits("valido", new Rule() {
            {
                add("retornoAlmoco", random(new LocalTime(11,59,59), new LocalTime(11,30,01), new LocalTime(15,59,59)));
            }
        });
        Fixture.of(Horario.class).addTemplate("saidaInvalido").inherits("valido", new Rule() {
            {
                add("saida", random(new LocalTime(6,59,59), new LocalTime(7,59,59), new LocalTime(20,00,01)));
            }
        });
    }

}
