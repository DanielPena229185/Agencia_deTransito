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

    /**
     * Constructor por defecto que inicializa un objeto DAOFactory para obtener
     * un objeto IPagoDAO.
     */
    public PagoServicio() {
        this.pagoDAO = new DAOFactory().getPagoDAO();

    }

    /**
     * Agrega un pago a la base de datos.
     *
     * @param pago Pago que se desea guardar en la base de datos.
     * @return Pago que se guardó en la base de datos.
     * @throws ServicioException Si no se puede guardar el pago en la base de
     * datos.
     */
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

    /**
     * Elimina un pago de la base de datos.
     *
     * @param pago Pago que se desea eliminar de la base de datos.
     * @throws ServicioException Si no se puede eliminar el pago de la base de
     * datos.
     */
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

    /**
     * Actualiza los datos de un pago en la base de datos.
     *
     * @param pago Pago que se desea actualizar en la base de datos.
     * @return Pago que se actualizó en la base de datos.
     * @throws ServicioException Si no se puede actualizar el pago en la base de
     * datos.
     */
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

    /**
     * Consulta un pago en la base de datos.
     *
     * @param pago Pago que se desea consultar en la base de datos.
     * @return Pago consultado en la base de datos.
     * @throws ServicioException Si no se puede consultar el pago en la base de
     * datos.
     */
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

    /**
     * Consulta todos los pagos en la base de datos.
     *
     * @return Lista de todos los pagos en la base de datos.
     * @throws ServicioException Si no se puede realizar la consulta en la base
     * de datos.
     */
    public List<Pago> consultarPagos() throws ServicioException {
        try {
            return pagoDAO.consultarPagos();
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar los pagos: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar la lista de pagos: " + e.getMessage());
        }
    }

    /**
     * Consulta todos los pagos realizados en una fecha específica.
     *
     * @param fecha Fecha a consultar.
     * @return Lista de todos los pagos realizados en la fecha especificada.
     * @throws ServicioException Si no se puede realizar la consulta en la base
     * de datos.
     */
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

    /**
     * Valida los atributos del objeto pago
     *
     * @param pago objeto a validar
     * @throws ServicioException si algun atributo no sea el correcto
     */
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
