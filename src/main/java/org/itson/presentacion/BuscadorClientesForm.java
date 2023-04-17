/**
 * BuscadorForm.java
 * 27 mar. 2023 10:30:15
 *
 */
package org.itson.presentacion;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import org.itson.dominio.EstadoTramite;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.dominio.Tramite;
import org.itson.dominio.Vehiculo;
import org.itson.excepciones.EncriptarException;
import org.itson.servicio.LicenciaServicio;
import org.itson.servicio.PersonaServicio;
import org.itson.utils.ConfiguracionDePaginado;
import org.itson.utils.Encriptador;

/**
 * Descripción de la clase: Esta clase se encarga de mostrar el formulario para
 * buscar cliente
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
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
     *
     * Constructor por defecto que inicializa los componentes del formulario,
     * carga la información necesaria en ellos y configura la selección de la
     * tabla de personas.
     */
    public BuscadorClientesForm() {
        personaDAO = new PersonaServicio();
        initComponents();
        this.cargarComboBox();
        this.validarPersonas();
        this.tblPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.BuscarPersona();
    }

    /**
     *
     * Constructor que recibe un objeto TramiteLicenciaForm como parámetro y lo
     * guarda en el atributo correspondiente. Llama a los mismos métodos que el
     * constructor por defecto.
     *
     * @param tramiteLicencia Objeto TramiteLicenciaForm que será utilizado en
     * el contexto del formulario.
     */
    public BuscadorClientesForm(TramiteLicenciaForm tramiteLicencia) {
        personaDAO = new PersonaServicio();
        initComponents();
        this.cargarComboBox();
        this.validarPersonas();
        this.tblPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.BuscarPersona();
        this.tramiteLicencia = tramiteLicencia;
    }

    /**
     *
     * Constructor que recibe un objeto ConsultaForm como parámetro y lo guarda
     * en el atributo correspondiente. Llama a los mismos métodos que el
     * constructor por defecto.
     *
     * @param consultarForm Objeto ConsultaForm que será utilizado en el
     * contexto del formulario.
     */
    public BuscadorClientesForm(ConsultaForm consultarForm) {
        personaDAO = new PersonaServicio();
        initComponents();
        this.cargarComboBox();
        this.validarPersonas();
        this.tblPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.BuscarPersona();
        this.consultarForm = consultarForm;
    }

    /**
     *
     * Constructor que recibe un objeto PrimerasPlacasForm y un objeto Vehiculo
     * como parámetros y los guarda en los atributos correspondientes. Llama a
     * los mismos métodos que el constructor por defecto.
     *
     * @param tramitePrimerasPlacas Objeto PrimerasPlacasForm que será utilizado
     * en el contexto del formulario.
     * @param vehiculo Objeto Vehiculo que será utilizado en el contexto del
     * formulario.
     */
    public BuscadorClientesForm(PrimerasPlacasForm tramitePrimerasPlacas, Vehiculo vehiculo) {
        personaDAO = new PersonaServicio();
        initComponents();
        this.licenciasActivas.setVisible(true);
        this.cargarComboBox();
        this.validarPersonas();
        this.tblPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.BuscarPersona();
        this.vehiculo = vehiculo;
        this.tramitePrimerasPlacas = tramitePrimerasPlacas;
    }

    /**
     *
     * Constructor que recibe los parámetros necesarios para realizar la
     * búsqueda de clientes.
     *
     * @param actualizarPlacas Objeto de la clase ActualizarPlacasForm.
     * @param vehiculo Objeto de la clase Vehiculo.
     * @param placaAntigua Objeto de la clase Placa.
     */
    public BuscadorClientesForm(ActualizarPlacasForm actualizarPlacas, Vehiculo vehiculo, Placa placaAntigua) {
        personaDAO = new PersonaServicio();
        initComponents();
        this.licenciasActivas.setVisible(true);
        this.cargarComboBox();
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
        yearChooser = new com.toedter.calendar.JYearChooser();
        licenciasActivas = new javax.swing.JLabel();

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

        yearChooser.setBackground(new java.awt.Color(255, 255, 255));
        yearChooser.setYear(1999);

        licenciasActivas.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        licenciasActivas.setForeground(new java.awt.Color(0, 153, 0));
        licenciasActivas.setText("Solo licencias activas");
	licenciasActivas.setVisible(false);

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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(yearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtBuscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAceptar)
                            .addComponent(btnRetrocederPersona)
                            .addComponent(btnAvanzarPersona)))
                    .addComponent(licenciasActivas))
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(yearChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(187, 187, 187))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(licenciasActivas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    /**
     *
     * Realiza la búsqueda de personas de acuerdo al filtro seleccionado y al
     * término de búsqueda ingresado. Actualiza la tabla de resultados de
     * acuerdo a la búsqueda. Lanza una excepción de tipo EncriptarException si
     * ocurre algún error al intentar encriptar el término de búsqueda.
     */
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
            buscar = String.valueOf(this.yearChooser.getYear());
        }
        //Generar tabla
        List<Persona> listaPersona = personaDAO.consultarPersonasFiltroPaginado(filtro, buscar, paginadoCliente);
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblPersonas.getModel();

        listaPersona = this.filtrarLicenciasActivas(listaPersona);
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

    /**
     *
     * Carga los elementos del ComboBox de filtro de búsqueda con los posibles
     * filtros disponibles. Este método es llamado al inicializar la ventana de
     * búsqueda de personas.
     */
    private void cbxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFiltroActionPerformed
        this.cargarComboBox();
    }//GEN-LAST:event_cbxFiltroActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        if (txtBuscar.getText().isEmpty()) {
            this.BuscarPersona();
        } else if (!this.txtBuscar.getText().isEmpty() && this.cbxFiltro.getSelectedItem().toString() != "Nombre") {
            this.BuscarPersona();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    /**
     *
     * Maneja el evento de tecleo de la caja de búsqueda de personas. Si el
     * término de búsqueda está vacío, se actualizan los resultados. Si el
     * término de búsqueda no está vacío y el filtro seleccionado no es
     * "Nombre", se actualizan los resultados. Este método es llamado cada vez
     * que se teclea en la caja de búsqueda.
     */
    private void tblPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPersonasMouseClicked
        int seleccionar = tblPersonas.rowAtPoint(evt.getPoint());
        String idString = String.valueOf(tblPersonas.getValueAt(seleccionar, 0));
        Long idLong = Long.valueOf(idString);
        Persona personaSeleccionada = new Persona();
        personaSeleccionada.setIdPersona(idLong);
        this.persona = personaDAO.consultarPersona(personaSeleccionada);
    }//GEN-LAST:event_tblPersonasMouseClicked

    /**
     *
     * Maneja el evento de clic en la tabla de resultados de personas. Obtiene
     * el ID de la persona seleccionada y consulta su información en la base de
     * datos. Este método es llamado cada vez que se hace clic en la tabla de
     * resultados.
     */
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

    /**
     *
     * Maneja el evento de clic del mouse en la tabla de personas.
     *
     * @param evt El evento del mouse
     */
    private void tblPersonasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPersonasMousePressed
        int seleccionar = tblPersonas.rowAtPoint(evt.getPoint());
        String idString = String.valueOf(tblPersonas.getValueAt(seleccionar, 0));
        Long idLong = Long.valueOf(idString);
        Persona personaSeleccionada = new Persona();
        personaSeleccionada.setIdPersona(idLong);
        this.persona = personaDAO.consultarPersona(personaSeleccionada);
    }//GEN-LAST:event_tblPersonasMousePressed

    /**
     *
     * Maneja el evento de ocultación del componente.
     *
     * @param evt El evento del componente
     */
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

    /**
     *
     * Maneja el evento de acción del cuadro de búsqueda.
     *
     * @param evt El evento de acción
     */
    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    /**
     *
     * Maneja el evento de acción del botón de avanzar persona.
     *
     * @param evt El evento de acción
     */
    private void btnAvanzarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarPersonaActionPerformed
        // TODO add your handling code here:
        paginadoCliente.avanzarPagina();
        this.BuscarPersona();
    }//GEN-LAST:event_btnAvanzarPersonaActionPerformed

    /**
     *
     * Maneja el evento de acción del botón de retroceder persona.
     *
     * @param evt El evento de acción
     */
    private void btnRetrocederPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederPersonaActionPerformed
        // TODO add your handling code here:
        paginadoCliente.retrocederPagina();
        this.BuscarPersona();
    }//GEN-LAST:event_btnRetrocederPersonaActionPerformed

    /**
     *
     * Maneja el evento de acción del botón de búsqueda.
     *
     * @param evt El evento de acción
     */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.BuscarPersona();
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     *
     * Valida si la credencial de la persona está activa.
     *
     * @return true si la credencial está activa, false en caso contrario
     */
    private boolean validarCredencialActiva() {
        List<Licencia> licencias = licenciaDAO.consultarLicenciasPersona(this.persona);
        for (Licencia licencia : licencias) {
            if (licencia.getEstado() == EstadoTramite.ACTIVO) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * Valida si se seleccionó correctamente a la persona.
     *
     * @return true si la persona está seleccionada correctamente, false en caso
     * contrario
     */
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

    /**
     *
     * Abre la ventana de tramitación de licencia.
     */
    private void tramitaLicenciaForm() {
        if (this.tramiteLicencia != null) {
            new TramiteLicenciaForm(persona);
            this.dispose();
        }
    }

    /**
     *
     * Abre la ventana de tramitación de primeras placas.
     */
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

    /**
     *
     * Método que permite la creación de una instancia de la clase
     * ActualizarPlacasForm para actualizar las placas de un vehículo registrado
     * en la base de datos. Si el formulario de ActualizarPlacas ya está abierto
     * y hay una persona seleccionada con una licencia activa, se crea una
     * instancia del formulario y se abre. Si la persona seleccionada no tiene
     * una licencia activa, se muestra un mensaje de error al usuario.
     */
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

    /**
     *
     * Método que permite la creación de una instancia de la clase ConsultaForm
     * para consultar los datos de una persona registrada en la base de datos.
     * Si el formulario de consulta ya está abierto, se crea una instancia del
     * formulario y se abre.
     */
    private void consultaForm() {
        if (this.consultarForm != null) {
            ConsultaForm consultar = new ConsultaForm(persona);
            consultar.setVisible(true);
            this.dispose();
        }
    }

    /**
     *
     * Método que verifica si la persona seleccionada es mayor de edad, es
     * decir, tiene una edad mayor o igual a 18 años. Si la persona no es mayor
     * de edad, se muestra un mensaje de error al usuario.
     *
     * @return true si la persona es mayor de edad, false en caso contrario.
     */
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

    /**
     *
     * Método que verifica si hay al menos una persona registrada en la base de
     * datos. Si no hay personas registradas, se muestra un mensaje de error al
     * usuario.
     */
    private void validarPersonas() {
        if (personaDAO.consultarPersonas().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ops! Parece que no "
                    + "seguiste las indicaciones\n"
                    + "Necesitas ingresar a las personas\n", "Ops!!",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     *
     * Método que carga los datos del comboBox utilizado para filtrar los
     * resultados de búsqueda de acuerdo a la opción seleccionada por el
     * usuario. Si se selecciona la opción "Año de Nacimiento", se deshabilita
     * el campo de búsqueda de texto y se habilita un componente de selección de
     * año. En caso contrario, se habilita el campo de búsqueda de texto y se
     * oculta el componente de selección de año.
     */
    private void cargarComboBox() {
        if (this.cbxFiltro.getSelectedItem().toString() != "Año de Nacimiento") {
            this.txtBuscar.enable(true);
            this.yearChooser.setVisible(false);
        } else {
            this.txtBuscar.enable(false);
            this.yearChooser.setVisible(true);
        }
    }

    /**
     * Método dónde se filtra las personas que solo tengan licencias activas
     * para solo el caso de que quiera realizar el trámite de placas, ya sea
     * actualizar o tramitar las primeras placas
     *
     * @param listaPersona Lista que se desea filtrar
     * @return Lista filtrada
     */
    private List<Persona> filtrarLicenciasActivas(List<Persona> listaPersona) {
        if (this.actualizarPlacas != null || this.tramitePrimerasPlacas != null) {
            //Si busca para actualizar o tramitar primeras placas
            //Aparezcan puras licencias activas
            List<Persona> listaPersonasFiltro = new LinkedList<>();
            for (Persona person : listaPersona) {
                List<Tramite> tramitesPerson = person.getTramite();
                for (Tramite tramite : tramitesPerson) {
                    if (tramite instanceof Licencia) {
                        if (tramite.getEstado() == EstadoTramite.ACTIVO) {
                            listaPersonasFiltro.add(person);
                        }
                    }
                }
            }
            listaPersona = listaPersonasFiltro;
        }
        return listaPersona;
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
    private javax.swing.JLabel licenciasActivas;
    private javax.swing.JTable tblPersonas;
    private javax.swing.JTextField txtBuscar;
    private com.toedter.calendar.JYearChooser yearChooser;
    // End of variables declaration//GEN-END:variables

}
