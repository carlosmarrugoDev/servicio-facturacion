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
public class ObProductoView {

    private int id_producto, id_categoria;
    private String descripcion, codigo;
    private double precio;
    private int estado;
    private String ubicacion;
    private int id_usuario, id_sede, id_marca, id_fac_cat3_umedida, id_fac_cat7_igv;
    
    private String descripcion_categoria, marca_descripcion, fac_cat3_umedida_descripcion, fac_cat7_igv_descripcion;

    public ObProductoView(int id_producto, int id_categoria, String descripcion, String codigo,
            double precio, int estado, String ubicacion, int id_usuario, int id_sede, int id_marca,
            int id_fac_cat3_umedida, int id_fac_cat7_igv, String descripcion_categoria, String marca_descripcion,
            String fac_cat3_umedida_descripcion, String fac_cat7_igv_descripcion) {
        this.id_producto = id_producto;
        this.id_categoria = id_categoria;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.precio = precio;
        this.estado = estado;
        this.ubicacion = ubicacion;
        this.id_usuario = id_usuario;
        this.id_sede = id_sede;
        this.id_marca = id_marca;
        this.id_fac_cat3_umedida = id_fac_cat3_umedida;
        this.id_fac_cat7_igv = id_fac_cat7_igv;

        this.descripcion_categoria = descripcion_categoria;
        this.marca_descripcion = marca_descripcion;
        this.fac_cat3_umedida_descripcion = fac_cat3_umedida_descripcion;
        this.fac_cat7_igv_descripcion = fac_cat7_igv_descripcion;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
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

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public int getId_fac_cat3_umedida() {
        return id_fac_cat3_umedida;
    }

    public void setId_fac_cat3_umedida(int id_fac_cat3_umedida) {
        this.id_fac_cat3_umedida = id_fac_cat3_umedida;
    }

    public int getId_fac_cat7_igv() {
        return id_fac_cat7_igv;
    }

    public void setId_fac_cat7_igv(int id_fac_cat7_igv) {
        this.id_fac_cat7_igv = id_fac_cat7_igv;
    }

    public String getDescripcion_categoria() {
        return descripcion_categoria;
    }

    public void setDescripcion_categoria(String descripcion_categoria) {
        this.descripcion_categoria = descripcion_categoria;
    } 

    public String getMarca_descripcion() {
        return marca_descripcion;
    }

    public void setMarca_descripcion(String marca_descripcion) {
        this.marca_descripcion = marca_descripcion;
    }

    public String getFac_cat3_umedida_descripcion() {
        return fac_cat3_umedida_descripcion;
    }

    public void setFac_cat3_umedida_descripcion(String fac_cat3_umedida_descripcion) {
        this.fac_cat3_umedida_descripcion = fac_cat3_umedida_descripcion;
    }

    public String getFac_cat7_igv_descripcion() {
        return fac_cat7_igv_descripcion;
    }

    public void setFac_cat7_igv_descripcion(String fac_cat7_igv_descripcion) {
        this.fac_cat7_igv_descripcion = fac_cat7_igv_descripcion;
    }

}
