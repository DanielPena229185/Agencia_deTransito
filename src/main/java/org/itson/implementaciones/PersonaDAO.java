/**
* PersonaDAO.java
* 28 mar. 2023 18:50:48
*/ 

package org.itson.implementaciones;
//importanciones

import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import org.itson.dominio.Persona;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IPersonaDAO;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class PersonaDAO implements IPersonaDAO{

    private EntityManager em;
    
    /**
     * 
     */
    public PersonaDAO(Conexion conexion){
        this.em = conexion.obtenerConexion();
    }

    @Override
    public Persona agregarPersona(Persona persona) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
            return persona;
        } catch (EntityExistsException a){
            em.getTransaction().rollback();
            throw new PersistenciaException("Esta persona ya existe");
        } catch(Exception b){
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo registrar a la persona");
        }finally{
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

    @Override
    public List<Persona> consultarPersonas(String filtro, String busqueda) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Persona> consultarPersonas() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
