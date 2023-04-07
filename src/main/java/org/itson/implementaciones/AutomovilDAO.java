/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.implementaciones;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;
import org.itson.dominio.Automovil;
import org.itson.dominio.Vehiculo;
import org.itson.dominio.Placa;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IAutomovilDAO;

/**
 *
 * @author HP
 */
public class AutomovilDAO implements IAutomovilDAO {

    private ConexionBD conexion;

    public AutomovilDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public Automovil agregarAutomovil(Automovil automovil) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            em.persist(automovil);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Automovil guardado con exito");
            return automovil;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo agregar el automovil: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo agregar el automovil: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

    @Override
    public Automovil actualizarAutomovil(Automovil automovil) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            Automovil automovilActualizado = em.find(Automovil.class, automovil.getIdVehiculo());
            if (automovilActualizado == null) {
                JOptionPane.showMessageDialog(null, "El automovil no existe en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                throw new PersistenciaException("El automovil no existe en la base de datos");
            }
            automovilActualizado.setNumeroSerie(automovil.getNumeroSerie());
            automovilActualizado.setMarca(automovil.getMarca());
            automovilActualizado.setColor(automovil.getColor());
            automovilActualizado.setModelo(automovil.getModelo());
            automovilActualizado.setLinea(automovil.getLinea());
            em.merge(automovilActualizado);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Automovil actualizado con exito");
            return automovilActualizado;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el automovil: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo actualizar el automovil: " + a.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Automovil eliminarAutomovil(Automovil automovil) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Automovil> consultarAutomoviles() throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Automovil> criteria = builder.createQuery(Automovil.class);
            Root<Vehiculo> root = criteria.from(Vehiculo.class);
            criteria.select(builder.treat(root, Automovil.class));
            TypedQuery<Automovil> query = em.createQuery(criteria);
            List<Automovil> automoviles = query.getResultList();
            em.getTransaction().commit();
            return automoviles;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo generar la busqueda de automoviles: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo generar la busqueda de automoviles: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Automovil> consultarAutomoviles(Placa placa) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
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
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo generar la busqueda de automoviles: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo generar la busqueda de automoviles: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

}
