/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.servicio;

import java.util.Calendar;
import java.util.List;
import org.itson.dominio.Pago;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ServicioException;
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

    public Pago agregarPago(Pago pago) throws ServicioException {
        try {
            this.validarDatos(pago);
            return pagoDAO.agregarPago(pago);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al agregar el pago " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se puede agregar el pago: " + e.getMessage());
        }
    }

    public void eliminarPago(Pago pago) throws ServicioException {
        try {
            this.validarDatos(pago);
            pagoDAO.eliminarPago(pago);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al eliminar el pago: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo eliminar el pago: " + e.getMessage());
        }
    }

    public Pago actualizarPago(Pago pago) throws ServicioException {
        try {
            this.validarDatos(pago);
            return pagoDAO.actualizarPago(pago);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al actualizar el pago: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo actualizar el pago: " + e.getMessage());
        }
    }

    public Pago consultarPago(Pago pago) throws ServicioException {
        try {
            this.validarDatos(pago);
            return pagoDAO.consultarPago(pago);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar el pago: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar el pago: " + e.getMessage());
        }
    }

    public List<Pago> consultarPagos() throws ServicioException {
        try {
            return pagoDAO.consultarPagos();
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar los pagos: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar la lista de pagos: " + e.getMessage());
        }
    }

    public List<Pago> consultarPagosFecha(Calendar fecha) throws ServicioException {
        try {
            if (fecha == null) {
                throw new ServicioException("La fecha y hora no pueden ser nulas");
            }
            return pagoDAO.consultarPagosFecha(fecha);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar los pagos por fecha: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar la lista de pagos: " + e.getMessage());
        }
    }

    public void validarDatos(Pago pago) throws ServicioException {
        if (pago.getMonto() <= 0) {
            throw new ServicioException("El monto debe ser mayor a 0");
        }
        if (pago.getFechaHora() == null) {
            throw new ServicioException("La fecha y hora no pueden ser nulas");
        }
        if (pago.getConcepto() == null || pago.getConcepto().trim().isEmpty()) {
            throw new ServicioException("El monto del pago es requerido");
        } else if (pago.getConcepto().length() > 255) {
            throw new ServicioException("El concepto del pago no debe exceder los 255 caracteres");
        }
        if (pago.getTramite() == null) {
            throw new ServicioException("El tramite del pago es requerido");
        }
    }

}
