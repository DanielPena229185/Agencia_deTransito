/**
 * ActualizarVehiculoPlaca.java
 * 28 mar. 2023 10:59:55
 *
 */
package org.itson.presentacion;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import org.itson.dominio.Costo;
import org.itson.dominio.CostoPlaca;
import org.itson.dominio.EstadoTramite;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.dominio.Vehiculo;
import org.itson.servicio.CostoServicio;
import org.itson.utils.GeneradorPlacas;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class ActualizarPlacasForm extends javax.swing.JFrame {

    private Persona persona;
    private Vehiculo vehiculo;
    private Placa placa;
    private Placa placaAntigua;
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    private CostoServicio costosDAO;

    /**
     *
     * Constructor de la clase ActualizarPlacasForm. Inicializa y muestra la
     * interfaz de usuario.
     */
    public ActualizarPlacasForm() {
        initComponents();
    }

    /**
     *
     * Constructor de la clase ActualizarPlacasForm que recibe un objeto
     * Vehiculo. Inicializa y muestra la interfaz de usuario.
     *
     * @param vehiculo Objeto de la clase Vehiculo que se utilizará para
     * actualizar las placas.
     */
    public ActualizarPlacasForm(Vehiculo vehiculo) {
        initComponents();
        this.vehiculo = vehiculo;
    }

    /**
     *
     * Constructor de la clase ActualizarPlacasForm que recibe objetos de las
     * clases Persona, Vehiculo y Placa. También inicializa y muestra la
     * interfaz de usuario, y llena los campos correspondientes con la
     * información recibida.
     *
     * @param persona Objeto de la clase Persona que se utilizará para llenar
     * los campos correspondientes.
     * @param vehiculo Objeto de la clase Vehiculo que se utilizará para llenar
     * los campos correspondientes.
     * @param placaAntigua Objeto de la clase Placa que representa la placa
     * anterior del vehículo.
     */
    public ActualizarPlacasForm(Persona persona, Vehiculo vehiculo, Placa placaAntigua) {
        initComponents();
        this.costosDAO = new CostoServicio();
        this.persona = persona;
        this.vehiculo = vehiculo;
        this.placaAntigua = placaAntigua;
        this.llenarCamposPersona();
        this.llenarCamposVehiculo();
        this.llenarCamposPlaca();
        this.llenarCamposPlacaNueva();
    }

    /**
     *
     * Constructor de la clase ActualizarPlacasForm que recibe un objeto
     * Vehiculo y un objeto Placa. Inicializa y muestra la interfaz de usuario,
     * y llena los campos correspondientes con la información recibida.
     *
     * @param vehiculo Objeto de la clase Vehiculo que se utilizará para llenar
     * los campos correspondientes.
     * @param placaAntigua Objeto de la clase Placa que representa la placa
     * anterior del vehículo.
     */
    public ActualizarPlacasForm(Vehiculo vehiculo, Placa placaAntigua) {
        initComponents();
        this.costosDAO = new CostoServicio();
        this.vehiculo = vehiculo;
        this.placaAntigua = placaAntigua;
        this.llenarCamposVehiculo();
        this.llenarCamposPlaca();
        this.llenarCamposPlacaNueva();
    }

    /**
     *
     * Método que llena los campos de nombre, RFC y teléfono de la persona en la
     * interfaz de usuario.
     */
    public void llenarCamposPersona() {
        this.txtNombre.setText(this.persona.getNombreCompleto());
        this.txtRfc.setText(this.persona.getRfc());
        this.txtTelefono.setText(this.persona.getTelefono());
    }

    /**
     *
     * Método que llena los campos de número de serie, marca, línea y modelo del
     * vehículo en la interfaz de usuario.
     */
    public void llenarCamposVehiculo() {
        this.txtNumeroSerie.setText(this.vehiculo.getNumeroSerie());
        this.txtMarca.setText(this.vehiculo.getMarca());
        this.txtLinea.setText(this.vehiculo.getLinea());
        this.txtModelo.setText(this.vehiculo.getModelo());
    }

    /**
     *
     * Método que llena los campos de número de placa y fecha de expedición de
     * la placa antigua del vehículo en la interfaz de usuario.
     */
    public void llenarCamposPlaca() {
        this.txtPlacas.setText(this.placaAntigua.getNumeroPlaca());
        Calendar fechaPlaca = this.placaAntigua.getFechaExpedicion();
        this.txtFechaExpedicion.setText(formatoFecha.format(fechaPlaca.getTime()));
    }

    /**
     *
     * Método que llena los campos de número de placa nueva, fecha de expedición
     * y costo de trámite de la nueva placa del vehículo en la interfaz de
     * usuario.
     */
    public void llenarCamposPlacaNueva() {
        GeneradorPlacas placaNueva = new GeneradorPlacas();
        this.txtPlacasNuevas.setText(placaNueva.generarPlaca());
        this.txtFecha.setText(formatoFecha.format(Calendar.getInstance().getTime()));
        this.txtPrecio.setText(String.valueOf(this.costoDeTramite()));
    }

    /**
     *
     * Retorna el costo del trámite de placa usado. Este método consulta los
     * costos de la tabla de costos de placa y retorna el costo normal del
     * trámite de placa usado. Si no hay costos en la tabla, retorna null.
     *
     * @return el costo normal del trámite de placa usado si hay costos en la
     * tabla
     */
    private Double costoDeTramite() {
        List<CostoPlaca> costos = costosDAO.consultarCostoPlacaUsado();

        for (Costo costo : costos) {
            return costo.getCostoNormal();
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        lblDatosVehiculo = new javax.swing.JLabel();
        lblNumeroSerie = new javax.swing.JLabel();
        txtNumeroSerie = new javax.swing.JTextField();
        lblMarca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lblLinea = new javax.swing.JLabel();
        txtLinea = new javax.swing.JTextField();
        lblModelo = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        lblPlacasAntiguas = new javax.swing.JLabel();
        lblPlacasAnteriores = new javax.swing.JLabel();
        txtPlacas = new javax.swing.JTextField();
        lblFechaExpedicion = new javax.swing.JLabel();
        txtFechaExpedicion = new javax.swing.JTextField();
        lblPlacasNuevas = new javax.swing.JLabel();
        lblNuvasPlacas = new javax.swing.JLabel();
        txtPlacasNuevas = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        lblSimboloPesos = new javax.swing.JLabel();
        lblDatosCliente = new javax.swing.JLabel();
        btnBuscarCliente = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblRfc = new javax.swing.JLabel();
        txtRfc = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualizar Placas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblDatosVehiculo.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblDatosVehiculo.setForeground(new java.awt.Color(0, 0, 0));
        lblDatosVehiculo.setText("Datos del Vehículo");

        lblNumeroSerie.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblNumeroSerie.setForeground(new java.awt.Color(0, 0, 0));
        lblNumeroSerie.setText("Número de Serie: ");

        txtNumeroSerie.setEditable(false);
        txtNumeroSerie.setBackground(new java.awt.Color(255, 255, 255));
        txtNumeroSerie.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtNumeroSerie.setForeground(new java.awt.Color(0, 0, 0));
        txtNumeroSerie.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNumeroSerie.setEnabled(false);
        txtNumeroSerie.setFocusable(false);

        lblMarca.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblMarca.setForeground(new java.awt.Color(0, 0, 0));
        lblMarca.setText("Marca:");

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

        txtModelo.setBackground(new java.awt.Color(255, 255, 255));
        txtModelo.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtModelo.setForeground(new java.awt.Color(0, 0, 0));
        txtModelo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtModelo.setEnabled(false);

        lblPlacasAntiguas.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblPlacasAntiguas.setForeground(new java.awt.Color(0, 0, 0));
        lblPlacasAntiguas.setText("Placas Antiguas");

        lblPlacasAnteriores.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblPlacasAnteriores.setForeground(new java.awt.Color(0, 0, 0));
        lblPlacasAnteriores.setText("Placas:");

        txtPlacas.setBackground(new java.awt.Color(255, 255, 255));
        txtPlacas.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtPlacas.setForeground(new java.awt.Color(0, 0, 0));
        txtPlacas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPlacas.setEnabled(false);
        txtPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacasActionPerformed(evt);
            }
        });

        lblFechaExpedicion.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblFechaExpedicion.setForeground(new java.awt.Color(0, 0, 0));
        lblFechaExpedicion.setText("Fecha de Expedición:");

        txtFechaExpedicion.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaExpedicion.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtFechaExpedicion.setForeground(new java.awt.Color(0, 0, 0));
        txtFechaExpedicion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtFechaExpedicion.setEnabled(false);

        lblPlacasNuevas.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblPlacasNuevas.setForeground(new java.awt.Color(0, 0, 0));
        lblPlacasNuevas.setText("Placas Nuevas");

        lblNuvasPlacas.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblNuvasPlacas.setForeground(new java.awt.Color(0, 0, 0));
        lblNuvasPlacas.setText("Placas:");

        txtPlacasNuevas.setBackground(new java.awt.Color(255, 255, 255));
        txtPlacasNuevas.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtPlacasNuevas.setForeground(new java.awt.Color(0, 0, 0));
        txtPlacasNuevas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPlacasNuevas.setEnabled(false);

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

        btnAceptar.setBackground(new java.awt.Color(255, 255, 255));
        btnAceptar.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(0, 0, 0));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        lblSimboloPesos.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblSimboloPesos.setForeground(new java.awt.Color(0, 0, 0));
        lblSimboloPesos.setText("$");

        lblDatosCliente.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblDatosCliente.setForeground(new java.awt.Color(0, 0, 0));
        lblDatosCliente.setText("Datos del Cliente");

        btnBuscarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarCliente.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnBuscarCliente.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscarCliente.setText("Buscar Cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        lblNombre.setBackground(new java.awt.Color(255, 255, 255));
        lblNombre.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(0, 0, 0));
        lblNombre.setText("Nombre:");

        txtNombre.setEditable(false);
        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));

        lblRfc.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblRfc.setForeground(new java.awt.Color(0, 0, 0));
        lblRfc.setText("RFC:");

        txtRfc.setEditable(false);
        txtRfc.setBackground(new java.awt.Color(255, 255, 255));
        txtRfc.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtRfc.setForeground(new java.awt.Color(0, 0, 0));

        lblTelefono.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(0, 0, 0));
        lblTelefono.setText("Teléfono:");

        txtTelefono.setEditable(false);
        txtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        jLabel1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Actualizar Placas:");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(6, 6, 6))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumeroSerie, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPlacas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtModelo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLinea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSimboloPesos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPlacasAnteriores)
                                    .addComponent(lblFechaExpedicion)
                                    .addComponent(lblNuvasPlacas)
                                    .addComponent(lblFecha)
                                    .addComponent(lblPrecio)
                                    .addComponent(lblModelo)
                                    .addComponent(lblLinea)
                                    .addComponent(lblMarca)
                                    .addComponent(lblNumeroSerie))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(txtFechaExpedicion, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPlacasNuevas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(lblPlacasAntiguas)
                            .addComponent(lblPlacasNuevas))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDatosVehiculo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDatosCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscarCliente))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(lblRfc)
                            .addComponent(lblTelefono))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(txtRfc)
                            .addComponent(txtNombre))))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRfc)
                    .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(lblDatosVehiculo)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumeroSerie))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMarca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLinea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModelo))
                .addGap(21, 21, 21)
                .addComponent(lblPlacasAntiguas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlacas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlacasAnteriores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaExpedicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaExpedicion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPlacasNuevas)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNuvasPlacas)
                    .addComponent(txtPlacasNuevas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSimboloPesos)
                    .addComponent(lblPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAceptar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlacasActionPerformed

    /**
     *
     * Acción que se realiza al hacer clic en el botón "Buscar Cliente". Este
     * método crea una instancia de la clase BuscadorClientesForm y muestra la
     * ventana de búsqueda de clientes. Luego, cierra la ventana actual.
     *
     * @param evt El evento que se activó al hacer clic en el botón "Buscar
     * Cliente".
     */
    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        BuscadorClientesForm buscar = new BuscadorClientesForm(this, vehiculo, placaAntigua);
        buscar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    /**
     *
     * Acción que se realiza al hacer clic en el botón "Aceptar". Este método
     * crea un objeto de tipo Placa y verifica si el vehículo tiene un dueño
     * registrado. Si el vehículo tiene un dueño registrado, crea una instancia
     * de la clase PagarDlg y muestra la ventana de pago. Si el usuario hace
     * clic en el botón "Salir" de la ventana de pago, crea una instancia de la
     * clase PrincipalForm y muestra la ventana principal. Si el vehículo no
     * tiene un dueño registrado, muestra un mensaje de advertencia al usuario.
     *
     * @param evt El evento que se activó al hacer clic en el botón "Aceptar".
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        crearObjetoPlaca();
        if (this.persona != null) {
            PagarDlg pagar = new PagarDlg(placa, placaAntigua, this, true, "Actualizar Placas");
            pagar.setVisible(true);
            if (pagar.isSalir()) {
                PrincipalForm principal = new PrincipalForm();
                principal.setVisible(true);
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Este vehículo no tiene dueño\n"
                    + " Intente seleccionar una persona en el buscador\n"
                    + "             [Buscar Personas]", "No puede Pagar", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
     *
     * Acción que se realiza al intentar cerrar la ventana. Este método muestra
     * un cuadro de diálogo de confirmación que pregunta al usuario si desea
     * cerrar la ventana. Si el usuario hace clic en "Sí", la ventana se cierra
     * y se llama al método regresarPantallaPrincipal(). Si el usuario hace clic
     * en "No", la ventana permanece abierta.
     *
     * @param evt El evento que se activó al intentar cerrar la ventana.
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
     * Crea un objeto de tipo Placa. Este método crea un objeto de tipo Placa
     * con la información de la placa que se está registrando. La placa incluirá
     * el número de placa nuevo, el vehículo al que se está asignando la placa,
     * el estado del trámite, el precio del trámite, la fecha de creación, la
     * fecha de vencimiento (que se establece en null) y la persona a la que se
     * está asignando la placa (que se establece en null).
     */
    private void crearObjetoPlaca() {
        this.placa = new Placa(this.txtPlacasNuevas.getText(),
                null, vehiculo, EstadoTramite.ACTIVO,
                Float.valueOf(this.txtPrecio.getText()), Calendar.getInstance(),
                null, persona);
    }

    /**
     *
     * Retorna a la pantalla principal de la aplicación. Este método crea una
     * instancia de la clase PrincipalForm y muestra la ventana principal, luego
     * cierra la ventana actual.
     */
    private void regresarPantallaPrincipal() {
        PrincipalForm principal = new PrincipalForm();
        principal.setVisible(true);
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDatosCliente;
    private javax.swing.JLabel lblDatosVehiculo;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFechaExpedicion;
    private javax.swing.JLabel lblLinea;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumeroSerie;
    private javax.swing.JLabel lblNuvasPlacas;
    private javax.swing.JLabel lblPlacasAnteriores;
    private javax.swing.JLabel lblPlacasAntiguas;
    private javax.swing.JLabel lblPlacasNuevas;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblRfc;
    private javax.swing.JLabel lblSimboloPesos;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFechaExpedicion;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroSerie;
    private javax.swing.JTextField txtPlacas;
    private javax.swing.JTextField txtPlacasNuevas;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtRfc;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

}
