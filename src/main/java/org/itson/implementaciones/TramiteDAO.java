/**
 * TramiteDAO.java
 * 29 mar. 2023 09:49:32
 */
package org.itson.implementaciones;
//importanciones

import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import org.itson.dominio.Persona;
import org.itson.dominio.Tramite;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.ITramiteDAO;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class TramiteDAO implements ITramiteDAO {

    private EntityManager em;

    //Constructor por omisión
    public TramiteDAO(Conexion conexion) {
        em = conexion.getConexion();
    }

    /**
     * Metódo que registra tramite
     *
     * @param tramite a ingresar
     * @return el tramite ya registrado
     * @throws PersistenciaException cuando ya exista un registro igual en la
     * base en la base de datos
     */
    @Override
    public Tramite agregarTramite(Tramite tramite) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            em.persist(tramite);
            em.getTransaction().commit();
            return tramite;
        } catch (EntityExistsException a) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Esta tramite ya exite");
        } catch (Exception b) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo registrar a el tramite");
        } finally {
            em.close();
        }
    }

    @Override
    public Tramite actualizarTramite(Tramite tramite) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Tramite eliminarTramite(Tramite tramite) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Tramite> consultarTramites() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Tramite> consultarTramitesPersona(Persona persona) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Tramite> consultarTramitesPeriodo(Calendar desde, Calendar hasta, Persona persona) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
