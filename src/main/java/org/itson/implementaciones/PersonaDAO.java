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

    private EntityManager em;

    /**
     *
     */
    public PersonaDAO(ConexionBD conexion) {
        this.em = conexion.getConexion();
    }

    @Override
    public Persona agregarPersona(Persona persona) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
            return persona;
        } catch (EntityExistsException a) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Esta persona ya existe");
        } catch (Exception b) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo registrar a la persona");
        } finally {
            em.close();
        }
    }

    @Override
    public Persona actualizarPersona(Persona persona) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Persona eliminarPersona(Persona persona) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Busca la lista de personas que coincidan co los parametros dados
     * @param filtro columna a buscar en la consulta
     * @param busqueda el valor del filtro a buscar
     * @return lista de Personas con los valores asignados en la consulta
     * @throws PersistenciaException 
     */
    @Override
    public List<Persona> consultarPersonas(String filtro, String busqueda) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
            Root<Persona> root = criteria.from(Persona.class);
            criteria.select(root).where(
                    builder.and(
                            builder.equal(root.get(filtro), busqueda)
                    )
            );
            TypedQuery<Persona> query = em.createQuery(criteria);

            List<Persona> personas = query.getResultList();
            em.getTransaction().commit();
            return personas;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo generar la busqueda de personas");
        } finally {
            em.close();
        }
    }

    @Override
    public List<Persona> consultarPersonas() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
