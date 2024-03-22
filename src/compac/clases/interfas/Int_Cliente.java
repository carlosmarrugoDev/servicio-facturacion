/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.interfas;
 
import java.util.List;

/**
 *
 * @author LuisT
 */
public interface Int_Cliente<ObCliente> {
     
    public List<ObCliente> listarCnt(String dato,int cnt_carga, int id_sedes );    
    public void registrar(ObCliente obj); 
    public void actualizar(ObCliente obj); 
    public void actualizarFoto(String foto,int id_cliente); 
    public void actualizarCorreo(String correo,int id_cliente); 
    
    public void eliminar(int id, int id_usuarios, int id_sedes ); 

    public ObCliente buscar_por_id(Integer id);  
    public int obtenerId_descripcion(String descripcion);
    public String obtieneDescripcion_id(int id_cliente); 
    
    public String obtieneDatosCliente(String campo,String documento); 
    public boolean validaCliente(String num_documento);
     
}
