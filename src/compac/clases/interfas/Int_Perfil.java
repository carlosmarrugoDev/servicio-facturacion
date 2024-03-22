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
public interface Int_Perfil<ObPerfil> {
     
    public List<ObPerfil> listarSinDes(); 
    public List<ObPerfil> listar(); 
    public List<ObPerfil> listarCnt(String dato,int cnt_carga);  
    public List<ObPerfil> listarCntSinDes(String dato,int cnt_carga);  
    public void registrar(ObPerfil obj ); 
    public void actualizar(ObPerfil obj ); 
    public void eliminar(int id ); 

    public ObPerfil buscar_por_id(Integer id);  
    public int obtenerId_descripcion(String descripcion);
    public String obtieneDescripcion_id(int id_categoria);
     
}
