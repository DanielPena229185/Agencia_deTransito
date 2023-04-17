/**
 * CobrarDlg.java
 * 27 mar. 2023 10:44:50
 */
package org.itson.presentacion;

import java.awt.Frame;
import java.util.Calendar;
import org.itson.dominio.EstadoTramite;
import org.itson.dominio.Licencia;
import org.itson.dominio.Pago;
import org.itson.dominio.Placa;
import org.itson.dominio.Tramite;
import org.itson.dominio.Vehiculo;
import org.itson.servicio.PagoServicio;
import org.itson.servicio.LicenciaServicio;
import org.itson.servicio.PlacaServicio;
import org.itson.servicio.VehiculoServicio;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class PagarDlg extends javax.swing.JDialog {

    private Tramite licencia;
    private Licencia licenciaAnterior;
    private String concepto;
    private PagoServicio PagoDAO;
    private VehiculoServicio vehiculoDAO = new VehiculoServicio();
    private LicenciaServicio licenciaDAO;
    private PlacaServicio placaDAO = new PlacaServicio();
    private Pago pago;
    private Placa placa;
    private Placa placaAnterior;
    private boolean salir;

    /**
     * En este constructor, recivimos trámites de licencia, para saber a qué
     * tipo de trámite se le va a pagar, en este caso es para una nueva licencia
     *
     * @param parent
     * @param modal
     * @param licencia
     * @param concepto
     */
    public PagarDlg(java.awt.Frame parent, boolean modal, Licencia licencia, String concepto) {
        super(parent, modal);
        initComponents();
        this.PagoDAO = new PagoServicio();
        this.licencia = licencia;
        this.concepto = concepto;
        this.llenarCamposTextoLicencia();
    }

    /**
     * En este constructor, recivimos trámites de licencia, para saber a qué
     * tipo de trámite se le va a pagar, en este caso es para una nueva licencia
     *
     * @param parent
     * @param modal
     * @param placa
     * @param concepto
     */
    public PagarDlg(java.awt.Frame parent, boolean modal, Placa placa, String concepto) {
        super(parent, modal);
        initComponents();
        this.PagoDAO = new PagoServicio();
        this.placa = placa;
        this.concepto = concepto;
        this.llenarCamposTextoLicencia();
    }

    /**
     * En este constructor, recivimos trámites de licencia, para saber a qué
     * tipo de trámite se le va a pagar, en este caso es para una trámitar otra
     * licencia
     *
     * @param parent
     * @param modal
     * @param licencia
     * @param licenciaAnterior
     */
    public PagarDlg(java.awt.Frame parent, boolean modal, Licencia licencia, Licencia licenciaAnterior, String concepto) {
        super(parent, modal);
        initComponents();
        this.PagoDAO = new PagoServicio();
        this.licenciaDAO = new LicenciaServicio();
        this.licencia = licencia;
        this.concepto = concepto;
        this.licenciaAnterior = licenciaAnterior;
        this.llenarCamposTextoLicencia();
    }

    /**
     *
     * Constructor de la clase PagarDlg.
     *
     * @param parent La ventana padre del diálogo.
     * @param modal Indica si el diálogo es modal o no.
     * @param placa La placa del vehículo a pagar.
     * @param placaAnterior La placa anterior del vehículo (en caso de cambio de
     * placa).
     * @param concepto El concepto de pago (multa, tenencia, etc.).
     */
    public PagarDlg(java.awt.Frame parent, boolean modal, Placa placa, Placa placaAnterior, String concepto) {
        super(parent, modal);
        initComponents();
        this.PagoDAO = new PagoServicio();
        this.placa = placa;
        this.placaAnterior = placaAnterior;
        this.concepto = concepto;
        this.llenarCamposTextoLicencia();
    }

    /**
     *
     * Crea un diálogo para realizar el pago de un trámite asociado a una placa
     * de vehículo.
     *
     * @param placa la placa de vehículo asociada al trámite.
     * @param placaAnterior la placa anterior del vehículo, en caso de cambio de
     * placa.
     * @param owner el Frame padre del diálogo.
     * @param modal especifica si el diálogo es modal.
     * @param concepto el concepto del trámite a pagar.
     */
    public PagarDlg(Placa placa, Placa placaAnterior, Frame owner, boolean modal, String concepto) {
        super(owner, modal);
        initComponents();
        this.placa = placa;
        this.PagoDAO = new PagoServicio();
        this.placaAnterior = placaAnterior;
        this.concepto = concepto;
        this.llenarCamposTextoPlaca();
    }

    /**
     *
     * Crea un diálogo para realizar un pago relacionado con una placa
     * especificada.
     *
     * @param placa la placa relacionada con el pago
     * @param owner el marco padre del diálogo
     * @param modal si el diálogo debe ser modal o no
     * @param concepto el concepto del pago a realizar
     */
    public PagarDlg(Placa placa, Frame owner, boolean modal, String concepto) {
        super(owner, modal);
        initComponents();
        this.PagoDAO = new PagoServicio();
        this.placa = placa;
        this.concepto = concepto;
        this.llenarCamposTextoPlaca();
    }

    /**
     *
     * Agrega un pago al sistema, actualizando la licencia o placa
     * correspondiente si es necesario. Si la licencia es no nula, crea un nuevo
     * objeto de tipo Pago y lo asocia a la licencia. Además, si existe una
     * licencia anterior, la actualiza a INACTIVA en la base de datos. Si la
     * licencia es nula, verifica si la placa anterior es nula o no. Si es nula,
     * crea un nuevo objeto de tipo Pago y lo asocia a la placa. Si no es nula,
     * actualiza la placa anterior a INACTIVA y con la fecha de recepción
     * actual, y crea un nuevo objeto de tipo Pago y lo asocia a la placa
     * actual.
     */
    public void agregarPago() {
        if (licencia != null) {
            pago = new Pago(licencia.getPrecio(), Calendar.getInstance(), this.txtConcepto.getText(), licencia);
            if (licenciaAnterior != null) {
                licenciaAnterior.setEstado(EstadoTramite.INACTIVO);
                licenciaDAO.actualizarLicencia(licenciaAnterior);
            }
        } else {
            if (placaAnterior == null) {
                Vehiculo vehiculo = placa.getVehiculo();
                vehiculoDAO.agregarVehiculo(vehiculo);
                pago = new Pago(placa.getPrecio(), Calendar.getInstance(), this.txtConcepto.getText(), placa);
            } else {
                placaAnterior.setEstado(EstadoTramite.INACTIVO);
                placaAnterior.setFechaRecepcion(Calendar.getInstance());
                placaDAO.actualizarPlaca(placaAnterior);
                pago = new Pago(placa.getPrecio(), Calendar.getInstance(), this.txtConcepto.getText(), placa);
            }
        }

        // JOptionPane.showMessageDialog(null, pago.toString());
        PagoDAO.agregarPago(pago);
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
        lblRealizarCobro = new javax.swing.JLabel();
        lblMonto = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        btnCobro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtConcepto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pagos");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        lblRealizarCobro.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblRealizarCobro.setForeground(new java.awt.Color(255, 255, 255));
        lblRealizarCobro.setText("Realizar Pago:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRealizarCobro)
                .addContainerGap(233, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRealizarCobro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblMonto.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblMonto.setForeground(new java.awt.Color(0, 0, 0));
        lblMonto.setText("Monto: ");

        txtMonto.setBackground(new java.awt.Color(255, 255, 255));
        txtMonto.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtMonto.setForeground(new java.awt.Color(0, 0, 0));
        txtMonto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMonto.setEnabled(false);

        btnCobro.setBackground(new java.awt.Color(255, 255, 255));
        btnCobro.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnCobro.setForeground(new java.awt.Color(0, 0, 0));
        btnCobro.setText("Pagar");
        btnCobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobroActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Concepto:");

        txtConcepto.setBackground(new java.awt.Color(255, 255, 255));
        txtConcepto.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtConcepto.setForeground(new java.awt.Color(0, 0, 0));
        txtConcepto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtConcepto.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCobro))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(lblMonto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMonto)
                            .addComponent(txtConcepto))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMonto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCobro)
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

    /**
     *
     * Método que se ejecuta al presionar el botón de cobro. Agrega un nuevo
     * pago y cierra el diálogo.
     *
     * @param evt El evento de acción que se genera al presionar el botón de
     * cobro.
     */
    private void btnCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobroActionPerformed
        this.agregarPago();
        this.salir = true;
        this.dispose();
    }//GEN-LAST:event_btnCobroActionPerformed

    /**
     *
     * Llena los campos de texto de la ventana de pago con la información de la
     * licencia. El precio de la licencia se coloca en el campo "txtMonto" y el
     * concepto en el campo "txtConcepto".
     */
    private void llenarCamposTextoLicencia() {
        String monto = String.valueOf(licencia.getPrecio());
        this.txtMonto.setText(monto);
        this.txtConcepto.setText(concepto);
    }

    /**
     *
     * Llena los campos de texto de la ventana con la información de la placa.
     */
    private void llenarCamposTextoPlaca() {
        String monto = String.valueOf(placa.getPrecio());
        this.txtMonto.setText(monto);
        this.txtConcepto.setText(concepto);
    }

    /**
     *
     * Retorna el valor actual de la variable "salir".
     *
     * @return true si se ha confirmado el cobro y se ha cerrado el dialogo,
     * false en caso contrario.
     */
    public boolean isSalir() {
        return salir;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCobro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblRealizarCobro;
    private javax.swing.JTextField txtConcepto;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables

}
