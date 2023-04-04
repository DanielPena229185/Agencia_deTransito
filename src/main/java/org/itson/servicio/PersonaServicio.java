/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.servicio;

import java.util.List;
import org.itson.dominio.Persona;
import org.itson.implementaciones.DAOFactory;
import org.itson.interfaces.IPersonaDAO;

/**
 *
 * @author HP
 */
public class PersonaServicio {

    private IPersonaDAO personaDAO;

    /**
     *
     */
    public PersonaServicio() {
        this.personaDAO = new DAOFactory().getPersonaDAO();

    }

    /**
     *
     * @param persona
     * @throws IllegalArgumentException
     */
    public void validarDatos(Persona persona) throws IllegalArgumentException {
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
     * @param persona
     * @return
     * @throws IllegalArgumentException
     */
    public Persona agregarPersona(Persona persona) throws IllegalArgumentException {
        try {
            this.validarDatos(persona);
            return personaDAO.agregarPersona(persona);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede agregar la persona " + e.getMessage());
        }
    }

    /**
     *
     * @param persona
     * @return
     * @throws IllegalArgumentException
     */
    public Persona actualizarPersona(Persona persona) throws IllegalArgumentException {
        try {
            this.validarDatos(persona);
            return personaDAO.actualizarPersona(persona);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede actualizar la persona " + e.getMessage());
        }
    }

//    public Persona eliminarPersona(Persona persona)throws PersistenciaException;
    /**
     *
     * @param filtro
     * @param busqueda
     * @return
     * @throws IllegalArgumentException
     */
    public List<Persona> consultarPersonas(String filtro, String busqueda) throws IllegalArgumentException {
        try {
            return personaDAO.consultarPersonas(filtro, busqueda);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede realizar la consulta " + e.getMessage());
        }
    }

    /**
     *
     * @return @throws IllegalArgumentException
     */
    public List<Persona> consultarPersonas() throws IllegalArgumentException {
        try {
            return personaDAO.consultarPersonas();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede realizar la consulta " + e.getMessage());
        }
    }

    public Persona consultarPersona(Long id) throws IllegalArgumentException {
        try {
            return personaDAO.buscarPersona(id);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede realizar la busqueda " + e.getMessage());
        }
    }

}
