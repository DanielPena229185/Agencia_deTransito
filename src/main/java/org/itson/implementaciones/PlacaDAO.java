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
 * Descripción de la clase: Esta clase se encarga de realizar operaciones en la
 * base de datos con respecto a la clase hija Placa
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class PlacaDAO implements IPlacaDAO {

    /**
     * Conexión a la base de datos
     */
    private ConexionBD conexion;

    /**
     * Constructor de la clase PlacaDAO
     *
     * @param conexion Conexión de la base de datos
     */
    public PlacaDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     *
     * Agrega una nueva placa al sistema.
     *
     * @param placa la placa a agregar al sistema.
     * @return la placa agregada al sistema.
     * @throws PersistenciaException si ocurre un error al interactuar con el
     * sistema de persistencia.
     */
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

    /**
     * Actualiza la información de una placa existente en la base de datos.
     *
     * @param placa la placa a actualizar
     * @return la placa actualizada
     * @throws PersistenciaException si ocurre un error al acceder a la base de
     * datos
     */
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

    /**
     * Elimina una placa existente en la base de datos.
     *
     * @param placa la placa a eliminar
     * @return la placa eliminada
     * @throws PersistenciaException si ocurre un error al acceder a la base de
     * datos
     */
    @Override
    public Placa eliminarPlaca(Placa placa) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Devuelve una lista de todas las placas registradas en el sistema.
     *
     * @return una lista de todas las placas registradas en el sistema.
     * @throws PersistenciaException si ocurre algún error al interactuar con el
     * almacenamiento persistente.
     */
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

    /**
     * Devuelve una lista de todas las placas registradas en el sistema que
     * están asociadas con una persona dada.
     *
     * @param persona la persona para la cual se desea obtener las placas
     * asociadas.
     * @return una lista de todas las placas registradas en el sistema que están
     * asociadas con la persona dada.
     * @throws PersistenciaException si ocurre algún error al interactuar con el
     * almacenamiento persistente.
     */
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

    /**
     * Consulta las placas de una persona en un período de tiempo específico.
     *
     * @param desde La fecha de inicio del período de tiempo.
     * @param hasta La fecha de fin del período de tiempo.
     * @param persona La persona de la que se quieren consultar las placas.
     * @return La lista de placas de la persona consultada que se encontraron
     * dentro del período de tiempo especificado.
     * @throws PersistenciaException Si ocurre un error en la operación de
     * consulta.
     */
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

    /**
     * Obtiene la lista de placas de todos los vehículos asociados a sus
     * respectivos dueños.
     *
     * @return una lista de matrices de objetos, donde cada fila contiene la
     * información de la placa, el vehículo y la persona propietaria.
     * @throws PersistenciaException si ocurre un error al interactuar con el
     * sistema de persistencia de datos.
     */
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

    /**
     * Obtiene la lista de placas de los vehículos asociados a las personas cuyo
     * nombre, número de identificación o dirección contengan la cadena
     * especificada en el parámetro de búsqueda.
     *
     * @param busqueda la cadena de texto a buscar en los datos de las personas
     * asociadas a los vehículos.
     * @return una lista de matrices de objetos, donde cada fila contiene la
     * información de la placa, el vehículo y la persona propietaria.
     * @throws PersistenciaException si ocurre un error al interactuar con el
     * sistema de persistencia de datos.
     */
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

    /**
     *
     * Consulta una placa en la base de datos.
     *
     * @param placa La placa a consultar.
     * @return La placa consultada.
     * @throws PersistenciaException Si ocurre un error en la consulta.
     */
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

    /**
     *
     * Consulta la placa asociada a un vehículo en la base de datos.
     *
     * @param vehiculo El vehículo del cual se desea consultar la placa.
     * @return La placa asociada al vehículo consultado.
     * @throws PersistenciaException Si ocurre un error en la consulta.
     */
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

    /**
     * Consulta las placas de una persona de forma paginada.
     *
     * @param persona La persona de la que se quieren consultar las placas.
     * @param paginado La configuración de paginado que se quiere utilizar.
     * @return La lista de placas de la persona consultada, de acuerdo a la
     * configuración de paginado especificada.
     * @throws PersistenciaException Si ocurre un error en la operación de
     * consulta.
     */
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

    /**
     * Busca y retorna una lista de objetos que contienen la información de la
     * placa y la persona asociada a dicha placa, filtrando los resultados según
     * el valor de búsqueda proporcionado, y aplicando paginación a los
     * resultados.
     *
     * @param busqueda valor de búsqueda para filtrar los resultados de la
     * consulta.
     * @param paginado configuración de paginación a aplicar a los resultados de
     * la consulta.
     * @return lista de objetos que contienen la información de la placa y la
     * persona asociada a dicha placa.
     * @throws PersistenciaException si ocurre algún error durante la ejecución
     * de la consulta.
     */
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
