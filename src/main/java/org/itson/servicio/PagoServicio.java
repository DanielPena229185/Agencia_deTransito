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

    /**
     *
     */
    public PagoServicio() {
        this.pagoDAO = new DAOFactory().getPagoDAO();

    }

    /**
     *
     * @param pago
     * @throws IllegalArgumentException
     */
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

    /**
     *
     * @param pago
     * @return
     * @throws IllegalArgumentException
     */
    public Pago agregarPago(Pago pago) throws IllegalArgumentException {
        try {
            this.validarDatos(pago);
            JOptionPane.showMessageDialog(null, "Pago realizado");
            return pagoDAO.agregarPago(pago);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede agregar el pago " + e.getMessage());
        }

    }

    /**
     *
     * @param pago
     * @throws IllegalArgumentException
     */
    public void eliminarPago(Pago pago) throws IllegalArgumentException {
        try {
            this.validarDatos(pago);
            pagoDAO.eliminarPago(pago);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo eliminar el pago " + e.getMessage());
        }

    }

    /**
     *
     * @param pago
     * @return
     * @throws IllegalArgumentException
     */
    public Pago actualizarPago(Pago pago) throws IllegalArgumentException {
        try {
            this.validarDatos(pago);
            return pagoDAO.actualizarPago(pago);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo actualizar el pago " + e.getMessage());
        }
    }

    /**
     *
     * @param pago
     * @return
     * @throws IllegalArgumentException
     */
    public Pago consultarPago(Pago pago) throws IllegalArgumentException {
        try {
            this.validarDatos(pago);
            return pagoDAO.consultarPago(pago);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo consultar el pago " + e.getMessage());
        }
    }

    /**
     *
     * @return @throws IllegalArgumentException
     */
    public List<Pago> consultarPago() throws IllegalArgumentException {
        try {
            return pagoDAO.consultarPago();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo consultar la lista de pagos " + e.getMessage());
        }
    }

    /**
     *
     * @param fecha
     * @return
     * @throws IllegalArgumentException
     */
    public List<Pago> consultarPago(Calendar fecha) throws IllegalArgumentException {
        try {
            if (fecha == null) {
                throw new IllegalArgumentException("La fecha y hora no pueden ser nulas");
            }
            return pagoDAO.consultarPago(fecha);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo consultar la lista de pagos " + e.getMessage());
        }
    }

}
