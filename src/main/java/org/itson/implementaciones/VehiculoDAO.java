/**
 * VehiculoDAO.java
 * 28 mar. 2023 20:20:47
 */
package org.itson.implementaciones;
//importanciones

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;
import org.itson.dominio.Placa;
import org.itson.dominio.Vehiculo;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IVehiculoDAO;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class VehiculoDAO implements IVehiculoDAO {

    private ConexionBD conexion;

    public VehiculoDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public Vehiculo agregarVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            em.persist(vehiculo);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Vehiculo guardado con exito");
            return vehiculo;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo agregar el vehiculo: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo agregar el vehiculo: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

    @Override
    public Vehiculo actualizarVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            Vehiculo vehiculoActualizado = em.find(Vehiculo.class, vehiculo.getIdVehiculo());
            if (vehiculoActualizado == null) {
                JOptionPane.showMessageDialog(null, "El vehiculo no existe en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                throw new PersistenciaException("El vehiculo no existe en la base de datos");
            }
            vehiculoActualizado.setNumeroSerie(vehiculo.getNumeroSerie());
            vehiculoActualizado.setMarca(vehiculo.getMarca());
            vehiculoActualizado.setColor(vehiculo.getColor());
            vehiculoActualizado.setModelo(vehiculo.getModelo());
            vehiculoActualizado.setLinea(vehiculo.getLinea());
            em.merge(vehiculoActualizado);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Vehiculo actualizado con exito");
            return vehiculoActualizado;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo actualizar a el vehiculo: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo actualizar el vehiculo: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

    @Override
    public Vehiculo eliminarVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Vehiculo> consultarVehiculos() throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Vehiculo> criteria = builder.createQuery(Vehiculo.class);
            TypedQuery<Vehiculo> query = em.createQuery(criteria);
            List<Vehiculo> vehiculos = query.getResultList();
            em.getTransaction().commit();
            return vehiculos;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error al consultar los vehiculos en la base de datos: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("Error al consultar los vehiculos en la base de datos: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Vehiculo> consultarVehiculo(Placa placa) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Vehiculo> criteria = builder.createQuery(Vehiculo.class);
            Root<Vehiculo> root = criteria.from(Vehiculo.class);
            criteria.where(
                    builder.equal(root.get("placas").get("id_tramite"), placa.getIdTramite())
            );
            TypedQuery<Vehiculo> query = em.createQuery(criteria);
            List<Vehiculo> vehiculos = query.getResultList();
            em.getTransaction().commit();
            return vehiculos;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo generar la busqueda de vehiculos: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo generar la busqueda de vehiculos: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

    @Override
    public Vehiculo consultarVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            vehiculo = em.find(Vehiculo.class, vehiculo.getIdVehiculo());
            em.getTransaction().commit();
            return vehiculo;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error al buscar el vehiculo: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("Error al buscar el vehiculo: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }
}
