/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.servicio;

import java.util.List;
import org.itson.dominio.*;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ServicioException;
import org.itson.implementaciones.DAOFactory;
import org.itson.interfaces.*;

/**
 * Descripción de la clase: Esta clase se encarga de realizar la conexion con la
 * clase dao del automóvi para antes hacer validaciones
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class AutomovilServicio {

    private IAutomovilDAO automovilDAO;

    /**
     * Constructor por defecto que inicializa un objeto DAOFactory para obtener
     * un objeto IAutomovilDAO.
     */
    public AutomovilServicio() {
        this.automovilDAO = new DAOFactory().getAutomovilDAO();
    }

    /**
     * Método que se encarga de agregar un Automóvil
     *
     * @param automovil Automovil que se desea agregar
     * @return Un objeto de tipo Automóvil
     * @throws ServicioException En caso de que no se pueda realizar la
     * operación de persistit el automóvil en la base de datos
     */
    public Vehiculo agregarAutomovil(Automovil automovil) throws ServicioException {
        try {
            this.validarDatos(automovil);
            return automovilDAO.agregarAutomovil(automovil);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al agregar el automovil ", pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se puede agregar el automovil: " + e.getMessage());
        }
    }

    /**
     * Método que se encarga de actualizar en la base de datos un automóvil
     *
     * @param automovil Automóvil que quiere actualizar
     * @return El objeto del automóvil actualizado
     * @throws ServicioException En caso que no se pueda realizar la operación
     * de actualizar el automóvil
     */
    public Vehiculo actualizarAutomovil(Automovil automovil) throws ServicioException {
        try {
            this.validarDatos(automovil);
            return automovilDAO.actualizarAutomovil(automovil);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al actualizar el automóvil " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo actualizar el automovil: " + e.getMessage());
        }
    }

//    public Vehiculo eliminarVehiculo(Vehiculo vehiculo)throws PersistenciaException;
    /**
     * Método que consulta todos los automóviles que pertenecen en la base de
     * datos
     *
     * @return Una lista con todos los automóviles que se conseguieron en la
     * consulta
     * @throws ServicioException En caso de que no se pueda realizar la consulta
     */
    public List<Automovil> consultarAutomoviles() throws ServicioException {
        try {
            return automovilDAO.consultarAutomoviles();
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar el automóvil " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("Error al consultar el automóvil " + e.getMessage());
        }
    }

    /**
     * Consulta todos los automóviles por su placa
     *
     * @param placa Placa que se desea buscar en el filtro
     * @return Una lista de todos los automóvil que cuentan con los placa
     * @throws ServicioException En caso de que no se pueda realizar la consulta
     */
    public List<Automovil> consultarAutomoviles(Placa placa) throws ServicioException {
        try {
            this.validarDatosPlaca(placa);
            return automovilDAO.consultarAutomoviles(placa);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar el automóvil " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se puede realizar la consulta: " + e.getMessage());
        }
    }

    /**
     * Validar los datos del objeto automovil
     *
     * @param automovil el objeto a validar
     * @throws ServicioException si algun atributo no es el correcto
     */
    public void validarDatos(Automovil automovil) {
        if (automovil.getNumeroSerie() == null || automovil.getNumeroSerie().trim().isEmpty()) {
            throw new ServicioException("El numero de serie no puede estar vacío");
        } else if (automovil.getNumeroSerie().length() > 50) {
            throw new ServicioException("El numero de serie del automovil no debe exceder los 50 caracteres");
        }

        if (automovil.getMarca() == null || automovil.getMarca().trim().isEmpty()) {
            throw new ServicioException("La marca no puede estar vacía");
        } else if (automovil.getMarca().length() > 100) {
            throw new ServicioException("La marca del automovil no debe exceder los 100 caracteres");
        }

        if (automovil.getColor() == null || automovil.getColor().trim().isEmpty()) {
            throw new ServicioException("El color no puede estar vacío");
        } else if (automovil.getColor().length() > 100) {
            throw new ServicioException("El color del automovil no debe exceder los 100 caracteres");
        }

        if (automovil.getModelo() == null || automovil.getModelo().trim().isEmpty()) {
            throw new ServicioException("El modelo no puede estar vacío");
        } else if (automovil.getModelo().length() > 100) {
            throw new ServicioException("El modelo del automovil no debe exceder los 100 caracteres");
        }

        if (automovil.getLinea() == null || automovil.getLinea().trim().isEmpty()) {
            throw new ServicioException("La linea no puede estar vacía");
        } else if (automovil.getLinea().length() > 100) {
            throw new ServicioException("La linea del automovil no debe exceder los 100 caracteres");
        }
    }

    /**
     * Validar los datos del objeto placa
     *
     * @param placa el objeto a validar
     * @throws ServicioException si algun atributo no es el correcto
     */
    public void validarDatosPlaca(Placa placa) throws ServicioException {
        if (placa.getEstado() == null) {
            throw new ServicioException("El estado no puede ser nula");
        }

        if (placa.getPrecio() <= 0) {
            throw new ServicioException("El precio debe ser mayor a 0");
        }

        if (placa.getFechaExpedicion() == null) {
            throw new ServicioException("La fecha y hora no pueden ser nulas");
        }

        if (placa.getPersona() == null) {
            throw new ServicioException("El persona del tramite es requerido");
        }
    }
}
