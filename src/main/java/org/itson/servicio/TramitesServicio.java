/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.servicio;

import java.util.Calendar;
import java.util.List;
import org.itson.dominio.Persona;
import org.itson.dominio.Tramite;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ServicioException;
import org.itson.implementaciones.DAOFactory;
import org.itson.interfaces.*;

/**
 * Descripción de la clase: Esta clase se encarga de realizar la conexion con la
 * clase dao de la clase padre tramite para antes hacer validaciones
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class TramitesServicio {

    private ITramiteDAO tramiteDAO;

    /**
     * Constructor por defecto que inicializa un objeto DAOFactory para obtener
     * un objeto ITramiteDAO.
     */
    public TramitesServicio() {
        this.tramiteDAO = new DAOFactory().getTramiteDAO();
    }

    /**
     * Agrega un nuevo trámite a la base de datos.
     *
     * @param tramite El trámite a agregar.
     * @return El trámite agregado.
     * @throws ServicioException Si algo sale mal al agregar.
     */
    public Tramite agregarTramite(Tramite tramite) throws ServicioException {
        try {
            this.validarDatos(tramite);
            return tramiteDAO.agregarTramite(tramite);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al agregar el trámite: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se puede agregar el tramite: " + e.getMessage());
        }
    }

    /**
     * Actualiza un trámite existente en la base de datos.
     *
     * @param tramite El trámite a actualizar.
     * @return El trámite actualizado.
     * @throws ServicioException Si algo sale mal al actualizar.
     */
    public Tramite actualizarTramite(Tramite tramite) throws ServicioException {
        try {
            this.validarDatos(tramite);
            return tramiteDAO.actualizarTramite(tramite);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al actualizar el trámite: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se puede actualizar el tramite: " + e.getMessage());
        }
    }

//    public Tramite eliminarTramite(Tramite tramite)throws PersistenciaException;
    /**
     * Consulta todos los trámites existentes en la base de datos.
     *
     * @return Lista con todos los trámites.
     * @throws ServicioException Si algo sale mal al consultar.
     */
    public List<Tramite> consultarTramites() throws ServicioException {
        try {
            return tramiteDAO.consultarTramites();
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar los trámites: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar los trámite: " + e.getMessage());
        }
    }

    /**
     * Consulta los trámites relacionados con una persona.
     *
     * @param persona La persona para la que se consultan los trámites.
     * @return Lista con los trámites relacionados con la persona.
     * @throws ServicioException Si algo sale mal al consultar.
     */
    public List<Tramite> consultarTramitesPersona(Persona persona) throws ServicioException {
        try {
            this.validarDatosPersona(persona);
            return tramiteDAO.consultarTramitesPersona(persona);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar los trámites de persona: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar el tramite: " + e.getMessage());
        }
    }

    /**
     * Consulta los trámites realizados en un período determinado y que
     * contienen un nombre de la persona en específico.
     *
     * @param desde Fecha inicial del período.
     * @param hasta Fecha final del período.
     * @param nombre Nombre que de la persona relacionada
     * @return Lista con los trámites realizados en el período y que contienen
     * el nombre específico.
     * @throws ServicioException Si algo sale mal al consultar.
     */
    public List<Tramite> consultarTramitesPeriodo(Calendar desde, Calendar hasta, String nombre) throws ServicioException {
        try {
            //this.validarFechas(desde, hasta);
            return tramiteDAO.consultarTramitesPeriodo(desde, hasta, nombre);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar en tramite de periodo: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar el tramite: " + e.getMessage());
        }
    }

    /**
     * Validar los datos del objeto tramite
     *
     * @param tramite el objeto a validar
     * @throws ServicioException si algun atributo no es el correcto
     */
    public void validarDatos(Tramite tramite) throws ServicioException {
        if (tramite.getEstado() == null) {
            throw new ServicioException("El estado no puede ser nula");
        }

        if (tramite.getPrecio() <= 0) {
            throw new ServicioException("El precio debe ser mayor a 0");
        }

        if (tramite.getFechaExpedicion() == null) {
            throw new ServicioException("La fecha y hora no pueden ser nulas");
        }

        if (tramite.getPersona() == null) {
            throw new ServicioException("El persona del tramite es requerido");
        }

    }

    /**
     * Validar los datos del objeto persona
     *
     * @param persona el objeto a validar
     * @throws ServicioException si algun atributo no es el correcto
     */
    public void validarDatosPersona(Persona persona) throws ServicioException {
        if (persona.getNombres() == null || persona.getNombres().trim().isEmpty()) {
            throw new ServicioException("El nombre no puede estar vacío");
        } else if (persona.getNombres().length() > 150) {
            throw new ServicioException("El nombre de la persona no debe exceder los 150 caracteres");
        }

        if (persona.getApellido_paterno() == null || persona.getApellido_paterno().trim().isEmpty()) {
            throw new ServicioException("El apellido paterno no puede estar vacío");
        } else if (persona.getApellido_paterno().length() > 150) {
            throw new ServicioException("El apellido paterno de la persona no debe exceder los 150 caracteres");
        }

        if (persona.getApellido_materno() == null || persona.getApellido_materno().trim().isEmpty()) {
            throw new ServicioException("El apellido materno no puede estar vacío");
        } else if (persona.getApellido_materno().length() > 150) {
            throw new ServicioException("El apellido materno de la persona no debe exceder los 150 caracteres");
        }

        if (persona.getRfc() == null || persona.getRfc().trim().isEmpty()) {
            throw new ServicioException("El RFC no puede estar vacío");
        } else if (persona.getRfc().length() > 150) {
            throw new ServicioException("El RFC de la persona no debe exceder los 150 caracteres");
        }

        if (persona.getFechaNacimiento() == null) {
            throw new ServicioException("La fecha de nacimiento no puede ser nula");
        }

        if (persona.getTelefono() == null || persona.getTelefono().trim().isEmpty()) {
            throw new ServicioException("El número de teléfono no puede estar vacío");
        } else if (persona.getTelefono().length() > 100) {
            throw new ServicioException("El numero telefonico de la persona no debe exceder los 100 caracteres");
        }
    }

    /**
     * Validar fechas
     *
     * @param desde primera fecha a validar
     * @param hasta segunda fecha a validar
     * @throws ServicioException si alguna fecha no es la correcta
     */
    private void validarFechas(Calendar desde, Calendar hasta) throws ServicioException {
        if (desde == null) {
            throw new ServicioException("La fecha desde no pueden ser nulas");
        }
        if (hasta == null) {
            throw new ServicioException("La fecha hasta no pueden ser nulas");
        }
    }
}
