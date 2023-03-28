package dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;

/**
 *
 * @author Daniel Alameda, Daniel Peña
 */
@Entity
@Table(name = "placa")
@PrimaryKeyJoinColumn(name = "id_tramite")
public class Placas extends Tramite implements Serializable {

    @Column(name = "numero", nullable = false, unique = true)
    private String numero;

    @Column(name = "fecha_recepcion", nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar fechaRecepcion;

    
}
