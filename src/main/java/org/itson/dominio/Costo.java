/**
 * Costo.java
 * 1 abr. 2023 15:26:41
 */
package org.itson.dominio;
//importanciones

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
@Entity
@Table(name = "costos")
@DiscriminatorColumn(name = "tipo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Costo implements Serializable {

    /**
     * Identificador unico del costo
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Costo normal del costo
     */
    @Column(name = "costo_normal", nullable = false)
    private double costoNormal;

    /**
     * Constructor vacio de la clase costo
     */
    public Costo() {
    }

    /**
     * Constructor de la clase costo
     *
     * @param costoNormal Costo normal
     */
    public Costo(double costoNormal) {
        this.costoNormal = costoNormal;
    }

    /**
     * Constructor de la clase costo
     *
     * @param id Identificador del costo
     * @param costoNormal Costo normal
     */
    public Costo(Long id, double costoNormal) {
        this.id = id;
        this.costoNormal = costoNormal;
    }

    /**
     * Devuelve el identificadro del costo
     *
     * @return Identificador del costo
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador del costo
     *
     * @param id Identificador del costo
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve el costo normal del costo
     *
     * @return Costo normal del costo
     */
    public double getCostoNormal() {
        return costoNormal;
    }

    /**
     * Establece el costo normal del costo
     *
     * @param costoNormal Costo normal del costo
     */
    public void setCostoNormal(double costoNormal) {
        this.costoNormal = costoNormal;
    }

}
