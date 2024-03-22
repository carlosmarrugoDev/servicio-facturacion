/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.controlador;

import compac.clases.interfas.Int_Fac_grupo_igv;
import compac.clases.modelo.ObFac_grupo_igv;
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
public class Fac_grupo_igvImpl extends SQL implements Int_Fac_grupo_igv<ObFac_grupo_igv> {

    private ObFac_grupo_igv fac_grupo_igv;
    ConfigGeneral config = new ConfigGeneral();

    @Override
    public List<ObFac_grupo_igv> listar() {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObFac_grupo_igv> listaFac_cat7 = new ArrayList<ObFac_grupo_igv>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from fac_grupo_igv where"
                    + "  estado_view='1' order by descripcion ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_fac_grupo_igv = rs.getInt(1);
                String codigo = rs.getString(2);
                String descripcion = rs.getString(3);
                double igv = rs.getDouble(4);
                int estado_view = rs.getInt(5);
                listaFac_cat7.add(new ObFac_grupo_igv(id_fac_grupo_igv, codigo, descripcion, igv, estado_view));
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
    public List<ObFac_grupo_igv> listarCnt(String dato, int fac_grupo_igv) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObFac_grupo_igv> listaFac_cat7 = new ArrayList<ObFac_grupo_igv>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from fac_grupo_igv  where "
                    + " descripcion  like '%" + dato + "%' or "
                    + " codigo  like '%" + dato + "%' "
                    + " order by descripcion limit 0," + fac_grupo_igv);

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_fac_grupo_igv = rs.getInt(1);
                String codigo = rs.getString(2);
                String descripcion = rs.getString(3);
                double igv = rs.getDouble(4);
                int estado_view = rs.getInt(5);
                listaFac_cat7.add(new ObFac_grupo_igv(id_fac_grupo_igv, codigo, descripcion, igv, estado_view));
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
    public void registrar(ObFac_grupo_igv obj) {
        String consulta = "INSERT INTO fac_grupo_igv(codigo, descripcion,igv,estado_view) "
                + "VALUES ('" + obj.getCodigo() + "','" + obj.getDescripcion() + "',"
                + "'" + obj.getIgv() + "','" + obj.getEstado_view() + "' )";
        grabarTabla(consulta);
    }

    @Override
    public void actualizar(ObFac_grupo_igv obj) {
        String consulta = "UPDATE fac_grupo_igv SET codigo='" + obj.getCodigo() + "',"
                + " descripcion='" + obj.getDescripcion() + "',igv='" + obj.getIgv() + "',"
                + " estado_view='" + obj.getEstado_view() + "' "
                + " WHERE id_fac_grupo_igv='" + obj.getId_fac_grupo_igv() + "'";
        actualizaTabla(consulta);
    }

    @Override
    public void actualizarActivar(int id_fac_grupo_igv) {
        String consulta = "UPDATE fac_grupo_igv SET estado_view='1' "
                + " WHERE id_fac_grupo_igv='" + id_fac_grupo_igv + "'";
        actualizaTabla(consulta);
    }

    @Override
    public void actualizarDesactivar(int id_fac_grupo_igv) {
        String consulta = "UPDATE fac_grupo_igv SET estado_view='0' "
                + " WHERE id_fac_grupo_igv='" + id_fac_grupo_igv + "'";
        actualizaTabla(consulta);
    }

    @Override
    public void eliminar(int id_fac_grupo_igv) {
        String consulta = "DELETE FROM fac_grupo_igv   "
                + "WHERE id_fac_grupo_igv='" + id_fac_grupo_igv + "'";
        actualizaTabla(consulta);
    }

    @Override
    public ObFac_grupo_igv buscar_por_id(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from fac_grupo_igv where id_fac_grupo_igv='" + id + "' ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_fac_grupo_igv = rs.getInt(1);
                String codigo = rs.getString(2);
                String descripcion = rs.getString(3);
                double igv = rs.getDouble(4);
                int estado_view = rs.getInt(5);
                fac_grupo_igv = new ObFac_grupo_igv(id_fac_grupo_igv, codigo, descripcion, igv, estado_view);
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
        return fac_grupo_igv;
    }

    public ObFac_grupo_igv getObFac_cat7() {
        return fac_grupo_igv;
    }

    public void setObFac_cat7(ObFac_grupo_igv fac_grupo_igv) {
        this.fac_grupo_igv = fac_grupo_igv;
    }

    @Override
    public int obtenerId_descripcion(String descripcion) {
        int id_fac_grupo_igv = 0;

        try {
            id_fac_grupo_igv = obtenerEntero("Select id_fac_grupo_igv from fac_grupo_igv where descripcion='" + descripcion + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_nomcompleto : " + e.getLocalizedMessage());
        }

        return id_fac_grupo_igv;
    }

    @Override
    public String obtieneDescripcion_id(int id_fac_grupo_igv) {
        String descripcion = "";

        try {
            descripcion = obtenerCadena("Select descripcion from fac_grupo_igv where id_fac_grupo_igv='" + id_fac_grupo_igv + "'");
        } catch (Exception e) {
            System.err.println("error obtenerdescripcion : " + e.getLocalizedMessage());
        }

        return descripcion;
    }

    @Override
    public String obtieneCodigo_id(int id_fac_grupo_igv) {
        String codigo = "";

        try {
            codigo = obtenerCadena("Select codigo from fac_grupo_igv where id_fac_grupo_igv='" + id_fac_grupo_igv + "'");
        } catch (Exception e) {
            System.err.println("error obtenercodigo : " + e.getLocalizedMessage());
        }

        return codigo;
    }

    @Override
    public double obtieneIGV_id(int id_fac_grupo_igv) {
        double igv = 0;

        try {
            igv = obtenerEntero("Select igv from fac_grupo_igv where id_fac_grupo_igv='" + id_fac_grupo_igv + "'");
        } catch (Exception e) {
            System.err.println("error obtenerigv : " + e.getLocalizedMessage());
        }

        return igv;
    }
}
