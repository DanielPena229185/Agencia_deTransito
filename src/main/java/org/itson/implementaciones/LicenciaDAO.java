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
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.ILicenciaDAO;

/**
 *
 * @author HP
 */
public class LicenciaDAO implements ILicenciaDAO {

    private EntityManager em;

    //Constructor por omisión
    public LicenciaDAO(ConexionBD conexion) {
        em = conexion.getConexion();
    }

    /**
     *
     * @param licencia
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Licencia agregarLicencia(Licencia licencia) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            em.persist(licencia);
            em.getTransaction().commit();
            return licencia;
        } catch (EntityExistsException a) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Esta licencia ya exite " + a.getMessage());
        } catch (Exception b) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo registrar la licencia");
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param licencia
     * @param vigencia
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Licencia actualizarLicencia(Licencia licencia, int vigencia) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            Licencia licenciaActualizada = em.find(Licencia.class, licencia.getIdTramite());
            if (licenciaActualizada == null) {
                throw new PersistenciaException("La licencia no existe en la base de datos");
            }
            licenciaActualizada.setEstado(licencia.getEstado());
            licenciaActualizada.setPrecio(licencia.getPrecio());
            licenciaActualizada.setFechaExpedicion(licencia.getFechaExpedicion());
            licenciaActualizada.setPersona(licencia.getPersona());
            licenciaActualizada.setFechaExpiracion(licencia.getFechaExpedicion(), vigencia);
            em.merge(licencia);
            em.getTransaction().commit();
            return licenciaActualizada;
        } catch (IllegalArgumentException b) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo actualizar la licencia " + b.getMessage());
        } catch (PersistenciaException b) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo actualizar la licencia " + b.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Licencia eliminarLicencia(Licencia licencia) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return @throws PersistenciaException
     */
    @Override
    public List<Licencia> consultarLicencias() throws PersistenciaException {
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Licencia> criteria = builder.createQuery(Licencia.class);
            Root<Licencia> root = criteria.from(Licencia.class);
            TypedQuery<Licencia> query = em.createQuery(criteria);
            List<Licencia> licencias = query.getResultList();
            em.getTransaction().commit();
            return licencias;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo generar la busqueda de licencias");
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
    public List<Licencia> consultarLicenciasPersona(Persona persona) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Licencia> criteria = builder.createQuery(Licencia.class);
            Root<Licencia> root = criteria.from(Licencia.class);
            criteria.where(
                    builder.equal(root.get("persona").get("idPersona"), persona.getIdPersona())
            );
            TypedQuery<Licencia> query = em.createQuery(criteria);
            List<Licencia> licencias = query.getResultList();
            em.getTransaction().commit();
            return licencias;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo generar la busqueda de licencias " + e.getLocalizedMessage());
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
    public List<Licencia> consultarLicenciaPeriodo(Calendar desde, Calendar hasta, Persona persona) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Licencia> criteria = builder.createQuery(Licencia.class);
            Root<Licencia> root = criteria.from(Licencia.class);
            criteria.select(root).where(
                    builder.and(
                            builder.between(root.get("fechaExpedicion"), desde, hasta),
                            builder.equal(root.get("persona"), persona)
                    )
            );
            TypedQuery<Licencia> query = em.createQuery(criteria);
            List<Licencia> licencias = query.getResultList();
            em.getTransaction().commit();
            return licencias;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo generar la busqueda de licencias " + e.getMessage());
        } finally {
            em.close();
        }
    }

}
