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
 * Descripción de la clase: Esta clase representa un pago para realizar los
 * trámites y se realiza un mapeo con la base de datos
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
@Entity
@Table(name = "pago")
public class Pago implements Serializable {

    /**
     * Identifiador unico del pago
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    /**
     * Monto del pago
     */
    @Column(name = "monto", nullable = false)
    private Float monto;

    /**
     * *
     * Fecha y hora de operación del pago
     */
    @Column(name = "fecha_hora", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaHora;

    /**
     * *
     * Concepto del pago
     */
    @Column(name = "concepto", nullable = true, length = 255)
    private String concepto;

    /**
     * Tramite asociado a el pego
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_tramite", nullable = false)
    private Tramite tramite;

    /**
     * Constructor vacio de la clase pago
     */
    public Pago() {
    }

    /**
     * Constructor de la clase pago
     *
     * @param monto Monto del pago
     * @param fechaHora Fecha y hora del pago
     * @param concepto Concepto del pago
     * @param tramite Tramite asociado al pago
     */
    public Pago(Float monto, Calendar fechaHora, String concepto, Tramite tramite) {
        this.monto = monto;
        this.fechaHora = fechaHora;
        this.concepto = concepto;
        this.tramite = tramite;
    }

    /**
     * Constructor de la clase pago
     *
     * @param idPago identificador del pago
     * @param monto Monto del pago
     * @param fechaHora Fecha y hora del pago
     * @param concepto Concepto del pago
     * @param tramite Tramite asociado al pago
     */
    public Pago(Long idPago, Float monto, Calendar fechaHora, String concepto, Tramite tramite) {
        this.idPago = idPago;
        this.monto = monto;
        this.fechaHora = fechaHora;
        this.concepto = concepto;
        this.tramite = tramite;
    }

    /**
     * Devuelve el identificador del pago
     *
     * @return identificador del pago
     */
    public Long getIdPago() {
        return idPago;
    }

    /**
     * Establece el identificador del pago
     *
     * @param idPago el identificador del pago
     */
    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    /**
     * Devuelve el monto del pago
     *
     * @return Monto del pago
     */
    public Float getMonto() {
        return monto;
    }

    /**
     * Establece el monto del pago
     *
     * @param monto el monto del pago
     */
    public void setMonto(Float monto) {
        this.monto = monto;
    }

    /**
     * Devuelve la fecha y hora del pago
     *
     * @return Fecha y hora del pago
     */
    public Calendar getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora del pago
     *
     * @param fechaHora la fecha y hora del pago
     */
    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Devuelve el concepto del pago
     *
     * @return el concepto del pago
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * Establece el concepto del pago
     *
     * @param concepto el concepto del pago
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    /**
     * Devuelve el tramite asociado al pago
     *
     * @return Tramite asociado al pago
     */
    public Tramite getTramite() {
        return tramite;
    }

    /**
     * Establece el tramite asociado al pago
     *
     * @param tramite el tramite asociado al pago
     */
    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

}
