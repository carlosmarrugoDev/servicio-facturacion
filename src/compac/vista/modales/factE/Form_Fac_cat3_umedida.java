/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.vista.modales.factE;

import compac.clases.controlador.Fac_cat3_umeidaImpl;
import compac.clases.modelo.ObFac_cat3_umedida;
import compac.clases.principales.ConfigGeneral;
import compac.clases.utilidades.FormatoTextField;
import compac.clases.utilidades.Validador_de_Campos;
import compac.vista.principal.alertas.Alerta;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Form_Fac_cat3_umedida extends javax.swing.JDialog {

    ConfigGeneral config = new ConfigGeneral();
    Fac_cat3_umeidaImpl controlador = new Fac_cat3_umeidaImpl(); //llamamos al mentenimiento general del objeto

    FormatoTextField JTF = new FormatoTextField();
    Validador_de_Campos validar = new Validador_de_Campos();

    private int opcion_visual = config.getOpcion_visual();
    int idrecepcionado = 0, ver = 0;
//        this.id_usuarios=id_usuarios;
//        this.id_sedes=id_usuarios;

    public Form_Fac_cat3_umedida(java.awt.Frame parent, boolean modal, int idrecepcionado, int ver) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);
        this.setTitle("REGISTRO DE CATÁLOGO 3 - UNIDADES DE MEDIDA");
        this.idrecepcionado = idrecepcionado;
        this.ver = ver;
        JTF.modelo_1TF(txtCodigoInternacional, opcion_visual);
        JTF.modelo_1TF(txtDescripcionInternacional, opcion_visual);
        JTF.modelo_1TF(txtCodigoLocal, opcion_visual);
        lblIdEmpresa.setText(idrecepcionado + "");
        lblIdEmpresa.setVisible(false);
//emp.icono.general
        setIconImage(new ImageIcon(getClass().getResource("/compac/icono/general/logos.png")).getImage());
