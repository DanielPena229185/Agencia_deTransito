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

    ConexionBD conexion;

    /**
     *
     */
    public CostoDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }

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

    @Override
    public Costo eliminarCosto(Costo costo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Costo actualizarCosto(Costo costo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Costo> consultarCostos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Costo> consultarCostosLicencia() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Costo> consultarCostosPlacas() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

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

    @Override
    public List<CostoPlaca> consultarCostoPlacaNuevo() throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<CostoPlaca> criteria = builder.createQuery(CostoPlaca.class);
            Root<CostoPlaca> root = criteria.from(CostoPlaca.class);
            criteria.select(root).where(
            builder.equal(root.get("tipo"), TipoVehiculo.NUEVO)
            );
            TypedQuery<CostoPlaca> query = em.createQuery(criteria);
            List<CostoPlaca> listaPlacas = query.getResultList();
            em.getTransaction().commit();
            return listaPlacas;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al conseguir los costos: " + e.getMessage(), e);
        }
    }

    @Override
    public List<CostoPlaca> consultarCostoPlacaUsado() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
