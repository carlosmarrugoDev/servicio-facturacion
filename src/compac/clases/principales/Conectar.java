/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.principales;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author IngenieroLuisTafurgm
 */
public class Conectar {

    Archivos_Planos archivo = new Archivos_Planos();
    private Connection conexion;//permite hacer el puente entre la BD 

    public Conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            conexion = DriverManager.getConnection("jdbc:mysql://" + archivo.leeBaseDatos(3) + ":" + archivo.leeBaseDatos(4) + "/" + archivo.leeBaseDatos(0) + "?zeroDateTimeBehavior=convertToNull", archivo.leeBaseDatos(1), archivo.leeBaseDatos(2));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConexion() {
        return conexion;
    }

}
