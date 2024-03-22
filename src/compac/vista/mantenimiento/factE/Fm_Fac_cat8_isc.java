/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.vista.mantenimiento.factE;

import compac.clases.controlador.CntcargaImpl;
import compac.clases.controlador.Fac_cat8_iscImpl;
import compac.clases.modelo.ObCntcarga;
import compac.clases.modelo.ObFac_cat8_isc;
import compac.clases.principales.ConfigGeneral;
import compac.clases.utilidades.Colorear_Tablas;
import compac.clases.utilidades.FormatoCombox;
import compac.clases.utilidades.FormatoTextField;
import compac.clases.utilidades.ImgTabla;
import compac.vista.modales.factE.Form_Fac_cat8_isc;
import compac.vista.principal.alertas.Alerta;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LuisT
 */
public class Fm_Fac_cat8_isc extends javax.swing.JFrame {

    ConfigGeneral config = new ConfigGeneral();
    private String ruta = config.getRuta();

    DefaultTableModel modelo = null;//creamos el modelo de la tabla 
    ArrayList<ObFac_cat8_isc> lista_ObFac_cat8_isc = null;// creamos la lista para el objeto 
    Fac_cat8_iscImpl controlador = new Fac_cat8_iscImpl();

    ArrayList<ObCntcarga> lista_ObCntcarga = null;// creamos la lista para el objeto
    CntcargaImpl mant_CntcargaImpl = new CntcargaImpl();//llamamos al mentenimiento general del objeto

    FormatoTextField JTF = new FormatoTextField();
    Colorear_Tablas col = new Colorear_Tablas();
    FormatoCombox JCX = new FormatoCombox();

    private int opcion_visual = config.getOpcion_visual();

