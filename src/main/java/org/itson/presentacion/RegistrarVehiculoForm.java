/**
 * RegistrarAutoForm.java
 * 29 mar. 2023 15:40:59
 *
 */
package org.itson.presentacion;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.itson.dominio.Vehiculo;

/**
 * DescripciÃ³n de la clase:
 *
 * @author Daniel Armando PeÃ±a Garcia ID:229185
 */
public class RegistrarVehiculoForm extends javax.swing.JFrame {

    private Vehiculo vehiculo;
    
    /**
     * Creates new form RegistrarAutoForm
     */
    public RegistrarVehiculoForm() {
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
        lblDatosVehiculo = new javax.swing.JLabel();
        lblNumeroSerie = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lblLinea = new javax.swing.JLabel();
        txtLinea = new javax.swing.JTextField();
        lblColor = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        formatNumeroSerie = new javax.swing.JFormattedTextField();
        formatModelo = new javax.swing.JFormattedTextField();

        setTitle("Registrar Vehículo");
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 120, 250));

        jLabel1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registrar Vehículo");

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

        lblDatosVehiculo.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblDatosVehiculo.setForeground(new java.awt.Color(0, 0, 0));
        lblDatosVehiculo.setText("Datos del Vehículo");

        lblNumeroSerie.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblNumeroSerie.setForeground(new java.awt.Color(0, 0, 0));
        lblNumeroSerie.setText("Número de Serie:");

        lblModelo.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblModelo.setForeground(new java.awt.Color(0, 0, 0));
        lblModelo.setText("Modelo:");

        lblMarca.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblMarca.setForeground(new java.awt.Color(0, 0, 0));
        lblMarca.setText("Marca:");

        txtMarca.setBackground(new java.awt.Color(255, 255, 255));
        txtMarca.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtMarca.setForeground(new java.awt.Color(0, 0, 0));

        lblLinea.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblLinea.setForeground(new java.awt.Color(0, 0, 0));
        lblLinea.setText("Línea:");

        txtLinea.setBackground(new java.awt.Color(255, 255, 255));
        txtLinea.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtLinea.setForeground(new java.awt.Color(0, 0, 0));

        lblColor.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblColor.setForeground(new java.awt.Color(0, 0, 0));
        lblColor.setText("Color:");

        txtColor.setBackground(new java.awt.Color(255, 255, 255));
        txtColor.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtColor.setForeground(new java.awt.Color(0, 0, 0));

        btnRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        formatNumeroSerie.setBackground(new java.awt.Color(255, 255, 255));
        formatNumeroSerie.setForeground(new java.awt.Color(0, 0, 0));
        try {
            formatNumeroSerie.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formatNumeroSerie.setToolTipText("");
        formatNumeroSerie.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        formatNumeroSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formatNumeroSerieActionPerformed(evt);
            }
        });

        formatModelo.setBackground(new java.awt.Color(255, 255, 255));
        formatModelo.setForeground(new java.awt.Color(0, 0, 0));
        try {
            formatModelo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formatModelo.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDatosVehiculo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegistrar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNumeroSerie)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                        .addComponent(formatNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblColor)
                            .addComponent(lblLinea)
                            .addComponent(lblModelo)
                            .addComponent(lblMarca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMarca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(txtLinea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(txtColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(formatModelo, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDatosVehiculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroSerie)
                    .addComponent(formatNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLinea)
                    .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(formatModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblColor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        int cancelarTodo = JOptionPane.showConfirmDialog(this,
                "¿Seguro(a) que deseas salir?"
                + "\nSe cancelará todo el proceso",
                "¡Peligro!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (JOptionPane.YES_OPTION == cancelarTodo) {
            dispose();
        } else {
            this.setVisible(true);
        }
    }//GEN-LAST:event_formComponentHidden

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (validarCamposTexto().isEmpty()) {
            generarObjetoVehiculo();
            PrimerasPlacasForm primerasPlacas = new PrimerasPlacasForm(vehiculo);
            primerasPlacas.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void formatNumeroSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formatNumeroSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_formatNumeroSerieActionPerformed

    private List<String> validarCamposTexto() {
        List<String> camposVacios = new ArrayList<>();
        if (txtColor.getText().isEmpty()) {
            camposVacios.add("Color");
        }
        if (txtLinea.getText().isEmpty()) {
            camposVacios.add("Línea");
        }
        if (txtMarca.getText().isEmpty()) {
            camposVacios.add("Marca");
        }
        if (formatModelo.getText().isEmpty()) {
            camposVacios.add("Modelo");
        }
        if (formatNumeroSerie.getText().isEmpty() || !formatNumeroSerie.getText().matches("[A-Z]{3}-\\d{3}")) {
            camposVacios.add("Número de serie (formato AAA-123)");
        }
        if (!camposVacios.isEmpty()) {
            String mensaje = "Los siguientes campos están vacíos o no cumplen con el formato requerido:\n" + String.join(", ", camposVacios);
            JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return camposVacios;
    }
    
    private void generarObjetoVehiculo(){
        String numeroSerie = this.formatNumeroSerie.getText();
        String marca = this.txtMarca.getText();
        String linea = this.txtLinea.getText();
        String modelo = this.formatModelo.getText();
        String color = this.txtColor.getText();
        this.vehiculo = new Vehiculo(numeroSerie, marca, color, modelo, linea);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JFormattedTextField formatModelo;
    private javax.swing.JFormattedTextField formatNumeroSerie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblDatosVehiculo;
    private javax.swing.JLabel lblLinea;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNumeroSerie;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    // End of variables declaration//GEN-END:variables

}
