/**
 * Reporte.java
 * 13 abr. 2023 10:53:01
 */
package org.itson.dominio;
//importanciones

import java.text.SimpleDateFormat;


/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Reporte {

    private Tramite tramite;
    private String tipo;
    private String fechaExpedicion;
    private String costo;
    private String nombreCompleto;

    /**
     * Constructor por default
     */
    public Reporte() {

    }

    public Reporte(Tramite tramite, String tipo) {
        this.tramite = tramite;
        this.tipo = tipo;
        this.llenarDatosReporte();
    }

    public Reporte(Tramite tramite, String tipo, String fechaExpedicion, String costo, String nombreCompleto) {
        this.tramite = tramite;
        this.tipo = tipo;
        this.fechaExpedicion = fechaExpedicion;
        this.costo = costo;
        this.nombreCompleto = nombreCompleto;
        this.llenarDatosReporte();
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    private void llenarDatosReporte() {
        String costoTramite = String.valueOf(this.tramite.getPrecio());
        String fechaExpedicionTramite = new SimpleDateFormat("dd/MM/yyyy").format(this.tramite.getFechaExpedicion().getTime());
        String nombreTramite = this.tramite.getPersona().getNombreCompleto();

        this.costo = "$" + costoTramite;
        this.fechaExpedicion = fechaExpedicionTramite;
        this.nombreCompleto = nombreTramite;
    }

}