    public Fm_Fac_cat8_isc() {
        initComponents();

        JTF.modelo_1TF(txtBusqueda, opcion_visual);
        JCX.modelo_1CBX(cboCnt_Carga);
        lblIdTipodoc.setVisible(false);
        tblDetalle.setDefaultRenderer(Object.class, new ImgTabla());
        this.setSize(870, 600);

        txtBusqueda.requestFocusInWindow();
        mostrar_Tabla();
        Limpiar_Tabla();
        lista_ObClienteDato();

        setIconImage(new ImageIcon(getClass().getResource("/compac/icono/general/logos.png")).getImage());
        this.setTitle("REGISTRO Y MANTENIMIENTO DE CATÁLOGO 8 - SIST. DE CÀLCULO DEL ISC");

        cerrar();
        txtBusqueda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrar_Tabla();
                Limpiar_Tabla();
                lista_ObFac_cat8_isc(leeCampo());
                txtBusqueda.setText("");
                txtBusqueda.requestFocusInWindow();
            }
        });

    }

    //RELIZAMOS LA CARGA DE DATOS PARA EL COMBO DE LECTURA 
    public void lista_ObClienteDato() {//LISTA TODAS EMPRESAS 
        lista_ObCntcarga = (ArrayList<ObCntcarga>) mant_CntcargaImpl.listar();
        cboCnt_Carga.removeAllItems();
        for (int i = 0; i < lista_ObCntcarga.size(); i++) {
            cboCnt_Carga.addItem(lista_ObCntcarga.get(i).getCantidad());
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
        modelo.addColumn("CÓDIGO");
        modelo.addColumn("DESCRIPCIÓN");
        modelo.addColumn("ESTADO");
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
        tblDetalle.setRowHeight(26);
        tblDetalle.setModel(modelo);
        tblDetalle.setBackground(Color.WHITE);
        tblDetalle.setAutoResizeMode(tblDetalle.AUTO_RESIZE_OFF);

        tblDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        tblDetalle.getColumnModel().getColumn(2).setPreferredWidth(500);
        tblDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        tblDetalle.getColumnModel().getColumn(4).setPreferredWidth(28);
        tblDetalle.getColumnModel().getColumn(5).setPreferredWidth(28);
        tblDetalle.getColumnModel().getColumn(6).setPreferredWidth(28);
        tblDetalle.getColumnModel().getColumn(7).setPreferredWidth(28);
        tblDetalle.getColumnModel().getColumn(8).setPreferredWidth(28);
    }

    public void lista_ObFac_cat8_isc(String dato) {//LISTA TODAS EMPRESAS  
        int cnt_carga = Integer.parseInt(cboCnt_Carga.getSelectedItem().toString());
        lista_ObFac_cat8_isc = (ArrayList<ObFac_cat8_isc>) controlador.listarCnt(dato, cnt_carga);
        int num = 0;
        for (int i = 0; i < lista_ObFac_cat8_isc.size(); i++) {
            num++;
            Object datos[] = new Object[10];

            datos[0] = (lista_ObFac_cat8_isc.get(i).getId_fac_cat8_isc()) + "";
            datos[1] = (lista_ObFac_cat8_isc.get(i).getCodigo()) + "";
            datos[2] = (lista_ObFac_cat8_isc.get(i).getDescripcion()) + "";
            if (lista_ObFac_cat8_isc.get(i).getEstado_view() == 1) {
                JLabel mensaje = new JLabel("ACTIVO", (int) CENTER_ALIGNMENT);
                datos[3] = mensaje;
            } else {
                JLabel mensaje = new JLabel("INACTIVO", (int) CENTER_ALIGNMENT);
                datos[3] = mensaje;
            }
            //BOTON MODIFICAR emp.icono.general
            ImageIcon iconoModi = new ImageIcon(getClass().getResource("/compac/icono/general/EditarTabla_40px.png"));
            Icon btnModificar = new ImageIcon(iconoModi.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));
            JButton botonModificar = new JButton("", btnModificar);
            botonModificar.setName("btnModificar");
            botonModificar.setToolTipText("Modificar Registro");

            datos[4] = botonModificar;
            //BOTON NUEVO
            ImageIcon icono = new ImageIcon(getClass().getResource("/compac/icono/general/EliminarTabla_40px.png"));
            Icon btnEliminar = new ImageIcon(icono.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));
            JButton botonEliminar = new JButton("", btnEliminar);
            botonEliminar.setName("btnEliminar");
            botonEliminar.setToolTipText("Eliminar Registro");

            datos[5] = botonEliminar;

            //BOTON VER
            ImageIcon iconoVer = new ImageIcon(getClass().getResource("/compac/icono/general/VerTabla_40px.png"));
            Icon btnVer = new ImageIcon(iconoVer.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));
            JButton botonVer = new JButton("", btnVer);
            botonVer.setName("btnVer");
            botonVer.setToolTipText("Ver Registro");
            datos[6] = botonVer;

            //BOTON VER
            ImageIcon iconoAct = new ImageIcon(getClass().getResource("/compac/icono/general/admUser_16px.png"));
            Icon btnAct = new ImageIcon(iconoAct.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));
            JButton botonAct = new JButton("", btnAct);
            botonAct.setName("botonAct");
            botonAct.setToolTipText("Activar Registro");
            datos[7] = botonAct;

            //BOTON VER 
            ImageIcon iconoDesAct = new ImageIcon(getClass().getResource("/compac/icono/general/Delete Shield_16px.png"));
            Icon btnDesAct = new ImageIcon(iconoDesAct.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));
            JButton botonDesAct = new JButton("", btnDesAct);
            botonDesAct.setName("botonDesAct");
            botonDesAct.setToolTipText("Desactivar Registro");
            datos[8] = botonDesAct;

            modelo.addRow(datos);
            lblCantidadDatos.setText("Cantidad de Datos Cargados: " + num);
        }
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

        lblIdTipodoc = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        txtBusqueda = new org.edisoncor.gui.textField.TextFieldRectBackground();
        cboCnt_Carga = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        lblCantidadDatos = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalle = new javax.swing.JTable();

        lblIdTipodoc.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(java.awt.Color.white);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Búsqueda");
        jPanel5.add(jLabel2);

        jPanel4.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jPanel11.setLayout(new java.awt.BorderLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new java.awt.GridLayout(1, 0));

        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/buscar_16px.png"))); // NOI18N
        jButton4.setText("Limpiar");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton4);

        jPanel11.add(jPanel12, java.awt.BorderLayout.LINE_END);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new java.awt.GridLayout(1, 0));

        txtBusqueda.setAnchoDeBorde(1.0F);
        txtBusqueda.setDescripcion("Ingrese una descripción y Preciona ENTER");
        txtBusqueda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel13.add(txtBusqueda);

        jPanel11.add(jPanel13, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel11);

        jPanel4.add(jPanel6, java.awt.BorderLayout.CENTER);

        cboCnt_Carga.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboCnt_Carga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cboCnt_CargaMouseEntered(evt);
            }
        });
        cboCnt_Carga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCnt_CargaActionPerformed(evt);
            }
        });

        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/nuevo_16px.png"))); // NOI18N
        jButton1.setMnemonic('N');
        jButton1.setText(" Nuevo");
        jButton1.setToolTipText("Realizar Nuevo Registro");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboCnt_Carga, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboCnt_Carga, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        lblCantidadDatos.setText("Cantidad");
        jPanel9.add(lblCantidadDatos);

        jPanel7.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.GridLayout(1, 0));
        jPanel10.add(jLabel3);
        jPanel10.add(jLabel4);
        jPanel10.add(jLabel5);
        jPanel10.add(jLabel7);
        jPanel10.add(jLabel9);
        jPanel10.add(jLabel10);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/pdf.png"))); // NOI18N
        jButton2.setToolTipText("Exportación en Formato Excell");
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton2);

        jPanel7.add(jPanel10);

        jPanel3.add(jPanel7, java.awt.BorderLayout.PAGE_END);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

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

        jPanel8.add(jScrollPane1);

        jPanel3.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboCnt_CargaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboCnt_CargaMouseEntered

    }//GEN-LAST:event_cboCnt_CargaMouseEntered

    private void cboCnt_CargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCnt_CargaActionPerformed
        try {
            mostrar_Tabla();
            Limpiar_Tabla();
            lista_ObFac_cat8_isc(leeCampo());
            txtBusqueda.setText("");
            txtBusqueda.requestFocusInWindow();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cboCnt_CargaActionPerformed

    private void tblDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetalleMouseClicked
        int fila = tblDetalle.getSelectedRow();
        String id = String.valueOf(tblDetalle.getValueAt(fila, 0));
        lblIdTipodoc.setText(id);

        int colum = tblDetalle.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tblDetalle.getRowHeight();

        if (row < tblDetalle.getRowCount() && row >= 0 && colum < tblDetalle.getColumnCount() && colum >= 0) {
            Object value = tblDetalle.getValueAt(row, colum);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                if (boton.getName().equals("btnEliminar")) {
                    int filas = tblDetalle.getSelectedRowCount();
                    if (filas == 0) {//si no elije ninguna fila
                        JOptionPane.showMessageDialog(null, "Debe de seleccionar una fila", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    } else {//cuando si seleciona
                        String valor = String.valueOf(tblDetalle.getValueAt(fila, 2));
                        int opcion = JOptionPane.showConfirmDialog(null, "Realmente desea eliminar el Tipo de Moneda " + valor + "?", "Mensaje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (opcion == JOptionPane.OK_OPTION) {
                            int id_fac_cat2_moneda = Integer.parseInt(lblIdTipodoc.getText());
                            controlador.eliminar(id_fac_cat2_moneda);

                            txtBusqueda.requestFocus();
                            mostrar_Tabla();
                            Limpiar_Tabla();
                            lista_ObClienteDato();
                            Alerta alert = new Alerta("Mensaje", "Eliminación Exitosa");
                            alert.setVisible(true);

                        } else {
                            txtBusqueda.requestFocus();
                            Alerta alert = new Alerta("Mensaje", "Operación Cancelada");
                            alert.setVisible(true);
                        }
                    }
                } else if (boton.getName().equals("btnModificar")) {
                    int filas = tblDetalle.getSelectedRowCount();
                    if (filas == 0) {//si no elije ninguna fila
                        JOptionPane.showMessageDialog(null, "Debe de seleccionar una fila", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    } else {//cuando si seleciona

                        int id_fac_cat2_moneda = Integer.parseInt(lblIdTipodoc.getText());
                        new Form_Fac_cat8_isc(this, true, id_fac_cat2_moneda, 0).setVisible(true);
                        mostrar_Tabla();
                        Limpiar_Tabla();
                        lista_ObClienteDato();

                    }
                } else if (boton.getName().equals("btnVer")) {
                    int filas = tblDetalle.getSelectedRowCount();
                    if (filas == 0) {//si no elije ninguna fila
                        JOptionPane.showMessageDialog(null, "Debe de seleccionar una fila", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    } else {//cuando si seleciona

                        int id_fac_cat2_moneda = Integer.parseInt(lblIdTipodoc.getText());
                        new Form_Fac_cat8_isc(this, true, id_fac_cat2_moneda, 1).setVisible(true);
                        mostrar_Tabla();
                        Limpiar_Tabla();
                        lista_ObClienteDato();

                    }
                } else if (boton.getName().equals("botonAct")) {
                    int filas = tblDetalle.getSelectedRowCount();
                    if (filas == 0) {//si no elije ninguna fila
                        JOptionPane.showMessageDialog(null, "Debe de seleccionar una fila", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    } else {//cuando si seleciona 

                        String valor = String.valueOf(tblDetalle.getValueAt(fila, 2));
                        int id_fac_cat2_moneda = Integer.parseInt(lblIdTipodoc.getText());
                        int activar = JOptionPane.showConfirmDialog(null, "Desea Activar el Registro de " + valor + " ?", "Mensaje", JOptionPane.OK_CANCEL_OPTION);

                        if (activar == JOptionPane.OK_OPTION) {
                            controlador.actualizarActivar(id_fac_cat2_moneda);
                            Alerta alert = new Alerta("Mensaje", "Actualización Exitosa");
                            alert.setVisible(true);
                        } else {
                            txtBusqueda.requestFocus();
                            Alerta alert = new Alerta("Mensaje", "Operación Cancelada");
                            alert.setVisible(true);
                        }
                        mostrar_Tabla();
                        Limpiar_Tabla();
                        lista_ObClienteDato();

                    }
                } else if (boton.getName().equals("botonDesAct")) {
                    int filas = tblDetalle.getSelectedRowCount();
                    if (filas == 0) {//si no elije ninguna fila
                        JOptionPane.showMessageDialog(null, "Debe de seleccionar una fila", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    } else {//cuando si seleciona  

                        String valor = String.valueOf(tblDetalle.getValueAt(fila, 2));
                        int id_fac_cat2_moneda = Integer.parseInt(lblIdTipodoc.getText());
                        int activar = JOptionPane.showConfirmDialog(null, "Desea Desactivar el Registro de " + valor + " ?", "Mensaje", JOptionPane.OK_CANCEL_OPTION);

                        if (activar == JOptionPane.OK_OPTION) {
                            controlador.actualizarDesactivar(id_fac_cat2_moneda);
                            Alerta alert = new Alerta("Mensaje", "Actualización Exitosa");
                            alert.setVisible(true);
                        } else {
                            txtBusqueda.requestFocus();
                            Alerta alert = new Alerta("Mensaje", "Operación Cancelada");
                            alert.setVisible(true);
                        }
                        mostrar_Tabla();
                        Limpiar_Tabla();
                        lista_ObClienteDato();

                    }
                }

            }
        }
    }//GEN-LAST:event_tblDetalleMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        new Form_Fac_cat8_isc(this, true, 0, 0).setVisible(true);
        mostrar_Tabla();
        Limpiar_Tabla();
        lista_ObClienteDato();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            txtBusqueda.setText("");
            txtBusqueda.requestFocusInWindow();
            mostrar_Tabla();
            Limpiar_Tabla();
            lista_ObFac_cat8_isc(leeCampo());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    public void cerrar() {
        try {
            this.setDefaultCloseOperation(Fm_Fac_cat8_isc.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent w) {
                    confirmarSalida();
                }
            });
            this.setVisible(true);
        } catch (Exception e) {
            System.err.println("error en " + e);
        }
    }

    public void confirmarSalida() {
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea cerrar la ventana de trabajo?", "Mensaje", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            this.dispose();
        } else {
            Alerta alert = new Alerta("Mensaje", "Operación Cancelada");
            alert.setVisible(true);
        }
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
            java.util.logging.Logger.getLogger(Fm_Fac_cat8_isc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fm_Fac_cat8_isc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fm_Fac_cat8_isc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fm_Fac_cat8_isc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold> 
        //</editor-fold>
        //</editor-fold>
        //</editor-fold> 
        //</editor-fold>
        //</editor-fold>
        //</editor-fold> 
        //</editor-fold>
        //</editor-fold>
        //</editor-fold> 
        //</editor-fold>
        //</editor-fold>
        //</editor-fold> 
        //</editor-fold>
        //</editor-fold>
        //</editor-fold> 
        //</editor-fold>
        //</editor-fold>
        //</editor-fold> 
        //</editor-fold>
        //</editor-fold>
        //</editor-fold> 
        //</editor-fold>
        //</editor-fold>
        //</editor-fold> 
        //</editor-fold>
        //</editor-fold>
        //</editor-fold> 
        //</editor-fold>
        //</editor-fold>
        //</editor-fold> 
        //</editor-fold>
        //</editor-fold>
        //</editor-fold> 
        //</editor-fold>
        //</editor-fold>
        //</editor-fold> 
        //</editor-fold>
        //</editor-fold>
        //</editor-fold> 
        //</editor-fold>
        //</editor-fold>
        //</editor-fold> 
        //</editor-fold>
        //</editor-fold>
        //</editor-fold> 

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fm_Fac_cat8_isc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboCnt_Carga;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel lblIdTipodoc;
    private javax.swing.JTable tblDetalle;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
