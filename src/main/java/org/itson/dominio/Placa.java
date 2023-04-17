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

    /**
     * Numero de placa
     */
    @Column(name = "numero_placa", nullable = true, unique = true, length = 7)
    private String numeroPlaca;

    /**
     * Fecha de recepción
     */
    @Column(name = "fecha_recepcion", nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar fechaRecepcion;

    //Relaciones
    /**
     * Vehiculo asociado a la placa
     */
    @ManyToOne(/*cascade = {CascadeType.PERSIST}*/)
    @JoinColumn(name = "id_vehiculo", nullable = true)
    private Vehiculo vehiculo;

    /**
     * Constructor vacio de la clase Placa
     */
    public Placa() {
        super();
    }

    /**
     * Constructor de la clase Placa
     *
     * @param numeroPlaca Numero de placa
     * @param fechaRecepcion Fecha de recepción de la placa
     * @param vehiculo Vehiculo asociado a la placa
     * @param estado Estado actaul de la placa
     * @param precio Precio de la placa
     * @param fechaExpedicio Fecha de expedición de la placa
     * @param pago Pago asociado a la placa
     * @param persona Persona asociada a la placa
     */
    public Placa(String numeroPlaca, Calendar fechaRecepcion, Vehiculo vehiculo, EstadoTramite estado, Float precio, Calendar fechaExpedicion, List<Pago> pago, Persona persona) {
        super(estado, precio, fechaExpedicion, persona);
        this.numeroPlaca = numeroPlaca;
        this.fechaRecepcion = fechaRecepcion;
        this.vehiculo = vehiculo;
    }

    /**
     * Constructor de la clase Placa
     *
     * @param numeroPlaca Numero placa
     * @param fechaRecepcion Fecha de recepción de la placa
     * @param vehiculo Vehiculo asociado a la placa
     * @param idTramite Identificador de la placa
     * @param estado Estado actual de la placa
     * @param precio Precio de la placa
     * @param fechaExpedicion Fecha de expedición de la placa
     * @param pago Pago asociado a la placa
     * @param persona Persona asociado a la placa
     */
    public Placa(String numeroPlaca, Calendar fechaRecepcion, Vehiculo vehiculo, Long idTramite, EstadoTramite estado, Float precio, Calendar fechaExpedicion, List<Pago> pago, Persona persona) {
        super(idTramite, estado, precio, fechaExpedicion, pago, persona);
        this.numeroPlaca = numeroPlaca;
        this.fechaRecepcion = fechaRecepcion;
        this.vehiculo = vehiculo;
    }

    /**
     * Devuelve la fecha de recepción de la placa
     *
     * @return Fecha de recepción de la placa
     */
    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Establece la fecha de recepción de la placa
     *
     * @param fechaRecepcion la fecha de recepción de la placas
     */
    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    /**
     * Devuelve el vehiculo asociado a la placa
     *
     * @return Vehiculo asociado a la placa
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Establce el vehiculo asociado a la placa
     *
     * @param vehiculo Vehiculo asociado a la placa
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Devuelve el numero de placa
     *
     * @return Numero de placa
     */
    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    /**
     * Establece el numero de placa
     *
     * @param numeroPlaca Numero de placa
     */
    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

}
