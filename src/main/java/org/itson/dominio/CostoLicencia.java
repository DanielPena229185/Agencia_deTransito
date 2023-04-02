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
import javax.persistence.Table;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
@Entity
@Table(name = "Costos_Licencias")
@DiscriminatorValue("Licencias")
public class CostoLicencia extends Costo implements Serializable {

    @Column(name = "Vigencia", nullable = true)
    private String vigencia;

    @Column(name = "Costo_Discapacitados", nullable = true)
    private double costoDiscapacitados;

    /**
     *
     */
    public CostoLicencia() {
        super();
    }

    public CostoLicencia(String vigencia, double costoDiscapacitados, Long id, double costoNormal, String concepto) {
        super(id, costoNormal, concepto);
        this.vigencia = vigencia;
        this.costoDiscapacitados = costoDiscapacitados;
    }

    public CostoLicencia(String vigencia, double costoDiscapacitados, double costoNormal, String concepto) {
        super(costoNormal, concepto);
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
