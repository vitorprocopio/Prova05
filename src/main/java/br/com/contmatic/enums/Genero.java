package br.com.contmatic.enums;

public enum Genero {
    
    F("Feminino"), 
    M("Masculino"), 
    TO("Outro");

    String descricao;
    
    Genero(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return descricao;
    }

}
