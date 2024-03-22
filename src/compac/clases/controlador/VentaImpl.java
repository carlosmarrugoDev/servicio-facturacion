/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.controlador;

import compac.clases.interfas.Int_Venta;
import compac.clases.modelo.ObVenta;
import compac.clases.modelo.ObVentaView;
import compac.clases.principales.Conectar;
import compac.clases.principales.ConfigGeneral;
import compac.clases.principales.SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Time;

/**
 *
 * @author LuisT
 */
public class VentaImpl extends SQL implements Int_Venta<ObVenta> {

    private ObVenta venta;
    ConfigGeneral config = new ConfigGeneral();

    @Override
    public List<ObVentaView> listarCnt(String dato, int cnt, int id_sedes) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObVentaView> listaArray = new ArrayList<ObVentaView>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from venta_listado where "
                    + " id_sede='" + id_sedes + "' and  nomcompleto like '%" + dato + "%' "
                    + " order by id_venta limit 0," + cnt);

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_venta = rs.getInt(1);
                String documento = rs.getString(2);
                String fecha = rs.getString(3);
                Time hora = rs.getTime(4);
                int id_cliente = rs.getInt(5);
                String moneda = rs.getString(6);
                double igv = rs.getDouble(7);
                double sub_total = rs.getDouble(8);
                double total_venta = rs.getDouble(9);
                String leyenda = rs.getString(10);
                double totalExonerado = rs.getDouble(11);
                double totalGravado = rs.getDouble(12);
                int id_usuario = rs.getInt(13);
                int id_sede = rs.getInt(14);
                int procesado = rs.getInt(15);
                String respuesta_sunat = rs.getString(16);
                String tipofac = rs.getString(17);
                String codigo_tipofac = rs.getString(18);

                String nomcompleto = rs.getString(19);
                String tipodoc = rs.getString(20);
                String num_documento = rs.getString(21);
                listaArray.add(new ObVentaView(id_venta, documento, fecha, hora, id_cliente, moneda, igv,
                        sub_total, total_venta, leyenda, totalExonerado, totalGravado, id_usuario, id_sede,
                        procesado, respuesta_sunat, tipofac, codigo_tipofac, nomcompleto, tipodoc, num_documento));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar ObVenta" + e);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar ");
            }
        }
        return listaArray;
    }

    @Override
    public void registrar(ObVenta obj) {
        String consulta = "INSERT INTO venta(documento, fecha, hora, id_cliente, moneda, igv, sub_total, "
                + "total_venta, leyenda, totalExonerado, totalGravado, id_usuario, id_sede, procesado, respuesta_sunat, "
                + "tipofac, codigo_tipofac) VALUES "
                + "('" + obj.getDocumento() + "','" + obj.getFecha() + "','" + obj.getHora() + "','" + obj.getId_cliente() + "',"
                + "'" + obj.getMoneda() + "','" + obj.getIgv() + "','" + obj.getSub_total() + "','" + obj.getTotal_venta() + "',"
                + "'" + obj.getLeyenda() + "','" + obj.getTotalExonerado() + "','" + obj.getTotalGravado() + "','" + obj.getId_usuario() + "',"
                + "'" + obj.getId_sede() + "','" + obj.getProcesado() + "','" + obj.getRespuesta_sunat() + "','" + obj.getTipofac() + "',"
                + "'" + obj.getCodigo_tipofac() + "' )";
        grabarTabla(consulta);

    }

    @Override
    public void actualizar(ObVenta obj) {
        String consulta = "UPDATE venta SET documento='" + obj.getDocumento() + "',fecha='" + obj.getFecha() + "',hora='" + obj.getHora() + "',"
                + "id_cliente='" + obj.getId_cliente() + "',moneda='" + obj.getMoneda() + "',igv='" + obj.getIgv() + "',sub_total='" + obj.getSub_total() + "',"
                + "total_venta='" + obj.getTotal_venta() + "',leyenda='" + obj.getLeyenda() + "',totalExonerado='" + obj.getTotalExonerado() + "',"
                + "totalGravado='" + obj.getTotalGravado() + "',id_usuario='" + obj.getId_usuario() + "',id_sede='" + obj.getId_sede() + "',"
                + "procesado='" + obj.getProcesado() + "',respuesta_sunat='" + obj.getRespuesta_sunat() + "',tipofac='" + obj.getTipofac() + "',"
                + "codigo_tipofac='" + obj.getCodigo_tipofac() + "' WHERE  id_venta='" + obj.getId_venta() + "'";
        actualizaTabla(consulta);

    }

    @Override
    public ObVenta buscar_por_id(int id) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from venta where id_venta='" + id + "' ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_venta = rs.getInt(1);
                String documento = rs.getString(2);
                String fecha = rs.getString(3);
                Time hora = rs.getTime(4);
                int id_cliente = rs.getInt(5);
                String moneda = rs.getString(6);
                double igv = rs.getDouble(7);
                double sub_total = rs.getDouble(8);
                double total_venta = rs.getDouble(9);
                String leyenda = rs.getString(10);
                double totalExonerado = rs.getDouble(11);
                double totalGravado = rs.getDouble(12);
                int id_usuario = rs.getInt(13);
                int id_sede = rs.getInt(14);
                int procesado = rs.getInt(15);
                String respuesta_sunat = rs.getString(16);
                String tipofac = rs.getString(17);
                String codigo_tipofac = rs.getString(18);
                venta = new ObVenta(id_venta, documento, fecha, hora, id_cliente, moneda, igv, sub_total, total_venta,
                        leyenda, totalExonerado, totalGravado, id_usuario, id_sede, procesado, respuesta_sunat, tipofac,
                        codigo_tipofac);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en buscar_por_id " + e);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar ");
            }
        }
        return venta;
    }

    public ObVenta getObVenta() {
        return venta;
    }

    public void setObVenta(ObVenta venta) {
        this.venta = venta;
    }

}
