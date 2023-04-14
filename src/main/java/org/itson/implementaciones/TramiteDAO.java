/**
 * TramiteDAO.java
 * 29 mar. 2023 09:49:32
 */
package org.itson.implementaciones;
//importanciones

import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;
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

    private ConexionBD conexion;

    public TramiteDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public Tramite agregarTramite(Tramite tramite) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            em.persist(tramite);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Tramite guardado con exito");
            return tramite;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo registrar a el tramite " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo registrar a el tramite " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

    @Override
    public Tramite actualizarTramite(Tramite tramite) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            Tramite tramiteActualizado = em.find(Tramite.class, tramite.getIdTramite());
            if (tramiteActualizado == null) {
                JOptionPane.showMessageDialog(null, "El tramite no existe en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                throw new PersistenciaException("El tramite no existe en la base de datos");
            }
            tramiteActualizado.setEstado(tramite.getEstado());
            tramiteActualizado.setPrecio(tramite.getPrecio());
            tramiteActualizado.setFechaExpedicion(tramite.getFechaExpedicion());
            tramiteActualizado.setPago(tramite.getPago());
            tramiteActualizado.setPersona(tramite.getPersona());
            em.merge(tramiteActualizado);
            JOptionPane.showMessageDialog(null, "Tramite actualizado con exito");
            em.getTransaction().commit();
            return tramiteActualizado;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo actualizar a el tramite " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo actualizar el tramite " + a.getMessage(), a);
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
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Tramite> criteria = builder.createQuery(Tramite.class);
            TypedQuery<Tramite> query = em.createQuery(criteria);
            List<Tramite> tramites = query.getResultList();
            em.getTransaction().commit();
            return tramites;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo generar la busqueda de tramites: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo generar la busqueda de tramites: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Tramite> consultarTramitesPersona(Persona persona) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
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
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo generar la busqueda de tramites: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo generar la busqueda de tramites: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Tramite> consultarTramitesPeriodo(Calendar desde, Calendar hasta, String nombre) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Tramite> criteria = builder.createQuery(Tramite.class);
            Root<Tramite> root = criteria.from(Tramite.class);
            Join<Tramite, Persona> joinPersona = root.join("persona"); // Se hace el join con la clase Persona
            criteria.select(root).where(
                    builder.and(
                            builder.between(root.get("fechaExpedicion"), desde, hasta),
                            builder.like(joinPersona.get("nombres"), "%" + nombre + "%") // Se utiliza el like para buscar por los nombres de la persona
                    )
            );
            TypedQuery<Tramite> query = em.createQuery(criteria);
            List<Tramite> tramites = query.getResultList();
            em.getTransaction().commit();
            return tramites;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo generar la busqueda de tramites: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo generar la busqueda de tramites: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

}
