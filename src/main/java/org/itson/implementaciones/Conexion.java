/**
* Conexion.java
* 29 mar. 2023 11:23:57
*/ 

package org.itson.implementaciones;
//importanciones

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Conexion {
    
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
     */
    public EntityManager obtenerConexion(){
        EntityManager entityManager = factory.createEntityManager();
        return entityManager;
    }
}
