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
 * Descripción de la clase: Esta clase se encarga de realizar operaciones en la
 * base de datos con respecto a la clase hija Automovil
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class AutomovilDAO implements IAutomovilDAO {

    /**
     * Conexión a la base de datos
     */
    private ConexionBD conexion;

    /**
     * Constructor de la clase AutovilDAO
     *
     * @param conexion Conexión de la base de datos
     */
    public AutomovilDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * Método que se encarga de agregar un Automóvil
     *
     * @param automovil Automovil que se desea agregar
     * @return Un objeto de tipo Automóvil
     * @throws PersistenciaException En caso de que no se pueda realizar la
     * operación de persistit el automóvil en la base de datos
     */
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

    /**
     * Método que se encarga de actualizar en la base de datos un automóvil
     *
     * @param automovil Automóvil que quiere actualizar
     * @return El objeto del automóvil actualizado
     * @throws PersistenciaException En caso que no se pueda realizar la
     * operación de actualizar el automóvil
     */
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

    /**
     * Método que se encarga de eliminar un automóvil en la base de datos
     *
     * @param automovil Automóvil que se desea eliminar
     * @return El objeto del automóvil que se eliminó
     * @throws PersistenciaException En caso de que no se pueda eliminar el
     * automóvil
     */
    @Override
    public Automovil eliminarAutomovil(Automovil automovil) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método que consulta todos los automóviles que pertenecen en la base de
     * datos
     *
     * @return Una lista con todos los automóviles que se conseguieron en la
     * consulta
     * @throws PersistenciaException En caso de que no se pueda realizar la
     * consulta
     */
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

    /**
     * Consulta todos los automóviles por su placa
     *
     * @param placa Placa que se desea buscar en el filtro
     * @return Una lista de todos los automóvil que cuentan con los placa
     * @throws PersistenciaException En caso de que no se pueda realizar la
     * consulta
     */
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
