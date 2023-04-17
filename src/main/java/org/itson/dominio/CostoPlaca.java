/**
 * CostoPlaca.java
 * 1 abr. 2023 16:06:26
 */
package org.itson.dominio;
//importanciones

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Descripción de la clase: Esta clase es el dominio de una clase hija de la
 * clase padre Costo que representa a un costo de una placa y se realiza el
 * mapeo en la base de datos
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
@Entity
@DiscriminatorValue(value = "placa")
public class CostoPlaca extends Costo implements Serializable {

    /**
     * Estado del costo de placas
     */
    @Column(name = "estado", nullable = true)
    @Enumerated(EnumType.STRING)
    private TipoVehiculo estado;

    /**
     * Constructor vacio de la calse costo placa
     */
    public CostoPlaca() {
        super();
    }

    /**
     * Constructor de la calse costo placa
     *
     * @param tipo Tipo de costo de placa
     * @param id Identificador del costo de placa
     * @param costoNormal Costo normal del costo de placa
     */
    public CostoPlaca(TipoVehiculo tipo, Long id, double costoNormal) {
        super(id, costoNormal);
        this.estado = tipo;
    }

    /**
     * Constructor de la calse costo placa
     *
     * @param tipo Tipo de costo de placa
     * @param costoNormal Costo normal del costo placa
     */
    public CostoPlaca(TipoVehiculo tipo, double costoNormal) {
        super(costoNormal);
        this.estado = tipo;
    }

    /**
     * Devuelve el tipo de costo de placa
     *
     * @return El tipo de costo de placa
     */
    public TipoVehiculo getTipo() {
        return estado;
    }

    /**
     * Establece el tipo de costo de placa
     *
     * @param tipo El tipo de costo de placa
     */
    public void setTipo(TipoVehiculo tipo) {
        this.estado = tipo;
    }

}
