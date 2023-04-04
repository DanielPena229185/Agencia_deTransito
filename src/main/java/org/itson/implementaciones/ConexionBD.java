/**
 * Conexion.java
 * 29 mar. 2023 11:23:57
 */
package org.itson.implementaciones;
//importanciones

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;
import org.itson.excepciones.PersistenciaException;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class ConexionBD {

    private final EntityManagerFactory factory;

    /**
     *
     * @param direccionPersistencia
     */
    public ConexionBD(String direccionPersistencia) {
        try {
            factory = Persistence.createEntityManagerFactory(direccionPersistencia);
        } catch (PersistenceException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la conexión a la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenceException("Error al obtener la conexión a la base de datos: " + e.getMessage());
        }

    }

    /**
     *
     * @return @throws PersistenceException
     */
    public EntityManager getConexion() {
        return factory.createEntityManager();
    }

    /**
     *
     * @param em
     */
    public void cerrarConexion(EntityManager em) {
        em.close();
    }
}
