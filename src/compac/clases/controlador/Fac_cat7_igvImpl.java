/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.controlador;

import compac.clases.interfas.Int_Fac_cat7_igv;
import compac.clases.modelo.ObFac_cat7_igv;
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
public class Fac_cat7_igvImpl extends SQL implements Int_Fac_cat7_igv<ObFac_cat7_igv> {

    private ObFac_cat7_igv fac_cat7_igv;
    ConfigGeneral config = new ConfigGeneral();

    @Override
    public List<ObFac_cat7_igv> listar() {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObFac_cat7_igv> listaFac_cat7 = new ArrayList<ObFac_cat7_igv>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from fac_cat7_igv where estado_view='1' "
                    + " order by descripcion ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_fac_cat7_igv = rs.getInt(1);
                String codigo = rs.getString(2);
                String descripcion = rs.getString(3);
                String codigo_tributo = rs.getString(4);
                int estado_view = rs.getInt(5);
                listaFac_cat7.add(new ObFac_cat7_igv(id_fac_cat7_igv, codigo, descripcion, codigo_tributo, estado_view));
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
    public List<ObFac_cat7_igv> listarCnt(String dato, int fac_cat7_igv) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObFac_cat7_igv> listaFac_cat7 = new ArrayList<ObFac_cat7_igv>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from fac_cat7_igv  where "
                    + " descripcion  like '%" + dato + "%' or "
                    + " codigo  like '%" + dato + "%' "
                    + " order by codigo limit 0," + fac_cat7_igv);

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_fac_cat7_igv = rs.getInt(1);
                String codigo = rs.getString(2);
                String descripcion = rs.getString(3);
                String codigo_tributo = rs.getString(4);
                int estado_view = rs.getInt(5);
                listaFac_cat7.add(new ObFac_cat7_igv(id_fac_cat7_igv, codigo, descripcion, codigo_tributo, estado_view));
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
    public void registrar(ObFac_cat7_igv obj) {
        String consulta = "INSERT INTO fac_cat7_igv(codigo, descripcion,codigo_tributo,estado_view ) "
                + "VALUES ('" + obj.getCodigo() + "','" + obj.getDescripcion() + "' ,"
                + "'" + obj.getCodigo_tributo() + "','" + obj.getEstado_view() + "')";
        grabarTabla(consulta);
    }

    @Override
    public void actualizar(ObFac_cat7_igv obj) {
        String consulta = "UPDATE fac_cat7_igv SET codigo='" + obj.getCodigo() + "',"
                + " descripcion='" + obj.getDescripcion() + "',codigo_tributo='" + obj.getCodigo_tributo() + "',"
                + " estado_view='" + obj.getEstado_view() + "' "
                + " WHERE id_fac_cat7_igv='" + obj.getId_fac_cat7_igv() + "'";
        actualizaTabla(consulta);
    }

    @Override
    public void eliminar(int id_fac_cat7_igv) {
        String consulta = "DELETE FROM fac_cat7_igv   "
                + "WHERE id_fac_cat7_igv='" + id_fac_cat7_igv + "'";
        actualizaTabla(consulta);
    }

    @Override
    public ObFac_cat7_igv buscar_por_id(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from fac_cat7_igv where id_fac_cat7_igv='" + id + "' ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_fac_cat7_igv = rs.getInt(1);
                String codigo = rs.getString(2);
                String descripcion = rs.getString(3);
                String codigo_tributo = rs.getString(4);
                int estado_view = rs.getInt(5);
                fac_cat7_igv = new ObFac_cat7_igv(id_fac_cat7_igv, codigo, descripcion, codigo_tributo, estado_view);
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
        return fac_cat7_igv;
    }

    @Override
    public void actualizarActivar(int id_fac_cat7_igv) {
        String consulta = "UPDATE fac_cat7_igv SET estado_view='1' "
                + " WHERE id_fac_cat7_igv='" + id_fac_cat7_igv + "'";
        actualizaTabla(consulta);
    }

    @Override
    public void actualizarDesactivar(int id_fac_cat7_igv) {
        String consulta = "UPDATE fac_cat7_igv SET estado_view='0' "
                + " WHERE id_fac_cat7_igv='" + id_fac_cat7_igv + "'";
        actualizaTabla(consulta);
    }

    public ObFac_cat7_igv getObFac_cat7() {
        return fac_cat7_igv;
    }

    public void setObFac_cat7(ObFac_cat7_igv fac_cat7_igv) {
        this.fac_cat7_igv = fac_cat7_igv;
    }

    @Override
    public int obtenerId_descripcion(String descripcion) {
        int id_fac_cat7_igv = 0;

        try {
            id_fac_cat7_igv = obtenerEntero("Select id_fac_cat7_igv from fac_cat7_igv where descripcion='" + descripcion + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_nomcompleto : " + e.getLocalizedMessage());
        }

        return id_fac_cat7_igv;
    }

    @Override
    public String obtieneDescripcion_id(int id_fac_cat7_igv) {
        String descripcion = "";

        try {
            descripcion = obtenerCadena("Select descripcion from fac_cat7_igv where id_fac_cat7_igv='" + id_fac_cat7_igv + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_nomcompleto : " + e.getLocalizedMessage());
        }

        return descripcion;
    }

    @Override
    public String obtieneCodigo_id(int id_fac_cat7_igv) {
        String codigo = "";

        try {
            codigo = obtenerCadena("Select codigo from fac_cat7_igv where id_fac_cat7_igv='" + id_fac_cat7_igv + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_nomcompleto : " + e.getLocalizedMessage());
        }

        return codigo;
    }

    @Override
    public String obtieneCodigoTributo_id(int id_fac_cat7_igv) {
        String codigo_tributo = "";

        try {
            codigo_tributo = obtenerCadena("Select codigo_tributo from fac_cat7_igv where id_fac_cat7_igv='" + id_fac_cat7_igv + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_nomcompleto : " + e.getLocalizedMessage());
        }

        return codigo_tributo;
    }
}
