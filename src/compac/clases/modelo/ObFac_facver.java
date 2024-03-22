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
public class ObFac_facver {

    private int id_fac_facver;
    private String descripcion;
    private int estado;

    public ObFac_facver(int id_fac_facver, String descripcion, int estado) {
        this.id_fac_facver = id_fac_facver;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getId_fac_facver() {
        return id_fac_facver;
    }

    public void setId_fac_facver(int id_fac_facver) {
        this.id_fac_facver = id_fac_facver;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
