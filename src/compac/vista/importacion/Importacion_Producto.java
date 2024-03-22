/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.vista.importacion;

import compac.clases.controlador.CategoriaImpl;
import compac.clases.controlador.ProductoImpl;
import compac.clases.controlador.SedeImpl;
import compac.clases.modelo.ObCategoria;
import compac.clases.modelo.ObProducto;
import compac.clases.modelo.ObSedes;
import compac.clases.principales.ConfigGeneral;
import compac.clases.utilidades.Colorear_Tablas;
import compac.clases.utilidades.CopiarCarpetas;
import compac.clases.utilidades.FormatoCombox;
import compac.clases.utilidades.FormatoTextField;
import compac.clases.utilidades.ImgTabla;
import compac.clases.utilidades.export_excel;
import compac.vista.principal.alertas.Alerta;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author LuisT
 */
public class Importacion_Producto extends javax.swing.JFrame {

    ConfigGeneral config = new ConfigGeneral();

    Colorear_Tablas col = new Colorear_Tablas();
    private JFileChooser FileChooser = new JFileChooser();
    DefaultTableModel modelo = null;//creamos el modelo de la tabla

    ArrayList<ObSedes> lista_ObSedes = null;// creamos la lista para el objeto
    SedeImpl controladorSedes = new SedeImpl();//llamamos al mentenimiento general del objeto

    ArrayList<ObProducto> lista_ObProducto = null;// creamos la lista para el objeto 
    ProductoImpl controlador = null;//llamamos al mentenimiento general del objeto  
    CategoriaImpl controladorCategoria = null;//llamamos al mentenimiento general del objeto 

    FormatoTextField JTF = new FormatoTextField();
    FormatoCombox JCX = new FormatoCombox();

    private int opcion_visual = config.getOpcion_visual();
    private int id_usuarios;
    Vector columna = new Vector();
    Vector filas = new Vector();

    public Importacion_Producto() {
        initComponents();

        controlador = new ProductoImpl();
        controladorCategoria = new CategoriaImpl();

        JTF.modelo_1TF(txtBusqueda, opcion_visual);
        tblImportar.setDefaultRenderer(Object.class, new ImgTabla());
        this.setSize(870, 600);

        txtBusqueda.requestFocusInWindow();
        lista_Sedes();

        mostrar_Tabla();
        Limpiar_Tabla();
        cerrar();
        setIconImage(new ImageIcon(getClass().getResource("/compac/icono/general/logos.png")).getImage());
        this.setTitle("IMPORTACIÓN Y GENERACIÓN DE FORMATO DE PRODUCTOS");

    }

    //RELIZAMOS LA CARGA DE DATOS PARA EL COMBO DE LECTURA 
    public void lista_Sedes() {//LISTA TODAS EMPRESAS 
        lista_ObSedes = (ArrayList<ObSedes>) controladorSedes.listar();
        cboSede.removeAllItems();
        for (int i = 0; i < lista_ObSedes.size(); i++) {
            cboSede.addItem(lista_ObSedes.get(i).getDescripcion());
        }
    }

