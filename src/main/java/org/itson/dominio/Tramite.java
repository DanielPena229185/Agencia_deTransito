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
     * Atributos
     */
    @Id
    @Column(name = "id")
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
        this.estado = estado;
        this.precio = precio;
        this.fechaExpedicion = fechaExpedicion;
        this.persona = persona;
    }

    public Tramite(Long idTramite, EstadoTramite estado, Float precio,
            Calendar fechaExpedicion, List<Pago> pago, Persona persona) {
        this.idTramite = idTramite;
        this.estado = estado;
        this.precio = precio;
        this.fechaExpedicion = fechaExpedicion;
        this.pago = pago;
        this.persona = persona;
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
        this.estado = estado;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Pago> getPago() {
        return pago;
    }

    public void setPago(List<Pago> pago) {
        this.pago = pago;
    }

    public void agregarPago(Pago pago) {
        this.pago.add(pago);
    }

}
