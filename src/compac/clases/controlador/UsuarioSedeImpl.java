/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.controlador;

import compac.clases.interfas.Int_UsuarioSede;
import compac.clases.modelo.ObUsuarioSede;
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
public class UsuarioSedeImpl extends SQL implements Int_UsuarioSede<ObUsuarioSede> {

    ConfigGeneral config = new ConfigGeneral();

    @Override
    public List<ObUsuarioSede> listarporUsuario(int idusuario) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObUsuarioSede> listaArray = new ArrayList<ObUsuarioSede>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from usuario_sede where id_usuario='" + idusuario + "' ");
            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_usuario_sede = rs.getInt(1);
                int id_usuario = rs.getInt(2);
                int id_sede = rs.getInt(3);
                listaArray.add(new ObUsuarioSede(id_usuario_sede, id_usuario, id_sede));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar ObUsuarioSede" + e);
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
    public void registrar(ObUsuarioSede obj) {
        String consulta = "INSERT INTO usuario_sede(id_usuario, id_sede) "
                + "VALUES ('" + obj.getId_usuario() + "','" + obj.getId_sede() + "' )";
        grabarTabla(consulta);
    }

    @Override
    public void eliminar(int idusuario, int id_usuarios, int id_sedes) {
        String consulta = "DELETE FROM usuario_sede "
                + "WHERE id_usuario='" + idusuario + "'";
        actualizaTabla(consulta);
    }

}
