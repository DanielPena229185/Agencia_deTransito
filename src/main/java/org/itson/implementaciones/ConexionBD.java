/**
 * Conexion.java
 * 29 mar. 2023 11:23:57
 */
package org.itson.implementaciones;
//importanciones

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.excepciones.PersistenciaException;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class ConexionBD{

    private final EntityManagerFactory factory;

    /**
     * Constructor para dar acceso a la base de datos.
     * @param direccionPersistencia Direccion a la persistencia para la conexión a la base de datos
     */
    public ConexionBD(String direccionPersistencia) {
        factory = Persistence.createEntityManagerFactory(direccionPersistencia);
    }

    /**
     * Método que regresa la conexión para el entityManager
     * @return
     * @throws PersistenciaException 
     */
    public EntityManager getConexion() throws PersistenciaException {
        try {
            return factory.createEntityManager();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener la conexión a la base de datos: " + e.getMessage());
        }
    }
}
