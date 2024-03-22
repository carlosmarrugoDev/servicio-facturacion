/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.controlador;

import compac.clases.interfas.Int_Perfil;
import compac.clases.modelo.ObPerfil;
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
public class PerfilImpl extends SQL implements Int_Perfil<ObPerfil> {

    private ObPerfil perfil;
    ConfigGeneral config = new ConfigGeneral();

    @Override
    public List<ObPerfil> listarSinDes() {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObPerfil> listaArray = new ArrayList<ObPerfil>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from perfil where estado='1'  "
                    + " and descripcion!='DESARROLLADOR' order by descripcion");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_perfil = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                listaArray.add(new ObPerfil(id_perfil, descripcion, estado));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar ObPerfil" + e);
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
    public List<ObPerfil> listar() {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObPerfil> listaArray = new ArrayList<ObPerfil>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from perfil where estado='1'  order by descripcion");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_perfil = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                listaArray.add(new ObPerfil(id_perfil, descripcion, estado));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar ObPerfil" + e);
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
    public List<ObPerfil> listarCnt(String dato, int cnt) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObPerfil> listaArray = new ArrayList<ObPerfil>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from perfil where estado='1' "
                    + " and descripcion  like '%" + dato + "%'  order by descripcion limit 0," + cnt);

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_perfil = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                listaArray.add(new ObPerfil(id_perfil, descripcion, estado));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar ObPerfil" + e);
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
    public List<ObPerfil> listarCntSinDes(String dato, int cnt) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObPerfil> listaArray = new ArrayList<ObPerfil>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from perfil where estado='1' "
                    + " and descripcion  like '%" + dato + "%'  "
                    + " and descripcion!='DESARROLLADOR'order by descripcion limit 0," + cnt);

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_perfil = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                listaArray.add(new ObPerfil(id_perfil, descripcion, estado));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar ObPerfil" + e);
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
    public void registrar(ObPerfil obj) {
        String consulta = "INSERT INTO perfil(descripcion, estado ) "
                + "VALUES ('" + obj.getDescripcion() + "','" + obj.getEstado() + "' )";
        grabarTabla(consulta);
    }

    @Override
    public void actualizar(ObPerfil obj) {
        String consulta = "UPDATE perfil SET descripcion='" + obj.getDescripcion() + "' "
                + " WHERE id_perfil='" + obj.getId_perfil() + "'";
        actualizaTabla(consulta);
    }

    @Override
    public void eliminar(int id) {
        String consulta = "UPDATE perfil SET estado='0' "
                + "WHERE id_perfil='" + id + "'";
        actualizaTabla(consulta);
    }

    @Override
    public int obtenerId_descripcion(String descripcion) {
        int id_perfil = 0;

        try {
            id_perfil = obtenerEntero("Select id_perfil from perfil where descripcion='" + descripcion + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return id_perfil;
    }

    @Override
    public String obtieneDescripcion_id(int id_perfil) {
        String descripcion = "";

        try {
            descripcion = obtenerCadena("Select descripcion from perfil where id_perfil='" + id_perfil + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return descripcion;
    }

    @Override
    public ObPerfil buscar_por_id(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from perfil where id_perfil='" + id + "' ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_perfil = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                perfil = new ObPerfil(id_perfil, descripcion, estado);
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
        return perfil;
    }

    public ObPerfil getObPerfil() {
        return perfil;
    }

    public void setObPerfil(ObPerfil perfil) {
        this.perfil = perfil;
    }

}
