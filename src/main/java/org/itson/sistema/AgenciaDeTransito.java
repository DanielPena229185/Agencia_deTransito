package org.itson.sistema;

import dominio.EstadoTramite;
import dominio.Licencia;
import dominio.Pago;
import dominio.Persona;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author
 */
public class AgenciaDeTransito {

    public static void main(String[] args) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.sistema_AgenciaDeTransito_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Calendar fechaNacimientoJuan = Calendar.getInstance();
        fechaNacimientoJuan.set(1990, 5, 15);
        Persona juan = new Persona("Juan", "Perez", "Garcia", "PEFJ900615", fechaNacimientoJuan, false, "5551234567");
       // entityManager.persist(juan);
        
        Licencia licencia = new Licencia(EstadoTramite.ACTIVO, 600F, fechaNacimientoJuan, 3, juan);
        Pago pago = new Pago(600F, fechaNacimientoJuan, "Licencia", licencia);
        licencia.agregarPago(pago);
        juan.agregarALista(licencia);
        entityManager.persist(pago);
        entityManager.persist(juan);
        entityManager.persist(licencia);
        entityManager.getTransaction().commit();
    }
}
