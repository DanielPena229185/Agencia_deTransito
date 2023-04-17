/**
 * CostoLicencia.java
 * 1 abr. 2023 16:01:20
 */
package org.itson.dominio;
//importanciones

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Descripción de la clase: Esta clase es el dominio de una clase hija de la
 * clase padre Costo que representa a un costo de una licencia y se realiza el
 * mapeo en la base de datos
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
@Entity
@DiscriminatorValue(value = "licencia")
public class CostoLicencia extends Costo implements Serializable {

    /**
     * Vigencia del costo de licencia
     */
    @Column(name = "vigencia", nullable = true)
    private String vigencia;

    /**
     * Costo de discapacitados de la licencia
     */
    @Column(name = "costo_discapacitados", nullable = true)
    private double costoDiscapacitados;

    /**
     * Constructor vacio de la clase licencia
     */
    public CostoLicencia() {
    }

    /**
     * Constructor de la clase licencia
     *
     * @param vigencia Vigencia de la licencia
     * @param costoDiscapacitados Costo de discapacitados de la licencia
     * @param costoNormal Costo normal de la licencia
     */
    public CostoLicencia(String vigencia, double costoDiscapacitados, double costoNormal) {
        super(costoNormal);
        this.vigencia = vigencia;
        this.costoDiscapacitados = costoDiscapacitados;
    }

    /**
     * Constructor de la clase licencia
     *
     * @param vigencia Vigencia de la licencia
     * @param costoDiscapacitados Costo de discapacitados de la licencia
     * @param id Identificador de la licencia
     * @param costoNormal Costo normal de la licencia
     */
    public CostoLicencia(String vigencia, double costoDiscapacitados, Long id, double costoNormal) {
        super(id, costoNormal);
        this.vigencia = vigencia;
        this.costoDiscapacitados = costoDiscapacitados;
    }

    /**
     * Devuelve la vigecnia del costo de licencia
     *
     * @return Vigencia del costo de licencia
     */
    public String getVigencia() {
        return vigencia;
    }

    /**
     * Establece la vigecnia del costo de licencia
     *
     * @param vigencia Vigencia del costo de licencia
     */
    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * Devuelve el costo de discapacitados
     *
     * @return Costo de discapacitados
     */
    public double getCostoDiscapacitados() {
        return costoDiscapacitados;
    }

    /**
     * Establece el costo de discapacitados
     *
     * @param costoDiscapacitados el costo de discapacitados
     */
    public void setCostoDiscapacitados(double costoDiscapacitados) {
        this.costoDiscapacitados = costoDiscapacitados;
    }

}
