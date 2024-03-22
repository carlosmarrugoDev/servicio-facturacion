/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.controlador;

import compac.clases.interfas.Int_Fac_facver;
import compac.clases.modelo.ObFac_facver;
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
public class Fac_facverImpl extends SQL implements Int_Fac_facver<ObFac_facver> {

    private ObFac_facver fac_facver;
    ConfigGeneral config = new ConfigGeneral();

    @Override
    public List<ObFac_facver> listar() {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObFac_facver> listaObFac_facver = new ArrayList<ObFac_facver>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from fac_facver where estado='1' order by descripcion ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_fac_facver = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                listaObFac_facver.add(new ObFac_facver(id_fac_facver, descripcion, estado));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar ObFac_facver" + e);
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
        return listaObFac_facver;
    }

    @Override
    public List<ObFac_facver> listarCnt(int fac_facver) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObFac_facver> listaObFac_facver = new ArrayList<ObFac_facver>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from fac_facver where estado='1' "
                    + "order by descripcion limit 0," + fac_facver);

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_fac_facver = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                listaObFac_facver.add(new ObFac_facver(id_fac_facver, descripcion, estado));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar ObFac_facver" + e);
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
        return listaObFac_facver;
    }

    @Override
    public void registrar(ObFac_facver obj) {
        String consulta = "INSERT INTO fac_facver(descripcion, estado ) "
                + "VALUES ('" + obj.getDescripcion() + "','" + obj.getEstado() + "' )";
        grabarTabla(consulta);
    }

    @Override
    public void actualizar(ObFac_facver obj) {
        String consulta = "UPDATE fac_facver SET descripcion='" + obj.getDescripcion() + "' "
                + " WHERE id_fac_facver='" + obj.getId_fac_facver() + "'";
        actualizaTabla(consulta);

        String consultaSede = "UPDATE  sede  SET fac_facver ='" + obj.getDescripcion() + "' "
                + " WHERE  id_fac_facver ='" + obj.getId_fac_facver() + "'";
        actualizaTabla(consultaSede);
    }

    @Override
    public void eliminar(int id) {
        String consulta = "UPDATE fac_facver SET estado='0' "
                + "WHERE id_fac_facver='" + id + "'";
        actualizaTabla(consulta);
    }

    @Override
    public ObFac_facver buscar_por_id(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from fac_facver where id_fac_facver='" + id + "' ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_fac_facver = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                fac_facver = new ObFac_facver(id_fac_facver, descripcion, estado);
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
        return fac_facver;
    }

    public ObFac_facver getObFac_facver() {
        return fac_facver;
    }

    public void setObFac_facver(ObFac_facver fac_facver) {
        this.fac_facver = fac_facver;
    }

    @Override
    public int obtenerId_descripcion(String descripcion) {
        int id_perfil = 0;

        try {
            id_perfil = obtenerEntero("Select id_fac_facver from fac_facver where descripcion='" + descripcion + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return id_perfil;
    }

    @Override
    public String obtieneDescripcion_id(int id_fac_facver) {
        String descripcion = "";

        try {
            descripcion = obtenerCadena("Select descripcion from fac_facver where id_fac_facver='" + id_fac_facver + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return descripcion;
    }

}