    public void cerrar() {
        try {
            this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
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

    public int leeIdSede() {
        return Integer.parseInt(lblIdSede.getText());
    }

    public void mostrar_Tabla() {
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        modelo.addColumn("#");
        modelo.addColumn("CATEGORÍA");
        modelo.addColumn("CÓDIGO");
        modelo.addColumn("DESC_PRODUCTO");
        modelo.addColumn("PRECIO_VENTA");
        modelo.addColumn("UBICACIÓN");
        tblImportar.setRowHeight(18);
        tblImportar.setModel(modelo);

        tblImportar.setAutoResizeMode(tblImportar.AUTO_RESIZE_ALL_COLUMNS);

    }

    public void lista_ObProducto(String dato) {//LISTA TODAS EMPRESAS   
        lista_ObProducto = (ArrayList<ObProducto>) controlador.listar(leeIdSede());
        for (int i = 0; i < lista_ObProducto.size(); i++) {

            Object datos[] = new Object[7];

            datos[0] = (lista_ObProducto.get(i).getId_producto()) + "";
            datos[1] = controladorCategoria.obtieneDescripcion_id(lista_ObProducto.get(i).getId_categoria()) + "";
            datos[2] = (lista_ObProducto.get(i).getCodigo());
            datos[3] = (lista_ObProducto.get(i).getDescripcion());
            datos[4] = (lista_ObProducto.get(i).getPrecio());
            datos[5] = (lista_ObProducto.get(i).getUbicacion());

            modelo.addRow(datos);
        }
    }

    /////LIMPIAR TABLA
    private void Limpiar_Tabla() {
        for (int i = 0; i < tblImportar.getRowCount() - 1; i++) {
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

        lblIdSede = new javax.swing.JLabel();
        jDialog = new javax.swing.JDialog();
        txtRuta = new javax.swing.JTextField();
        btnGuardarExel = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtAceptarExportar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        txtBusqueda = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cboSede = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblImportar = new javax.swing.JTable();

        btnGuardarExel.setText("Guardar en ../ Save");
        btnGuardarExel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarExelActionPerformed(evt);
            }
        });

        txtAceptarExportar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAceptarExportar.setForeground(new java.awt.Color(204, 0, 0));
        txtAceptarExportar.setText("Aceptar");
        txtAceptarExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAceptarExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogLayout = new javax.swing.GroupLayout(jDialog.getContentPane());
        jDialog.getContentPane().setLayout(jDialogLayout);
        jDialogLayout.setHorizontalGroup(
            jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarExel)
                .addGap(19, 19, 19))
            .addGroup(jDialogLayout.createSequentialGroup()
                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jLabel16))
                    .addGroup(jDialogLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(txtAceptarExportar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialogLayout.setVerticalGroup(
            jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarExel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAceptarExportar)
                .addContainerGap(198, Short.MAX_VALUE))
        );

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
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/buscar_16px.png"))); // NOI18N
        jButton4.setText("Importar Archivo");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton4);

        jButton5.setForeground(new java.awt.Color(51, 51, 51));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/gerencia_16px.png"))); // NOI18N
        jButton5.setText("Registrar Datos Masivamente");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton5);

        jPanel11.add(jPanel12, java.awt.BorderLayout.LINE_END);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new java.awt.GridLayout(1, 0));

        txtBusqueda.setEditable(false);
        txtBusqueda.setAnchoDeBorde(1.0F);
        txtBusqueda.setDescripcion("Ruta de Archivo");
        txtBusqueda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel13.add(txtBusqueda);

        jPanel11.add(jPanel13, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel11);

        jPanel4.add(jPanel6, java.awt.BorderLayout.CENTER);

        jButton6.setForeground(new java.awt.Color(51, 51, 51));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/reportes_16px.png"))); // NOI18N
        jButton6.setText("Generar Formato de Importación");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setForeground(new java.awt.Color(51, 51, 51));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Empresas_Gen16px.png"))); // NOI18N
        jButton7.setText("Exportar Lista Existente de Datos");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/caducidad_16px.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Sede *");

        cboSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSedeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboSede, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboSede, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.GridLayout(1, 0));
        jPanel7.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.GridLayout(1, 0));
        jPanel7.add(jPanel10);

        jPanel3.add(jPanel7, java.awt.BorderLayout.PAGE_END);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        tblImportar.setForeground(new java.awt.Color(255, 255, 255));
        tblImportar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblImportar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblImportar.setFillsViewportHeight(true);
        tblImportar.setGridColor(new java.awt.Color(247, 247, 247));
        tblImportar.setSelectionBackground(new java.awt.Color(0, 102, 153));
        tblImportar.getTableHeader().setReorderingAllowed(false);
        tblImportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblImportarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblImportar);

        jPanel8.add(jScrollPane1);

        jPanel3.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        mostrar_Tabla();
        Limpiar_Tabla();

        try {
            //
            // TODO add your handling code here:
            FileChooser.showDialog(null, "Importar Hoja ");
            File file = FileChooser.getSelectedFile();
            if (file.getName().endsWith("xls") || file.getName().endsWith("xlsx")) {
                int numero = tblImportar.getColumnCount();
//                System.out.println("nnumero : " + numero);
                if (numero > 11) {
                    JOptionPane.showMessageDialog(null, "Número de columnas excedido ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    jButton4.requestFocusInWindow();
                    Limpiar_Tabla();
                } else {
                    String fl = file.toString();
                    txtBusqueda.setText(fl);
                    export_excel ex = new export_excel();
                    ex.Importar(file, tblImportar);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un archivo excel...", "Error", JOptionPane.ERROR_MESSAGE);

            }
        } catch (Exception e) {
            System.out.println("error en  : " + e.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    public void CrearTabla(File file) throws IOException {
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(file);
            Sheet sheet = workbook.getSheet(0);

            columna.clear();

            for (int i = 0; i < sheet.getColumns(); i++) {
                Cell cell = sheet.getCell(i, 0);
                columna.add(cell.getContents());
            }
            filas.clear();

            for (int j = 1; j < sheet.getRows(); j++) {
                Vector d = new Vector();
                for (int i = 0; i < sheet.getColumns(); i++) {
                    Cell cell = sheet.getCell(i, j);
                    d.add(cell.getContents());
                }
                d.add("\n");
                filas.add(d);
            }

        } catch (BiffException e) {
            e.printStackTrace();
        }
    }


    private void tblImportarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblImportarMouseClicked

    }//GEN-LAST:event_tblImportarMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        int totalRow = tblImportar.getRowCount();
        if (totalRow > 0) {

            int opcion = JOptionPane.showConfirmDialog(null, "Desea continuar con el registro masivo de Productos? .", "Mensaje", JOptionPane.OK_CANCEL_OPTION);
            if (opcion == JOptionPane.OK_OPTION) {

                //REGISTRAMOS LOS DATOS MASIVAMENTE
                int num = 0, num_dni = 0;
                for (int i = 0; i < (totalRow); i++) {
                    String descripcion = (tblImportar.getValueAt(i, 1).toString());

                    String consulta = "Select descripcion from producto where  "
                            + " descripcion='" + descripcion + "' and estado='1'  ";
                    if (!controlador.valida_Campos(consulta)) {
                        num++;
                        String categoria = (tblImportar.getValueAt(i, 2).toString());
                        String codigo = (tblImportar.getValueAt(i, 3).toString());

                        int idCategoria = 0;
                        int id_categoriaFinal = controladorCategoria.obtenerEntero("select id_categoria from categoria where descripcion='" + categoria + "'");

                        if (id_categoriaFinal == 0) {
                            ObCategoria cat = new ObCategoria(0, categoria.toUpperCase(), 1, id_usuarios, leeIdSede());
                            controladorCategoria.registrar(cat);
                            idCategoria = controladorCategoria.obtenerEntero("select id_categoria from categoria where descripcion='" + categoria + "'");
                        } else {
                            idCategoria = id_categoriaFinal;
                        }

                        int id_categoria = idCategoria;
                        double precio = Double.parseDouble(tblImportar.getValueAt(i, 4).toString());
                        int estado = 1;
                        String ubicacion = (tblImportar.getValueAt(i, 5).toString());

                        ObProducto prod = new ObProducto(0, id_categoria, descripcion, codigo, precio, estado,
                                ubicacion, id_usuarios, leeIdSede(), 0, 0, 0);
                        controlador.registrar(prod);

                    } else {
                        num_dni++;
                    }

                }
                JOptionPane.showMessageDialog(null, num_dni + " Números de Productos Existentes.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, num + " Registros realizados Exitosamente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                mostrar_Tabla();
                Limpiar_Tabla();
            } else {
                Alerta alert = new Alerta("Mensaje", "Operación Cancelada");
                alert.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Importe la Hoja de Excell para poder Realizar el Registro Masivo.", "Mensajes", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnGuardarExelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarExelActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_btnGuardarExelActionPerformed

    private void txtAceptarExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAceptarExportarActionPerformed

    }//GEN-LAST:event_txtAceptarExportarActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            // TODO add your handling code here:
            FileChooser.showDialog(null, "Generar");

            File file = FileChooser.getSelectedFile();
            String fl = file.toString();

            File original = new File(config.getRuta() + "\\Archivos\\Importaciones\\Formato_Productos");
            File copia = new File(fl);

            //LLAMAMOS A LAS CLASES PARA PODER UTILIZAR EL COPIADO DE ARCHIVOS
            CopiarCarpetas cop_carpeta = new CopiarCarpetas();
            cop_carpeta.copiar_directorios(original, copia);

            JOptionPane.showMessageDialog(null, "Archivos Generados Exitosamente en :\n"
                    + fl, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("ERROR EN : " + e.getMessage());
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            mostrar_Tabla();
            Limpiar_Tabla();
            lista_ObProducto(leeCampo());

            export_excel exel = new export_excel();
            String ruta = System.getProperty("user.home") + "/LISTADO_DE_PRODUCTOS.xls";
            Alerta alert = new Alerta("Mensaje", exel.exportar_a_exel("LISTADO_DE_PRODUCTOS", tblImportar, ruta));
            alert.setVisible(true);
        } catch (Exception e) {
            System.err.println(".------- " + e.getMessage());
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(null, "Recordar que si ha cargado la Lista de sus productos con la descripción de \n"
                + "una Categoría que no existe en su Base de Datos, este se creará como nuevo, además se asignará al producto respectivo.\n"
                + "Recuerde también que si la descripción de un producto ya existe este como tal, no será registrado dentro del Sistema.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cboSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSedeActionPerformed

        try {
            String des_producto = cboSede.getSelectedItem().toString();
            int id_sede = controladorSedes.obtenerId_descripcion(des_producto);
            lblIdSede.setText("" + id_sede);
            try {
                mostrar_Tabla();
                Limpiar_Tabla();
                lista_ObProducto(leeCampo());
                txtBusqueda.setText("");
                txtBusqueda.requestFocusInWindow();
            } catch (Exception e) {
            }
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
            java.util.logging.Logger.getLogger(Importacion_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Importacion_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Importacion_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Importacion_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold> 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Importacion_Producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarExel;
    private javax.swing.JComboBox cboSede;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JDialog jDialog;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JLabel lblIdSede;
    private javax.swing.JTable tblImportar;
    private javax.swing.JButton txtAceptarExportar;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtBusqueda;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables
}
