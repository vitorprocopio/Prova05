package br.com.contmatic.enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum Estado.
 */
public enum Estado {

                    /** The ac. */
                    AC("Acre"),

                    /** The al. */
                    AL("Alagoas"),

                    /** The am. */
                    AM("Amazonas"),

                    /** The ap. */
                    AP("Amapá"),

                    /** The ba. */
                    BA("Bahia"),

                    /** The ce. */
                    CE("Ceará"),

                    /** The df. */
                    DF("Destrito federal"),

                    /** The es. */
                    ES("Espírito Santo"),

                    /** The go. */
                    GO("Goiás"),

                    /** The ma. */
                    MA("Maranhão"),

                    /** The mg. */
                    MG("Minas Gerais"),

                    /** The ms. */
                    MS("Mato grosso do Sul"),

                    /** The mt. */
                    MT("Mato Grosso"),

                    /** The pa. */
                    PA("Pará"),

                    /** The pb. */
                    PB("Paraíba"),

                    /** The pe. */
                    PE("Pernambucanas"),

                    /** The pi. */
                    PI("Piauí"),

                    /** The pr. */
                    PR("Paraná"),

                    /** The rj. */
                    RJ("Rio de Janeiro"),

                    /** The rn. */
                    RN("Rio Grande do Norte"),

                    /** The ro. */
                    RO("Rondônia"),

                    /** The rr. */
                    RR("Roraima"),

                    /** The rs. */
                    RS("Rio Grande do Sul"),

                    /** The sc. */
                    SC("Santa Catarina"),

                    /** The se. */
                    SE("Sergipe"),

                    /** The sp. */
                    SP("São Paulo"),

                    /** The to. */
                    TO("Tocantins");

    /** The nome. */
    String nome;

    /**
     * Instantiates a new estado.
     *
     * @param nome the nome
     */
    Estado(String nome) {
        this.nome = nome;
    }

    /**
     * Gets the nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

}
