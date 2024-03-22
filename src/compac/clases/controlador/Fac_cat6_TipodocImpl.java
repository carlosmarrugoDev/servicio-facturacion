/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.controlador;

import compac.clases.modelo.ObFac_cat6_Tipodoc;
import compac.clases.principales.Conectar;
import compac.clases.principales.ConfigGeneral;
import compac.clases.principales.SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import compac.clases.interfas.Int_Fac_cat6_Tipodoc;

/**
 *
 * @author LuisT
 */
public class Fac_cat6_TipodocImpl extends SQL implements Int_Fac_cat6_Tipodoc<ObFac_cat6_Tipodoc> {

    private ObFac_cat6_Tipodoc fac_cat6_tipodoc;
    ConfigGeneral config = new ConfigGeneral();

    @Override
    public List<ObFac_cat6_Tipodoc> listar() {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObFac_cat6_Tipodoc> listaArray = new ArrayList<ObFac_cat6_Tipodoc>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from fac_cat6_tipodoc where estado='1' and estado_view='1'");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_tipodoc = rs.getInt(1);
                String descripcion = rs.getString(2);
                int longitud = rs.getInt(3);
                int estado = rs.getInt(4);
                String codigo = rs.getString(5);
                int estado_view = rs.getInt(6);
                String simbolo = rs.getString(7);
                listaArray.add(new ObFac_cat6_Tipodoc(id_tipodoc, descripcion, estado, longitud,
                        codigo, estado_view, simbolo));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar ObTipodoc" + e);
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
    public List<ObFac_cat6_Tipodoc> listarCnt(String dato, int cnt) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObFac_cat6_Tipodoc> listaArray = new ArrayList<ObFac_cat6_Tipodoc>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from fac_cat6_tipodoc where estado='1' "
                    + " and descripcion  like '%" + dato + "%'  order by descripcion limit 0," + cnt);

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_tipodoc = rs.getInt(1);
                String descripcion = rs.getString(2);
                int longitud = rs.getInt(3);
                int estado = rs.getInt(4);
                String codigo = rs.getString(5);
                int estado_view = rs.getInt(6);
                String simbolo = rs.getString(7);
                listaArray.add(new ObFac_cat6_Tipodoc(id_tipodoc, descripcion, estado, longitud,
                        codigo, estado_view, simbolo));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar ObTipodoc" + e);
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
    public void registrar(ObFac_cat6_Tipodoc obj) {
        String consulta = "INSERT INTO fac_cat6_tipodoc(descripcion, estado,longitud,codigo,estado_view,simbolo) "
                + "VALUES ('" + obj.getDescripcion() + "','" + obj.getEstado() + "', '" + obj.getLongitud() + "',"
                + "'" + obj.getCodigo() + "','" + obj.getEstado_view() + "','" + obj.getSimbolo() + "' )";
        grabarTabla(consulta);

    }

    @Override
    public void actualizar(ObFac_cat6_Tipodoc obj) {
        String consulta = "UPDATE fac_cat6_tipodoc SET descripcion='" + obj.getDescripcion() + "' , "
                + " longitud='" + obj.getLongitud() + "',codigo='" + obj.getCodigo() + "',"
                + " estado_view='" + obj.getEstado_view() + "',simbolo='" + obj.getSimbolo() + "'"
                + " WHERE id_tipodoc='" + obj.getId_tipodoc() + "'";
        actualizaTabla(consulta);

        String consultaCliente = "UPDATE cliente SET  tipodoc='" + obj.getSimbolo() + "' "
                + " WHERE id_tipodoc='" + obj.getId_tipodoc() + "'";
        actualizaTabla(consultaCliente);

    }

    @Override
    public void actualizarActivar(int id_tipodoc) {
        String consulta = "UPDATE fac_cat6_tipodoc SET estado_view='1' "
                + " WHERE id_tipodoc='" + id_tipodoc + "'";
        actualizaTabla(consulta);
    }

    @Override
    public void actualizarDesactivar(int id_tipodoc) {
        String consulta = "UPDATE fac_cat6_tipodoc SET estado_view='0' "
                + " WHERE id_tipodoc='" + id_tipodoc + "'";
        actualizaTabla(consulta);
    }

    @Override
    public void eliminar(int id) {
        String consulta = "UPDATE fac_cat6_tipodoc SET estado='0' "
                + "WHERE id_tipodoc='" + id + "'";
        actualizaTabla(consulta);
    }

    @Override
    public String obtieneCodigo_id(int id_tipodoc) {
        String codigo = "";

        try {
            codigo = obtenerCadena("Select codigo from fac_cat6_tipodoc where id_tipodoc='" + id_tipodoc + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return codigo;
    }

    @Override
    public String obtieneDescripcion_id(int id_tipodoc) {
        String descripcion = "";

        try {
            descripcion = obtenerCadena("Select descripcion from fac_cat6_tipodoc where id_tipodoc='" + id_tipodoc + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return descripcion;
    }

    @Override
    public String obtieneSimbolo_id(String descripcion) {
        String simbolo = "";

        try {
            simbolo = obtenerCadena("Select simbolo from fac_cat6_tipodoc where descripcion='" + descripcion + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return simbolo;
    }

    @Override
    public int obtenerId_descripcion(String simbolo) {
        int id_sede = 0;

        try {
            id_sede = obtenerEntero("Select id_tipodoc from fac_cat6_tipodoc where simbolo='" + simbolo + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return id_sede;
    }

    @Override
    public ObFac_cat6_Tipodoc buscar_por_id(int id) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from fac_cat6_tipodoc where id_tipodoc='" + id + "' ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_tipodoc = rs.getInt(1);
                String descripcion = rs.getString(2);
                int longitud = rs.getInt(3);
                int estado = rs.getInt(4);
                String codigo = rs.getString(5);
                int estado_view = rs.getInt(6);
                String simbolo = rs.getString(7);
                fac_cat6_tipodoc = new ObFac_cat6_Tipodoc(id_tipodoc, descripcion, estado, longitud,
                        codigo, estado_view, simbolo);
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
        return fac_cat6_tipodoc;
    }

    public ObFac_cat6_Tipodoc getObTipodoc() {
        return fac_cat6_tipodoc;
    }

    public void setObTipodoc(ObFac_cat6_Tipodoc fac_cat6_tipodoc) {
        this.fac_cat6_tipodoc = fac_cat6_tipodoc;
    }

}
