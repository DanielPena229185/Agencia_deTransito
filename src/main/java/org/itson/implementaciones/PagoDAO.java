/**
 * PagoDAO.java
 * 29 mar. 2023 09:50:06
 */
package org.itson.implementaciones;
//importanciones

import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;
import org.itson.dominio.Pago;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IPagoDAO;

/**
 * Descripción de la clase: Esta clase se encarga de realizar operaciones en la
 * base de datos con respecto a la clase Pago
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class PagoDAO implements IPagoDAO {

    /**
     * Conexión a la base de datos
     */
    private ConexionBD conexion;

    /**
     * Constructor de la clase PagoDAO
     *
     * @param conexion Conexión de la base de datos
     */
    public PagoDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * Agrega un pago a la base de datos.
     *
     * @param pago Pago que se desea guardar en la base de datos.
     * @return Pago que se guardó en la base de datos.
     * @throws PersistenciaException Si no se puede guardar el pago en la base
     * de datos.
     */
    @Override
    public Pago agregarPago(Pago pago) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            em.persist(pago);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Pago realizado con exito");
            return pago;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo agregar el pago: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo agregar el pago: " + a.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Elimina un pago de la base de datos.
     *
     * @param pago Pago que se desea eliminar de la base de datos.
     * @throws PersistenciaException Si no se puede eliminar el pago de la base
     * de datos.
     */
    @Override
    public void eliminarPago(Pago pago) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            Pago pagoEnBaseDeDatos = em.find(Pago.class, pago.getIdPago());
            if (pagoEnBaseDeDatos == null) {
                JOptionPane.showMessageDialog(null, "El pago no existe en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                throw new PersistenciaException("El pago no existe en la base de datos");
            }
            em.remove(pagoEnBaseDeDatos);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Pago eliminado con exito");
        } catch (IllegalArgumentException a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el pago: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo eliminar el pago: " + a.getMessage());
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el pago: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo eliminar el pago: " + a.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Actualiza los datos de un pago en la base de datos.
     *
     * @param pago Pago que se desea actualizar en la base de datos.
     * @return Pago que se actualizó en la base de datos.
     * @throws PersistenciaException Si no se puede actualizar el pago en la
     * base de datos.
     */
    @Override
    public Pago actualizarPago(Pago pago) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            Pago pagoActualizado = em.find(Pago.class, pago.getIdPago());
            if (pagoActualizado == null) {
                throw new PersistenciaException("El pago no existe en la base de datos");
            }
            pagoActualizado.setMonto(pago.getMonto());
            pagoActualizado.setFechaHora(pago.getFechaHora());
            pagoActualizado.setConcepto(pago.getConcepto());
            pagoActualizado.setTramite(pago.getTramite());
            em.merge(pagoActualizado);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Pago actualizado con exito");
            return pagoActualizado;
        } catch (IllegalArgumentException a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el pago: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo actualizar el pago: " + a.getMessage());
        } catch (PersistenciaException a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el pago: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo actualizar el pago " + a.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Consulta un pago en la base de datos.
     *
     * @param pago Pago que se desea consultar en la base de datos.
     * @return Pago consultado en la base de datos.
     * @throws PersistenciaException Si no se puede consultar el pago en la base
     * de datos.
     */
    @Override
    public Pago consultarPago(Pago pago) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            Pago pagoConsulta = em.find(Pago.class, pago.getIdPago());
            em.getTransaction().commit();
            return pagoConsulta;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error al consultar el pago en la base de datos: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("Error al consultar el pago en la base de datos: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

    /**
     * Consulta todos los pagos en la base de datos.
     *
     * @return Lista de todos los pagos en la base de datos.
     * @throws PersistenciaException Si no se puede realizar la consulta en la
     * base de datos.
     */
    @Override
    public List<Pago> consultarPagos() throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Pago> criteria = builder.createQuery(Pago.class);
            Root<Pago> root = criteria.from(Pago.class);
            TypedQuery<Pago> query = em.createQuery(criteria);
            List<Pago> pagos = query.getResultList();
            em.getTransaction().commit();
            return pagos;
        } catch (PersistenciaException a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error al consultar los pagos en la base de datos: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("Error al consultar los pagos en la base de datos: " + a.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Consulta todos los pagos realizados en una fecha específica.
     *
     * @param fecha Fecha a consultar.
     * @return Lista de todos los pagos realizados en la fecha especificada.
     * @throws PersistenciaException Si no se puede realizar la consulta en la
     * base de datos.
     */
    @Override
    public List<Pago> consultarPagosFecha(Calendar fecha) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Pago> criteria = builder.createQuery(Pago.class);
            Root<Pago> root = criteria.from(Pago.class);
            criteria.equals(
                    builder.equal(root.get("fechaHora"), fecha)
            );
            TypedQuery<Pago> query = em.createQuery(criteria);
            List<Pago> pagos = query.getResultList();
            em.getTransaction().commit();
            return pagos;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error al consultar los pagos en la base de datos: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("Error al consultar los pagos en la base de datos: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

}
