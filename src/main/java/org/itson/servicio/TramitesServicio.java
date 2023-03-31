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
import org.itson.implementaciones.DAOFactory;
import org.itson.interfaces.*;

/**
 *
 * @author HP
 */
public class TramitesServicio {

    private ITramiteDAO tramiteDAO;

    /**
     *
     */
    public TramitesServicio() {
        this.tramiteDAO = new DAOFactory().getTramiteDAO();
    }

    /**
     *
     * @param tramite
     * @throws IllegalArgumentException
     */
    public void validarDatos(Tramite tramite) throws IllegalArgumentException {
        if (tramite.getEstado() == null) {
            throw new IllegalArgumentException("El estado no puede ser nula");
        }

        if (tramite.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }

        if (tramite.getFechaExpedicion() == null) {
            throw new IllegalArgumentException("La fecha y hora no pueden ser nulas");
        }

        if (tramite.getPersona() == null) {
            throw new IllegalArgumentException("El persona del tramite es requerido");
        }

    }

    /**
     *
     * @param persona
     * @throws IllegalArgumentException
     */
    public void validarDatosPersona(Persona persona) throws IllegalArgumentException {
        if (persona.getNombres() == null || persona.getNombres().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        } else if (persona.getNombres().length() > 150) {
            throw new IllegalArgumentException("El nombre de la persona no debe exceder los 150 caracteres");
        }

        if (persona.getApellido_paterno() == null || persona.getApellido_paterno().trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido paterno no puede estar vacío");
        } else if (persona.getApellido_paterno().length() > 150) {
            throw new IllegalArgumentException("El apellido paterno de la persona no debe exceder los 150 caracteres");
        }

        if (persona.getApellido_materno() == null || persona.getApellido_materno().trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido materno no puede estar vacío");
        } else if (persona.getApellido_materno().length() > 150) {
            throw new IllegalArgumentException("El apellido materno de la persona no debe exceder los 150 caracteres");
        }

        if (persona.getRfc() == null || persona.getRfc().trim().isEmpty()) {
            throw new IllegalArgumentException("El RFC no puede estar vacío");
        } else if (persona.getRfc().length() > 150) {
            throw new IllegalArgumentException("El RFC de la persona no debe exceder los 150 caracteres");
        }

        if (persona.getFechaNacimiento() == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
        }

        if (persona.getTelefono() == null || persona.getTelefono().trim().isEmpty()) {
            throw new IllegalArgumentException("El número de teléfono no puede estar vacío");
        } else if (persona.getTelefono().length() > 100) {
            throw new IllegalArgumentException("El numero telefonico de la persona no debe exceder los 100 caracteres");
        }
    }

    /**
     *
     * @param tramite
     * @return
     * @throws IllegalArgumentException
     */
    public Tramite agregarTramite(Tramite tramite) throws IllegalArgumentException {
        try {
            this.validarDatos(tramite);
            return tramiteDAO.agregarTramite(tramite);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede agregar el tramite " + e.getMessage());
        }
    }

    /**
     *
     * @param tramite
     * @return
     * @throws IllegalArgumentException
     */
    public Tramite actualizarTramite(Tramite tramite) throws IllegalArgumentException {
        try {
            this.validarDatos(tramite);
            return tramiteDAO.actualizarTramite(tramite);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede actualizar el tramite " + e.getMessage());
        }
    }
//    public Tramite eliminarTramite(Tramite tramite)throws PersistenciaException;

    /**
     *
     * @return @throws IllegalArgumentException
     */
    public List<Tramite> consultarTramites() throws IllegalArgumentException {
        try {
            return tramiteDAO.consultarTramites();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo consultar el tramite " + e.getMessage());
        }
    }

    /**
     *
     * @param persona
     * @return
     * @throws IllegalArgumentException
     */
    public List<Tramite> consultarTramitesPersona(Persona persona) throws IllegalArgumentException {
        try {
            this.validarDatosPersona(persona);
            return tramiteDAO.consultarTramitesPersona(persona);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo consultar el tramite " + e.getMessage());
        }
    }

    public List<Tramite> consultarTramitesPeriodo(Calendar desde, Calendar hasta, Persona persona) throws IllegalArgumentException {
        try {
            if (desde == null) {
                throw new IllegalArgumentException("La fecha desde no pueden ser nulas");
            }
            if (hasta == null) {
                throw new IllegalArgumentException("La fecha hasta no pueden ser nulas");
            }
            this.validarDatosPersona(persona);
            return tramiteDAO.consultarTramitesPeriodo(desde, hasta, persona);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo consultar el tramite " + e.getMessage());
        }
    }
}
