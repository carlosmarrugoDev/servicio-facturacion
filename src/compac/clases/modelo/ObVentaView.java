/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.modelo;

import java.sql.Time;

/**
 *
 * @author USER
 */
public class ObVentaView {

    private int id_venta;
    private String documento, fecha;
    private Time hora;
    private int id_cliente;
    private String moneda;
    private double igv, sub_total, total_venta;
    private String leyenda;
    private double totalExonerado, totalGravado;
    private int id_usuario, id_sede, procesado;
    private String respuesta_sunat, tipofac, codigo_tipofac, nomcompleto, tipodoc, num_documento;

    public ObVentaView(int id_venta, String documento, String fecha, Time hora, int id_cliente, String moneda, double igv, double sub_total,
            double total_venta, String leyenda, double totalExonerado, double totalGravado, int id_usuario, int id_sede, int procesado,
            String respuesta_sunat, String tipofac, String codigo_tipofac, String nomcompleto, String tipodoc, String num_documento) {
        this.id_venta = id_venta;
        this.documento = documento;
        this.fecha = fecha;
        this.hora = hora;
        this.id_cliente = id_cliente;
        this.moneda = moneda;
        this.igv = igv;
        this.sub_total = sub_total;
        this.total_venta = total_venta;
        this.leyenda = leyenda;
        this.totalExonerado = totalExonerado;
        this.totalGravado = totalGravado;
        this.id_usuario = id_usuario;
        this.id_sede = id_sede;
        this.procesado = procesado;
        this.respuesta_sunat = respuesta_sunat;
        this.tipofac = tipofac;
        this.codigo_tipofac = codigo_tipofac;

        this.nomcompleto = nomcompleto;
        this.tipodoc = tipodoc;
        this.num_documento = num_documento;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }

    public double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(double total_venta) {
        this.total_venta = total_venta;
    }

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }

    public double getTotalExonerado() {
        return totalExonerado;
    }

    public void setTotalExonerado(double totalExonerado) {
        this.totalExonerado = totalExonerado;
    }

    public double getTotalGravado() {
        return totalGravado;
    }

    public void setTotalGravado(double totalGravado) {
        this.totalGravado = totalGravado;
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

    public int getProcesado() {
        return procesado;
    }

    public void setProcesado(int procesado) {
        this.procesado = procesado;
    }

    public String getRespuesta_sunat() {
        return respuesta_sunat;
    }

    public void setRespuesta_sunat(String respuesta_sunat) {
        this.respuesta_sunat = respuesta_sunat;
    }

    public String getTipofac() {
        return tipofac;
    }

    public void setTipofac(String tipofac) {
        this.tipofac = tipofac;
    }

    public String getCodigo_tipofac() {
        return codigo_tipofac;
    }

    public void setCodigo_tipofac(String codigo_tipofac) {
        this.codigo_tipofac = codigo_tipofac;
    }

    public String getNomcompleto() {
        return nomcompleto;
    }

    public void setNomcompleto(String nomcompleto) {
        this.nomcompleto = nomcompleto;
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

}
