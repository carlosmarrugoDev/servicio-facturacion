/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.controlador;

import compac.clases.interfas.Int_SedeConfig;
import compac.clases.modelo.ObSedeConfig;
import compac.clases.principales.Conectar;
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
public class SedeconfigImpl extends SQL implements Int_SedeConfig<ObSedeConfig> {

    private ObSedeConfig sedeconfig;

    @Override
    public List<ObSedeConfig> listarCnt(String dato, int cnt) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObSedeConfig> listaArray = new ArrayList<ObSedeConfig>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from sedeconfig where sede  like '%" + dato + "%' "
                    + " order by sede limit 0," + cnt);

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_sedeconfig = rs.getInt(1);
                int id_sede = rs.getInt(2);
                int modelo_codbar = rs.getInt(3);
                String sede = rs.getString(4);
                listaArray.add(new ObSedeConfig(id_sedeconfig, id_sede, modelo_codbar, sede));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar ObSedeConfig" + e);
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
    public void registrar(ObSedeConfig obj) {
        String consulta = "INSERT INTO sedeconfig( modelo_codbar,id_sede,sede ) "
                + "VALUES ('" + obj.getModelo_codbar() + "', '" + obj.getId_sede() + "','" + obj.getSede() + "' )";
        grabarTabla(consulta);

    }

    @Override
    public void actualizar(ObSedeConfig obj) {
        String consulta = "UPDATE sedeconfig SET modelo_codbar='" + obj.getModelo_codbar() + "' , "
                + "id_sede='" + obj.getId_sede() + "',sede='" + obj.getSede() + "'"
                + " WHERE id_sedeconfig='" + obj.getId_sedeconfig() + "'";
        actualizaTabla(consulta);

    }

    @Override
    public void eliminar(int id) {
        String consulta = "DELETE FROM sedeconfig   "
                + "WHERE id_sedeconfig='" + id + "'";
        actualizaTabla(consulta);
    }

    @Override
    public ObSedeConfig buscar_por_id(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from sedeconfig where id_sedeconfig='" + id + "' ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_sedeconfig = rs.getInt(1);
                int id_sede = rs.getInt(2);
                int modelo_codbar = rs.getInt(3);
                String sede = rs.getString(4);
                sedeconfig = new ObSedeConfig(id_sedeconfig, id_sede, modelo_codbar, sede);
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
        return sedeconfig;
    }

    public ObSedeConfig getObSedeConfig() {
        return sedeconfig;
    }

    public void setObSedeConfig(ObSedeConfig sedeconfig) {
        this.sedeconfig = sedeconfig;
    }

}
