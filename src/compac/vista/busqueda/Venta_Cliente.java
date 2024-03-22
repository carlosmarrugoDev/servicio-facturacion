/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.vista.busqueda;

import compac.clases.controlador.ClienteImpl;
import compac.clases.modelo.ObCliente;
import compac.clases.principales.ConfigGeneral;
import compac.clases.utilidades.Colorear_Tablas;
import compac.clases.utilidades.FormatoCombox;
import compac.clases.utilidades.FormatoTextField;
import compac.clases.utilidades.ImgTabla;
import compac.vista.modales.Form_Cliente;
import compac.vista.modales.Form_Venta;
import compac.vista.principal.alertas.Alerta;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Venta_Cliente extends javax.swing.JDialog {

    ConfigGeneral config = new ConfigGeneral();
    private String ruta = config.getRuta();

    DefaultTableModel modelo = null;//creamos el modelo de la tabla 
    ArrayList<ObCliente> lista_ObCliente = null;// creamos la lista para el objeto 
    ClienteImpl controlador = null;//llamamos al mentenimiento general del objeto  

    FormatoTextField JTF = new FormatoTextField();
    Colorear_Tablas col = new Colorear_Tablas();
    FormatoCombox JCX = new FormatoCombox();

    private int opcion_visual = config.getOpcion_visual();
    private int id_usuario = 0, id_sede = 0;
    private String tipoDoc = "";
    public static int valor = 0;

    public Venta_Cliente(java.awt.Frame parent, boolean modal, int id_usuario, int id_sede, String tipoDoc) {
        super(parent, modal);
        initComponents();
        this.id_usuario = id_usuario;
        this.id_sede = id_sede;
        this.tipoDoc = tipoDoc;

        this.setLocationRelativeTo(null);
        controlador = new ClienteImpl();

        JTF.modelo_1TF(txtBusqueda, opcion_visual);
        tblDetalle.setDefaultRenderer(Object.class, new ImgTabla());
        valor = 0;
        mostrar_Tabla();
        Limpiar_Tabla();
        lista_ObCliente(leeCampo());

        setIconImage(new ImageIcon(getClass().getResource("/compac/icono/general/logos.png")).getImage());
        this.setTitle("BÚSQUEDA DE CLIENTES");
        this.setSize(750, 470);
//        cerrar();

        tblDetalle.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent Mouse_evt) {
                if (Mouse_evt.getClickCount() == 2) {
                    int fila = tblDetalle.getSelectedRow();
                    String id = tblDetalle.getValueAt(fila, 0).toString();
                    Form_Venta.lblIdCliente.setText(id);
                    valor = 1;
                    dispose();
                }
            }
        });

    }

    public void mostrar_Tabla() {
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        modelo.addColumn("#");
        modelo.addColumn("NOMBRES");
        modelo.addColumn("DOCUMENTO");
        modelo.addColumn("CORREO");
        modelo.addColumn("CELULAR");
        modelo.addColumn("");
        tblDetalle.setRowHeight(23);
        tblDetalle.setModel(modelo);
        tblDetalle.setBackground(Color.WHITE);
        tblDetalle.setAutoResizeMode(tblDetalle.AUTO_RESIZE_OFF);

        tblDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblDetalle.getColumnModel().getColumn(1).setPreferredWidth(260);
        tblDetalle.getColumnModel().getColumn(2).setPreferredWidth(110);
        tblDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        tblDetalle.getColumnModel().getColumn(4).setPreferredWidth(110);
        tblDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
    }

    public int leeIdSede() {
        return Integer.parseInt(lblIdSede.getText());
    }

    public void lista_ObCliente(String dato) {//LISTA TODAS EMPRESAS    
        lista_ObCliente = (ArrayList<ObCliente>) controlador.listarCnt(dato, 30, id_sede);
        int num = 0;
        Object datos[] = new Object[10];
        for (int i = 0; i < lista_ObCliente.size(); i++) {
            num++;

            datos[0] = (lista_ObCliente.get(i).getId_cliente()) + "";
            datos[1] = (lista_ObCliente.get(i).getNomcompleto()) + "";
            datos[2] = (lista_ObCliente.get(i).getNum_documento()) + "";
            datos[3] = (lista_ObCliente.get(i).getEmail()) + "";
            datos[4] = (lista_ObCliente.get(i).getCelular()) + "";

            ImageIcon iconoModi = new ImageIcon(getClass().getResource("/compac/icono/general/EditarTabla_40px.png"));
            Icon btnModificar = new ImageIcon(iconoModi.getImage().getScaledInstance(14, 14, Image.SCALE_DEFAULT));
            JButton botonModificar = new JButton("", btnModificar);
            botonModificar.setName("btnModificar");
            botonModificar.setToolTipText("Modificar Registro");
            datos[5] = botonModificar;

            modelo.addRow(datos);
        }
        lblCantidadDatos.setText("Cantidad de Datos Cargados: " + num);
    }

    /////LIMPIAR TABLA
    private void Limpiar_Tabla() {
        for (int i = 0; i < tblDetalle.getRowCount() - 1; i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    public String leeCampo() {
        return txtBusqueda.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        LTABLA = new javax.swing.JLabel();
        lblIdSede = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        txtBusqueda = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        lblCantidadDatos = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalle = new javax.swing.JTable();

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
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(java.awt.Color.white);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Búsqueda");
        jPanel6.add(jLabel2);

        jPanel5.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        jPanel11.setLayout(new java.awt.BorderLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new java.awt.GridLayout(1, 0));
        jPanel11.add(jPanel12, java.awt.BorderLayout.LINE_END);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new java.awt.GridLayout(1, 0));

        txtBusqueda.setAnchoDeBorde(1.0F);
        txtBusqueda.setDescripcion("Documento de Identidad");
        txtBusqueda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });
        jPanel13.add(txtBusqueda);

        jPanel11.add(jPanel13, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel11);

        jPanel5.add(jPanel7, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBackground(java.awt.Color.white);
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.GridLayout(1, 0));

        lblCantidadDatos.setText("Cantidad");
        jPanel10.add(lblCantidadDatos);

        jPanel9.add(jPanel10);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new java.awt.GridLayout(1, 0));
        jPanel14.add(jLabel3);
        jPanel14.add(jLabel4);
        jPanel14.add(jLabel5);
        jPanel14.add(jLabel7);
        jPanel14.add(jLabel9);
        jPanel14.add(jLabel10);
        jPanel14.add(jLabel11);

        jPanel9.add(jPanel14);

        jPanel8.add(jPanel9, java.awt.BorderLayout.PAGE_END);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new java.awt.GridLayout(1, 0));

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

        jPanel15.add(jScrollPane1);

        jPanel8.add(jPanel15, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2);

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

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased

        if (txtBusqueda.getText().length() % 3 == 0) {
            try {
                mostrar_Tabla();
                Limpiar_Tabla();
                lista_ObCliente(leeCampo());
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void tblDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetalleMouseClicked
        int fila = tblDetalle.getSelectedRow();
        String id_cliente = String.valueOf(tblDetalle.getValueAt(fila, 0));

        int colum = tblDetalle.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tblDetalle.getRowHeight();

        if (row < tblDetalle.getRowCount() && row >= 0 && colum < tblDetalle.getColumnCount() && colum >= 0) {
            Object value = tblDetalle.getValueAt(row, colum);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                if (boton.getName().equals("btnModificar")) {
                    int filas = tblDetalle.getSelectedRowCount();
                    if (filas == 0) {//si no elije ninguna fila
                        JOptionPane.showMessageDialog(null, "Debe de seleccionar una fila", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    } else {//cuando si seleciona

                        int id_clienteEditar = Integer.parseInt(id_cliente);
                        new Form_Cliente(null, true, id_clienteEditar, 0, "", id_usuario, id_sede).setVisible(true);
                        if (Form_Cliente.valor == 1) {
                            mostrar_Tabla();
                            Limpiar_Tabla();
                            lista_ObCliente(leeCampo());
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_tblDetalleMouseClicked

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
            java.util.logging.Logger.getLogger(Venta_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venta_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venta_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venta_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold      
        //</editor-fold>
        //</editor-fold      

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Venta_Cliente dialog = new Venta_Cliente(new javax.swing.JFrame(), true, 0, 0, "");
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidadDatos;
    private javax.swing.JLabel lblIdSede;
    private javax.swing.JTable tblDetalle;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
