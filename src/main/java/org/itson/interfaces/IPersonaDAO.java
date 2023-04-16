/**
 * IPersonaDAO.java
 * 28 mar. 2023 18:42:59
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Persona;
import org.itson.excepciones.PersistenciaException;
import org.itson.utils.ConfiguracionDePaginado;

/**
 * Descripción de la clase: Interfaz donde se implementará para tener la
 * comunicación con la base de datos con respecto a las personas
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public interface IPersonaDAO {

    /**
     * Agrega una nueva persona a la base de datos
     *
     * @param persona La persona a agregar
     * @return La persona agregada
     * @throws PersistenciaException En caso de que algo salga mal en la
     * inserción
     */
    public Persona agregarPersona(Persona persona) throws PersistenciaException;

    /**
     * Actualiza una persona existente en la base de datos
     *
     * @param persona La persona a actualizar
     * @return La persona actualizada
     * @throws PersistenciaException En caso de que algo salga mal en la
     * actualización
     */
    public Persona actualizarPersona(Persona persona) throws PersistenciaException;

    /**
     * Elimina una persona existente en la base de datos
     *
     * @param persona La persona a eliminar
     * @return La persona eliminada
     * @throws PersistenciaException En caso de que algo salga mal en la
     * eliminación
     */
    public Persona eliminarPersona(Persona persona) throws PersistenciaException;

    /**
     * Busca una persona en la base de datos
     *
     * @param persona La persona a buscar (se busca por su ID)
     * @return La persona encontrada
     * @throws PersistenciaException En caso de que algo salga mal en la
     * consulta
     */
    public Persona buscarPersona(Persona persona) throws PersistenciaException;

    /**
     * Consulta personas en la base de datos según un filtro de consulta
     *
     * @param filtro El filtro de consulta
     * @param busqueda El término de consulta
     * @return La lista de personas que cumplen con el filtro y la consulta
     * @throws PersistenciaException En caso de que algo salga mal en la
     * consulta
     */
    public List<Persona> consultarPersonasFiltro(String filtro, String busqueda) throws PersistenciaException;

    /**
     * Consulta personas en la base de datos según un filtro de consulta y
     * paginación
     *
     * @param filtro El filtro de consulta
     * @param busqueda El término de consulta
     * @param paginado La configuración de paginación
     * @return La lista de personas que cumplen con el filtro, la consulta y la
     * paginación
     * @throws PersistenciaException En caso de que algo salga mal en la
     * consulta
     */
    public List<Persona> consultarPersonasFiltroPaginado(String filtro, String busqueda, ConfiguracionDePaginado paginado) throws PersistenciaException;

    /**
     * Consulta todas las personas en la base de datos
     *
     * @return La lista de todas las personas en la base de datos
     * @throws PersistenciaException En caso de que algo salga mal en la
     * consulta
     */
    public List<Persona> consultarPersonas() throws PersistenciaException;
}
