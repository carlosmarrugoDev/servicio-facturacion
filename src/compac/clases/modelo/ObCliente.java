/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.modelo;

/**
 *
 * @author IngenieroLuisTafurgm
 */
public class ObCliente {

    private int id_cliente;
    private String tipodoc;
    private String num_documento, direccion, celular;
    private String email;
    private int estado;
    private String nomcompleto;
    private int id_usuario, id_sede;
    private String observacion;
    private int id_tipodoc;

    public ObCliente(int id_cliente, String tipodoc, String num_documento, String direccion,
            String celular, String email, int estado, String nomcompleto,
            int id_usuario, int id_sede,String observacion,int id_tipodoc) {
        this.id_cliente = id_cliente;
        this.tipodoc = tipodoc;
        this.num_documento = num_documento;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
        this.estado = estado;
        this.nomcompleto = nomcompleto;
        this.id_usuario = id_usuario;
        this.id_sede = id_sede;
        this.observacion = observacion;
        this.id_tipodoc = id_tipodoc;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNomcompleto() {
        return nomcompleto;
    }

    public void setNomcompleto(String nomcompleto) {
        this.nomcompleto = nomcompleto;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_sede() {
        return id_sede;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getId_tipodoc() {
        return id_tipodoc;
    }

    public void setId_tipodoc(int id_tipodoc) {
        this.id_tipodoc = id_tipodoc;
    }

}
