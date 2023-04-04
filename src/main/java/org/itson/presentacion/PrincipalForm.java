/**
 * PrincipalForm.java
 * 25 mar. 2023 14:12:20
 */
package org.itson.presentacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import org.itson.interfaces.IPersonaDAO;
import org.itson.servicio.PersonaServicio;

/**
 * DescripciÃ³n de la clase:
 *
 * @author Daniel Armando PeÃ±a Garcia ID:229185
 */
public class PrincipalForm extends javax.swing.JFrame {

    PersonaServicio es;

    /**
     * Creates new form PrincipalForm
     */
    public PrincipalForm() {
        initComponents();
        valoresIniciales();
        es = new PersonaServicio();
    }

    private String fecha() {
        LocalDate fechaActual = LocalDate.now();

        // Crear un formateador de fecha con el formato "dd/MM/yyyy"
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Formatear la fecha en una cadena utilizando el formateador
        String fechaFormateada = fechaActual.format(formateador);
        return fechaFormateada;
    }

    private void valoresIniciales() {
        this.lblFecha.setText(fecha());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        panelInicio = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblItson = new javax.swing.JLabel();
        lblAgencia = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuSistema = new javax.swing.JMenu();
        menuItemSalir = new javax.swing.JMenuItem();
        menuTramites = new javax.swing.JMenu();
        menuItemTramiteLicencia = new javax.swing.JMenuItem();
        menuTramitesPlacas = new javax.swing.JMenu();
        menuItemPlacasNueva = new javax.swing.JMenuItem();
        menuItemPlacasCambiar = new javax.swing.JMenuItem();
        menuConsulta = new javax.swing.JMenu();
        menuItemConsultaTramites = new javax.swing.JMenuItem();
        menuItemConsultaReporte = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        menuItemConfiguracion = new javax.swing.JMenuItem();
        menuItemSobreNosotros = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");

        panelInicio.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        lblItson.setFont(new java.awt.Font("Impact", 1, 24)); // NOI18N
        lblItson.setForeground(new java.awt.Color(255, 255, 255));
        lblItson.setText("ITSON");

        lblAgencia.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblAgencia.setForeground(new java.awt.Color(255, 255, 255));
        lblAgencia.setText("Agencia de Tránsito");

        lblFecha.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("dd/mm/aaaa");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblItson)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblAgencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 351, Short.MAX_VALUE)
                        .addComponent(lblFecha)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblItson)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAgencia)
                    .addComponent(lblFecha))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelInicioLayout = new javax.swing.GroupLayout(panelInicio);
        panelInicio.setLayout(panelInicioLayout);
        panelInicioLayout.setHorizontalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelInicioLayout.setVerticalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 317, Short.MAX_VALUE))
        );

        desktopPane.add(panelInicio);
        panelInicio.setBounds(0, 0, 580, 390);

        menuSistema.setMnemonic('f');
        menuSistema.setText("Sistema");

        menuItemSalir.setMnemonic('x');
        menuItemSalir.setText("Salir");
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirActionPerformed(evt);
            }
        });
        menuSistema.add(menuItemSalir);

        menuBar.add(menuSistema);

        menuTramites.setMnemonic('e');
        menuTramites.setText("Trámites");
        menuTramites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTramitesActionPerformed(evt);
            }
        });

        menuItemTramiteLicencia.setText("Licencia");
        menuItemTramiteLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTramiteLicenciaActionPerformed(evt);
            }
        });
        menuTramites.add(menuItemTramiteLicencia);

        menuTramitesPlacas.setText("Placas");

        menuItemPlacasNueva.setText("Nueva");
        menuItemPlacasNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPlacasNuevaActionPerformed(evt);
            }
        });
        menuTramitesPlacas.add(menuItemPlacasNueva);

        menuItemPlacasCambiar.setText("Cambiar");
        menuTramitesPlacas.add(menuItemPlacasCambiar);

        menuTramites.add(menuTramitesPlacas);

        menuBar.add(menuTramites);

        menuConsulta.setText("Consulta");

        menuItemConsultaTramites.setText("Tràmites");
        menuItemConsultaTramites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemConsultaTramitesActionPerformed(evt);
            }
        });
        menuConsulta.add(menuItemConsultaTramites);

        menuItemConsultaReporte.setText("Reporte pdf");
        menuConsulta.add(menuItemConsultaReporte);

        menuBar.add(menuConsulta);

        menuAyuda.setMnemonic('h');
        menuAyuda.setText("Ayuda");

        menuItemConfiguracion.setMnemonic('c');
        menuItemConfiguracion.setText("Configuración");
        menuItemConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemConfiguracionActionPerformed(evt);
            }
        });
        menuAyuda.add(menuItemConfiguracion);

        menuItemSobreNosotros.setMnemonic('a');
        menuItemSobreNosotros.setText("Sobre Nosotros");
        menuItemSobreNosotros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSobreNosotrosActionPerformed(evt);
            }
        });
        menuAyuda.add(menuItemSobreNosotros);

        menuBar.add(menuAyuda);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirActionPerformed
        int salir = JOptionPane.showConfirmDialog(this, "Â¿Segur(a) que desea salir\n"
                + "del sistema?", "Â¡PrecauciÃ³n!", JOptionPane.YES_NO_OPTION);
        if (salir == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_menuItemSalirActionPerformed

    private void menuItemSobreNosotrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSobreNosotrosActionPerformed
        NosotrosDlg nosotros = new NosotrosDlg(this, true);
        nosotros.setVisible(true);
    }//GEN-LAST:event_menuItemSobreNosotrosActionPerformed

    private void menuItemConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemConfiguracionActionPerformed

        AyudaDlg ayuda = new AyudaDlg(this, true);
        ayuda.setVisible(true);
    }//GEN-LAST:event_menuItemConfiguracionActionPerformed

    private void menuItemTramiteLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTramiteLicenciaActionPerformed
        TramitesLicencia tramiteLicencia = new TramitesLicencia();
        this.dispose();
        tramiteLicencia.setVisible(true);
    }//GEN-LAST:event_menuItemTramiteLicenciaActionPerformed

    private void menuTramitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTramitesActionPerformed

    }//GEN-LAST:event_menuTramitesActionPerformed

    private void menuItemTramitePlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTramitePlacaActionPerformed


    }//GEN-LAST:event_menuItemTramitePlacaActionPerformed

    private void menuItemConsultaTramitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemConsultaTramitesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemConsultaTramitesActionPerformed

    private void menuItemPlacasNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPlacasNuevaActionPerformed
        RegistrarAutoForm nuevoAuto = new RegistrarAutoForm();
        nuevoAuto.setVisible(true);
    }//GEN-LAST:event_menuItemPlacasNuevaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAgencia;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblItson;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuConsulta;
    private javax.swing.JMenuItem menuItemConfiguracion;
    private javax.swing.JMenuItem menuItemConsultaReporte;
    private javax.swing.JMenuItem menuItemConsultaTramites;
    private javax.swing.JMenuItem menuItemPlacasCambiar;
    private javax.swing.JMenuItem menuItemPlacasNueva;
    private javax.swing.JMenuItem menuItemSalir;
    private javax.swing.JMenuItem menuItemSobreNosotros;
    private javax.swing.JMenuItem menuItemTramiteLicencia;
    private javax.swing.JMenu menuSistema;
    private javax.swing.JMenu menuTramites;
    private javax.swing.JMenu menuTramitesPlacas;
    private javax.swing.JPanel panelInicio;
    // End of variables declaration//GEN-END:variables

}
