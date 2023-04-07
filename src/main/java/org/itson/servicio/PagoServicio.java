/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.servicio;

import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import org.itson.dominio.Pago;
import org.itson.implementaciones.DAOFactory;
import org.itson.interfaces.*;

/**
 *
 * @author HP
 */
public class PagoServicio {

    private IPagoDAO pagoDAO;

    public PagoServicio() {
        this.pagoDAO = new DAOFactory().getPagoDAO();

    }

    public Pago agregarPago(Pago pago) throws IllegalArgumentException {
        try {
            this.validarDatos(pago);
            return pagoDAO.agregarPago(pago);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede agregar el pago: " + e.getMessage());
        }
    }

    public void eliminarPago(Pago pago) throws IllegalArgumentException {
        try {
            this.validarDatos(pago);
            pagoDAO.eliminarPago(pago);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo eliminar el pago: " + e.getMessage());
        }
    }

    public Pago actualizarPago(Pago pago) throws IllegalArgumentException {
        try {
            this.validarDatos(pago);
            return pagoDAO.actualizarPago(pago);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo actualizar el pago: " + e.getMessage());
        }
    }

    public Pago consultarPago(Pago pago) throws IllegalArgumentException {
        try {
            this.validarDatos(pago);
            return pagoDAO.consultarPago(pago);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo consultar el pago: " + e.getMessage());
        }
    }

    public List<Pago> consultarPagos() throws IllegalArgumentException {
        try {
            return pagoDAO.consultarPagos();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo consultar la lista de pagos: " + e.getMessage());
        }
    }

    public List<Pago> consultarPagosFecha(Calendar fecha) throws IllegalArgumentException {
        try {
            if (fecha == null) {
                throw new IllegalArgumentException("La fecha y hora no pueden ser nulas");
            }
            return pagoDAO.consultarPagosFecha(fecha);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo consultar la lista de pagos: " + e.getMessage());
        }
    }

    public void validarDatos(Pago pago) throws IllegalArgumentException {
        if (pago.getMonto() <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a 0");
        }
        if (pago.getFechaHora() == null) {
            throw new IllegalArgumentException("La fecha y hora no pueden ser nulas");
        }
        if (pago.getConcepto() == null || pago.getConcepto().trim().isEmpty()) {
            throw new IllegalArgumentException("El monto del pago es requerido");
        } else if (pago.getConcepto().length() > 255) {
            throw new IllegalArgumentException("El concepto del pago no debe exceder los 255 caracteres");
        }
        if (pago.getTramite() == null) {
            throw new IllegalArgumentException("El tramite del pago es requerido");
        }
    }

}
