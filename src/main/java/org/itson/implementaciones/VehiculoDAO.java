/**
 * VehiculoDAO.java
 * 28 mar. 2023 20:20:47
 */
package org.itson.implementaciones;
//importanciones

import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.itson.dominio.Pago;
import org.itson.dominio.Placa;
import org.itson.dominio.Tramite;
import org.itson.dominio.Vehiculo;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IVehiculoDAO;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class VehiculoDAO implements IVehiculoDAO {

    private EntityManager em;

    public VehiculoDAO(ConexionBD conexion) {
        this.em = conexion.getConexion();
    }

    /**
     *
     * @param vehiculo
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Vehiculo agregarVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        try {
            this.em.getTransaction().begin();
            this.em.persist(vehiculo);
            this.em.getTransaction().commit();
            return vehiculo;
        } catch (EntityExistsException a) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Este vehiculo ya exite en la base de datos" + a.getMessage());
        } catch (Exception e) {
            this.em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo agregar el vehiculo" + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param vehiculo
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Vehiculo actualizarVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            Vehiculo vehiculoActualizado = em.find(Vehiculo.class, vehiculo.getIdVehiculo());
            if (vehiculoActualizado == null) {
                throw new PersistenciaException("El vehiculo no existe en la base de datos");
            }
            vehiculoActualizado.setNumeroSerie(vehiculo.getNumeroSerie());
            vehiculoActualizado.setMarca(vehiculo.getMarca());
            vehiculoActualizado.setColor(vehiculo.getColor());
            vehiculoActualizado.setModelo(vehiculo.getModelo());
            vehiculoActualizado.setLinea(vehiculo.getLinea());
            em.merge(vehiculoActualizado);
            em.getTransaction().commit();
            return vehiculoActualizado;
        } catch (IllegalArgumentException b) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo actualizar el vehiculo " + b.getMessage());
        } catch (PersistenciaException b) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo actualizar el vehiculo " + b.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * 
     * @param vehiculo
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Vehiculo eliminarVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * 
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public List<Vehiculo> consultarVehiculos() throws PersistenciaException {
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Vehiculo> criteria = builder.createQuery(Vehiculo.class);
            Root<Vehiculo> root = criteria.from(Vehiculo.class);
            TypedQuery<Vehiculo> query = em.createQuery(criteria);
            List<Vehiculo> vehiculos = query.getResultList();
            em.getTransaction().commit();
            return vehiculos;
        } catch (PersistenciaException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al consultar los vehiculos en la base de datos " + e.getMessage());
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
    public List<Vehiculo> consultarVehiculo(Placa placa) throws PersistenciaException {
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
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo generar la busqueda de vehiculos " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