//        validar.validarSoloNumeros(txtDescripcion);
        if (idrecepcionado == 0) {
            txtCodigoInternacional.requestFocus();
        } else {
            controlador.buscar_por_id(idrecepcionado);
            String codigoInter = controlador.getObFac_cat3().getCodigo_inter();
            String nombreInter = controlador.getObFac_cat3().getNombre_inter();
            String codigo = controlador.getObFac_cat3().getCodigo();
            String descripcion = controlador.getObFac_cat3().getDescripcion();
//            ////////////////////////////////////////////////////////////////////////////
            txtCodigoInternacional.setText(codigoInter + "");
            txtDescripcionInternacional.setText("" + nombreInter);
            txtCodigoLocal.setText(codigo + "");
            txtDescripcionLocal.setText("" + descripcion);
            txtCodigoInternacional.requestFocus();
            /////////////////////////////////////////////////////////////////////////////
        }
        if (ver == 1) {
            txtCodigoInternacional.setEnabled(false);
            txtDescripcionInternacional.setEnabled(false);
            txtCodigoLocal.setEnabled(false);
            txtDescripcionLocal.setEnabled(false);
            btnRegistrar.setEnabled(false);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        LTABLA = new javax.swing.JLabel();
        lblIdEmpresa = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCodigoInternacional = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtDescripcionInternacional = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel4 = new javax.swing.JLabel();
        txtCodigoLocal = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel5 = new javax.swing.JLabel();
        txtDescripcionLocal = new org.edisoncor.gui.textField.TextFieldRectBackground();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        LTABLA.setText("jLabel1");
        jPanel4.add(LTABLA);

        lblIdEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Código Internacional *");

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
        jLabel3.setText("Decripción Internacional *");

        txtCodigoInternacional.setAnchoDeBorde(1.0F);
        txtCodigoInternacional.setDescripcion("Ingrese el código");
        txtCodigoInternacional.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtDescripcionInternacional.setAnchoDeBorde(1.0F);
        txtDescripcionInternacional.setDescripcion("Ingrese su descripción");
        txtDescripcionInternacional.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Código Local *");

        txtCodigoLocal.setAnchoDeBorde(1.0F);
        txtCodigoLocal.setDescripcion("Ingrese su descripción");
        txtCodigoLocal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCodigoLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoLocalActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Decripción Local *");

        txtDescripcionLocal.setAnchoDeBorde(1.0F);
        txtDescripcionLocal.setDescripcion("Ingrese su descripción");
        txtDescripcionLocal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCodigoInternacional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDescripcionInternacional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCodigoLocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDescripcionLocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigoInternacional, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcionInternacional, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcionLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
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

    public String leeDescripcionInternacional() {
        return txtDescripcionInternacional.getText().toUpperCase();
    }

    public int leeId() {
        return Integer.parseInt(lblIdEmpresa.getText());
    }

    public String leeCodigoInternacional() {
        return txtCodigoInternacional.getText().toUpperCase();
    }

    public String leeCodigoLocal() {
        return txtCodigoLocal.getText();
    }

    public String leeDescripcionLocal() {
        return txtDescripcionLocal.getText().toUpperCase();
    }
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (txtCodigoInternacional.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Ingrese un Código Internacional válido", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtCodigoInternacional.requestFocus();
            return;
        }
        if (txtDescripcionInternacional.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Ingrese una Descripción Internacional válida", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtDescripcionInternacional.requestFocus();
            return;
        }
        if (txtCodigoLocal.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Ingrese un Código Local válido", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtCodigoLocal.requestFocus();
            return;
        }
        if (txtDescripcionLocal.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Ingrese una Descripción Local válida", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtDescripcionLocal.requestFocus();
            return;
        }
        try {
            if (idrecepcionado == 0) {
                String consulta = "Select descripcion from fac_cat3_umedida where descripcion='" + leeDescripcionLocal() + "' ";
                if (controlador.valida_Campos(consulta)) {
                    JOptionPane.showMessageDialog(null, "La Descripción ingresada ya existe.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    txtDescripcionLocal.setText("");
                    txtDescripcionLocal.requestFocusInWindow();
                    return;
                }
                ObFac_cat3_umedida cat3_umedida = new ObFac_cat3_umedida(0, leeCodigoInternacional(), leeDescripcionInternacional(),
                        leeCodigoLocal(), leeDescripcionLocal(), 1);
                controlador.registrar(cat3_umedida);

                int opcion = JOptionPane.showConfirmDialog(null, "Desea Realizar otro Registro?", "Mensaje", JOptionPane.OK_CANCEL_OPTION);
                if (opcion == JOptionPane.OK_OPTION) {
                    txtCodigoInternacional.setText("");
                    txtDescripcionInternacional.setText("");
                    txtCodigoLocal.setText("");
                    txtDescripcionLocal.setText("");
                    txtCodigoInternacional.requestFocusInWindow();
                } else {
                    this.dispose();
                }

                Alerta alert = new Alerta("Mensaje", "Registro Exitoso");
                alert.setVisible(true);
            } else {

                String consulta = "Select descripcion from fac_cat3_umedida where descripcion='" + leeDescripcionLocal() + "' and "
                        + " id_fac_cat3_umedida='" + leeId() + "'  ";
                if (!controlador.valida_Campos(consulta)) {
                    String consulta_reg = "Select descripcion from fac_cat3_umedida where descripcion='" + leeDescripcionLocal() + "'";
                    if (controlador.valida_Campos(consulta_reg)) {
                        JOptionPane.showMessageDialog(null, "La Descripción ingresada ya existe.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        txtCodigoInternacional.setText("");
                        txtDescripcionInternacional.setText("");
                        txtCodigoLocal.setText("");
                        txtDescripcionLocal.setText("");
                        txtCodigoInternacional.requestFocusInWindow();
                        return;
                    }
                }

                ObFac_cat3_umedida cat3_umedida = new ObFac_cat3_umedida(leeId(), leeCodigoInternacional(), leeDescripcionInternacional(),
                        leeCodigoLocal(), leeDescripcionLocal(), 1);
                controlador.actualizar(cat3_umedida);
                this.dispose();
                Alerta alert = new Alerta("Mensaje", "Actualización Exitosa");
                alert.setVisible(true);
            }

        } catch (Exception e) {
            System.err.println("error al registrar fac_cat3_umedida " + e.getLocalizedMessage());
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtLongitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLongitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLongitudActionPerformed

    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionKeyReleased

    private void txtLongitudKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLongitudKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLongitudKeyReleased

    private void txtCodigoLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoLocalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoLocalActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Fac_cat3_umedida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Fac_cat3_umedida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Fac_cat3_umedida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Fac_cat3_umedida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold   
        //</editor-fold 
        //</editor-fold>
        //</editor-fold   
        //</editor-fold 

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Form_Fac_cat3_umedida dialog = new Form_Fac_cat3_umedida(new javax.swing.JFrame(), true, 0, 0);
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
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblIdEmpresa;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtCodigoInternacional;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtCodigoLocal;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDescripcionInternacional;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDescripcionLocal;
    // End of variables declaration//GEN-END:variables
}
