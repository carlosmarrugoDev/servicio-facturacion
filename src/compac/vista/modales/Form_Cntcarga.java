/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.vista.modales;

import compac.clases.controlador.CntcargaImpl;
import compac.clases.modelo.ObCntcarga;
import compac.clases.principales.ConfigGeneral;
import compac.clases.utilidades.FormatoTextField;
import compac.clases.utilidades.Validador_de_Campos;
import compac.vista.principal.alertas.Alerta;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Form_Cntcarga extends javax.swing.JDialog {

    ConfigGeneral config = new ConfigGeneral();
    CntcargaImpl mant_Cnt_carga = new CntcargaImpl(); //llamamos al mentenimiento general del objeto

    FormatoTextField JTF = new FormatoTextField();
    Validador_de_Campos validar = new Validador_de_Campos();

    private int opcion_visual = config.getOpcion_visual();
    int idrecepcionado = 0, ver = 0;
    private int id_usuarios, id_sedes; 

    public Form_Cntcarga(java.awt.Frame parent, boolean modal, int idrecepcionado, int ver, int id_usuarios, int id_sedes) {
        super(parent, modal);
        initComponents();
        this.id_usuarios = id_usuarios;
        this.id_sedes = id_sedes;

        this.setLocationRelativeTo(null);
        this.setTitle("REGISTRO DE CANTIDAD DE CARGA DE DATOS");
        this.idrecepcionado = idrecepcionado;
        this.ver = ver;
        JTF.modelo_1TF(txtCantidad, opcion_visual);
        lblIdEmpresa.setText(idrecepcionado + "");
        lblIdEmpresa.setVisible(false);
//emp.icono.general
        setIconImage(new ImageIcon(getClass().getResource("/compac/icono/general/logos.png")).getImage());
        validar.validarSoloNumeros(txtCantidad);
        if (idrecepcionado == 0) {
            txtCantidad.requestFocus();
        } else {
            mant_Cnt_carga.buscar_por_id(idrecepcionado);
            int cantidad = mant_Cnt_carga.getCnt_carga().getCantidad();
//            ////////////////////////////////////////////////////////////////////////////
            txtCantidad.setText(cantidad + "");
            txtCantidad.requestFocus();
            /////////////////////////////////////////////////////////////////////////////
        }
        if (ver == 1) {
            txtCantidad.setEnabled(false);
            btnRegistrar.setEnabled(false);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        LTABLA = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        lblIdEmpresa = new javax.swing.JLabel();
        txtCantidad = new org.edisoncor.gui.textField.TextFieldRectBackground();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        LTABLA.setText("jLabel1");
        jPanel4.add(LTABLA);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Cantidad de Carga de Datos *");

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

        lblIdEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtCantidad.setAnchoDeBorde(1.0F);
        txtCantidad.setDescripcion("Ingrese una descripción");
        txtCantidad.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblIdEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 243, Short.MAX_VALUE))
                    .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
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

    public int leeCantidad() {
        return Integer.parseInt(txtCantidad.getText());
    }

    public int leeId() {
        return Integer.parseInt(lblIdEmpresa.getText());
    }
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (txtCantidad.getText().equalsIgnoreCase("") || leeCantidad() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese una valor válido", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtCantidad.requestFocus();
            return;
        }
        try {
            if (idrecepcionado == 0) {

                String consulta = "Select cantidad from cntcarga where cantidad='" + leeCantidad() + "' and estado='1'";
                if (mant_Cnt_carga.valida_Campos(consulta)) {
                    JOptionPane.showMessageDialog(null, "La Cantidad ingresada ya existe.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    txtCantidad.setText("");
                    txtCantidad.requestFocusInWindow();
                    return;
                }
                ObCntcarga areas = new ObCntcarga(0, leeCantidad(), 1);
                mant_Cnt_carga.registrar(areas);

                int opcion = JOptionPane.showConfirmDialog(null, "Desea Realizar otro Registro?", "Mensaje", JOptionPane.OK_CANCEL_OPTION);
                if (opcion == JOptionPane.OK_OPTION) {
                    txtCantidad.setText("");
                    txtCantidad.requestFocusInWindow();
                } else {
                    this.dispose();
                }

                Alerta alert = new Alerta("Mensaje", "Registro Exitoso");
                alert.setVisible(true);
            } else {

                String consulta = "Select cantidad from cntcarga where cantidad='" + leeCantidad() + "' and "
                        + " id_cntcarga='" + leeId() + "'  and estado='1'";
                if (!mant_Cnt_carga.valida_Campos(consulta)) {
                    String consulta_reg = "Select cantidad from cntcarga where cantidad='" + leeCantidad() + "'";
                    if (mant_Cnt_carga.valida_Campos(consulta_reg)) {
                        JOptionPane.showMessageDialog(null, "La Cantidad ingresada ya existe.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        txtCantidad.setText("");
                        txtCantidad.requestFocusInWindow();
                        return;
                    }
                }

                ObCntcarga areas = new ObCntcarga(leeId(), leeCantidad(), 1);
                mant_Cnt_carga.actualizar(areas);
                this.dispose();
                Alerta alert = new Alerta("Mensaje", "Actualización Exitosa");
                alert.setVisible(true);
            }

        } catch (Exception e) {
            System.err.println("error al registrar area " + e.getLocalizedMessage());
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Cntcarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Cntcarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Cntcarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Cntcarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>    
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Form_Cntcarga dialog = new Form_Cntcarga(new javax.swing.JFrame(), true, 0, 0, 0, 0);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblIdEmpresa;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtCantidad;
    // End of variables declaration//GEN-END:variables
}
