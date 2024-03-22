/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.controlador;

import compac.clases.interfas.Int_Fac_cat2_moneda;
import compac.clases.modelo.ObFac_cat2_moneda;
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
public class Fac_cat2_monedaImpl extends SQL implements Int_Fac_cat2_moneda<ObFac_cat2_moneda> {

    private ObFac_cat2_moneda fac_cat2_moneda;
    ConfigGeneral config = new ConfigGeneral();

    @Override
    public List<ObFac_cat2_moneda> listar() {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObFac_cat2_moneda> listaFac_cat7 = new ArrayList<ObFac_cat2_moneda>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from fac_cat2_moneda where"
                    + "  estado_view='1' order by descripcion ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_fac_cat2_moneda = rs.getInt(1);
                String codigo = rs.getString(2);
                String descripcion = rs.getString(3);
                int estado_view = rs.getInt(4);
                listaFac_cat7.add(new ObFac_cat2_moneda(id_fac_cat2_moneda, codigo, descripcion, estado_view));
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
    public List<ObFac_cat2_moneda> listarCnt(String dato, int fac_cat2_moneda) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObFac_cat2_moneda> listaFac_cat7 = new ArrayList<ObFac_cat2_moneda>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from fac_cat2_moneda  where "
                    + " descripcion  like '%" + dato + "%' or "
                    + " codigo  like '%" + dato + "%' "
                    + " order by descripcion limit 0," + fac_cat2_moneda);

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_fac_cat2_moneda = rs.getInt(1);
                String codigo = rs.getString(2);
                String descripcion = rs.getString(3);
                int estado_view = rs.getInt(4);
                listaFac_cat7.add(new ObFac_cat2_moneda(id_fac_cat2_moneda, codigo, descripcion, estado_view));
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
    public void registrar(ObFac_cat2_moneda obj) {
        String consulta = "INSERT INTO fac_cat2_moneda(codigo, descripcion,estado_view) "
                + "VALUES ('" + obj.getCodigo() + "','" + obj.getDescripcion() + "','" + obj.getEstado_view() + "' )";
        grabarTabla(consulta);
    }

    @Override
    public void actualizar(ObFac_cat2_moneda obj) {
        String consulta = "UPDATE fac_cat2_moneda SET codigo='" + obj.getCodigo() + "',"
                + " descripcion='" + obj.getDescripcion() + "', "
                + " estado_view='" + obj.getEstado_view() + "' "
                + " WHERE id_fac_cat2_moneda='" + obj.getId_fac_cat2_moneda() + "'";
        actualizaTabla(consulta);
    }

    @Override
    public void actualizarActivar(int id_fac_cat2_moneda) {
        String consulta = "UPDATE fac_cat2_moneda SET estado_view='1' "
                + " WHERE id_fac_cat2_moneda='" + id_fac_cat2_moneda + "'";
        actualizaTabla(consulta);
    }

    @Override
    public void actualizarDesactivar(int id_fac_cat2_moneda) {
        String consulta = "UPDATE fac_cat2_moneda SET estado_view='0' "
                + " WHERE id_fac_cat2_moneda='" + id_fac_cat2_moneda + "'";
        actualizaTabla(consulta);
    }

    @Override
    public void eliminar(int id_fac_cat2_moneda) {
        String consulta = "DELETE FROM fac_cat2_moneda   "
                + "WHERE id_fac_cat2_moneda='" + id_fac_cat2_moneda + "'";
        actualizaTabla(consulta);
    }

    @Override
    public ObFac_cat2_moneda buscar_por_id(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from fac_cat2_moneda where id_fac_cat2_moneda='" + id + "' ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_fac_cat2_moneda = rs.getInt(1);
                String codigo = rs.getString(2);
                String descripcion = rs.getString(3);
                int estado_view = rs.getInt(4);
                fac_cat2_moneda = new ObFac_cat2_moneda(id_fac_cat2_moneda, codigo, descripcion, estado_view);
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
        return fac_cat2_moneda;
    }

    public ObFac_cat2_moneda getObFac_cat7() {
        return fac_cat2_moneda;
    }

    public void setObFac_cat7(ObFac_cat2_moneda fac_cat2_moneda) {
        this.fac_cat2_moneda = fac_cat2_moneda;
    }

    @Override
    public int obtenerId_descripcion(String descripcion) {
        int id_fac_cat2_moneda = 0;

        try {
            id_fac_cat2_moneda = obtenerEntero("Select id_fac_cat2_moneda from fac_cat2_moneda where descripcion='" + descripcion + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_nomcompleto : " + e.getLocalizedMessage());
        }

        return id_fac_cat2_moneda;
    }

    @Override
    public String obtieneDescripcion_id(int id_fac_cat2_moneda) {
        String descripcion = "";

        try {
            descripcion = obtenerCadena("Select descripcion from fac_cat2_moneda where id_fac_cat2_moneda='" + id_fac_cat2_moneda + "'");
        } catch (Exception e) {
            System.err.println("error obtenerdescripcion : " + e.getLocalizedMessage());
        }

        return descripcion;
    }

    @Override
    public String obtieneCodigo_id(int id_fac_cat2_moneda) {
        String codigo = "";

        try {
            codigo = obtenerCadena("Select codigo from fac_cat2_moneda where id_fac_cat2_moneda='" + id_fac_cat2_moneda + "'");
        } catch (Exception e) {
            System.err.println("error obtenercodigo : " + e.getLocalizedMessage());
        }

        return codigo;
    } 
}
