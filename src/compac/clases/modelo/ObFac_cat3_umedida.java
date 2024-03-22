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
public class ObFac_cat3_umedida {

    private int id_fac_cat3_umedida;
    private String codigo_inter, nombre_inter, codigo, descripcion;
    private int estado_view;

    public ObFac_cat3_umedida(int id_fac_cat3_umedida, String codigo_inter, String nombre_inter,
            String codigo, String descripcion, int estado_view) {
        this.id_fac_cat3_umedida = id_fac_cat3_umedida;
        this.codigo_inter = codigo_inter;
        this.nombre_inter = nombre_inter;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado_view = estado_view;
    }

    public int getId_fac_cat3_umedida() {
        return id_fac_cat3_umedida;
    }

    public void setId_fac_cat3_umedida(int id_fac_cat3_umedida) {
        this.id_fac_cat3_umedida = id_fac_cat3_umedida;
    }

    public String getCodigo_inter() {
        return codigo_inter;
    }

    public void setCodigo_inter(String codigo_inter) {
        this.codigo_inter = codigo_inter;
    }

    public String getNombre_inter() {
        return nombre_inter;
    }

    public void setNombre_inter(String nombre_inter) {
        this.nombre_inter = nombre_inter;
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

    public int getEstado_view() {
        return estado_view;
    }

    public void setEstado_view(int estado_view) {
        this.estado_view = estado_view;
    }

}
