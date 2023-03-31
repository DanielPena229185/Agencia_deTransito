/**
 * VehiculoDAO.java
 * 28 mar. 2023 20:20:47
 */
package org.itson.implementaciones;
//importanciones

import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
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

    @Override
    public Vehiculo agregarVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        try {
            this.em.getTransaction().begin();
            this.em.persist(vehiculo);
            this.em.getTransaction().commit();
            return vehiculo;
        } catch (Exception e) {
            this.em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo agregar el vehiculo");
        } finally {
            em.close();
        }
    }

    @Override
    public Vehiculo actualizarVehiculo(Vehiculo vehiculo) throws PersistenciaException {
//        try {
//            em.getTransaction().begin();
//            Tramite tramiteActualizado = em.find(Vehiculo.class, vehiculo.getIdTramite());
//            vehiculoActualizado.actualizarTramite(tramite);
//            em.merge(tramite);
//            em.getTransaction().commit();
//            return tramiteActualizado;
//        } catch (Exception b) {
//            em.getTransaction().rollback();
//            throw new PersistenciaException("No se pudo actualizar el tramite");
//        } finally {
//            em.close();
//        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vehiculo eliminarVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Vehiculo> consultarVehiculos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Vehiculo> consultarVehiculo(Placa placa) throws PersistenciaException {
        List<Vehiculo> vehiculos = new LinkedList<>();
        String numeroPlaca = placa.getNumero();
        return vehiculos;
    }
}
