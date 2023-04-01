/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.implementaciones;

import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.dominio.Tramite;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IPlacaDAO;

/**
 *
 * @author HP
 */
public class PlacaDAO implements IPlacaDAO {

    private EntityManager em;

    //Constructor por omisión
    public PlacaDAO(ConexionBD conexion) {
        em = conexion.getConexion();
    }

    /**
     *
     * @param placa
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Placa agregarPlaca(Placa placa) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            em.persist(placa);
            em.getTransaction().commit();
            return placa;
        } catch (EntityExistsException a) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Esta placa ya exite " + a.getMessage());
        } catch (Exception b) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo registrar la placa " + b.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param placa
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Placa actualizarTramite(Placa placa) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            Placa plactaActualizada = em.find(Placa.class, placa.getIdTramite());
            if (plactaActualizada == null) {
                throw new PersistenciaException("La placa no existe en la base de datos");
            }
            plactaActualizada.setEstado(placa.getEstado());
            plactaActualizada.setPrecio(placa.getPrecio());
            plactaActualizada.setFechaExpedicion(placa.getFechaExpedicion());
            plactaActualizada.setPago(placa.getPago());
            plactaActualizada.setPersona(placa.getPersona());
            plactaActualizada.setNumero(placa.getNumero());
            plactaActualizada.setFechaRecepcion(placa.getFechaRecepcion());
            em.merge(plactaActualizada);
            em.getTransaction().commit();
            return plactaActualizada;
        } catch (IllegalArgumentException b) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo actualizar la placa " + b.getMessage());
        } catch (PersistenciaException b) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo actualizar la placa " + b.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Placa eliminarTramite(Placa placa) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return @throws PersistenciaException
     */
    @Override
    public List<Placa> consultarTramites() throws PersistenciaException {
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Placa> criteria = builder.createQuery(Placa.class);
            Root<Placa> root = criteria.from(Placa.class);
            TypedQuery<Placa> query = em.createQuery(criteria);
            List<Placa> placas = query.getResultList();
            em.getTransaction().commit();
            return placas;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo generar la busqueda de placas " + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param persona
     * @return
     * @throws PersistenciaException
     */
    @Override
    public List<Placa> consultarTramitesPersona(Persona persona) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Placa> criteria = builder.createQuery(Placa.class);
            Root<Placa> root = criteria.from(Placa.class);
            criteria.where(
                    builder.equal(root.get("persona").get("idPersona"), persona.getIdPersona())
            );
            TypedQuery<Placa> query = em.createQuery(criteria);
            List<Placa> placas = query.getResultList();
            em.getTransaction().commit();
            return placas;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo generar la busqueda de placas");
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param desde
     * @param hasta
     * @param persona
     * @return
     * @throws PersistenciaException
     */
    @Override
    public List<Placa> consultarTramitesPeriodo(Calendar desde, Calendar hasta, Persona persona) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Placa> criteria = builder.createQuery(Placa.class);
            Root<Placa> root = criteria.from(Placa.class);
            criteria.select(root).where(
                    builder.and(
                            builder.between(root.get("fechaExpedicion"), desde, hasta),
                            builder.equal(root.get("persona"), persona)
                    )
            );
            TypedQuery<Placa> query = em.createQuery(criteria);
            List<Placa> placas = query.getResultList();
            em.getTransaction().commit();
            return placas;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo generar la busqueda de placas");
        } finally {
            em.close();
        }
    }

}
