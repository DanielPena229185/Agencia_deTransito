/**
 * TramiteLicencia.java
 * 25 mar. 2023 15:51:52
 *
 */
package org.itson.presentacion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import org.itson.dominio.CostoLicencia;
import org.itson.dominio.EstadoTramite;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;
import org.itson.servicio.CostoServicio;
import org.itson.servicio.LicenciaServicio;

/**
 * Descripción de la clase: Esta clase se encarga de mostrar el formulario para
 * tramites licencia
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class TramiteLicenciaForm extends javax.swing.JFrame {

    private Persona persona = null;
    private CostoServicio costoDAO;
    private LicenciaServicio licenciaDAO;
    private Licencia licencia;
    private Licencia licenciaAnterior;
    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

    /**
     *
     * Crea una nueva instancia de la clase TramiteLicenciaForm. Este
     * constructor inicializa los componentes de la interfaz de usuario y crea
     * instancias de los objetos CostoServicio y LicenciaServicio para su uso
     * posterior.
     */
    public TramiteLicenciaForm() {
        initComponents();
        costoDAO = new CostoServicio();
        licenciaDAO = new LicenciaServicio();
    }

    /**
     *
     * Crea una nueva instancia de la clase TramiteLicenciaForm con una persona
     * preseleccionada. Este constructor establece la persona seleccionada como
     * el titular de la licencia y luego inicializa los componentes de la
     * interfaz de usuario. También habilita el cuadro de selección de vigencia
     * y crea instancias de los objetos CostoServicio y LicenciaServicio para su
     * uso posterior. Luego muestra la ventana y llama al método
     * validarLicenciaActiva() para determinar si la persona ya tiene una
     * licencia activa.
     *
     * @param persona La persona que se seleccionó previamente para la solicitud
     * de la licencia.
     */
    public TramiteLicenciaForm(Persona persona) {
        this.persona = persona;
        initComponents();
        this.cbxVigencia.enable(true);
        costoDAO = new CostoServicio();
        licenciaDAO = new LicenciaServicio();
        this.setVisible(true);
        validarLicenciaActiva(persona);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panCuerpo = new javax.swing.JPanel();
        panEncabezado = new javax.swing.JPanel();
        lblGenerarTramiteLicencia = new javax.swing.JLabel();
        lblDatosCliente = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        lblRFC = new javax.swing.JLabel();
        txtRfc = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        lblFecha = new javax.swing.JLabel();
        txtFechaHoy = new javax.swing.JTextField();
        lbl = new javax.swing.JLabel();
        cbxVigencia = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtFechaVigencia = new javax.swing.JTextField();
        lblDatosLicencia = new javax.swing.JLabel();
        lblFechaVigencia = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        lblSimboloPeso = new javax.swing.JLabel();
        checkDiscapacitado = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Trámite de Licencia");
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
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panCuerpo.setBackground(new java.awt.Color(255, 255, 255));

        panEncabezado.setBackground(new java.awt.Color(0, 102, 255));
        panEncabezado.setPreferredSize(new java.awt.Dimension(400, 55));

        lblGenerarTramiteLicencia.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblGenerarTramiteLicencia.setForeground(new java.awt.Color(255, 255, 255));
        lblGenerarTramiteLicencia.setText("Generar Trámite de Licencia");

        javax.swing.GroupLayout panEncabezadoLayout = new javax.swing.GroupLayout(panEncabezado);
        panEncabezado.setLayout(panEncabezadoLayout);
        panEncabezadoLayout.setHorizontalGroup(
            panEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGenerarTramiteLicencia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panEncabezadoLayout.setVerticalGroup(
            panEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGenerarTramiteLicencia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblDatosCliente.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblDatosCliente.setForeground(new java.awt.Color(0, 0, 0));
        lblDatosCliente.setText("Datos del Cliente");

        lblNombres.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblNombres.setForeground(new java.awt.Color(0, 0, 0));
        lblNombres.setText("Nombre: ");

        txtNombres.setBackground(new java.awt.Color(255, 255, 255));
        txtNombres.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtNombres.setForeground(new java.awt.Color(0, 0, 0));
        txtNombres.setCaretColor(new java.awt.Color(0, 0, 0));
        txtNombres.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNombres.setEnabled(false);

        lblRFC.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblRFC.setForeground(new java.awt.Color(0, 0, 0));
        lblRFC.setText("RFC: ");

        txtRfc.setBackground(new java.awt.Color(255, 255, 255));
        txtRfc.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtRfc.setForeground(new java.awt.Color(0, 0, 0));
        txtRfc.setCaretColor(new java.awt.Color(0, 0, 0));
        txtRfc.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtRfc.setEnabled(false);
        txtRfc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRfcKeyTyped(evt);
            }
        });

        btnBuscarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarCliente.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnBuscarCliente.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscarCliente.setText("Buscar Cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        lblTelefono.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(0, 0, 0));
        lblTelefono.setText("Teléfono: ");

        txtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(0, 0, 0));
        txtTelefono.setToolTipText("10 dígitos");
        txtTelefono.setCaretColor(new java.awt.Color(0, 0, 0));
        txtTelefono.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTelefono.setEnabled(false);
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        btnAceptar.setBackground(new java.awt.Color(255, 255, 255));
        btnAceptar.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(0, 0, 0));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        lblFecha.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(0, 0, 0));
        lblFecha.setText("Fecha:");

        txtFechaHoy.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaHoy.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtFechaHoy.setForeground(new java.awt.Color(0, 0, 0));
        txtFechaHoy.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtFechaHoy.setEnabled(false);

        lbl.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lbl.setForeground(new java.awt.Color(0, 0, 0));
        lbl.setText("Vigencia:");

        cbxVigencia.setBackground(new java.awt.Color(255, 255, 255));
        cbxVigencia.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        cbxVigencia.setForeground(new java.awt.Color(0, 0, 0));
        cbxVigencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 Año", "2 Años", "3 Años" }));
        cbxVigencia.setEnabled(false);
        cbxVigencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxVigenciaMouseClicked(evt);
            }
        });
        cbxVigencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxVigenciaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Costo:");

        txtFechaVigencia.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaVigencia.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtFechaVigencia.setForeground(new java.awt.Color(0, 0, 0));
        txtFechaVigencia.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtFechaVigencia.setEnabled(false);

        lblDatosLicencia.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblDatosLicencia.setForeground(new java.awt.Color(0, 0, 0));
        lblDatosLicencia.setText("Datos de la Licencia:");

        lblFechaVigencia.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblFechaVigencia.setForeground(new java.awt.Color(0, 0, 0));
        lblFechaVigencia.setText("Fecha de Vigencia:");

        txtCosto.setBackground(new java.awt.Color(255, 255, 255));
        txtCosto.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtCosto.setForeground(new java.awt.Color(0, 0, 0));
        txtCosto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCosto.setEnabled(false);

        lblSimboloPeso.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblSimboloPeso.setForeground(new java.awt.Color(0, 0, 0));
        lblSimboloPeso.setText("$");

        checkDiscapacitado.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        checkDiscapacitado.setForeground(new java.awt.Color(0, 0, 0));
        checkDiscapacitado.setText("Discapacitado");
        checkDiscapacitado.setEnabled(false);

        javax.swing.GroupLayout panCuerpoLayout = new javax.swing.GroupLayout(panCuerpo);
        panCuerpo.setLayout(panCuerpoLayout);
        panCuerpoLayout.setHorizontalGroup(
            panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
            .addGroup(panCuerpoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panCuerpoLayout.createSequentialGroup()
                        .addGroup(panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombres)
                            .addComponent(lblDatosCliente)
                            .addComponent(lblRFC)
                            .addComponent(lblTelefono))
                        .addGroup(panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCuerpoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkDiscapacitado)
                                    .addComponent(btnBuscarCliente)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCuerpoLayout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addGroup(panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtFechaVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panCuerpoLayout.createSequentialGroup()
                                        .addComponent(lblSimboloPeso)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbxVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaHoy, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAceptar))
                                .addGap(2, 2, 2))))
                    .addGroup(panCuerpoLayout.createSequentialGroup()
                        .addGroup(panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFecha)
                            .addComponent(lblDatosLicencia)
                            .addComponent(lbl)
                            .addComponent(lblFechaVigencia)
                            .addComponent(jLabel5))
                        .addGap(238, 238, 238)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panCuerpoLayout.setVerticalGroup(
            panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCuerpoLayout.createSequentialGroup()
                .addComponent(panEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDatosCliente)
                    .addComponent(btnBuscarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombres)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRFC)
                    .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkDiscapacitado)
                .addGap(15, 15, 15)
                .addComponent(lblDatosLicencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaHoy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFecha))
                .addGap(12, 12, 12)
                .addGroup(panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaVigencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSimboloPeso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptar)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panCuerpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panCuerpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    /**
     *
     * Abre el formulario de búsqueda de clientes y cierra la ventana actual.
     * Este método crea una instancia de la clase BuscadorClientesForm y muestra
     * la ventana de búsqueda. Luego cierra la ventana actual para permitir que
     * la ventana de búsqueda tome el control.
     *
     * @param evt El evento de acción que se produce cuando se hace clic en el
     * botón de búsqueda.
     */
    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        BuscadorClientesForm buscador = new BuscadorClientesForm(this);
        buscador.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    /**
     *
     * Maneja el evento de acción cuando se hace clic en el botón de Aceptar.
     * Este método primero valida que los campos de texto necesarios no estén
     * vacíos. Si se ingresan valores válidos, crea una instancia de la clase
     * PagarDlg y muestra la ventana de pago. Luego verifica si el usuario ha
     * hecho clic en el botón de Salir y, si es así, crea una instancia de la
     * clase PrincipalForm y muestra la ventana principal.
     *
     * @param evt El evento de acción que se produce cuando se hace clic en el
     * botón de Aceptar.
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        List<String> validarCamposVacios = this.validarCamposTexto();
        if (validarCamposVacios.isEmpty()) {
            PagarDlg cobrar;
            String concepto;
            licencia = this.nuevaLicencia();
            if (licenciaAnterior != null) {
                concepto = "Renovación de Licencia";
                cobrar = new PagarDlg(this, true, licencia, licenciaAnterior, concepto);
            } else {
                concepto = "Nueva Licencia";
                cobrar = new PagarDlg(this, true, licencia, concepto);
            }
            cobrar.setVisible(true);
            if (cobrar.isSalir()) {
                PrincipalForm principal = new PrincipalForm();
                principal.setVisible(true);
                dispose();
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
     *
     * Maneja el evento de tecla presionada cuando se está escribiendo en el
     * campo de texto de Teléfono. Este método limita la cantidad de caracteres
     * que se pueden ingresar en el campo de texto a 10. Si el usuario intenta
     * ingresar más caracteres, este método consume el evento para evitar que se
     * ingresen más caracteres.
     *
     * @param evt El evento de tecla presionada que se produce cuando se está
     * escribiendo en el campo de texto de Teléfono.
     */
    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // Limitar la cantidad de caracteres a 10
        if (txtTelefono.getText().length() >= 10) {
            evt.consume(); // Evita que se agreguen más caracteres
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtRfcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRfcKeyTyped

    }//GEN-LAST:event_txtRfcKeyTyped

    /**
     *
     * Este método se llama cuando el usuario hace clic en el comboBox de
     * vigencia de la licencia y se encarga de llenar los campos del formulario
     * correspondientes al tipo de licencia seleccionado
     */
    private void cbxVigenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxVigenciaMouseClicked
        llenarCamposTramite();
    }//GEN-LAST:event_cbxVigenciaMouseClicked

    /**
     *
     * Este método se llama cuando el usuario selecciona una opción en el
     * comboBox de vigencia de la licencia y se encarga de llenar los campos del
     * formulario correspondientes al tipo de licencia seleccionado
     */
    private void cbxVigenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxVigenciaActionPerformed
        llenarCamposTramite();
    }//GEN-LAST:event_cbxVigenciaActionPerformed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden

    }//GEN-LAST:event_formComponentHidden

    /**
     *
     * Método que se ejecuta al intentar cerrar la ventana. Si hay una persona
     * seleccionada,
     *
     * muestra un diálogo de confirmación antes de cerrar la ventana y regresar
     * a la pantalla principal.
     *
     * Si no hay persona seleccionada, simplemente regresa a la pantalla
     * principal.
     *
     * @param evt el evento de ventana
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        if (this.persona != null) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                // Si el usuario confirma la salida, puedes permitir que el marco se cierre
                this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                regresarPantallaPrincipal();
            } else {
                // Si el usuario cancela la salida, evita que el marco se cierre
                this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            }
        } else {
            regresarPantallaPrincipal();
        }

    }//GEN-LAST:event_formWindowClosing

    /**
     *
     * Valida que los campos de texto obligatorios no estén vacíos.
     *
     * @return Una lista de cadenas con los nombres de los campos vacíos, o una
     * lista vacía si todos los campos están completos.
     */
    private List<String> validarCamposTexto() {
        List<String> camposVacios = new ArrayList<>();
        if (txtCosto.getText().isEmpty()) {
            camposVacios.add("Costo");
        }
        if (txtFechaHoy.getText().isEmpty()) {
            camposVacios.add("Fecha de hoy");
        }
        if (txtFechaVigencia.getText().isEmpty()) {
            camposVacios.add("Fecha de vigencia");
        }
        if (txtNombres.getText().isEmpty()) {
            camposVacios.add("Nombres");
        }
        if (txtRfc.getText().isEmpty()) {
            camposVacios.add("RFC");
        }
        if (txtTelefono.getText().isEmpty()) {
            camposVacios.add("Teléfono");
        }
        if (!camposVacios.isEmpty()) {
            String mensaje = "Los siguientes campos están vacíos:\n" + String.join(", ", camposVacios);
            JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return camposVacios;
    }

    /**
     * Llena los campos de fecha con la fecha actual y la fecha de vigencia
     * obtenida del método ObtenerFechaVigencia(). Utiliza un objeto Calendar
     * para obtener la fecha actual y la fecha de vigencia, y luego los muestra
     * en los campos de texto correspondientes
     */
    private void llenarCampoFechas() {

        Calendar hoy = Calendar.getInstance();
        Calendar fechaVigencia = ObtenerFechaVigencia();
        txtFechaHoy.setText(formatoFecha.format(hoy.getTime()));
        txtFechaVigencia.setText(formatoFecha.format(fechaVigencia.getTime()));
    }

    /**
     *
     * Llena los campos de texto correspondientes con la información del cliente
     * actual.
     */
    private void llenarCamposCliente() {
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
     * Actualiza los campos de fecha y costo en la ventana de trámite. Esto se
     * logra llamando a los métodos "llenarCampoFechas()" y
     * "llenarCamposCosto()".
     */
    private void llenarCamposTramite() {
        llenarCampoFechas();
        llenarCamposCosto();
    }

    /**
     *
     * Llena el campo de texto correspondiente al costo del trámite con el valor
     * obtenido mediante el método costoDeTramite()
     */
    private void llenarCamposCosto() {
        Double costo = costoDeTramite();
        txtCosto.setText(String.valueOf(costo));
    }

    /**
     *
     * Calcula el costo del trámite de la licencia de conducir para la persona
     * asociada a la ventana.
     *
     * Si la persona tiene una discapacidad, se utiliza el costo para
     * discapacitados; de lo contrario, se utiliza el costo normal.
     *
     * @return el costo del trámite de la licencia de conducir
     */
    private Double costoDeTramite() {
        List<CostoLicencia> costos = obtenerCostoTramite();

        for (CostoLicencia costo : costos) {
            if (persona.getDiscapacidad()) {
                return costo.getCostoDiscapacitados();
            } else {
                return costo.getCostoNormal();
            }
        }
        return null;
    }

    /**
     *
     * Obtiene el costo del trámite de la licencia según la vigencia
     * seleccionada y si la persona tiene o no discapacidad.
     *
     * @return el costo del trámite de la licencia.
     */
    private List<CostoLicencia> obtenerCostoTramite() {
        String vigencia = cbxVigencia.getSelectedItem().toString();
        return costoDAO.consultarCostoLicencias(vigencia);
    }

    /**
     *
     * Valida si la persona tiene una licencia activa y solicita confirmación
     * para cancelarla. Si no tiene una licencia activa, llena los campos del
     * cliente y del trámite.
     *
     * @param persona La persona a validar.
     */
    private void validarLicenciaActiva(Persona persona) {
        List<Licencia> licencias = licenciaDAO.consultarLicenciasPersona(persona);
        if (licencias.isEmpty()) {
            this.llenarCamposCliente();
            this.llenarCamposTramite();
        } else {
            for (Licencia licencia : licencias) {
                if (licencia.getEstado() == EstadoTramite.ACTIVO) {
                    int respuesta = JOptionPane.showConfirmDialog(null,
                            "Esta persona ya tiene una licencia\n"
                            + "¿Está seguro que desea continuar y cancelar la licencia anterior?", "Confirmación",
                            JOptionPane.YES_NO_OPTION);
                    if (respuesta == JOptionPane.YES_OPTION) {
                        this.licenciaAnterior = licencia;
                        this.llenarCamposCliente();
                        this.llenarCamposTramite();
                        break;
                    }
                }
            }
        }
    }

    /**
     *
     * Crea una nueva licencia con los datos de la persona y del trámite
     * seleccionados, estableciendo la fecha de expedición como la fecha actual
     * y el estado de la licencia como "ACTIVO".
     *
     * @return la nueva licencia creada.
     */
    private Licencia nuevaLicencia() {
        // Licencia licencia;
        EstadoTramite estado = EstadoTramite.ACTIVO;
        Calendar fechaExpedicion = Calendar.getInstance();

        Float precio = Float.valueOf(txtCosto.getText());
        Calendar fechaVigencia = ObtenerFechaVigencia();
        this.licencia = new Licencia(estado, precio, fechaExpedicion, fechaVigencia, persona);
        return licencia;
    }

//    private Calendar ObtenerFechaHoy() {
//        Calendar fecha;
//        int dia = Calendar.DAY_OF_MONTH;
//        int mes = Calendar.MONTH + 1;
//        int anio = Calendar.YEAR;
//        fecha = new GregorianCalendar(anio, mes, dia);
//        return fecha;
//    }
    /**
     *
     * Obtiene la fecha de vigencia de la licencia según la selección realizada
     * en el ComboBox de vigencia.
     *
     * @return la fecha de vigencia de la licencia como un objeto de tipo
     * Calendar.
     */
    private Calendar ObtenerFechaVigencia() {
        //  Calendar hoy = 
        Calendar vigencia = Calendar.getInstance();
        String seleccion = cbxVigencia.getSelectedItem().toString();
        int numero = Integer.parseInt(seleccion.split(" ")[0]);
        vigencia.add(Calendar.YEAR, numero);
        return vigencia;
    }

    /**
     *
     * Método para regresar a la pantalla principal del sistema. Cierra la
     * ventana actual y abre una nueva instancia de la clase PrincipalForm.
     */
    private void regresarPantallaPrincipal() {
        PrincipalForm principal = new PrincipalForm();
        principal.setVisible(true);
        dispose();
    }

    /**
     *
     * Establece la persona asociada al trámite y valida si ya tiene una
     * licencia activa. Si no tiene una licencia activa, se llenan los campos
     * del cliente y del trámite. Si ya tiene una licencia activa, se muestra un
     * mensaje de confirmación y si el usuario acepta, se guarda la licencia
     * anterior y se llenan los campos del cliente y del trámite.
     *
     * @param persona La persona asociada al trámite.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
        this.validarLicenciaActiva(persona);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JComboBox<String> cbxVigencia;
    private javax.swing.JCheckBox checkDiscapacitado;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblDatosCliente;
    private javax.swing.JLabel lblDatosLicencia;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFechaVigencia;
    private javax.swing.JLabel lblGenerarTramiteLicencia;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblRFC;
    private javax.swing.JLabel lblSimboloPeso;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JPanel panCuerpo;
    private javax.swing.JPanel panEncabezado;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtFechaHoy;
    private javax.swing.JTextField txtFechaVigencia;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtRfc;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

}
