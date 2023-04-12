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
import org.itson.dominio.Vehiculo;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ServicioException;
import org.itson.implementaciones.DAOFactory;
import org.itson.interfaces.IPlacaDAO;
import org.itson.utils.ConfiguracionDePaginado;

/**
 *
 * @author HP
 */
public class PlacaServicio {

    private IPlacaDAO placaDAO;

    public PlacaServicio() {
        this.placaDAO = new DAOFactory().getPlacaDAO();
    }

    public Placa agregarPlaca(Placa placa) throws ServicioException {
        try {
            this.validarDatos(placa);
            return placaDAO.agregarPlaca(placa);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al agregar las placas: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se puede agregar la placa: " + e.getMessage());
        }
    }

    public Placa actualizarPlaca(Placa placa) throws ServicioException {
        try {
            this.validarDatos(placa);
            return placaDAO.actualizarPlaca(placa);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al actualizar las placas: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se puede actualizar la placa: " + e.getMessage());
        }
    }
//    public Placa eliminarTramite(Placa placa)throws PersistenciaException;

    public List<Placa> consultarPlaca() throws ServicioException {
        try {
            return placaDAO.consultarPlaca();
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar las placas: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar las placas: " + e.getMessage());
        }
    }

    public List<Placa> consultarPlacasPersona(Persona persona) throws ServicioException {
        try {
            this.validarDatosPersona(persona);
            return placaDAO.consultarPlacasPersona(persona);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar placas por Persona: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar las placas: " + e.getMessage());
        }
    }

    public List<Placa> consultarPlacasPersona(Persona persona, ConfiguracionDePaginado paginado) throws ServicioException {
        try {
            this.validarDatosPersona(persona);
            return placaDAO.consultarPlacasPersonaPaginado(persona, paginado);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar placas por Persona: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar las placas: " + e.getMessage());
        }
    }

    public List<Placa> consultarPlacasPeriodo(Calendar desde, Calendar hasta, Persona persona) throws ServicioException {
        try {
            this.validarFechas(desde, hasta);
            this.validarDatosPersona(persona);
            return placaDAO.consultarPlacasPeriodo(desde, hasta, persona);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar placas por periodo: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar el tramite: " + e.getMessage());
        }
    }

    public List<Object[]> consultarPlacasPersonas() throws ServicioException {
        try {
            return placaDAO.consultarPlacasPersonas();
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar placas: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar las placas: " + e.getMessage());
        }
    }

    public List<Object[]> consultarPlacasPersonasFiltro(String busqueda) throws ServicioException {
        try {
            return placaDAO.consultarPlacasPersonasFiltro(busqueda);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar las placas: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar las placas: " + e.getMessage());
        }
    }

    public Placa consultarPlaca(Placa placa) throws ServicioException {
        try {
            return placaDAO.consultarPlaca(placa);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar la placa: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar la placa: " + e.getMessage());
        }
    }

    public Placa consultarPlacaVehiculo(Vehiculo vehiculo) throws ServicioException {
        try {
            return placaDAO.consultarPlacasVehiculo(vehiculo);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar placa por vehiculo: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar la placa: " + e.getMessage());
        }
    }

    public void validarDatos(Placa placa) throws ServicioException {
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

    private void validarFechas(Calendar desde, Calendar hasta) throws ServicioException {
        if (desde == null) {
            throw new ServicioException("La fecha desde no pueden ser nulas");
        }
        if (hasta == null) {
            throw new ServicioException("La fecha hasta no pueden ser nulas");
        }
    }
}
