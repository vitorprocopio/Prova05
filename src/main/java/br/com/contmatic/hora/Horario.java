package br.com.contmatic.hora;


import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.LocalTime;

import br.com.contmatic.annotations.HorarioEntrada;
import br.com.contmatic.annotations.HorarioRetornoAlmoco;
import br.com.contmatic.annotations.HorarioSaida;
import br.com.contmatic.annotations.HorarioSaidaAlmoco;

// TODO: Auto-generated Javadoc
/**
 * The Class Horario.
 */
public class Horario {
    
    /** The entrada. */
    @HorarioEntrada
	@NotNull(message = "Não deve conter entrada nula")
    private LocalTime entrada;
    
    /** The saida almoco. */
    @HorarioSaidaAlmoco
	@NotNull(message = "Não deve conter saida para o almoço nula")
    private LocalTime saidaAlmoco;
    
    /** The retorno almoco. */
    @HorarioRetornoAlmoco
	@NotNull(message = "Não deve conter retorno para o almoço nulo")
    private LocalTime retornoAlmoco;
    
    /** The saida. */
    @HorarioSaida
	@NotNull(message = "Não deve conter saída nula")
    private LocalTime saida;
    
    /**
     * Instantiates a new horario.
     *
     * @param entrada the entrada
     * @param saidaAlmoco the saida almoco
     * @param retornoAlmoco the retorno almoco
     * @param saida the saida
     */
    public Horario(LocalTime entrada, LocalTime saidaAlmoco, LocalTime retornoAlmoco, LocalTime saida) {
        this.setEntrada (entrada);
        this.setSaidaAlmoco(saidaAlmoco);
        this.setRetornoAlmoco(retornoAlmoco);
        this.setSaida(saida);
    }

    /**
     * Gets the entrada.
     *
     * @return the entrada
     */
    public LocalTime getEntrada() {
        return entrada;
    }

    /**
     * Sets the entrada.
     *
     * @param entrada the new entrada
     */
    public void setEntrada(LocalTime entrada) {
//        verificaHorarioNulo(entrada);
//        verificaEntrada(entrada);
        this.entrada = entrada;
    }

//    private void verificaEntrada(LocalTime entrada) {
//        if(entrada.isBefore(LocalTime.of(07, 00, 00)) || entrada.isAfter(LocalTime.of(18, 00, 00))) {
//           throw new IllegalArgumentException("Coloque um horário entre 07:00:00 e 18:00:00"); 
//        }
//    }
//
//    private void verificaHorarioNulo(LocalTime campo) {
//        if(campo == null) {
//            throw new IllegalArgumentException("O campo não deve ser nulo");
//        }
//    }

    /**
 * Gets the saida almoco.
 *
 * @return the saida almoco
 */
public LocalTime getSaidaAlmoco() {
        return saidaAlmoco;
    }

    /**
     * Sets the saida almoco.
     *
     * @param saidaAlmoco the new saida almoco
     */
    public void setSaidaAlmoco(LocalTime saidaAlmoco) {
//        verificaHorarioNulo(saidaAlmoco);
//        verificaSaidaAlmoco(saidaAlmoco);
        this.saidaAlmoco = saidaAlmoco;
    }
//
//    private void verificaSaidaAlmoco(LocalTime saidaAlmoco) {
//        if(saidaAlmoco.isBefore(LocalTime.of(11, 00, 00)) || saidaAlmoco.isAfter(LocalTime.of(14, 00, 00))) {
//           throw new IllegalArgumentException("Coloque um horário entre 11:00:00 e 14:00:00"); 
//        }
//    }

    /**
 * Gets the retorno almoco.
 *
 * @return the retorno almoco
 */
public LocalTime getRetornoAlmoco() {
        return retornoAlmoco;
    }

    /**
     * Sets the retorno almoco.
     *
     * @param retornoAlmoco the new retorno almoco
     */
    public void setRetornoAlmoco(LocalTime retornoAlmoco) {
//        verificaHorarioNulo(retornoAlmoco);
//        verificaRetornoAlmoco(retornoAlmoco);
        this.retornoAlmoco = retornoAlmoco;
    }

//    private void verificaRetornoAlmoco(LocalTime retornoAlmoco) {
//        if(retornoAlmoco.isBefore(LocalTime.of(12, 00, 00)) || retornoAlmoco.isAfter(LocalTime.of(15, 00, 00))) {
//           throw new IllegalArgumentException("Coloque um horário entre 12:00:00 e 15:00:00"); 
//        }
//    }

    /**
 * Gets the saida.
 *
 * @return the saida
 */
public LocalTime getSaida() {
        return saida;
    }

    /**
     * Sets the saida.
     *
     * @param saida the new saida
     */
    public void setSaida(LocalTime saida) {
//        verificaHorarioNulo(saida);
//        verificaSaida(saida);
        this.saida = saida;
    }

//    private void verificaSaida(LocalTime saida) {
//        if(saida.isBefore(LocalTime.of(8, 00, 00)) || saida.isAfter(LocalTime.of(20, 00, 00))) {
//           throw new IllegalArgumentException("Coloque um horário entre 8:00:00 e 20:00:00"); 
//        }
//    }

    /**
 * Equals.
 *
 * @param obj the obj
 * @return true, if successful
 */
public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    /**
     * To string.
     *
     * @return the string
     */
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
