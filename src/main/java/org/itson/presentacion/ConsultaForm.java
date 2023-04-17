/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.presentacion;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.servicio.LicenciaServicio;
import org.itson.servicio.PlacaServicio;
import org.itson.utils.ConfiguracionDePaginado;

/**
 *
 * @author Dapgp
 */
public class ConsultaForm extends javax.swing.JFrame {

    private Persona persona;
    private LicenciaServicio licenciaDAO;
    private PlacaServicio placaDAO;
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    private ConfiguracionDePaginado paginadoLicencia;
    private ConfiguracionDePaginado paginadoPlaca;

    /**
     * Crea un nuevo formulario ConsultaForm.
     */
    public ConsultaForm() {
        initComponents();
    }

    /**
     *
     * Crea un objeto ConsultaForm para mostrar la información de las licencias
     * y placas asociadas a una persona.
     *
     * @param persona Persona cuya información se desea consultar.
     */
    public ConsultaForm(Persona persona) {
        initComponents();
        this.licenciaDAO = new LicenciaServicio();
        this.placaDAO = new PlacaServicio();
        this.paginadoLicencia = new ConfiguracionDePaginado(1, 5);
        this.paginadoPlaca = new ConfiguracionDePaginado(1, 5);
        this.persona = persona;
        this.llenarCampos();
        this.cargarTablaLicencia();
        this.cargarTablaPlaca();
    }

    /**
     *
     * Llena los campos del formulario con los datos de la persona.
     */
    public void llenarCampos() {
        this.txtNombre.setText(persona.getNombreCompleto());
        this.txtRfc.setText(persona.getRfc());
        if (persona.getDiscapacidad()) {
            this.checkDiscapacidad.setSelected(true);
        }
    }

    /**
     *
     * Carga los datos de las licencias de conducir de la persona en la tabla
     * correspondiente.
     */
    public void cargarTablaLicencia() {
        List<Licencia> listaLicencia = licenciaDAO.consultarLicenciasPersonaPaginado(persona, paginadoLicencia);
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblLicencia.getModel();
        //Limpia tabla anterior
        modeloTabla.setRowCount(0);
        listaLicencia.forEach(licencia -> {
            Object[] fila = {
                formatoFecha.format(licencia.getFechaExpedicion().getTime()),
                licencia.getEstado(),
                licencia.getPrecio(),
                formatoFecha.format(licencia.getFechaExpiracion().getTime())
            };
            modeloTabla.addRow(fila);

        });
    }

