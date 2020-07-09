package br.com.contmatic.enums;

public enum Estado {
    
    AC("Acre"),
    AL("Alagoas"), 
    AM("Amazonas"), 
    AP("Amapá"),
    BA("Bahia"), 
    CE("Ceará"), 
    DF("Destrito federal"), 
    ES("Espírito Santo"), 
    GO("Goiás"), 
    MA("Maranhão"), 
    MG("Minas Gerais"), 
    MS("Mato grosso do Sul"), 
    MT("Mato Grosso"), 
    PA("Pará"), 
    PB("Paraíba"), 
    PE("Pernambucanas"), 
    PI("Piauí"), 
    PR("Paraná"), 
    RJ("Rio de Janeiro"), 
    RN("Rio Grande do Norte"), 
    RO("Rondônia"), 
    RR("Roraima"), 
    RS("Rio Grande do Sul"), 
    SC("Santa Catarina"), 
    SE("Sergipe"), 
    SP("São Paulo"), 
    TO("Tocantins");

    String nome;
    
    Estado(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
