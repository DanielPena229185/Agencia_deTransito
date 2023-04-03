/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.implementaciones;

import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.itson.dominio.Automovil;
import org.itson.dominio.Placa;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IAutomovilDAO;

/**
 *
 * @author HP
 */
public class AutomovilDAO implements IAutomovilDAO {

    private EntityManager em;

    /**
     *
     * @param conexion
     */
    public AutomovilDAO(ConexionBD conexion) {
        this.em = conexion.getConexion();

    }

    @Override
    public Automovil agregarVehiculo(Automovil automovil) throws PersistenciaException {
        try {
            this.em.getTransaction().begin();
            this.em.persist(automovil);
            this.em.getTransaction().commit();
            return automovil;
        } catch (EntityExistsException a) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Este automovil ya exite en la base de datos" + a.getMessage());
        } catch (Exception e) {
            this.em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo agregar el automovil" + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Automovil actualizarVehiculo(Automovil automovil) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            Automovil automovilActualizado = em.find(Automovil.class, automovil.getIdVehiculo());
            if (automovilActualizado == null) {
                throw new PersistenciaException("El automovil no existe en la base de datos");
            }
            automovilActualizado.setNumeroSerie(automovil.getNumeroSerie());
            automovilActualizado.setMarca(automovil.getMarca());
            automovilActualizado.setColor(automovil.getColor());
            automovilActualizado.setModelo(automovil.getModelo());
            automovilActualizado.setLinea(automovil.getLinea());
            em.merge(automovilActualizado);
            em.getTransaction().commit();
            return automovilActualizado;
        } catch (IllegalArgumentException b) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo actualizar el automovil " + b.getMessage());
        } catch (PersistenciaException b) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo actualizar el automovil " + b.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Automovil eliminarVehiculo(Automovil automovil) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Automovil> consultarVehiculos() throws PersistenciaException {
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Automovil> criteria = builder.createQuery(Automovil.class);
            Root<Automovil> root = criteria.from(Automovil.class);
            TypedQuery<Automovil> query = em.createQuery(criteria);
            List<Automovil> automoviles = query.getResultList();
            em.getTransaction().commit();
            return automoviles;
        } catch (PersistenciaException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al consultar los automoviles en la base de datos " + e.getMessage());
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
    public List<Automovil> consultarVehiculo(Placa placa) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Automovil> criteria = builder.createQuery(Automovil.class);
            Root<Automovil> root = criteria.from(Automovil.class);
            criteria.where(
                    builder.equal(root.get("placas").get("id_tramite"), placa.getIdTramite())
            );
            TypedQuery<Automovil> query = em.createQuery(criteria);
            List<Automovil> automoviles = query.getResultList();
            em.getTransaction().commit();
            return automoviles;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo generar la busqueda de automoviles " + e.getMessage());
        } finally {
            em.close();
        }
    }

}
