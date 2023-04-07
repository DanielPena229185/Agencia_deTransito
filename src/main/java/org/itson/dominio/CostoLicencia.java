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
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
@Entity
@DiscriminatorValue(value = "costo_licencia")
public class CostoLicencia extends Costo implements Serializable {

    @Column(name = "vigencia", nullable = true)
    private String vigencia;

    @Column(name = "costo_discapacitados", nullable = true)
    private double costoDiscapacitados;

    public CostoLicencia() {
    }

    public CostoLicencia(String vigencia, double costoDiscapacitados, double costoNormal) {
        super(costoNormal);
        this.vigencia = vigencia;
        this.costoDiscapacitados = costoDiscapacitados;
    }

    public CostoLicencia(String vigencia, double costoDiscapacitados, Long id, double costoNormal) {
        super(id, costoNormal);
        this.vigencia = vigencia;
        this.costoDiscapacitados = costoDiscapacitados;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public double getCostoDiscapacitados() {
        return costoDiscapacitados;
    }

    public void setCostoDiscapacitados(double costoDiscapacitados) {
        this.costoDiscapacitados = costoDiscapacitados;
    }

}
