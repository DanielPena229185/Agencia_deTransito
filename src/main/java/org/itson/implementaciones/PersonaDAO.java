/**
 * PersonaDAO.java
 * 28 mar. 2023 18:50:48
 */
package org.itson.implementaciones;
//importanciones

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;
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

    public PersonaDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public Persona agregarPersona(Persona persona) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
            return persona;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo registrar a la persona: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo registrar a la persona: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

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
            JOptionPane.showMessageDialog(null, "Persona actualizada con exito");
            return personaActualizado;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el pago: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo actualizar el pago: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

    @Override
    public Persona eliminarPersona(Persona persona) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Persona> consultarPersonasFiltro(String filtro, String busqueda) throws PersistenciaException {
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
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "No se pudo generar la busqueda de personas: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("No se pudo generar la busqueda de personas: " + a.getMessage(), a);
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
        } catch (PersistenciaException a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error al consultar las personas en la base de datos: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("Error al consultar las personas en la base de datos: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }

    @Override
    public Persona buscarPersona(Persona persona) throws PersistenciaException {
        EntityManager em = conexion.getConexion();
        try {
            em.getTransaction().begin();
            persona = em.find(Persona.class, persona.getIdPersona());
            em.getTransaction().commit();
            return persona;
        } catch (Exception a) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error al buscar a la persona: " + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenciaException("Error al buscar a la persona: " + a.getMessage(), a);
        } finally {
            em.close();
        }
    }
}
