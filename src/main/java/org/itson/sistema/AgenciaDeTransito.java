package org.itson.sistema;

import java.util.Calendar;
import org.itson.dominio.Persona;
import org.itson.implementaciones.ConexionBD;
import org.itson.implementaciones.PersonaDAO;
import org.itson.interfaces.IPersonaDAO;
import org.itson.presentacion.PrincipalForm;
import org.itson.servicio.PersonaServicio;

/**
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author
 */
public class AgenciaDeTransito {

    public static void main(String[] args) {

        PrincipalForm principal = new PrincipalForm();
        principal.setVisible(true);

//        ConexionBD conexion = new ConexionBD("org.itson.sistema_AgenciaDeTransito_jar_1.0-SNAPSHOTPU");
//        IPersonaDAO personas = new PersonaDAO(conexion);
//        entityManager.getTransaction().begin();
//        Calendar fechaNacimientoJuan = Calendar.getInstance();
//        fechaNacimientoJuan.set(1990, 5, 15);
//        Persona juan = new Persona("Juan", "Perez", "Garcia", "PEFJ900615", fechaNacimientoJuan, false, "5551234567");
//       // entityManager.persist(juan);
//        
//        Licencia licencia = new Licencia(EstadoTramite.ACTIVO, 600F, fechaNacimientoJuan, 3, juan);
//        Pago pago = new Pago(600F, fechaNacimientoJuan, "Licencia", licencia);
//        licencia.agregarPago(pago);
//        juan.agregarALista(licencia);
//        entityManager.persist(pago);
//        entityManager.persist(juan);
//        entityManager.persist(licencia);
//        entityManager.getTransaction().commit();
    }
}
