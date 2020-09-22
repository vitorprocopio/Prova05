package br.com.contmatic.enums;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Enum Genero.
 */
public enum Genero {

                    /** The f. */
                    F("Feminino"),

                    /** The m. */
                    M("Masculino"),

                    /** The o. */
                    O("Outro");

    /** The descricao. */
    String descricao;

    /**
     * Instantiates a new genero.
     *
     * @param descricao the descricao
     */
    Genero(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Gets the nome.
     *
     * @return the nome
     */
    public String getNome() {
        return descricao;
    }
    
    public static Genero randomSexo(){
        Random random = new Random();
        int indice = random.nextInt(3);
        
        Genero sexo = Genero.values()[indice];
        return sexo;
    }
}
