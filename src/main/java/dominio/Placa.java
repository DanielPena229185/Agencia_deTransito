package dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Daniel Alameda, Daniel Peña
 */
@Entity
@Table(name = "placa")
@PrimaryKeyJoinColumn(name = "id_tramite")
public class Placa extends Tramite implements Serializable {

    @Column(name = "numero", nullable = false, unique = true, length = 7)
    private String numero;

    @Column(name = "fecha_recepcion", nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar fechaRecepcion;

    /**
     * Relaciones
     */
    // Relacion vehiculo
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_vehiculo", nullable = true)
    private Vehiculo vehiculo;

    public Placa() {
    }

    public Placa(String numero, Calendar fechaRecepcion, Vehiculo vehiculo, EstadoTramite estado, Float precio, Calendar fechaExpedicion, List<Pago> pago, Persona persona) {
        super(estado, precio, fechaExpedicion, pago, persona);
        this.numero = numero;
        this.fechaRecepcion = fechaRecepcion;
        this.vehiculo = vehiculo;
    }

    public Placa(String numero, Calendar fechaRecepcion, Vehiculo vehiculo, Long idTramite, EstadoTramite estado, Float precio, Calendar fechaExpedicion, List<Pago> pago) {
        super(idTramite, estado, precio, fechaExpedicion, pago);
        this.numero = numero;
        this.fechaRecepcion = fechaRecepcion;
        this.vehiculo = vehiculo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

}
