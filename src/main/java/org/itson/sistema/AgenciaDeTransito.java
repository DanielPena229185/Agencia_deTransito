package org.itson.sistema;

import javax.swing.JOptionPane;
import org.itson.presentacion.PrincipalForm;

/**
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author
 */
public class AgenciaDeTransito {

    public static void main(String[] args) {

        PrincipalForm principal = new PrincipalForm();
        principal.setVisible(true);
        JOptionPane.showMessageDialog(null, "Necesita Ingresar a las personas\n"
                + "Los pasos son: "
                + "Ayuda>Configuración [Insertar Clientes]", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Necesita Ingresar a los costos\n"
                + "Los pasos son: "
                + "Ayuda>Configuración [Insertar Costos]", "Aviso", JOptionPane.INFORMATION_MESSAGE);

//          VehiculoServicio servicioA = new VehiculoServicio();
//          Vehiculo vehiculo = new Vehiculo();
//          vehiculo.setNumeroSerie("ABC-123");
//          Vehiculo v1 = servicioA.consultarVehiculoNumeroSerie(vehiculo);
//          PlacaServicio servicioB = new PlacaServicio();
//          Pago pago = new Pago(Float.NaN, fechaHora, concepto, tramite);
//          Placa nuevaPlaca = new Placa("ABC-123", null, v1, EstadoTramite.ACTIVO, 900F, Calendar.getInstance(), , persona)
//          Placa placa = servicioB.consultarPlacaVehiculo(v1);
//          System.out.println(placa.getNumeroPlaca());
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
