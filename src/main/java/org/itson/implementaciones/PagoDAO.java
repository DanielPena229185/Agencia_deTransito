/**
 * PagoDAO.java
 * 29 mar. 2023 09:50:06
 */
package org.itson.implementaciones;
//importanciones

import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import org.itson.dominio.Pago;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IPagoDAO;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class PagoDAO implements IPagoDAO {

    private EntityManager em;

    /**
     *
     * @param conexion
     */
<<<<<<< HEAD
    public PagoDAO(Conexion conexion) {
        this.em = conexion.obtenerConexion();
=======
    public PagoDAO(ConexionBD conexion) {
        this.em = conexion.getConexion();
>>>>>>> 6862a16a7507114c0a3eaea9003c3531af6d5c18
    }

    @Override
    public Pago agregarPago(Pago pago) throws PersistenciaException {
        try {
            this.em.getTransaction().begin();
            this.em.persist(pago);
            this.em.getTransaction().commit();
            return pago;
        } catch (Exception e) {
            this.em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo agregar el pago");
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminarPago(Pago pago) throws PersistenciaException {
        try {
            this.em.getTransaction().begin();
            Pago pagoEnBaseDeDatos = this.em.find(Pago.class, pago.getIdPago());
            if (pagoEnBaseDeDatos != null) {
                this.em.remove(pagoEnBaseDeDatos);
            }
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo eliminar el pago");
        }
    }

    @Override
    public Pago actualizarPago(Pago pago) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pago consultarPago(Pago pago) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Pago> consultarPago() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Pago> consultarPago(Calendar fecha) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
