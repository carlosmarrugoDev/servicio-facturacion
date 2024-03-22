/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.vista.mensajeria;

import compac.clases.controlador.SedeImpl;
import compac.clases.principales.ConfigGeneral;
import compac.clases.utilidades.FormatoTextField;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class List_WsspMensaje extends javax.swing.JDialog {

    ConfigGeneral config = new ConfigGeneral();

    SedeImpl controladorSede = new SedeImpl();
    FormatoTextField JTF = new FormatoTextField();
    private int opcion_visual = config.getOpcion_visual();
    int id_cliente = 0, id_sedes = 0;

    java.util.Date utilDate = new java.util.Date(); //fecha actual
    long lnMilisegundos = utilDate.getTime();
    java.sql.Time Time = new java.sql.Time(lnMilisegundos);

    private int id_sede;

    public List_WsspMensaje(java.awt.Frame parent, boolean modal, int id_cliente,
            String telefono, String nombre, int id_sede) {
        super(parent, modal);
        initComponents();
        this.id_sede = id_sede;

        JTF.modelo_1TF(txtNombre, opcion_visual);
        JTF.modelo_1TF(txtCelular, opcion_visual);

        txtCelular.setText(telefono);
        txtNombre.setText(nombre);
        txtSalida.setLineWrap(true);
        txtSalida.setWrapStyleWord(true);

        txtCelular.setEditable(false);
        txtNombre.setEditable(false);
        txtSalida.requestFocusInWindow();

        this.setLocationRelativeTo(null);
        this.setTitle("ENVÍO DE MENSAJES POR WSSP");
        this.id_cliente = id_cliente;

        setIconImage(new ImageIcon(getClass().getResource("/compac/icono/general/logos.png")).getImage());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        LTABLA = new javax.swing.JLabel();
        lblIdEmpresa = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnEnviar1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSalida = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtCelular = new org.edisoncor.gui.textField.TextFieldRectBackground();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        LTABLA.setText("jLabel1");
        jPanel4.add(LTABLA);

        lblIdEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Celular *");

        btnEnviar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/WhatsApp_16px.png"))); // NOI18N
        btnEnviar1.setText("Enviar");
        btnEnviar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnviar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviar1ActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Cliente *");

        txtSalida.setColumns(20);
        txtSalida.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtSalida.setRows(5);
        jScrollPane1.setViewportView(txtSalida);

        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Ingresar Mensaje *");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(199, 28, 28));
        jLabel1.setText("***No ingresar tildes o símbolos extraños.");

        txtNombre.setEditable(false);
        txtNombre.setAnchoDeBorde(1.0F);
        txtNombre.setDescripcion("Ingrese una descripción");
        txtNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtCelular.setEditable(false);
        txtCelular.setAnchoDeBorde(1.0F);
        txtCelular.setDescripcion("Ingrese una descripción");
        txtCelular.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEnviar1))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
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

    public int leeId() {
        return Integer.parseInt(lblIdEmpresa.getText());
    }
//mes

    public void enviarWssp(JTextField num, JTextArea salida) {
        try {

            String msmPension = salida.getText();

            String cliente = txtNombre.getText();
            String numero = num.getText();
            String mensaje = "Sr(a) " + cliente;

            String empresa = controladorSede.obtieneDescripcion_id(id_sede);
            String msmTotal = empresa + " Informa: " + mensaje + ". " + msmPension;

//        System.err.println("msmPension: "+msmTotal);
            String url = "https://wa.me/51" + numero + "?text= " + msmTotal;
            try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Error: " + err);
            }
        } catch (Exception e) {
            System.err.println("error en: " + e.getMessage());
        }
    }
    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed

    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void btnEnviar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviar1ActionPerformed
        if (txtCelular.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "El Cliente Seleccionado no Presenta un Número de Celular Registrado como Válido.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtCelular.requestFocusInWindow();
            return;
        }
        if (txtSalida.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un Mensaje a enviar al Cliente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtSalida.requestFocusInWindow();
            return;
        }
        int longiCel = 9;

        int longitudCel = txtCelular.getText().length();
        if (longitudCel < longiCel) {
            JOptionPane.showMessageDialog(null, "El Número de Celular es Incorrecto, debe de contener 9 dígitos.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        enviarWssp(txtCelular, txtSalida);
    }//GEN-LAST:event_btnEnviar1ActionPerformed

    private void txtCelularKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyReleased

    }//GEN-LAST:event_txtCelularKeyReleased

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
            java.util.logging.Logger.getLogger(List_WsspMensaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(List_WsspMensaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(List_WsspMensaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(List_WsspMensaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold  
        //</editor-fold> 

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                List_WsspMensaje dialog = new List_WsspMensaje(new javax.swing.JFrame(), true, 0, "", "",0);
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
    private javax.swing.JButton btnEnviar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdEmpresa;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtCelular;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtNombre;
    private javax.swing.JTextArea txtSalida;
    // End of variables declaration//GEN-END:variables
}
