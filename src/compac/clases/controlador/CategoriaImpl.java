/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.controlador;

import compac.clases.interfas.Int_Categoria;
import compac.clases.modelo.ObCategoria;
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
public class CategoriaImpl extends SQL implements Int_Categoria<ObCategoria> {

    private ObCategoria categoria;
    ConfigGeneral config = new ConfigGeneral();

    @Override
    public List<ObCategoria> listar(int id_sedes) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObCategoria> listaArray = new ArrayList<ObCategoria>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from categoria where estado='1' and "
                    + " id_sede='" + id_sedes + "' order by descripcion");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_categoria = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                int id_usuario = rs.getInt(4);
                int id_sede = rs.getInt(5);
                listaArray.add(new ObCategoria(id_categoria, descripcion, estado, id_usuario, id_sede));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar ObCategoria" + e);
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
    public List<ObCategoria> listarCnt(String dato, int cnt, int id_sedes) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObCategoria> listaArray = new ArrayList<ObCategoria>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from categoria where estado='1' "
                    + " and descripcion  like '%" + dato + "%' and id_sede='" + id_sedes + "' "
                    + " order by descripcion limit 0," + cnt);

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_categoria = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                int id_usuario = rs.getInt(4);
                int id_sede = rs.getInt(5);
                listaArray.add(new ObCategoria(id_categoria, descripcion, estado, id_usuario, id_sede));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar ObCategoria" + e);
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
    public void registrar(ObCategoria obj) {
        String consulta = "INSERT INTO categoria(descripcion, estado ,id_usuario,id_sede) "
                + "VALUES ('" + obj.getDescripcion() + "','" + obj.getEstado() + "',"
                + "'" + obj.getId_usuario() + "','" + obj.getId_sede() + "' )";
        grabarTabla(consulta);

    }

    @Override
    public void actualizar(ObCategoria obj) {
        String consulta = "UPDATE categoria SET descripcion='" + obj.getDescripcion() + "',"
                + " id_usuario='" + obj.getId_usuario() + "', id_sede='" + obj.getId_sede() + "' "
                + " WHERE id_categoria='" + obj.getId_categoria() + "'";
        actualizaTabla(consulta);

        //ACTUALIZAMOS LA CATEGORIA
        String consultaCategoria = "UPDATE producto SET  categoria='" + obj.getDescripcion() + "' "
                + " WHERE id_categoria='" + obj.getId_categoria() + "'";
        actualizaTabla(consultaCategoria);

    }

    @Override
    public void eliminar(int id, int id_usuarios, int id_sedes) {
        String consulta = "UPDATE categoria SET estado='0' "
                + "WHERE id_categoria='" + id + "'";
        actualizaTabla(consulta);

    }

    @Override
    public int obtenerId_descripcion(String descripcion) {
        int id_perfil = 0;

        try {
            id_perfil = obtenerEntero("Select id_categoria from categoria where descripcion='" + descripcion + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return id_perfil;
    }

    @Override
    public String obtieneDescripcion_id(int id_categoria) {
        String descripcion = "";

        try {
            descripcion = obtenerCadena("Select descripcion from categoria where id_categoria='" + id_categoria + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return descripcion;
    }

    @Override
    public ObCategoria buscar_por_id(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from categoria where id_categoria='" + id + "' ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_categoria = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                int id_usuario = rs.getInt(4);
                int id_sede = rs.getInt(5);
                categoria = new ObCategoria(id_categoria, descripcion, estado, id_usuario, id_sede);
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
        return categoria;
    }

    public ObCategoria getObCategoria() {
        return categoria;
    }

    public void setObCategoria(ObCategoria categoria) {
        this.categoria = categoria;
    }

}
