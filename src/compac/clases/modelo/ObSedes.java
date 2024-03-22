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
public class ObSedes {

    private int id_sede;
    private String descripcion, direccion, telefono, celular, ruc;
    private String email_clave, email_origen, email_destino, foto;
    private int estado;
    private String despedida;

    public ObSedes(int id_sede, String descripcion, String direccion, String telefono, String celular,
            String ruc, String email_clave, String email_origen, String email_destino, String foto,
            int estado, String despedida) {
        this.id_sede = id_sede;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.ruc = ruc;
        this.email_clave = email_clave;
        this.email_origen = email_origen;
        this.email_destino = email_destino;
        this.foto = foto;
        this.estado = estado;
        this.despedida = despedida;
    }

    public int getId_sede() {
        return id_sede;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getEmail_clave() {
        return email_clave;
    }

    public void setEmail_clave(String email_clave) {
        this.email_clave = email_clave;
    }

    public String getEmail_origen() {
        return email_origen;
    }

    public void setEmail_origen(String email_origen) {
        this.email_origen = email_origen;
    }

    public String getEmail_destino() {
        return email_destino;
    }

    public void setEmail_destino(String email_destino) {
        this.email_destino = email_destino;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDespedida() {
        return despedida;
    }

    public void setDespedida(String despedida) {
        this.despedida = despedida;
    }

}
