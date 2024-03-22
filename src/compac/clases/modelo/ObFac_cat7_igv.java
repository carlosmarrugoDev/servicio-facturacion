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
public class ObFac_cat7_igv {

    private int id_fac_cat7_igv;
    private String codigo, descripcion,codigo_tributo;
    private int estado_view;

    public ObFac_cat7_igv(int id_fac_cat7_igv, String codigo, String descripcion,
            String codigo_tributo,int estado_view) {
        this.id_fac_cat7_igv = id_fac_cat7_igv;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.codigo_tributo = codigo_tributo;
        this.estado_view = estado_view;
    }

    public int getId_fac_cat7_igv() {
        return id_fac_cat7_igv;
    }

    public void setId_fac_cat7_igv(int id_fac_cat7_igv) {
        this.id_fac_cat7_igv = id_fac_cat7_igv;
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

    public String getCodigo_tributo() {
        return codigo_tributo;
    }

    public void setCodigo_tributo(String codigo_tributo) {
        this.codigo_tributo = codigo_tributo;
    }

    public int getEstado_view() {
        return estado_view;
    }

    public void setEstado_view(int estado_view) {
        this.estado_view = estado_view;
    }

}
