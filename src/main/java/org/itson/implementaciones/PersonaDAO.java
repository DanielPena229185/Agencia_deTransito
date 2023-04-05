/**
 * PersonaDAO.java
 * 28 mar. 2023 18:50:48
 */
package org.itson.implementaciones;
//importanciones

import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.itson.dominio.Persona;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IPersonaDAO;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class PersonaDAO implements IPersonaDAO {

    private ConexionBD conexion;

    /**
     *
     */
    public PersonaDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     *
     * @param persona
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Persona agregarPersona(Persona persona) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
            return persona;
        } catch (Exception b) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo registrar a la persona:" + b.getMessage(), b);
        } finally {
            em.close();
        }
    }

    /**
     * 6
     *
     * @param persona
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Persona actualizarPersona(Persona persona) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            Persona personaActualizado = em.find(Persona.class, persona.getIdPersona());
            personaActualizado.setNombres(persona.getNombres());
            personaActualizado.setApellido_paterno(persona.getApellido_paterno());
            personaActualizado.setApellido_materno(persona.getApellido_materno());
            personaActualizado.setRfc(persona.getRfc());
            personaActualizado.setFechaNacimiento(persona.getFechaNacimiento());
            personaActualizado.setDiscapacidad(persona.getDiscapacidad());
            personaActualizado.setTelefono(persona.getTelefono());
            em.merge(personaActualizado);
            em.getTransaction().commit();
            return personaActualizado;
        } catch (Exception b) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo actualizar el pago: " + b.getMessage(), b);
        } finally {
            em.close();
        }
    }

    @Override
    public Persona eliminarPersona(Persona persona) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Busca la lista de personas que coincidan co los parametros dados
     *
     * @param filtro columna a buscar en la consulta
     * @param busqueda el valor del filtro a buscar
     * @return lista de Personas con los valores asignados en la consulta
     * @throws PersistenciaException
     */
    @Override
    public List<Persona> consultarPersonas(String filtro, String busqueda) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
            Root<Persona> root = criteria.from(Persona.class);
            criteria.select(root).where(
                    builder.like(root.get(filtro), "%" + busqueda + "%")
            );
            TypedQuery<Persona> query = em.createQuery(criteria);

            List<Persona> personas = query.getResultList();
            em.getTransaction().commit();
            return personas;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo generar la busqueda de personas: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Persona> consultarPersonas() throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
            Root<Persona> root = criteria.from(Persona.class);
            TypedQuery<Persona> query = em.createQuery(criteria);
            List<Persona> personas = query.getResultList();
            em.getTransaction().commit();
            return personas;
        } catch (PersistenciaException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al consultar las personas en la base de datos: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    @Override
    public Persona buscarPersona(Long id) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        Persona persona = null;
        try {
            em.getTransaction().begin();
            persona = em.find(Persona.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al encontrar al usuario con id: " + id + ": " + e.getMessage(), e);
        }
        return persona;
    }
}
