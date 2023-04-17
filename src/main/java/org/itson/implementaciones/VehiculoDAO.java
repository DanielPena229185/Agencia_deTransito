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
 * Descripción de la clase: Esta clase se encarga de realizar operaciones en la
 * base de datos con respecto a la clase padre vehículo
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class VehiculoDAO implements IVehiculoDAO {

    /**
     * Conexión a la base de datos
     */
    private ConexionBD conexion;

    /**
     * Constructor de la clase VehiculoDAO
     *
     * @param conexion Conexión de la base de datos
     */
    public VehiculoDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * Agrega un nuevo Vehiculo a la base de datos.
     *
     * @param vehiculo El Vehiculo que se desea agregar.
     * @return El Vehiculo agregado.
     * @throws PersistenciaException En caso de que haya un error al agregar en
     * la base de datos
     */
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

    /**
     * Actualiza un Vehiculo existente en la base de datos.
     *
     * @param vehiculo El Vehiculo que se desea actualizar.
     * @return El Vehiculo actualizado.
     * @throws PersistenciaException En caso de que haya un error al actualizar
     * en la base de datos
     */
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

    /**
     * Elimina un Vehiculo existente en la base de datos.
     *
     * @param vehiculo El Vehiculo que se desea eliminar.
     * @return El Vehiculo eliminado.
     * @throws PersistenciaException En caso de que haya un error al eliminar en
     * la base de datos
     */
    @Override
    public Vehiculo eliminarVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Busca todos los Vehiculos existentes en la base de datos.
     *
     * @return Una lista con todos los Vehiculos de la base de datos.
     * @throws PersistenciaException En caso de que haya un error al consultar
     * en la base de datos
     */
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

    /**
     * Busca un Vehiculo existente en la base de datos por su Placa.
     *
     * @param placa La Placa del Vehiculo que se desea buscar.
     * @return El Vehiculo encontrado o null si no existe en la base de datos.
     * @throws PersistenciaException En caso de que haya un error al consultar
     * en la base de datos
     */
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

    /**
     * Busca un Vehiculo existente en la base de datos.
     *
     * @param vehiculo El Vehiculo que se desea buscar.
     * @return El Vehiculo encontrado o null si no existe en la base de datos.
     * @throws PersistenciaException En caso de que haya un error al consultar
     * en la base de datos
     */
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

    /**
     * Busca todos los Vehiculos de la base de datos que coinciden con el número
     * de serie dado.
     *
     * @param vehiculo El Vehiculo que contiene el número de serie a buscar.
     * @return Una lista de Vehiculos que tienen el mismo número de serie que el
     * Vehiculo dado.
     * @throws PersistenciaException En caso de que haya un error al consultar
     * en la base de datos
     */
    @Override
    public List<Vehiculo> consultarVehiculoNumeroSerie(Vehiculo vehiculo) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Vehiculo> criteria = builder.createQuery(Vehiculo.class);
            Root<Vehiculo> root = criteria.from(Vehiculo.class);
            criteria.select(root).where(
                    builder.equal(root.get("numeroSerie"), vehiculo.getNumeroSerie())
            );
            TypedQuery<Vehiculo> query = em.createQuery(criteria);
            List<Vehiculo> vehiculoEncontrado = query.getResultList();
            em.getTransaction().commit();
            return vehiculoEncontrado;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error al buscar el vehiculo: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("Error al buscar el vehiculo: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }
}
