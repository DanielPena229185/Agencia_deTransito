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
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
@Entity
@DiscriminatorValue(value = "placa")
public class CostoPlaca extends Costo implements Serializable {

    @Column(name = "estado", nullable = true)
    @Enumerated(EnumType.STRING)
    private TipoVehiculo estado;

    public CostoPlaca() {
        super();
    }

    public CostoPlaca(TipoVehiculo tipo, Long id, double costoNormal) {
        super(id, costoNormal);
        this.estado = tipo;
    }

    public CostoPlaca(TipoVehiculo tipo, double costoNormal) {
        super(costoNormal);
        this.estado = tipo;
    }

    public TipoVehiculo getTipo() {
        return estado;
    }

    public void setTipo(TipoVehiculo tipo) {
        this.estado = tipo;
    }

}
