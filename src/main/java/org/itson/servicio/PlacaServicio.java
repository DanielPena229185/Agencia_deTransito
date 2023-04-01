/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.servicio;

import java.util.Calendar;
import java.util.List;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.implementaciones.DAOFactory;
import org.itson.interfaces.IPlacaDAO;

/**
 *
 * @author HP
 */
public class PlacaServicio {

    private IPlacaDAO placaDAO;

    /**
     *
     */
    public PlacaServicio() {
        this.placaDAO = new DAOFactory().getPlacaDAO();
    }

    /**
     *
     * @param placa
     * @throws IllegalArgumentException
     */
    public void validarDatos(Placa placa) throws IllegalArgumentException {
        if (placa.getEstado() == null) {
            throw new IllegalArgumentException("El estado no puede ser nula");
        }

        if (placa.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }

        if (placa.getFechaExpedicion() == null) {
            throw new IllegalArgumentException("La fecha y hora no pueden ser nulas");
        }

        if (placa.getPersona() == null) {
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
     * @param placa
     * @return
     * @throws IllegalArgumentException
     */
    public Placa agregarPlaca(Placa placa) throws IllegalArgumentException {
        try {
            this.validarDatos(placa);
            return placaDAO.agregarPlaca(placa);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede agregar la placa " + e.getMessage());
        }
    }

    /**
     *
     * @param placa
     * @return
     * @throws IllegalArgumentException
     */
    public Placa actualizarTramite(Placa placa) throws IllegalArgumentException {
        try {
            this.validarDatos(placa);
            return placaDAO.actualizarTramite(placa);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede actualizar la placa " + e.getMessage());
        }
    }
//    public Placa eliminarTramite(Placa placa)throws PersistenciaException;

    /**
     *
     * @return @throws IllegalArgumentException
     */
    public List<Placa> consultarTramites() throws IllegalArgumentException {
        try {
            return placaDAO.consultarTramites();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo consultar las placas " + e.getMessage());
        }
    }

    /**
     *
     * @param persona
     * @return
     * @throws IllegalArgumentException
     */
    public List<Placa> consultarTramitesPersona(Persona persona) throws IllegalArgumentException {
        try {
            this.validarDatosPersona(persona);
            return placaDAO.consultarTramitesPersona(persona);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo consultar las placas " + e.getMessage());
        }
    }

    /**
     * 
     * @param desde
     * @param hasta
     * @param persona
     * @return
     * @throws IllegalArgumentException 
     */
    public List<Placa> consultarTramitesPeriodo(Calendar desde, Calendar hasta, Persona persona) throws IllegalArgumentException {
        try {
            if (desde == null) {
                throw new IllegalArgumentException("La fecha desde no pueden ser nulas");
            }
            if (hasta == null) {
                throw new IllegalArgumentException("La fecha hasta no pueden ser nulas");
            }
            this.validarDatosPersona(persona);
            return placaDAO.consultarTramitesPeriodo(desde, hasta, persona);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo consultar el tramite " + e.getMessage());
        }
    }

}
