/**
 * CostoDAO.java
 * 1 abr. 2023 17:17:58
 */
package org.itson.implementaciones;
//importanciones

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.itson.dominio.Costo;
import org.itson.dominio.CostoLicencia;
import org.itson.dominio.CostoPlaca;
import org.itson.dominio.TipoVehiculo;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.ICostoDAO;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class CostoDAO implements ICostoDAO {

    /**
     * Conexión a la base de datos
     */
    ConexionBD conexion;

    /**
     * Constructor de la clase CostoDAO
     *
     * @param conexion Conexión de la base de datos
     */
    public CostoDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * Guardar el costo a la base de datos
     *
     * @param costo el costo a guardar en la base de datos
     * @return costo ya guardado
     * @throws PersistenciaException en el caso de no poder guardarse
     */
    @Override
    public Costo agregarCosto(Costo costo) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            em.persist(costo);
            em.getTransaction().commit();
            return costo;
        } catch (Exception b) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo registrar el costo: " + b.getMessage(), b);
        }
    }

    /**
     * Eliminar el costo en la base de datos
     *
     * @param costo el costo a eliminar en la base de datos
     * @return costo ya eliminado en la base de datos
     * @throws PersistenciaException en el caso de no poder eliminarse
     */
    @Override
    public Costo eliminarCosto(Costo costo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Actualizar el costo en la base de datos
     *
     * @param costo el costo a actualizar en la base de datos
     * @return costo ya actualizado en la base de datos
     * @throws PersistenciaException en el caso de no poder actualizarse
     */
    @Override
    public Costo actualizarCosto(Costo costo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Consultar los costos en la base de datos
     *
     * @return Lista de costos en la base de datos
     * @throws PersistenciaException en el caso de no poder consultar los costos
     */
    @Override
    public List<Costo> consultarCostos() throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Costo> criteria = builder.createQuery(Costo.class);
            TypedQuery<Costo> query = em.createQuery(criteria);
            List<Costo> listaCostos = query.getResultList();
            em.getTransaction().commit();
            return listaCostos;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al conseguir los costos: " + e.getMessage(), e);
        }
    }

    /**
     * Consultar el costo con la vigencia ingresada en la base de datos
     *
     * @param vigencia la vigencia a comparar en la base de datos
     * @return Lista de costos con la vigencia comparada en la base de datos
     * @throws PersistenciaException en el caso de podero consultar los costos
     */
    @Override
    public List<Costo> consultarCostosLicencia() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Consultar los costos de placa en la base de datos
     *
     * @return Lista de costos de placa en la base de datos
     * @throws PersistenciaException en el caso de no poder consultar los costos
     * de las placas
     */
    @Override
    public List<Costo> consultarCostosPlacas() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Consultar los costos de licencia en la base de datos
     *
     * @return Lista de costos de licencia en la base de datos
     * @throws PersistenciaException en el caso de no poder consultar los costos
     * de las licencias
     */
    @Override
    public List<CostoLicencia> consultarCostoLicencias(String vigencia) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<CostoLicencia> criteria = builder.createQuery(CostoLicencia.class);
            Root<CostoLicencia> root = criteria.from(CostoLicencia.class);
            criteria.select(root).where(
                    builder.equal(root.get("vigencia"), vigencia)
            );
            TypedQuery<CostoLicencia> query = em.createQuery(criteria);
            List<CostoLicencia> listaCostos = query.getResultList();
            em.getTransaction().commit();
            return listaCostos;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al conseguir los costos: " + e.getMessage(), e);
        }
    }

    /**
     * Consulta el costo de placas nuevas en la base de datos
     *
     * @return Lista de costos de placas nuevas en la base de datos
     * @throws PersistenciaException en el caso de no poder consultar los costos
     */
    @Override
    public List<CostoPlaca> consultarCostoPlacaNuevo() throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();

            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<CostoPlaca> criteria = builder.createQuery(CostoPlaca.class);
            Root<CostoPlaca> root = criteria.from(CostoPlaca.class);
            criteria.where(builder.equal(root.get("estado"), TipoVehiculo.NUEVO));
            TypedQuery<CostoPlaca> query = em.createQuery(criteria);
            List<CostoPlaca> listaPlacas = query.getResultList();
            return listaPlacas;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al conseguir los costos: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    /**
     * Consulta el costo de placas usadas en la base de datos
     *
     * @return Lista de costos de placas usadas en la base de datos
     * @throws PersistenciaException en el caso de no poder consultar los costos
     */
    @Override
    public List<CostoPlaca> consultarCostoPlacaUsado() throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();

            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<CostoPlaca> criteria = builder.createQuery(CostoPlaca.class);
            Root<CostoPlaca> root = criteria.from(CostoPlaca.class);
            criteria.where(builder.equal(root.get("estado"), TipoVehiculo.USADO));
            TypedQuery<CostoPlaca> query = em.createQuery(criteria);
            List<CostoPlaca> listaPlacas = query.getResultList();
            return listaPlacas;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al conseguir los costos: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
}
