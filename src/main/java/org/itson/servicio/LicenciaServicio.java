/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.servicio;

import java.util.Calendar;
import java.util.List;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;
import org.itson.implementaciones.DAOFactory;
import org.itson.interfaces.ILicenciaDAO;

/**
 *
 * @author HP
 */
public class LicenciaServicio {

    private ILicenciaDAO licenciaDAO;

    /**
     *
     */
    public LicenciaServicio() {
        this.licenciaDAO = new DAOFactory().getLicenciaDAO();
    }

    /**
     *
     * @param licencia
     * @throws IllegalArgumentException
     */
    public void validarDatos(Licencia licencia) throws IllegalArgumentException {
        if (licencia.getEstado() == null) {
            throw new IllegalArgumentException("El estado no puede ser nula");
        }

        if (licencia.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }

        if (licencia.getFechaExpedicion() == null) {
            throw new IllegalArgumentException("La fecha y hora no pueden ser nulas");
        }

        if (licencia.getPersona() == null) {
            throw new IllegalArgumentException("El persona de la licencia es requerido");
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
     * @param licencia
     * @return
     * @throws IllegalArgumentException
     */
    public Licencia agregarLicencia(Licencia licencia) throws IllegalArgumentException {
        try {
            this.validarDatos(licencia);
            return licenciaDAO.agregarLicencia(licencia);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede agregar la licencia " + e.getMessage());
        }
    }

    /**
     *
     * @param licencia
     * @param vigencia
     * @return
     * @throws IllegalArgumentException
     */
    public Licencia actualizarLicencia(Licencia licencia, int vigencia) throws IllegalArgumentException {
        try {
            this.validarDatos(licencia);
            if (vigencia <= 0) {
                throw new IllegalArgumentException("La vigencia debe ser mayor a 0");
            }
            return licenciaDAO.actualizarLicencia(licencia, vigencia);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede actualizar la licencia " + e.getMessage());
        }
    }
//    public Licencia eliminarLicencia(Licencia licencia)throws PersistenciaException;

    /**
     *
     * @return @throws IllegalArgumentException
     */
    public List<Licencia> consultarLicencias() throws IllegalArgumentException {
        try {
            return licenciaDAO.consultarLicencias();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo consultar licencias " + e.getMessage());
        }
    }

    /**
     *
     * @param persona
     * @return
     * @throws IllegalArgumentException
     */
    public List<Licencia> consultarLicenciasPersona(Persona persona) throws IllegalArgumentException {
        try {
            this.validarDatosPersona(persona);
            return licenciaDAO.consultarLicenciasPersona(persona);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo consultar licencias " + e.getMessage());
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
    public List<Licencia> consultarLicenciaPeriodo(Calendar desde, Calendar hasta, Persona persona) throws IllegalArgumentException {
        try {
            if (desde == null) {
                throw new IllegalArgumentException("La fecha desde no pueden ser nulas");
            }
            if (hasta == null) {
                throw new IllegalArgumentException("La fecha hasta no pueden ser nulas");
            }
            this.validarDatosPersona(persona);
            return licenciaDAO.consultarLicenciaPeriodo(desde, hasta, persona);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo consultar la licencia " + e.getMessage());
        }
    }
}
