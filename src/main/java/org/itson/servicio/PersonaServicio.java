/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.servicio;

import java.util.List;
import org.itson.dominio.Persona;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ServicioException;
import org.itson.implementaciones.DAOFactory;
import org.itson.interfaces.IPersonaDAO;
import org.itson.utils.ConfiguracionDePaginado;

/**
 * Descripción de la clase: Esta clase se encarga de realizar la conexion con la
 * clase dao de la persona para antes hacer validaciones
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class PersonaServicio {

    private IPersonaDAO personaDAO;

    /**
     * Constructor por defecto que inicializa un objeto DAOFactory para obtener
     * un objeto IPersonaDAO.
     */
    public PersonaServicio() {
        this.personaDAO = new DAOFactory().getPersonaDAO();

    }

    /**
     * Agrega una nueva persona a la base de datos
     *
     * @param persona La persona a agregar
     * @return La persona agregada
     * @throws ServicioException En caso de que algo salga mal en la inserción
     */
    public Persona agregarPersona(Persona persona) throws ServicioException {
        try {
            this.validarDatos(persona);
            return personaDAO.agregarPersona(persona);
        } catch (PersistenciaException pe) {
            throw new ServicioException("Error al agregar a la persona: "
                    + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se puede agregar la persona: " + e.getMessage());
        }
    }

    /**
     * Actualiza una persona existente en la base de datos
     *
     * @param persona La persona a actualizar
     * @return La persona actualizada
     * @throws ServicioException En caso de que algo salga mal en la
     * actualización
     */
    public Persona actualizarPersona(Persona persona) throws ServicioException {
        try {
            this.validarDatos(persona);
            return personaDAO.actualizarPersona(persona);
        } catch (PersistenciaException pe) {
            throw new ServicioException("Error al actualizar a la persona: "
                    + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se puede actualizar la persona: " + e.getMessage());
        }
    }

//    public Persona eliminarPersona(Persona persona)throws PersistenciaException;
    /**
     * Consulta personas en la base de datos según un filtro de consulta
     *
     * @param filtro El filtro de consulta
     * @param busqueda El término de consulta
     * @return La lista de personas que cumplen con el filtro y la consulta
     * @throws ServicioException En caso de que algo salga mal en la consulta
     */
    public List<Persona> consultarPersonasFiltro(String filtro, String busqueda) throws ServicioException {
        try {
            return personaDAO.consultarPersonasFiltro(filtro, busqueda);
        } catch (PersistenciaException pe) {
            throw new ServicioException("Error al consultar a las "
                    + "personas por filtro: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se puede realizar la consulta: " + e.getMessage());
        }
    }

    /**
     * Consulta personas en la base de datos según un filtro de consulta y
     * paginación
     *
     * @param filtro El filtro de consulta
     * @param busqueda El término de consulta
     * @param paginado La configuración de paginación
     * @return La lista de personas que cumplen con el filtro, la consulta y la
     * paginación
     * @throws ServicioException En caso de que algo salga mal en la consulta
     */
    public List<Persona> consultarPersonasFiltroPaginado(String filtro, String busqueda, ConfiguracionDePaginado paginado) throws ServicioException {
        try {
            return personaDAO.consultarPersonasFiltroPaginado(filtro, busqueda, paginado);
        } catch (PersistenciaException pe) {
            throw new ServicioException("Error al consultar a las "
                    + "personas por filtro: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se puede realizar la consulta: " + e.getMessage());
        }
    }

    /**
     * Consulta todas las personas en la base de datos
     *
     * @return La lista de todas las personas en la base de datos
     * @throws ServicioException En caso de que algo salga mal en la consulta
     */
    public List<Persona> consultarPersonas() throws ServicioException {
        try {
            return personaDAO.consultarPersonas();
        } catch (PersistenciaException pe) {
            throw new ServicioException("Error al consultar a las personas: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se puede realizar la consulta: " + e.getMessage());
        }
    }

    /**
     * Busca una persona en la base de datos
     *
     * @param persona La persona a buscar (se busca por su ID)
     * @return La persona encontrada
     * @throwsServicioException En caso de que algo salga mal en la consulta
     */
    public Persona consultarPersona(Persona persona) throws ServicioException {
        try {
            return personaDAO.buscarPersona(persona);
        } catch (PersistenciaException pe) {
            throw new ServicioException("Error al consultar a la persona: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se puede realizar la busqueda: " + e.getMessage());
        }
    }

    /**
     * Validar los datos del objeto persona
     *
     * @param persona el objeto a validar
     * @throws ServicioException si algun atributo no es el correcto
     */
    public void validarDatos(Persona persona) throws ServicioException {
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
