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
 * Descripción de la clase: Esta clase se encarga de realizar la conexion con la
 * clase dao de la placa para antes hacer validaciones
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class PlacaServicio {

    private IPlacaDAO placaDAO;

    /**
     * Constructor por defecto que inicializa un objeto DAOFactory para obtener
     * un objeto IPlacaDAO.
     */
    public PlacaServicio() {
        this.placaDAO = new DAOFactory().getPlacaDAO();
    }

    /**
     *
     * Agrega una nueva placa al sistema.
     *
     * @param placa la placa a agregar al sistema.
     * @return la placa agregada al sistema.
     * @throws ServicioException si ocurre un error al interactuar con el
     * sistema de persistencia.
     */
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

    /**
     * Actualiza la información de una placa existente en la base de datos.
     *
     * @param placa la placa a actualizar
     * @return la placa actualizada
     * @throws ServicioException si ocurre un error al acceder a la base de
     * datos
     */
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

    /**
     * Devuelve una lista de todas las placas registradas en el sistema.
     *
     * @return una lista de todas las placas registradas en el sistema.
     * @throws ServicioException si ocurre algún error al interactuar con el
     * almacenamiento persistente.
     */
    public List<Placa> consultarPlaca() throws ServicioException {
        try {
            return placaDAO.consultarPlaca();
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar las placas: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar las placas: " + e.getMessage());
        }
    }

    /**
     * Devuelve una lista de todas las placas registradas en el sistema que
     * están asociadas con una persona dada.
     *
     * @param persona la persona para la cual se desea obtener las placas
     * asociadas.
     * @return una lista de todas las placas registradas en el sistema que están
     * asociadas con la persona dada.
     * @throws ServicioException si ocurre algún error al interactuar con el
     * almacenamiento persistente.
     */
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

    /**
     * Consulta las placas de una persona de forma paginada.
     *
     * @param persona La persona de la que se quieren consultar las placas.
     * @param paginado La configuración de paginado que se quiere utilizar.
     * @return La lista de placas de la persona consultada, de acuerdo a la
     * configuración de paginado especificada.
     * @throws ServicioException Si ocurre un error en la operación de consulta.
     */
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

    /**
     * Consulta las placas de una persona en un período de tiempo específico.
     *
     * @param desde La fecha de inicio del período de tiempo.
     * @param hasta La fecha de fin del período de tiempo.
     * @param persona La persona de la que se quieren consultar las placas.
     * @return La lista de placas de la persona consultada que se encontraron
     * dentro del período de tiempo especificado.
     * @throws ServicioException Si ocurre un error en la operación de consulta.
     */
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

    /**
     * Obtiene la lista de placas de todos los vehículos asociados a sus
     * respectivos dueños.
     *
     * @return una lista de matrices de objetos, donde cada fila contiene la
     * información de la placa, el vehículo y la persona propietaria.
     * @throws ServicioException si ocurre un error al interactuar con el
     * sistema de persistencia de datos.
     */
    public List<Object[]> consultarPlacasPersonas() throws ServicioException {
        try {
            return placaDAO.consultarPlacasPersonas();
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar placas: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar las placas: " + e.getMessage());
        }
    }

    /**
     * Obtiene la lista de placas de los vehículos asociados a las personas cuyo
     * nombre, número de identificación o dirección contengan la cadena
     * especificada en el parámetro de búsqueda.
     *
     * @param busqueda la cadena de texto a buscar en los datos de las personas
     * asociadas a los vehículos.
     * @return una lista de matrices de objetos, donde cada fila contiene la
     * información de la placa, el vehículo y la persona propietaria.
     * @throws ServicioException ocurre un error al interactuar con el sistema
     * de persistencia de datos.
     */
    public List<Object[]> consultarPlacasPersonasFiltro(String busqueda) throws ServicioException {
        try {
            return placaDAO.consultarPlacasPersonasFiltro(busqueda);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar las placas: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar las placas: " + e.getMessage());
        }
    }

    /**
     * Busca y retorna una lista de objetos que contienen la información de la
     * placa y la persona asociada a dicha placa, filtrando los resultados según
     * el valor de búsqueda proporcionado, y aplicando paginación a los
     * resultados.
     *
     * @param busqueda valor de búsqueda para filtrar los resultados de la
     * consulta.
     * @param paginado configuración de paginación a aplicar a los resultados de
     * la consulta.
     * @return lista de objetos que contienen la información de la placa y la
     * persona asociada a dicha placa.
     * @throws ServicioException si ocurre algún error durante la ejecución de
     * la consulta.
     */
    public List<Object[]> consultarPlacasPersonasFiltroPaginado(String busqueda, ConfiguracionDePaginado paginado) throws ServicioException {
        try {
            return placaDAO.consultarPlacasPersonasFiltroPaginado(busqueda, paginado);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar las placas: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar las placas: " + e.getMessage());
        }
    }

    /**
     * Devuelve una lista de todas las placas registradas en el sistema.
     *
     * @return una lista de todas las placas registradas en el sistema.
     * @throws ServicioException si ocurre algún error al interactuar con el
     * almacenamiento persistente.
     */
    public Placa consultarPlaca(Placa placa) throws ServicioException {
        try {
            return placaDAO.consultarPlaca(placa);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar la placa: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar la placa: " + e.getMessage());
        }
    }

    /**
     *
     * Consulta la placa asociada a un vehículo en la base de datos.
     *
     * @param vehiculo El vehículo del cual se desea consultar la placa.
     * @return La placa asociada al vehículo consultado.
     * @throws ServicioException Si ocurre un error en la consulta.
     */
    public Placa consultarPlacaVehiculo(Vehiculo vehiculo) throws ServicioException {
        try {
            return placaDAO.consultarPlacasVehiculo(vehiculo);
        } catch (PersistenciaException pe) {
            throw new PersistenciaException("Error al consultar placa por vehiculo: " + pe.getMessage(), pe);
        } catch (ServicioException e) {
            throw new ServicioException("No se pudo consultar la placa: " + e.getMessage());
        }
    }

    /**
     * Valida los atributos del objeto placa
     *
     * @param placa objeto a validar
     * @throws ServicioException si algun atributo no sea el correcto
     */
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
