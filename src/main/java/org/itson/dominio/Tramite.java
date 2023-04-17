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
@Table(name = "tramite")
@DiscriminatorColumn(name = "Tipo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Tramite implements Serializable {

    /**
     *
     * Identificador del Tramite.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTramite;

    /**
     * Estado actual de tramite
     */
    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoTramite estado;

    /**
     * Precio del tramite
     */
    @Column(name = "precio", nullable = false)
    private Float precio;

    /**
     * Fecha de expedición del tramite
     */
    @Column(name = "fecha_expedicion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaExpedicion;

    //Relaciones
    /**
     * Persona asociada al tramite
     */
    @ManyToOne()
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    /**
     * Pago asociado al tramite
     */
    @OneToMany(mappedBy = "tramite", cascade = {CascadeType.PERSIST})
    private List<Pago> pago;

    /**
     * Constructor vacio de la clase tramite
     */
    public Tramite() {
    }

    /**
     * Constructor de la clase Tramite
     *
     * @param estado Estado actual de tramite
     * @param precio Precio del tramite
     * @param fechaExpedicion Fecha de expedición del tramite
     * @param persona Persona asociada al tramite
     */
    public Tramite(EstadoTramite estado, Float precio,
            Calendar fechaExpedicion, Persona persona) {
        this.estado = estado;
        this.precio = precio;
        this.fechaExpedicion = fechaExpedicion;
        this.persona = persona;
    }

    /**
     * Constructor de la clase Tramite
     *
     * @param idTramite Identificador del tramite
     * @param estado Estado actual del tramite
     * @param precio Precio del tramite
     * @param fechaExpedicion fecha de expedición del tramite
     * @param pago Pago asociado al tramite
     * @param persona Persona asociada al tramite
     */
    public Tramite(Long idTramite, EstadoTramite estado, Float precio,
            Calendar fechaExpedicion, List<Pago> pago, Persona persona) {
        this.idTramite = idTramite;
        this.estado = estado;
        this.precio = precio;
        this.fechaExpedicion = fechaExpedicion;
        this.pago = pago;
        this.persona = persona;
    }

    /**
     * Devuelve el identificador del tramite
     *
     * @return el identificador del tramite
     */
    public Long getIdTramite() {
        return idTramite;
    }

    /**
     * Establece el identificador del tramite
     *
     * @param idTramite el identificador a establecer el tramite
     */
    public void setIdTramite(Long idTramite) {
        this.idTramite = idTramite;
    }

    /**
     * Devuelve el estado actual del tramite
     *
     * @return el estado actual del tramite
     */
    public EstadoTramite getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual del tramite
     *
     * @param estado el estado actual del tramite
     */
    public void setEstado(EstadoTramite estado) {
        this.estado = estado;
    }

    /**
     * Devuelve el precio del tramite
     *
     * @return precio del tramite
     */
    public Float getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del tramite
     *
     * @param precio el precio del tramite a establecer
     */
    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    /**
     * Devuelve la fecha de expedición del tramite
     *
     * @return fecha de expedición del tramite
     */
    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     * Establece la fecha de expedición del tramite
     *
     * @param fechaExpedicion la fecha de expedición del tramite
     */
    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * Devuelve la persona asociada al tramite
     *
     * @return persona asociada al tramite
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada al tramite
     *
     * @param persona la persona asociada al tramite
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Devuelve la lista de pagos asociados al tramite
     *
     * @return lista de pagos asociados al tramite
     */
    public List<Pago> getPago() {
        return pago;
    }

    /**
     * Establece la lista de pagos asociados al tramite
     *
     * @param pago lista de pagos asociados al tramites
     */
    public void setPago(List<Pago> pago) {
        this.pago = pago;
    }

    /**
     * Agrega un pago especifico a la lista de pagos asociados al tramite
     *
     * @param pago el pago para agregar a la lista
     */
    public void agregarPago(Pago pago) {
        this.pago.add(pago);
    }

}
