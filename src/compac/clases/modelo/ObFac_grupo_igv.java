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
public class ObFac_grupo_igv {

    private int id_fac_grupo_igv;
    private String codigo, descripcion;
    private double igv;
    private int estado_view;

    public ObFac_grupo_igv(int id_fac_grupo_igv, String codigo, String descripcion,
            double igv,int estado_view) {
        this.id_fac_grupo_igv = id_fac_grupo_igv;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.igv = igv;
        this.estado_view = estado_view;
    }

    public int getId_fac_grupo_igv() {
        return id_fac_grupo_igv;
    }

    public void setId_fac_grupo_igv(int id_fac_grupo_igv) {
        this.id_fac_grupo_igv = id_fac_grupo_igv;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public int getEstado_view() {
        return estado_view;
    }

    public void setEstado_view(int estado_view) {
        this.estado_view = estado_view;
    }

}
