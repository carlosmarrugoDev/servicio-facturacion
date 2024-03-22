/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.modelo;

/**
 *
 * @author USER
 */
public class ObVenta_det {

    private int id_venta_det, id_venta, id_producto;
    private double cantidad;
    private String descripcion;
    private double precio, igv, sub_total, total_venta;

    public ObVenta_det(int id_venta_det, int id_venta, int id_producto, double cantidad, String descripcion,
            double precio, double igv, double sub_total, double total_venta) {
        this.id_venta_det = id_venta_det;
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.precio = precio;
        this.igv = igv;
        this.sub_total = sub_total;
        this.total_venta = total_venta;
    }

    public int getId_venta_det() {
        return id_venta_det;
    }

    public void setId_venta_det(int id_venta_det) {
        this.id_venta_det = id_venta_det;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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

}
