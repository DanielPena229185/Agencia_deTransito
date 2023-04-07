package org.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Daniel Alameda, Daniel Peña
 */
@Entity
@DiscriminatorValue(value = "placa")
public class Placa extends Tramite implements Serializable {

    @Column(name = "numero_placa", nullable = true, unique = true, length = 7)
    private String numeroPlaca;

    @Column(name = "fecha_recepcion", nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar fechaRecepcion;

    //Relaciones
    // Relacion vehiculo
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_vehiculo", nullable = true)
    private Vehiculo vehiculo;

    public Placa() {
        super();
    }

    public Placa(String numeroPlaca, Calendar fechaRecepcion, Vehiculo vehiculo, EstadoTramite estado, Float precio, Calendar fechaExpedicion, List<Pago> pago, Persona persona) {
        super(estado, precio, fechaExpedicion, persona);
        this.numeroPlaca = numeroPlaca;
        this.fechaRecepcion = fechaRecepcion;
        this.vehiculo = vehiculo;
    }

    public Placa(String numeroPlaca, Calendar fechaRecepcion, Vehiculo vehiculo, Long idTramite, EstadoTramite estado, Float precio, Calendar fechaExpedicion, List<Pago> pago, Persona persona) {
        super(idTramite, estado, precio, fechaExpedicion, pago, persona);
        this.numeroPlaca = numeroPlaca;
        this.fechaRecepcion = fechaRecepcion;
        this.vehiculo = vehiculo;
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

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

}
