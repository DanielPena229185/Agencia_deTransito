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
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ServicioException;
import org.itson.implementaciones.DAOFactory;
import org.itson.interfaces.ILicenciaDAO;

/**
 *
 * @author HP
 */
public class LicenciaServicio {

    private ILicenciaDAO licenciaDAO;

    public LicenciaServicio() {
        this.licenciaDAO = new DAOFactory().getLicenciaDAO();
    }

    public Licencia agregarLicencia(Licencia licencia) throws ServicioException {
        try {
            this.validarDatos(licencia);
            return licenciaDAO.agregarLicencia(licencia);
        } catch (PersistenciaException e) {
            throw new ServicioException("No se puede agregar la licencia: " + e.getMessage());
        }
    }

    public Licencia actualizarLicencia(Licencia licencia) throws ServicioException {
        try {
            this.validarDatos(licencia);
            return licenciaDAO.actualizarLicencia(licencia);
        } catch (PersistenciaException ep) {
            throw new PersistenciaException("Error al actualizar la licencia " + ep.getMessage(), ep);
        } catch (ServicioException e) {
            throw new ServicioException("No se puede actualizar la licencia: " + e.getMessage());
        }
    }

//    public Licencia eliminarLicencia(Licencia licencia)throws PersistenciaException;
    public List<Licencia> consultarLicencias() throws ServicioException {
        try {
            return licenciaDAO.consultarLicencias();
        } catch (PersistenciaException ep) {
            throw new PersistenciaException("Error al consultar las licencias " + ep.getMessage(), ep);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar licencias: " + e.getMessage());
        }
    }

    public List<Licencia> consultarLicenciasPersona(Persona persona) throws ServicioException {
        try {
            this.validarDatosPersona(persona);
            return licenciaDAO.consultarLicenciasPersona(persona);
        } catch (PersistenciaException ep) {
            throw new PersistenciaException("Error al consultar Licencias por Persona " + ep.getMessage(), ep);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar licencias: " + e.getMessage());
        }

    }

    public List<Licencia> consultarLicenciaPeriodo(Calendar desde, Calendar hasta, Persona persona) throws ServicioException {
        try {
            if (desde == null) {
                throw new ServicioException("La fecha desde no pueden ser nulas");
            }
            if (hasta == null) {
                throw new ServicioException("La fecha hasta no pueden ser nulas");
            }
            this.validarDatosPersona(persona);
            return licenciaDAO.consultarLicenciaPeriodo(desde, hasta, persona);
        } catch (PersistenciaException ep) {
            throw new PersistenciaException("Error al  consultar licencias por periodo " + ep.getMessage(), ep);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar la licencia: " + e.getMessage());
        }
    }

    //Validar de datos
    public void validarDatos(Licencia licencia) throws ServicioException {
        if (licencia.getEstado() == null) {
            throw new ServicioException("El estado no puede ser nula");
        }

        if (licencia.getPrecio() <= 0) {
            throw new ServicioException("El precio debe ser mayor a 0");
        }

        if (licencia.getFechaExpedicion() == null) {
            throw new ServicioException("La fecha y hora no pueden ser nulas");
        }

        if (licencia.getPersona() == null) {
            throw new ServicioException("El persona de la licencia es requerido");
        }
    }

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
}
