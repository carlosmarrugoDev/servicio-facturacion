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
public class ObFac_cat17_oper {

    private int id_fac_cat17_oper;
    private String codigo, descripcion;
    private int estado_view;

    public ObFac_cat17_oper(int id_fac_cat17_oper, String codigo, String descripcion, int estado_view) {
        this.id_fac_cat17_oper = id_fac_cat17_oper;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado_view = estado_view;
    } 

    public int getId_fac_cat17_oper() {
        return id_fac_cat17_oper;
    }

    public void setId_fac_cat17_oper(int id_fac_cat17_oper) {
        this.id_fac_cat17_oper = id_fac_cat17_oper;
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
