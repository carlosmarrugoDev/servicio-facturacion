/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.vista.modales;

import compac.clases.controlador.ClienteImpl;
import compac.clases.controlador.Fac_cat6_TipodocImpl;
import compac.clases.modelo.ObCliente;
import compac.clases.modelo.ObFac_cat6_Tipodoc;
import compac.clases.principales.Archivos_Planos;
import compac.clases.principales.ConfigGeneral;
import compac.clases.principales.ConsultaWebService;
import compac.clases.utilidades.FormatoCombox;
import compac.clases.utilidades.FormatoTextField;
import compac.clases.utilidades.Validador_de_Campos;
import compac.vista.principal.alertas.AlertaBien;
import compac.vista.principal.alertas.AlertaError;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Form_Cliente extends javax.swing.JDialog {

    ConfigGeneral config = new ConfigGeneral();
    ClienteImpl controlador = new ClienteImpl(); //llamamos al mentenimiento general del objeto      
    Archivos_Planos arc = new Archivos_Planos();
    FormatoTextField JTF = new FormatoTextField();
    Validador_de_Campos validar = new Validador_de_Campos();
    FormatoCombox JCX = new FormatoCombox();

    ArrayList<ObFac_cat6_Tipodoc> lista_ObTipodoc = null;// creamos la lista para el objeto
    Fac_cat6_TipodocImpl controladorTipodoc = new Fac_cat6_TipodocImpl();//llamamos al mentenimiento general del objeto

    String foto = "", origen = "", destino = "", documento = "";
    private int opcion_visual = config.getOpcion_visual();
    int idcliente = 0, ver = 0;
    public static int valor = 0;
    private int id_usuario = 0, id_sede = 0;

    ConsultaWebService webService = new ConsultaWebService();

    public Form_Cliente(java.awt.Frame parent, boolean modal, int idcliente, int ver,
            String documento, int id_usuario, int id_sede) {
        super(parent, modal);
        initComponents();
        this.id_sede = id_sede;
        this.id_usuario = id_usuario;
        this.idcliente = idcliente;
        this.documento = documento;

        this.setLocationRelativeTo(null);
        this.setTitle("REGISTRO DE CLIENTES");
        this.ver = ver;
        JTF.modelo_1TF(txtNombresCompleto, opcion_visual);
        JTF.modelo_1TF(txtNumeroDocumento, opcion_visual);
        JTF.modelo_1TF(txtDireccion, opcion_visual);
        JTF.modelo_1TF(txtCelular, opcion_visual);
        JTF.modelo_1TF(txtCorreo, opcion_visual);
        JCX.modelo_1CBX(cboTipodocumento);

        validar.validarSoloNumeros(txtCelular);
        lblIdEmpresa.setText(idcliente + "");
        lblIdEmpresa.setVisible(false);
        valor = 0;

        txtObservaciones.setLineWrap(true);
        txtObservaciones.setWrapStyleWord(true);

        setIconImage(new ImageIcon(getClass().getResource("/compac/icono/general/logos.png")).getImage());

        lista_Tipos_Doc();
        if (idcliente == 0) {
            cboTipodocumento.requestFocus();

        } else {
            controlador.buscar_por_id(idcliente);
            String tipodoc = controlador.getObCliente().getTipodoc();
            String numdoc = controlador.getObCliente().getNum_documento();
            String direccion = controlador.getObCliente().getDireccion();
            String cel1 = controlador.getObCliente().getCelular();
            String correo = controlador.getObCliente().getEmail();
            String nombres = controlador.getObCliente().getNomcompleto();
            String observaciones = controlador.getObCliente().getObservacion();

//            ////////////////////////////////////////////////////////////////////////////
            cboTipodocumento.setSelectedItem(tipodoc);
            txtObservaciones.setText(observaciones);
            txtNombresCompleto.setText(nombres + "");
            txtCelular.setText(cel1 + "");
            txtCorreo.setText(correo + "");
            txtDireccion.setText(direccion + "");
            txtNumeroDocumento.setText(numdoc + "");

        }

        if (ver == 1) {
            txtNombresCompleto.setEnabled(false);
            txtNumeroDocumento.setEnabled(false);
            txtDireccion.setEnabled(false);
            txtCelular.setEnabled(false);
            txtCorreo.setEnabled(false);
            cboTipodocumento.setEnabled(false);
            btnRegistrar.setEnabled(false);
            btnConsulta.setEnabled(false);
            txtObservaciones.setEnabled(false);
        }

        txtNumeroDocumento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultaReSun();
            }
        });
    }

    //RELIZAMOS LA CARGA DE DATOS PARA EL COMBO DE LECTURA 
    public void lista_Tipos_Doc() {//LISTA TODAS EMPRESAS 
        lista_ObTipodoc = (ArrayList<ObFac_cat6_Tipodoc>) controladorTipodoc.listar();
        cboTipodocumento.removeAllItems();
        for (int i = 0; i < lista_ObTipodoc.size(); i++) {
            cboTipodocumento.addItem(lista_ObTipodoc.get(i).getSimbolo());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        LTABLA = new javax.swing.JLabel();
        lblIdEmpresa = new javax.swing.JLabel();
        placa = new javax.swing.JLabel();
        lblIdtipodoc = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnConsulta = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboTipodocumento = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtNumeroDocumento = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtNombresCompleto = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtDireccion = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtCelular = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtCorreo = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        LTABLA.setText("jLabel1");
        jPanel4.add(LTABLA);

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

        btnConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/Mant_Gen_16px.png"))); // NOI18N
        btnConsulta.setToolTipText("Consulta Reniec o Sunat dependiendo de su Tipo de Documento Seleccionado");
        btnConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Apellidos y Nombres *");

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Tipo de Documento *");

        cboTipodocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipodocumentoActionPerformed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Correo");

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Número de Documento *");

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Dirección");

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

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Celular");

        txtNumeroDocumento.setAnchoDeBorde(1.0F);
        txtNumeroDocumento.setDescripcion("Número de Documento");
        txtNumeroDocumento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtNombresCompleto.setAnchoDeBorde(1.0F);
        txtNombresCompleto.setDescripcion("Ingrese una descripción");
        txtNombresCompleto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtDireccion.setAnchoDeBorde(1.0F);
        txtDireccion.setDescripcion("Ingrese una descripción");
        txtDireccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtCelular.setAnchoDeBorde(1.0F);
        txtCelular.setDescripcion("Ingrese una descripción");
        txtCelular.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtCorreo.setAnchoDeBorde(1.0F);
        txtCorreo.setDescripcion("Ingrese una descripción");
        txtCorreo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtObservaciones.setColumns(20);
        txtObservaciones.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtObservaciones.setRows(5);
        jScrollPane1.setViewportView(txtObservaciones);

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Observaciones");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTipodocumento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(575, 575, 575)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombresCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addComponent(cboTipodocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombresCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel7)
                .addGap(6, 6, 6)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    public String leeCorreo() {
        String correo = txtCorreo.getText();
        return correo;
    }

    public String leeNumeroDocumento() {
        return txtNumeroDocumento.getText();
    }

    public String leeDireccion() {
        return txtDireccion.getText();
    }

    public String leeTipoDocumento() {
        return cboTipodocumento.getSelectedItem().toString().toUpperCase();
    }

    public String leeCelular1() {
        return txtCelular.getText();
    }

    public String leeNomCompleto() {
        return txtNombresCompleto.getText();
    }

    public int leeId() {
        return Integer.parseInt(lblIdEmpresa.getText());
    }

    public int leeId_tipodoc() {
        return Integer.parseInt(lblIdtipodoc.getText());
    }

    public String leeObservaciones() {
        return txtObservaciones.getText();
    }
    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtNumeroDocumentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroDocumentoKeyReleased

        int longiDoc = controladorTipodoc.obtenerEntero("Select longitud from tipodoc where id_tipodoc='" + lblIdtipodoc.getText() + "'");

        int longitud = txtNumeroDocumento.getText().length();
        String texto = txtNumeroDocumento.getText();
        if (longitud > longiDoc) {
            String cadena = texto.substring(0, texto.length() - 1);
            txtNumeroDocumento.setText(cadena);
        }

    }//GEN-LAST:event_txtNumeroDocumentoKeyReleased

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtCelularKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyReleased
        int longiDoc = 9;

        int longitud = txtCelular.getText().length();
        String texto = txtCelular.getText();
        if (longitud > longiDoc) {
            String cadena = texto.substring(0, texto.length() - 1);
            txtCelular.setText(cadena);
        }
    }//GEN-LAST:event_txtCelularKeyReleased

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        ConsultaReSun();
    }//GEN-LAST:event_btnConsultaActionPerformed

    public void ConsultaReSun() {
        String tipoDoc = cboTipodocumento.getSelectedItem().toString();
        if (tipoDoc.equalsIgnoreCase("RUC")) {
            int longiDoc = 11;

            int longitud = txtNumeroDocumento.getText().length();
            if (longitud > longiDoc) {
                JOptionPane.showMessageDialog(null, "El número de Ruc ingresado no es válido. Vuelva a intentarlo.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String rpt = "";
                try {
                    rpt = webService.consultarSunatruc(txtNumeroDocumento.getText(), txtNombresCompleto, txtDireccion);
                } catch (Exception ex) {
                    Logger.getLogger(Form_Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (!rpt.equalsIgnoreCase("SI")) {
                    AlertaError alert = new AlertaError("Mensaje", "Intente nuevamente");
                    alert.setVisible(true);
                }
            }
        } else if (tipoDoc.equalsIgnoreCase("DNI")) {
            int longiDoc = 8;

            int longitud = txtNumeroDocumento.getText().length();
            if (longitud > longiDoc) {
                JOptionPane.showMessageDialog(null, "El número de Ruc ingresado no es válido. Vuelva a intentarlo.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String rpt = "";
                try {
                    rpt = webService.consultarReniecDni(txtNumeroDocumento.getText(), txtNombresCompleto);
                } catch (Exception ex) {
                    Logger.getLogger(Form_Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (!rpt.equalsIgnoreCase("SI")) {
                    AlertaError alert = new AlertaError("Mensaje", "Intente nuevamente");
                    alert.setVisible(true);
                }
            }

        }
    }
    private void cboTipodocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipodocumentoActionPerformed

        try {
            String simbolo = cboTipodocumento.getSelectedItem().toString();
            int id_tipodoc = controladorTipodoc.obtenerId_descripcion(simbolo);
            lblIdtipodoc.setText("" + id_tipodoc);
            txtNumeroDocumento.requestFocusInWindow();

            if (simbolo.equalsIgnoreCase("RUC")) {
                jLabel3.setText("Razón Social *");
            } else {
                jLabel3.setText("Apellidos y Nombres *");
            }
            if (ver != 1) {
                txtNumeroDocumento.setText("");
                txtNombresCompleto.setText("");
                txtDireccion.setText("");
            }
            if (!documento.equalsIgnoreCase("")) {
                txtNumeroDocumento.setText(documento);
                ConsultaReSun();
            }
        } catch (Exception e) {
            System.err.println("error en : " + e.getMessage());
        }
    }//GEN-LAST:event_cboTipodocumentoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        int longiDoc = controladorTipodoc.obtenerEntero("Select longitud from fac_cat6_tipodoc where id_tipodoc='" + lblIdtipodoc.getText() + "'");

        int longitud = txtNumeroDocumento.getText().length();
        if (longitud < longiDoc) {

            JOptionPane.showMessageDialog(null, "El Número de Documento es Incorrecto. Verifique el Tipo de Documento Elegido.\n"
                    + "1. DNI (8 Dígitos)\n"
                    + "2. RUC (11 Dígitos)", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtNumeroDocumento.requestFocus();
            return;
        }

        if (txtNombresCompleto.getText().equalsIgnoreCase("")) {
            cboTipodocumento.requestFocus();
            AlertaError alert = new AlertaError("Mensaje", "Ingrese una descripción");
            alert.setVisible(true);
            return;
        }

        if (txtNumeroDocumento.getText().equalsIgnoreCase("")) {
            txtNumeroDocumento.requestFocus();
            AlertaError alert = new AlertaError("Mensaje", "Ingrese un número de Documento");
            alert.setVisible(true);
            return;
        }

        if (txtObservaciones.getText().equalsIgnoreCase("")) {
            txtObservaciones.setText("Sin observaciones.");
        }

        try {
            if (idcliente == 0) {

                String consulta = "Select num_documento from cliente where "
                        + " num_documento='" + leeNumeroDocumento() + "' and estado='1'  ";
                if (controlador.valida_Campos(consulta)) {
                    JOptionPane.showMessageDialog(null, "El Cliente ingresado ya existe.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    txtNumeroDocumento.setText("");
                    txtNumeroDocumento.requestFocusInWindow();
                    return;
                }

                ObCliente cliente = new ObCliente(0, leeTipoDocumento(), leeNumeroDocumento(),
                        leeDireccion(), leeCelular1(), leeCorreo(), 1, leeNomCompleto(),
                        id_usuario, id_sede, leeObservaciones(), leeId_tipodoc());
                controlador.registrar(cliente);

                valor = 1;
                int opcion = JOptionPane.showConfirmDialog(null, "Desea Realizar otro Registro?", "Mensaje", JOptionPane.OK_CANCEL_OPTION);
                if (opcion == JOptionPane.OK_OPTION) {
                    txtNombresCompleto.setText("");
                    txtNumeroDocumento.setText("");
                    txtDireccion.setText("");
                    txtCelular.setText("");
                    txtCorreo.setText("");
                    txtObservaciones.setText("");
                    txtNumeroDocumento.requestFocusInWindow();
                } else {
                    this.dispose();
                }

                AlertaBien alert = new AlertaBien("Mensaje", "Registro Exitoso");
                alert.setVisible(true);
            } else {

                String consulta = "Select num_documento from cliente where id_cliente='" + leeId() + "'  and "
                        + " num_documento='" + leeNumeroDocumento() + "' and estado='1' ";
                if (!controlador.valida_Campos(consulta)) {
                    String consultaCli = "Select num_documento from cliente where "
                            + " num_documento='" + leeNumeroDocumento() + "' and estado='1'  ";
                    if (controlador.valida_Campos(consultaCli)) {
                        JOptionPane.showMessageDialog(null, "El Cliente ingresado ya existe.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        txtNumeroDocumento.setText("");
                        txtNumeroDocumento.requestFocusInWindow();
                        return;
                    }
                }

                ObCliente cliente = new ObCliente(leeId(), leeTipoDocumento(), leeNumeroDocumento(),
                        leeDireccion(), leeCelular1(), leeCorreo(), 1, leeNomCompleto(),
                        id_usuario, id_sede, leeObservaciones(), leeId_tipodoc());
                controlador.actualizar(cliente);

                valor = 1;
                this.dispose();
                AlertaBien alert = new AlertaBien("Mensaje", "Actualización Exitosa");
                alert.setVisible(true);

            }
        } catch (Exception e) {
            System.err.println("error al registrar cliente " + e.getMessage());
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        valor = 0;
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        valor = 0;
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Form_Cliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Cliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Cliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Cliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold 
        //</editor-fold> 
        //</editor-fold  

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Form_Cliente dialog = new Form_Cliente(new javax.swing.JFrame(), true, 0, 0, "", 0, 0);
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
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox cboTipodocumento;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdEmpresa;
    private javax.swing.JLabel lblIdtipodoc;
    private javax.swing.JLabel placa;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtCelular;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtCorreo;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDireccion;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtNombresCompleto;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtNumeroDocumento;
    private javax.swing.JTextArea txtObservaciones;
    // End of variables declaration//GEN-END:variables
}
