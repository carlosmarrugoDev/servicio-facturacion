/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the e ditor.
 */
package compac.vista.modales;

import compac.clases.controlador.CategoriaImpl;
import compac.clases.controlador.Fac_cat3_umeidaImpl;
import compac.clases.controlador.Fac_cat7_igvImpl;
import compac.clases.controlador.MarcaImpl;
import compac.clases.controlador.ProductoImpl;
import compac.clases.modelo.ObCategoria;
import compac.clases.modelo.ObProducto;
import compac.clases.principales.Archivos_Planos;
import compac.clases.principales.ConfigGeneral;
import compac.clases.utilidades.FormatoCombox;
import compac.clases.utilidades.FormatoTextField;
import compac.clases.utilidades.Validador_de_Campos;
import compac.vista.modales.auxiliares.VistaGeneral;
import compac.vista.principal.alertas.AlertaBien;
import compac.vista.principal.alertas.AlertaError;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Form_Producto extends javax.swing.JDialog {

    ConfigGeneral config = new ConfigGeneral();
    ProductoImpl controlador = new ProductoImpl(); //llamamos al mentenimiento general del objeto  
    ArrayList<ObCategoria> lista_ObCategoria = null;// creamos la lista para el objeto 
    CategoriaImpl controladorCategoria = null;//llamamos al mentenimiento general del objeto 
    MarcaImpl controladorMarca = new MarcaImpl();

    Fac_cat3_umeidaImpl controladorFac_cat3_umeidaImpl = new Fac_cat3_umeidaImpl();
    Fac_cat7_igvImpl controladorFac_cat7_igvImpl = new Fac_cat7_igvImpl();

    Archivos_Planos arc = new Archivos_Planos();
    private String ruta = config.getRuta();
    FormatoTextField JTF = new FormatoTextField();
    Validador_de_Campos validar = new Validador_de_Campos();
    FormatoCombox JCX = new FormatoCombox();

    private int opcion_visual = config.getOpcion_visual();
    int idproducto = 0, ver = 0;
    String foto = "", origen = "", destino = "";
    private int id_usuario = 0, id_sede = 0;

    public Form_Producto(java.awt.Frame parent, boolean modal, int idproducto,
            int ver, int id_usuario, int id_sede) {
        super(parent, modal);
        initComponents();
        controladorCategoria = new CategoriaImpl();
        this.id_usuario = id_usuario;
        this.id_sede = id_sede;

        this.setLocationRelativeTo(null);
        this.setTitle("REGISTRO DE PRODUCTOS / SERVICIOS");
        this.idproducto = idproducto;
        this.ver = ver;
        JTF.modelo_1TF(txtDescripcion, opcion_visual);
        JTF.modelo_1TF(txtPrecio, opcion_visual);
        JTF.modelo_1TF(txtUbicacion, opcion_visual);
        JTF.modelo_1TF(txtCodigo, opcion_visual);

        lblIdEmpresa.setText(idproducto + "");
        lblIdEmpresa.setVisible(false);

        setIconImage(new ImageIcon(getClass().getResource("/compac/icono/general/logos.png")).getImage());

        if (idproducto == 0) {
            btnBuscarCategoria.requestFocus();
        } else {
            controlador.buscar_por_id(idproducto);
            int id_producto = controlador.getObProducto().getId_producto();
            int id_categoria = controlador.getObProducto().getId_categoria();
            int id_marca = controlador.getObProducto().getId_marca();
            int id_fac_cat3_umedida = controlador.getObProducto().getId_fac_cat3_umedida();
            int id_fac_fac_cat7_igv = controlador.getObProducto().getId_fac_cat7_igv();
            String descripcion = controlador.getObProducto().getDescripcion();
            String codigo = controlador.getObProducto().getCodigo();
            double precio = controlador.getObProducto().getPrecio();
            String ubicacion = controlador.getObProducto().getUbicacion();
//            String categoria = controlador.getObProducto().getCategoria();
//            ////////////////////////////////////////////////////////////////////////////
            txtDescripcion.setText(descripcion + "");
            txtPrecio.setText(precio + "");
            txtUbicacion.setText(ubicacion);
            txtCodigo.setText(codigo);
            lblIdEmpresa.setText("" + id_producto);

            String des_categoria = controladorCategoria.obtieneDescripcion_id(id_categoria);
            txtDescripcionCategoria.setText(des_categoria);
            lblIdCategoria.setText("" + id_categoria);

            String des_marca = controladorMarca.obtieneDescripcion_id(id_marca);
            txtDescripcionMarca.setText(des_marca);
            lblIdMarca.setText("" + id_marca);

            String des_fac_cat3_umedida = controladorFac_cat3_umeidaImpl.obtieneDescripcion_id(id_fac_cat3_umedida);
            txtDescripcionUniMedida.setText(des_fac_cat3_umedida);
            lblIdUniMedida.setText("" + id_fac_cat3_umedida);

            String des_fac_fac_cat7_igv = controladorFac_cat7_igvImpl.obtieneDescripcion_id(id_fac_fac_cat7_igv);
            txtDescripcionAfectacion.setText(des_fac_fac_cat7_igv);
            lblIdAfectacion.setText("" + id_fac_fac_cat7_igv);
            /////////////////////////////////////////////////////////////////////////////
        }

        if (ver == 1) {

            btnBuscarUniMedida.setEnabled(false);
            btnBuscarAfectacion.setEnabled(false);

            txtCodigo.setEnabled(false);
            btnNuevaCategoria.setEnabled(false);
            txtDescripcion.setEnabled(false);
            txtPrecio.setEnabled(false);
            txtUbicacion.setEnabled(false);
            btnBuscarCategoria.setEnabled(false);
            btnRegistrar.setEnabled(false);
            btnNuevaCategoria.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        LTABLA = new javax.swing.JLabel();
        lblIdEmpresa = new javax.swing.JLabel();
        lblIdCategoria = new javax.swing.JLabel();
        lblIdMarca = new javax.swing.JLabel();
        lblIdUniMedida = new javax.swing.JLabel();
        lblIdAfectacion = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPrecio = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtCodigo = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtUbicacion = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel4 = new javax.swing.JLabel();
        txtDescripcion = new org.edisoncor.gui.textField.TextFieldRectBackground();
        btnBuscarCategoria = new javax.swing.JButton();
        txtDescripcionCategoria = new org.edisoncor.gui.textField.TextFieldRectBackground();
        btnNuevaCategoria = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnBuscarMarca = new javax.swing.JButton();
        txtDescripcionMarca = new org.edisoncor.gui.textField.TextFieldRectBackground();
        btnNuevaMarca = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnBuscarUniMedida = new javax.swing.JButton();
        txtDescripcionUniMedida = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel7 = new javax.swing.JLabel();
        txtDescripcionAfectacion = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel8 = new javax.swing.JLabel();
        btnBuscarAfectacion = new javax.swing.JButton();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        LTABLA.setText("jLabel1");
        jPanel4.add(LTABLA);

        lblIdEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
        jLabel3.setText("Precio *");

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Ubicación");

        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Código");

        txtPrecio.setAnchoDeBorde(1.0F);
        txtPrecio.setDescripcion("Precio de Venta");
        txtPrecio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtCodigo.setAnchoDeBorde(1.0F);
        txtCodigo.setDescripcion("Código de Barra");
        txtCodigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtUbicacion.setAnchoDeBorde(1.0F);
        txtUbicacion.setDescripcion("Ingrese una descripción");
        txtUbicacion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Decripción *");

        txtDescripcion.setAnchoDeBorde(1.0F);
        txtDescripcion.setDescripcion("Ingrese una descripción");
        txtDescripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnBuscarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/buscar_16px.png"))); // NOI18N
        btnBuscarCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCategoriaActionPerformed(evt);
            }
        });

        txtDescripcionCategoria.setEditable(false);
        txtDescripcionCategoria.setAnchoDeBorde(1.0F);
        txtDescripcionCategoria.setDescripcion("Descripción de Categoria");
        txtDescripcionCategoria.setEnabled(false);
        txtDescripcionCategoria.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnNuevaCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/nuevo_16px.png"))); // NOI18N
        btnNuevaCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaCategoriaActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Categoría *");

        btnBuscarMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/buscar_16px.png"))); // NOI18N
        btnBuscarMarca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMarcaActionPerformed(evt);
            }
        });

        txtDescripcionMarca.setEditable(false);
        txtDescripcionMarca.setAnchoDeBorde(1.0F);
        txtDescripcionMarca.setDescripcion("Descripción de Marca");
        txtDescripcionMarca.setEnabled(false);
        txtDescripcionMarca.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnNuevaMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/nuevo_16px.png"))); // NOI18N
        btnNuevaMarca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevaMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaMarcaActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Marca *");

        btnBuscarUniMedida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/buscar_16px.png"))); // NOI18N
        btnBuscarUniMedida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarUniMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUniMedidaActionPerformed(evt);
            }
        });

        txtDescripcionUniMedida.setEditable(false);
        txtDescripcionUniMedida.setAnchoDeBorde(1.0F);
        txtDescripcionUniMedida.setDescripcion("Descripción de Unidades de Medida");
        txtDescripcionUniMedida.setEnabled(false);
        txtDescripcionUniMedida.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Unidades de Medida *");

        txtDescripcionAfectacion.setEditable(false);
        txtDescripcionAfectacion.setAnchoDeBorde(1.0F);
        txtDescripcionAfectacion.setDescripcion("Descripción de Tipo de Afectación");
        txtDescripcionAfectacion.setEnabled(false);
        txtDescripcionAfectacion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Tipo de Afectaciión");

        btnBuscarAfectacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/buscar_16px.png"))); // NOI18N
        btnBuscarAfectacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarAfectacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAfectacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(674, 674, 674)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtDescripcionCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtDescripcionMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNuevaMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtDescripcionUniMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarUniMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtDescripcionAfectacion, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarAfectacion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(421, 421, 421)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(457, 457, 457)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcionCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcionMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevaMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(6, 6, 6)
                            .addComponent(txtDescripcionUniMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(btnBuscarUniMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(6, 6, 6)
                            .addComponent(txtDescripcionAfectacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(btnBuscarAfectacion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoKeyReleased

    public String leeDescripcion() {
        return txtDescripcion.getText();
    }

    public String leeCoodigo() {
        return txtCodigo.getText();
    }

    public String leeUbicacion() {
        return txtUbicacion.getText().toUpperCase();
    }

    public int leeId() {
        return Integer.parseInt(lblIdEmpresa.getText());
    }

    public double leePrecio() {
        return Double.parseDouble(txtPrecio.getText());
    }

    public int leeIdCategoria() {
        return Integer.parseInt(lblIdCategoria.getText());
    }

    public int leeIdMarca() {
        return Integer.parseInt(lblIdMarca.getText());
    }

    public int leeIdFac_cat3_Unimedida() {
        return Integer.parseInt(lblIdUniMedida.getText());
    }

    public int leeIdFac_cat7_Igv() {
        return Integer.parseInt(lblIdAfectacion.getText());
    }
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (txtDescripcionCategoria.getText().equalsIgnoreCase("")) {
            txtDescripcionCategoria.requestFocus();
            AlertaError alert = new AlertaError("Mensaje", "Seleccione una Categoría Válida.");
            alert.setVisible(true);
            return;
        }

        if (txtDescripcionMarca.getText().equalsIgnoreCase("")) {
            txtDescripcionMarca.requestFocus();
            AlertaError alert = new AlertaError("Mensaje", "Seleccione una Categoría Válida.");
            alert.setVisible(true);
            return;
        }

        if (txtDescripcionUniMedida.getText().equalsIgnoreCase("")) {
            txtDescripcionUniMedida.requestFocus();
            AlertaError alert = new AlertaError("Mensaje", "Seleccione una Unidad de Medida Válida.");
            alert.setVisible(true);
            return;
        }

        if (txtDescripcionAfectacion.getText().equalsIgnoreCase("")) {
            txtDescripcionAfectacion.requestFocus();
            AlertaError alert = new AlertaError("Mensaje", "Seleccione un Tipo de Afectación Válido.");
            alert.setVisible(true);
            return;
        }

        if (txtDescripcion.getText().equalsIgnoreCase("")) {
            txtDescripcion.requestFocus();
            AlertaError alert = new AlertaError("Mensaje", "Ingrese la Descripción del Producto o Servicio.");
            alert.setVisible(true);
            return;
        }

        if (txtPrecio.getText().equalsIgnoreCase("")) {
            txtPrecio.requestFocus();
            AlertaError alert = new AlertaError("Mensaje", "Ingrese un Precio de Venta válido");
            alert.setVisible(true);
            return;
        }

        try {
            if (idproducto == 0) {

                String consulta = "Select codigo from producto where "
                        + " descripcion='" + leeDescripcion() + "' and estado='1'   and id_sede='" + id_sede + "' ";
                if (controlador.valida_Campos(consulta)) {
                    JOptionPane.showMessageDialog(null, "El Producto o Servicio ingresado ya existe.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                    txtPrecio.setText("");
                    txtUbicacion.setText("");
                    txtCodigo.setText("");
                    txtDescripcion.requestFocusInWindow();
                    return;
                }
                ObProducto producto = new ObProducto(0, leeIdCategoria(), leeDescripcion(), leeCoodigo(), leePrecio(), 1, leeUbicacion(),
                        id_usuario, id_sede, leeIdMarca(), leeIdFac_cat3_Unimedida(), leeIdFac_cat7_Igv());
                controlador.registrar(producto);

                int opcion = JOptionPane.showConfirmDialog(null, "Desea Realizar otro Registro?", "Mensaje", JOptionPane.OK_CANCEL_OPTION);
                if (opcion == JOptionPane.OK_OPTION) {

                    txtDescripcionCategoria.setText("");
                    txtDescripcionMarca.setText("");
                    txtDescripcionUniMedida.setText("");
                    txtDescripcionAfectacion.setText("");

                    txtPrecio.setText("");
                    txtUbicacion.setText("");
                    txtCodigo.setText("");
                    txtDescripcion.requestFocusInWindow();
                } else {
                    this.dispose();
                }

                AlertaBien alert = new AlertaBien("Mensaje", "Registro Exitoso");
                alert.setVisible(true);
            } else {

                String consulta = "Select codigo from producto where  descripcion='" + leeDescripcion() + "' and "
                        + " id_producto='" + leeId() + "'  and estado='1'   and id_sede='" + id_sede + "'";
                if (!controlador.valida_Campos(consulta)) {

                    String consulta_reg = "Select codigo from producto where "
                            + "  descripcion='" + leeDescripcion() + "' and estado='1'   and id_sede='" + id_sede + "'";
                    if (controlador.valida_Campos(consulta_reg)) {
                        JOptionPane.showMessageDialog(null, "El Producto o Servicio ingresado ya existe.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                        txtDescripcion.requestFocusInWindow();
                        return;
                    }
                }

                ObProducto producto = new ObProducto(leeId(), leeIdCategoria(), leeDescripcion(), leeCoodigo(), leePrecio(), 1, leeUbicacion(),
                        id_usuario, id_sede, leeIdMarca(), leeIdFac_cat3_Unimedida(), leeIdFac_cat7_Igv());
                controlador.actualizar(producto);

                this.dispose();
                AlertaBien alert = new AlertaBien("Mensaje", "Registro Exitoso");
                alert.setVisible(true);
            }

        } catch (Exception e) {
            AlertaError alert = new AlertaError("Mensaje", "Error de Registro de Productos");
            alert.setVisible(true);
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtPreCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPreCompraKeyTyped

    }//GEN-LAST:event_txtPreCompraKeyTyped

    private void txtPrecio2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecio2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecio2KeyTyped

    private void txtPreVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPreVentaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPreVentaKeyTyped

    private void txtCodigoBarraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoBarraKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoBarraKeyTyped

    private void txtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyReleased

    }//GEN-LAST:event_txtPrecioKeyReleased

    private void txtCodigoBarraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroDocumento1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDocumento1KeyReleased

    private void txtUbicacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUbicacionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUbicacionKeyReleased

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && txtPrecio.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void btnBuscarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCategoriaActionPerformed

        new VistaGeneral(null, true, "CATEGORÍAS", "categoria", id_sede, id_usuario).setVisible(true);
        if (VistaGeneral.respuesta == 1) {

            txtDescripcionCategoria.setText(VistaGeneral.descripcion_cateogria);
            lblIdCategoria.setText("" + VistaGeneral.id_categoria);

            AlertaBien alert = new AlertaBien("Mensaje", "Selección de Categoría Correcta");
            alert.setVisible(true);
        } else {
            AlertaError alert = new AlertaError("Mensaje", "Operación Cancelada");
            alert.setVisible(true);

        }
    }//GEN-LAST:event_btnBuscarCategoriaActionPerformed

    private void btnNuevaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaCategoriaActionPerformed

        new Form_Categoria(null, true, 0, 0, id_usuario, id_sede).setVisible(true);
        if (Form_Categoria.valor == 1) {

            int id_categoria = controladorCategoria.obtenerEntero("Select max(id_categoria) from categoria where id_usuario='" + id_usuario + "' and id_sede='" + id_sede + "'");
            String categoria = controladorCategoria.obtieneDescripcion_id(id_categoria);

            txtDescripcionCategoria.setText(categoria);
            lblIdCategoria.setText("" + id_categoria);

        } else {
            AlertaError alert = new AlertaError("Mensaje", "Operación Cancelada");
            alert.setVisible(true);
        }
    }//GEN-LAST:event_btnNuevaCategoriaActionPerformed

    private void btnBuscarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMarcaActionPerformed

        new VistaGeneral(null, true, "MARCAS", "marca", id_sede, id_usuario).setVisible(true);
        if (VistaGeneral.respuesta == 1) {

            txtDescripcionMarca.setText(VistaGeneral.descripcion_marca);
            lblIdMarca.setText("" + VistaGeneral.id_marca);

            AlertaBien alert = new AlertaBien("Mensaje", "Selección de Marca Correcta");
            alert.setVisible(true);
        } else {
            AlertaError alert = new AlertaError("Mensaje", "Operación Cancelada");
            alert.setVisible(true);

        }
    }//GEN-LAST:event_btnBuscarMarcaActionPerformed

    private void btnNuevaMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaMarcaActionPerformed

        new Form_Marca(null, true, 0, 0, id_usuario, id_sede).setVisible(true);
        if (Form_Marca.valor == 1) {

            int id_marca = controladorMarca.obtenerEntero("Select max(id_marca) from marca where id_usuario='" + id_usuario + "' and id_sede='" + id_sede + "'");
            String marca = controladorMarca.obtieneDescripcion_id(id_marca);

            txtDescripcionMarca.setText(marca);
            lblIdMarca.setText("" + id_marca);

        } else {
            AlertaError alert = new AlertaError("Mensaje", "Operación Cancelada");
            alert.setVisible(true);
        }

    }//GEN-LAST:event_btnNuevaMarcaActionPerformed

    private void btnBuscarUniMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUniMedidaActionPerformed

        new VistaGeneral(null, true, "UNIDADES DE MEDIDA", "fac_cat3_umedida", id_sede, id_usuario).setVisible(true);
        if (VistaGeneral.respuesta == 1) {

            txtDescripcionUniMedida.setText(VistaGeneral.descripcion_fac_cat3_umedida);
            lblIdUniMedida.setText("" + VistaGeneral.id_fac_cat3_umedida);

            AlertaBien alert = new AlertaBien("Mensaje", "Selección de Categoría Correcta");
            alert.setVisible(true);
        } else {
            AlertaError alert = new AlertaError("Mensaje", "Operación Cancelada");
            alert.setVisible(true);

        }
    }//GEN-LAST:event_btnBuscarUniMedidaActionPerformed

    private void btnBuscarAfectacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAfectacionActionPerformed

        new VistaGeneral(null, true, "TIPOS DE AFECTACIÓN", "fac_cat7_igv", id_sede, id_usuario).setVisible(true);
        if (VistaGeneral.respuesta == 1) {

            txtDescripcionAfectacion.setText(VistaGeneral.descripcion_fac_cat7_igv);
            lblIdAfectacion.setText("" + VistaGeneral.id_fac_cat7_igv);

            AlertaBien alert = new AlertaBien("Mensaje", "Selección de Categoría Correcta");
            alert.setVisible(true);
        } else {
            AlertaError alert = new AlertaError("Mensaje", "Operación Cancelada");
            alert.setVisible(true);

        }

    }//GEN-LAST:event_btnBuscarAfectacionActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold 
        //</editor-fold>  
        //</editor-fold>
        //</editor-fold 

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Form_Producto dialog = new Form_Producto(new javax.swing.JFrame(), true, 0, 0, 0, 0);
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
    private javax.swing.JButton btnBuscarAfectacion;
    private javax.swing.JButton btnBuscarCategoria;
    private javax.swing.JButton btnBuscarMarca;
    private javax.swing.JButton btnBuscarUniMedida;
    private javax.swing.JButton btnNuevaCategoria;
    private javax.swing.JButton btnNuevaMarca;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblIdAfectacion;
    private javax.swing.JLabel lblIdCategoria;
    private javax.swing.JLabel lblIdEmpresa;
    private javax.swing.JLabel lblIdMarca;
    private javax.swing.JLabel lblIdUniMedida;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtCodigo;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDescripcion;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDescripcionAfectacion;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDescripcionCategoria;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDescripcionMarca;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDescripcionUniMedida;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtPrecio;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtUbicacion;
    // End of variables declaration//GEN-END:variables
}
