/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.vista.modales.auxiliares;

import compac.clases.controlador.CategoriaImpl;
import compac.clases.controlador.Fac_cat3_umeidaImpl;
import compac.clases.controlador.Fac_cat7_igvImpl;
import compac.clases.controlador.MarcaImpl;
import compac.clases.modelo.ObCategoria;
import compac.clases.modelo.ObFac_cat3_umedida;
import compac.clases.modelo.ObFac_cat7_igv;
import compac.clases.modelo.ObMarca;
import compac.vista.modales.Form_Categoria;
import compac.vista.modales.Form_Marca;
import compac.vista.principal.alertas.AlertaError;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

public class VistaGeneral extends javax.swing.JDialog {

//    
//    SQL consulta = new SQL();
    private DefaultListModel modeloLista = new DefaultListModel();
    private String nombreTabla = "";
    private int id_sede = 0, id_usuario = 0;

    ArrayList<ObCategoria> lista_ObCategoria = null;
    CategoriaImpl controladorCategoria = new CategoriaImpl();

    ArrayList<ObMarca> lista_ObMarca = null;
    MarcaImpl controladorMarca = new MarcaImpl();

    ArrayList<ObFac_cat3_umedida> lista_ObFac_cat3_umedida = null;
    Fac_cat3_umeidaImpl controladorFac_cat3_umedida = new Fac_cat3_umeidaImpl();

    ArrayList<ObFac_cat7_igv> lista_ObFac_cat7_igv = null;
    Fac_cat7_igvImpl controladorFac_cat7_igv = new Fac_cat7_igvImpl();

    public static int respuesta = 0;
    public static int id_categoria = 0, id_marca = 0, id_fac_cat3_umedida = 0, id_fac_cat7_igv = 0;
    public static String descripcion_cateogria = "", descripcion_marca = "", descripcion_fac_cat3_umedida = "", descripcion_fac_cat7_igv = "";

    public VistaGeneral(java.awt.Frame parent, boolean modal, String titulo, String nombreTabla, int id_sede, int id_usuario) {
        super(parent, modal);
        initComponents();

        setIconImage(new ImageIcon(getClass().getResource("/compac/icono/general/logos.png")).getImage());

        this.nombreTabla = nombreTabla;
        this.id_sede = id_sede;
        this.id_usuario = id_usuario;
        respuesta = 0;

        if (nombreTabla.equalsIgnoreCase("fac_cat3_umedida") || nombreTabla.equalsIgnoreCase("fac_cat7_igv")) {
            btnNuevaCategoria.setEnabled(false);
        }

        opcionde_Muestra();
        this.setTitle("Buscar  -  " + titulo.toUpperCase());
        this.setLocationRelativeTo(null);

    }

    public void opcionde_Muestra() {

        if (nombreTabla.equalsIgnoreCase("categoria")) {

            lista_ObCategoria = (ArrayList<ObCategoria>) controladorCategoria.listarCnt(txtDescripcion.getText(), 30, id_sede);
            modeloLista.removeAllElements();
            for (int i = 0; i < lista_ObCategoria.size(); i++) {
                modeloLista.addElement(lista_ObCategoria.get(i).getDescripcion());//nombre es el campo de la base de datos 
                ListaElementos.setModel(modeloLista);
            }

        } else if (nombreTabla.equalsIgnoreCase("marca")) {

            lista_ObMarca = (ArrayList<ObMarca>) controladorMarca.listarCnt(txtDescripcion.getText(), 30, id_sede);
            modeloLista.removeAllElements();
            for (int i = 0; i < lista_ObMarca.size(); i++) {
                modeloLista.addElement(lista_ObMarca.get(i).getDescripcion());//nombre es el campo de la base de datos 
                ListaElementos.setModel(modeloLista);
            }

        } else if (nombreTabla.equalsIgnoreCase("fac_cat3_umedida")) {

            lista_ObFac_cat3_umedida = (ArrayList<ObFac_cat3_umedida>) controladorFac_cat3_umedida.listarCnt(txtDescripcion.getText(), 30);
            modeloLista.removeAllElements();
            for (int i = 0; i < lista_ObFac_cat3_umedida.size(); i++) {
                modeloLista.addElement(lista_ObFac_cat3_umedida.get(i).getDescripcion());//nombre es el campo de la base de datos 
                ListaElementos.setModel(modeloLista);
            }

        } else if (nombreTabla.equalsIgnoreCase("fac_cat7_igv")) {

            lista_ObFac_cat7_igv = (ArrayList<ObFac_cat7_igv>) controladorFac_cat7_igv.listarCnt(txtDescripcion.getText(), 30);
            modeloLista.removeAllElements();
            for (int i = 0; i < lista_ObFac_cat7_igv.size(); i++) {
                modeloLista.addElement(lista_ObFac_cat7_igv.get(i).getDescripcion());//nombre es el campo de la base de datos 
                ListaElementos.setModel(modeloLista);
            }

        }

        ListaElementos.setSelectedIndex(0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaElementos = new javax.swing.JList();
        txtDescripcion = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel2 = new javax.swing.JLabel();
        btnNuevaCategoria = new javax.swing.JButton();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ListaElementos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaElementosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListaElementos);

        txtDescripcion.setAnchoDeBorde(1.0F);
        txtDescripcion.setDescripcion("Ingrese una descripción");
        txtDescripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyReleased(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Decripción *");

        btnNuevaCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/nuevo_16px.png"))); // NOI18N
        btnNuevaCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased

        if (txtDescripcion.getText().length() % 3 == 0) {
            opcionde_Muestra();
        }

    }//GEN-LAST:event_txtDescripcionKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        respuesta = 0;
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        respuesta = 0;
    }//GEN-LAST:event_formWindowClosed

