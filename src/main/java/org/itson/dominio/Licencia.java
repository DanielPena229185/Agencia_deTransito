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
@DiscriminatorValue(value = "licencia")
public class Licencia extends Tramite implements Serializable {

    /**
     * Fecha de expiración de la licencia
     */
    @Column(name = "fecha_expiracion", nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar fechaExpiracion;

    /**
     * Constructor vacio de la clase Licencia
     */
    public Licencia() {
        super();
    }

    /**
     * Constructor de la clase Licencia
     *
     * @param estado Estado actual de la licencia
     * @param precio Precio de la licencia
     * @param fechaExpedicion Fecha de expedición de la licencia
     * @param fechaVigencia Fecha de vigencia de la licencia
     * @param persona Persona asociada a la licencia
     */
    public Licencia(EstadoTramite estado, Float precio,
            Calendar fechaExpedicion, Calendar fechaVigencia, Persona persona) {
        super(estado, precio, fechaExpedicion, persona);
        this.fechaExpiracion = fechaVigencia;
    }

    /**
     * Constructor de la clase Licencia
     *
     * @param idTramite Identificador de la licencia
     * @param estado Estado actual de la licencia
     * @param precio Precio de la licencia
     * @param fechaExpedicion Fecha de expedición de la licencia
     * @param pago Pago asociado a la licencia
     * @param fechaVigencia Fecha de vigencia de la licencia
     * @param persona Persona asociada a la licencia
     */
    public Licencia(Long idTramite, EstadoTramite estado, Float precio,
            Calendar fechaExpedicion, List<Pago> pago, Calendar fechaVigencia,
            Persona persona) {
        super(idTramite, estado, precio, fechaExpedicion, pago, persona);
        this.fechaExpiracion = fechaVigencia;
    }

    /**
     * Devuelve la fecha de expiración de la licencia
     *
     * @return Fecha de expiración de la licencia
     */
    public Calendar getFechaExpiracion() {
        return fechaExpiracion;
    }

    /**
     * Establece la fecha de expiración de la licencia
     *
     * @param fechaExpiracion Fecha de expiración de la licencia
     */
    public void setFechaExpiracion(Calendar fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
}
