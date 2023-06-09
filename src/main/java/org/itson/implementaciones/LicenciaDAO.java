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
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;
import org.itson.dominio.Tramite;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.ILicenciaDAO;
import org.itson.utils.ConfiguracionDePaginado;

/**
 * Descripción de la clase: Esta clase se encarga de realizar operaciones en la
 * base de datos con respecto a la clase hija Licencia
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class LicenciaDAO implements ILicenciaDAO {

    /**
     * Conexión a la base de datos
     */
    private ConexionBD conexion;

    /**
     * Constructor de la clase LicenciaDAO
     *
     * @param conexion Conexión de la base de datos
     */
    public LicenciaDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * Método que se encarga de guardar un trámite de Licencia
     *
     * @param licencia Licencia que se quiere guardar
     * @return La licencia que se guardó
     * @throws PersistenciaException En caso de que no se pueda añadir el
     * trámite
     */
    @Override
    public Licencia agregarLicencia(Licencia licencia) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            em.persist(licencia);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Licencia guardada con exito");
            return licencia;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo registrar la licencia: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo registrar la licencia: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

    /**
     * Método que se encarga de actualizar la licencia
     *
     * @param licencia Licencia que se quiere actualizar
     * @return Licencia que se actualizó
     * @throws PersistenciaException En caso de que no se haya podido actualizar
     */
    @Override
    public Licencia actualizarLicencia(Licencia licencia) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            Licencia licenciaActualizada = em.find(Licencia.class, licencia.getIdTramite());
            if (licenciaActualizada == null) {
                JOptionPane.showMessageDialog(null, "La licencia no existe en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                throw new PersistenciaException("La licencia no existe en la base de datos");
            }
            licenciaActualizada.setEstado(licencia.getEstado());
            licenciaActualizada.setPrecio(licencia.getPrecio());
            licenciaActualizada.setFechaExpedicion(licencia.getFechaExpedicion());
            licenciaActualizada.setPersona(licencia.getPersona());
            licenciaActualizada.setFechaExpiracion(licencia.getFechaExpiracion());
            em.merge(licenciaActualizada);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Licencia actualizada con exito");
            return licenciaActualizada;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo actualizar la licencia: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo actualizar la licencia: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

    /**
     * Método que se encarga de eliminar una licencia
     *
     * @param licencia Licencia que se planea eliminar
     * @return Licencia que se eliminó
     * @throws PersistenciaException En caso de que no se pueda eliminar la
     * licencia
     */
    @Override
    public Licencia eliminarLicencia(Licencia licencia) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método que se encarga de consultar todas las licencias
     *
     * @return Lista de todas las licencias que hay en la base de datos
     * @throws PersistenciaException En caso de que no se haya podido realizar
     * la consulta
     */
    @Override
    public List<Licencia> consultarLicencias() throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Licencia> criteria = builder.createQuery(Licencia.class);
            Root<Tramite> root = criteria.from(Tramite.class);
            criteria.select(builder.treat(root, Licencia.class));
            TypedQuery<Licencia> query = em.createQuery(criteria);
            List<Licencia> licencias = query.getResultList();
            em.getTransaction().commit();
            return licencias;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo generar la busqueda de licencias: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo generar la busqueda de licencias: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

    /**
     * Método que se encarga de consultar todas las licencias dependiendo de la
     * persona
     *
     * @param persona Persona de la que se quiere buscar sus licencias
     * @return Regresa todas las licencias de la persona
     * @throws PersistenciaException En caso de que no se pueda realizar la
     * consulta
     */
    @Override
    public List<Licencia> consultarLicenciasPersona(Persona persona) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Licencia> criteria = builder.createQuery(Licencia.class);
            Root<Licencia> root = criteria.from(Licencia.class);
            Predicate predicate = builder.equal(root.get("persona").get("idPersona"), persona.getIdPersona());
            criteria.select(builder.treat(root, Licencia.class)).where(predicate);
            TypedQuery<Licencia> query = em.createQuery(criteria);
            List<Licencia> licencias = query.getResultList();
            em.getTransaction().commit();
            return licencias;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo generar la busqueda de licencias: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo generar la busqueda de licencias: " + a.getLocalizedMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Método que realiza la consulta por persona y limita para no traer todos
     * los tramites y se configura el páginado
     *
     * @param persona Persona de la que se quiere buscar sus trámites
     * @param paginado La cantidad de partes en la que va a traer los datos en
     * la consulta
     * @return Lista de licencias de la persona
     * @throws PersistenciaException En caso que no pueda realizarce la consulta
     */
    @Override
    public List<Licencia> consultarLicenciasPersonaPaginado(Persona persona, ConfiguracionDePaginado paginado) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Licencia> criteria = builder.createQuery(Licencia.class);
            Root<Licencia> root = criteria.from(Licencia.class);
            Predicate predicate = builder.equal(root.get("persona").get("idPersona"), persona.getIdPersona());
            criteria.select(builder.treat(root, Licencia.class)).where(predicate);
            TypedQuery<Licencia> query = em.createQuery(criteria);
            // calcular el número de resultados a saltar para llegar a la página deseada
            int resultadosSaltados = (paginado.getNumPagina() - 1) * paginado.getElementosPorPagina();
            query.setFirstResult(resultadosSaltados);
            query.setMaxResults(paginado.getElementosPorPagina());
            List<Licencia> licencias = query.getResultList();
            em.getTransaction().commit();
            return licencias;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo generar la busqueda de licencias: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo generar la busqueda de licencias: " + a.getLocalizedMessage());
        } finally {
            em.close();
        }
    }

}
