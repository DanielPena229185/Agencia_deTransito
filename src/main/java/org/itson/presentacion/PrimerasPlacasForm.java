/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package org.itson.presentacion;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import org.itson.dominio.CostoPlaca;
import org.itson.dominio.Costo;
import org.itson.dominio.EstadoTramite;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.dominio.Vehiculo;
import org.itson.servicio.CostoServicio;
import org.itson.utils.GeneradorPlacas;

/**
 *
 * @author Dapgp
 */
public class PrimerasPlacasForm extends javax.swing.JFrame {

    private Persona persona;
    private Vehiculo vehiculo;
    private Vehiculo vehiculoUsado;
    private CostoServicio costoDAO = new CostoServicio();
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    private Placa placaNueva;

    /**
     *
     * Constructor de la clase PrimerasPlacasForm.
     *
     * @param vehiculo el vehículo asociado con el trámite de primeras placas
     * Este método inicializa la clase PrimerasPlacasForm con un vehículo dado,
     * y llena los campos correspondientes con la información del vehículo.
     */
    public PrimerasPlacasForm(Vehiculo vehiculo) {
        initComponents();
        this.vehiculo = vehiculo;
        this.llenarCamposVehiculo();
        this.llenarCamposTramite();
    }

    /**
     *
     * Constructor de la clase PrimerasPlacasForm.
     *
     * @param persona la persona asociada con el trámite de primeras placas
     * @param vehiculo el vehículo asociado con el trámite de primeras placas
     * Este método inicializa la clase PrimerasPlacasForm con una persona y un
     * vehículo dados, y llena los campos correspondientes con la información de
     * la persona y el vehículo.
     */
    public PrimerasPlacasForm(Persona persona, Vehiculo vehiculo) {
        initComponents();
        this.persona = persona;
        this.vehiculo = vehiculo;
        this.llenarCamposPersona();
        this.llenarCamposTramite();
        this.llenarCamposVehiculo();
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
        jLabel6 = new javax.swing.JLabel();
        lblPlacas = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        lblDatosPlaca = new javax.swing.JLabel();
        lblDatosVehiculo = new javax.swing.JLabel();
        lblNumeroSerie = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lblLinea = new javax.swing.JLabel();
        txtLinea = new javax.swing.JTextField();
        lblModelo = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        formatoNumeroSerie = new javax.swing.JFormattedTextField();
        lblSimboloPesos = new javax.swing.JLabel();
        formatoPlacas = new javax.swing.JFormattedTextField();
        lblDatosCliente = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        lblRfc = new javax.swing.JLabel();
        txtRfc = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        checkDiscapacitado = new javax.swing.JCheckBox();
        formatModelo = new javax.swing.JFormattedTextField();

        setTitle("Nuevas Placas");
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        jLabel6.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Asignación de Placas:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblPlacas.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblPlacas.setForeground(new java.awt.Color(0, 0, 0));
        lblPlacas.setText("Placas:");

        lblFecha.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(0, 0, 0));
        lblFecha.setText("Fecha:");

        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        txtFecha.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(0, 0, 0));
        txtFecha.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtFecha.setEnabled(false);

        lblPrecio.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(0, 0, 0));
        lblPrecio.setText("Precio:");

        txtPrecio.setBackground(new java.awt.Color(255, 255, 255));
        txtPrecio.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(0, 0, 0));
        txtPrecio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPrecio.setEnabled(false);
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        lblDatosPlaca.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblDatosPlaca.setForeground(new java.awt.Color(0, 0, 0));
        lblDatosPlaca.setText("Datos de Placas");

        lblDatosVehiculo.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblDatosVehiculo.setForeground(new java.awt.Color(0, 0, 0));
        lblDatosVehiculo.setText("Datos del Vehículo");

        lblNumeroSerie.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblNumeroSerie.setForeground(new java.awt.Color(0, 0, 0));
        lblNumeroSerie.setText("Número de serie:");

        lblMarca.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblMarca.setForeground(new java.awt.Color(0, 0, 0));
        lblMarca.setText("Marca: ");

        txtMarca.setBackground(new java.awt.Color(255, 255, 255));
        txtMarca.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtMarca.setForeground(new java.awt.Color(0, 0, 0));
        txtMarca.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMarca.setEnabled(false);

        lblLinea.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblLinea.setForeground(new java.awt.Color(0, 0, 0));
        lblLinea.setText("Línea:");

        txtLinea.setBackground(new java.awt.Color(255, 255, 255));
        txtLinea.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtLinea.setForeground(new java.awt.Color(0, 0, 0));
        txtLinea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtLinea.setEnabled(false);

        lblModelo.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblModelo.setForeground(new java.awt.Color(0, 0, 0));
        lblModelo.setText("Modelo:");

        btnAceptar.setBackground(new java.awt.Color(255, 255, 255));
        btnAceptar.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(0, 0, 0));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        formatoNumeroSerie.setEditable(false);
        formatoNumeroSerie.setBackground(new java.awt.Color(255, 255, 255));
        formatoNumeroSerie.setForeground(new java.awt.Color(0, 0, 0));
        try {
            formatoNumeroSerie.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formatoNumeroSerie.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        formatoNumeroSerie.setEnabled(false);
        formatoNumeroSerie.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N

        lblSimboloPesos.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblSimboloPesos.setForeground(new java.awt.Color(0, 0, 0));
        lblSimboloPesos.setText("$");

        formatoPlacas.setBackground(new java.awt.Color(255, 255, 255));
        formatoPlacas.setForeground(new java.awt.Color(0, 0, 0));
        try {
            formatoPlacas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formatoPlacas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        formatoPlacas.setEnabled(false);
        formatoPlacas.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N

        lblDatosCliente.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblDatosCliente.setForeground(new java.awt.Color(0, 0, 0));
        lblDatosCliente.setText("Datos del cliente");

        lblNombre.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(0, 0, 0));
        lblNombre.setText("Nombre:");

        txtNombres.setBackground(new java.awt.Color(255, 255, 255));
        txtNombres.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtNombres.setForeground(new java.awt.Color(0, 0, 0));
        txtNombres.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNombres.setEnabled(false);

        lblRfc.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblRfc.setForeground(new java.awt.Color(0, 0, 0));
        lblRfc.setText("RFC:");

        txtRfc.setBackground(new java.awt.Color(255, 255, 255));
        txtRfc.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtRfc.setForeground(new java.awt.Color(0, 0, 0));
        txtRfc.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtRfc.setEnabled(false);

        lblTelefono.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(0, 0, 0));
        lblTelefono.setText("Teléfono:");

        txtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(0, 0, 0));
        txtTelefono.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTelefono.setEnabled(false);

        btnBuscarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarCliente.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnBuscarCliente.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscarCliente.setText("Buscar Cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        checkDiscapacitado.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        checkDiscapacitado.setText("Discapacidad");
        checkDiscapacitado.setEnabled(false);

        formatModelo.setBackground(new java.awt.Color(255, 255, 255));
        formatModelo.setForeground(new java.awt.Color(0, 0, 0));
        try {
            formatModelo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formatModelo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        formatModelo.setEnabled(false);
        formatModelo.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAceptar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addGap(110, 110, 110)
                                .addComponent(txtNombres))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNumeroSerie)
                                    .addComponent(lblModelo)
                                    .addComponent(lblLinea)
                                    .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPlacas)
                                    .addComponent(lblFecha))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtLinea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(formatoNumeroSerie, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(formatModelo, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTelefono)
                                .addGap(142, 142, 142)
                                .addComponent(txtTelefono))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblDatosCliente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lblPrecio)
                                        .addGap(48, 48, 48)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(116, 116, 116)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblSimboloPesos)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(formatoPlacas, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 3, Short.MAX_VALUE))
                                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(checkDiscapacitado))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lblDatosPlaca)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDatosVehiculo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDatosCliente)
                    .addComponent(btnBuscarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRfc)
                    .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkDiscapacitado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(lblDatosVehiculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroSerie)
                    .addComponent(formatoNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMarca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLinea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(formatModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblDatosPlaca)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlacas)
                    .addComponent(formatoPlacas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSimboloPesos)
                    .addComponent(lblPrecio))
                .addGap(18, 18, 18)
                .addComponent(btnAceptar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * Método que se llama cuando se cierra la ventana.
     *
     * @param evt el evento que se produce al cerrar la ventana Este método
     * muestra un cuadro de diálogo de confirmación para asegurarse de que el
     * usuario desea salir de la ventana. Si el usuario confirma la salida,
     * permite que la ventana se cierre y llama al método
     * regresarPantallaPrincipal(). Si el usuario cancela la salida, evita que
     * la ventana se cierre.
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            // Si el usuario confirma la salida, puedes permitir que el marco se cierre
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            regresarPantallaPrincipal();
        } else {
            // Si el usuario cancela la salida, evita que el marco se cierre
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     *
     * Método que se llama para regresar a la pantalla principal. Este método
     * crea una nueva instancia de la clase PrincipalForm y la muestra en la
     * pantalla. Luego, cierra la ventana actual (PrimerasPlacasForm).
     */
    private void regresarPantallaPrincipal() {
        PrincipalForm principal = new PrincipalForm();
        principal.setVisible(true);
        dispose();
    }

    /**
     *
     * Método que se llama para llenar los campos correspondientes al trámite de
     * primeras placas. Este método obtiene una nueva placa llamando al método
     * conseguirPlacaNueva(), y la muestra en el campo correspondiente
     * formatoPlacas. Luego, obtiene la fecha actual y la muestra en el campo
     * correspondiente txtFecha en el formato especificado por formatoFecha.
     * Finalmente, llama al método costoDeTramite() para obtener el costo del
     * trámite y lo muestra en el campo correspondiente txtPrecio.
     */
    private void llenarCamposTramite() {
        //Placas
        String placas = conseguirPlacaNueva();
        formatoPlacas.setText(placas);
        //Fecha
        Calendar hoy = Calendar.getInstance();
        txtFecha.setText(formatoFecha.format(hoy.getTime()));
        //Costo
        Double costo = costoDeTramite();
        txtPrecio.setText(String.valueOf(costo));
    }

    /**
     *
     * Método que se llama cuando el componente se oculta.
     *
     * @param evt el evento que se produce cuando el componente se oculta Este
     * método muestra un cuadro de diálogo de confirmación para asegurarse de
     * que el usuario desea salir de la ventana. Si el usuario confirma la
     * salida, cierra la ventana actual (PrimerasPlacasForm). Si el usuario
     * cancela la salida, mantiene la ventana visible.
     */
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

    /**
     *
     * Método que se llama cuando se hace clic en el botón de buscar cliente.
     *
     * @param evt el evento que se produce cuando se hace clic en el botón de
     * buscar cliente Este método crea una nueva instancia de la clase
     * BuscadorClientesForm, pasándole la ventana actual (PrimerasPlacasForm) y
     * el vehículo actual. Luego, muestra la ventana del buscador y cierra la
     * ventana actual.
     */
    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        BuscadorClientesForm buscador = new BuscadorClientesForm(this, vehiculo);
        buscador.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    /**
     *
     * Método que se llama cuando se hace clic en el botón de aceptar.
     *
     * @param evt el evento que se produce cuando se hace clic en el botón de
     * aceptar Este método valida los campos de texto de la ventana. Si los
     * campos son válidos, crea una instancia de la clase PagarDlg, pasándole
     * los datos de las nuevas placas y un concepto de "Nuevas Placas". Muestra
     * la ventana de cobro y, si el usuario confirma el pago, crea una nueva
     * instancia de la clase PrincipalForm y la muestra, cerrando la ventana
     * actual (PrimerasPlacasForm).
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (this.validarCamposTexto()) {
            PagarDlg cobrar;
            String concepto;
            //  if (this.vehiculoUsado != null) {
            concepto = "Nuevas Placas";
            placaNueva = new Placa(this.formatoPlacas.getText(),
                    null, vehiculo, EstadoTramite.ACTIVO,
                    Float.valueOf(this.txtPrecio.getText()), Calendar.getInstance(),
                    null, persona);
            cobrar = new PagarDlg(placaNueva, this, true, concepto);
            cobrar.setVisible(true);
            if (cobrar.isSalir()) {
                PrincipalForm principal = new PrincipalForm();
                principal.setVisible(true);
                dispose();
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    /**
     *
     * Método que genera una nueva placa utilizando un objeto GeneradorPlacas.
     *
     * @return la nueva placa generada como una cadena de texto
     */
    private String conseguirPlacaNueva() {
        GeneradorPlacas placas = new GeneradorPlacas();

        return placas.generarPlaca();
    }

    /**
     *
     * Método que valida si se ha seleccionado un cliente antes de continuar con
     * el trámite.
     *
     * @return true si se ha seleccionado un cliente, false de lo contrario.
     */
    private boolean validarCamposTexto() {
        if (this.persona == null) {
            JOptionPane.showConfirmDialog(this,
                    "No has seleccionado ningún cliente",
                    "Error",
                    JOptionPane.OK_OPTION,
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     *
     * Método que llena los campos de la información de la persona en el
     * formulario de trámite de placas.
     */
    private void llenarCamposPersona() {
        String nombreCompleto = persona.getNombreCompleto();
        String rfc = persona.getRfc();
        String telefono = persona.getTelefono();
        this.txtNombres.setText(nombreCompleto);
        this.txtRfc.setText(rfc);
        this.txtTelefono.setText(telefono);
        checkDiscapacitado.setSelected(persona.getDiscapacidad());
    }

    /**
     *
     * Llena los campos de la ventana con la información del vehículo.
     */
    private void llenarCamposVehiculo() {
        String numeroSerie = vehiculo.getNumeroSerie();
        String marca = vehiculo.getMarca();
        String linea = vehiculo.getLinea();
        String modelo = vehiculo.getModelo();

        this.formatoNumeroSerie.setText(numeroSerie);
        this.txtMarca.setText(marca);
        this.txtLinea.setText(linea);
        this.formatModelo.setText(modelo);
    }

    /**
     *
     * Calcula el costo de un trámite de placas.
     *
     * @return El costo del trámite.
     */
    private Double costoDeTramite() {
        List<CostoPlaca> costos = obtenerCostoTramite();

        for (Costo costo : costos) {
            return costo.getCostoNormal();
        }
        return null;
    }

    /**
     *
     * Método que devuelve el costo del trámite de la placa nueva.
     *
     * @return el costo del trámite de la placa nueva.
     */
    private List<CostoPlaca> obtenerCostoTramite() {
        return costoDAO.consultarCostoPlacaNueva();
    }

    private void validarPlacasAnteriores() {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JCheckBox checkDiscapacitado;
    private javax.swing.JFormattedTextField formatModelo;
    private javax.swing.JFormattedTextField formatoNumeroSerie;
    private javax.swing.JFormattedTextField formatoPlacas;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDatosCliente;
    private javax.swing.JLabel lblDatosPlaca;
    private javax.swing.JLabel lblDatosVehiculo;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblLinea;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumeroSerie;
    private javax.swing.JLabel lblPlacas;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblRfc;
    private javax.swing.JLabel lblSimboloPesos;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtRfc;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
