package br.com.contmatic.empresa;

import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.enums.Estado;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EmpresaTemplate implements TemplateLoader {
    
    Endereco endereco1 = new Endereco("01234567", "Rua 1 de Abril", 1, "Bloco 1 Apto 102", "Bairro Um", "São Paulo", Estado.SP, "Brasil");
    Endereco endereco2 = new Endereco ("03315000", "Rua Padre Estevão Pernet", 215, null, "Tatuapé", "São Paulo", Estado.SP, "Brasil");
    
    @Override
    public void load() {
        Fixture.of(Empresa.class).addTemplate("valido", new Rule() {
            {
                add("codigo", random("123", "0009", "99999", "4321", "1", "095", "0000"));
                add("nomeFantasia", name());
                add("razaoSocial", name());
                add("cnpj", cnpj());
                add("endereco", random(endereco1, endereco2));
//                add("endereco", one(Endereco.class, "valido"));
            }
        });
        Fixture.of(Empresa.class).addTemplate("codigoInvalido").inherits("valido", new Rule() {
            {
                add("codigo", random("@1234", "12 34", "Cod01", "4321#", "12&34", "123456", "-1"));
            }
        });
        Fixture.of(Empresa.class).addTemplate("cnpjInvalido").inherits("valido", new Rule() {
            {
                add("cnpj", random("0", "-1", "-99999", "-100000", "100000", "13084850001234", "77831284835875", "7783128483111A", "Z7834781284834", "@7736483128483", "7749683 284834"));
            }
        });
        Fixture.of(Empresa.class).addTemplate("razaoSocialInvalido").inherits("valido", new Rule() {
            {
                add("razaoSocial", random("", "   ", " Pedro 01", "Maria & Joaquim "));
            }
        });
        Fixture.of(Empresa.class).addTemplate("nomeFantasiaInvalido").inherits("valido", new Rule() {
            {
                add("nomeFantasia", random("", "   ", " Pedro 01", "Maria & Joaquim "));
            }
        });
    }

}