/**
 * ITramiteDAO.java
 * 28 mar. 2023 20:23:24
 */
package org.itson.interfaces;

import java.util.Calendar;
import java.util.List;
import org.itson.dominio.Persona;
import org.itson.dominio.Tramite;
import org.itson.excepciones.PersistenciaException;

/**
 * Descripción de la interface:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface ITramiteDAO {

    /**
     * Agrega un nuevo trámite a la base de datos.
     *
     * @param tramite El trámite a agregar.
     * @return El trámite agregado.
     * @throws PersistenciaException Si algo sale mal al agregar.
     */
    public Tramite agregarTramite(Tramite tramite) throws PersistenciaException;

    /**
     * Actualiza un trámite existente en la base de datos.
     *
     * @param tramite El trámite a actualizar.
     * @return El trámite actualizado.
     * @throws PersistenciaException Si algo sale mal al actualizar.
     */
    public Tramite actualizarTramite(Tramite tramite) throws PersistenciaException;

    /**
     * Elimina un trámite existente en la base de datos.
     *
     * @param tramite El trámite a eliminar.
     * @return El trámite eliminado.
     * @throws PersistenciaException Si algo sale mal al eliminar.
     */
    public Tramite eliminarTramite(Tramite tramite) throws PersistenciaException;

    /**
     * Consulta todos los trámites existentes en la base de datos.
     *
     * @return Lista con todos los trámites.
     * @throws PersistenciaException Si algo sale mal al consultar.
     */
    public List<Tramite> consultarTramites() throws PersistenciaException;

    /**
     * Consulta los trámites relacionados con una persona.
     *
     * @param persona La persona para la que se consultan los trámites.
     * @return Lista con los trámites relacionados con la persona.
     * @throws PersistenciaException Si algo sale mal al consultar.
     */
    public List<Tramite> consultarTramitesPersona(Persona persona) throws PersistenciaException;

    /**
     * Consulta los trámites realizados en un período determinado y que
     * contienen un nombre de la persona en específico.
     *
     * @param desde Fecha inicial del período.
     * @param hasta Fecha final del período.
     * @param nombre Nombre que de la persona relacionada
     * @return Lista con los trámites realizados en el período y que contienen
     * el nombre específico.
     * @throws PersistenciaException Si algo sale mal al consultar.
     */
    public List<Tramite> consultarTramitesPeriodo(Calendar desde, Calendar hasta, String nombre) throws PersistenciaException;
}
