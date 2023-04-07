/**
* IPersonaDAO.java
* 28 mar. 2023 18:42:59
*/ 

package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Persona;
import org.itson.excepciones.PersistenciaException;

/**
 * Descripción de la interface: 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface IPersonaDAO {
    
    public Persona agregarPersona(Persona persona)throws PersistenciaException;
    public Persona actualizarPersona(Persona persona)throws PersistenciaException;
    public Persona eliminarPersona(Persona persona)throws PersistenciaException;
    public Persona buscarPersona(Persona persona)throws PersistenciaException;
    /**
     * Consulta que se condiciona en la busqueda por filtro
     * @param filtro De que manera quiere buscar
     * @param busqueda Lo que quiere buscar
     * @return Lista de personas que tienen relación con la búsqueda
     * @throws PersistenciaException En caso de que algo salga mal en la búsqueda
     */
    public List<Persona> consultarPersonasFiltro(String filtro, String busqueda)throws PersistenciaException;
    public List<Persona> consultarPersonas()throws PersistenciaException;
}
