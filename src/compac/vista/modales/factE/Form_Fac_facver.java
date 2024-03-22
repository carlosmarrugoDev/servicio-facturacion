/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.vista.modales.factE;

import compac.clases.controlador.Fac_facverImpl;
import compac.clases.modelo.ObFac_facver;
import compac.clases.principales.ConfigGeneral;
import compac.clases.utilidades.FormatoTextField;
import compac.clases.utilidades.Validador_de_Campos;
import compac.vista.principal.alertas.Alerta;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Form_Fac_facver extends javax.swing.JDialog {

    ConfigGeneral config = new ConfigGeneral();
    Fac_facverImpl controladorFacver = new Fac_facverImpl(); //llamamos al mentenimiento general del objeto

    FormatoTextField JTF = new FormatoTextField();
    Validador_de_Campos validar = new Validador_de_Campos();

    private int opcion_visual = config.getOpcion_visual();
    int id_fac_facver = 0, ver = 0;
    private int id_usuarios, id_sedes;

    public Form_Fac_facver(java.awt.Frame parent, boolean modal, int id_fac_facver, int ver, int id_usuarios, int id_sedes) {
        super(parent, modal);
        initComponents();
        this.id_usuarios = id_usuarios;
        this.id_sedes = id_sedes;

        this.setLocationRelativeTo(null);
        this.setTitle("REGISTRO DE VERSIONES DEL FACTURADOR");
        this.id_fac_facver = id_fac_facver;
        this.ver = ver;
        JTF.modelo_1TF(txtDescripcion, opcion_visual);
        lblIdEmpresa.setText(id_fac_facver + "");
        lblIdEmpresa.setVisible(false);

        setIconImage(new ImageIcon(getClass().getResource("/compac/icono/general/logos.png")).getImage());

        if (id_fac_facver == 0) {
            txtDescripcion.requestFocus();
        } else {
            controladorFacver.buscar_por_id(id_fac_facver);
            String descripcion = controladorFacver.getObFac_facver().getDescripcion();
//            ////////////////////////////////////////////////////////////////////////////
            txtDescripcion.setText(descripcion + "");
            txtDescripcion.requestFocus();
            /////////////////////////////////////////////////////////////////////////////
        }
        if (ver == 1) {
            txtDescripcion.setEnabled(false);
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
        txtDescripcion = new org.edisoncor.gui.textField.TextFieldRectBackground();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        LTABLA.setText("jLabel1");
        jPanel4.add(LTABLA);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Versión del Facturación Electrónica *");

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

        txtDescripcion.setAnchoDeBorde(1.0F);
        txtDescripcion.setDescripcion("Ingrese una descripción");
        txtDescripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

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
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    public String leeDescripcion() {
        return txtDescripcion.getText();
    }

    public int leeId() {
        return Integer.parseInt(lblIdEmpresa.getText());
    }
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (txtDescripcion.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Ingrese una Descripción válida", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtDescripcion.requestFocus();
            return;
        }
        try {
            if (id_fac_facver == 0) {

                String consulta = "Select descripcion from fac_facver where descripcion='" + leeDescripcion() + "' and estado='1'";
                if (controladorFacver.valida_Campos(consulta)) {
                    JOptionPane.showMessageDialog(null, "La Versión de la Facturación ingresada ya existe.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    txtDescripcion.setText("");
                    txtDescripcion.requestFocusInWindow();
                    return;
                }
                ObFac_facver facver = new ObFac_facver(0, leeDescripcion(), 1);
                controladorFacver.registrar(facver);

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

                String consulta = "Select descripcion from fac_facver where descripcion='" + leeDescripcion() + "' and "
                        + " id_fac_facver='" + leeId() + "'  and estado='1'";
                if (!controladorFacver.valida_Campos(consulta)) {
                    String consulta_reg = "Select descripcion from fac_facver where descripcion='" + leeDescripcion() + "'";
                    if (controladorFacver.valida_Campos(consulta_reg)) {
                        JOptionPane.showMessageDialog(null, "La Versión de la Facturación ingresada ya existe.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        txtDescripcion.setText("");
                        txtDescripcion.requestFocusInWindow();
                        return;
                    }
                }

                ObFac_facver facver = new ObFac_facver(leeId(), leeDescripcion(), 1);
                controladorFacver.actualizar(facver);
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
            java.util.logging.Logger.getLogger(Form_Fac_facver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Fac_facver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Fac_facver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Fac_facver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>    
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Form_Fac_facver dialog = new Form_Fac_facver(new javax.swing.JFrame(), true, 0, 0, 0, 0);
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
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
