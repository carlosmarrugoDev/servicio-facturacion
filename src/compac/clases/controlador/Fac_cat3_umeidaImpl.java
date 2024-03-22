/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.controlador;

import compac.clases.interfas.Int_Fac_cat3_umedida;
import compac.clases.modelo.ObFac_cat3_umedida;
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
public class Fac_cat3_umeidaImpl extends SQL implements Int_Fac_cat3_umedida<ObFac_cat3_umedida> {

    private ObFac_cat3_umedida fac_cat3_umedida;
    ConfigGeneral config = new ConfigGeneral();

    @Override
    public List<ObFac_cat3_umedida> listar() {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObFac_cat3_umedida> listaFac_cat7 = new ArrayList<ObFac_cat3_umedida>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from fac_cat3_umedida where estado_view='1' "
                    + " order by nombre_inter ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_fac_cat3_umedida = rs.getInt(1);
                String codigo_inter = rs.getString(2);
                String nombre_inter = rs.getString(3);
                String codigo = rs.getString(4);
                String descripcion = rs.getString(5);
                int estado_view = rs.getInt(6);
                listaFac_cat7.add(new ObFac_cat3_umedida(id_fac_cat3_umedida, codigo_inter, nombre_inter,
                        codigo, descripcion, estado_view));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar ObFac_cat3" + e);
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
        return listaFac_cat7;
    }

    @Override
    public List<ObFac_cat3_umedida> listarCnt(String dato, int cnt_carga) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObFac_cat3_umedida> listaFac_cat7 = new ArrayList<ObFac_cat3_umedida>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from fac_cat3_umedida  where "
                    + " nombre_inter  like '%" + dato + "%' or "
                    + " codigo_inter  like '%" + dato + "%' or "
                    + " codigo  like '%" + dato + "%' or "
                    + " descripcion  like '%" + dato + "%' "
                    + " order by codigo_inter limit 0," + cnt_carga);

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_fac_cat3_umedida = rs.getInt(1);
                String codigo_inter = rs.getString(2);
                String nombre_inter = rs.getString(3);
                String codigo = rs.getString(4);
                String descripcion = rs.getString(5);
                int estado_view = rs.getInt(6);
                listaFac_cat7.add(new ObFac_cat3_umedida(id_fac_cat3_umedida, codigo_inter, nombre_inter,
                        codigo, descripcion, estado_view));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar ObFac_cat3" + e);
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
        return listaFac_cat7;
    }

    @Override
    public void registrar(ObFac_cat3_umedida obj) {
        String consulta = "INSERT INTO fac_cat3_umedida(codigo_inter, nombre_inter,codigo,descripcion,estado_view ) "
                + "VALUES ('" + obj.getCodigo_inter() + "','" + obj.getNombre_inter() + "' ,"
                + "'" + obj.getCodigo() + "','" + obj.getDescripcion() + "','" + obj.getEstado_view() + "')";
        grabarTabla(consulta);
    }

    @Override
    public void actualizar(ObFac_cat3_umedida obj) {
        String consulta = "UPDATE fac_cat3_umedida SET codigo_inter='" + obj.getCodigo_inter() + "',"
                + " nombre_inter='" + obj.getNombre_inter() + "',codigo='" + obj.getCodigo() + "',"
                + " descripcion='" + obj.getDescripcion() + "',estado_view='" + obj.getEstado_view() + "' "
                + " WHERE id_fac_cat3_umedida='" + obj.getId_fac_cat3_umedida() + "'";
        actualizaTabla(consulta);
    }

    @Override
    public void eliminar(int id_fac_cat3_umedida) {
        String consulta = "DELETE FROM fac_cat3_umedida   "
                + "WHERE id_fac_cat3_umedida='" + id_fac_cat3_umedida + "'";
        actualizaTabla(consulta);
    }

    @Override
    public ObFac_cat3_umedida buscar_por_id(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from fac_cat3_umedida where id_fac_cat3_umedida='" + id + "' ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_fac_cat3_umedida = rs.getInt(1);
                String codigo_inter = rs.getString(2);
                String nombre_inter = rs.getString(3);
                String codigo = rs.getString(4);
                String descripcion = rs.getString(5);
                int estado_view = rs.getInt(6);
                fac_cat3_umedida = new ObFac_cat3_umedida(id_fac_cat3_umedida, codigo_inter, nombre_inter,
                        codigo, descripcion, estado_view);
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
        return fac_cat3_umedida;
    }

    @Override
    public void actualizarActivar(int id_fac_cat3_umedida) {
        String consulta = "UPDATE fac_cat3_umedida SET estado_view='1' "
                + " WHERE id_fac_cat3_umedida='" + id_fac_cat3_umedida + "'";
        actualizaTabla(consulta);
    }

    @Override
    public void actualizarDesactivar(int id_fac_cat3_umedida) {
        String consulta = "UPDATE fac_cat3_umedida SET estado_view='0' "
                + " WHERE id_fac_cat3_umedida='" + id_fac_cat3_umedida + "'";
        actualizaTabla(consulta);
    }

    public ObFac_cat3_umedida getObFac_cat3() {
        return fac_cat3_umedida;
    }

    public void setObFac_cat3(ObFac_cat3_umedida fac_cat3_umedida) {
        this.fac_cat3_umedida = fac_cat3_umedida;
    }

    @Override
    public String obtieneDescripcion_id(int id_fac_cat3_umedida) {
        String nombre_inter = "";

        try {
            nombre_inter = obtenerCadena("Select descripcion from fac_cat3_umedida where id_fac_cat3_umedida='" + id_fac_cat3_umedida + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_nomcompleto : " + e.getLocalizedMessage());
        }

        return nombre_inter;
    }

    @Override
    public String obtieneCodigo_id(int id_fac_cat3_umedida) {
        String codigo_inter = ""; 
        try {
            codigo_inter = obtenerCadena("Select codigo from fac_cat3_umedida where id_fac_cat3_umedida='" + id_fac_cat3_umedida + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_nomcompleto : " + e.getLocalizedMessage());
        } 
        return codigo_inter;
    }

    @Override
    public int obtenerId_descripcion(String descripcion) {

        int id_fac_cat3_umedida = 0; 
        try {
            id_fac_cat3_umedida = obtenerEntero("Select id_fac_cat3_umedida from fac_cat3_umedida where descripcion='" + descripcion + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_nomcompleto : " + e.getLocalizedMessage());
        } 
        return id_fac_cat3_umedida;
    }

}
