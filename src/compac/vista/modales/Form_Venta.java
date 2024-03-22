/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.vista.modales;

import compac.clases.controlador.ClienteImpl;
import compac.clases.controlador.VentaImpl;
import compac.clases.modelo.ObCliente;
import compac.clases.principales.ConfigGeneral;
import compac.clases.principales.ConsultaWebService;
import compac.clases.principales.Fecha_Date;
import compac.clases.utilidades.FormatoTextField;
import compac.clases.utilidades.ImgTabla;
import compac.clases.utilidades.Validador_de_Campos;
import compac.vista.busqueda.Venta_Cliente;
import compac.vista.principal.alertas.AlertaBien;
import compac.vista.principal.alertas.AlertaError;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Form_Venta extends javax.swing.JDialog {

    ConfigGeneral config = new ConfigGeneral();
    VentaImpl controlador = new VentaImpl(); //llamamos al mentenimiento general del objeto
    ClienteImpl controladorCliente = new ClienteImpl();

    FormatoTextField JTF = new FormatoTextField();
    Validador_de_Campos validar = new Validador_de_Campos();

    ConsultaWebService webService = new ConsultaWebService();

    Fecha_Date fec = new Fecha_Date();
    private int opcion_visual = config.getOpcion_visual();
    int id_venta = 0, ver = 0;
    private int id_usuario = 0, id_sede = 0;

    public Form_Venta(java.awt.Frame parent, boolean modal, int id_venta,
            int ver, int id_usuario, int id_sede) {
        super(parent, modal);
        initComponents();
        this.id_venta = id_venta;
        this.id_usuario = id_usuario;
        this.id_sede = id_sede;
        this.ver = ver;

        this.setLocationRelativeTo(null);
        this.setTitle("REGISTRO DE VENTAS");

        fec.capturaymuestrahoradelsistema(txtFecha);
        tblDetalle.setDefaultRenderer(Object.class, new ImgTabla());

        JTF.modelo_1TF(txtDocumentoComprobante, opcion_visual);
        lblIdVenta.setText(id_venta + "");
        lblIdVenta.setVisible(false);

        setIconImage(new ImageIcon(getClass().getResource("/compac/icono/general/logos.png")).getImage());

        if (id_venta == 0) {
            txtDocumentoCliente.requestFocusInWindow();
        } else {
            controlador.buscar_por_id(id_venta);
            String fecha = controlador.getObVenta().getFecha();

            txtFecha.setDate(fec.StringADate(fecha));

        }

        txtDocumentoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String tipoComprobante = cboTipoComprobante.getSelectedItem().toString();
                if (tipoComprobante.equalsIgnoreCase("BOLETA DE VENTA ELECTRÓNICA")) {

                    int ctnTexto = txtDocumentoCliente.getText().length();
                    if (ctnTexto == 8) {

                        int pregunta = JOptionPane.showConfirmDialog(null, "¿Desea realizar la Búsqueda del Cliente Ingresado?\n"
                                + "El número de Documento es: " + txtDocumentoCliente.getText(), "Mensaje", JOptionPane.OK_CANCEL_OPTION);
                        if (pregunta == JOptionPane.OK_OPTION) {
                            if (ConsultaReSun() == 1) {

                                ObCliente cliente = new ObCliente(0, "DNI", txtDocumentoCliente.getText(), "-", "", "", 1,
                                        txtNombreCliente.getText().toUpperCase(), id_usuario, id_sede, "", 1);
                                controladorCliente.registrar(cliente);

                                AlertaBien alert = new AlertaBien("Mensaje", "Registro Exitoso");
                                alert.setVisible(true);
                            } else {

                                AlertaError alert = new AlertaError("Mensaje", "Operación Cancelada");
                                alert.setVisible(true);
                            }

                        }

                    } else {
                        txtNombreCliente.setText("");
                        txtCorreoCliente.setText("");
                        txtDireccionCliente.setText("");
                        lblIdCliente.setText("");

                        AlertaError alert = new AlertaError("Mensaje", "El Documento ingresado no Cumple el valor necesario");
                        alert.setVisible(true);
                    }

                } else if (tipoComprobante.equalsIgnoreCase("FACTURA ELECTRÓNICA")) {
                    int ctnTexto = txtDocumentoCliente.getText().length();
                    if (ctnTexto == 11) {
                        int pregunta = JOptionPane.showConfirmDialog(null, "¿Desea realizar la Búsqueda del Cliente Ingresado?\n"
                                + "El número de Documento es: " + txtDocumentoCliente.getText(), "Mensaje", JOptionPane.OK_CANCEL_OPTION);
                        if (pregunta == JOptionPane.OK_OPTION) {
                            if (ConsultaReSun() == 1) {
                                ObCliente cliente = new ObCliente(0, "RUC", txtDocumentoCliente.getText(), txtDireccionCliente.getText().toUpperCase(),
                                        "", "", 1, txtNombreCliente.getText().toUpperCase(), id_usuario, id_sede, "", 2);
                                controladorCliente.registrar(cliente);

                                AlertaBien alert = new AlertaBien("Mensaje", "Registro Exitoso");
                                alert.setVisible(true);
                            }
                        } else {

                            AlertaError alert = new AlertaError("Mensaje", "Operación Cancelada");
                            alert.setVisible(true);
                        }

                    } else {
                        txtNombreCliente.setText("");
                        txtCorreoCliente.setText("");
                        txtDireccionCliente.setText("");
                        lblIdCliente.setText("");

                        AlertaError alert = new AlertaError("Mensaje", "El Documento ingresado no Cumple el valor necesario");
                        alert.setVisible(true);
                    }
                }
            }
        });

        if (ver == 1) {
            txtDocumentoComprobante.setEnabled(false);
            btnRegistrar.setEnabled(false);
        }

    }

    public int ConsultaReSun() {

        int valorRpta = 0;

        String tipoComprobante = cboTipoComprobante.getSelectedItem().toString();
        if (tipoComprobante.equalsIgnoreCase("FACTURA ELECTRÓNICA")) {
            int longiDoc = 11;

            int longitud = txtDocumentoCliente.getText().length();
            if (longitud > longiDoc) {
                JOptionPane.showMessageDialog(null, "El número de Ruc ingresado no es válido. Vuelva a intentarlo.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String rpt = "";
                try {
                    rpt = webService.consultarSunatruc(txtDocumentoCliente.getText(), txtNombreCliente, txtDireccionCliente);
                } catch (Exception ex) {
                    Logger.getLogger(Form_Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (!rpt.equalsIgnoreCase("SI")) {
                    AlertaError alert = new AlertaError("Mensaje", "Intente nuevamente");
                    alert.setVisible(true);
                } else {
                    valorRpta = 1;
                }
            }
        } else if (tipoComprobante.equalsIgnoreCase("BOLETA DE VENTA ELECTRÓNICA")) {
            int longiDoc = 8;

            int longitud = txtDocumentoCliente.getText().length();
            if (longitud > longiDoc) {
                JOptionPane.showMessageDialog(null, "El número de Ruc ingresado no es válido. Vuelva a intentarlo.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String rpt = "";
                try {
                    rpt = webService.consultarReniecDni(txtDocumentoCliente.getText(), txtNombreCliente);
                } catch (Exception ex) {
                    Logger.getLogger(Form_Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (!rpt.equalsIgnoreCase("SI")) {
                    AlertaError alert = new AlertaError("Mensaje", "Intente nuevamente");
                    alert.setVisible(true);
                } else {
                    valorRpta = 1;
                }
            }
        }
        return valorRpta;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        LTABLA = new javax.swing.JLabel();
        lblIdVenta = new javax.swing.JLabel();
        lblIdCliente = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtDocumentoComprobante = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel3 = new javax.swing.JLabel();
        cboTipoComprobante = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        txtDescripcion1 = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel5 = new javax.swing.JLabel();
        txtDocumentoCliente = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel6 = new javax.swing.JLabel();
        txtNombreCliente = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel7 = new javax.swing.JLabel();
        txtCorreoCliente = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel8 = new javax.swing.JLabel();
        btnNuevoCliente = new javax.swing.JButton();
        btnBuscarCliente = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalle = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtDescripcion5 = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtDireccionCliente = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel10 = new javax.swing.JLabel();
        txtImporteTotal = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtLeyenda = new javax.swing.JLabel();
        txtSubTotal = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtTotaIgv = new org.edisoncor.gui.textField.TextFieldRectBackground();
        btnRegistrar = new javax.swing.JButton();
        txtTotalGravado = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel19 = new javax.swing.JLabel();
        txtTotalExonerado = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel20 = new javax.swing.JLabel();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        LTABLA.setText("jLabel1");
        jPanel4.add(LTABLA);

        lblIdVenta.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblIdCliente.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Producto *");

        txtDocumentoComprobante.setEditable(false);
        txtDocumentoComprobante.setAnchoDeBorde(1.0F);
        txtDocumentoComprobante.setDescripcion("Núm. de Documento");
        txtDocumentoComprobante.setEnabled(false);
        txtDocumentoComprobante.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Tipo de Comprobante *");

        cboTipoComprobante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BOLETA DE VENTA ELECTRÓNICA", "FACTURA ELECTRÓNICA" }));
        cboTipoComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoComprobanteActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Fecha *");

        txtDescripcion1.setAnchoDeBorde(1.0F);
        txtDescripcion1.setDescripcion("Ingrese una descripción");
        txtDescripcion1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Comprobante *");

        txtDocumentoCliente.setAnchoDeBorde(1.0F);
        txtDocumentoCliente.setDescripcion("Documento de Identidad");
        txtDocumentoCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDocumentoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDocumentoClienteKeyReleased(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Número de Documento *");

        txtNombreCliente.setEditable(false);
        txtNombreCliente.setAnchoDeBorde(1.0F);
        txtNombreCliente.setDescripcion("Nombre / Razón Social");
        txtNombreCliente.setEnabled(false);
        txtNombreCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreClienteActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Nombres / Razón Social *");

        txtCorreoCliente.setEditable(false);
        txtCorreoCliente.setAnchoDeBorde(1.0F);
        txtCorreoCliente.setDescripcion("Ingrese una descripción");
        txtCorreoCliente.setEnabled(false);
        txtCorreoCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Correo *");

        btnNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/nuevo_16px.png"))); // NOI18N
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });

        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/buscar_16px.png"))); // NOI18N
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/buscar_16px.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        tblDetalle.setForeground(new java.awt.Color(255, 255, 255));
        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDetalle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDetalle.setFillsViewportHeight(true);
        tblDetalle.setGridColor(new java.awt.Color(247, 247, 247));
        tblDetalle.setSelectionBackground(new java.awt.Color(0, 102, 153));
        tblDetalle.getTableHeader().setReorderingAllowed(false);
        tblDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetalleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDetalle);

        jPanel2.add(jScrollPane1);

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Obs. *");

        txtDescripcion5.setAnchoDeBorde(1.0F);
        txtDescripcion5.setDescripcion("Ingrese una descripción");
        txtDescripcion5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtDireccionCliente.setEditable(false);
        txtDireccionCliente.setAnchoDeBorde(1.0F);
        txtDireccionCliente.setDescripcion("Ingrese una descripción");
        txtDireccionCliente.setEnabled(false);
        txtDireccionCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Dirección *");

        txtImporteTotal.setEditable(false);
        txtImporteTotal.setBackground(new java.awt.Color(1, 150, 51));
        txtImporteTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtImporteTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtImporteTotal.setAnchoDeBorde(1.0F);
        txtImporteTotal.setColorDeBorde(new java.awt.Color(1, 150, 51));
        txtImporteTotal.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        txtImporteTotal.setDescripcion("Total");

        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("T.Gravado : ");

        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Sub Total : ");

        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("IGV : ");

        txtLeyenda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtLeyenda.setForeground(new java.awt.Color(51, 51, 51));
        txtLeyenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtSubTotal.setEditable(false);
        txtSubTotal.setBackground(new java.awt.Color(238, 64, 64));
        txtSubTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtSubTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSubTotal.setAnchoDeBorde(1.0F);
        txtSubTotal.setColorDeBorde(new java.awt.Color(238, 64, 64));
        txtSubTotal.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        txtSubTotal.setDescripcion("Sub Total");
        txtSubTotal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        txtTotaIgv.setEditable(false);
        txtTotaIgv.setBackground(new java.awt.Color(238, 64, 64));
        txtTotaIgv.setForeground(new java.awt.Color(255, 255, 255));
        txtTotaIgv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotaIgv.setAnchoDeBorde(1.0F);
        txtTotaIgv.setColorDeBorde(new java.awt.Color(238, 64, 64));
        txtTotaIgv.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        txtTotaIgv.setDescripcion("IGV");
        txtTotaIgv.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/guardar_16px.png"))); // NOI18N
        btnRegistrar.setMnemonic('R');
        btnRegistrar.setText("Registrar");
        btnRegistrar.setToolTipText("Realizar NuevoRegistro");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        txtTotalGravado.setEditable(false);
        txtTotalGravado.setBackground(new java.awt.Color(1, 150, 51));
        txtTotalGravado.setForeground(new java.awt.Color(255, 255, 255));
        txtTotalGravado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalGravado.setAnchoDeBorde(1.0F);
        txtTotalGravado.setColorDeBorde(new java.awt.Color(1, 150, 51));
        txtTotalGravado.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        txtTotalGravado.setDescripcion("Total");

        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("T.Exonerado : ");

        txtTotalExonerado.setEditable(false);
        txtTotalExonerado.setBackground(new java.awt.Color(1, 150, 51));
        txtTotalExonerado.setForeground(new java.awt.Color(255, 255, 255));
        txtTotalExonerado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalExonerado.setAnchoDeBorde(1.0F);
        txtTotalExonerado.setColorDeBorde(new java.awt.Color(1, 150, 51));
        txtTotalExonerado.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        txtTotalExonerado.setDescripcion("Total");

        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Imp.Total : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccionCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtLeyenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtImporteTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboTipoComprobante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                    .addComponent(txtDocumentoComprobante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtDescripcion1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescripcion5, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel12)
                                        .addGap(4, 4, 4)
                                        .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(4, 4, 4)
                                        .addComponent(txtTotalGravado, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(jLabel13)
                                        .addGap(4, 4, 4)
                                        .addComponent(txtTotaIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(4, 4, 4)
                                        .addComponent(txtTotalExonerado, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboTipoComprobante)
                            .addComponent(txtDocumentoComprobante, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNuevoCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(1, 1, 1)
                .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtDescripcion5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLeyenda, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtImporteTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel12)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotalGravado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel11))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotaIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel13)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotalExonerado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel19)))))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPlantillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlantillaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlantillaActionPerformed

    private void txtPlantillaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlantillaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlantillaKeyReleased

    private void txtCodigoBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoBarraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoBarraActionPerformed

    private void txtCodigoBarraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoBarraKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoBarraKeyReleased

    public String leeDescripcion() {
        return txtDocumentoComprobante.getText().toUpperCase();
    }

    public int leeId() {
        return Integer.parseInt(lblIdVenta.getText());
    }
    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void tblDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetalleMouseClicked

    }//GEN-LAST:event_tblDetalleMouseClicked

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed


    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        new Venta_Cliente(null, true, id_usuario, id_sede, "TODOS").setVisible(true);
        if (Venta_Cliente.valor == 1) {

            int id_clienteBusqueda = Integer.parseInt(lblIdCliente.getText());
            muestraClienteporId(id_clienteBusqueda);

        } else {
            AlertaError alert = new AlertaError("Mensaje", "Operación Cancelada");
            alert.setVisible(true);
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed

        new Form_Cliente(null, true, 0, 0, "", id_usuario, id_sede).setVisible(true);
        if (Form_Cliente.valor == 1) {

            int id_clienteRegistro = controladorCliente.obtenerEntero("Select max(id_cliente) from cliente where id_usuario='" + id_usuario + "' and id_sede='" + id_sede + "'");
            muestraClienteporId(id_clienteRegistro);

        } else {
            AlertaError alert = new AlertaError("Mensaje", "Operación Cancelada");
            alert.setVisible(true);
        }


    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void txtDocumentoClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoClienteKeyReleased

        String tipoComprobante = cboTipoComprobante.getSelectedItem().toString();
        if (tipoComprobante.equalsIgnoreCase("BOLETA DE VENTA ELECTRÓNICA")) {

            int ctnTexto = txtDocumentoCliente.getText().length();
            if (ctnTexto == 8) {

                if (controladorCliente.validaCliente(txtDocumentoCliente.getText())) {
                    int id_clienteVenta = Integer.parseInt(controladorCliente.obtieneDatosCliente("id_cliente", txtDocumentoCliente.getText()));
                    muestraClienteporId(id_clienteVenta);
                }

            } else {
                txtNombreCliente.setText("");
                txtCorreoCliente.setText("");
                txtDireccionCliente.setText("");
                lblIdCliente.setText("");
            }

        } else if (tipoComprobante.equalsIgnoreCase("FACTURA ELECTRÓNICA")) {
            int ctnTexto = txtDocumentoCliente.getText().length();
            if (ctnTexto == 11) {
                if (controladorCliente.validaCliente(txtDocumentoCliente.getText())) {
                    int id_clienteVenta = Integer.parseInt(controladorCliente.obtieneDatosCliente("id_cliente", txtDocumentoCliente.getText()));
                    muestraClienteporId(id_clienteVenta);
                }
            } else {
                txtNombreCliente.setText("");
                txtCorreoCliente.setText("");
                txtDireccionCliente.setText("");
                lblIdCliente.setText("");
            }

        }


    }//GEN-LAST:event_txtDocumentoClienteKeyReleased

    private void cboTipoComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoComprobanteActionPerformed

        txtNombreCliente.setText("");
        txtCorreoCliente.setText("");
        txtDireccionCliente.setText("");
        lblIdCliente.setText("");
        txtDocumentoCliente.requestFocusInWindow();

    }//GEN-LAST:event_cboTipoComprobanteActionPerformed

    public void muestraClienteporId(int id_clienteMostrar) {
        controladorCliente.buscar_por_id(id_clienteMostrar);
        String num_documentoCliente = controladorCliente.getObCliente().getNum_documento();
        String nom_Cliente = controladorCliente.getObCliente().getNomcompleto();
        String correo_Cliente = controladorCliente.getObCliente().getEmail();
        String direccion_Cliente = controladorCliente.getObCliente().getDireccion();

        lblIdCliente.setText("" + id_clienteMostrar);
        txtDocumentoCliente.setText(num_documentoCliente);
        txtNombreCliente.setText(nom_Cliente);
        txtCorreoCliente.setText(correo_Cliente);
        txtDireccionCliente.setText(direccion_Cliente);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold  
        //</editor-fold>
        //</editor-fold  

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Form_Venta dialog = new Form_Venta(new javax.swing.JFrame(), true, 0, 0, 0, 0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LTABLA;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox cboTipoComprobante;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblIdCliente;
    private javax.swing.JLabel lblIdVenta;
    private javax.swing.JTable tblDetalle;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtCorreoCliente;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDescripcion1;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDescripcion5;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDireccionCliente;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDocumentoCliente;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDocumentoComprobante;
    private com.toedter.calendar.JDateChooser txtFecha;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtImporteTotal;
    private javax.swing.JLabel txtLeyenda;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtNombreCliente;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtSubTotal;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtTotaIgv;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtTotalExonerado;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtTotalGravado;
    // End of variables declaration//GEN-END:variables
}
