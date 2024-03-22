/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.vista.modales;

import compac.clases.controlador.PerfilImpl;
import compac.clases.controlador.SedeImpl;
import compac.clases.controlador.UsuarioImpl;
import compac.clases.controlador.UsuarioSedeImpl;
import compac.clases.modelo.ObPerfil;
import compac.clases.modelo.ObSedes;
import compac.clases.modelo.ObUsuario;
import compac.clases.modelo.ObUsuarioSede;
import compac.clases.principales.ConfigGeneral;
import compac.clases.principales.Encripar;
import compac.clases.utilidades.FormatoCombox;
import compac.clases.utilidades.FormatoTextField;
import compac.clases.utilidades.Validador_de_Campos;
import compac.vista.principal.alertas.Alerta;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Form_Usuario extends javax.swing.JDialog {

    DefaultTableModel modelo = null;//creamos el modelo de la tabla
    ConfigGeneral config = new ConfigGeneral();
    Encripar encriptar = new Encripar();
    UsuarioImpl controlador = new UsuarioImpl(); //llamamos al mentenimiento general del objeto

    ArrayList<ObPerfil> lista_ObPerfil = null;// creamos la lista para el objeto
    PerfilImpl controladorPerfil = null;//llamamos al mentenimiento general del objeto  

    ArrayList<ObSedes> lista_ObSedes = null;// creamos la lista para el objeto
    ArrayList<ObUsuarioSede> lista_ObUsuarioSede = null;// creamos la lista para el objeto
    SedeImpl controladorSedes = new SedeImpl();//llamamos al mentenimiento general del objeto
    UsuarioSedeImpl controladorUsuarioSede = new UsuarioSedeImpl();//llamamos al mentenimiento general del objeto

    FormatoTextField JTF = new FormatoTextField();
    FormatoCombox JCX = new FormatoCombox();
    Validador_de_Campos validar = new Validador_de_Campos();

    private int opcion_visual = config.getOpcion_visual();
    int id_usuario = 0, ver = 0, id_sede = 0;
//        this.id_usuarios=id_usuarios;
//        this.id_sedes=id_usuarios;

    public Form_Usuario(java.awt.Frame parent, boolean modal, int id_usuario, int ver, int id_sede) {
        super(parent, modal);
        initComponents();
        controladorPerfil = new PerfilImpl();

        this.setLocationRelativeTo(null);
        this.setTitle("REGISTRO DE USUARIOS");
        this.id_usuario = id_usuario;
        this.id_sede = id_sede;
        this.ver = ver;
        JTF.modelo_1TF(txtUsuario, opcion_visual);
        JTF.modelo_1TF(txtPassword, opcion_visual);
        JCX.modelo_1CBX(cboPerfil);

        lblIdEmpresa.setText(id_usuario + "");
        lblIdEmpresa.setVisible(false);
        lblIdPerfil.setVisible(false);
//emp.icono.general
        setIconImage(new ImageIcon(getClass().getResource("/compac/icono/general/logos.png")).getImage());
//        validar.validarSoloNumeros(txtDescripcion);
        int id_perfilGen = controlador.obtenerId_perfil(id_usuario);
        if (id_usuario == 0) {
            lista_Perfil(id_perfilGen);
            lista_Sedes();
            mostrar_Tabla();
            txtUsuario.requestFocus();
        } else {
            controlador.buscar_por_id(id_usuario);
            String descripcion = controlador.getObUsuario().getUsuario();
            String password = controlador.getObUsuario().getPassword();
            int id_perfil = controlador.getObUsuario().getId_perfil();

            lista_Perfil(id_perfil);
            lista_Sedes();
            mostrar_Tabla();
//            ////////////////////////////////////////////////////////////////////////////
            txtUsuario.setText(descripcion + "");
            txtPassword.setText(password + "");

            cboPerfil.setSelectedItem(controladorPerfil.obtieneDescripcion_id(id_perfil));
            lblIdPerfil.setText(id_perfil + "");

            lista_ObUsuario(id_usuario);
            txtUsuario.requestFocus();
            /////////////////////////////////////////////////////////////////////////////
        }

        if (ver == 1) {
            txtUsuario.setEnabled(false);
            txtPassword.setEnabled(false);
            cboPerfil.setEnabled(false);
            btnRegistrar.setEnabled(false);
            btnNuevoPerfil.setEnabled(false);

            cboSede.setEnabled(false);
            btnAgregar.setEnabled(false);
            btnQuitar.setEnabled(false);
        }
    }

    //RELIZAMOS LA CARGA DE DATOS PARA EL COMBO DE LECTURA 
    public void lista_Perfil(int id_perfil) {//LISTA TODAS EMPRESAS 
        String perfil = controladorPerfil.obtieneDescripcion_id(id_perfil);
        if (perfil.equalsIgnoreCase("DESARROLLADOR")) {
            lista_ObPerfil = (ArrayList<ObPerfil>) controladorPerfil.listar();
        } else {
            lista_ObPerfil = (ArrayList<ObPerfil>) controladorPerfil.listarSinDes();
        }
        cboPerfil.removeAllItems();
        for (int i = 0; i < lista_ObPerfil.size(); i++) {
            cboPerfil.addItem(lista_ObPerfil.get(i).getDescripcion());
        }
    }

    //RELIZAMOS LA CARGA DE DATOS PARA EL COMBO DE LECTURA 
    public void lista_Sedes() {//LISTA TODAS EMPRESAS 
        lista_ObSedes = (ArrayList<ObSedes>) controladorSedes.listar();
        cboSede.removeAllItems();
        for (int i = 0; i < lista_ObSedes.size(); i++) {
            cboSede.addItem(lista_ObSedes.get(i).getDescripcion());
        }
    }

    public void mostrar_Tabla() {
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        modelo.addColumn("#");
        modelo.addColumn("SEDE");
        tblDetalle.setRowHeight(30);
        tblDetalle.setModel(modelo);
        tblDetalle.setBackground(Color.WHITE);
        tblDetalle.setAutoResizeMode(tblDetalle.AUTO_RESIZE_OFF);

        tblDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblDetalle.getColumnModel().getColumn(1).setPreferredWidth(410);
    }

    public void agregarDatosTabla() {
        String datos[] = new String[2];

        datos[0] = "" + leeIdSede();
        datos[1] = cboSede.getSelectedItem().toString().toUpperCase();

        modelo.addRow(datos);
    }

    public void lista_ObUsuario(int idUsuario) {//LISTA TODAS EMPRESAS   
        lista_ObUsuarioSede = (ArrayList<ObUsuarioSede>) controladorUsuarioSede.listarporUsuario(idUsuario);
        for (int i = 0; i < lista_ObUsuarioSede.size(); i++) {
            Object datos[] = new Object[2];

            datos[0] = (lista_ObUsuarioSede.get(i).getId_sede()) + "";
            datos[1] = (controladorSedes.obtieneDescripcion_id(lista_ObUsuarioSede.get(i).getId_sede())) + "";

            modelo.addRow(datos);
        }
    }

    public void guardar_detalle(int idusuario) {
        //obtiene el numero de filas seleccionadas
        int filas = tblDetalle.getRowCount();
        if (filas <= 0) {//si no elije ninguna fila
            JOptionPane.showMessageDialog(null, "No existen detalles a guardar");
        } else {//cuando si seleciona
            int totalRow = tblDetalle.getRowCount();
            totalRow -= 1;
            for (int i = 0; i <= (totalRow); i++) {
                int idSede = Integer.parseInt(tblDetalle.getValueAt(i, 0).toString());
                //GRABAR LA TABLA DETALLE DE GUIA
                try {
                    ObUsuarioSede usuSede = new ObUsuarioSede(0, idusuario, idSede);
                    controladorUsuarioSede.registrar(usuSede);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al guardar el controladorUsuarioSede " + e, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        LTABLA = new javax.swing.JLabel();
        lblIdEmpresa = new javax.swing.JLabel();
        lblIdPerfil = new javax.swing.JLabel();
        lblIdSede = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboPerfil = new javax.swing.JComboBox();
        btnNuevoPerfil = new javax.swing.JButton();
        txtUsuario = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtPassword = new org.edisoncor.gui.passwordField.PasswordFieldRectBackground();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalle = new javax.swing.JTable();
        btnQuitar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        cboSede = new javax.swing.JComboBox();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        LTABLA.setText("jLabel1");
        jPanel4.add(LTABLA);

        lblIdEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Usuario *");

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

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Contraseña *");

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Perfil de Usuario *");

        cboPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPerfilActionPerformed(evt);
            }
        });

        btnNuevoPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/nuevo_16px.png"))); // NOI18N
        btnNuevoPerfil.setText("Nuevo");
        btnNuevoPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPerfilActionPerformed(evt);
            }
        });

        txtUsuario.setAnchoDeBorde(1.0F);
        txtUsuario.setDescripcion("Ingrese una descripción");
        txtUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtPassword.setAnchoDeBorde(1.0F);
        txtPassword.setDescripcion("***************************");

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Sedes de Acceso *");

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
        jScrollPane1.setViewportView(tblDetalle);

        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/eliminar_16px.png"))); // NOI18N
        btnQuitar.setToolTipText("Quitar de Detalle");
        btnQuitar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/guardar_16px.png"))); // NOI18N
        btnAgregar.setToolTipText("Agregar a Detalle");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        cboSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSedeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 3, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cboSede, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnNuevoPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboSede, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        return txtUsuario.getText().toUpperCase();
    }

    public String leePaassword() {
        return txtPassword.getText();
    }

    public int leeIdPerfil() {
        return Integer.parseInt(lblIdPerfil.getText());
    }

    public int leeIdSede() {
        return Integer.parseInt(lblIdSede.getText());
    }

    public int leeId() {
        return Integer.parseInt(lblIdEmpresa.getText());
    }

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        int filas = tblDetalle.getRowCount();
        if (filas <= 0) {//si no elije ninguna fila 
            JOptionPane.showMessageDialog(null, "Ingrese como Mínimo un Item en la Lista.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            cboSede.requestFocusInWindow();
            return;
        }

        if (txtUsuario.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Ingrese un Usuario válido", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtUsuario.requestFocus();
            return;
        }
        if (txtPassword.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Ingrese una Contraseña válida", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtPassword.requestFocus();
            return;
        }
        if (lblIdPerfil.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Seleccione un Perfil válido", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            cboPerfil.requestFocus();
            return;
        }
        if (lblIdPerfil.getText().equalsIgnoreCase("0")) {
            JOptionPane.showMessageDialog(null, "Seleccione un Perfil válido", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            cboPerfil.requestFocus();
            return;
        }
        try {

            if (id_usuario == 0) {

                String consulta = "Select usuario from usuario where "
                        + " usuario='" + leeDescripcion() + "'   "
                        + " and estado='1'";
                if (controlador.valida_Campos(consulta)) {
                    JOptionPane.showMessageDialog(null, "El Usuario ingresado ya existe.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    txtUsuario.setText("");
                    txtUsuario.requestFocusInWindow();
                    return;
                }
                ObUsuario usuario = new ObUsuario(0, leeDescripcion(), leePaassword(), 1,
                        leeIdPerfil(), id_sede);
                controlador.registrar(usuario);

                int idmax_usuario = controlador.obtenerEntero("Select max(id_usuario) from usuario ");
                //GUARDAMOS DETALLE DE ACCESO A SEDES
                guardar_detalle(idmax_usuario);
                int opcion = JOptionPane.showConfirmDialog(null, "Desea Realizar otro Registro?", "Mensaje", JOptionPane.OK_CANCEL_OPTION);
                if (opcion == JOptionPane.OK_OPTION) {
                    txtUsuario.setText("");
                    txtPassword.setText("");
                    txtUsuario.requestFocusInWindow();
                } else {
                    this.dispose();
                }
                Alerta alert = new Alerta("Mensaje", "Registro Exitoso");
                alert.setVisible(true);
            } else {

                String consulta = "Select usuario from usuario where usuario='" + leeDescripcion() + "' and "
                        + " id_usuario='" + leeId() + "'  and estado='1'   ";
                if (!controlador.valida_Campos(consulta)) {
                    String consulta_reg = "Select usuario from usuario where "
                            + " usuario='" + leeDescripcion() + "'  "
                            + " and estado='1'";
                    if (controlador.valida_Campos(consulta_reg)) {
                        JOptionPane.showMessageDialog(null, "El Usuario ingresado ya existe.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        txtUsuario.setText("");
                        txtUsuario.requestFocusInWindow();
                        return;
                    }
                }

                ObUsuario usuario = new ObUsuario(leeId(), leeDescripcion(), leePaassword(), 1,
                        leeIdPerfil(), id_sede);
                controlador.actualizar(usuario);
                //GUARDAMOS DETALLE DE ACCESO A SEDES
                controladorUsuarioSede.eliminar(leeId(), id_usuario, id_sede);
                guardar_detalle(leeId());
                this.dispose();
                Alerta alert = new Alerta("Mensaje", "Actualización Exitosa");
                alert.setVisible(true);
            }

        } catch (Exception e) {
            System.err.println("error al registrar area " + e.getLocalizedMessage());
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void cboPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPerfilActionPerformed

        try {
            String des_perfil = cboPerfil.getSelectedItem().toString();
            int id_perfil = controladorPerfil.obtenerId_descripcion(des_perfil);
            lblIdPerfil.setText("" + id_perfil);
        } catch (Exception e) {
            System.err.println("error en : " + e.getMessage());
        }

    }//GEN-LAST:event_cboPerfilActionPerformed

    private void btnNuevoPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPerfilActionPerformed

    }//GEN-LAST:event_btnNuevoPerfilActionPerformed

    void Eliminar() {
        //obtiene el numero de filas seleccionadas
        int filas = tblDetalle.getSelectedRowCount();
        if (filas == 0) {//si no elije ninguna fila
            JOptionPane.showMessageDialog(null, "Deve selecionar una fila o más");
        } else {//cuando si seleciona
            int fila = tblDetalle.getSelectedRow();//obtiene la fila
            modelo.removeRow(fila);//remueve la fila obtenida
        }
    }
    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null, "Desea Eliminar la Fila Seleccionada?", "Mensaje", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            //ELIMINAR
            Eliminar();
        } else {
            JOptionPane.showMessageDialog(null, "Operación de Eliminación Cancelada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        agregarDatosTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cboSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSedeActionPerformed

        try {
            String des_sede = cboSede.getSelectedItem().toString();
            int id_sede = controladorSedes.obtenerId_descripcion(des_sede);
            lblIdSede.setText("" + id_sede);
        } catch (Exception e) {
            System.err.println("error en : " + e.getMessage());
        }
    }//GEN-LAST:event_cboSedeActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold 
        //</editor-fold>
        //</editor-fold 
        //</editor-fold>
        //</editor-fold 
        //</editor-fold>
        //</editor-fold 

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Form_Usuario dialog = new Form_Usuario(new javax.swing.JFrame(), true, 0, 0, 0);
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
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnNuevoPerfil;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox cboPerfil;
    private javax.swing.JComboBox cboSede;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdEmpresa;
    private javax.swing.JLabel lblIdPerfil;
    private javax.swing.JLabel lblIdSede;
    private javax.swing.JTable tblDetalle;
    private org.edisoncor.gui.passwordField.PasswordFieldRectBackground txtPassword;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtUsuario;
    // End of variables declaration//GEN-END:variables
}
