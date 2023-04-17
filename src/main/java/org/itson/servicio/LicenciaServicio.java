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
import org.itson.utils.ConfiguracionDePaginado;

/**
 * Descripción de la clase: Esta clase se encarga de realizar la conexion con la
 * clase dao de licencia para antes hacer validaciones
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class LicenciaServicio {

    private ILicenciaDAO licenciaDAO;

    /**
     * Constructor por defecto que inicializa un objeto DAOFactory para obtener
     * un objeto ILicenciaDAO.
     */
    public LicenciaServicio() {
        this.licenciaDAO = new DAOFactory().getLicenciaDAO();
    }

    /**
     * Método que se encarga de guardar un trámite de Licencia
     *
     * @param licencia Licencia que se quiere guardar
     * @return La licencia que se guardó
     * @throws ServicioException En caso de que no se pueda añadir el trámite
     */
    public Licencia agregarLicencia(Licencia licencia) throws ServicioException {
        try {
            this.validarDatos(licencia);
            return licenciaDAO.agregarLicencia(licencia);
        } catch (PersistenciaException e) {
            throw new ServicioException("No se puede agregar la licencia: " + e.getMessage());
        }
    }

    /**
     * Método que se encarga de actualizar la licencia
     *
     * @param licencia Licencia que se quiere actualizar
     * @return Licencia que se actualizó
     * @throws ServicioException En caso de que no se haya podido actualizar
     */
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
    /**
     * Método que se encarga de consultar todas las licencias
     *
     * @return Lista de todas las licencias que hay en la base de datos
     * @throws ServicioException En caso de que no se haya podido realizar la
     * consulta
     */
    public List<Licencia> consultarLicencias() throws ServicioException {
        try {
            return licenciaDAO.consultarLicencias();
        } catch (PersistenciaException ep) {
            throw new PersistenciaException("Error al consultar las licencias " + ep.getMessage(), ep);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar licencias: " + e.getMessage());
        }
    }

    /**
     * Método que se encarga de consultar todas las licencias dependiendo de la
     * persona
     *
     * @param persona Persona de la que se quiere buscar sus licencias
     * @return Regresa todas las licencias de la persona
     * @throws ServicioException En caso de que no se pueda realizar la consulta
     */
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

    /**
     * Método que realiza la consulta por persona y limita para no traer todos
     * los tramites y se configura el páginado
     *
     * @param persona Persona de la que se quiere buscar sus trámites
     * @param paginado La cantidad de partes en la que va a traer los datos en
     * la consulta
     * @return Lista de licencias de la persona
     * @throws ServicioException En caso que no pueda realizarce la consulta
     */
    public List<Licencia> consultarLicenciasPersonaPaginado(Persona persona, ConfiguracionDePaginado paginado) throws ServicioException {
        try {
            this.validarDatosPersona(persona);
            return licenciaDAO.consultarLicenciasPersonaPaginado(persona, paginado);
        } catch (PersistenciaException ep) {
            throw new PersistenciaException("Error al consultar Licencias por Persona " + ep.getMessage(), ep);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar licencias: " + e.getMessage());
        }
    }

    /**
     * Validar los datos del objeto licencia
     *
     * @param licencia el objeto a validar
     * @throws ServicioException si algun atributo no es el correcto
     */
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
}
