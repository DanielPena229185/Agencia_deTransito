/**
 * AyudaForm.java
 * 25 mar. 2023 13:34:32
 */
package org.itson.presentacion;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.itson.dominio.Costo;
import org.itson.dominio.CostoLicencia;
import org.itson.dominio.CostoPlaca;
import org.itson.dominio.Persona;
import org.itson.dominio.TipoVehiculo;
import org.itson.implementaciones.CostoDAO;
import org.itson.servicio.PersonaServicio;
import org.itson.servicio.CostoServicio;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class AyudaDlg extends javax.swing.JDialog {

    private PersonaServicio personaDAO;
    private CostoServicio costoDAO;

    /**
     *
     * @param parent
     * @param modal
     * @param personaDAO
     */
    public AyudaDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        personaDAO = new PersonaServicio();
        costoDAO = new CostoServicio();
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblConfiguracion = new javax.swing.JLabel();
        btnInsertarClientes = new javax.swing.JButton();
        btnCostosTramites = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuración");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        lblConfiguracion.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblConfiguracion.setForeground(new java.awt.Color(255, 255, 255));
        lblConfiguracion.setText("Configuración");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblConfiguracion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblConfiguracion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnInsertarClientes.setBackground(new java.awt.Color(255, 255, 255));
        btnInsertarClientes.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnInsertarClientes.setForeground(new java.awt.Color(0, 0, 0));
        btnInsertarClientes.setText("Insertar Clientes");
        btnInsertarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarClientesActionPerformed(evt);
            }
        });

        btnCostosTramites.setBackground(new java.awt.Color(255, 255, 255));
        btnCostosTramites.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnCostosTramites.setForeground(new java.awt.Color(0, 0, 0));
        btnCostosTramites.setText("Costos de Trámites");
        btnCostosTramites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCostosTramitesActionPerformed(evt);
            }
        });

        btnCerrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrar.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(0, 0, 0));
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCostosTramites)
                    .addComponent(btnCerrar)
                    .addComponent(btnInsertarClientes))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCostosTramites)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInsertarClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar)
                .addGap(113, 113, 113))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarClientesActionPerformed
        this.insertarPersonas();
    }//GEN-LAST:event_btnInsertarClientesActionPerformed

    private void btnCostosTramitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCostosTramitesActionPerformed
        // TODO add your handling code here:
        this.insertarCostos();
    }//GEN-LAST:event_btnCostosTramitesActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void insertarCostos() {
        Costo licencia1 = new CostoLicencia("1 año", 200, 600);
        Costo licencia2 = new CostoLicencia("2 años", 500, 900);
        Costo licencia3 = new CostoLicencia("3 años", 700, 1100);
        costoDAO.agregarCosto(licencia1);
        costoDAO.agregarCosto(licencia2);
        costoDAO.agregarCosto(licencia3);

        Costo placa1 = new CostoPlaca(TipoVehiculo.NUEVO, 1500);
        Costo placa2 = new CostoPlaca(TipoVehiculo.USADO, 1000);
        costoDAO.agregarCosto(placa1);
        costoDAO.agregarCosto(placa2);
        JOptionPane.showMessageDialog(null, "Registro masivo de costos exitoso");
    }

    /**
     * Método que crea 20 objetos de tipo Persona
     *
     * @return Lista de objetos de tipo Persona
     */
    private List<Persona> crearPersonas() {
        List<Persona> listaPersonas = new LinkedList<>();
        Persona persona1 = new Persona("Juan", "Pérez", "García", "PERJ820215LW8", null, false, "5551234567");
        listaPersonas.add(persona1);
        Persona persona2 = new Persona("María", "González", "López", "GOLM840912VY3", null, true, "5552345678");
        listaPersonas.add(persona2);
        Persona persona3 = new Persona("José", "Hernández", "Méndez", "HEME780324EY1", null, false, "5553456789");
        listaPersonas.add(persona3);
        Persona persona4 = new Persona("Ana", "Martínez", "Ramírez", "MARA790603GT5", null, true, "5554567890");
        listaPersonas.add(persona4);
        Persona persona5 = new Persona("Pedro", "Sánchez", "Ruiz", "SARP811212LZ9", null, false, "5555678901");
        listaPersonas.add(persona5);
        Persona persona6 = new Persona("Lucía", "Flores", "Gómez", "FLOG790510DS2", null, true, "5556789012");
        listaPersonas.add(persona6);
        Persona persona7 = new Persona("Miguel", "Castillo", "Cortés", "CASD811001MY4", null, false, "5557890123");
        listaPersonas.add(persona7);
        Persona persona8 = new Persona("Sofía", "Rivera", "Vega", "RIVS830511PA6", null, true, "5558901234");
        listaPersonas.add(persona8);
        Persona persona9 = new Persona("Carlos", "Gutiérrez", "Díaz", "GUDC800802KL7", null, false, "5559012345");
        listaPersonas.add(persona9);
        Persona persona10 = new Persona("Laura", "Álvarez", "García", "ALGL820423FH9", null, true, "5550123456");
        listaPersonas.add(persona10);
        Persona persona11 = new Persona("Fernando", "Pérez", "López", "PERF800709WU8", null, false, "5551234567");
        listaPersonas.add(persona11);
        Persona persona12 = new Persona("Paula", "Sánchez", "Méndez", "SAMM840313SG1", null, true, "5552345678");
        listaPersonas.add(persona12);
        Persona persona13 = new Persona("Gustavo", "García", "Ramírez", "GARR810708CT3", null, false, "5553456789");
        listaPersonas.add(persona13);
        Persona persona14 = new Persona("Luisa", "Flores", "Ruiz", "FLRL830928BG5", null, true, "5554567890");
        listaPersonas.add(persona14);
        Persona persona15 = new Persona("Arturo", "Castillo", "Gómez", "CASG790205XQ2", null, false, "5555678901");
        listaPersonas.add(persona15);
        Persona persona16 = new Persona("Carmen", "Rivera", "Cortés", "RIVC810402DH4", null, true, "5556789012");
        listaPersonas.add(persona16);
        Persona persona17 = new Persona("Diego", "Gutiérrez", "Vega", "GUDV800118NP0", null, false, "5557890123");
        listaPersonas.add(persona17);
        Persona persona18 = new Persona("Elena", "Álvarez", "Díaz", "ALDE810606LU6", null, true, "5558901234");
        listaPersonas.add(persona18);
        Persona persona19 = new Persona("Felipe", "Pérez", "García", "PERF820426CE7", null, false, "5559012345");
        listaPersonas.add(persona19);
        Persona persona20 = new Persona("Gabriela", "García", "González", "GARG900303", null, true, "6441942558");
        listaPersonas.add(persona20);
        return listaPersonas;
    }

    /**
     * Método que crea 20 objetos de tipo Calendar para crear 20 fechas de
     * nacimiento
     *
     * @return Lista de 20 objetos de tipo Calendar
     */
    private List<Calendar> crearFechaNacimiento() {
        List<Calendar> listaFechasNacimiento = new LinkedList<>();
        Calendar fechaNacimiento1 = new GregorianCalendar(2000, 2, 15);
        listaFechasNacimiento.add(fechaNacimiento1);
        Calendar fechaNacimiento2 = new GregorianCalendar(2002, 10, 15);
        listaFechasNacimiento.add(fechaNacimiento2);
        Calendar fechaNacimiento3 = new GregorianCalendar(2004, 4, 2);
        listaFechasNacimiento.add(fechaNacimiento3);
        Calendar fechaNacimiento4 = new GregorianCalendar(2001, 8, 7);
        listaFechasNacimiento.add(fechaNacimiento4);
        Calendar fechaNacimiento5 = new GregorianCalendar(2005, 6, 21);
        listaFechasNacimiento.add(fechaNacimiento5);
        Calendar fechaNacimiento6 = new GregorianCalendar(2003, 12, 11);
        listaFechasNacimiento.add(fechaNacimiento6);
        Calendar fechaNacimiento7 = new GregorianCalendar(2000, 1, 3);
        listaFechasNacimiento.add(fechaNacimiento7);
        Calendar fechaNacimiento8 = new GregorianCalendar(2002, 5, 29);
        listaFechasNacimiento.add(fechaNacimiento8);
        Calendar fechaNacimiento9 = new GregorianCalendar(2004, 9, 18);
        listaFechasNacimiento.add(fechaNacimiento9);
        Calendar fechaNacimiento10 = new GregorianCalendar(2001, 11, 6);
        listaFechasNacimiento.add(fechaNacimiento10);
        Calendar fechaNacimiento11 = new GregorianCalendar(2005, 7, 9);
        listaFechasNacimiento.add(fechaNacimiento11);
        Calendar fechaNacimiento12 = new GregorianCalendar(2003, 2, 28);
        listaFechasNacimiento.add(fechaNacimiento12);
        Calendar fechaNacimiento13 = new GregorianCalendar(2000, 4, 14);
        listaFechasNacimiento.add(fechaNacimiento13);
        Calendar fechaNacimiento14 = new GregorianCalendar(2002, 1, 25);
        listaFechasNacimiento.add(fechaNacimiento14);
        Calendar fechaNacimiento15 = new GregorianCalendar(2004, 11, 27);
        listaFechasNacimiento.add(fechaNacimiento15);
        Calendar fechaNacimiento16 = new GregorianCalendar(2001, 3, 31);
        listaFechasNacimiento.add(fechaNacimiento16);
        Calendar fechaNacimiento17 = new GregorianCalendar(2005, 9, 2);
        listaFechasNacimiento.add(fechaNacimiento17);
        Calendar fechaNacimiento18 = new GregorianCalendar(2003, 6, 8);
        listaFechasNacimiento.add(fechaNacimiento18);
        Calendar fechaNacimiento19 = new GregorianCalendar(2000, 12, 12);
        listaFechasNacimiento.add(fechaNacimiento19);
        Calendar fechaNacimiento20 = new GregorianCalendar(2002, 7, 4);
        listaFechasNacimiento.add(fechaNacimiento20);
        return listaFechasNacimiento;
    }

    /**
     * Método que le asigna a una lista de personas sin fecha de nacimiento una
     * fecha de nacimiento con otra lista de tipo Calendar
     *
     * @return Lista de objetos de tipo Persona con fecha de nacimiento
     */
    private List<Persona> asignarFechaNacimientoToPersona() {

        List<Persona> listaPersonas = crearPersonas();
        List<Calendar> listaFechasNacimiento = crearFechaNacimiento();

        for (int i = 0; i < listaPersonas.size(); i++) {
            Persona persona = listaPersonas.get(i);
            Calendar fechaNacimiento = listaFechasNacimiento.get(i);
            persona.setFechaNacimiento(fechaNacimiento);
        }
        return listaPersonas;
    }

    /**
     * Inserta de manera masiva 20 personas a la base de datos
     */
    private void insertarPersonas() {
        List<Persona> listaPersonas = asignarFechaNacimientoToPersona();
        for (Persona persona : listaPersonas) {
            //System.out.println(persona.getFechaNacimiento());
            //System.out.println(persona.toString());
            personaDAO.agregarPersona(persona);

        }
        JOptionPane.showMessageDialog(null, "Registro masivo exitoso");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCostosTramites;
    private javax.swing.JButton btnInsertarClientes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblConfiguracion;
    // End of variables declaration//GEN-END:variables

}
