/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.controlador;

import compac.clases.interfas.Int_Fac_cat17_oper;
import compac.clases.modelo.ObFac_cat17_oper;
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
public class Fac_cat17_operImpl extends SQL implements Int_Fac_cat17_oper<ObFac_cat17_oper> {

    private ObFac_cat17_oper fac_cat17_oper;
    ConfigGeneral config = new ConfigGeneral();

    @Override
    public List<ObFac_cat17_oper> listar() {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObFac_cat17_oper> listaFac_cat7 = new ArrayList<ObFac_cat17_oper>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from fac_cat17_oper where"
                    + "  estado_view='1' order by descripcion ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_fac_cat17_oper = rs.getInt(1);
                String codigo = rs.getString(2);
                String descripcion = rs.getString(3);
                int estado_view = rs.getInt(4);
                listaFac_cat7.add(new ObFac_cat17_oper(id_fac_cat17_oper, codigo, descripcion, estado_view));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar ObFac_cat7" + e);
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
    public List<ObFac_cat17_oper> listarCnt(String dato, int fac_cat17_oper) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObFac_cat17_oper> listaFac_cat7 = new ArrayList<ObFac_cat17_oper>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from fac_cat17_oper  where "
                    + " descripcion  like '%" + dato + "%' or "
                    + " codigo  like '%" + dato + "%' "
                    + " order by descripcion limit 0," + fac_cat17_oper);

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_fac_cat17_oper = rs.getInt(1);
                String codigo = rs.getString(2);
                String descripcion = rs.getString(3);
                int estado_view = rs.getInt(4);
                listaFac_cat7.add(new ObFac_cat17_oper(id_fac_cat17_oper, codigo, descripcion, estado_view));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar ObFac_cat7" + e);
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
    public void registrar(ObFac_cat17_oper obj) {
        String consulta = "INSERT INTO fac_cat17_oper(codigo, descripcion,estado_view) "
                + "VALUES ('" + obj.getCodigo() + "','" + obj.getDescripcion() + "','" + obj.getEstado_view() + "' )";
        grabarTabla(consulta);
    }

    @Override
    public void actualizar(ObFac_cat17_oper obj) {
        String consulta = "UPDATE fac_cat17_oper SET codigo='" + obj.getCodigo() + "',"
                + " descripcion='" + obj.getDescripcion() + "', "
                + " estado_view='" + obj.getEstado_view() + "' "
                + " WHERE id_fac_cat17_oper='" + obj.getId_fac_cat17_oper() + "'";
        actualizaTabla(consulta);
    }

    @Override
    public void actualizarActivar(int id_fac_cat17_oper) {
        String consulta = "UPDATE fac_cat17_oper SET estado_view='1' "
                + " WHERE id_fac_cat17_oper='" + id_fac_cat17_oper + "'";
        actualizaTabla(consulta);
    }

    @Override
    public void actualizarDesactivar(int id_fac_cat17_oper) {
        String consulta = "UPDATE fac_cat17_oper SET estado_view='0' "
                + " WHERE id_fac_cat17_oper='" + id_fac_cat17_oper + "'";
        actualizaTabla(consulta);
    }

    @Override
    public void eliminar(int id_fac_cat17_oper) {
        String consulta = "DELETE FROM fac_cat17_oper   "
                + "WHERE id_fac_cat17_oper='" + id_fac_cat17_oper + "'";
        actualizaTabla(consulta);
    }

    @Override
    public ObFac_cat17_oper buscar_por_id(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from fac_cat17_oper where id_fac_cat17_oper='" + id + "' ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_fac_cat17_oper = rs.getInt(1);
                String codigo = rs.getString(2);
                String descripcion = rs.getString(3);
                int estado_view = rs.getInt(4);
                fac_cat17_oper = new ObFac_cat17_oper(id_fac_cat17_oper, codigo, descripcion, estado_view);
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
        return fac_cat17_oper;
    }

    public ObFac_cat17_oper getObFac_cat7() {
        return fac_cat17_oper;
    }

    public void setObFac_cat7(ObFac_cat17_oper fac_cat17_oper) {
        this.fac_cat17_oper = fac_cat17_oper;
    }

    @Override
    public int obtenerId_descripcion(String descripcion) {
        int id_fac_cat17_oper = 0;

        try {
            id_fac_cat17_oper = obtenerEntero("Select id_fac_cat17_oper from fac_cat17_oper where descripcion='" + descripcion + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_nomcompleto : " + e.getLocalizedMessage());
        }

        return id_fac_cat17_oper;
    }

    @Override
    public String obtieneDescripcion_id(int id_fac_cat17_oper) {
        String descripcion = "";

        try {
            descripcion = obtenerCadena("Select descripcion from fac_cat17_oper where id_fac_cat17_oper='" + id_fac_cat17_oper + "'");
        } catch (Exception e) {
            System.err.println("error obtenerdescripcion : " + e.getLocalizedMessage());
        }

        return descripcion;
    }

    @Override
    public String obtieneCodigo_id(int id_fac_cat17_oper) {
        String codigo = "";

        try {
            codigo = obtenerCadena("Select codigo from fac_cat17_oper where id_fac_cat17_oper='" + id_fac_cat17_oper + "'");
        } catch (Exception e) {
            System.err.println("error obtenercodigo : " + e.getLocalizedMessage());
        }

        return codigo;
    }
}
