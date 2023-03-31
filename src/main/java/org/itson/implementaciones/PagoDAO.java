/**
 * PagoDAO.java
 * 29 mar. 2023 09:50:06
 */
package org.itson.implementaciones;
//importanciones

import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    public PagoDAO(ConexionBD conexion) {
        this.em = conexion.getConexion();

    }

    /**
     *
     * @param pago
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Pago agregarPago(Pago pago) throws PersistenciaException {
        try {
            this.em.getTransaction().begin();
            this.em.persist(pago);
            this.em.getTransaction().commit();
            return pago;
        } catch (EntityExistsException a) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Esta pago ya exite en la base de datos"+a.getMessage());
        } catch (Exception e) {
            this.em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo agregar el pago");
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param pago
     * @throws PersistenciaException
     */
    @Override
    public void eliminarPago(Pago pago) throws PersistenciaException {
        try {
            this.em.getTransaction().begin();
            Pago pagoEnBaseDeDatos = this.em.find(Pago.class, pago.getIdPago());
            if (pagoEnBaseDeDatos == null) {
                throw new PersistenciaException("El pago no existe en la base de datos");
            }
            this.em.remove(pagoEnBaseDeDatos);
            this.em.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            this.em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo eliminar el pago " + e.getMessage());
        } catch (Exception e) {
            this.em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo eliminar el pago " + e.getMessage());
        }
    }

    /**
     *
     * @param pago
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Pago actualizarPago(Pago pago) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            Pago pagoActualizado = em.find(Pago.class, pago.getIdPago());
            pagoActualizado.setMonto(pago.getMonto());
            pagoActualizado.setFechaHora(pago.getFechaHora());
            pagoActualizado.setConcepto(pago.getConcepto());
            pagoActualizado.setTramite(pago.getTramite());
            em.merge(pagoActualizado);
            em.getTransaction().commit();
            return pagoActualizado;
        } catch (Exception b) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo actualizar el pago");
        } finally {
            em.close();
        }
    }

    @Override
    public Pago consultarPago(Pago pago) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            Pago pagoConsulta = em.find(Pago.class, pago.getIdPago());
            em.getTransaction().commit();
            return pagoConsulta;
        } catch (Exception b) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No existe el pago en la BD");
        } finally {
            em.close();
        }
    }

    @Override
    public List<Pago> consultarPago() throws PersistenciaException {
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Pago> criteria = builder.createQuery(Pago.class);
            Root<Pago> root = criteria.from(Pago.class);
            TypedQuery<Pago> query = em.createQuery(criteria);
            List<Pago> pagos = query.getResultList();
            em.getTransaction().commit();
            return pagos;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo generar la busqueda de pagos");
        } finally {
            em.close();
        }
    }

    @Override
    public List<Pago> consultarPago(Calendar fecha) throws PersistenciaException {
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
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo generar la busqueda de pagos");
        } finally {
            em.close();
        }
    }
}