    /**
     * Actualiza la tabla de placas con los datos obtenidos de la base de datos
     * correspondientes a la persona actual y la paginación actual.
     *
     * Este método utiliza el objeto PlacaDAO para consultar la lista de placas
     * de la persona actual, utilizando la paginación actual. Luego, limpia la
     * tabla anterior y agrega las nuevas filas con los datos obtenidos al
     * modelo de tabla de la tabla de placas.
     *
     * @return void
     */
    public void cargarTablaPlaca() {
        List<Placa> listaPlaca = placaDAO.consultarPlacasPersona(persona, paginadoPlaca);
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblPlaca.getModel();
        //Limpia tabla anterior
        modeloTabla.setRowCount(0);
        listaPlaca.forEach(placa -> {

            Object[] fila = {
                formatoFecha.format(placa.getFechaExpedicion().getTime()),
                placa.getEstado(),
                placa.getPrecio(),
                placa.getFechaRecepcion() != null
                ? formatoFecha.format(placa.getFechaRecepcion().getTime())
                : null,
                placa.getNumeroPlaca()
            };
            modeloTabla.addRow(fila);
        });
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
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLicencia = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlaca = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRfc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        checkDiscapacidad = new javax.swing.JCheckBox();
        btnRegresarLicencia = new javax.swing.JButton();
        btnAvanzarLicencia = new javax.swing.JButton();
        btnRetrocederPlaca = new javax.swing.JButton();
        btnAvanzarPlaca = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Historial");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        jLabel1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Consultar Historial");

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

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Buscar Cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblLicencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha de Expedición", "Estado", "Costo", "Fecha de Vigencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLicencia.setAutoscrolls(false);
        jScrollPane2.setViewportView(tblLicencia);
        if (tblLicencia.getColumnModel().getColumnCount() > 0) {
            tblLicencia.getColumnModel().getColumn(0).setResizable(false);
            tblLicencia.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblLicencia.getColumnModel().getColumn(1).setResizable(false);
            tblLicencia.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLicencia.getColumnModel().getColumn(2).setResizable(false);
            tblLicencia.getColumnModel().getColumn(2).setPreferredWidth(65);
            tblLicencia.getColumnModel().getColumn(3).setResizable(false);
            tblLicencia.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        tblPlaca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha Expedición", "Estado", "Costo", "Fecha de Recepción", "Número"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPlaca);

        jLabel2.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre: ");

        txtNombre.setEditable(false);
        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("RFC: ");

        txtRfc.setEditable(false);
        txtRfc.setBackground(new java.awt.Color(255, 255, 255));
        txtRfc.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtRfc.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Trámites de Licencias");

        jLabel5.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Trámites de Placas");

        checkDiscapacidad.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        checkDiscapacidad.setForeground(new java.awt.Color(0, 0, 0));
        checkDiscapacidad.setText("Discapacitado");
        checkDiscapacidad.setEnabled(false);

        btnRegresarLicencia.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnRegresarLicencia.setText("<");
        btnRegresarLicencia.setBorderPainted(false);
        btnRegresarLicencia.setContentAreaFilled(false);
        btnRegresarLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarLicenciaActionPerformed(evt);
            }
        });

        btnAvanzarLicencia.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnAvanzarLicencia.setText(">");
        btnAvanzarLicencia.setBorderPainted(false);
        btnAvanzarLicencia.setContentAreaFilled(false);
        btnAvanzarLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarLicenciaActionPerformed(evt);
            }
        });

        btnRetrocederPlaca.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnRetrocederPlaca.setText("<");
        btnRetrocederPlaca.setBorderPainted(false);
        btnRetrocederPlaca.setContentAreaFilled(false);
        btnRetrocederPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederPlacaActionPerformed(evt);
            }
        });

        btnAvanzarPlaca.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnAvanzarPlaca.setText(">");
        btnAvanzarPlaca.setBorderPainted(false);
        btnAvanzarPlaca.setContentAreaFilled(false);
        btnAvanzarPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarPlacaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jButton1)
                    .addComponent(checkDiscapacidad)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(txtRfc))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresarLicencia)
                    .addComponent(btnAvanzarPlaca)
                    .addComponent(btnRetrocederPlaca))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(886, Short.MAX_VALUE)
                    .addComponent(btnAvanzarLicencia)
                    .addGap(23, 23, 23)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkDiscapacidad))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(btnRegresarLicencia)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnAvanzarPlaca)
                        .addGap(28, 28, 28)
                        .addComponent(btnRetrocederPlaca)))
                .addGap(56, 56, 56))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(113, 113, 113)
                    .addComponent(btnAvanzarLicencia)
                    .addContainerGap(332, Short.MAX_VALUE)))
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
     * Maneja el evento de cierre de la ventana principal de la aplicación.
     * Muestra un mensaje de confirmación para preguntar al usuario si está
     * seguro de que desea salir. Si el usuario confirma, la ventana se cierra y
     * se regresa a la pantalla principal. Si el usuario cancela, la ventana no
     * se cierra.
     *
     * @param evt el evento de cierre de la ventana
     * @return void
     */

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
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
     * Este método se ejecuta cuando se hace clic en el botón "Buscar clientes".
     * Crea una nueva instancia del formulario BuscadorClientesForm y lo muestra
     * en la pantalla actual. Finalmente, cierra el formulario actual.
     *
     * @param evt el evento generado por el clic en el botón
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        BuscadorClientesForm buscarCliente = new BuscadorClientesForm(this);
        buscarCliente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Este método se ejecuta cuando se hace clic en el botón "Avanzar" para el
     * paginado de licencias. Avanza a la siguiente página del paginado y carga
     * la tabla de datos de licencias correspondiente.
     *
     * @param evt el evento generado por el clic en el botón
     */
    private void btnAvanzarLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarLicenciaActionPerformed
        // TODO add your handling code here:
        paginadoLicencia.avanzarPagina();
        this.cargarTablaLicencia();
    }//GEN-LAST:event_btnAvanzarLicenciaActionPerformed

    /**
     * Este método se ejecuta cuando se hace clic en el botón "Retroceder" para
     * el paginado de licencias. Retrocede a la página anterior del paginado y
     * carga la tabla de datos de licencias correspondiente.
     *
     * @param evt el evento generado por el clic en el botón
     */
    private void btnRegresarLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarLicenciaActionPerformed
        // TODO add your handling code here:
        paginadoLicencia.retrocederPagina();
        this.cargarTablaLicencia();
    }//GEN-LAST:event_btnRegresarLicenciaActionPerformed

    /**
     * Este método se ejecuta cuando se hace clic en el botón "Avanzar" para el
     * paginado de placas. Avanza a la siguiente página del paginado y carga la
     * tabla de datos de placas correspondiente.
     *
     * @param evt el evento generado por el clic en el botón
     */
    private void btnAvanzarPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarPlacaActionPerformed
        // TODO add your handling code here:
        paginadoPlaca.avanzarPagina();
        this.cargarTablaPlaca();
    }//GEN-LAST:event_btnAvanzarPlacaActionPerformed

    /**
     * Este método se ejecuta cuando se hace clic en el botón "Retroceder" para
     * el paginado de placas. Retrocede a la página anterior del paginado y
     * carga la tabla de datos de placas correspondiente.
     *
     * @param evt el evento generado por el clic en el botón
     */
    private void btnRetrocederPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederPlacaActionPerformed
        // TODO add your handling code here:
        paginadoPlaca.retrocederPagina();
        this.cargarTablaPlaca();
    }//GEN-LAST:event_btnRetrocederPlacaActionPerformed

    /**
     * Este método regresa a la pantalla principal de la aplicación. Crea una
     * nueva instancia del formulario PrincipalForm y lo muestra en la pantalla
     * actual. Finalmente, cierra el formulario actual.
     */
    private void regresarPantallaPrincipal() {
        PrincipalForm principal = new PrincipalForm();
        principal.setVisible(true);
        dispose();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvanzarLicencia;
    private javax.swing.JButton btnAvanzarPlaca;
    private javax.swing.JButton btnRegresarLicencia;
    private javax.swing.JButton btnRetrocederPlaca;
    private javax.swing.JCheckBox checkDiscapacidad;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblLicencia;
    private javax.swing.JTable tblPlaca;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRfc;
    // End of variables declaration//GEN-END:variables
}
