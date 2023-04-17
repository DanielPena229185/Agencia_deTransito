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

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class ConexionBD {

    /**
     *
     * Clase que representa una conexión a una base de datos usando JPA
     * EntityManager
     */
    private final EntityManagerFactory factory;

    /**
     *
     * Constructor que recibe la dirección de persistencia y crea una conexión a
     * la base de datos
     *
     * @param direccionPersistencia la dirección de persistencia de la base de
     * datos
     * @throws PersistenceException si ocurre un error al obtener la conexión a
     * la base de datos
     */
    public ConexionBD(String direccionPersistencia) {
        try {
            factory = Persistence.createEntityManagerFactory(direccionPersistencia);
        } catch (Exception e) {
            throw new PersistenceException("Error al obtener la conexión a la base de datos: " + e.getMessage(), e);
        }

    }

    /**
     *
     * Retorna una instancia de EntityManager para la conexión actual
     *
     * @return EntityManager una instancia de EntityManager para la conexión
     * actual
     */
    public EntityManager getConexion() {
        return factory.createEntityManager();
    }

    /**
     *
     * Cierra una conexión de EntityManager
     *
     * @param em la conexión a cerrar
     */
    public void cerrarConexion(EntityManager em) {
        em.close();
    }
}
