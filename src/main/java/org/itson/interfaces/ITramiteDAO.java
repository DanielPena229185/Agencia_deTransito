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

    public Tramite agregarTramite(Tramite tramite)throws PersistenciaException;
    public Tramite actualizarTramite(Tramite tramite)throws PersistenciaException;
    public Tramite eliminarTramite(Tramite tramite)throws PersistenciaException;
    public List<Tramite> consultarTramites()throws PersistenciaException;
    public List<Tramite> consultarTramitesPersona(Persona persona)throws PersistenciaException;
    public List<Tramite> consultarTramitesPeriodo(Calendar desde, Calendar hasta, Persona persona)throws PersistenciaException;
}
