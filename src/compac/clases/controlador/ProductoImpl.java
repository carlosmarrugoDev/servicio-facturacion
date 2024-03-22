/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.controlador;

import compac.clases.interfas.Int_Producto;
import compac.clases.modelo.ObProducto;
import compac.clases.modelo.ObProductoView;
import compac.clases.principales.Conectar;
import compac.clases.principales.ConfigGeneral;
import compac.clases.principales.SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LuisT
 */
public class ProductoImpl extends SQL implements Int_Producto<ObProducto> {

    private ObProducto producto;
    ConfigGeneral config = new ConfigGeneral();

    @Override
    public List<ObProductoView> listar(String dato, int cnt, int id_sedes) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObProductoView> listaArray = new ArrayList<ObProductoView>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from producto_listado where "
                    + " ( descripcion  like '%" + dato + "%' and id_sede='" + id_sedes + "' and estado='1') or "
                    + " ( codigo  like '%" + dato + "%' and id_sede='" + id_sedes + "' and estado='1')  "
                    + " order by descripcion limit 0," + cnt);

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_producto = rs.getInt(1);
                int id_categoria = rs.getInt(2);
                String descripcion = rs.getString(3);
                String codigo = rs.getString(4);
                double precio = rs.getDouble(5);
                int estado = rs.getInt(6);
                String ubicacion = rs.getString(7);
                int id_usuario = rs.getInt(8);
                int id_sede = rs.getInt(9);
                int id_marca = rs.getInt(10);
                int id_fac_cat3_umedida = rs.getInt(11);
                int id_fac_cat7_igv = rs.getInt(12);
                String descripcion_categoria = rs.getString(13);
                String marca_descripcion = rs.getString(14);
                String fac_cat3_umedida_descripcion = rs.getString(15);
                String fac_cat7_igv_descripcion = rs.getString(16);

                listaArray.add(new ObProductoView(id_producto, id_categoria, descripcion, codigo,
                        precio, estado, ubicacion, id_usuario, id_sede, id_marca, id_fac_cat3_umedida,
                        id_fac_cat7_igv, descripcion_categoria, marca_descripcion, fac_cat3_umedida_descripcion,
                        fac_cat7_igv_descripcion));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar listar" + e);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar ");
            }
        }
        return listaArray;
    }

    @Override
    public List<ObProducto> listar(int id_sedes) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObProducto> listaArray = new ArrayList<ObProducto>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from producto where id_sede='" + id_sedes + "'  order by descripcion ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_producto = rs.getInt(1);
                int id_categoria = rs.getInt(2);
                String descripcion = rs.getString(3);
                String codigo = rs.getString(4);
                double precio = rs.getDouble(5);
                int estado = rs.getInt(6);
                String ubicacion = rs.getString(7);
                int id_usuario = rs.getInt(8);
                int id_sede = rs.getInt(9);
                int id_marca = rs.getInt(10);
                int id_fac_cat3_umedida = rs.getInt(11);
                int id_fac_cat7_igv = rs.getInt(12);
                listaArray.add(new ObProducto(id_producto, id_categoria, descripcion, codigo,
                        precio, estado, ubicacion, id_usuario, id_sede, id_marca, id_fac_cat3_umedida,
                        id_fac_cat7_igv));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar listar" + e);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar ");
            }
        }
        return listaArray;
    }

    @Override
    public List<ObProducto> listarCategorias(int idcategoria, String dato, int cnt, int id_sedes) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObProducto> listaArray = new ArrayList<ObProducto>();
        try {
            con = conectar.getConexion();
            if (idcategoria == 0) {
                pst = con.prepareStatement("select * from producto where "
                        + " ( descripcion  like '%" + dato + "%'  and id_sede='" + id_sedes + "' ) or "
                        + " ( codigo  like '%" + dato + "%'  and id_sede='" + id_sedes + "' )  "
                        + " order by descripcion limit 0," + cnt);
            } else {
                pst = con.prepareStatement("select * from producto where "
                        + " ( descripcion  like '%" + dato + "%' and id_categoria='" + idcategoria + "' and id_sede='" + id_sedes + "' ) or "
                        + " ( codigo  like '%" + dato + "%' and id_categoria='" + idcategoria + "'  and id_sede='" + id_sedes + "' ) "
                        + "  order by descripcion limit 0," + cnt);
            }

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_producto = rs.getInt(1);
                int id_categoria = rs.getInt(2);
                String descripcion = rs.getString(3);
                String codigo = rs.getString(4);
                double precio = rs.getDouble(5);
                int estado = rs.getInt(6);
                String ubicacion = rs.getString(7);
                int id_usuario = rs.getInt(8);
                int id_sede = rs.getInt(9);
                int id_marca = rs.getInt(10);
                int id_fac_cat3_umedida = rs.getInt(11);
                int id_fac_cat7_igv = rs.getInt(12);
                listaArray.add(new ObProducto(id_producto, id_categoria, descripcion, codigo,
                        precio, estado, ubicacion, id_usuario, id_sede, id_marca, id_fac_cat3_umedida,
                        id_fac_cat7_igv));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar ObProducto" + e);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar ");
            }
        }
        return listaArray;
    }

    @Override
    public void registrar(ObProducto obj) {
        String consulta = "INSERT INTO producto(id_categoria,descripcion,codigo,precio,"
                + "estado,ubicacion,id_usuario,id_sede,id_marca,id_fac_cat3_umedida,id_fac_cat7_igv) "
                + "VALUES ('" + obj.getId_categoria() + "','" + obj.getDescripcion() + "',"
                + "'" + obj.getCodigo() + "','" + obj.getPrecio() + "','" + obj.getEstado() + "',"
                + "'" + obj.getUbicacion() + "', '" + obj.getId_usuario() + "',"
                + "'" + obj.getId_sede() + "','" + obj.getId_marca() + "','" + obj.getId_fac_cat3_umedida() + "',"
                + "'" + obj.getId_fac_cat7_igv() + "')";
        grabarTabla(consulta);
    }

    @Override
    public void actualizar(ObProducto obj) {
        String consulta = "UPDATE producto SET  "
                + " id_categoria='" + obj.getId_categoria() + "',descripcion='" + obj.getDescripcion() + "', "
                + " codigo='" + obj.getCodigo() + "',precio='" + obj.getPrecio() + "', estado='" + obj.getEstado() + "',"
                + " ubicacion='" + obj.getUbicacion() + "',id_usuario='" + obj.getId_usuario() + "',"
                + " id_marca='" + obj.getId_marca() + "',id_fac_cat3_umedida='" + obj.getId_fac_cat3_umedida() + "',"
                + " id_fac_cat7_igv='" + obj.getId_fac_cat7_igv() + "' "
                + " WHERE id_producto='" + obj.getId_producto() + "'";
        actualizaTabla(consulta);
    }

    @Override
    public void actualizarPrecio(int id_producto, double precio) {
        String consulta = "UPDATE producto SET  precio='" + precio + "'  "
                + " WHERE id_producto='" + id_producto + "'";
        actualizaTabla(consulta);

    }

    @Override
    public void eliminar(int id, int id_usuarios, int id_sedes) {
        String consulta = "UPDATE producto SET estado='0' "
                + "WHERE id_producto='" + id + "'";
        actualizaTabla(consulta);

    }

    @Override
    public ObProducto buscar_por_id(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from producto where id_producto='" + id + "' ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_producto = rs.getInt(1);
                int id_categoria = rs.getInt(2);
                String descripcion = rs.getString(3);
                String codigo = rs.getString(4);
                double precio = rs.getDouble(5);
                int estado = rs.getInt(6);
                String ubicacion = rs.getString(7);
                int id_usuario = rs.getInt(8);
                int id_sede = rs.getInt(9);
                int id_marca = rs.getInt(10);
                int id_fac_cat3_umedida = rs.getInt(11);
                int id_fac_cat7_igv = rs.getInt(12);
                producto = new ObProducto(id_producto, id_categoria, descripcion, codigo,
                        precio, estado, ubicacion, id_usuario, id_sede, id_marca, id_fac_cat3_umedida,
                        id_fac_cat7_igv);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en buscar_por_id " + e);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar ");
            }
        }
        return producto;
    }

    public ObProducto getObProducto() {
        return producto;
    }

    public void setObProducto(ObProducto producto) {
        this.producto = producto;
    }

    @Override
    public int obtenerId_descripcion(String descripcion) {
        int id_producto = 0;

        try {
            id_producto = obtenerEntero("Select id_producto from producto where descripcion='" + descripcion + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return id_producto;
    }

    @Override
    public String obtieneDescripcion_id(int id_producto) {
        String descripcion = "";

        try {
            descripcion = obtenerCadena("Select descripcion from producto where id_producto='" + id_producto + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return descripcion;
    }

    @Override
    public double obtienePrecio_id(int id_producto) {
        double precio = 0;

        try {
            precio = obtenerDouble("Select precio from producto where id_producto='" + id_producto + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return precio;
    }

    @Override
    public int obtenerId_codigo(String codigo) {
        int id_producto = 0;

        try {
            id_producto = obtenerEntero("Select id_producto from producto where codigo='" + codigo + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }
        return id_producto;
    }

}
