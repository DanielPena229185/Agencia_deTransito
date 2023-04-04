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
import javax.persistence.Table;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
@Entity
@Table(name = "Costos_Placa")
@DiscriminatorValue("Placas")
public class CostoPlaca extends Costo implements Serializable {

    @Column(name = "Tipo", nullable = true)
    @Enumerated(EnumType.STRING)
    private TipoVehiculo tipo;

    public CostoPlaca() {
        super();
    }

    public CostoPlaca(TipoVehiculo tipo, Long id, double costoNormal) {
        super(id, costoNormal);
        this.tipo = tipo;
    }

    public CostoPlaca(TipoVehiculo tipo, double costoNormal) {
        super(costoNormal);
        this.tipo = tipo;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

}