    private void ListaElementosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaElementosMouseClicked

        if (nombreTabla.equalsIgnoreCase("categoria")) {

            if (evt.getClickCount() == 2) {
                descripcion_cateogria = String.valueOf(ListaElementos.getSelectedValue());
                id_categoria = controladorCategoria.obtenerId_descripcion(descripcion_cateogria);
                respuesta = 1;
                dispose();
            }

        } else if (nombreTabla.equalsIgnoreCase("marca")) {

            if (evt.getClickCount() == 2) {
                descripcion_marca = String.valueOf(ListaElementos.getSelectedValue());
                id_marca = controladorMarca.obtenerId_descripcion(descripcion_marca);
                respuesta = 1;
                dispose();
            }

        } else if (nombreTabla.equalsIgnoreCase("fac_cat3_umedida")) {

            if (evt.getClickCount() == 2) {
                descripcion_fac_cat3_umedida = String.valueOf(ListaElementos.getSelectedValue());
                id_fac_cat3_umedida = controladorFac_cat3_umedida.obtenerId_descripcion(descripcion_fac_cat3_umedida);
                respuesta = 1;
                dispose();
            }

        } else if (nombreTabla.equalsIgnoreCase("fac_cat7_igv")) {

            if (evt.getClickCount() == 2) {
                descripcion_fac_cat7_igv = String.valueOf(ListaElementos.getSelectedValue());
                id_fac_cat7_igv = controladorFac_cat7_igv.obtenerId_descripcion(descripcion_fac_cat7_igv);
                respuesta = 1;
                dispose();
            }

        }


    }//GEN-LAST:event_ListaElementosMouseClicked

    private void btnNuevaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaCategoriaActionPerformed

        if (nombreTabla.equalsIgnoreCase("categoria")) {

            new Form_Categoria(null, true, 0, 0, id_usuario, id_sede).setVisible(true);
            if (Form_Categoria.valor == 1) {

//                // 1
//                opcionde_Muestra();
                //2
                int id_categoria_registro = controladorCategoria.obtenerEntero("Select max(id_categoria) from categoria where id_usuario='" + id_usuario + "' and id_sede='" + id_sede + "'");
                String categoria_registro = controladorCategoria.obtieneDescripcion_id(id_categoria_registro);

                descripcion_cateogria = categoria_registro;
                id_categoria = id_categoria_registro;
                respuesta = 1;
                dispose();

            } else {
                AlertaError alert = new AlertaError("Mensaje", "Operación Cancelada");
                alert.setVisible(true);
            }

        } else if (nombreTabla.equalsIgnoreCase("marca")) {

            new Form_Marca(null, true, 0, 0, id_usuario, id_sede).setVisible(true);
            if (Form_Marca.valor == 1) {

//                // 1
//                opcionde_Muestra();
                //2
                int id_marca_registro = controladorMarca.obtenerEntero("Select max(id_marca) from marca where id_usuario='" + id_usuario + "' and id_sede='" + id_sede + "'");
                String marca_registro = controladorMarca.obtieneDescripcion_id(id_marca_registro);

                descripcion_marca = marca_registro;
                id_marca = id_marca_registro;
                respuesta = 1;
                dispose();
            } else {
                AlertaError alert = new AlertaError("Mensaje", "Operación Cancelada");
                alert.setVisible(true);
            }

        }

    }//GEN-LAST:event_btnNuevaCategoriaActionPerformed

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
            java.util.logging.Logger.getLogger(VistaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VistaGeneral dialog = new VistaGeneral(new javax.swing.JFrame(), true, "", "", 0, 0);
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
    private javax.swing.JList ListaElementos;
    private javax.swing.JButton btnNuevaCategoria;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
