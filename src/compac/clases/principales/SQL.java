/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.principales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author IngenieroLuisTafurgm
 */
public class SQL {

    /**
     * Graba*
     */
    public void grabarTabla(String sql) {
        Conectar cc = new Conectar();
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = cc.getConexion();
            //RECIBE EL PARAMETRO DE LA SENTENCIA SQL
            pst = con.prepareStatement(sql);
            int rs = pst.executeUpdate();//devulve la cantidad de filas añadidas
        } catch (Exception ex) {
            System.out.println("Error en la sentencia Insertar www" + ex.getMessage());
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
    }

    public boolean valida_Campos(String consulta) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        try {
            con = conectar.getConexion();
            String sql = consulta;
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {//recorre haver si SI HUVO REGISTRO con ese ID Y ESA CLAVE
                return true;   //retorna lo q encontro en la BD
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error en la conexión " + e);
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

        return false;
    } 

    /**
     * Actualiza*
     */
    public boolean actualizaTabla(String sql) {
        Conectar cc = new Conectar();
        try {
            Statement st = cc.getConexion().createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }

    public int obtenerEntero(String sql) {
        Connection con = null;
        PreparedStatement pst = null;
        int valor = 0;
        Conectar cc = new Conectar();

        try {
            con = cc.getConexion();
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) { // mientras aya informacion almacenarl en el listado
                valor = rs.getInt(1);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en obtener_entero " + e.getMessage());
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
        return valor;
    }

    public String obtenerCadena(String sql) {
        Connection con = null;
        Conectar cc = new Conectar();
        PreparedStatement pst = null;
        String cadena = null;

        try {
            con = cc.getConexion();
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) { // mientras aya informacion almacenarl en el listado
                cadena = rs.getString(1);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en obtener_cadena " + e.getMessage());
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
        return cadena;
    }

    public double obtenerDouble(String sql) {
        Connection con = null;
        PreparedStatement pst = null;
        double valor = 0.0;
        Conectar cc = new Conectar();

        try {
            con = cc.getConexion();
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) { // mientras aya informacion almacenarl en el listado
                valor = rs.getDouble(1);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en obtener_double " + e.getMessage());
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
        return valor;
    }

    public Date obtenerFecha(String sql) {

        Connection con = null;
        Conectar cc = new Conectar();
        PreparedStatement pst = null;
        Date fecha = null;

        try {
            con = cc.getConexion();
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) { // mientras aya informacion almacenarl en el listado
                fecha = rs.getDate(1);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en obtener_fecha " + e.getMessage());
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
        return fecha;
    }
}
