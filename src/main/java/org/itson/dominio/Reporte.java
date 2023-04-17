/**
 * Reporte.java
 * 13 abr. 2023 10:53:01
 */
package org.itson.dominio;
//importanciones

import java.text.SimpleDateFormat;

/**
 * Descripción de la clase: Esta clase es para guardar los datos de un reporte
 * para generar el pdf
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class Reporte {

    /**
     * Tramite necesario para el reporte
     */
    private Tramite tramite;
    /**
     * Tipo de tramite
     */
    private String tipo;
    /**
     * Fecha de expedición del tramite
     */
    private String fechaExpedicion;
    /**
     * Costo del tramite
     */
    private String costo;
    /**
     * Nombre completo de la persona
     */
    private String nombreCompleto;

    /**
     * Constructor vacio de la clase Reporte
     */
    public Reporte() {

    }

    /**
     * Constructor de la clase Reporte
     *
     * @param tramite Tramite relacionado para el reporte
     * @param tipo Tipo de de tramite
     */
    public Reporte(Tramite tramite, String tipo) {
        this.tramite = tramite;
        this.tipo = tipo;
        this.llenarDatosReporte();
    }

    /**
     * Constructor de la clase Reporte
     *
     * @param tramite Tramite relacionado para el reporte
     * @param tipo Tipo de tramite
     * @param fechaExpedicion Fecha de expedición del tramite
     * @param costo Costo del tramite
     * @param nombreCompleto Nombre completo de la persona
     */
    public Reporte(Tramite tramite, String tipo, String fechaExpedicion, String costo, String nombreCompleto) {
        this.tramite = tramite;
        this.tipo = tipo;
        this.fechaExpedicion = fechaExpedicion;
        this.costo = costo;
        this.nombreCompleto = nombreCompleto;
        this.llenarDatosReporte();
    }

    /**
     * Devuelve el tramite del reporte
     *
     * @return Tramite del reporte
     */
    public Tramite getTramite() {
        return tramite;
    }

    /**
     * Establece el tramite para el reporte
     *
     * @param tramite el tramite para el reporte
     */
    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    /**
     * Devuelve el tipo de tramite
     *
     * @return Tipo de tramite
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de tramite
     *
     * @param tipo el tipo de tramite
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve la fecha de expiración del tramite
     *
     * @return la fecha de expiración del tramite
     */
    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     * Establece la fecha de expiración del tramite
     *
     * @param fechaExpedicion la fecha de expiración del tramite
     */
    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * Devuelve el costo del tramite
     *
     * @return el costo del tramite
     */
    public String getCosto() {
        return costo;
    }

    /**
     * Establece el costo del tramite
     *
     * @param costo el costo del tramite
     */
    public void setCosto(String costo) {
        this.costo = costo;
    }

    /**
     * Devuelve el nombre completo de la persona
     *
     * @return el nombre completo de la persona
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo de la persona
     *
     * @param nombreCompleto el nombre completo de la persona
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Metodo que llena los campos requeridos por el reporte
     */
    private void llenarDatosReporte() {
        String costoTramite = String.valueOf(this.tramite.getPrecio());
        String fechaExpedicionTramite = new SimpleDateFormat("dd/MM/yyyy").format(this.tramite.getFechaExpedicion().getTime());
        String nombreTramite = this.tramite.getPersona().getNombreCompleto();

        this.costo = "$" + costoTramite;
        this.fechaExpedicion = fechaExpedicionTramite;
        this.nombreCompleto = nombreTramite;
    }

}
