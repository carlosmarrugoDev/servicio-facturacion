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
public class ObFac_cat6_Tipodoc {

    private int id_tipodoc;
    private String descripcion;
    private int estado, longitud;
    private String codigo;
    private int estado_view;
    private String simbolo;

    public ObFac_cat6_Tipodoc(int id_tipodoc, String descripcion, int estado, int longitud,
            String codigo, int estado_view,String simbolo) {
        this.id_tipodoc = id_tipodoc;
        this.descripcion = descripcion;
        this.estado = estado;
        this.longitud = longitud;
        this.codigo = codigo;
        this.estado_view = estado_view;
        this.simbolo = simbolo;
    }

    public int getId_tipodoc() {
        return id_tipodoc;
    }

    public void setId_tipodoc(int id_tipodoc) {
        this.id_tipodoc = id_tipodoc;
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

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getEstado_view() {
        return estado_view;
    }

    public void setEstado_view(int estado_view) {
        this.estado_view = estado_view;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

}
