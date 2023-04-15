/**
 * GenerarReportePdfForm.java
 * 12 abr. 2023 21:09:06
 *
 */
package org.itson.presentacion;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.itson.dominio.Licencia;
import org.itson.dominio.Placa;
import org.itson.dominio.Reporte;
import org.itson.dominio.Tramite;
import org.itson.servicio.TramitesServicio;
import org.itson.utils.Encriptador;
import org.itson.utils.GenerarReporte;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class GenerarReportePdfForm extends javax.swing.JFrame {

    private TramitesServicio servicioA = new TramitesServicio();
    private String nombre;

    /**
     * Creates new form GenerarReportePdfForm
     */
    public GenerarReportePdfForm() {
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
        jLabel1 = new javax.swing.JLabel();
        datePickerDesde = new com.toedter.calendar.JDateChooser();
        lblDesde = new javax.swing.JLabel();
        datePickerHasta = new com.toedter.calendar.JDateChooser();
        lblHasta = new javax.swing.JLabel();
        btnG = new javax.swing.JButton();
        txtNombrePersonas = new javax.swing.JTextField();
        lblNombrePersonas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generar Reporte PDF");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 122, 255));

        jLabel1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reporte de PDF");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblDesde.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblDesde.setForeground(new java.awt.Color(0, 0, 0));
        lblDesde.setText("Desde:");

        lblHasta.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblHasta.setForeground(new java.awt.Color(0, 0, 0));
        lblHasta.setText("Hasta:");

        btnG.setBackground(new java.awt.Color(255, 255, 255));
        btnG.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnG.setForeground(new java.awt.Color(0, 0, 0));
        btnG.setText("Generar PDF");
        btnG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGActionPerformed(evt);
            }
        });

        txtNombrePersonas.setBackground(new java.awt.Color(255, 255, 255));
        txtNombrePersonas.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtNombrePersonas.setForeground(new java.awt.Color(0, 0, 0));
        txtNombrePersonas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombrePersonasKeyTyped(evt);
            }
        });

        lblNombrePersonas.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblNombrePersonas.setForeground(new java.awt.Color(0, 0, 0));
        lblNombrePersonas.setText("Nombre de las personas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(btnG))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(datePickerDesde, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(datePickerHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(lblHasta))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(lblDesde))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(txtNombrePersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(lblNombrePersonas)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDesde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datePickerDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblHasta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datePickerHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(lblNombrePersonas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombrePersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btnG)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGActionPerformed
        if (this.datePickerDesde.getDate() == null || this.datePickerHasta.getDate() == null) {
            if (this.consultarListaTramites() != null) {
                GenerarReporte.generarReporte(consultarListaTramites());
            }
// JOptionPane.showMessageDialog(this, "No puedes hacer un reporte sin especificar las fechas del periodo", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            Date fechaDesde = this.datePickerDesde.getDate();
            Date fechaHasta = this.datePickerHasta.getDate();
            if (fechaDesde.after(fechaHasta)) {
                JOptionPane.showMessageDialog(this, "La fecha de inicio no puede ser posterior a la de fin", "Error!", JOptionPane.ERROR_MESSAGE);
            } else if (fechaHasta.before(fechaDesde)) {
                JOptionPane.showMessageDialog(this, "La fecha de fin no puede ser anterior a la de inicio", "Error!", JOptionPane.ERROR_MESSAGE);
            } else {
                if (this.consultarListaTramites() != null) {
                    GenerarReporte.generarReporte(consultarListaTramites());
                }

            }
        }
    }//GEN-LAST:event_btnGActionPerformed

    private void txtNombrePersonasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePersonasKeyTyped

    }//GEN-LAST:event_txtNombrePersonasKeyTyped

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        new PrincipalForm().setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private List<Reporte> consultarListaTramites() {
        String nombre = "";

        if (txtNombrePersonas.getText().isEmpty() && this.datePickerDesde.getDate() == null || this.datePickerHasta == null) {
            JOptionPane.showMessageDialog(this, "Necesitas llenar almenos los campos del periodo (Desde y Hasta) o escribir almenos un nombre", "No se puede realizar la búsqueda", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        if (!this.txtNombrePersonas.getText().isEmpty()) {
            nombre = Encriptador.encriptar(txtNombrePersonas.getText().toUpperCase());
        }

        List<Reporte> reportes = new LinkedList<>();

        List<Tramite> tramites = servicioA.consultarTramitesPeriodo(this.datePickerDesde.getCalendar(), this.datePickerHasta.getCalendar(), nombre);
        if (tramites.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningún trámite "
                    + "con esas especificaciones",
                    "Error!", JOptionPane.ERROR_MESSAGE);
            return null;
        } else {
            for (Tramite tramite : tramites) {
                if (tramite instanceof Licencia) {
                    Licencia l = (Licencia) tramite;
                    // Realizar acciones específicas para la subclase Licencia
                    Reporte reporte = new Reporte(tramite, "Licencia");
                    reportes.add(reporte);
                } else if (tramite instanceof Placa) {
                    Placa p = (Placa) tramite;
                    // Realizar acciones específicas para la subclase Placa
                    Reporte reporte = new Reporte(tramite, "Placa");
                    reportes.add(reporte);
                }
            }
            return reportes;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnG;
    private com.toedter.calendar.JDateChooser datePickerDesde;
    private com.toedter.calendar.JDateChooser datePickerHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDesde;
    private javax.swing.JLabel lblHasta;
    private javax.swing.JLabel lblNombrePersonas;
    private javax.swing.JTextField txtNombrePersonas;
    // End of variables declaration//GEN-END:variables

}
