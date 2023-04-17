package org.itson.dominio;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Descripción de la clase: Esta clase es el dominio de una clase padre que
 * representa a un vehículo y se realiza el mapeo en la base de datos
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
@Entity
@DiscriminatorValue(value = "automovil")
public class Automovil extends Vehiculo implements Serializable {

    /**
     * Constructor vacio de la clase Automovil
     */
    public Automovil() {
        super();
    }

    /**
     * Constructor de la clase Automovil
     *
     * @param idVehiculo Identificado del automovil
     * @param numeroSerie Numero de serie del automovil
     * @param marca Marca del automovil
     * @param color Color del automovil
     * @param modelo Modelo del automovil
     * @param linea Linea del automovil
     */
    public Automovil(Long idVehiculo, String numeroSerie, String marca, String color, String modelo, String linea) {
        super(idVehiculo, numeroSerie, marca, color, modelo, linea);
    }

    /**
     * Constructor de la clase Automovil
     *
     * @param numeroSerie Numero de serie del automovil
     * @param marca Marca del automovil
     * @param color Color del automovil
     * @param modelo Modelo del automovil
     * @param linea Linea del automovil
     */
    public Automovil(String numeroSerie, String marca, String color, String modelo, String linea) {
        super(numeroSerie, marca, color, modelo, linea);
    }

}
