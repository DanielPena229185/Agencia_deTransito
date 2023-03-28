package dominio;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Daniel Alameda, Daniel Peña
 */
@Entity
@Table(name = "automovil")
@PrimaryKeyJoinColumn(name = "id_vehiculo")
public class Automovil extends Vehiculo implements Serializable {

    public Automovil() {
    }

    public Automovil(String numeroSerie, String marca, String color, String modelo, String linea) {
        super(numeroSerie, marca, color, modelo, linea);
    }

    public Automovil(Long idVehiculo, String numeroSerie, String marca, String color, String modelo, String linea) {
        super(idVehiculo, numeroSerie, marca, color, modelo, linea);
    }

}
