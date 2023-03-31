package org.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Daniel Alameda, Daniel Peña
 */
@Entity
@Table(name = "tramite")
@Inheritance(strategy = InheritanceType.JOINED)
public class Tramite implements Serializable {

    /**
     * Atributos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTramite;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoTramite estado;

    @Column(name = "precio", nullable = false)
    private Float precio;

    @Column(name = "fecha_expedicion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaExpedicion;

    /**
     * Relaciones
     */
    //Relación con persona
    @ManyToOne()
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    // Relacion pago
    @OneToMany(mappedBy = "tramite", cascade = {CascadeType.PERSIST})
    private List<Pago> pago;

    public Tramite() {
    }

    public Tramite(EstadoTramite estado, Float precio,
            Calendar fechaExpedicion, Persona persona) {
        this.validarDatos(estado, precio, fechaExpedicion, persona);
        this.estado = estado;
        this.precio = precio;
        this.fechaExpedicion = fechaExpedicion;
        this.persona = persona;
    }

    public Tramite(Long idTramite, EstadoTramite estado, Float precio,
            Calendar fechaExpedicion, List<Pago> pago, Persona persona) {
        this.validarDatos(estado, precio, fechaExpedicion, persona);
        this.idTramite = idTramite;
        this.estado = estado;
        this.precio = precio;
        this.fechaExpedicion = fechaExpedicion;
        this.pago = pago;
        this.persona = persona;
    }

    public void validarDatos(EstadoTramite estado, Float precio,
            Calendar fechaExpedicion, Persona persona) {
        if (estado == null) {
            throw new IllegalArgumentException("El estado no puede ser nula");
        }

        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }

        if (fechaExpedicion == null) {
            throw new IllegalArgumentException("La fecha y hora no pueden ser nulas");
        }

        if (persona == null) {
            throw new IllegalArgumentException("El persona del tramite es requerido");
        }

    }

    public Long getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Long idTramite) {
        this.idTramite = idTramite;
    }

    public EstadoTramite getEstado() {
        return estado;
    }

    public void setEstado(EstadoTramite estado) {
        if (estado == null) {
            throw new IllegalArgumentException("El estado no puede ser nula");
        }
        this.estado = estado;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        this.precio = precio;
    }

    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Calendar fechaExpedicion) {
        if (fechaExpedicion == null) {
            throw new IllegalArgumentException("La fecha y hora no pueden ser nulas");
        }
        this.fechaExpedicion = fechaExpedicion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        if (persona == null) {
            throw new IllegalArgumentException("El persona del tramite es requerido");
        }
        this.persona = persona;
    }

    public List<Pago> getPago() {
        return pago;
    }

    public void setPago(List<Pago> pago) {
        this.pago = pago;
    }

    public void actualizarTramite(Tramite tramite) {
        this.idTramite = tramite.getIdTramite();
        this.estado = tramite.getEstado();
        this.precio = tramite.getPrecio();
        this.fechaExpedicion = tramite.fechaExpedicion;
        this.pago = tramite.pago;
        this.persona = tramite.getPersona();
    }

    public void agregarPago(Pago pago) {
        if (this.pago == null) {
            this.pago = new LinkedList<>();
        }

        this.pago.add(pago);
    }

}
