/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "pago")
public class Pago implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    @Column(name = "monto", nullable = false)
    private Float monto;

    @Column(name = "fecha_hora", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaHora;

    @Column(name = "concepto", nullable = true, length = 255)
    private String concepto;

    /**
     * Relaciones
     */
    //Relación con tramite
    @ManyToOne()
    @JoinColumn(name = "id_tramite", nullable = false)
    private Tramite tramite;

    public Pago() {
    }

    public Pago(Float monto, Calendar fechaHora, String concepto, Tramite tramite) {
        this.validarPago(monto, fechaHora, concepto, tramite);
        this.monto = monto;
        this.fechaHora = fechaHora;
        this.concepto = concepto;
        this.tramite = tramite;
    }

    public Pago(Long idPago, Float monto, Calendar fechaHora, String concepto, Tramite tramite) {
        this.validarPago(monto, fechaHora, concepto, tramite);
        this.idPago = idPago;
        this.monto = monto;
        this.fechaHora = fechaHora;
        this.concepto = concepto;
        this.tramite = tramite;
    }

    public void validarPago(Float monto, Calendar fechaHora, String concepto, Tramite tramite) throws IllegalArgumentException{
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a 0");
        }
        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha y hora no pueden ser nulas");
        }
        if (concepto == null || concepto.trim().isEmpty()) {
            throw new IllegalArgumentException("El monto del pago es requerido");
        } else if (concepto.length() > 255) {
            throw new IllegalArgumentException("El concepto del pago no debe exceder los 255 caracteres");
        }
        if (tramite == null) {
            throw new IllegalArgumentException("El tramite del pago es requerido");
        }
    }

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a 0");
        }
        this.monto = monto;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha y hora no pueden ser nulas");
        }
        this.fechaHora = fechaHora;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        if (concepto == null || concepto.trim().isEmpty()) {
            throw new IllegalArgumentException("El monto del pago es requerido");
        } else if (concepto.length() > 255) {
            throw new IllegalArgumentException("El concepto del pago no debe exceder los 255 caracteres");
        }
        this.concepto = concepto;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        if (tramite == null) {
            throw new IllegalArgumentException("El tramite del pago es requerido");
        }
        this.tramite = tramite;
    }
}
