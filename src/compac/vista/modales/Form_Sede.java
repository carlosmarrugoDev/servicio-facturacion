/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.vista.modales;

import compac.clases.controlador.SedeImpl;
import compac.clases.modelo.ObSedes;
import compac.clases.principales.Archivos_Planos;
import compac.clases.principales.ConfigGeneral;
import compac.clases.principales.CopiarArchivo;
import compac.clases.principales.Encripar;
import compac.clases.utilidades.FormatoCombox;
import compac.clases.utilidades.FormatoTextField;
import compac.clases.utilidades.Validador_de_Campos;
import compac.vista.principal.alertas.Alerta;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Form_Sede extends javax.swing.JDialog {

    ConfigGeneral config = new ConfigGeneral();
    SedeImpl controlador = new SedeImpl(); //llamamos al mentenimiento general del objeto  
    Archivos_Planos arc = new Archivos_Planos();

    Encripar encrip = new Encripar();
    FormatoCombox JCX = new FormatoCombox();
    FormatoTextField JTF = new FormatoTextField();
    
    Validador_de_Campos validar = new Validador_de_Campos();

    private int opcion_visual = config.getOpcion_visual();
    private String ruta = config.getRuta();
    String foto = "", origen = "", destino = "";
    int idrecepcionado = 0, ver = 0, id_usuario = 0;

    public Form_Sede(java.awt.Frame parent, boolean modal, int idrecepcionado, int ver, int id_usuario) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);
        this.setTitle("REGISTRO DE SEDE");
        this.idrecepcionado = idrecepcionado;
        this.id_usuario = id_usuario;
        this.ver = ver;


        JTF.modelo_1TF(txtDescripcion, opcion_visual);
        JTF.modelo_1TF(txtEmailOrigen, opcion_visual);
        JTF.modelo_1TF(txtDireccion, opcion_visual);
        JTF.modelo_1TF(txtTelefono, opcion_visual);
        JTF.modelo_1TF(txtCelular, opcion_visual);
        JTF.modelo_1TF(txtRuc, opcion_visual);
        JTF.modelo_1TF(txtEmailClave, opcion_visual);
        JTF.modelo_1TF(txtEmailDestino, opcion_visual);

        validar.validarSoloNumeros(txtTelefono);
        validar.validarSoloNumeros(txtCelular);
        validar.validarSoloNumeros(txtRuc);
        lblIdEmpresa.setText(idrecepcionado + "");
        lblIdEmpresa.setVisible(false);
        txtRuta.setVisible(false);
//emp.icono.general
        setIconImage(new ImageIcon(getClass().getResource("/compac/icono/general/logos.png")).getImage());
