/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.vista.principal;

import compac.vista.principal.alertas.Alerta;
import compac.clases.controlador.PerfilImpl;
import compac.clases.controlador.SedeImpl;
import compac.clases.controlador.UsuarioImpl;
import compac.clases.principales.Fecha_Date;
import compac.vista.importacion.Importacion_Producto;
import compac.vista.mantenimiento.Fm_Categoria;
import compac.vista.mantenimiento.Fm_Clientes;
import compac.vista.mantenimiento.Fm_Cntcarga;
import compac.vista.mantenimiento.Fm_Marca;
import compac.vista.mantenimiento.factE.Fm_Fac_cat2_moneda;
import compac.vista.mantenimiento.factE.Fm_Fac_cat3_umedida;
import compac.vista.mantenimiento.factE.Fm_Fac_cat7_igv;
import compac.vista.mantenimiento.factE.Fm_Fac_grupo_igv;
import compac.vista.mantenimiento.Fm_Perfil;
import compac.vista.mantenimiento.Fm_Producto;
import compac.vista.mantenimiento.Fm_Sede;
import compac.vista.mantenimiento.Fm_Sedeconfig;
import compac.vista.mantenimiento.factE.Fm_Fac_cat6_tipodoc;
import compac.vista.mantenimiento.Fm_Usuario;
import compac.vista.mantenimiento.Fm_Venta;
import compac.vista.mantenimiento.factE.Fm_Fac_cat17_oper;
import compac.vista.mantenimiento.factE.Fm_Fac_cat8_isc;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * private String pass = "kxshhrjbgnwswinx"; private String email =
 * "cursosdesoftperu@gmail.com";
 */
public class Frm_Menu_Principal extends javax.swing.JFrame {

    UsuarioImpl controladorUsuario = new UsuarioImpl();
    SedeImpl controladorSede = new SedeImpl();
    PerfilImpl controladorPerfil = new PerfilImpl();

    Fecha_Date fech = new Fecha_Date();
    Date now = new Date(System.currentTimeMillis());
    SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");

    private int id_usuario = 0, id_sede = 0;

    public Frm_Menu_Principal(String usuario, int id_usuario, int id_sede) {
        initComponents();

        this.id_usuario = id_usuario;
        this.id_sede = id_sede;

        controladorSede.buscar_por_id(id_sede);
        controladorUsuario.buscar_por_id(id_usuario);
        String empresa = controladorSede.getObSedes().getDescripcion();

        //MOSTRAMOS EN LA PARTE INFERIOR LOS DATOS CAPTURADOS
        txtCargo.setText(controladorPerfil.obtieneDescripcion_id(controladorUsuario.getObUsuario().getId_perfil()));
        txtUsuario.setText(usuario.toUpperCase());
        txtFecha.setText("" + fech.retorna_fecha_del_sistemaOrden());
        txtHora.setText(hour.format(now));

        this.setExtendedState(MAXIMIZED_BOTH);//sirve para maximizar la pantalla
        setIconImage(new ImageIcon(getClass().getResource("/compac/icono/general/logos.png")).getImage());
        this.setTitle("SISTEMA DE COTIZACIONES - " + empresa);
        cerrar();
    }

    public void cerrar() {
        try {
            this.setDefaultCloseOperation(Fm_Categoria.DO_NOTHING_ON_CLOSE);
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
            System.exit(-1);
        } else {
            Alerta alert = new Alerta("Mensaje", "Operación Cancelada");
            alert.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtHora = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCargo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        chbEstado = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jdtFecha = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnPresentacion = new javax.swing.JButton();
        btnLaboratorio = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtSanitario = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        txtConcentracion1 = new javax.swing.JTextField();
        txtStock1 = new javax.swing.JTextField();
        txtCosto1 = new javax.swing.JTextField();
        txtPrecio1 = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtb_datos = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        btnGuardad = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jbt_limpiar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        dcFecha = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        btnCalcular1 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblVenta = new javax.swing.JTable();
        btnVentas = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        dcFechaini = new com.toedter.calendar.JDateChooser();
        jLabel33 = new javax.swing.JLabel();
        dcFechafin = new com.toedter.calendar.JDateChooser();
        jLabel34 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblVenta1 = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        txtDocumentoComprobante = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel39 = new javax.swing.JLabel();
        cboTipoComprobante = new javax.swing.JComboBox();
        jLabel40 = new javax.swing.JLabel();
        txtFecha1 = new com.toedter.calendar.JDateChooser();
        txtDescripcion1 = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel41 = new javax.swing.JLabel();
        txtDocumentoCliente = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel42 = new javax.swing.JLabel();
        txtNombreCliente = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel43 = new javax.swing.JLabel();
        txtCorreoCliente = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel44 = new javax.swing.JLabel();
        btnNuevoCliente = new javax.swing.JButton();
        btnBuscarCliente = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblDetalle = new javax.swing.JTable();
        jLabel45 = new javax.swing.JLabel();
        txtDescripcion5 = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtDireccionCliente = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel46 = new javax.swing.JLabel();
        txtImporteTotal = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        txtLeyenda = new javax.swing.JLabel();
        txtSubTotal = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtTotaIgv = new org.edisoncor.gui.textField.TextFieldRectBackground();
        btnRegistrar = new javax.swing.JButton();
        txtTotalGravado = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel50 = new javax.swing.JLabel();
        txtTotalExonerado = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel51 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel25 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jcb_Sexo = new javax.swing.JComboBox();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        chbEstado1 = new javax.swing.JCheckBox();
        jLabel77 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jtb_Empleados = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jPanel31 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jchEstado = new javax.swing.JCheckBox();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jtbPresentacion = new javax.swing.JTable();
        jPanel35 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        btnBuscarProveedor = new javax.swing.JButton();
        txtNombreProveedor = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        lblIdProveedor = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        btnBuscarComprobante = new javax.swing.JButton();
        txtComprobante = new javax.swing.JTextField();
        txtFechas = new javax.swing.JTextField();
        jPanel39 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        txtNombreProducto = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        txtDescripcionProducto = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtPrecioProducto = new javax.swing.JTextField();
        lblIdProducto = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        txtPresentacionProducto = new javax.swing.JTextField();
        txtConcentracionProducto = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        txtIdEmpleado = new javax.swing.JTextField();
        txtNumeroCompra = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        txtTipoPago = new javax.swing.JTextField();
        txtIdProveedor = new javax.swing.JTextField();
        txtUltimoId = new javax.swing.JTextField();
        jPanel40 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        txtCantidadProducto = new javax.swing.JTextField();
        btnAgregarProducto = new javax.swing.JButton();
        jLabel99 = new javax.swing.JLabel();
        txtTotalProducto = new javax.swing.JTextField();
        btnEliminarProducto = new javax.swing.JButton();
        btnLimpiarTabla = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblDetalleProducto = new javax.swing.JTable();
        btnNuevo1 = new javax.swing.JButton();
        btnGuardar1 = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();
        btnReporte1 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel41 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        txtSubTotal1 = new javax.swing.JTextField();
        txtIGV = new javax.swing.JTextField();
        txtTotalCompra = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        btnAnular = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblCompra = new javax.swing.JTable();
        jPanel42 = new javax.swing.JPanel();
        dcFechaini1 = new com.toedter.calendar.JDateChooser();
        jLabel103 = new javax.swing.JLabel();
        dcFechafin1 = new com.toedter.calendar.JDateChooser();
        jLabel104 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblIdCompra = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jPanel46 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        dcFechaini2 = new com.toedter.calendar.JDateChooser();
        jLabel105 = new javax.swing.JLabel();
        dcFechafin2 = new com.toedter.calendar.JDateChooser();
        jLabel106 = new javax.swing.JLabel();
        lblIdVenta = new javax.swing.JLabel();
        lblComprobante = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel48 = new javax.swing.JPanel();
        btnAnular1 = new javax.swing.JButton();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblVenta2 = new javax.swing.JTable();
        jPanel45 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tbProductos = new rojerusan.RSTableMetro();
        jPanel49 = new javax.swing.JPanel();
        rbtndes = new javax.swing.JRadioButton();
        rbtntodo = new javax.swing.JRadioButton();
        btnbuscar = new javax.swing.JButton();
        rbtPres = new javax.swing.JRadioButton();
        jLabel107 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jPanel26 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        rdgenero2 = new javax.swing.JRadioButton();
        rddni2 = new javax.swing.JRadioButton();
        rdtodo2 = new javax.swing.JRadioButton();
        btnbuscar3 = new javax.swing.JButton();
        rdEspecialidad2 = new javax.swing.JRadioButton();
        jScrollPane20 = new javax.swing.JScrollPane();
        tbProveedores = new rojerusan.RSTableMetro();
        jLabel52 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        rbtCategoria = new javax.swing.JRadioButton();
        rbtId = new javax.swing.JRadioButton();
        rbtEstado = new javax.swing.JRadioButton();
        rbtTotal = new javax.swing.JRadioButton();
        btnGenerar = new javax.swing.JButton();
        jScrollPane21 = new javax.swing.JScrollPane();
        tbProductos1 = new rojerusan.RSTableMetro();
        btnCerrar = new javax.swing.JButton();
        jPanel55 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        jPanel56 = new javax.swing.JPanel();
        jPanel57 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        cboTipo = new javax.swing.JComboBox();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        chbEstado2 = new javax.swing.JCheckBox();
        btnPresentacion1 = new javax.swing.JButton();
        jScrollPane23 = new javax.swing.JScrollPane();
        tbUsuario = new javax.swing.JTable();
        jLabel118 = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        txtImagen = new javax.swing.JTextField();
        btnImagen = new javax.swing.JButton();
        jPanel61 = new javax.swing.JPanel();
        btnregistrar = new javax.swing.JButton();
        btnNuevo2 = new javax.swing.JButton();
        btnEliminar2 = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel62 = new javax.swing.JPanel();
        jLabel122 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtId1 = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        txtDni4 = new javax.swing.JTextField();
        jLabel124 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtApellidos1 = new javax.swing.JTextField();
        jLabel125 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        txtNombres1 = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        txtEmail1 = new javax.swing.JTextField();
        jLabel127 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        txtNomUsuario = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        txtClave = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        txtTipoUser = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel130 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        txtEstado1 = new javax.swing.JTextField();
        jLabel120 = new javax.swing.JLabel();
        btnCancelar2 = new javax.swing.JButton();
        jPanel64 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnImprimir1 = new javax.swing.JButton();
        btnImagen1 = new javax.swing.JButton();
        jPanel63 = new javax.swing.JPanel();
        jLabel119 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/VerTabla_40px.png"))); // NOI18N
        jLabel1.setText("Hora");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(50, 30));
        jPanel7.add(jLabel1);

        txtHora.setBackground(new java.awt.Color(255, 255, 255));
        txtHora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtHora.setForeground(new java.awt.Color(102, 102, 102));
        txtHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtHora.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtHora.setOpaque(true);
        jPanel7.add(txtHora);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Info_16px.png"))); // NOI18N
        jLabel10.setText("Fecha");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel10.setOpaque(true);
        jPanel7.add(jLabel10);

        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        txtFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(102, 102, 102));
        txtFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtFecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtFecha.setOpaque(true);
        jPanel7.add(txtFecha);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Pc_user_16px.png"))); // NOI18N
        jLabel8.setText("Perfil");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel8.setOpaque(true);
        jPanel7.add(jLabel8);

        txtCargo.setBackground(new java.awt.Color(255, 255, 255));
        txtCargo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtCargo.setForeground(new java.awt.Color(102, 102, 102));
        txtCargo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCargo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtCargo.setOpaque(true);
        jPanel7.add(txtCargo);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Mant_Gen_16px.png"))); // NOI18N
        jLabel7.setText("Usuario");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel7.setOpaque(true);
        jPanel7.add(jLabel7);

        txtUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(102, 102, 102));
        txtUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtUsuario.setOpaque(true);
        jPanel7.add(txtUsuario);

        jPanel2.add(jPanel7);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 1151, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 5, -1, -1));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(251, 248, 248));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Datos del Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("ID:");
        jPanel15.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 19, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setText("Descripción:");
        jPanel15.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("Presentación:");
        jPanel15.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("Concentración:");
        jPanel15.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 150, 100, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 51));
        jLabel9.setText(" Precio de venta:");
        jPanel15.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 100, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 51));
        jLabel11.setText("Estado:");
        jPanel15.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        chbEstado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        chbEstado.setForeground(new java.awt.Color(0, 102, 102));
        chbEstado.setText("Activo");
        chbEstado.setContentAreaFilled(false);
        chbEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chbEstado.setFocusPainted(false);
        chbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbEstadoActionPerformed(evt);
            }
        });
        chbEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                chbEstadoKeyPressed(evt);
            }
        });
        jPanel15.add(chbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, 30));

        jLabel15.setForeground(new java.awt.Color(0, 51, 51));
        jLabel15.setText("*");
        jPanel15.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 14, -1));

        jLabel16.setForeground(new java.awt.Color(0, 51, 51));
        jLabel16.setText("*");
        jPanel15.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 29, -1));

        jdtFecha.setDateFormatString("yyy/MM/dd ");
        jPanel15.add(jdtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 140, 160, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 51, 51));
        jLabel19.setText("Fecha de Vencimiento:");
        jPanel15.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(696, 150, 130, -1));

        jLabel20.setForeground(new java.awt.Color(0, 51, 51));
        jLabel20.setText("*");
        jPanel15.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 140, 16, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 51, 51));
        jLabel21.setText("Costo:");
        jPanel15.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 40, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 51, 51));
        jLabel23.setText("Laboratorio:");
        jPanel15.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, 80, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 51, 51));
        jLabel24.setText("Registro Sanitario:");
        jPanel15.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 110, -1));

        jLabel26.setForeground(new java.awt.Color(0, 51, 51));
        jLabel26.setText("*");
        jPanel15.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 30, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 51, 51));
        jLabel27.setText("Stock:");
        jPanel15.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        jLabel28.setForeground(new java.awt.Color(0, 51, 51));
        jLabel28.setText("*");
        jPanel15.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 14, -1));

        btnPresentacion.setBorderPainted(false);
        btnPresentacion.setContentAreaFilled(false);
        btnPresentacion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPresentacion.setFocusPainted(false);
        btnPresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPresentacionActionPerformed(evt);
            }
        });
        jPanel15.add(btnPresentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 50, 50));

        btnLaboratorio.setBorderPainted(false);
        btnLaboratorio.setContentAreaFilled(false);
        btnLaboratorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLaboratorio.setFocusPainted(false);
        btnLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaboratorioActionPerformed(evt);
            }
        });
        jPanel15.add(btnLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 50, 50, 50));

        jLabel29.setForeground(new java.awt.Color(0, 51, 51));
        jLabel29.setText("*");
        jPanel15.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 60, 20, -1));

        jLabel30.setForeground(new java.awt.Color(0, 51, 51));
        jLabel30.setText("*");
        jPanel15.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 100, 23, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 51));
        jLabel14.setText(" * Campos Obligatorios");
        jPanel15.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 220, 120, -1));

        jLabel13.setForeground(new java.awt.Color(0, 51, 51));
        jLabel13.setText("*");
        jPanel15.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 20, 20));

        txtSanitario.setText("jTextField1");
        jPanel15.add(txtSanitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, 140, -1));

        txtId.setText("jTextField1");
        jPanel15.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 180, -1));

        txtDescripcion.setText("jTextField1");
        jPanel15.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 180, -1));

        jTextField4.setText("jTextField1");
        jPanel15.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 180, -1));

        txtConcentracion1.setText("jTextField1");
        jPanel15.add(txtConcentracion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 180, -1));

        txtStock1.setText("jTextField1");
        jPanel15.add(txtStock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 130, -1));

        txtCosto1.setText("jTextField1");
        jPanel15.add(txtCosto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 130, -1));

        txtPrecio1.setText("jTextField1");
        jPanel15.add(txtPrecio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 120, -1));

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jPanel16.setBackground(new java.awt.Color(0, 102, 102));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Registro de Productos");
        jPanel16.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, -1));

        jPanel14.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 1080, 70));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 51));
        jLabel12.setText(" Buscar por Descripción:");
        jPanel14.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jtb_datos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jtb_datos.setBackground(new java.awt.Color(251, 248, 248));
        jtb_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtb_datos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtb_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_datosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtb_datos);

        jPanel14.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 1080, 270));

        jPanel17.setBackground(new java.awt.Color(0, 102, 102));
        jPanel17.setLayout(null);

        btnGuardad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGuardad.setForeground(new java.awt.Color(0, 0, 102));
        btnGuardad.setBorder(null);
        btnGuardad.setBorderPainted(false);
        btnGuardad.setContentAreaFilled(false);
        btnGuardad.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardad.setFocusPainted(false);
        btnGuardad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardadActionPerformed(evt);
            }
        });
        btnGuardad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardadKeyPressed(evt);
            }
        });
        jPanel17.add(btnGuardad);
        btnGuardad.setBounds(140, 0, 150, 70);

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 102));
        btnEliminar.setBorderPainted(false);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminar.setFocusPainted(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel17.add(btnEliminar);
        btnEliminar.setBounds(440, 10, 140, 8);

        jbt_limpiar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbt_limpiar.setForeground(new java.awt.Color(0, 0, 102));
        jbt_limpiar.setBorderPainted(false);
        jbt_limpiar.setContentAreaFilled(false);
        jbt_limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbt_limpiar.setFocusPainted(false);
        jbt_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_limpiarActionPerformed(evt);
            }
        });
        jPanel17.add(jbt_limpiar);
        jbt_limpiar.setBounds(10, 10, 130, 50);

        btnReporte.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnReporte.setForeground(new java.awt.Color(0, 0, 102));
        btnReporte.setBorder(null);
        btnReporte.setBorderPainted(false);
        btnReporte.setContentAreaFilled(false);
        btnReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnReporte.setFocusPainted(false);
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        jPanel17.add(btnReporte);
        btnReporte.setBounds(290, 10, 150, 50);

        btnVolver.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(0, 0, 102));
        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVolver.setFocusPainted(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel17.add(btnVolver);
        btnVolver.setBounds(933, 10, 150, 8);

        jPanel14.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, 1080, 100));

        jScrollPane2.setViewportView(jPanel14);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1150, 550));

        jTabbedPane1.addTab("tab2", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("FECHA:");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        dcFecha.setDateFormatString("yyy-MM-dd");
        dcFecha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel5.add(dcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 220, 30));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/vista/imagenes/caja2.jpg"))); // NOI18N
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, 230));

        jPanel18.setBackground(new java.awt.Color(251, 248, 248));
        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel18.setForeground(new java.awt.Color(255, 255, 255));

        btnCalcular1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCalcular1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/vuelto.png"))); // NOI18N
        btnCalcular1.setText("Calcular Ingresos");
        btnCalcular1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCalcular1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcular1ActionPerformed(evt);
            }
        });
        jPanel18.add(btnCalcular1);

        jPanel5.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 240, 50));

        jPanel19.setBackground(new java.awt.Color(251, 248, 248));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Resumen diario", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 0, 0))); // NOI18N
        jPanel19.setToolTipText("");
        jPanel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel19.setLayout(null);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 102));
        jLabel22.setText("Ingreso por ventas:");
        jPanel19.add(jLabel22);
        jLabel22.setBounds(16, 27, 120, 20);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 102, 102));
        jLabel25.setText("Cant. de Productos:");
        jPanel19.add(jLabel25);
        jLabel25.setBounds(20, 80, 120, 14);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 102, 102));
        jLabel31.setText("Ganancia:");
        jPanel19.add(jLabel31);
        jLabel31.setBounds(70, 120, 70, 30);

        jPanel5.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 240, 220));

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));

        tblVenta = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblVenta.setRowHeight(22);
        jScrollPane5.setViewportView(tblVenta);

        jPanel5.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 530, 340));

        btnVentas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/CyV.png"))); // NOI18N
        btnVentas.setText("Ventas Realizadas");
        btnVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });
        jPanel5.add(btnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 180, 40));

        jLabel32.setFont(new java.awt.Font("AR JULIAN", 1, 12)); // NOI18N
        jLabel32.setText("TOTAL EN CAJA:");
        jPanel5.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, -1, -1));

        jTabbedPane1.addTab("tab3", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel20.setLayout(null);

        dcFechaini.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel20.add(dcFechaini);
        dcFechaini.setBounds(20, 30, 130, 25);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("DESDE:");
        jPanel20.add(jLabel33);
        jLabel33.setBounds(60, 10, 70, 20);

        dcFechafin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel20.add(dcFechafin);
        dcFechafin.setBounds(190, 30, 130, 25);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("HASTA:");
        jPanel20.add(jLabel34);
        jLabel34.setBounds(230, 10, 70, 20);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel20.add(jButton1);
        jButton1.setBounds(350, 20, 110, 40);

        jPanel6.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 740, 70));

        tblVenta1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblVenta1.setRowHeight(22);
        tblVenta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVenta1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblVenta1);

        jPanel6.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 740, 300));

        jPanel21.setBackground(new java.awt.Color(251, 248, 248));
        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("CANTIDAD:");
        jPanel21.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 20));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("TOTAL DE VENTAS:");
        jPanel21.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 110, 20));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("GANANCIAS:");
        jPanel21.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 90, 20));

        jPanel6.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, 740, 80));

        jTabbedPane1.addTab("tab4", jPanel6);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        jLabel38.setForeground(new java.awt.Color(102, 102, 102));
        jLabel38.setText("Producto *");

        txtDocumentoComprobante.setEditable(false);
        txtDocumentoComprobante.setAnchoDeBorde(1.0F);
        txtDocumentoComprobante.setDescripcion("Núm. de Documento");
        txtDocumentoComprobante.setEnabled(false);
        txtDocumentoComprobante.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel39.setForeground(new java.awt.Color(102, 102, 102));
        jLabel39.setText("Tipo de Comprobante *");

        cboTipoComprobante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BOLETA DE VENTA ELECTRÓNICA", "FACTURA ELECTRÓNICA" }));
        cboTipoComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoComprobanteActionPerformed(evt);
            }
        });

        jLabel40.setForeground(new java.awt.Color(102, 102, 102));
        jLabel40.setText("Fecha *");

        txtDescripcion1.setAnchoDeBorde(1.0F);
        txtDescripcion1.setDescripcion("Ingrese una descripción");
        txtDescripcion1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel41.setForeground(new java.awt.Color(102, 102, 102));
        jLabel41.setText("Comprobante *");

        txtDocumentoCliente.setAnchoDeBorde(1.0F);
        txtDocumentoCliente.setDescripcion("Documento de Identidad");
        txtDocumentoCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDocumentoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDocumentoClienteKeyReleased(evt);
            }
        });

        jLabel42.setForeground(new java.awt.Color(102, 102, 102));
        jLabel42.setText("Número de Documento *");

        txtNombreCliente.setEditable(false);
        txtNombreCliente.setAnchoDeBorde(1.0F);
        txtNombreCliente.setDescripcion("Nombre / Razón Social");
        txtNombreCliente.setEnabled(false);
        txtNombreCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreClienteActionPerformed(evt);
            }
        });

        jLabel43.setForeground(new java.awt.Color(102, 102, 102));
        jLabel43.setText("Nombres / Razón Social *");

        txtCorreoCliente.setEditable(false);
        txtCorreoCliente.setAnchoDeBorde(1.0F);
        txtCorreoCliente.setDescripcion("Ingrese una descripción");
        txtCorreoCliente.setEnabled(false);
        txtCorreoCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel44.setForeground(new java.awt.Color(102, 102, 102));
        jLabel44.setText("Correo *");

        btnNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/nuevo_16px.png"))); // NOI18N
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });

        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/buscar_16px.png"))); // NOI18N
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/buscar_16px.png"))); // NOI18N

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setLayout(new java.awt.GridLayout(1, 0));

        tblDetalle.setForeground(new java.awt.Color(255, 255, 255));
        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDetalle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblDetalle.setFillsViewportHeight(true);
        tblDetalle.setGridColor(new java.awt.Color(247, 247, 247));
        tblDetalle.setSelectionBackground(new java.awt.Color(0, 102, 153));
        tblDetalle.getTableHeader().setReorderingAllowed(false);
        tblDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetalleMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblDetalle);

        jPanel24.add(jScrollPane7);

        jLabel45.setForeground(new java.awt.Color(102, 102, 102));
        jLabel45.setText("Obs. *");

        txtDescripcion5.setAnchoDeBorde(1.0F);
        txtDescripcion5.setDescripcion("Ingrese una descripción");
        txtDescripcion5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtDireccionCliente.setEditable(false);
        txtDireccionCliente.setAnchoDeBorde(1.0F);
        txtDireccionCliente.setDescripcion("Ingrese una descripción");
        txtDireccionCliente.setEnabled(false);
        txtDireccionCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel46.setForeground(new java.awt.Color(102, 102, 102));
        jLabel46.setText("Dirección *");

        txtImporteTotal.setEditable(false);
        txtImporteTotal.setBackground(new java.awt.Color(1, 150, 51));
        txtImporteTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtImporteTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtImporteTotal.setAnchoDeBorde(1.0F);
        txtImporteTotal.setColorDeBorde(new java.awt.Color(1, 150, 51));
        txtImporteTotal.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        txtImporteTotal.setDescripcion("Total");

        jLabel47.setForeground(new java.awt.Color(102, 102, 102));
        jLabel47.setText("T.Gravado : ");

        jLabel48.setForeground(new java.awt.Color(102, 102, 102));
        jLabel48.setText("Sub Total : ");

        jLabel49.setForeground(new java.awt.Color(102, 102, 102));
        jLabel49.setText("IGV : ");

        txtLeyenda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtLeyenda.setForeground(new java.awt.Color(51, 51, 51));
        txtLeyenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtSubTotal.setEditable(false);
        txtSubTotal.setBackground(new java.awt.Color(238, 64, 64));
        txtSubTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtSubTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSubTotal.setAnchoDeBorde(1.0F);
        txtSubTotal.setColorDeBorde(new java.awt.Color(238, 64, 64));
        txtSubTotal.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        txtSubTotal.setDescripcion("Sub Total");
        txtSubTotal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        txtTotaIgv.setEditable(false);
        txtTotaIgv.setBackground(new java.awt.Color(238, 64, 64));
        txtTotaIgv.setForeground(new java.awt.Color(255, 255, 255));
        txtTotaIgv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotaIgv.setAnchoDeBorde(1.0F);
        txtTotaIgv.setColorDeBorde(new java.awt.Color(238, 64, 64));
        txtTotaIgv.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        txtTotaIgv.setDescripcion("IGV");
        txtTotaIgv.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/guardar_16px.png"))); // NOI18N
        btnRegistrar.setMnemonic('R');
        btnRegistrar.setText("Registrar");
        btnRegistrar.setToolTipText("Realizar NuevoRegistro");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        txtTotalGravado.setEditable(false);
        txtTotalGravado.setBackground(new java.awt.Color(1, 150, 51));
        txtTotalGravado.setForeground(new java.awt.Color(255, 255, 255));
        txtTotalGravado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalGravado.setAnchoDeBorde(1.0F);
        txtTotalGravado.setColorDeBorde(new java.awt.Color(1, 150, 51));
        txtTotalGravado.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        txtTotalGravado.setDescripcion("Total");

        jLabel50.setForeground(new java.awt.Color(102, 102, 102));
        jLabel50.setText("T.Exonerado : ");

        txtTotalExonerado.setEditable(false);
        txtTotalExonerado.setBackground(new java.awt.Color(1, 150, 51));
        txtTotalExonerado.setForeground(new java.awt.Color(255, 255, 255));
        txtTotalExonerado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalExonerado.setAnchoDeBorde(1.0F);
        txtTotalExonerado.setColorDeBorde(new java.awt.Color(1, 150, 51));
        txtTotalExonerado.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        txtTotalExonerado.setDescripcion("Total");

        jLabel51.setForeground(new java.awt.Color(102, 102, 102));
        jLabel51.setText("Imp.Total : ");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccionCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(txtLeyenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtImporteTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboTipoComprobante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                    .addComponent(txtDocumentoComprobante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel23Layout.createSequentialGroup()
                                        .addComponent(txtCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel23Layout.createSequentialGroup()
                                        .addComponent(txtDescripcion1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescripcion5, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel23Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel48)
                                        .addGap(4, 4, 4)
                                        .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel23Layout.createSequentialGroup()
                                        .addComponent(jLabel47)
                                        .addGap(4, 4, 4)
                                        .addComponent(txtTotalGravado, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel23Layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(jLabel49)
                                        .addGap(4, 4, 4)
                                        .addComponent(txtTotaIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel23Layout.createSequentialGroup()
                                        .addComponent(jLabel50)
                                        .addGap(4, 4, 4)
                                        .addComponent(txtTotalExonerado, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(jLabel41))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboTipoComprobante)
                            .addComponent(txtDocumentoComprobante, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNuevoCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                            .addComponent(jLabel42)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                            .addComponent(jLabel43)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel46)
                .addGap(1, 1, 1)
                .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtDescripcion5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLeyenda, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(txtImporteTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel48)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotalGravado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel47))))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotaIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel49)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotalExonerado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel50)))))
                .addContainerGap())
        );

        jPanel22.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));

        jScrollPane4.setViewportView(jPanel22);

        jPanel8.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 560));

        jTabbedPane1.addTab("tab5", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel27.setBackground(new java.awt.Color(0, 102, 153));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Registro de Empleados");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(492, Short.MAX_VALUE)
                .addComponent(jLabel53)
                .addGap(361, 361, 361))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel53)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel25.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1130, 60));

        jPanel29.setBackground(new java.awt.Color(251, 248, 248));
        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Datos del Empleado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel29.setLayout(null);

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 102, 102));
        jLabel54.setText("Id:");
        jPanel29.add(jLabel54);
        jLabel54.setBounds(56, 32, 17, 15);

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 102, 102));
        jLabel55.setText("Nombres:");
        jPanel29.add(jLabel55);
        jLabel55.setBounds(16, 72, 58, 15);

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 102, 102));
        jLabel56.setText("Apellidos:");
        jPanel29.add(jLabel56);
        jLabel56.setBounds(16, 114, 59, 15);

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 102, 102));
        jLabel57.setText("DNI:");
        jPanel29.add(jLabel57);
        jLabel57.setBounds(47, 207, 28, 15);

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 102, 102));
        jLabel58.setText("Sexo:");
        jPanel29.add(jLabel58);
        jLabel58.setBounds(39, 156, 34, 15);

        jcb_Sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "⠀", "M", "F" }));
        jcb_Sexo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jcb_Sexo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcb_SexoKeyPressed(evt);
            }
        });
        jPanel29.add(jcb_Sexo);
        jcb_Sexo.setBounds(83, 152, 76, 25);

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 102, 102));
        jLabel59.setText("Telefono:");
        jPanel29.add(jLabel59);
        jLabel59.setBounds(320, 160, 56, 15);

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 102, 102));
        jLabel60.setText("Email:");
        jPanel29.add(jLabel60);
        jLabel60.setBounds(340, 80, 37, 15);

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 102, 102));
        jLabel61.setText("Direccion:");
        jPanel29.add(jLabel61);
        jLabel61.setBounds(320, 120, 61, 15);

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 102, 102));
        jLabel62.setText("Especialidad:");
        jPanel29.add(jLabel62);
        jLabel62.setBounds(300, 210, 79, 15);

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 102, 102));
        jLabel63.setText("Hora de Salida:");
        jPanel29.add(jLabel63);
        jLabel63.setBounds(690, 120, 91, 15);

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(0, 102, 102));
        jLabel64.setText("Hora de Ingreso:");
        jPanel29.add(jLabel64);
        jLabel64.setBounds(680, 80, 100, 15);

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 102, 102));
        jLabel65.setText("Sueldo S/:");
        jPanel29.add(jLabel65);
        jLabel65.setBounds(718, 163, 63, 15);

        jLabel66.setForeground(new java.awt.Color(0, 102, 102));
        jLabel66.setText("*");
        jPanel29.add(jLabel66);
        jLabel66.setBounds(290, 110, 20, 19);

        jLabel67.setForeground(new java.awt.Color(0, 102, 102));
        jLabel67.setText("*");
        jPanel29.add(jLabel67);
        jLabel67.setBounds(590, 110, 20, 16);

        jLabel68.setForeground(new java.awt.Color(0, 102, 102));
        jLabel68.setText("*");
        jPanel29.add(jLabel68);
        jLabel68.setBounds(210, 205, 20, 10);

        jLabel69.setForeground(new java.awt.Color(0, 102, 102));
        jLabel69.setText("*");
        jPanel29.add(jLabel69);
        jLabel69.setBounds(590, 70, 10, 16);

        jLabel70.setForeground(new java.awt.Color(0, 102, 102));
        jLabel70.setText("*");
        jPanel29.add(jLabel70);
        jLabel70.setBounds(287, 64, 18, 17);

        jLabel71.setForeground(new java.awt.Color(0, 102, 102));
        jLabel71.setText("*");
        jPanel29.add(jLabel71);
        jLabel71.setBounds(560, 150, 30, 10);

        jLabel72.setForeground(new java.awt.Color(0, 102, 102));
        jLabel72.setText("*");
        jPanel29.add(jLabel72);
        jLabel72.setBounds(910, 70, 16, 16);

        jLabel73.setForeground(new java.awt.Color(0, 102, 102));
        jLabel73.setText("*");
        jPanel29.add(jLabel73);
        jLabel73.setBounds(560, 202, 23, 16);

        jLabel74.setForeground(new java.awt.Color(0, 102, 102));
        jLabel74.setText("*");
        jPanel29.add(jLabel74);
        jLabel74.setBounds(911, 111, 28, 16);

        jLabel75.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(0, 102, 102));
        jLabel75.setText("* Campos Obligatorios");
        jPanel29.add(jLabel75);
        jLabel75.setBounds(828, 239, 125, 14);

        jLabel76.setForeground(new java.awt.Color(0, 102, 102));
        jLabel76.setText("*");
        jPanel29.add(jLabel76);
        jLabel76.setBounds(163, 152, 5, 25);

        chbEstado1.setForeground(new java.awt.Color(0, 102, 102));
        chbEstado1.setText("Activo");
        chbEstado1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel29.add(chbEstado1);
        chbEstado1.setBounds(793, 204, 59, 24);

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(0, 102, 102));
        jLabel77.setText("Estado:");
        jPanel29.add(jLabel77);
        jLabel77.setBounds(737, 207, 44, 15);

        jLabel79.setForeground(new java.awt.Color(0, 102, 102));
        jLabel79.setText("*");
        jPanel29.add(jLabel79);
        jLabel79.setBounds(910, 150, 28, 16);

        jPanel25.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 1130, 270));

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 102, 102));
        jLabel80.setText("BUSCAR:");
        jPanel25.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        jtb_Empleados = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jtb_Empleados.setBackground(new java.awt.Color(251, 248, 248));
        jtb_Empleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtb_Empleados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtb_Empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_EmpleadosMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jtb_Empleados);

        jPanel25.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 1110, 250));

        jPanel30.setBackground(new java.awt.Color(0, 102, 153));
        jPanel30.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnnuevo.setForeground(new java.awt.Color(0, 102, 102));
        btnnuevo.setContentAreaFilled(false);
        btnnuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnnuevo.setFocusPainted(false);
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        jPanel30.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 150, -1));

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(0, 102, 102));
        btnguardar.setContentAreaFilled(false);
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnguardar.setFocusPainted(false);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        btnguardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnguardarKeyPressed(evt);
            }
        });
        jPanel30.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 170, -1));

        btnEliminar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar1.setForeground(new java.awt.Color(0, 102, 102));
        btnEliminar1.setContentAreaFilled(false);
        btnEliminar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminar1.setFocusPainted(false);
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });
        jPanel30.add(btnEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 190, -1));

        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(0, 102, 102));
        btncancelar.setContentAreaFilled(false);
        btncancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btncancelar.setFocusPainted(false);
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        jPanel30.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 210, -1));

        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(0, 102, 102));
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar.setFocusPainted(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel30.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 8, -1, 50));

        jPanel25.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 710, 1110, 70));

        jScrollPane8.setViewportView(jPanel25);

        jPanel9.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 560));

        jTabbedPane1.addTab("tab6", jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane11.setBackground(new java.awt.Color(255, 255, 255));

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel33.setBackground(new java.awt.Color(0, 51, 51));
        jPanel33.setForeground(new java.awt.Color(0, 51, 51));

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setText("Registro de Comprobantes");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1130, Short.MAX_VALUE)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel33Layout.createSequentialGroup()
                    .addGap(0, 404, Short.MAX_VALUE)
                    .addComponent(jLabel82)
                    .addGap(0, 404, Short.MAX_VALUE)))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel33Layout.createSequentialGroup()
                    .addGap(0, 10, Short.MAX_VALUE)
                    .addComponent(jLabel82)
                    .addGap(0, 11, Short.MAX_VALUE)))
        );

        jPanel31.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1130, -1));

        jPanel34.setBackground(new java.awt.Color(251, 248, 248));
        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Datos del Tipo de Comprobante:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11), new java.awt.Color(0, 51, 51))); // NOI18N

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(0, 51, 0));
        jLabel83.setText("Id:");

        jchEstado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jchEstado.setForeground(new java.awt.Color(0, 102, 0));
        jchEstado.setText("Activo");
        jchEstado.setContentAreaFilled(false);
        jchEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(0, 51, 0));
        jLabel84.setText("Descripción:");

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(0, 51, 0));
        jLabel85.setText("Estado:");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                        .addComponent(jLabel83)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel84)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                                .addComponent(jLabel85)
                                .addGap(10, 10, 10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jchEstado)
                .addContainerGap(383, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel83)
                .addGap(18, 18, 18)
                .addComponent(jLabel84)
                .addGap(29, 29, 29)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jchEstado)
                    .addComponent(jLabel85))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel31.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 540, 140));

        jtbPresentacion = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jtbPresentacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtbPresentacion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtbPresentacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbPresentacionMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jtbPresentacion);

        jPanel31.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 540, 330));

        jPanel35.setBackground(new java.awt.Color(0, 51, 51));
        jPanel35.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel35.setLayout(null);

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardar.setFocusPainted(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel35.add(btnGuardar);
        btnGuardar.setBounds(140, 0, 12, 60);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelar.setFocusPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel35.add(btnCancelar);
        btnCancelar.setBounds(310, 0, 12, 60);

        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNuevo.setFocusPainted(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel35.add(btnNuevo);
        btnNuevo.setBounds(10, 10, 130, 40);

        jPanel31.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 550, 540, 90));

        jScrollPane11.setViewportView(jPanel31);

        jPanel10.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 560));

        jTabbedPane1.addTab("tab7", jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane12.setBackground(new java.awt.Color(255, 255, 255));

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel37.setBackground(new java.awt.Color(0, 102, 102));
        jPanel37.setForeground(new java.awt.Color(0, 51, 51));

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setText("Realizar Compra");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1130, Short.MAX_VALUE)
            .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel37Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel86)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
            .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel37Layout.createSequentialGroup()
                    .addGap(0, 15, Short.MAX_VALUE)
                    .addComponent(jLabel86)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel36.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1130, -1));

        jPanel38.setBackground(new java.awt.Color(251, 248, 248));
        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Datos de la Compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel38.setForeground(new java.awt.Color(0, 102, 102));

        jLabel87.setBackground(new java.awt.Color(0, 51, 51));
        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(0, 102, 102));
        jLabel87.setText("Proveedor:");

        btnBuscarProveedor.setAlignmentY(1.0F);
        btnBuscarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedorActionPerformed(evt);
            }
        });

        txtNombreProveedor.setEnabled(false);

        jLabel88.setBackground(new java.awt.Color(0, 51, 51));
        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(0, 102, 102));
        jLabel88.setText("RUC:");

        jLabel89.setBackground(new java.awt.Color(0, 51, 51));
        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(0, 102, 102));
        jLabel89.setText("Fecha:");

        txtRuc.setEditable(false);

        jLabel90.setBackground(new java.awt.Color(0, 51, 51));
        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(0, 102, 102));
        jLabel90.setText("Comprobante:");

        btnBuscarComprobante.setAlignmentY(1.0F);
        btnBuscarComprobante.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscarComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarComprobanteActionPerformed(evt);
            }
        });

        txtComprobante.setEditable(false);

        txtFechas.setEditable(false);

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnBuscarComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel88)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnBuscarProveedor))
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel90)
                .addGap(6, 6, 6)
                .addComponent(txtComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnBuscarComprobante))
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel36.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 730, 90));

        jPanel39.setBackground(new java.awt.Color(251, 248, 248));
        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Datos del Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel91.setBackground(new java.awt.Color(0, 51, 51));
        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(0, 102, 102));
        jLabel91.setText("Código:");
        jPanel39.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 70, 40));

        txtCodigoProducto.setEditable(false);
        txtCodigoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoProductoActionPerformed(evt);
            }
        });
        txtCodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoProductoKeyTyped(evt);
            }
        });
        jPanel39.add(txtCodigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 40, 100, 25));

        btnBuscarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });
        jPanel39.add(btnBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 30, -1));

        txtNombreProducto.setEnabled(false);
        jPanel39.add(txtNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 240, -1));

        jLabel92.setBackground(new java.awt.Color(0, 51, 51));
        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(0, 102, 102));
        jLabel92.setText("Stock:");
        jPanel39.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));
        jPanel39.add(txtDescripcionProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 30, 20));

        txtCantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidad.setEnabled(false);
        jPanel39.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 90, -1));

        txtPrecioProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPrecioProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioProducto.setEnabled(false);
        jPanel39.add(txtPrecioProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 90, -1));
        jPanel39.add(lblIdProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 20, 20));

        jLabel93.setBackground(new java.awt.Color(0, 51, 51));
        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(0, 102, 102));
        jLabel93.setText("Costo c/u:");
        jPanel39.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 70, -1));

        txtPresentacionProducto.setEditable(false);
        jPanel39.add(txtPresentacionProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 160, -1));

        txtConcentracionProducto.setEditable(false);
        jPanel39.add(txtConcentracionProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 160, -1));

        jLabel94.setBackground(new java.awt.Color(0, 51, 51));
        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(0, 102, 102));
        jLabel94.setText("Producto:");
        jPanel39.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 70, 20));

        jLabel95.setBackground(new java.awt.Color(0, 51, 51));
        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(0, 102, 102));
        jLabel95.setText("Presentación:");
        jPanel39.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 90, 20));

        jLabel96.setBackground(new java.awt.Color(0, 51, 51));
        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(0, 102, 102));
        jLabel96.setText("Concentración:");
        jPanel39.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 100, 20));

        txtIdEmpleado.setEditable(false);
        jPanel39.add(txtIdEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 90, -1));

        jPanel36.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 730, 130));

        txtNumeroCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroCompraActionPerformed(evt);
            }
        });
        jPanel36.add(txtNumeroCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 120, 160, -1));

        jLabel97.setBackground(new java.awt.Color(0, 51, 51));
        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(0, 102, 102));
        jLabel97.setText("N° Compra:");
        jPanel36.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 100, -1, -1));

        txtTipoPago.setEditable(false);
        txtTipoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoPagoActionPerformed(evt);
            }
        });
        jPanel36.add(txtTipoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 280, 180, -1));

        txtIdProveedor.setEditable(false);
        txtIdProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProveedorActionPerformed(evt);
            }
        });
        jPanel36.add(txtIdProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 200, 180, -1));

        txtUltimoId.setEditable(false);
        jPanel36.add(txtUltimoId, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 240, 180, -1));

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel98.setText("CANTIDAD:");

        txtCantidadProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCantidadProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadProductoKeyTyped(evt);
            }
        });

        btnAgregarProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(0, 102, 102));
        btnAgregarProducto.setText("Agregar");
        btnAgregarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        jLabel99.setText("TOTAL:");

        txtTotalProducto.setBackground(new java.awt.Color(255, 255, 204));
        txtTotalProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTotalProducto.setForeground(new java.awt.Color(0, 102, 204));
        txtTotalProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalProducto.setDisabledTextColor(new java.awt.Color(0, 102, 204));
        txtTotalProducto.setEnabled(false);

        btnEliminarProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminarProducto.setForeground(new java.awt.Color(0, 102, 102));
        btnEliminarProducto.setText("Eliminar");
        btnEliminarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        btnLimpiarTabla.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLimpiarTabla.setForeground(new java.awt.Color(0, 102, 102));
        btnLimpiarTabla.setText("Limpiar");
        btnLimpiarTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarTablaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(txtTotalProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnAgregarProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addComponent(btnEliminarProducto)
                .addGap(8, 8, 8)
                .addComponent(btnLimpiarTabla)
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnLimpiarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13))
        );

        jPanel36.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 730, 60));

        tblDetalleProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblDetalleProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDetalleProducto.setRowHeight(22);
        jScrollPane13.setViewportView(tblDetalleProducto);

        jPanel36.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 740, 340));

        btnNuevo1.setBackground(new java.awt.Color(204, 255, 204));
        btnNuevo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNuevo1.setForeground(new java.awt.Color(0, 102, 102));
        btnNuevo1.setText("Nuevo");
        btnNuevo1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNuevo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo1.setIconTextGap(0);
        btnNuevo1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo1ActionPerformed(evt);
            }
        });
        jPanel36.add(btnNuevo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 320, 110, 40));

        btnGuardar1.setBackground(new java.awt.Color(204, 255, 204));
        btnGuardar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGuardar1.setForeground(new java.awt.Color(0, 102, 102));
        btnGuardar1.setText("Guardar");
        btnGuardar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar1.setIconTextGap(0);
        btnGuardar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });
        jPanel36.add(btnGuardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 370, 110, 40));

        btnCancelar1.setBackground(new java.awt.Color(204, 255, 204));
        btnCancelar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar1.setForeground(new java.awt.Color(0, 102, 102));
        btnCancelar1.setText("Cancelar");
        btnCancelar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar1.setIconTextGap(0);
        btnCancelar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });
        jPanel36.add(btnCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 420, 110, 40));

        btnReporte1.setBackground(new java.awt.Color(204, 255, 204));
        btnReporte1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReporte1.setForeground(new java.awt.Color(0, 102, 102));
        btnReporte1.setText("Imprimir");
        btnReporte1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnReporte1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReporte1.setIconTextGap(0);
        btnReporte1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporte1ActionPerformed(evt);
            }
        });
        jPanel36.add(btnReporte1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 470, 110, 40));

        btnSalir.setBackground(new java.awt.Color(204, 255, 204));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 102, 102));
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setIconTextGap(0);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel36.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 520, 110, 40));

        jPanel41.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setText("SUB TOTAL");
        jPanel41.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 100, 20));

        jLabel101.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel101.setText("I.G.V.");
        jPanel41.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 100, 20));

        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel102.setText("TOTAL A PAGAR");
        jLabel102.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel41.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 150, 20));

        txtSubTotal1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSubTotal1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSubTotal1.setEnabled(false);
        jPanel41.add(txtSubTotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 100, 30));

        txtIGV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtIGV.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIGV.setEnabled(false);
        jPanel41.add(txtIGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 100, 30));

        txtTotalCompra.setBackground(new java.awt.Color(255, 255, 204));
        txtTotalCompra.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTotalCompra.setForeground(new java.awt.Color(0, 255, 102));
        txtTotalCompra.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalCompra.setDisabledTextColor(new java.awt.Color(0, 255, 102));
        txtTotalCompra.setEnabled(false);
        jPanel41.add(txtTotalCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 150, 30));

        jPanel36.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 750, 740, 110));

        jScrollPane12.setViewportView(jPanel36);

        jPanel11.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 560));

        jTabbedPane1.addTab("tab8", jPanel11);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel43.setBackground(new java.awt.Color(251, 248, 248));
        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Anular Compra:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 51, 51))); // NOI18N
        jPanel43.setLayout(null);

        btnAnular.setForeground(new java.awt.Color(153, 0, 0));
        btnAnular.setContentAreaFilled(false);
        btnAnular.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAnular.setFocusPainted(false);
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });
        jPanel43.add(btnAnular);
        btnAnular.setBounds(60, 20, 160, 60);

        jPanel12.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, 270, 100));

        tblCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblCompra.setRowHeight(22);
        tblCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCompraMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tblCompra);

        jPanel12.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 920, 380));

        jPanel42.setBackground(new java.awt.Color(251, 248, 248));
        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Buscar Compra:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 51, 51))); // NOI18N
        jPanel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel42.setLayout(null);

        dcFechaini1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel42.add(dcFechaini1);
        dcFechaini1.setBounds(70, 40, 150, 25);

        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(0, 51, 51));
        jLabel103.setText("Desde:");
        jPanel42.add(jLabel103);
        jLabel103.setBounds(20, 40, 70, 20);

        dcFechafin1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel42.add(dcFechafin1);
        dcFechafin1.setBounds(290, 40, 210, 25);

        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(0, 51, 51));
        jLabel104.setText("Hasta:");
        jPanel42.add(jLabel104);
        jLabel104.setBounds(240, 40, 50, 20);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel42.add(jButton2);
        jButton2.setBounds(390, 20, 130, 60);
        jPanel42.add(lblIdCompra);
        lblIdCompra.setBounds(320, 20, 40, 20);

        jPanel12.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 580, 100));

        jTabbedPane1.addTab("tab9", jPanel12);

        jPanel44.setBackground(new java.awt.Color(255, 255, 255));
        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane15.setBackground(new java.awt.Color(255, 255, 255));

        jPanel46.setBackground(new java.awt.Color(255, 255, 255));
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel47.setBackground(new java.awt.Color(251, 248, 248));
        jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Buscar venta:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 51, 51))); // NOI18N
        jPanel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel47.setLayout(null);

        dcFechaini2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel47.add(dcFechaini2);
        dcFechaini2.setBounds(70, 40, 170, 25);

        jLabel105.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(0, 51, 51));
        jLabel105.setText("Desde:");
        jPanel47.add(jLabel105);
        jLabel105.setBounds(20, 40, 70, 20);

        dcFechafin2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel47.add(dcFechafin2);
        dcFechafin2.setBounds(320, 40, 170, 25);

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(0, 51, 51));
        jLabel106.setText("Hasta:");
        jPanel47.add(jLabel106);
        jLabel106.setBounds(270, 40, 50, 20);
        jPanel47.add(lblIdVenta);
        lblIdVenta.setBounds(320, 20, 40, 20);
        jPanel47.add(lblComprobante);
        lblComprobante.setBounds(410, 30, 0, 40);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.setFocusPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel47.add(jButton4);
        jButton4.setBounds(390, 20, 130, 60);

        jPanel46.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 550, 90));

        jPanel48.setBackground(new java.awt.Color(251, 248, 248));
        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Anular Venta:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 51, 51))); // NOI18N
        jPanel48.setLayout(null);

        btnAnular1.setForeground(new java.awt.Color(153, 0, 0));
        btnAnular1.setContentAreaFilled(false);
        btnAnular1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAnular1.setFocusPainted(false);
        btnAnular1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnular1ActionPerformed(evt);
            }
        });
        jPanel48.add(btnAnular1);
        btnAnular1.setBounds(10, 20, 160, 60);

        jPanel46.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, 170, 90));

        tblVenta2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblVenta2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblVenta2.setRowHeight(22);
        tblVenta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVenta2MouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(tblVenta2);

        jPanel46.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 750, 310));

        jScrollPane15.setViewportView(jPanel46);

        jPanel44.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 560));

        jTabbedPane1.addTab("tab10", jPanel44);

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbProductos.setAltoHead(22);
        tbProductos.setColorBackgoundHead(new java.awt.Color(0, 51, 51));
        tbProductos.setColorFilasBackgound2(new java.awt.Color(240, 240, 240));
        tbProductos.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbProductos.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbProductos.setFuenteFilas(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        tbProductos.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tbProductos.setFuenteHead(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tbProductos.setGrosorBordeFilas(0);
        jScrollPane18.setViewportView(tbProductos);

        jPanel13.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 860, 360));

        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Buscar Productos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 51, 51))); // NOI18N

        rbtndes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtndes.setForeground(new java.awt.Color(0, 51, 51));
        rbtndes.setSelected(true);
        rbtndes.setText("Mostrar Productos por Descripcion:");
        rbtndes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rbtndes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtndesActionPerformed(evt);
            }
        });

        rbtntodo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtntodo.setForeground(new java.awt.Color(0, 51, 51));
        rbtntodo.setText("Mostrar todos los Productos");
        rbtntodo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rbtntodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtntodoActionPerformed(evt);
            }
        });

        btnbuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnbuscar.setContentAreaFilled(false);
        btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnbuscar.setFocusPainted(false);
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        rbtPres.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtPres.setForeground(new java.awt.Color(0, 51, 51));
        rbtPres.setText("Mostrar Productos por Presentación:");
        rbtPres.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rbtPres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtPresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtPres)
                    .addComponent(rbtndes))
                .addGap(205, 205, 205)
                .addComponent(btnbuscar)
                .addGap(18, 18, 18)
                .addComponent(rbtntodo)
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnbuscar)
                            .addGroup(jPanel49Layout.createSequentialGroup()
                                .addComponent(rbtndes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtPres))))
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(rbtntodo)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel13.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(0, 51, 51));
        jLabel107.setText("Cantidad de Registros:");
        jPanel13.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 550, -1, 30));

        jPanel50.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 620, 860, 30));

        jScrollPane17.setViewportView(jPanel13);

        jPanel45.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 560));

        jTabbedPane1.addTab("tab11", jPanel45);

        jPanel51.setBackground(new java.awt.Color(255, 255, 255));
        jPanel51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel52.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Buscar Empleado:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 102, 102))); // NOI18N

        rdgenero2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdgenero2.setForeground(new java.awt.Color(0, 51, 51));
        rdgenero2.setSelected(true);
        rdgenero2.setText("Buscar Proveedor por nombre:");
        rdgenero2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rdgenero2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdgenero2ActionPerformed(evt);
            }
        });

        rddni2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rddni2.setForeground(new java.awt.Color(0, 51, 51));
        rddni2.setText("Buscar Proveedor  por DNI:");
        rddni2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rddni2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rddni2ActionPerformed(evt);
            }
        });

        rdtodo2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdtodo2.setForeground(new java.awt.Color(0, 51, 51));
        rdtodo2.setText("Mostrar todos los Proveedores");
        rdtodo2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rdtodo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdtodo2ActionPerformed(evt);
            }
        });

        btnbuscar3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnbuscar3.setContentAreaFilled(false);
        btnbuscar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnbuscar3.setFocusPainted(false);
        btnbuscar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar3ActionPerformed(evt);
            }
        });

        rdEspecialidad2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdEspecialidad2.setForeground(new java.awt.Color(0, 51, 51));
        rdEspecialidad2.setText("Buscar Proveedor por Ruc :");
        rdEspecialidad2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rdEspecialidad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdEspecialidad2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdgenero2)
                    .addComponent(rddni2)
                    .addComponent(rdtodo2)
                    .addComponent(rdEspecialidad2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 355, Short.MAX_VALUE)
                .addComponent(btnbuscar3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel52Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(rddni2))
                            .addGroup(jPanel52Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(rdgenero2)))
                        .addGap(14, 14, 14)
                        .addComponent(rdEspecialidad2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdtodo2))
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnbuscar3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel26.add(jPanel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 830, -1));

        tbProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbProveedores.setAltoHead(22);
        tbProveedores.setColorBackgoundHead(new java.awt.Color(0, 51, 51));
        tbProveedores.setColorFilasBackgound2(new java.awt.Color(240, 240, 240));
        tbProveedores.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbProveedores.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbProveedores.setFuenteFilas(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        tbProveedores.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tbProveedores.setFuenteHead(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tbProveedores.setGrosorBordeFilas(0);
        jScrollPane20.setViewportView(tbProveedores);

        jPanel26.add(jScrollPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 830, 280));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 51, 51));
        jLabel52.setText("Cantidad de Registros:");
        jPanel26.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 490, -1, 30));

        jScrollPane19.setViewportView(jPanel26);

        jPanel51.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 560));

        jTabbedPane1.addTab("tab12", jPanel51);

        jPanel53.setBackground(new java.awt.Color(255, 255, 255));
        jPanel53.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel54.setBackground(new java.awt.Color(251, 248, 248));
        jPanel54.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Reportes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 102, 102))); // NOI18N

        rbtCategoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtCategoria.setForeground(new java.awt.Color(0, 102, 102));
        rbtCategoria.setSelected(true);
        rbtCategoria.setText("Generar Reporte por Presentación:");
        rbtCategoria.setContentAreaFilled(false);
        rbtCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rbtCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtCategoriaActionPerformed(evt);
            }
        });

        rbtId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtId.setForeground(new java.awt.Color(0, 102, 102));
        rbtId.setText("Generar Reporte por Id:");
        rbtId.setContentAreaFilled(false);
        rbtId.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rbtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtIdActionPerformed(evt);
            }
        });

        rbtEstado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtEstado.setForeground(new java.awt.Color(0, 102, 102));
        rbtEstado.setText("Generar Reporte por Estado:");
        rbtEstado.setContentAreaFilled(false);
        rbtEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rbtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtEstadoActionPerformed(evt);
            }
        });

        rbtTotal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtTotal.setForeground(new java.awt.Color(0, 102, 102));
        rbtTotal.setText("Mostrar Reporte General");
        rbtTotal.setContentAreaFilled(false);
        rbtTotal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rbtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtTotalActionPerformed(evt);
            }
        });

        btnGenerar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGenerar.setText("Generar");
        btnGenerar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGenerar.setIconTextGap(0);
        btnGenerar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtTotal)
                    .addComponent(rbtCategoria)
                    .addComponent(rbtEstado)
                    .addComponent(rbtId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rbtCategoria)
                        .addGap(11, 11, 11)
                        .addComponent(rbtId)
                        .addGap(9, 9, 9)
                        .addComponent(rbtEstado))
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addComponent(rbtTotal)
                .addGap(9, 9, 9))
        );

        jPanel53.add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));

        tbProductos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbProductos1.setAltoHead(22);
        tbProductos1.setColorBackgoundHead(new java.awt.Color(0, 51, 51));
        tbProductos1.setColorFilasBackgound2(new java.awt.Color(240, 240, 240));
        tbProductos1.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbProductos1.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbProductos1.setFuenteFilas(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        tbProductos1.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tbProductos1.setFuenteHead(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tbProductos1.setGrosorBordeFilas(0);
        tbProductos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductos1MouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(tbProductos1);

        jPanel53.add(jScrollPane21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 900, 260));

        btnCerrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCerrar.setText("Volver");
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setIconTextGap(0);
        btnCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel53.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 490, 110, 30));

        jTabbedPane1.addTab("tab13", jPanel53);

        jPanel55.setBackground(new java.awt.Color(255, 255, 255));
        jPanel55.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane22.setBackground(new java.awt.Color(255, 255, 255));

        jPanel56.setBackground(new java.awt.Color(255, 255, 255));
        jPanel56.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel57.setBackground(new java.awt.Color(0, 51, 51));

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setText("Registro de Usuarios");

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGap(438, 438, 438)
                .addComponent(jLabel81)
                .addContainerGap(442, Short.MAX_VALUE))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel81)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel56.add(jPanel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 1130, 60));

        jPanel60.setBackground(new java.awt.Color(251, 248, 248));
        jPanel60.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Usuario:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel60.setLayout(null);

        jLabel108.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(0, 51, 51));
        jLabel108.setText("Id:");
        jPanel60.add(jLabel108);
        jLabel108.setBounds(70, 30, 18, 16);

        jLabel109.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(0, 51, 51));
        jLabel109.setText("Email:");
        jPanel60.add(jLabel109);
        jLabel109.setBounds(50, 180, 50, 16);

        jLabel110.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(0, 51, 51));
        jLabel110.setText("Contraseña:");
        jPanel60.add(jLabel110);
        jLabel110.setBounds(20, 260, 79, 16);

        jLabel111.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(0, 51, 51));
        jLabel111.setText("Tipo Usuario:");
        jPanel60.add(jLabel111);
        jLabel111.setBounds(13, 300, 90, 16);

        cboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "⠀⠀⠀⠀⠀⠀⠀⠀", "Administrador", "Vendedor", " " }));
        cboTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoActionPerformed(evt);
            }
        });
        cboTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboTipoKeyPressed(evt);
            }
        });
        jPanel60.add(cboTipo);
        cboTipo.setBounds(120, 300, 132, 28);

        jLabel112.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(0, 51, 51));
        jLabel112.setText("DNI:");
        jPanel60.add(jLabel112);
        jLabel112.setBounds(60, 70, 30, 16);

        jLabel113.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(0, 51, 51));
        jLabel113.setText("Usuario:");
        jPanel60.add(jLabel113);
        jLabel113.setBounds(40, 220, 60, 16);

        jLabel114.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(0, 51, 51));
        jLabel114.setText("Apellidos:");
        jPanel60.add(jLabel114);
        jLabel114.setBounds(30, 100, 90, 16);

        jLabel115.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(0, 51, 51));
        jLabel115.setText("Nombres:");
        jPanel60.add(jLabel115);
        jLabel115.setBounds(30, 140, 90, 16);

        jLabel117.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(0, 51, 51));
        jLabel117.setText("Estado:");
        jPanel60.add(jLabel117);
        jLabel117.setBounds(50, 340, 49, 16);

        chbEstado2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        chbEstado2.setForeground(new java.awt.Color(0, 102, 102));
        chbEstado2.setText("Activo");
        chbEstado2.setContentAreaFilled(false);
        chbEstado2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chbEstado2.setFocusPainted(false);
        jPanel60.add(chbEstado2);
        chbEstado2.setBounds(120, 340, 62, 24);

        btnPresentacion1.setBorderPainted(false);
        btnPresentacion1.setContentAreaFilled(false);
        btnPresentacion1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPresentacion1.setFocusPainted(false);
        btnPresentacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPresentacion1ActionPerformed(evt);
            }
        });
        jPanel60.add(btnPresentacion1);
        btnPresentacion1.setBounds(180, 10, 64, 50);

        jPanel56.add(jPanel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 420, 400));

        tbUsuario = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsuarioMouseClicked(evt);
            }
        });
        jScrollPane23.setViewportView(tbUsuario);

        jPanel56.add(jScrollPane23, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 700, 390));

        jLabel118.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(0, 51, 51));
        jLabel118.setText("Buscar:");
        jPanel56.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, -1, -1));

        lblImagen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblImagen.setText("Imagen:");
        jPanel56.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, -1, -1));
        jPanel56.add(txtImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 510, 260, -1));

        btnImagen.setText("Agregar");
        btnImagen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });
        jPanel56.add(btnImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 510, -1, -1));

        jPanel61.setBackground(new java.awt.Color(0, 51, 51));
        jPanel61.setLayout(null);

        btnregistrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnregistrar.setForeground(new java.awt.Color(0, 153, 102));
        btnregistrar.setContentAreaFilled(false);
        btnregistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnregistrar.setFocusPainted(false);
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });
        btnregistrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnregistrarKeyPressed(evt);
            }
        });
        jPanel61.add(btnregistrar);
        btnregistrar.setBounds(130, 0, 140, 60);

        btnNuevo2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNuevo2.setForeground(new java.awt.Color(0, 153, 102));
        btnNuevo2.setContentAreaFilled(false);
        btnNuevo2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNuevo2.setFocusPainted(false);
        btnNuevo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo2ActionPerformed(evt);
            }
        });
        jPanel61.add(btnNuevo2);
        btnNuevo2.setBounds(-10, 0, 147, 60);

        btnEliminar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminar2.setForeground(new java.awt.Color(0, 153, 102));
        btnEliminar2.setContentAreaFilled(false);
        btnEliminar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminar2.setFocusPainted(false);
        btnEliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar2ActionPerformed(evt);
            }
        });
        jPanel61.add(btnEliminar2);
        btnEliminar2.setBounds(260, 0, 163, 60);

        btnImprimir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(0, 153, 102));
        btnImprimir.setContentAreaFilled(false);
        btnImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnImprimir.setFocusPainted(false);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel61.add(btnImprimir);
        btnImprimir.setBounds(810, 0, 171, 60);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 153, 102));
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel61.add(jButton5);
        jButton5.setBounds(420, 0, 12, 60);

        jPanel56.add(jPanel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 1130, 60));

        jScrollPane22.setViewportView(jPanel56);

        jPanel55.add(jScrollPane22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 560));

        jTabbedPane1.addTab("tab14", jPanel55);

        jPanel62.setBackground(new java.awt.Color(255, 255, 255));
        jPanel62.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel122.setBackground(new java.awt.Color(0, 0, 0));
        jLabel122.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(255, 255, 255));
        jLabel122.setText("Id:");
        jPanel62.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel62.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 90, 10));

        txtId1.setEditable(false);
        txtId1.setBackground(new java.awt.Color(0, 0, 0));
        txtId1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtId1.setForeground(new java.awt.Color(255, 255, 255));
        txtId1.setBorder(null);
        txtId1.setCaretColor(new java.awt.Color(255, 255, 255));
        txtId1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtId1ActionPerformed(evt);
            }
        });
        jPanel62.add(txtId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 90, 30));

        jLabel123.setBackground(new java.awt.Color(0, 0, 0));
        jLabel123.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(255, 255, 255));
        jLabel123.setText("Dni:");
        jPanel62.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        jSeparator4.setBackground(new java.awt.Color(0, 51, 51));
        jPanel62.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 140, 20));

        txtDni4.setEditable(false);
        txtDni4.setBackground(new java.awt.Color(0, 0, 0));
        txtDni4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDni4.setForeground(new java.awt.Color(255, 255, 255));
        txtDni4.setBorder(null);
        txtDni4.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel62.add(txtDni4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 140, 30));

        jLabel124.setBackground(new java.awt.Color(0, 0, 0));
        jLabel124.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(255, 255, 255));
        jLabel124.setText("Apellidos:");
        jPanel62.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));
        jPanel62.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 210, 20));

        txtApellidos1.setBackground(new java.awt.Color(0, 0, 0));
        txtApellidos1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtApellidos1.setForeground(new java.awt.Color(255, 255, 255));
        txtApellidos1.setBorder(null);
        txtApellidos1.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel62.add(txtApellidos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 210, 30));

        jLabel125.setBackground(new java.awt.Color(0, 0, 0));
        jLabel125.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(255, 255, 255));
        jLabel125.setText("Nombres:");
        jPanel62.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));
        jPanel62.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 210, 10));

        txtNombres1.setBackground(new java.awt.Color(0, 0, 0));
        txtNombres1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNombres1.setForeground(new java.awt.Color(255, 255, 255));
        txtNombres1.setBorder(null);
        txtNombres1.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel62.add(txtNombres1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 210, 30));

        jLabel126.setBackground(new java.awt.Color(0, 0, 0));
        jLabel126.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(255, 255, 255));
        jLabel126.setText("Email:");
        jPanel62.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        jSeparator7.setBackground(new java.awt.Color(160, 160, 160));
        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel62.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 210, 20));

        txtEmail1.setBackground(new java.awt.Color(0, 0, 0));
        txtEmail1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEmail1.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail1.setBorder(null);
        txtEmail1.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel62.add(txtEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 210, 30));

        jLabel127.setBackground(new java.awt.Color(0, 0, 0));
        jLabel127.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(255, 255, 255));
        jLabel127.setText("Usuario:");
        jPanel62.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, -1, -1));
        jPanel62.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 210, 20));

        txtNomUsuario.setBackground(new java.awt.Color(0, 0, 0));
        txtNomUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNomUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtNomUsuario.setBorder(null);
        txtNomUsuario.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel62.add(txtNomUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 210, 30));

        jLabel128.setBackground(new java.awt.Color(0, 0, 0));
        jLabel128.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(255, 255, 255));
        jLabel128.setText("Contraseña:");
        jPanel62.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));
        jPanel62.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 210, 10));

        txtClave.setBackground(new java.awt.Color(0, 0, 0));
        txtClave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtClave.setForeground(new java.awt.Color(255, 255, 255));
        txtClave.setBorder(null);
        txtClave.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel62.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 210, 30));

        jLabel129.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(0, 102, 102));
        jLabel129.setText("Tipo de Usuario:");
        jPanel62.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        txtTipoUser.setEditable(false);
        txtTipoUser.setBackground(new java.awt.Color(0, 0, 0));
        txtTipoUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTipoUser.setForeground(new java.awt.Color(255, 255, 255));
        txtTipoUser.setBorder(null);
        txtTipoUser.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel62.add(txtTipoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 210, 30));

        jSeparator12.setBackground(new java.awt.Color(0, 51, 51));
        jPanel62.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 210, 10));

        jLabel130.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(0, 102, 102));
        jLabel130.setText("Estado:");
        jPanel62.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, -1, -1));

        jSeparator14.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator14.setForeground(new java.awt.Color(0, 102, 102));
        jPanel62.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 520, 210, 10));

        txtEstado1.setEditable(false);
        txtEstado1.setBackground(new java.awt.Color(0, 0, 0));
        txtEstado1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEstado1.setForeground(new java.awt.Color(0, 102, 102));
        txtEstado1.setBorder(null);
        txtEstado1.setCaretColor(new java.awt.Color(255, 255, 255));
        txtEstado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstado1ActionPerformed(evt);
            }
        });
        jPanel62.add(txtEstado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 210, 30));

        jLabel120.setForeground(new java.awt.Color(255, 255, 255));
        jLabel120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/vista/imagenes/fon2_1.jpg"))); // NOI18N
        jLabel120.setText("jLabel10");
        jPanel62.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 360, 490));

        btnCancelar2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar2.setText("Cancelar");
        btnCancelar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar2ActionPerformed(evt);
            }
        });
        jPanel62.add(btnCancelar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, 100, 30));

        jPanel64.setBackground(new java.awt.Color(0, 102, 102));
        jPanel64.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnImprimir1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnImprimir1.setText("Imprimir");
        btnImprimir1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnImprimir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImprimir1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnModificar)
                .addGap(18, 18, 18)
                .addComponent(btnImprimir1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel62.add(jPanel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, -1, -1));

        btnImagen1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnImagen1.setText("Seleccionar Imagen");
        btnImagen1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnImagen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagen1ActionPerformed(evt);
            }
        });
        jPanel62.add(btnImagen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, -1, -1));

        jPanel63.setBackground(new java.awt.Color(58, 159, 171));

        jLabel119.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(255, 255, 255));
        jLabel119.setText("Administrar Perfil");

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                .addContainerGap(486, Short.MAX_VALUE)
                .addComponent(jLabel119)
                .addGap(441, 441, 441))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel119)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel62.add(jPanel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1140, 50));

        jLabel121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/vista/imagenes/fon4.jpg"))); // NOI18N
        jPanel62.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 350, 490));

        jTabbedPane1.addTab("tab15", jPanel62);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 1160, 630));

        getContentPane().add(jPanel1);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        jMenu1.setForeground(new java.awt.Color(66, 66, 66));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Empresas_Gen16px.png"))); // NOI18N
        jMenu1.setText("Mantenimiento");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jMenuItem3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem3.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Laboratorios_Gen_16px.png"))); // NOI18N
        jMenuItem3.setText("Categorías");
        jMenuItem3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem4.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Laboratorios_Gen_16px.png"))); // NOI18N
        jMenuItem4.setText("Marcas");
        jMenuItem4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem2.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/registro_de_compra_16px.png"))); // NOI18N
        jMenuItem2.setText("Productos / Servicios");
        jMenuItem2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(66, 66, 66));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/ventas_16px.png"))); // NOI18N
        jMenu2.setText("Facturación  ");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/colaboradores_16px.png"))); // NOI18N
        jMenuItem1.setText("Clientes");
        jMenuItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem5.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/ventas_16px.png"))); // NOI18N
        jMenuItem5.setText("Ventas");
        jMenuItem5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setForeground(new java.awt.Color(66, 66, 66));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Pc_user_16px.png"))); // NOI18N
        jMenu3.setText("Gerencia ");
        jMenu3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jMenu5.setForeground(new java.awt.Color(51, 51, 51));
        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Pc_user_16px.png"))); // NOI18N
        jMenu5.setText("Empresa");
        jMenu5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jMenuItem15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem15.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Pc_user_16px.png"))); // NOI18N
        jMenuItem15.setText("Empresa");
        jMenuItem15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem15);

        jMenuItem24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem24.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Pc_user_16px.png"))); // NOI18N
        jMenuItem24.setText("Parámetros de Empresas");
        jMenuItem24.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem24);
        jMenu5.add(jSeparator3);

        jMenuItem7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem7.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/gerencia_16px.png"))); // NOI18N
        jMenuItem7.setText("Perfiles");
        jMenuItem7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuItem6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem6.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Mant_Gen_16px.png"))); // NOI18N
        jMenuItem6.setText("Usuarios");
        jMenuItem6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem6);

        jMenu3.add(jMenu5);

        jMenu7.setForeground(new java.awt.Color(51, 51, 51));
        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/buscar_16px.png"))); // NOI18N
        jMenu7.setText("Importaciones Masivas");
        jMenu7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jMenuItem11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem11.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/registro_de_compra_16px.png"))); // NOI18N
        jMenuItem11.setText("Productos / Servicios");
        jMenuItem11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem11);

        jMenu3.add(jMenu7);

        jMenuBar1.add(jMenu3);

        jMenu8.setForeground(new java.awt.Color(66, 66, 66));
        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/gerencia_16px.png"))); // NOI18N
        jMenu8.setText("Desarrollador  ");
        jMenu8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jMenu9.setForeground(new java.awt.Color(51, 51, 51));
        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/gerencia_16px.png"))); // NOI18N
        jMenu9.setText("Empresa");
        jMenu9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jMenuItem18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem18.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Pc_user_16px.png"))); // NOI18N
        jMenuItem18.setText("Perfiles");
        jMenuItem18.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem18);

        jMenuItem19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem19.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Colaboradores_Gen_16px.png"))); // NOI18N
        jMenuItem19.setText("Usuarios");
        jMenuItem19.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem19);

        jMenu8.add(jMenu9);
        jMenu8.add(jSeparator5);

        jMenuItem16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem16.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Mant_Gen_16px.png"))); // NOI18N
        jMenuItem16.setText("Control de Sedes");
        jMenuItem16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem16);

        jMenuItem20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem20.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/reportes_16px.png"))); // NOI18N
        jMenuItem20.setText("Cantidad de Carga de Datos");
        jMenuItem20.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem20);

        jMenu13.setForeground(new java.awt.Color(51, 51, 51));
        jMenu13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Pc_user_16px.png"))); // NOI18N
        jMenu13.setText("Facturación Electrónica");
        jMenu13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jMenuItem31.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem31.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Pc_user_16px.png"))); // NOI18N
        jMenuItem31.setText("Catálogo #2 - Registro de Productos");
        jMenuItem31.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem31);

        jMenuItem30.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem30.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Pc_user_16px.png"))); // NOI18N
        jMenuItem30.setText("Catálogo #3 - Resumen de Caja");
        jMenuItem30.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem30);

        jMenuItem17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem17.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Pc_user_16px.png"))); // NOI18N
        jMenuItem17.setText("Catálogo #6 - Ventas Realizadas");
        jMenuItem17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem17);

        jMenuItem28.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem28.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Pc_user_16px.png"))); // NOI18N
        jMenuItem28.setText("Registro de Ventas");
        jMenuItem28.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem28);

        jMenuItem32.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem32.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Pc_user_16px.png"))); // NOI18N
        jMenuItem32.setText("Registro de Empleados");
        jMenuItem32.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem32);

        jMenuItem33.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem33.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Pc_user_16px.png"))); // NOI18N
        jMenuItem33.setText("Registro de Comprobantes");
        jMenuItem33.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem33);

        jMenuItem29.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem29.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Pc_user_16px.png"))); // NOI18N
        jMenuItem29.setText("Realizar Compra");
        jMenuItem29.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem29);

        jMenuItem9.setText("Consultar Compras");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem9);

        jMenuItem10.setText("Consultar Ventas");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem10);

        jMenuItem12.setText("Consultar Productos");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem12);

        jMenuItem13.setText("Consultar Proveedores");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem13);

        jMenuItem14.setText("Reportes de Productos");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem14);

        jMenuItem21.setText("Registro de Usuarios");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem21);

        jMenuItem22.setText("Administrar Perfil");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem22);

        jMenu8.add(jMenu13);

        jMenuBar1.add(jMenu8);

        jMenu4.setForeground(new java.awt.Color(66, 66, 66));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icono/general/Home_16px.png"))); // NOI18N
        jMenu4.setText("Sistema");
        jMenu4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jMenuItem8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem8.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compac/icnono/botones/salir_16px.png"))); // NOI18N
        jMenuItem8.setText("Salir");
        jMenuItem8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        Fm_Categoria formulario = new Fm_Categoria(id_usuario, id_sede);
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        Fm_Producto formulario = new Fm_Producto(id_usuario, id_sede);
        formulario.setExtendedState(MAXIMIZED_BOTH);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        Fm_Clientes formulario = new Fm_Clientes(id_usuario, id_sede);
        formulario.setExtendedState(MAXIMIZED_BOTH);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

        Fm_Usuario formulario = new Fm_Usuario(0, id_sede);
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed

        Fm_Perfil formulario = new Fm_Perfil(0);
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed

        Importacion_Producto formulario = new Importacion_Producto();
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed

        Fm_Sede formulario = new Fm_Sede(id_usuario, id_sede, 0);
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed

        Fm_Sede formulario = new Fm_Sede(id_usuario, id_sede, 1);
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        jTabbedPane1.setSelectedIndex(3);
        Fm_Fac_cat6_tipodoc formulario = new Fm_Fac_cat6_tipodoc();
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed

        Fm_Perfil formulario = new Fm_Perfil(1);
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed

        Fm_Usuario formulario = new Fm_Usuario(1, id_sede);
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed

        Fm_Cntcarga formulario = new Fm_Cntcarga(id_usuario, id_sede);
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed

        Fm_Sedeconfig formulario = new Fm_Sedeconfig(id_usuario, id_sede);
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        jTabbedPane1.setSelectedIndex(4);
        Fm_Fac_cat7_igv formulario = new Fm_Fac_cat7_igv();
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        jTabbedPane1.setSelectedIndex(7);
        Fm_Fac_grupo_igv formulario = new Fm_Fac_grupo_igv();
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
        Fm_Fac_cat3_umedida formulario = new Fm_Fac_cat3_umedida();
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
        Fm_Fac_cat2_moneda formulario = new Fm_Fac_cat2_moneda();
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem32ActionPerformed
        jTabbedPane1.setSelectedIndex(5);
        Fm_Fac_cat8_isc formulario = new Fm_Fac_cat8_isc();
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem32ActionPerformed

    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed
        jTabbedPane1.setSelectedIndex(6);
        Fm_Fac_cat17_oper formulario = new Fm_Fac_cat17_oper();
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem33ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        System.exit(-1);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        Fm_Marca formulario = new Fm_Marca(id_usuario, id_sede);
        formulario.setLocationRelativeTo(null);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

        Fm_Venta formulario = new Fm_Venta(id_usuario, id_sede);
        formulario.setExtendedState(MAXIMIZED_BOTH);
        formulario.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void chbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbEstadoActionPerformed

    private void chbEstadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chbEstadoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            btnGuardad.requestFocus();

        }
    }//GEN-LAST:event_chbEstadoKeyPressed

    private void btnPresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPresentacionActionPerformed

        BuscarPresentacion Presentacion = new BuscarPresentacion();
        frmPrincipal.tbn_escritorio.add(Presentacion);
        Presentacion.toFront();
        Presentacion.setVisible(true);
    }//GEN-LAST:event_btnPresentacionActionPerformed

    private void btnLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaboratorioActionPerformed
        BuscarLaboratorio Laboratorio = new BuscarLaboratorio();
        frmPrincipal.tbn_escritorio.add(Laboratorio);
        Laboratorio.toFront();
        Laboratorio.setVisible(true);
    }//GEN-LAST:event_btnLaboratorioActionPerformed

    private void txtDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtPresentacion.requestFocus();

        }
    }//GEN-LAST:event_txtDescripcionKeyPressed

    private void txtPresentacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresentacionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPresentacionKeyPressed

    private void txtConcentracionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConcentracionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConcentracionKeyPressed

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }

    }//GEN-LAST:event_txtStockKeyTyped

    private void txtStockKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockKeyPressed

    private void txtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo Números");
        }
    }//GEN-LAST:event_txtCostoKeyTyped

    private void txtCostoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoKeyPressed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo Números");
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioKeyPressed

    private void txtLaboratorioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLaboratorioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLaboratorioKeyTyped

    private void txtLaboratorioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLaboratorioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLaboratorioKeyPressed

    private void txtSanitarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSanitarioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSanitarioKeyTyped

    private void txtSanitarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSanitarioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSanitarioKeyPressed

    private void jtb_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_datosMouseClicked

        int row = jtb_datos.getSelectedRow();
        // l.setBackground(new Color(203, 159, 41));

        //        Date fec = jtb_datos.getValueAt(row, 7).toString();
        txtId.setText(jtb_datos.getValueAt(row, 0).toString());
        txtDescripcion.setText(jtb_datos.getValueAt(row, 2).toString());
        txtSanitario.setText(jtb_datos.getValueAt(row, 3).toString());
        txtSanitario.setText(jtb_datos.getValueAt(row, 4).toString());
        txtSanitario.setText(jtb_datos.getValueAt(row, 5).toString());
        txtSanitario.setText(jtb_datos.getValueAt(row, 6).toString());
        txtSanitario.setText(jtb_datos.getValueAt(row, 8).toString());
        //        jdtFecha.setDate(fec);

        //        jdtFecha.setText(7,((JTextField)frmProductos.jdtFecha.getDateEditor().getUiComponent()).getText());
        String est = jtb_datos.getValueAt(row, 10).toString();
        if (est.equals("Activo")) {
            chbEstado.setSelected(true);
        } else {
            chbEstado.setSelected(false);
        }
        num = 1;
    }//GEN-LAST:event_jtb_datosMouseClicked

    private void btnGuardadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardadActionPerformed
        double costo, precio;
        //VALIDAR CAMPOS PARA QUE TODOS ESTEN LLENOS
        //--------------------------------------------------
        if (txtDescripcion.getText().isEmpty() || txtSanitario.getText().isEmpty() || txtSanitario.getText().isEmpty() || txtPresentacion.getText().isEmpty()
            || txtSanitario.getText().isEmpty() || txtSanitario.getText().isEmpty() || txtLaboratorio.getText().isEmpty() || txtSanitario.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos");
            //--------------------------------------------------
        } else {
            costo= Double.parseDouble(txtSanitario.getText());
            precio= Double.parseDouble(txtSanitario.getText());

            if(costo > 0){
                if (precio > costo){

                    String ID = txtId.getText();
                    String Descripcion = txtDescripcion.getText();
                    String Concentracion = txtSanitario.getText();
                    int Stock = Integer.parseInt(txtSanitario.getText());
                    float Costo = Float.parseFloat(txtSanitario.getText());
                    float Precio = Float.parseFloat(txtSanitario.getText());
                    String RegistroSanitario = txtSanitario.getText();

                    Date Fecha = jdtFecha.getDate();
                    Long d = Fecha.getTime();
                    java.sql.Date fecha = new java.sql.Date(d);

                    String Estado;
                    if (chbEstado.isSelected()) {
                        Estado = "Activo";
                    } else {
                        Estado = "Inactivo";
                    }

                    String Presentacion = txtIdPresentacion.getText();
                    String Laboratorio = txtIdLaboratorio.getText();

                    if (num == 0) {
                        int respuesta = metodos.guardarProductos(Descripcion, Concentracion, Stock, Costo, Precio, RegistroSanitario, fecha, Estado, Presentacion, Laboratorio);
                        if (respuesta > 0) {
                            listar();

                            limpiar();
                        }
                    }if (num != 0) {
                        int respuesta = metodos.ActualizarDatos(ID, Descripcion, Concentracion, Stock, Costo, Precio, RegistroSanitario, fecha, Estado, Presentacion, Laboratorio);
                        if (respuesta > 0) {
                            listar();
                            num = 0;
                        }
                    }
                } else{
                    JOptionPane.showMessageDialog(null, "El precio de venta no puede ser menor o igual al costo del Producto");
                }
            }else{
                JOptionPane.showMessageDialog(null, "El costo del producto no puede ser menor o igual a 0");
            }
        }
    }//GEN-LAST:event_btnGuardadActionPerformed

    private void btnGuardadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardadKeyPressed
        double costo, precio;
        //VALIDAR CAMPOS PARA QUE TODOS ESTEN LLENOS
        //--------------------------------------------------
        if (txtDescripcion.getText().isEmpty() || txtSanitario.getText().isEmpty() || txtSanitario.getText().isEmpty() || txtPresentacion.getText().isEmpty()
            || txtSanitario.getText().isEmpty() || txtSanitario.getText().isEmpty() || txtLaboratorio.getText().isEmpty() || txtSanitario.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos");
            //--------------------------------------------------
        } else {
            costo= Double.parseDouble(txtSanitario.getText());
            precio= Double.parseDouble(txtSanitario.getText());
            if (precio > costo){

                String ID = txtId.getText();
                String Descripcion = txtDescripcion.getText();
                String Concentracion = txtSanitario.getText();
                int Stock = Integer.parseInt(txtSanitario.getText());
                float Costo = Float.parseFloat(txtSanitario.getText());
                float Precio = Float.parseFloat(txtSanitario.getText());
                String RegistroSanitario = txtSanitario.getText();

                Date Fecha = jdtFecha.getDate();
                Long d = Fecha.getTime();
                java.sql.Date fecha = new java.sql.Date(d);

                String Estado;
                if (chbEstado.isSelected()) {
                    Estado = "Activo";
                } else {
                    Estado = "Inactivo";
                }

                String Presentacion = txtIdPresentacion.getText();
                String Laboratorio = txtIdLaboratorio.getText();

                if (num == 0) {
                    int respuesta = metodos.guardarProductos(Descripcion, Concentracion, Stock, Costo, Precio, RegistroSanitario, fecha, Estado, Presentacion, Laboratorio);
                    if (respuesta > 0) {
                        listar();

                        limpiar();
                    }
                }if (num != 0) {
                    int respuesta = metodos.ActualizarDatos(ID, Descripcion, Concentracion, Stock, Costo, Precio, RegistroSanitario, fecha, Estado, Presentacion, Laboratorio);
                    if (respuesta > 0) {
                        listar();
                        num = 0;
                    }
                }
            } else{
                JOptionPane.showMessageDialog(null, "El precio de venta no puede ser menor o igual al costo del Producto");
            }
        }
    }//GEN-LAST:event_btnGuardadKeyPressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int fila = jtb_datos.getSelectedRowCount();
        if (fila < 1) {
            JOptionPane.showMessageDialog(null, "Seleccione Un registro de la tabla");
        } else if(fila==1){
            int result = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el registro?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                if (CP.EliminarDatos(jtb_datos.getValueAt(jtb_datos.getSelectedRow(), 0).toString()) > 0) {
                    limpiar();
                    listar();
                }
            }if (result == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Eliminación cancelada!");

            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jbt_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_limpiarActionPerformed

        txtId.setText("");
        txtDescripcion.setText("");
        txtSanitario.setText("");
        txtSanitario.setText("");
        txtPresentacion.setText("");
        chbEstado.setSelected(false);
        txtLaboratorio.setText("");
        txtSanitario.setText("");
        txtSanitario.setText("");
        txtSanitario.setText("");
        txtDescripcion.requestFocus();
    }//GEN-LAST:event_jbt_limpiarActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        JRReporte cr = new JRReporte();
        Connection con = null;
        try {
            con = ConexionBD.conectar();
            String ruta = System.getProperty("user.dir") + "\\src\\Reportes\\Productos.jrxml";
            cr.abrirReporte(ruta, con);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnCalcular1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcular1ActionPerformed
        BuscarIngresos();
        CrearTabla();
        VentasTotal();
        CantidadVenta();
        GananciaVenta();
    }//GEN-LAST:event_btnCalcular1ActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        TotalVentasRealizadas ventas=new Vista.TotalVentasRealizadas();
        frmPrincipal.tbn_escritorio.add(ventas);
        ventas.show();
    }//GEN-LAST:event_btnVentasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BuscarVenta();
        CrearTabla();
        CantidadTotal();
        VentasTotal();
        CantidadVenta();
        GananciaVenta();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblVenta1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVenta1MouseClicked

    }//GEN-LAST:event_tblVenta1MouseClicked

    private void cboTipoComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoComprobanteActionPerformed

        txtNombreCliente.setText("");
        txtCorreoCliente.setText("");
        txtDireccionCliente.setText("");
        lblIdCliente.setText("");
        txtDocumentoCliente.requestFocusInWindow();
    }//GEN-LAST:event_cboTipoComprobanteActionPerformed

    private void txtDocumentoClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoClienteKeyReleased

        String tipoComprobante = cboTipoComprobante.getSelectedItem().toString();
        if (tipoComprobante.equalsIgnoreCase("BOLETA DE VENTA ELECTRÓNICA")) {

            int ctnTexto = txtDocumentoCliente.getText().length();
            if (ctnTexto == 8) {

                if (controladorCliente.validaCliente(txtDocumentoCliente.getText())) {
                    int id_clienteVenta = Integer.parseInt(controladorCliente.obtieneDatosCliente("id_cliente", txtDocumentoCliente.getText()));
                    muestraClienteporId(id_clienteVenta);
                }

            } else {
                txtNombreCliente.setText("");
                txtCorreoCliente.setText("");
                txtDireccionCliente.setText("");
                lblIdCliente.setText("");
            }

        } else if (tipoComprobante.equalsIgnoreCase("FACTURA ELECTRÓNICA")) {
            int ctnTexto = txtDocumentoCliente.getText().length();
            if (ctnTexto == 11) {
                if (controladorCliente.validaCliente(txtDocumentoCliente.getText())) {
                    int id_clienteVenta = Integer.parseInt(controladorCliente.obtieneDatosCliente("id_cliente", txtDocumentoCliente.getText()));
                    muestraClienteporId(id_clienteVenta);
                }
            } else {
                txtNombreCliente.setText("");
                txtCorreoCliente.setText("");
                txtDireccionCliente.setText("");
                lblIdCliente.setText("");
            }

        }

    }//GEN-LAST:event_txtDocumentoClienteKeyReleased

    private void txtNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteActionPerformed

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed

        new Form_Cliente(null, true, 0, 0, "", id_usuario, id_sede).setVisible(true);
        if (Form_Cliente.valor == 1) {

            int id_clienteRegistro = controladorCliente.obtenerEntero("Select max(id_cliente) from cliente where id_usuario='" + id_usuario + "' and id_sede='" + id_sede + "'");
            muestraClienteporId(id_clienteRegistro);

        } else {
            AlertaError alert = new AlertaError("Mensaje", "Operación Cancelada");
            alert.setVisible(true);
        }

    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        new Venta_Cliente(null, true, id_usuario, id_sede, "TODOS").setVisible(true);
        if (Venta_Cliente.valor == 1) {

            int id_clienteBusqueda = Integer.parseInt(lblIdCliente.getText());
            muestraClienteporId(id_clienteBusqueda);

        } else {
            AlertaError alert = new AlertaError("Mensaje", "Operación Cancelada");
            alert.setVisible(true);
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void tblDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetalleMouseClicked

    }//GEN-LAST:event_tblDetalleMouseClicked

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jcb_SexoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_SexoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtDni.requestFocus();

        }
    }//GEN-LAST:event_jcb_SexoKeyPressed

    private void txtIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtNombre.requestFocus();

        }
    }//GEN-LAST:event_txtIdKeyPressed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo Letras");
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtApellidos.requestFocus();

        }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtDniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtEmail.requestFocus();

        }
    }//GEN-LAST:event_txtDniKeyPressed

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtTelefono.requestFocus();

        }
    }//GEN-LAST:event_txtDireccionKeyPressed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo Números");
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtEspecialidad.requestFocus();

        }
    }//GEN-LAST:event_txtTelefonoKeyPressed

    private void txtEspecialidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEspecialidadKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo Letras");
        }
    }//GEN-LAST:event_txtEspecialidadKeyTyped

    private void txtEspecialidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEspecialidadKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtIngreso.requestFocus();

        }
    }//GEN-LAST:event_txtEspecialidadKeyPressed

    private void txtSueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo Números");
        }
    }//GEN-LAST:event_txtSueldoKeyTyped

    private void txtSueldoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            btnguardar.requestFocus();

        }
    }//GEN-LAST:event_txtSueldoKeyPressed

    private void txtIngresoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIngresoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtSalida.requestFocus();

        }
    }//GEN-LAST:event_txtIngresoKeyPressed

    private void txtSalidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalidaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtSueldo.requestFocus();

        }
    }//GEN-LAST:event_txtSalidaKeyPressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        cargar(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jtb_EmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_EmpleadosMouseClicked
        int row = jtb_Empleados.getSelectedRow();
        txtId.setText(jtb_Empleados.getValueAt(row, 0).toString());
        txtNombre.setText(jtb_Empleados.getValueAt(row, 1).toString());
        txtApellidos.setText(jtb_Empleados.getValueAt(row, 2).toString());
        txtEspecialidad.setText(jtb_Empleados.getValueAt(row, 3).toString());
        jcb_Sexo.setSelectedItem(jtb_Empleados.getValueAt(row, 4).toString());
        txtDni.setText(jtb_Empleados.getValueAt(row, 5).toString());
        txtEmail.setText(jtb_Empleados.getValueAt(row, 6).toString());
        txtTelefono.setText(jtb_Empleados.getValueAt(row, 7).toString());
        txtDireccion.setText(jtb_Empleados.getValueAt(row, 8).toString());
        txtIngreso.setText(jtb_Empleados.getValueAt(row, 9).toString());
        txtSalida.setText(jtb_Empleados.getValueAt(row, 10).toString());
        txtSueldo.setText(jtb_Empleados.getValueAt(row, 11).toString());
        String est = jtb_Empleados.getValueAt(row, 12).toString();
        if (est.equals("Activo")) {
            chbEstado.setSelected(true);
        } else {
            chbEstado.setSelected(false);
        }

        nums = 1;
    }//GEN-LAST:event_jtb_EmpleadosMouseClicked

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        nuevo();
        jcb_Sexo.setSelectedIndex(0);
        txtIngreso.setText("0:00 am");
        txtSalida.setText("0:00 pm");
        txtId.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtDni.setText("");
        txtEmail.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtEspecialidad.setText("");
        txtSueldo.setText("");
        txtNombre.requestFocus();
        chbEstado.setSelected(false);
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        //VALIDAR CAMPOS PARA QUE TODOS ESTEN LLENOS
        if (txtNombre.getText().isEmpty()
            || txtApellidos.getText().isEmpty() || txtDni.getText().isEmpty()
            || txtEmail.getText().isEmpty() || txtDireccion.getText().isEmpty()
            || txtTelefono.getText().isEmpty() || txtEspecialidad.getText().isEmpty() || txtSueldo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos");
            /*----------------------------------------------------------------------------*/
        } else {
            String Id = txtId.getText();
            String Nombres = txtNombre.getText();
            String Apellidos = txtApellidos.getText();
            String Especialidad = txtEspecialidad.getText();
            String Sexo = jcb_Sexo.getSelectedItem().toString();
            int DNI = Integer.parseInt(txtDni.getText());
            int Telefono = Integer.parseInt(txtTelefono.getText());
            String Email = txtEmail.getText();
            String Direccion = txtDireccion.getText();
            String Ingreso = txtIngreso.getText();
            String Salida = txtSalida.getText();
            float Sueldo = Float.parseFloat(txtSueldo.getText());
            int Usuario = Integer.parseInt(txtIdUsuario.getText());
            String Estado;
            if (chbEstado.isSelected()) {
                Estado = "Activo";
            } else {
                Estado = "Inactivo";
            }
            if (nums == 0) {
                if (metodos.Email(txtEmail.getText())) {
                    if (metodos.EmpleadoExistente(txtDni.getText()) == 0) {

                        int respuesta = metodos.guardarEmpleado(Nombres, Apellidos, Especialidad, Sexo, DNI, Email, Telefono, Direccion, Ingreso, Salida, Sueldo, Estado, Usuario);
                        if (respuesta > 0) {
                            listar();
                            limpiar();
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "El empleado ya esta registrado");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El correo electrónico no es valido");
                }
            }

            if (nums != 0) {
                if (metodos.Email(txtEmail.getText())) {
                    int respuesta = metodos.ActualizarEmpleado(Id, Nombres, Apellidos, Especialidad, Sexo, DNI, Email, Telefono, Direccion, Ingreso, Salida, Sueldo, Estado, Usuario);
                    if (respuesta > 0) {
                        listar();
                        limpiar();
                        nums = 0;
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El correo electrónico no es valido");
                }
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnguardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnguardarKeyPressed
        //VALIDAR CAMPOS PARA QUE TODOS ESTEN LLENOS
        if (txtNombre.getText().isEmpty()
            || txtApellidos.getText().isEmpty() || txtDni.getText().isEmpty()
            || txtEmail.getText().isEmpty() || txtDireccion.getText().isEmpty()
            || txtTelefono.getText().isEmpty() || txtEspecialidad.getText().isEmpty() || txtSueldo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos");
            /*----------------------------------------------------------------------------*/
        } else {
            String Id = txtId.getText();
            String Nombres = txtNombre.getText();
            String Apellidos = txtApellidos.getText();
            String Especialidad = txtEspecialidad.getText();
            String Sexo = jcb_Sexo.getSelectedItem().toString();
            int DNI = Integer.parseInt(txtDni.getText());
            int Telefono = Integer.parseInt(txtTelefono.getText());
            String Email = txtEmail.getText();
            String Direccion = txtDireccion.getText();
            String Ingreso = txtIngreso.getText();
            String Salida = txtSalida.getText();
            float Sueldo = Float.parseFloat(txtSueldo.getText());
            int Usuario = Integer.parseInt(txtIdUsuario.getText());
            String Estado;
            if (chbEstado.isSelected()) {
                Estado = "Activo";
            } else {
                Estado = "Inactivo";
            }
            if (nums == 0) {
                if (metodos.Email(txtEmail.getText())) {
                    if (metodos.EmpleadoExistente(txtDni.getText()) == 0) {

                        int respuesta = metodos.guardarEmpleado(Nombres, Apellidos, Especialidad, Sexo, DNI, Email, Telefono, Direccion, Ingreso, Salida, Sueldo, Estado, Usuario);
                        if (respuesta > 0) {
                            listar();
                            limpiar();
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "El empleado ya esta registrado");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El correo electrónico no es valido");
                }
            }

            if (nums != 0) {
                if (metodos.Email(txtEmail.getText())) {
                    int respuesta = metodos.ActualizarEmpleado(Id, Nombres, Apellidos, Especialidad, Sexo, DNI, Email, Telefono, Direccion, Ingreso, Salida, Sueldo, Estado, Usuario);
                    if (respuesta > 0) {
                        listar();
                        limpiar();
                        nums = 0;
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El correo electrónico no es valido");
                }
            }
        }
    }//GEN-LAST:event_btnguardarKeyPressed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        int fila = jtb_Empleados.getSelectedRowCount();
        if (fila < 1) {
            JOptionPane.showMessageDialog(null, "SELECCIONE UN REGISTRO DE LA TABLA");
        } else if(fila==1){
            int result = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el registro?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                if (CP.EliminarEmpleado(jtb_Empleados.getValueAt(jtb_Empleados.getSelectedRow(), 0).toString()) > 0) {
                    limpiar();
                    listar();
                }
            }
            if (result == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Registro no Eliminado!");
            }
        }
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        mirar();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void jtbPresentacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbPresentacionMouseClicked
        int row = jtbPresentacion.getSelectedRow();
        txtId.setText(jtbPresentacion.getValueAt(row, 0).toString());
        txtDescripcion.setText(jtbPresentacion.getValueAt(row, 1).toString());
        String est = jtbPresentacion.getValueAt(row, 2).toString();
        if (est.equals("Activo")) {
            jchEstado.setSelected(true);
        } else {
            jchEstado.setSelected(false);
        }
        num = 1;
    }//GEN-LAST:event_jtbPresentacionMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //VALIDAR CAMPOS PARA QUE TODOS ESTEN LLENOS
        //--------------------------------------------------
        if (txtDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos");
            //--------------------------------------------------
        } else {

            String ID = txtId.getText();
            String Descripcion = txtDescripcion.getText();
            String Estado;
            if (jchEstado.isSelected()) {
                Estado = "Activo";
            } else {
                Estado = "Inactivo";
            }
            if (num == 0) {
                int respuesta = metodos.guardarComprobante(Descripcion, Estado);
                if (respuesta > 0) {
                    listar();

                    limpiar();
                }
            } else {
                int respuesta = metodos.ActualizarDatos(ID, Descripcion, Estado);
                if (respuesta > 0) {
                    listar();
                    num = 0;
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
        txtDescripcion.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedorActionPerformed
        BuscarProveedor proveedor = new BuscarProveedor();
        frmPrincipal.tbn_escritorio.add(proveedor);
        proveedor.toFront();
        proveedor.setVisible(true);
    }//GEN-LAST:event_btnBuscarProveedorActionPerformed

    private void btnBuscarComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarComprobanteActionPerformed

        BuscarComprobanteCompra Comprobante = new BuscarComprobanteCompra();
        CentrarVentana(Comprobante);
    }//GEN-LAST:event_btnBuscarComprobanteActionPerformed

    private void txtCodigoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProductoActionPerformed

    private void txtCodigoProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProductoKeyReleased
        /*BuscarProductoPorCodigo();
        int keyCode = evt.getKeyCode();
        if (keyCode==KeyEvent.VK_ENTER) txtCantidadProducto.requestFocus();*/
    }//GEN-LAST:event_txtCodigoProductoKeyReleased

    private void txtCodigoProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProductoKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_txtCodigoProductoKeyTyped

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        accion = "ProductoCompra";
        BuscarProductosCompras producto= new BuscarProductosCompras();
        frmPrincipal.tbn_escritorio.add(producto);
        producto.toFront();
        producto.setVisible(true);
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void txtNumeroCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroCompraActionPerformed

    private void txtTipoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoPagoActionPerformed

    private void txtIdProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProveedorActionPerformed

    private void txtCantidadProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProductoKeyReleased
        CalcularTotal();
        int keyCode = evt.getKeyCode();
        if (keyCode==KeyEvent.VK_ENTER) btnAgregarProducto.requestFocus();
    }//GEN-LAST:event_txtCantidadProductoKeyReleased

    private void txtCantidadProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProductoKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_txtCantidadProductoKeyTyped

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        double stock,cant;

        if (!txtCantidadProducto.getText().equals("")){
            if(txtCantidadProducto.getText().equals("")){
                txtCantidadProducto.setText("0");
                cant=Double.parseDouble(txtCantidadProducto.getText());
            }else{
                cant=Double.parseDouble(txtCantidadProducto.getText());
            }

            if(cant>0){

                int d1=Integer.parseInt(txtCodigoProducto.getText());
                String d2=txtNombreProducto.getText();
                String d3=txtPresentacionProducto.getText();
                String d4=txtConcentracionProducto.getText();
                double d5=Double.parseDouble(txtCantidadProducto.getText());
                double d6=Double.parseDouble(txtPrecioProducto.getText());
                double d7=Double.parseDouble(txtTotalProducto.getText());
                agregardatos(d1,d2,d3,d4,d5,d6,d7);

                CalcularTotal_Compra();
                CalcularSubTotal();
                CalcularIGV();

                txtCantidadProducto.setText("");
                txtTotalProducto.setText("");
                txtCodigoProducto.requestFocus();

            }else{
                JOptionPane.showMessageDialog(null, "Ingrese Cantidad mayor a 0");
                txtCantidadProducto.requestFocus();
            }

        }else{
            JOptionPane.showMessageDialog(null, "Ingrese cantidad");
            txtCantidadProducto.requestFocus();
        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        int fila = tblDetalleProducto.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una fila", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else//de lo contrario si se selecciono la fila
        {

            if (fila > 0) {
                dtmDetalle.removeRow(fila);
                CalcularTotal_Compra();
                CalcularSubTotal();
                CalcularIGV();
            } else if (fila == 0) {
                dtmDetalle.removeRow(fila);
                txtSubTotal.setText("0.0");
                txtIGV.setText("0.0");
                txtTotalCompra.setText("0.0");

                CalcularTotal_Compra();
                CalcularSubTotal();
                CalcularIGV();
            }
        }
        CalcularTotal_Compra();
        CalcularSubTotal();
        CalcularIGV();

    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnLimpiarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarTablaActionPerformed
        limpiarTabla();
        txtSubTotal.setText("0.0");
        txtIGV.setText("0.0");
        txtTotalCompra.setText("0.0");

        //        txtNombreProveedor.setText("");
        //        txtRuc.setText("");
        //        txtComprobante.setText("");
        //
        //        txtCodigoProducto.setText("");
        //        txtNombreProducto.setText("");
        //        txtPresentacionProducto.setText("");
        //        txtConcentracionProducto.setText("");
    }//GEN-LAST:event_btnLimpiarTablaActionPerformed

    private void btnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo1ActionPerformed
        accion="Nuevo";
        modificar();
        limpiarCampos();
    }//GEN-LAST:event_btnNuevo1ActionPerformed

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        if (txtComprobante.getText().isEmpty() || txtNombreProveedor.getText().isEmpty() || txtNumeroCompra.getText().isEmpty() || txtCantidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos");
            //--------------------------------------------------
        } else {
            int result = JOptionPane.showConfirmDialog(this, "¿Desea Generar la Compra?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                Metodos_Compra compras=new Metodos_Compra();
                String Numero = txtNumeroCompra.getText();
                String Fecha = txtFecha.getText();
                String TipoPago = txtTipoPago.getText();
                String SubTotal = txtSubTotal.getText();
                String Total = txtTotalCompra.getText();
                String Igv = txtIGV.getText();
                String Estado = estado;
                String IdProveedor = txtIdProveedor.getText();
                String IdEmpleados = txtIdEmpleado.getText();
                String IdTipoComprobante = txtIdComprobante.getText();
                //+++++++++++++++++++++++
                if (num == 0) {
                    compras.GuardarCompras(Numero, Fecha, TipoPago, SubTotal, Total, Igv, Estado, IdProveedor, IdEmpleados, IdTipoComprobante);
                    guardarDetalle();
                }
                mirar();
                limpiarTabla();
                numCompra=generaNumCompra();
                txtNumeroCompra.setText(numCompra);

            }
            if (result == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Compra Anulada!");
            }
            btnReporte.setEnabled(true);
        }
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        mirar();
        limpiarTabla();
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void btnReporte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporte1ActionPerformed
        JRReporte cr = new JRReporte();
        Connection con = null;

        try {
            con = ConexionBD.conectar();
            Map parametros = new HashMap();
            parametros.put("IdCompra", txtUltimoId.getText());
            String ruta = System.getProperty("user.dir") + "\\src\\Reportes\\Compras.jrxml";
            cr.abrirReporte(ruta, con, parametros);
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el reporte de Ventas", "ERROR", JOptionPane.ERROR_MESSAGE);

        }

        btnReporte.setEnabled(false);
    }//GEN-LAST:event_btnReporte1ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        BuscarCompra();
        CrearTabla();
        CantidadTotal();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed

        if(lblIdCompra.getText().isEmpty()){

            JOptionPane.showMessageDialog(this, "¡Se debe seleccionar un registro de compra!");
        }else{
            int fila_s = tblCompra.getSelectedRow();
            String est_compra=String.valueOf(tblCompra.getModel().getValueAt(fila_s, 6));

            if(tblCompra.getSelectedRows().length > 0 ){
                if(!est_compra.equals("ANULADO")){
                    int result = JOptionPane.showConfirmDialog(this, "¿Desea anular la compra?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        Metodos_Compra compras=new Metodos_Compra();
                        String Estado = estado;
                        compras.actualizarCompraEstado(lblIdCompra.getText(), Estado);

                        BuscarCompra();
                        CrearTabla();
                    }
                    if (result == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null, "Anulación Cancelada!");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "¡Esta compra ya ha sido ANULADA!");
                }
            }
        }
    }//GEN-LAST:event_btnAnularActionPerformed

    private void tblCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCompraMouseClicked
        int fila;
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        fila = tblCompra.getSelectedRow();

        if (fila == -1){
            JOptionPane.showMessageDialog(null, "Se debe seleccionar un registro");
        }else{
            defaultTableModel = (DefaultTableModel)tblCompra.getModel();
            //strCodigo =  ((String) defaultTableModel.getValueAt(fila, 0));
            lblIdCompra.setText((String) defaultTableModel.getValueAt(fila, 0));

        }
        BuscarCompraDetalle();
        CrearTablaDetalle();
    }//GEN-LAST:event_tblCompraMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        BuscarVenta();
        CrearTabla();
        CantidadTotal();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnAnular1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnular1ActionPerformed

        if(lblIdVenta.getText().isEmpty()){

            JOptionPane.showMessageDialog(this, "¡Se debe seleccionar un registro de venta!");
        }else{
            int fila_s = tblVenta.getSelectedRow();
            String est_venta=String.valueOf(tblVenta.getModel().getValueAt(fila_s, 7));

            if(tblVenta.getSelectedRows().length > 0 ){
                if(!est_venta.equals("ANULADO")){
                    int result = JOptionPane.showConfirmDialog(this, "¿Desea anular la venta?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        Metodos_Ventas ventas=new Metodos_Ventas();
                        String Estado = estado;
                        ventas.actualizarVentaEstado(lblIdVenta.getText(), Estado);

                        BuscarVenta();
                        CrearTabla();
                    }
                    if (result == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null, "Anulación Cancelada!");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "¡Esta venta ya ha sido ANULADA!");
                }
            }
        }
    }//GEN-LAST:event_btnAnular1ActionPerformed

    private void tblVenta2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVenta2MouseClicked
        int fila;
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        fila = tblVenta.getSelectedRow();

        if (fila == -1){
            JOptionPane.showMessageDialog(null, "Se debe seleccionar un registro");
        }else{
            defaultTableModel = (DefaultTableModel)tblVenta.getModel();
            //strCodigo =  ((String) defaultTableModel.getValueAt(fila, 0));
            lblIdVenta.setText((String) defaultTableModel.getValueAt(fila, 0));
            lblComprobante.setText((String) defaultTableModel.getValueAt(fila, 4));

        }
        BuscarVentaDetalle();
        CrearTablaDetalle();
    }//GEN-LAST:event_tblVenta2MouseClicked

    private void rbtndesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtndesActionPerformed
        // TODO add your handling code here:
        if(rbtndes.isSelected()==true)
        {
            listar();
            txtBuscar.setEnabled(true);
            btnbuscar.setEnabled(true);
            txtBuscar.requestFocus();

            txtPresentacion.setEnabled(false);
            txtPresentacion.setText("");
        }
    }//GEN-LAST:event_rbtndesActionPerformed

    private void rbtntodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtntodoActionPerformed
        // TODO add your handling code here:
        if(rbtntodo.isSelected()==true)
        {
            btnbuscar.setEnabled(false);
            txtCantidad.setEnabled(false);
            txtBuscar.setEnabled(false);
            txtBuscar.setText("");
            txtPresentacion.setEnabled(false);
            txtPresentacion.setText("");
            listar();
        }

    }//GEN-LAST:event_rbtntodoActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        String buscar=txtBuscar.getText();
        if(rbtndes.isSelected()==true)
        {
            DefaultTableModel tabla= new DefaultTableModel();
            String []titulos={"CODIGO","DESCRIPCIÓN","CATEGORÍA","CANTIDAD","COSTO","PRECIO","ESTADO"};
            tabla.setColumnIdentifiers(titulos);
            this.tbProductos.setModel(tabla);
            String consulta= "SELECT * FROM producto WHERE pro_Categoria  LIKE '%"+buscar+"%'";
            String []Datos= new String [7];
            try {
                Statement st = cn.createStatement();
                ResultSet rs= st.executeQuery(consulta);
                while(rs.next())
                {
                    Datos[0]=rs.getString("pro_ID");
                    Datos[1]=rs.getString("pro_Descripcion");
                    Datos[2]=rs.getString("pro_Categoria");
                    Datos[3]=rs.getString("pro_Cantidad");
                    Datos[4]=rs.getString("pro_Costo");
                    Datos[5]=rs.getString("pro_Precio");
                    Datos[6]=rs.getString("pro_Estado");
                    tabla.addRow(Datos);
                }
                tbProductos.setModel(tabla);
                txtCantidad.setText(""+tbProductos.getRowCount());
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else
        {
            listar();
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtBuscar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar1KeyReleased
        BuscarProductos();
    }//GEN-LAST:event_txtBuscar1KeyReleased

    private void rbtPresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtPresActionPerformed
        if(rbtPres.isSelected()==true)
        {
            txtBuscar.setEnabled(false);
            txtBuscar.setText("");
            txtPresentacion.setEnabled(true);
            btnbuscar.setEnabled(true);
            txtPresentacion.requestFocus();
        }
    }//GEN-LAST:event_rbtPresActionPerformed

    private void rdgenero2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdgenero2ActionPerformed
        // TODO add your handling code here:
        if(rdgenero.isSelected()==true)
        {
            txtNombre.requestFocus();
            txtNombre.setText("");
            txtNombre.setEnabled(true);
            txtDni.setEnabled(false);
            txtDni.setText("");
            txtRuc.setEnabled(false);
            txtRuc.setText("");
            btnbuscar.setEnabled(true);
            CargarlistaProveedores();

        }
    }//GEN-LAST:event_rdgenero2ActionPerformed

    private void rddni2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rddni2ActionPerformed
        // TODO add your handling code here:
        if(rddni.isSelected()==true)
        {
            txtNombre.setText("");
            txtNombre.setEnabled(false);
            txtDni.setEnabled(true);
            txtDni.requestFocus();
            txtRuc.setText("");
            txtRuc.setEnabled(false);
            btnbuscar.setEnabled(true);
            CargarlistaProveedores();
        }
    }//GEN-LAST:event_rddni2ActionPerformed

    private void rdtodo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdtodo2ActionPerformed
        // TODO add your handling code here:
        CargarlistaProveedores();
        txtNombre.setText("");
        txtNombre.setEnabled(false);
        txtDni.setText("");
        txtDni.setEnabled(false);
        txtRuc.setEnabled(false);
        txtRuc.setText("");
        btnbuscar.setEnabled(false);
    }//GEN-LAST:event_rdtodo2ActionPerformed

    private void btnbuscar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar3ActionPerformed

        // TODO add your handling code here:
        String Nombre= txtNombre.getText();
        String dni=txtDni.getText();
        String Ruc=txtRuc.getText();

        if(rdgenero.isSelected()==true)
        {
            DefaultTableModel modelo= new DefaultTableModel();
            String[] Titulos = {"Id", "Nombres", "Dni", "Ruc", "Dirección","Email", "Teléfono", "Banco", "Cuenta", "Estado"};
            modelo.setColumnIdentifiers(Titulos);
            this.tbProveedores.setModel(modelo);
            try {

                String ConsultaSQL="SELECT * FROM proveedor WHERE Nombre='"+Nombre+"'";

                String []registros= new String[10];

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(ConsultaSQL);
                while(rs.next())
                {
                    registros[0] = rs.getString("IdProveedor");
                    registros[1] = rs.getString("Nombre");
                    registros[2] = rs.getString("Dni");
                    registros[3] = rs.getString("Ruc");
                    registros[4] = rs.getString("Direccion");
                    registros[5] = rs.getString("Email");
                    registros[6] = rs.getString("Telefono");
                    registros[7] = rs.getString("Banco");
                    registros[8] = rs.getString("Cuenta");
                    registros[9] = rs.getString("Estado");
                    modelo.addRow(registros);

                }
                tbProveedores.setModel(modelo);
                txtCantidad.setText(""+tbProveedores.getRowCount());
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if(rddni.isSelected()==true)
        {
            DefaultTableModel modelo= new DefaultTableModel();
            String[] Titulos = {"Id", "Nombres", "Dni", "Ruc", "Dirección","Email", "Teléfono", "Banco", "Cuenta", "Estado"};
            modelo.setColumnIdentifiers(Titulos);
            this.tbProveedores.setModel(modelo);
            try {

                String ConsultaSQL="SELECT * FROM proveedor WHERE Dni='"+dni+"'";

                String []registros= new String[10];

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(ConsultaSQL);
                while(rs.next())
                {
                    registros[0] = rs.getString("IdProveedor");
                    registros[1] = rs.getString("Nombre");
                    registros[2] = rs.getString("Dni");
                    registros[3] = rs.getString("Ruc");
                    registros[4] = rs.getString("Direccion");
                    registros[5] = rs.getString("Email");
                    registros[6] = rs.getString("Telefono");
                    registros[7] = rs.getString("Banco");
                    registros[8] = rs.getString("Cuenta");
                    registros[9] = rs.getString("Estado");
                    modelo.addRow(registros);

                }
                tbProveedores.setModel(modelo);
                txtCantidad.setText(""+tbProveedores.getRowCount());
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProveedores.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if(rdEspecialidad.isSelected()==true)
        {
            DefaultTableModel modelo= new DefaultTableModel();
            String[] Titulos = {"Id", "Nombres", "Dni", "Ruc", "Dirección","Email", "Teléfono", "Banco", "Cuenta", "Estado"};
            modelo.setColumnIdentifiers(Titulos);
            this.tbProveedores.setModel(modelo);
            try {

                String ConsultaSQL="SELECT * FROM proveedor WHERE Ruc='"+Ruc+"'";

                String []registros= new String[10];

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(ConsultaSQL);
                while(rs.next())
                {
                    registros[0] = rs.getString("IdProveedor");
                    registros[1] = rs.getString("Nombre");
                    registros[2] = rs.getString("Dni");
                    registros[3] = rs.getString("Ruc");
                    registros[4] = rs.getString("Direccion");
                    registros[5] = rs.getString("Email");
                    registros[6] = rs.getString("Telefono");
                    registros[7] = rs.getString("Banco");
                    registros[8] = rs.getString("Cuenta");
                    registros[9] = rs.getString("Estado");
                    modelo.addRow(registros);

                }
                tbProveedores.setModel(modelo);
                txtCantidad.setText(""+tbProveedores.getRowCount());
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProveedores.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if(rdtodo.isSelected()==true)
        {
            CargarlistaProveedores();
        }

    }//GEN-LAST:event_btnbuscar3ActionPerformed

    private void rdEspecialidad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdEspecialidad2ActionPerformed
        if(rdEspecialidad.isSelected()==true)
        {
            txtNombre.setText("");
            txtNombre.setEnabled(false);
            txtDni.setEnabled(false);
            txtDni.setText("");
            txtRuc.setEnabled(true);
            txtRuc.requestFocus();
            btnbuscar.setEnabled(true);
            CargarlistaProveedores();
        }
    }//GEN-LAST:event_rdEspecialidad2ActionPerformed

    private void txtDni2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDni2KeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
        int i = txtDni.getText().length();
        if (txtDni.getText().trim().length() < 8) {

        } else {
            i = 10;
            String com = txtDni.getText().substring(0, 7);
            txtDni.setText("");
            txtDni.setText(com);
        }
    }//GEN-LAST:event_txtDni2KeyTyped

    private void txtRuc3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRuc3KeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
        int i = txtRuc.getText().length();
        if (txtRuc.getText().trim().length() < 11) {

        } else {
            i = 10;
            String com = txtRuc.getText().substring(0, 10);
            txtRuc.setText("");
            txtRuc.setText(com);
        }
    }//GEN-LAST:event_txtRuc3KeyTyped

    private void rbtCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtCategoriaActionPerformed
        // TODO add your handling code here:
        if(rbtCategoria.isSelected()==true)
        {
            txtCategoria.setEnabled(true);
            txtCategoria.setText("");
            txtId.setEnabled(false);
            txtId.setText("");
            txtEstado.setEnabled(false);
            txtEstado.setText("");
            btnGenerar.setEnabled(true);
            txtCategoria.requestFocus();
            listar();
        }
    }//GEN-LAST:event_rbtCategoriaActionPerformed

    private void rbtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtIdActionPerformed
        if(rbtId.isSelected()==true)
        {
            txtId.setEnabled(true);
            txtId.setText("");
            txtCategoria.setEnabled(false);
            txtEstado.setEnabled(false);
            txtCategoria.setText("");
            txtEstado.setText("");
            btnGenerar.setEnabled(true);
            txtId.requestFocus();
            listar();
        }
    }//GEN-LAST:event_rbtIdActionPerformed

    private void rbtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtEstadoActionPerformed
        if(rbtEstado.isSelected()==true)
        {
            txtEstado.setEnabled(true);
            txtEstado.setText("");
            txtCategoria.setEnabled(false);
            txtCategoria.setText("");
            txtId.setEnabled(false);
            txtId.setText("");
            btnGenerar.setEnabled(true);
            txtEstado.requestFocus();
            listar();
        }
    }//GEN-LAST:event_rbtEstadoActionPerformed

    private void rbtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtTotalActionPerformed
        // TODO add your handling code here:
        if(rbtTotal.isSelected()==true)
        {
            txtCategoria.setEnabled(false);
            txtCategoria.setText("");
            txtId.setEnabled(false);
            txtId.setText("");
            txtEstado.setEnabled(false);
            txtEstado.setText("");
            listar();
        }

    }//GEN-LAST:event_rbtTotalActionPerformed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }

    }//GEN-LAST:event_txtIdKeyTyped

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed

        JRReporte cr = new JRReporte();
        Connection con = null;

        if(rbtCategoria.isSelected()==true)
        {
            if (txtCategoria.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "por favor complete el campo vacío");
                txtCategoria.requestFocus();
                //--------------------------------------------------
            } else {
                try {
                    con = ConexionBD.conectar();
                    Map parametros = new HashMap();
                    parametros.put("Categoria", txtCategoria.getText());
                    String ruta = System.getProperty("user.dir") + "\\src\\Reportes\\ProdCat.jrxml";
                    cr.abrirReporte(ruta, con, parametros);
                    con.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al cargar el reporte de Empleados", "ERROR", JOptionPane.ERROR_MESSAGE);

                }
            }
        }
        if(rbtTotal.isSelected()==true)
        {
            try {
                con = ConexionBD.conectar();
                String ruta = System.getProperty("user.dir") + "\\src\\Reportes\\Productos.jrxml";
                cr.abrirReporte(ruta, con);
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cargar el reporte de Empleados", "ERROR", JOptionPane.ERROR_MESSAGE);

            }

        }
        if(rbtId.isSelected()==true)
        {
            if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "por favor complete el campo vacío");
                txtId.requestFocus();
                //--------------------------------------------------
            } else {
                try {
                    con = ConexionBD.conectar();
                    Map parametros = new HashMap();
                    parametros.put("ID", txtId.getText());
                    String ruta = System.getProperty("user.dir") + "\\src\\Reportes\\ProID.jrxml";
                    cr.abrirReporte(ruta, con, parametros);
                    con.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al cargar el reporte de Empleados", "ERROR", JOptionPane.ERROR_MESSAGE);

                }
            }
        }
        if(rbtEstado.isSelected()==true)
        {
            if (txtEstado.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "por favor complete el campo vacío");
                txtEstado.requestFocus();
                //--------------------------------------------------
            } else {
                try {
                    con = ConexionBD.conectar();
                    Map parametros = new HashMap();
                    parametros.put("Estado", txtEstado.getText());
                    String ruta = System.getProperty("user.dir") + "\\src\\Reportes\\ProdEstado.jrxml";
                    cr.abrirReporte(ruta, con, parametros);
                    con.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al cargar el reporte de Empleados", "ERROR", JOptionPane.ERROR_MESSAGE);

                }
            }
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void tbProductos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductos1MouseClicked
        int row = tbProductos.getSelectedRow();
        txtCategoria.setText(tbProductos.getValueAt(row, 1).toString());
        txtId.setText(tbProductos.getValueAt(row, 0).toString());
        txtEstado.setText(tbProductos.getValueAt(row, 10).toString());
    }//GEN-LAST:event_tbProductos1MouseClicked

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void cboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTipoActionPerformed

    private void cboTipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboTipoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            btnregistrar.requestFocus();

        }
    }//GEN-LAST:event_cboTipoKeyPressed

    private void txtIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtDni.requestFocus();

        }
    }//GEN-LAST:event_txtIDKeyPressed

    private void txtDni3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDni3KeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo Números");
        }
    }//GEN-LAST:event_txtDni3KeyTyped

    private void txtDni3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDni3KeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtApellidos.requestFocus();

        }
    }//GEN-LAST:event_txtDni3KeyPressed

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo Letras");
        }
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtApellidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtNombres.requestFocus();

        }
    }//GEN-LAST:event_txtApellidosKeyPressed

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo Letras");
        }
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtNombresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtEmail.requestFocus();

        }
    }//GEN-LAST:event_txtNombresKeyPressed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtUsuario.requestFocus();

        }
    }//GEN-LAST:event_txtEmailKeyPressed

    private void txtUsuario1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuario1KeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtContraseña.requestFocus();

        }
    }//GEN-LAST:event_txtUsuario1KeyPressed

    private void txtContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            cboTipo.requestFocus();

        }
    }//GEN-LAST:event_txtContraseñaKeyPressed

    private void btnPresentacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPresentacion1ActionPerformed

        BuscarEmpleados Presentacion = new BuscarEmpleados();
        frmPrincipal.tbn_escritorio.add(Presentacion);
        Presentacion.toFront();
        Presentacion.setVisible(true);
    }//GEN-LAST:event_btnPresentacion1ActionPerformed

    private void tbUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuarioMouseClicked
        int row = tbUsuario.getSelectedRow();
        //        Id=(tbUsuario.getValueAt(row, 0).toString());
        txtID.setText(tbUsuario.getValueAt(row, 0).toString());
        txtDni.setText(tbUsuario.getValueAt(row, 3).toString());
        txtApellidos.setText(tbUsuario.getValueAt(row, 2).toString());
        txtNombres.setText(tbUsuario.getValueAt(row, 1).toString());
        txtEmail.setText(tbUsuario.getValueAt(row, 4).toString());
        txtUsuario.setText(tbUsuario.getValueAt(row, 5).toString());
        txtContraseña.setText(tbUsuario.getValueAt(row, 6).toString());
        cboTipo.setSelectedItem(tbUsuario.getValueAt(row, 7).toString());
        String est = tbUsuario.getValueAt(row, 8).toString();
        if (est.equals("Activo")) {
            chbEstado.setSelected(true);
        } else {
            chbEstado.setSelected(false);
        }
        //        String file = new String("/imgproductos/" + Id + ".jpg");
        //     String master = System.getProperty("user.dir") + file;
        //                  lblfoto.setIcon(new ImageIcon(master));
        //            ImageIcon icon=new ImageIcon(master);
        //            Image img=icon.getImage();
        //            Image newimg = img.getScaledInstance(lblfoto.getWidth(),lblfoto.getHeight(),java.awt.Image.SCALE_SMOOTH);
        //            ImageIcon newIcon= new ImageIcon(newimg);
        //            lblfoto.setIcon(newIcon);
        //            lblfoto.setSize(lblfoto.getWidth(), lblfoto.getHeight());

        nums = 1;
    }//GEN-LAST:event_tbUsuarioMouseClicked

    private void btnImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenActionPerformed
        // TODO add your handling code here:
        try {
            open();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnImagenActionPerformed

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
        //VALIDAR CAMPOS PARA QUE TODOS ESTEN LLENOS
        if (txtDni.getText().isEmpty()
            || txtApellidos.getText().isEmpty() || txtNombres.getText().isEmpty()
            || txtEmail.getText().isEmpty() || txtUsuario.getText().isEmpty()
            || txtContraseña.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "POR FAVOR RELLENE TODOS LOS CAMPOS");

        } else {

            String ID = txtID.getText();
            String Nombres = txtNombres.getText();
            String Apellidos = txtApellidos.getText();
            String Dni = txtDni.getText();
            String Email = txtEmail.getText();
            String Usuario = txtUsuario.getText();
            String Contraseña = txtContraseña.getText();
            String TipoUsuario = cboTipo.getSelectedItem().toString();
            //            String Foto = txtImagen.getText();
            String Estado;
            if (chbEstado.isSelected()) {
                Estado = "Activo";
            } else {
                Estado = "Inactivo";
            }

            if (nums == 0) {
                int respuesta = metodos.guardarUsuarios(Nombres, Apellidos, Dni, Email, Usuario, Contraseña, TipoUsuario, Estado);
                if (respuesta > 0) {
                    listar();

                    limpiar();
                }
            } else {
                int respuesta = metodos.ActualizarUsuarios(ID, Nombres, Apellidos, Dni, Email, Usuario, Contraseña, TipoUsuario, Estado);
                if (respuesta > 0) {
                    listar();
                    nums = 0;
                }
            }
        }
    }//GEN-LAST:event_btnregistrarActionPerformed

    private void btnregistrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnregistrarKeyPressed
        //VALIDAR CAMPOS PARA QUE TODOS ESTEN LLENOS
        if (txtDni.getText().isEmpty()
            || txtApellidos.getText().isEmpty() || txtNombres.getText().isEmpty()
            || txtEmail.getText().isEmpty() || txtUsuario.getText().isEmpty()
            || txtContraseña.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "POR FAVOR RELLENE TODOS LOS CAMPOS");

        } else {

            String ID = txtID.getText();
            String Nombres = txtNombres.getText();
            String Apellidos = txtApellidos.getText();
            String Dni = txtDni.getText();
            String Email = txtEmail.getText();
            String Usuario = txtUsuario.getText();
            String Contraseña = txtContraseña.getText();
            String TipoUsuario = cboTipo.getSelectedItem().toString();
            //            String Foto = txtImagen.getText();
            String Estado;
            if (chbEstado.isSelected()) {
                Estado = "Activo";
            } else {
                Estado = "Inactivo";
            }

            if (nums == 0) {
                int respuesta = metodos.guardarUsuarios(Nombres, Apellidos, Dni, Email, Usuario, Contraseña, TipoUsuario, Estado);
                if (respuesta > 0) {
                    listar();

                    limpiar();
                }
            } else {
                int respuesta = metodos.ActualizarUsuarios(ID, Nombres, Apellidos, Dni, Email, Usuario, Contraseña, TipoUsuario, Estado);
                if (respuesta > 0) {
                    listar();
                    nums = 0;
                }
            }
        }
    }//GEN-LAST:event_btnregistrarKeyPressed

    private void btnNuevo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo2ActionPerformed
        limpiar();
    }//GEN-LAST:event_btnNuevo2ActionPerformed

    private void btnEliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar2ActionPerformed
        int fila = tbUsuario.getSelectedRowCount();
        if (fila < 1) {
            JOptionPane.showMessageDialog(null, "SELECCIONE UN REGISTRO DE LA TABLA");
        } else if(fila==1){
            int result = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el registro?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {

                if (CP.EliminarUsuario(tbUsuario.getValueAt(tbUsuario.getSelectedRow(), 0).toString()) > 0) {
                    limpiar();
                    listar();
                }
            }
            if (result == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Registro no Eliminado!");
            }
        }
    }//GEN-LAST:event_btnEliminar2ActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JRReporte cr = new JRReporte();
        Connection con = null;
        try {
            con = ConexionBD.conectar();
            String ruta = System.getProperty("user.dir") + "\\src\\Reportes\\Usuarios.jrxml";
            cr.abrirReporte(ruta, con);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtId1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtId1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtId1ActionPerformed

    private void txtEstado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstado1ActionPerformed

    private void btnCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar2ActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelar2ActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        //VALIDAR CAMPOS PARA QUE TODOS ESTEN LLENOS
        if (txtApellidos.getText().isEmpty() || txtNombres.getText().isEmpty()
            || txtEmail.getText().isEmpty() || txtNomUsuario.getText().isEmpty()
            || txtClave.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos");

        } else {

            String idUsuario = txtId.getText();
            String Nombres = txtNombres.getText();
            String Apellidos = txtApellidos.getText();
            String Dni = txtDni.getText();
            String Email = txtEmail.getText();
            String Usuario = txtNomUsuario.getText();
            String Clave = txtClave.getText();
            String TipoUsuario = txtTipoUser.getText();
            //            String Foto = txtImagen.getText();
            String Estado = txtEstado.getText();

            if (nums == 0) {

                int respuesta = metodos.ActualizarUsuarios(idUsuario,Nombres,Apellidos,Dni ,Email, Usuario, Clave, TipoUsuario, Estado);
                if (respuesta > 0) {
                    nums = 0;
                }
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnImprimir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimir1ActionPerformed
        JRReporte cr = new JRReporte();
        Connection con = null;
        try {
            con = ConexionBD.conectar();
            Map parametros = new HashMap();
            parametros.put("Id", txtId.getText());
            String ruta = System.getProperty("user.dir") + "\\src\\Reportes\\Perfil.jrxml";
            cr.abrirReporte(ruta, con, parametros);
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el reporte de Empleados", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnImprimir1ActionPerformed

    private void btnImagen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagen1ActionPerformed
        // TODO add your handling code here:
        try {
            open();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnImagen1ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
            jTabbedPane1.setSelectedIndex(8);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        jTabbedPane1.setSelectedIndex(9);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        jTabbedPane1.setSelectedIndex(10);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        jTabbedPane1.setSelectedIndex(11);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        jTabbedPane1.setSelectedIndex(12);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        jTabbedPane1.setSelectedIndex(13);
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        jTabbedPane1.setSelectedIndex(14);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Menu_Principal("", 0, 0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnAnular1;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarComprobante;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnBuscarProveedor;
    private javax.swing.JButton btnCalcular1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnCancelar2;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnEliminar2;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnGuardad;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar1;
    public static javax.swing.JButton btnImagen;
    private javax.swing.JButton btnImagen1;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnImprimir1;
    private javax.swing.JButton btnLaboratorio;
    private javax.swing.JButton btnLimpiarTabla;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JButton btnNuevo2;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnPresentacion;
    private javax.swing.JButton btnPresentacion1;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    public static javax.swing.JButton btnReporte;
    private javax.swing.JButton btnReporte1;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVentas;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnbuscar3;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JComboBox cboTipo;
    private javax.swing.JComboBox cboTipoComprobante;
    private javax.swing.JCheckBox chbEstado;
    private javax.swing.JCheckBox chbEstado1;
    private javax.swing.JCheckBox chbEstado2;
    private com.toedter.calendar.JDateChooser dcFecha;
    private com.toedter.calendar.JDateChooser dcFechafin;
    private com.toedter.calendar.JDateChooser dcFechafin1;
    private com.toedter.calendar.JDateChooser dcFechafin2;
    private com.toedter.calendar.JDateChooser dcFechaini;
    private com.toedter.calendar.JDateChooser dcFechaini1;
    private com.toedter.calendar.JDateChooser dcFechaini2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton jbt_limpiar;
    private javax.swing.JComboBox jcb_Sexo;
    private javax.swing.JCheckBox jchEstado;
    public static com.toedter.calendar.JDateChooser jdtFecha;
    private javax.swing.JTable jtbPresentacion;
    private javax.swing.JTable jtb_Empleados;
    private javax.swing.JTable jtb_datos;
    private javax.swing.JLabel lblComprobante;
    private javax.swing.JLabel lblIdCompra;
    public static javax.swing.JLabel lblIdProducto;
    public static javax.swing.JLabel lblIdProveedor;
    private javax.swing.JLabel lblIdVenta;
    public static javax.swing.JLabel lblImagen;
    private javax.swing.JRadioButton rbtCategoria;
    private javax.swing.JRadioButton rbtEstado;
    private javax.swing.JRadioButton rbtId;
    private javax.swing.JRadioButton rbtPres;
    private javax.swing.JRadioButton rbtTotal;
    private javax.swing.JRadioButton rbtndes;
    private javax.swing.JRadioButton rbtntodo;
    private javax.swing.JRadioButton rdEspecialidad2;
    private javax.swing.JRadioButton rddni2;
    private javax.swing.JRadioButton rdgenero2;
    private javax.swing.JRadioButton rdtodo2;
    private rojerusan.RSTableMetro tbProductos;
    private rojerusan.RSTableMetro tbProductos1;
    private rojerusan.RSTableMetro tbProveedores;
    private javax.swing.JTable tbUsuario;
    private javax.swing.JTable tblCompra;
    private javax.swing.JTable tblDetalle;
    private javax.swing.JTable tblDetalleProducto;
    private javax.swing.JTable tblVenta;
    private javax.swing.JTable tblVenta1;
    private javax.swing.JTable tblVenta2;
    public static javax.swing.JTextField txtApellidos1;
    public static javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCantidadProducto;
    private javax.swing.JLabel txtCargo;
    public static javax.swing.JTextField txtClave;
    public static javax.swing.JTextField txtCodigoProducto;
    public static javax.swing.JTextField txtComprobante;
    private javax.swing.JTextField txtConcentracion1;
    public static javax.swing.JTextField txtConcentracionProducto;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtCorreoCliente;
    private javax.swing.JTextField txtCosto1;
    private javax.swing.JTextField txtDescripcion;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDescripcion1;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDescripcion5;
    public static javax.swing.JLabel txtDescripcionProducto;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDireccionCliente;
    public static javax.swing.JTextField txtDni4;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDocumentoCliente;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDocumentoComprobante;
    public static javax.swing.JTextField txtEmail1;
    public static javax.swing.JTextField txtEstado1;
    private javax.swing.JLabel txtFecha;
    private com.toedter.calendar.JDateChooser txtFecha1;
    private javax.swing.JTextField txtFechas;
    private javax.swing.JLabel txtHora;
    private javax.swing.JTextField txtIGV;
    private javax.swing.JTextField txtId;
    public static javax.swing.JTextField txtId1;
    public static javax.swing.JTextField txtIdEmpleado;
    public static javax.swing.JTextField txtIdProveedor;
    public static javax.swing.JTextField txtImagen;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtImporteTotal;
    private javax.swing.JLabel txtLeyenda;
    public static javax.swing.JTextField txtNomUsuario;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtNombreCliente;
    public static javax.swing.JTextField txtNombreProducto;
    public static javax.swing.JTextField txtNombreProveedor;
    public static javax.swing.JTextField txtNombres1;
    public static javax.swing.JTextField txtNumeroCompra;
    private javax.swing.JTextField txtPrecio1;
    public static javax.swing.JTextField txtPrecioProducto;
    public static javax.swing.JTextField txtPresentacionProducto;
    public static javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtSanitario;
    private javax.swing.JTextField txtStock1;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtSubTotal;
    private javax.swing.JTextField txtSubTotal1;
    private javax.swing.JTextField txtTipoPago;
    public static javax.swing.JTextField txtTipoUser;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtTotaIgv;
    private javax.swing.JTextField txtTotalCompra;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtTotalExonerado;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtTotalGravado;
    private javax.swing.JTextField txtTotalProducto;
    public static javax.swing.JTextField txtUltimoId;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}
