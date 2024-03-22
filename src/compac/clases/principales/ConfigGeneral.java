/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.principales;

/**
 *
 * @author IngenieroLuisTafurgm
 */
public class ConfigGeneral {
 
    private String ruta = "C:\\COMPAC"; 
    private int opcion_visual=0;
  
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getOpcion_visual() {
        return opcion_visual;
    }

    public void setOpcion_visual(int opcion_visual) {
        this.opcion_visual = opcion_visual;
    }
 

}
