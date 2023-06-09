/**
 * TramiteDAO.java
 * 29 mar. 2023 09:49:32
 */
package org.itson.implementaciones;
//importanciones

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;
import org.itson.dominio.Persona;
import org.itson.dominio.Tramite;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.ITramiteDAO;

/**
 * Descripción de la clase: Esta clase se encarga de realizar operaciones en la
 * base de datos con respecto a la clase padre Tramite
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class TramiteDAO implements ITramiteDAO {

    /**
     * Conexión a la base de datos
     */
    private ConexionBD conexion;

    /**
     * Constructor de la clase TramiteDAO
     *
     * @param conexion Conexión de la base de datos
     */
    public TramiteDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * Agrega un nuevo trámite a la base de datos.
     *
     * @param tramite El trámite a agregar.
     * @return El trámite agregado.
     * @throws PersistenciaException Si algo sale mal al agregar.
     */
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

    /**
     * Actualiza un trámite existente en la base de datos.
     *
     * @param tramite El trámite a actualizar.
     * @return El trámite actualizado.
     * @throws PersistenciaException Si algo sale mal al actualizar.
     */
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

    /**
     * Elimina un trámite existente en la base de datos.
     *
     * @param tramite El trámite a eliminar.
     * @return El trámite eliminado.
     * @throws PersistenciaException Si algo sale mal al eliminar.
     */
    @Override
    public Tramite eliminarTramite(Tramite tramite) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Consulta todos los trámites existentes en la base de datos.
     *
     * @return Lista con todos los trámites.
     * @throws PersistenciaException Si algo sale mal al consultar.
     */
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

    /**
     * Consulta los trámites relacionados con una persona.
     *
     * @param persona La persona para la que se consultan los trámites.
     * @return Lista con los trámites relacionados con la persona.
     * @throws PersistenciaException Si algo sale mal al consultar.
     */
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
    @Override
    public List<Tramite> consultarTramitesPeriodo(Calendar desde, Calendar hasta, String nombre) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();

            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Tramite> criteria = builder.createQuery(Tramite.class);
            Root<Tramite> root = criteria.from(Tramite.class);
            List<Predicate> predicados = new LinkedList<>();
            Join<Tramite, Persona> joinPersona = root.join("persona");
            if (desde != null && hasta != null) {
                predicados.add(builder.between(root.get("fechaExpedicion"), desde, hasta));
            }
            if (nombre != null) {
                predicados.add(builder.like(joinPersona.get("nombres"), "%" + nombre + "%"));
            }
            ; // Se hace el join con la clase Persona
            criteria.select(root).where(
                    builder.and(predicados.toArray(new Predicate[0]))
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
