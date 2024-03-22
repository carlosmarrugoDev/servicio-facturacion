/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.modelo;

/**
 *
 * @author LuisT
 */
public class ObCntcarga {

    private int id_cntcarga;
    private int cantidad;
    private int estado;

    public ObCntcarga(int id_cntcarga, int cantidad, int estado) {
        this.id_cntcarga = id_cntcarga;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public int getIdcant_carga() {
        return id_cntcarga;
    }

    public void setIdcant_carga(int id_cntcarga) {
        this.id_cntcarga = id_cntcarga;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
 
}
