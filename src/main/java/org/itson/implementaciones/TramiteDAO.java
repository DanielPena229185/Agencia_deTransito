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
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    public TramiteDAO(ConexionBD conexion) {
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

    /**
     *
     * @param tramite
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Tramite actualizarTramite(Tramite tramite) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            Tramite tramiteActualizado = em.find(Tramite.class, tramite.getIdTramite());
            tramiteActualizado.actualizarTramite(tramite);
            em.merge(tramite);
            em.getTransaction().commit();
            return tramiteActualizado;
        } catch (Exception b) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo actualizar el tramite");
        } finally {
            em.close();
        }
    }

    @Override
    public Tramite eliminarTramite(Tramite tramite) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Tramite> consultarTramites() throws PersistenciaException {
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Tramite> criteria = builder.createQuery(Tramite.class);
            Root<Tramite> root = criteria.from(Tramite.class);
            TypedQuery<Tramite> query = em.createQuery(criteria);
            List<Tramite> tramites = query.getResultList();
            em.getTransaction().commit();
            return tramites;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo generar la busqueda de tramites");
        } finally {
            em.close();
        }
    }

    @Override
    public List<Tramite> consultarTramitesPersona(Persona persona) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Tramite> criteria = builder.createQuery(Tramite.class);
            Root<Tramite> root = criteria.from(Tramite.class);
            criteria.where(
                    builder.equal(root.get("persona").get("idPersona"), persona.getIdPersona())
            );

            TypedQuery<Tramite> query = em.createQuery(criteria);
            List<Tramite> tramites = query.getResultList();
            em.getTransaction().commit();
            return tramites;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo generar la busqueda de tramites");
        } finally {
            em.close();
        }
    }

    @Override
    public List<Tramite> consultarTramitesPeriodo(Calendar desde, Calendar hasta, Persona persona) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
