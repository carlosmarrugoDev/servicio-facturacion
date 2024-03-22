/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.controlador;

import compac.clases.interfas.Int_Cliente;
import compac.clases.modelo.ObCliente;
import compac.clases.principales.Conectar;
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
public class ClienteImpl extends SQL implements Int_Cliente<ObCliente> {

    private ObCliente cliente;

    @Override
    public List<ObCliente> listarCnt(String dato, int cnt, int id_sedes) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        ArrayList<ObCliente> listaArray = new ArrayList<ObCliente>();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from cliente where "
                    + "(estado='1' and nomcompleto  like '%" + dato + "%' and id_sede='" + id_sedes + "') or "
                    + "(estado='1' and num_documento  like '%" + dato + "%' and id_sede='" + id_sedes + "')  or "
                    + "(estado='1' and celular  like '%" + dato + "%' and id_sede='" + id_sedes + "')   or "
                    + "(estado='1' and email  like '%" + dato + "%' and id_sede='" + id_sedes + "') "
                    + " order by nomcompleto limit 0," + cnt);

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_cliente = rs.getInt(1);
                String tipodoc = rs.getString(2);
                String num_documento = rs.getString(3);
                String direccion = rs.getString(4);
                String celular = rs.getString(5);
                String email = rs.getString(6);
                int estado = rs.getInt(7);
                String nomcompleto = rs.getString(8);
                int id_usuario = rs.getInt(9);
                int id_sede = rs.getInt(10);
                String observacion = rs.getString(11);
                int id_tipodoc = rs.getInt(12);
                listaArray.add(new ObCliente(id_cliente, tipodoc, num_documento,  direccion, celular, email,
                        estado, nomcompleto, id_usuario, id_sede,observacion,id_tipodoc));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en listar ObCliente " + e.getMessage());
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
    public void registrar(ObCliente obj) {
        String consulta = "INSERT INTO cliente(tipodoc, num_documento,direccion, celular,  email, estado ,"
                + "nomcompleto,id_usuario,id_sede,observacion,id_tipodoc) "
                + "VALUES ( '" + obj.getTipodoc() + "', '" + obj.getNum_documento() + "',"
                + "'" + obj.getDireccion() + "', '" + obj.getCelular() + "', '" + obj.getEmail() + "',"
                + "'" + obj.getEstado() + "', '" + obj.getNomcompleto() + "',"
                + "'" + obj.getId_usuario() + "','" + obj.getId_sede() + "','" + obj.getObservacion()+ "',"
                + "'" + obj.getId_tipodoc()+ "')";
        grabarTabla(consulta);


    }

    @Override
    public void actualizar(ObCliente obj) {
        String consulta = "UPDATE cliente SET  tipodoc='" + obj.getTipodoc() + "', "
                + "num_documento='" + obj.getNum_documento() + "', direccion='" + obj.getDireccion() + "',"
                + "celular='" + obj.getCelular() + "', email='" + obj.getEmail() + "',"
                + "nomcompleto='" + obj.getNomcompleto() + "',id_usuario='" + obj.getId_usuario() + "',"
                + "id_sede='" + obj.getId_sede() + "',observacion='" + obj.getObservacion()+ "',"
                + "id_tipodoc='" + obj.getId_tipodoc()+ "' "
                + " WHERE id_cliente='" + obj.getId_cliente() + "'";
        actualizaTabla(consulta);

    }

    @Override
    public void actualizarFoto(String foto, int id_cliente) {
        String consulta = "UPDATE cliente SET  foto='" + foto + "'  "
                + " WHERE id_cliente='" + id_cliente + "'";
        actualizaTabla(consulta);
    }

    @Override
    public void actualizarCorreo(String email, int id_cliente) {
        String consulta = "UPDATE cliente SET  email='" + email + "'  "
                + " WHERE id_cliente='" + id_cliente + "'";
        actualizaTabla(consulta);
    }

    @Override
    public void eliminar(int id, int id_usuarios, int id_sedes) {
        String consulta = "UPDATE cliente SET estado='0' "
                + "WHERE id_cliente='" + id + "'";
        actualizaTabla(consulta);
    }

    @Override
    public ObCliente buscar_por_id(Integer id) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        try {
            con = conectar.getConexion();
            pst = con.prepareStatement("select * from cliente where id_cliente='" + id + "' ");

            ResultSet rs = pst.executeQuery();//si hay consulta 
            while (rs.next()) {
                int id_cliente = rs.getInt(1);
                String tipodoc = rs.getString(2);
                String num_documento = rs.getString(3);
                String direccion = rs.getString(4);
                String celular = rs.getString(5);
                String email = rs.getString(6);
                int estado = rs.getInt(7);
                String nomcompleto = rs.getString(8);
                int id_usuario = rs.getInt(9);
                int id_sede = rs.getInt(10);
                String observacion = rs.getString(11); 
                int id_tipodoc = rs.getInt(12); 
                cliente = new ObCliente(id_cliente, tipodoc, num_documento,  direccion, celular, email,
                        estado, nomcompleto, id_usuario, id_sede,observacion,id_tipodoc);
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
        return cliente;
    }

    public ObCliente getObCliente() {
        return cliente;
    }

    public void setObCliente(ObCliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int obtenerId_descripcion(String nomcompleto) {
        int id_perfil = 0;

        try {
            id_perfil = obtenerEntero("Select id_cliente from cliente where nomcompleto='" + nomcompleto + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_nomcompleto : " + e.getLocalizedMessage());
        }

        return id_perfil;
    }

    @Override
    public String obtieneDescripcion_id(int id_cliente) {
        String nomcompleto = "";

        try {
            nomcompleto = obtenerCadena("Select nomcompleto from cliente where id_cliente='" + id_cliente + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_nomcompleto : " + e.getLocalizedMessage());
        }

        return nomcompleto;
    }

    @Override
    public String obtieneDatosCliente(String campo, String documento) {
        String dato = "";

        try {
            dato = obtenerCadena("Select " + campo + " from cliente where num_documento='" + documento + "'");
        } catch (Exception e) {
            System.err.println("error obtenerId_nomcompleto : " + e.getLocalizedMessage());
        }

        return dato;
    }

    @Override
    public boolean validaCliente(String num_documento) {
        Connection con = null;
        PreparedStatement pst = null;
        Conectar conectar = new Conectar();
        try {
            con = conectar.getConexion();
            String sql = "Select id_cliente from cliente where  num_documento='" + num_documento + "' and estado='1'";
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {//recorre haver si SI HUVO REGISTRO con ese ID Y ESA CLAVE
                return true;   //retorna lo q encontro en la BD
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error en la conexión " + e);
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

        return false;
    }

}
