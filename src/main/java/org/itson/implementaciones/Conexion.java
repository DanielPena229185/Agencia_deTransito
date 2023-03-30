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
public class Conexion{

    private final EntityManagerFactory factory;

    /**
     *
     * @param direccionPersistencia
     */
    public Conexion(String direccionPersistencia) {
        factory = Persistence.createEntityManagerFactory(direccionPersistencia);
    }

    /**
     * 
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
