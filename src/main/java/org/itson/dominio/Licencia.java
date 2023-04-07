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

    @Column(name = "fecha_expiracion", nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar fechaExpiracion;

    public Licencia() {
        super();
    }

    public Licencia(EstadoTramite estado, Float precio,
            Calendar fechaExpedicion, Calendar fechaVigencia, Persona persona) {
        super(estado, precio, fechaExpedicion, persona);
        this.fechaExpiracion = fechaVigencia;
    }

    public Licencia(Long idTramite, EstadoTramite estado, Float precio,
            Calendar fechaExpedicion, List<Pago> pago, Calendar fechaVigencia,
            Persona persona) {
        super(idTramite, estado, precio, fechaExpedicion, pago, persona);
        this.fechaExpiracion = fechaVigencia;
    }

    public Calendar getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Calendar fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
}