//        validar.validarSoloNumeros(txtDescripcion);

        if (idrecepcionado == 0) {
            txtDescripcion.requestFocus();
            /////////////////////////////////////////////////////////////////////////////
            //para MOSTRAR LA IMAGEN COMO ICONO DENTRO DEL LABEL emp.icono.general
            mostrarFotoPoDefecto("sinfoto.png");
            txtRuta.setText("sinfoto.png");
            ///////////////////////////////////////////////////////////////////////////// 
        } else {
            controlador.buscar_por_id(idrecepcionado);
            String descripcion = controlador.getObSedes().getDescripcion();
            String direccion = controlador.getObSedes().getDireccion();
            String telefono = controlador.getObSedes().getTelefono();
            String celular = controlador.getObSedes().getCelular();
            String ruc = controlador.getObSedes().getRuc();
            String email_clave = controlador.getObSedes().getEmail_clave();
            String email_origen = controlador.getObSedes().getEmail_origen();
            String email_destino = controlador.getObSedes().getEmail_destino();
            String foto = controlador.getObSedes().getFoto();

            String despedida = controlador.getObSedes().getDespedida();

            txtDespedida.setText(despedida);
//            ////////////////////////////////////////////////////////////////////////////
            txtDescripcion.setText(descripcion + "");
            txtDireccion.setText(direccion + "");
            txtTelefono.setText(telefono + "");
            txtCelular.setText(celular + "");
            txtRuc.setText(ruc + "");

            txtEmailClave.setText(encrip.desencriptarGeneral(email_clave) + "");
            txtEmailOrigen.setText(email_origen + "");
            txtEmailDestino.setText(email_destino + "");
            txtRuta.setText(foto + "");

            txtDescripcion.requestFocus();
            mostrarFotoPoDefecto(foto);
            /////////////////////////////////////////////////////////////////////////////
        }
        if (ver == 1) {
            txtDescripcion.setEnabled(false);
            txtDireccion.setEnabled(false);
            txtTelefono.setEnabled(false);
            txtCelular.setEnabled(false);
            txtRuc.setEnabled(false);
            txtEmailClave.setEnabled(false);
            txtEmailOrigen.setEnabled(false);
            txtEmailDestino.setEnabled(false);
            btnRegistrar.setEnabled(false);
            btnFoto.setEnabled(false);
            btnRestaurarFoto.setEnabled(false);

            txtDespedida.setEnabled(false);
        }

    }


    public void mostrarFotoPoDefecto(String f) {
        /////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////
        //para MOSTRAR LA IMAGEN COMO ICONO DENTRO DEL LABEL

        //para MOSTRAR LA IMAGEN COMO ICONO DENTRO DEL LABEL
        ImageIcon fot = new ImageIcon(ruta + "\\Fotos\\Sede\\" + f);
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(151, 151, Image.SCALE_DEFAULT));//lo de 140 y 170 es para q la imagen salga ese tamaño
        lblFoto.setIcon(icono);
        this.repaint();
        /////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        LTABLA = new javax.swing.JLabel();
        lblIdEmpresa = new javax.swing.JLabel();
        fcBuscarFoto = new javax.swing.JFileChooser();
        txtRuta = new javax.swing.JLabel();
        lblIdVersion = new javax.swing.JLabel();
        lblRespuesta = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        txtRuc = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtDescripcion = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtDireccion = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtTelefono = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtEmailOrigen = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtCelular = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtEmailDestino = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtEmailClave = new org.edisoncor.gui.passwordField.PasswordFieldRectBackground();
        btnFoto = new javax.swing.JButton();
        btnRestaurarFoto = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtDespedida = new org.edisoncor.gui.textField.TextFieldRectBackground();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        LTABLA.setText("jLabel1");
        jPanel4.add(LTABLA);

        lblIdEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtRuta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRuta.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblIdVersion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblRespuesta.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Decripción *");

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

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Ruc *");

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Dirección *");

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Email Origen *");

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Email Clave *");

        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Email Destino *");

        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Teléfono");

        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Celular");

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Foto ");

        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lblFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFotoMouseClicked(evt);
            }
        });

        txtRuc.setAnchoDeBorde(1.0F);
        txtRuc.setDescripcion("Ingrese una descripción");
        txtRuc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtDescripcion.setAnchoDeBorde(1.0F);
        txtDescripcion.setDescripcion("Ingrese una descripción");
        txtDescripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtDireccion.setAnchoDeBorde(1.0F);
        txtDireccion.setDescripcion("Ingrese una descripción");
        txtDireccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtTelefono.setAnchoDeBorde(1.0F);
        txtTelefono.setDescripcion("Ingrese una descripción");
        txtTelefono.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtEmailOrigen.setAnchoDeBorde(1.0F);
        txtEmailOrigen.setDescripcion("Ingrese una descripción");
        txtEmailOrigen.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtCelular.setAnchoDeBorde(1.0F);
        txtCelular.setDescripcion("Ingrese una descripción");
        txtCelular.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtEmailDestino.setAnchoDeBorde(1.0F);
        txtEmailDestino.setDescripcion("Ingrese una descripción");
        txtEmailDestino.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtEmailClave.setAnchoDeBorde(1.0F);
        txtEmailClave.setDescripcion("***************************");

        btnFoto.setBackground(new java.awt.Color(255, 255, 255));
        btnFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/guardar_16px.png"))); // NOI18N
        btnFoto.setText("Subir foto");
        btnFoto.setToolTipText("Opcion de Cargar foto");
        btnFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });

        btnRestaurarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/eliminar_16px.png"))); // NOI18N
        btnRestaurarFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRestaurarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarFotoActionPerformed(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Mensaje Despedida Para Impresión (PDF) *");

        txtDespedida.setAnchoDeBorde(1.0F);
        txtDespedida.setDescripcion("Ingrese una descripción");
        txtDespedida.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(315, 315, 315)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnFoto)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnRestaurarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDespedida, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEmailOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEmailDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                                        .addComponent(txtEmailClave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addContainerGap(14, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEmailOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(33, 33, 33))
                                            .addComponent(txtEmailDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(33, 33, 33))
                                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEmailClave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(33, 33, 33))
                                            .addComponent(txtDespedida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel8)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRestaurarFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        return txtDescripcion.getText();
    }

    public String leeDireccion() {
        return txtDireccion.getText();
    }

    public String leeRuc() {
        return txtRuc.getText().toUpperCase();
    }

    public String leeTelefono() {
        return txtTelefono.getText().toUpperCase();
    }

    public String leeCelular() {
        return txtCelular.getText().toUpperCase();
    }

    public String leeEmailOrigen() {
        return txtEmailOrigen.getText();
    }

    public String leeEmailClave() {
        return encrip.encriptarGeneral(txtEmailClave.getText());
    }

    public String leeEmailDestino() {
        return txtEmailDestino.getText();
    }

    public String leeRuta() {
        return txtRuta.getText();
    }

    public int leeId() {
        return Integer.parseInt(lblIdEmpresa.getText());
    }

    public String leeMsmDespedida() {
        return txtDespedida.getText();
    }

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (txtDescripcion.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Ingrese una valor válido", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtDescripcion.requestFocus();
            return;
        }
        if (txtDireccion.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Ingrese una Dirección válida", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtDireccion.requestFocus();
            return;
        }
        if (txtRuc.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Ingrese un Ruc válido", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtRuc.requestFocus();
            return;
        }

        try {
            if (idrecepcionado == 0) {

                String consulta = "Select descripcion from sede where descripcion='" + leeDescripcion() + "'";
                if (controlador.valida_Campos(consulta)) {
                    JOptionPane.showMessageDialog(null, "La Sede ingresada ya existe.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    txtDescripcion.setText("");
                    txtDescripcion.requestFocusInWindow();
                    return;
                }
                ObSedes sedes = new ObSedes(0, leeDescripcion(), leeDireccion(), leeTelefono(), leeCelular(),
                        leeRuc(), leeEmailClave(), leeEmailOrigen(), leeEmailDestino(), leeRuta(), 1, leeMsmDespedida());
                controlador.registrar(sedes);

                int opcion = JOptionPane.showConfirmDialog(null, "Desea Realizar otro Registro?", "Mensaje", JOptionPane.OK_CANCEL_OPTION);
                if (opcion == JOptionPane.OK_OPTION) {
                    txtDescripcion.setText("");
                    txtDescripcion.requestFocusInWindow();
                } else {
                    this.dispose();
                }

                Alerta alert = new Alerta("Mensaje", "Registro Exitoso");
                alert.setVisible(true);
            } else {

                String consulta = "Select descripcion from sede where descripcion='" + leeDescripcion() + "' and "
                        + " id_sede='" + leeId() + "'";
                if (!controlador.valida_Campos(consulta)) {
                    String consulta_reg = "Select descripcion from sede where descripcion='" + leeDescripcion() + "'";
                    if (controlador.valida_Campos(consulta_reg)) {
                        JOptionPane.showMessageDialog(null, "La Sede ingresada ya existe.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        txtDescripcion.setText("");
                        txtDescripcion.requestFocusInWindow();
                        return;
                    }
                }

                ObSedes sedes = new ObSedes(leeId(), leeDescripcion(), leeDireccion(), leeTelefono(), leeCelular(),
                        leeRuc(), leeEmailClave(), leeEmailOrigen(), leeEmailDestino(), leeRuta(), 1, leeMsmDespedida());
                controlador.actualizar(sedes);
                this.dispose();
                Alerta alert = new Alerta("Mensaje", "Actualización Exitosa");
                alert.setVisible(true);
            }

        } catch (Exception e) {
            System.err.println("error al registrar sede " + e.getLocalizedMessage());
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void lblFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoMouseClicked

    }//GEN-LAST:event_lblFotoMouseClicked

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtEmailOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailOrigenActionPerformed

    private void txtEmailDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailDestinoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtPagoMoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagoMoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagoMoraActionPerformed

    private void txtRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucActionPerformed

    private void txtEmailClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtEmailClave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailClave1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailClave1ActionPerformed

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed
        //busca la foto y lo graba en el paquete Imagen

        int resp;
        FileNameExtensionFilter f = new FileNameExtensionFilter(".JPG", ".PNG");
        fcBuscarFoto.setFileFilter(f);
        resp = fcBuscarFoto.showOpenDialog(this);

        if (resp == JFileChooser.APPROVE_OPTION) {

            origen = fcBuscarFoto.getSelectedFile().toString();
            foto = fcBuscarFoto.getName(fcBuscarFoto.getSelectedFile());
            System.out.println(fcBuscarFoto.getSelectedFile().toString());
            System.out.println();
            ////////lo alamcenamos en la carpeta
            //            destino = System.getProperty("user.dir") + "C:\\Program Files (x86)\\MESA-7\\FOTOS\\" + fcBuscarFoto.getName(fcBuscarFoto.getSelectedFile());
            destino = ruta + "\\Fotos\\Sede\\" + fcBuscarFoto.getName(fcBuscarFoto.getSelectedFile());
            //            destino = System.getProperty("user.home")+ "\\MESA-7\\FOTOS\\" + fcBuscarFoto.getName(fcBuscarFoto.getSelectedFile());
            /////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////////
            //para MOSTRAR LA IMAGEN COMO ICONO DENTRO DEL LABEL para mostrarlo al instante de cargar la foto al sistema
            ImageIcon fot = new ImageIcon(origen);
            Icon icono = new ImageIcon(fot.getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT));//lo de 140 y 170 es para q la imagen salga ese tamaño
            lblFoto.setIcon(icono);
            this.repaint();
            txtRuta.setText(foto);///foto contiene el nombre del archivo q se guardara en la BD
            /////////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////////
            //
            CopiarArchivo.getInstance().copiar(origen, destino);
            return;
        } else if (resp == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Operación Cancelada");
            return;
        }// TODO add your handling code here:
    }//GEN-LAST:event_btnFotoActionPerformed

    private void btnRestaurarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarFotoActionPerformed
        if (!txtRuta.getText().equalsIgnoreCase("sinfoto.png")) {
            arc.Eliminar_archivo(config.getRuta() + "\\Fotos\\Sede\\" + txtRuta.getText());
        }
        controlador.actualizarFoto("sinfoto.png", leeId());
        mostrarFotoPoDefecto("sinfoto.png");
        txtRuta.setText("sinfoto.png");
    }//GEN-LAST:event_btnRestaurarFotoActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Sede.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Sede.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Sede.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Sede.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold 
        //</editor-fold> 

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Form_Sede dialog = new Form_Sede(new javax.swing.JFrame(), true, 0, 0, 0);
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
    public static javax.swing.JButton btnFoto;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRestaurarFoto;
    private javax.swing.JFileChooser fcBuscarFoto;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblIdEmpresa;
    private javax.swing.JLabel lblIdVersion;
    public static javax.swing.JLabel lblRespuesta;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtCelular;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDescripcion;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDespedida;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDireccion;
    private org.edisoncor.gui.passwordField.PasswordFieldRectBackground txtEmailClave;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtEmailDestino;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtEmailOrigen;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtRuc;
    private javax.swing.JLabel txtRuta;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtTelefono;
    // End of variables declaration//GEN-END:variables
}
