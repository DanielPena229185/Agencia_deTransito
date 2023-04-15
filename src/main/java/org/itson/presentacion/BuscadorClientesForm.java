/**
 * BuscadorForm.java
 * 27 mar. 2023 10:30:15
 *
 */
package org.itson.presentacion;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import org.itson.dominio.EstadoTramite;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.dominio.Vehiculo;
import org.itson.excepciones.EncriptarException;
import org.itson.servicio.LicenciaServicio;
import org.itson.servicio.PersonaServicio;
import org.itson.utils.ConfiguracionDePaginado;
import org.itson.utils.Encriptador;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class BuscadorClientesForm extends javax.swing.JFrame {
    
    private PersonaServicio personaDAO;
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    private Persona persona;
    private Vehiculo vehiculo;
    private TramiteLicenciaForm tramiteLicencia;
    private PrimerasPlacasForm tramitePrimerasPlacas;
    private ActualizarPlacasForm actualizarPlacas;
    private ConsultaForm consultarForm;
    private Placa placaAntigua;
    private LicenciaServicio licenciaDAO = new LicenciaServicio();
    private ConfiguracionDePaginado paginadoCliente = new ConfiguracionDePaginado(1, 10);

    /**
     * Creates new form BuscadorForm
     */
    public BuscadorClientesForm() {
        personaDAO = new PersonaServicio();
        initComponents();
        this.validarPersonas();
        this.tblPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.BuscarPersona();
    }

    /**
     *
     * @param tramiteLicencia
     */
    public BuscadorClientesForm(TramiteLicenciaForm tramiteLicencia) {
        personaDAO = new PersonaServicio();
        initComponents();
        this.validarPersonas();
        this.tblPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.BuscarPersona();
        this.tramiteLicencia = tramiteLicencia;
    }
    
    public BuscadorClientesForm(ConsultaForm consultarForm) {
        personaDAO = new PersonaServicio();
        initComponents();
        this.validarPersonas();
        this.tblPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.BuscarPersona();
        this.consultarForm = consultarForm;
    }
    
    public BuscadorClientesForm(PrimerasPlacasForm tramitePrimerasPlacas, Vehiculo vehiculo) {
        personaDAO = new PersonaServicio();
        initComponents();
        this.validarPersonas();
        this.tblPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.BuscarPersona();
        this.vehiculo = vehiculo;
        this.tramitePrimerasPlacas = tramitePrimerasPlacas;
    }
    
    public BuscadorClientesForm(ActualizarPlacasForm actualizarPlacas, Vehiculo vehiculo, Placa placaAntigua) {
        personaDAO = new PersonaServicio();
        initComponents();
        this.validarPersonas();
        this.tblPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.actualizarPlacas = actualizarPlacas;
        this.vehiculo = vehiculo;
        this.placaAntigua = placaAntigua;
        this.BuscarPersona();
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
        jLabel2 = new javax.swing.JLabel();
        lblBuscarPor = new javax.swing.JLabel();
        cbxFiltro = new javax.swing.JComboBox<>();
        btnAceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonas = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        btnAvanzarPersona = new javax.swing.JButton();
        btnRetrocederPersona = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setTitle("Buscador de Cliente");
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        jLabel2.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Encuentra tu Cliente: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lblBuscarPor.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblBuscarPor.setForeground(new java.awt.Color(0, 0, 0));
        lblBuscarPor.setText("Buscar Por: ");

        cbxFiltro.setBackground(new java.awt.Color(255, 255, 255));
        cbxFiltro.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        cbxFiltro.setForeground(new java.awt.Color(0, 0, 0));
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "RFC", "Año de Nacimiento" }));
        cbxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFiltroActionPerformed(evt);
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

        tblPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombres", "Apellidos", "RFC", "Fecha de Nacimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
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
        tblPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPersonasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPersonasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblPersonas);
        if (tblPersonas.getColumnModel().getColumnCount() > 0) {
            tblPersonas.getColumnModel().getColumn(0).setResizable(false);
            tblPersonas.getColumnModel().getColumn(1).setResizable(false);
            tblPersonas.getColumnModel().getColumn(2).setResizable(false);
            tblPersonas.getColumnModel().getColumn(3).setResizable(false);
            tblPersonas.getColumnModel().getColumn(4).setResizable(false);
        }

        txtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscar.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        btnAvanzarPersona.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnAvanzarPersona.setText(">");
        btnAvanzarPersona.setBorderPainted(false);
        btnAvanzarPersona.setContentAreaFilled(false);
        btnAvanzarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarPersonaActionPerformed(evt);
            }
        });

        btnRetrocederPersona.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnRetrocederPersona.setText("<");
        btnRetrocederPersona.setBorderPainted(false);
        btnRetrocederPersona.setContentAreaFilled(false);
        btnRetrocederPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederPersonaActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblBuscarPor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar)
                    .addComponent(txtBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptar)
                    .addComponent(btnRetrocederPersona)
                    .addComponent(btnAvanzarPersona))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBuscarPor)
                            .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addGap(187, 187, 187))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnAvanzarPersona)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRetrocederPersona)
                                .addGap(33, 33, 33)
                                .addComponent(btnAceptar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void BuscarPersona() {
        String filtro = null;
        String buscar = "";
        if (this.cbxFiltro.getSelectedItem().toString() == "Nombre") {
            filtro = "nombres";
            try {
                if (!txtBuscar.getText().isEmpty()) {
                    buscar = Encriptador.encriptar(this.txtBuscar.getText().toUpperCase());
                }
            } catch (Exception e) {
                throw new EncriptarException("Error al encriptar en búsqueda: " + e.getMessage(), e);
            }
        } else if (this.cbxFiltro.getSelectedItem().toString() == "RFC") {
            filtro = "rfc";
            buscar = this.txtBuscar.getText();
        } else if (this.cbxFiltro.getSelectedItem().toString() == "Año de Nacimiento") {
            filtro = "fechaNacimiento";
            buscar = this.txtBuscar.getText();
        }
        //Generar tabla
        List<Persona> listaPersona = personaDAO.consultarPersonasFiltroPaginado(filtro, buscar, paginadoCliente);
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblPersonas.getModel();
        //Limpia tabla anterior
        modeloTabla.setRowCount(0);
        listaPersona.forEach(persona -> {
            Object[] fila = {
                persona.getIdPersona(),
                persona.getNombres(),
                persona.getApellido_paterno() + " " + persona.getApellido_materno(),
                persona.getRfc(),
                formatoFecha.format(persona.getFechaNacimiento().getTime())
            };
            modeloTabla.addRow(fila);
        });
    }

    private void cbxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFiltroActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        if(txtBuscar.getText().isEmpty()){
            this.BuscarPersona();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void tblPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPersonasMouseClicked
        int seleccionar = tblPersonas.rowAtPoint(evt.getPoint());
        String idString = String.valueOf(tblPersonas.getValueAt(seleccionar, 0));
        Long idLong = Long.valueOf(idString);
        Persona personaSeleccionada = new Persona();
        personaSeleccionada.setIdPersona(idLong);
        this.persona = personaDAO.consultarPersona(personaSeleccionada);
    }//GEN-LAST:event_tblPersonasMouseClicked

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (this.validarEscogioPersona()) {
            if (this.validarMayorDeEdad()) {
                this.tramitaLicenciaForm();
                this.tramitePrimerasPlacasForm();
                this.actualizarPlacasForm();
                this.consultaForm();
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void tblPersonasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPersonasMousePressed
        int seleccionar = tblPersonas.rowAtPoint(evt.getPoint());
        String idString = String.valueOf(tblPersonas.getValueAt(seleccionar, 0));
        Long idLong = Long.valueOf(idString);
        Persona personaSeleccionada = new Persona();
        personaSeleccionada.setIdPersona(idLong);
        this.persona = personaDAO.consultarPersona(personaSeleccionada);
    }//GEN-LAST:event_tblPersonasMousePressed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        int opcion;
        opcion = JOptionPane.showConfirmDialog(this,
                "¿Desea Cancelar la búsqueda?", "¡Cuidado!",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            if (this.tramiteLicencia != null) {
                new TramiteLicenciaForm().setVisible(true);
            } else if (this.tramitePrimerasPlacas != null) {
                new PrimerasPlacasForm(this.vehiculo).setVisible(true);
            } else if (this.actualizarPlacas != null) {
                new ActualizarPlacasForm(this.vehiculo).setVisible(true);
            } else if (this.consultarForm != null) {
                new ConsultaForm().setVisible(true);
            } else {
                new PrincipalForm().setVisible(true);
            }
        } else {
            this.setVisible(true);
        }
    }//GEN-LAST:event_formComponentHidden

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnAvanzarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarPersonaActionPerformed
        // TODO add your handling code here:
        paginadoCliente.avanzarPagina();
        this.BuscarPersona();
    }//GEN-LAST:event_btnAvanzarPersonaActionPerformed

    private void btnRetrocederPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederPersonaActionPerformed
        // TODO add your handling code here:
        paginadoCliente.retrocederPagina();
        this.BuscarPersona();
    }//GEN-LAST:event_btnRetrocederPersonaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.BuscarPersona();
    }//GEN-LAST:event_btnBuscarActionPerformed
    
    private boolean validarCredencialActiva() {
        List<Licencia> licencias = licenciaDAO.consultarLicenciasPersona(this.persona);
        for (Licencia licencia : licencias) {
            if (licencia.getEstado() == EstadoTramite.ACTIVO) {
                return true;
            }
        }
        return false;
    }
    
    private boolean validarEscogioPersona() {
        if (persona == null) {
            JOptionPane.showMessageDialog(this,
                    "Selecciona correctamente a la persona",
                    "Error al seleccionar al cliente",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void tramitaLicenciaForm() {
        if (this.tramiteLicencia != null) {
            new TramiteLicenciaForm(persona);
            this.dispose();
        }
    }
    
    private void tramitePrimerasPlacasForm() {
        if (this.tramitePrimerasPlacas != null) {
            if (validarCredencialActiva()) {
                PrimerasPlacasForm tramite = new PrimerasPlacasForm(persona, vehiculo);
                tramite.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "La persona: "
                        + this.persona.getNombres() + " no tiene una licencia"
                        + " activa\n "
                        + "Vuelve a intentarlo registrando una licencia",
                        "Sin licencia",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    private void actualizarPlacasForm() {
        if (this.actualizarPlacas != null) {
            if (validarCredencialActiva()) {
                ActualizarPlacasForm actualizar = new ActualizarPlacasForm(persona, vehiculo, placaAntigua);
                actualizar.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "La persona: "
                        + this.persona.getNombres() + " no tiene una licencia"
                        + " activa", "Sin licencia",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    private void consultaForm() {
        if (this.consultarForm != null) {
            ConsultaForm consultar = new ConsultaForm(persona);
            consultar.setVisible(true);
            this.dispose();
        }
    }
    
    private boolean validarMayorDeEdad() {
        if (this.persona.getEdad() < 18) {
            JOptionPane.showMessageDialog(this,
                    "La persona: "
                    + this.persona.getNombres()
                    + " No es mayor de edad", "No tiene permiso!", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void validarPersonas() {
        if (personaDAO.consultarPersonas().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ops! Parece que no "
                    + "seguiste las indicaciones\n"
                    + "Necesitas ingresar a las personas\n", "Ops!!",
                    JOptionPane.WARNING_MESSAGE);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAvanzarPersona;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRetrocederPersona;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscarPor;
    private javax.swing.JTable tblPersonas;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

}
