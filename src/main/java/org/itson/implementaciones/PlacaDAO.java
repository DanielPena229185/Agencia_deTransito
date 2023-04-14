/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.implementaciones;

import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;
import org.itson.dominio.EstadoTramite;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.dominio.Tramite;
import org.itson.dominio.Vehiculo;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IPlacaDAO;
import org.itson.utils.ConfiguracionDePaginado;

/**
 *
 * @author HP
 */
public class PlacaDAO implements IPlacaDAO {

    private ConexionBD conexion;

    public PlacaDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public Placa agregarPlaca(Placa placa) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            em.persist(placa);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Placa guardada con exito");
            return placa;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo registrar la placa: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo registrar la placa: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

    @Override
    public Placa actualizarPlaca(Placa placa) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            Placa placaActualizada = em.find(Placa.class, placa.getIdTramite());
            if (placaActualizada == null) {
                JOptionPane.showMessageDialog(null, "La placa no existe en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                throw new PersistenciaException("La placa no existe en la base de datos");
            }
            placaActualizada.setNumeroPlaca(placa.getNumeroPlaca());
            placaActualizada.setFechaRecepcion(placa.getFechaRecepcion());
            placaActualizada.setVehiculo(placa.getVehiculo());
            placaActualizada.setEstado(placa.getEstado());
            placaActualizada.setPrecio(placa.getPrecio());
            placaActualizada.setFechaExpedicion(placa.getFechaExpedicion());
            placaActualizada.setPago(placa.getPago());
            placaActualizada.setPersona(placa.getPersona());
            em.merge(placaActualizada);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Placa actualizada con exito");
            return placaActualizada;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo actualizar la placa: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo actualizar la placa: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

    @Override
    public Placa eliminarPlaca(Placa placa) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Placa> consultarPlaca() throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Placa> criteria = builder.createQuery(Placa.class);
            Root<Tramite> root = criteria.from(Tramite.class);
            criteria.select(builder.treat(root, Placa.class));
            TypedQuery<Placa> query = em.createQuery(criteria);
            List<Placa> placas = query.getResultList();
            em.getTransaction().commit();
            return placas;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo generar la busqueda de placas: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo generar la busqueda de placas: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Placa> consultarPlacasPersona(Persona persona) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Placa> criteria = builder.createQuery(Placa.class);
            Root<Placa> root = criteria.from(Placa.class);
            Predicate predicate = builder.equal(root.get("persona").get("idPersona"), persona.getIdPersona());
            criteria.select(builder.treat(root, Placa.class)).where(predicate);
            TypedQuery<Placa> query = em.createQuery(criteria);
            List<Placa> placas = query.getResultList();
            em.getTransaction().commit();
            return placas;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo generar la busqueda de placas: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo generar la busqueda de placas: " + a.getLocalizedMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public List<Placa> consultarPlacasPeriodo(Calendar desde, Calendar hasta, Persona persona) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Placa> criteria = builder.createQuery(Placa.class);
            Root<Placa> root = criteria.from(Placa.class);
            criteria.select(root).where(
                    builder.and(
                            builder.between(root.get("fechaExpedicion"), desde, hasta),
                            builder.equal(root.get("persona"), persona)
                    )
            );
            TypedQuery<Placa> query = em.createQuery(criteria);
            List<Placa> placas = query.getResultList();
            em.getTransaction().commit();
            return placas;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo generar la busqueda de placas: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo generar la busqueda de placas: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Object[]> consultarPlacasPersonas() throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
            // Root<Tramite> tramiteRoot = query.from(Tramite.class);
            Root<Placa> placaRoot = query.from(Placa.class);
            Join<Placa, Vehiculo> vehiculoJoin = placaRoot.join("vehiculo");
            Join<Placa, Persona> personaJoin = placaRoot.join("persona");

            query.multiselect(
                    placaRoot.get("idTramite"),
                    placaRoot.get("numeroPlaca"),
                    placaRoot.get("estado"),
                    vehiculoJoin.get("idVehiculo"),
                    vehiculoJoin.get("numeroSerie"),
                    placaRoot.get("fechaExpedicion"),
                    personaJoin.get("idPersona"),
                    personaJoin.get("nombres"),
                    personaJoin.get("telefono"))
                    .where(builder.equal(placaRoot.get("estado"), EstadoTramite.ACTIVO));

            List<Object[]> results = em.createQuery(query).getResultList();
            return results;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo generar la busqueda de placas: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo generar la busqueda de placas: " + a.getMessage(), a);
        } finally {
            em.close();
        }

    }

    @Override
    public List<Object[]> consultarPlacasPersonasFiltro(String busqueda) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
            // Root<Tramite> tramiteRoot = query.from(Tramite.class);
            Root<Placa> placaRoot = query.from(Placa.class);
            Join<Placa, Vehiculo> vehiculoJoin = placaRoot.join("vehiculo");
            Join<Placa, Persona> personaJoin = placaRoot.join("persona");

            query.multiselect(
                    placaRoot.get("idTramite"),
                    placaRoot.get("numeroPlaca"),
                    placaRoot.get("estado"),
                    vehiculoJoin.get("idVehiculo"),
                    vehiculoJoin.get("numeroSerie"),
                    placaRoot.get("fechaExpedicion"),
                    personaJoin.get("idPersona"),
                    personaJoin.get("nombres"),
                    personaJoin.get("telefono"))
                    .where(
                            builder.equal(placaRoot.get("estado"), EstadoTramite.ACTIVO),
                            builder.like(placaRoot.get("numeroPlaca"), "%" + busqueda + "%")
                    );

            List<Object[]> results = em.createQuery(query).getResultList();
            return results;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo generar la busqueda de placas: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo generar la busqueda de placas: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

    @Override
    public Placa consultarPlaca(Placa placa) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            placa = em.find(Placa.class, placa.getIdTramite());
            em.getTransaction().commit();
            return placa;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error al buscar la placa: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("Error al buscar la placa: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

    @Override
    public Placa consultarPlacasVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Placa> criteria = builder.createQuery(Placa.class);
            Root<Placa> root = criteria.from(Placa.class);
            criteria.select(root).where(
                    builder.equal(root.get("vehiculo"), vehiculo)
            );
            criteria.orderBy(
                    builder.desc(root.get("fechaExpedicion"))
            );
            TypedQuery<Placa> query = em.createQuery(criteria);
            query.setMaxResults(1); // Limita el resultado a solo uno
            Placa placa = query.getSingleResult();
            em.getTransaction().commit();
            return placa;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error al buscar la placa: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("Error al buscar la placa: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Placa> consultarPlacasPersonaPaginado(Persona persona, ConfiguracionDePaginado paginado) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Placa> criteria = builder.createQuery(Placa.class);
            Root<Placa> root = criteria.from(Placa.class);
            Predicate predicate = builder.equal(root.get("persona").get("idPersona"), persona.getIdPersona());
            criteria.select(builder.treat(root, Placa.class)).where(predicate);
            TypedQuery<Placa> query = em.createQuery(criteria);
            // calcular el número de resultados a saltar para llegar a la página deseada
            int resultadosSaltados = (paginado.getNumPagina() - 1) * paginado.getElementosPorPagina();
            query.setFirstResult(resultadosSaltados);
            query.setMaxResults(paginado.getElementosPorPagina());
            List<Placa> placas = query.getResultList();
            em.getTransaction().commit();
            return placas;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo generar la busqueda de placas: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo generar la busqueda de plascas: " + a.getLocalizedMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public List<Object[]> consultarPlacasPersonasFiltroPaginado(String busqueda, ConfiguracionDePaginado paginado) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
            Root<Placa> placaRoot = query.from(Placa.class);
            Join<Placa, Vehiculo> vehiculoJoin = placaRoot.join("vehiculo");
            Join<Placa, Persona> personaJoin = placaRoot.join("persona");

            query.multiselect(
                    placaRoot.get("idTramite"),
                    placaRoot.get("numeroPlaca"),
                    placaRoot.get("estado"),
                    vehiculoJoin.get("idVehiculo"),
                    vehiculoJoin.get("numeroSerie"),
                    placaRoot.get("fechaExpedicion"),
                    personaJoin.get("idPersona"),
                    personaJoin.get("nombres"),
                    personaJoin.get("telefono"))
                    .where(
                            builder.equal(placaRoot.get("estado"), EstadoTramite.ACTIVO),
                            builder.like(placaRoot.get("numeroPlaca"), "%" + busqueda + "%")
                    );

            TypedQuery<Object[]> typedQuery = em.createQuery(query);

            int startPosition = (paginado.getNumPagina() - 1) * paginado.getElementosPorPagina();
            typedQuery.setFirstResult(startPosition);
            typedQuery.setMaxResults(paginado.getElementosPorPagina());

            List<Object[]> resultados = typedQuery.getResultList();
            em.getTransaction().commit();
            return resultados;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo generar la busqueda de placas: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo generar la busqueda de placas: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

}
