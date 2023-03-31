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
@Table(name = "licencia")
@PrimaryKeyJoinColumn(name = "id_tramite")
public class Licencia extends Tramite implements Serializable {

    @Column(name = "fecha_expiracion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaExpiracion;

    public Licencia() {
        super();
    }

    public Licencia(EstadoTramite estado, Float precio,
            Calendar fechaExpedicion, int vigencia, Persona persona) {
        super(estado, precio, fechaExpedicion, persona);

        this.setFechaExpiracion(fechaExpedicion, vigencia);
    }

    public Licencia(Long idTramite, EstadoTramite estado, Float precio,
            Calendar fechaExpedicion, List<Pago> pago, int vigencia,
            Persona persona) {
        super(idTramite, estado, precio, fechaExpedicion, pago, persona);

        this.setFechaExpiracion(fechaExpedicion, vigencia);
    }

    public Calendar getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Calendar fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    private void setFechaExpiracion(Calendar fechaExpedicion, int años) {
        //Calendar fecha = new Calendar(fechaExpedicion.get(Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH));
        fechaExpiracion = (Calendar) fechaExpedicion.clone();
        this.fechaExpiracion.add(Calendar.YEAR, años);
    }
}
