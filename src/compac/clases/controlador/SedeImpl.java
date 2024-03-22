/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.controlador;

import compac.clases.interfas.Int_Sede;
import compac.clases.modelo.ObSedes;
import compac.clases.principales.Conectar;
import compac.clases.principales.ConfigGeneral;
import compac.clases.principales.SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LuisT
 */
public class SedeImpl extends SQL implements Int_Sede<ObSedes> {

    private ObSedes sede;
    ConfigGeneral config = new ConfigGeneral();

    @Override
    public List<ObSedes> listar() {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObSedes> listaArray = new ArrayList<ObSedes>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("Select * from sede where estado='1' order by descripcion ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_sede = rs.getInt(1);
                String descripcion = rs.getString(2);
                String direccion = rs.getString(3);
                String telefono = rs.getString(4);
                String celular = rs.getString(5);
                String ruc = rs.getString(6);
                String email_clave = rs.getString(7);
                String email_origen = rs.getString(8);
                String email_destino = rs.getString(9);
                String foto = rs.getString(10);
                int estado = rs.getInt(11);
                String despedida = rs.getString(12);
                listaArray.add(new ObSedes(id_sede, descripcion, direccion, telefono, celular, ruc,
                        email_clave, email_origen, email_destino, foto, estado, despedida));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar listar" + e);
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
    public List<ObSedes> listarCnt(String dato, int cnt) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObSedes> listaArray = new ArrayList<ObSedes>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from sede where "
                    + " descripcion  like '%" + dato + "%' and estado='1' "
                    + " order by descripcion limit 0," + cnt);

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_sede = rs.getInt(1);
                String descripcion = rs.getString(2);
                String direccion = rs.getString(3);
                String telefono = rs.getString(4);
                String celular = rs.getString(5);
                String ruc = rs.getString(6);
                String email_clave = rs.getString(7);
                String email_origen = rs.getString(8);
                String email_destino = rs.getString(9);
                String foto = rs.getString(10);
                int estado = rs.getInt(11);
                String despedida = rs.getString(12);
                listaArray.add(new ObSedes(id_sede, descripcion, direccion, telefono, celular, ruc,
                        email_clave, email_origen, email_destino, foto, estado, despedida));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar Cnt_carga" + e);
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
    public void registrar(ObSedes obj) {
        String consulta = "INSERT INTO  sede ( descripcion ,  direccion ,telefono,celular,ruc,email_clave,"
                + "email_origen,email_destino,foto,estado , despedida) "
                + "VALUES ('" + obj.getDescripcion() + "','" + obj.getDireccion() + "','" + obj.getTelefono() + "'"
                + ",'" + obj.getCelular() + "','" + obj.getRuc() + "' ,'" + obj.getEmail_clave() + "',"
                + "'" + obj.getEmail_origen() + "','" + obj.getEmail_destino() + "' ,'" + obj.getFoto() + "',"
                + "'" + obj.getEstado() + "','" + obj.getDespedida() + "')";
        grabarTabla(consulta);

    }

    @Override
    public void actualizar(ObSedes obj) {
        String consulta = "UPDATE  sede  SET  descripcion ='" + obj.getDescripcion() + "', "
                + " direccion ='" + obj.getDireccion() + "', "
                + " telefono ='" + obj.getTelefono() + "', celular ='" + obj.getCelular() + "', "
                + " ruc ='" + obj.getRuc() + "',  email_clave ='" + obj.getEmail_clave() + "',"
                + " email_origen ='" + obj.getEmail_origen() + "', email_destino ='" + obj.getEmail_destino() + "', "
                + " foto ='" + obj.getFoto() + "', estado ='" + obj.getEstado() + "', despedida ='" + obj.getDespedida() + "' "
                + " WHERE  id_sede ='" + obj.getId_sede() + "'";
        actualizaTabla(consulta);

        //ACTUALIZAMOS NOM_SEDE EN CONFIGURACIÓN
        String consultaConfig = "UPDATE sedeconfig SET  sede='" + obj.getDescripcion() + "'"
                + " WHERE id_sede='" + obj.getId_sede() + "'";
        actualizaTabla(consultaConfig);
    }

    @Override
    public void eliminar(int id_sede) {
        String consulta = "UPDATE  sede  SET  estado ='0' "
                + "WHERE  id_sede ='" + id_sede + "'";
        actualizaTabla(consulta);
    }

    @Override
    public void actualizarFoto(String foto, int id_sede) {
        String consulta = "UPDATE  sede  SET  foto ='" + foto + "' "
                + "WHERE  id_sede ='" + id_sede + "'";
        actualizaTabla(consulta);
    }

    @Override
    public ObSedes buscar_por_id(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * "
                    + " from sede where id_sede='" + id + "' ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_sede = rs.getInt(1);
                String descripcion = rs.getString(2);
                String direccion = rs.getString(3);
                String telefono = rs.getString(4);
                String celular = rs.getString(5);
                String ruc = rs.getString(6);
                String email_clave = rs.getString(7);
                String email_origen = rs.getString(8);
                String email_destino = rs.getString(9);
                String foto = rs.getString(10);
                int estado = rs.getInt(11);
                String despedida = rs.getString(12);
                sede = new ObSedes(id_sede, descripcion, direccion, telefono, celular, ruc,
                        email_clave, email_origen, email_destino, foto, estado, despedida);
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
        return sede;
    }

    public ObSedes getObSedes() {
        return sede;
    }

    public void setObSedes(ObSedes sede) {
        this.sede = sede;
    }

    @Override
    public int obtenerId_descripcion(String descripcion) {
        int id_sede = 0;

        try {
            id_sede = obtenerEntero("Select id_sede from sede where  descripcion ='" + descripcion + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return id_sede;
    }

    @Override
    public String obtieneDescripcion_id(int id_sede) {
        String descripcion = "";

        try {
            descripcion = obtenerCadena("Select descripcion from sede where  id_sede ='" + id_sede + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return descripcion;
    }

    @Override
    public String obtieneEmail_clave(int id_sede) {
        String descripcion = "";

        try {
            descripcion = obtenerCadena("Select email_clave from sede where  id_sede ='" + id_sede + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return descripcion;
    }

    @Override
    public String obtieneEmail_destino(int id_sede) {
        String descripcion = "";

        try {
            descripcion = obtenerCadena("Select email_destino from sede where  id_sede ='" + id_sede + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }

        return descripcion;
    }

    @Override
    public String obtieneEmail_origen(int id_sede) {
        String descripcion = "";

        try {
            descripcion = obtenerCadena("Select email_origen from sede where  id_sede ='" + id_sede + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_descripcion : " + e.getLocalizedMessage());
        }
        return descripcion;
    }


}
