/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.controlador;

import compac.clases.interfas.Int_Marca;
import compac.clases.modelo.ObMarca;
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
public class MarcaImpl extends SQL implements Int_Marca<ObMarca> {

    private ObMarca marca;
    ConfigGeneral config = new ConfigGeneral();

    @Override
    public List<ObMarca> listar(int id_sedes) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObMarca> listaArray = new ArrayList<ObMarca>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from marca where estado='1' and "
                    + " id_sede='" + id_sedes + "' order by descripcion");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_marca = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                int id_usuario = rs.getInt(4);
                int id_sede = rs.getInt(5);
                listaArray.add(new ObMarca(id_marca, descripcion, estado, id_usuario, id_sede));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar ObMarca" + e);
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
    public List<ObMarca> listarCnt(String dato, int cnt, int id_sedes) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObMarca> listaArray = new ArrayList<ObMarca>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from marca where estado='1' "
                    + " and descripcion  like '%" + dato + "%' and id_sede='" + id_sedes + "' "
                    + " order by descripcion limit 0," + cnt);

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_marca = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                int id_usuario = rs.getInt(4);
                int id_sede = rs.getInt(5);
                listaArray.add(new ObMarca(id_marca, descripcion, estado, id_usuario, id_sede));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar ObMarca" + e);
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
    public void registrar(ObMarca obj) {
        String consulta = "INSERT INTO marca(descripcion, estado ,id_usuario,id_sede) "
                + "VALUES ('" + obj.getDescripcion() + "','" + obj.getEstado() + "',"
                + "'" + obj.getId_usuario() + "','" + obj.getId_sede() + "' )";
        grabarTabla(consulta);

    }

    @Override
    public void actualizar(ObMarca obj) {
        String consulta = "UPDATE marca SET descripcion='" + obj.getDescripcion() + "',"
                + " id_usuario='" + obj.getId_usuario() + "', id_sede='" + obj.getId_sede() + "' "
                + " WHERE id_marca='" + obj.getId_marca() + "'";
        actualizaTabla(consulta);

        //ACTUALIZAMOS LA CATEGORIA
        String consultaMarca = "UPDATE producto SET  marca='" + obj.getDescripcion() + "' "
                + " WHERE id_marca='" + obj.getId_marca() + "'";
        actualizaTabla(consultaMarca);

    }

    @Override
    public void eliminar(int id, int id_usuarios, int id_sedes) {
        String consulta = "UPDATE marca SET estado='0' "
                + "WHERE id_marca='" + id + "'";
        actualizaTabla(consulta);

    }

    @Override
    public int obtenerId_descripcion(String descripcion) {
        int id_perfil = 0;

        try {
            id_perfil = obtenerEntero("Select id_marca from marca where descripcion='" + descripcion + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return id_perfil;
    }

    @Override
    public String obtieneDescripcion_id(int id_marca) {
        String descripcion = "";

        try {
            descripcion = obtenerCadena("Select descripcion from marca where id_marca='" + id_marca + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return descripcion;
    }

    @Override
    public ObMarca buscar_por_id(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from marca where id_marca='" + id + "' ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_marca = rs.getInt(1);
                String descripcion = rs.getString(2);
                int estado = rs.getInt(3);
                int id_usuario = rs.getInt(4);
                int id_sede = rs.getInt(5);
                marca = new ObMarca(id_marca, descripcion, estado, id_usuario, id_sede);
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
        return marca;
    }

    public ObMarca getObMarca() {
        return marca;
    }

    public void setObMarca(ObMarca marca) {
        this.marca = marca;
    }

}
