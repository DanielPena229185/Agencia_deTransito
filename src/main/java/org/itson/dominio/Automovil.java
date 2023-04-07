package org.itson.dominio;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Daniel Alameda, Daniel Peña
 */
@Entity
@DiscriminatorValue(value = "automovil")
public class Automovil extends Vehiculo implements Serializable {

    /**
     * Constructor por ausencia
     */
    public Automovil() {
        super();
    }

    public Automovil(Long idVehiculo, String numeroSerie, String marca, String color, String modelo, String linea) {
        super(idVehiculo, numeroSerie, marca, color, modelo, linea);
    }

    public Automovil(String numeroSerie, String marca, String color, String modelo, String linea) {
        super(numeroSerie, marca, color, modelo, linea);
    }

}
