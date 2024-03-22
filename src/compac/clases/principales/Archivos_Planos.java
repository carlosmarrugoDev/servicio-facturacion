/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.principales;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author IngenieroLuisTafurgm
 */
public class Archivos_Planos {

    ConfigGeneral config = new ConfigGeneral();

    Encripar encrip = new Encripar();

    public void crearTXT(String ruta, String texto) {
        File archi = new File(ruta);
        try {
            FileWriter fw = new FileWriter(archi);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(texto);
            pw.close();

        } catch (IOException io) {
            JOptionPane.showMessageDialog(null, "error" + io);
        }
    }

    public void Eliminar_archivo(String ruta) {
        try {

            File archi = new File(ruta);
            if (archi.delete()) {
                System.out.println("Archivo Eliminado");
            } else {
                System.out.println("Archivo no se pudo Eliminar");
            }
        } catch (Exception e) {
            System.out.println("ERROR : " + e.getLocalizedMessage());
        }
    }

    public String leeBaseDatos(int valor) {
        String retorna = null;
        String ruta = config.getRuta() + "\\bin\\cnx\\BD.dat";
        File archivo = new File(ruta);
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            //abrir el archivo para mostrar
            String linea = ""; 
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                retorna = datos[valor];
                return encrip.desencriptarGeneral(retorna);
            }
            br.close();
        } catch (IOException ioex) {
            JOptionPane.showMessageDialog(null, "Error" + ioex);
        }
        return null;
    }  
  
}
