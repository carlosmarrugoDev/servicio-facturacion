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
public interface Int_Usuario<ObUsuario> {
     
    public List<ObUsuario> listar(); 
    public List<ObUsuario> listarCntDes(String dato,int cnt_carga ); 
    public List<ObUsuario> listarCnt(String dato,int cnt_carga ); 
    
    public void registrar(ObUsuario obj ); 
    public void actualizar(ObUsuario obj ); 
    public void eliminar(int id ); 

    public ObUsuario buscar_por_id(Integer id);  
    public int obtenerId_descripcion(String descripcion);
    public String obtenerUsuarioporId(int id_usuarios); 
    public int obtenerId_descripcionSede(String usuario); 
    
    //LOGIN
    public boolean validaUsuario(String usuario, String password);
    
    public int obtenerId_perfil(int id_usuarios); 
     
     
}
