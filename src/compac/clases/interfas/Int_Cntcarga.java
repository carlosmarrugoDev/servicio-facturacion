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
public interface Int_Cntcarga<ObCntcarga> {
 
    public List<ObCntcarga> listar(); 
    public List<ObCntcarga> listarCnt(int cnt_carga);  
    public void registrar(ObCntcarga obj ); 
    public void actualizar(ObCntcarga obj ); 
    public void eliminar(int id ); 

    public ObCntcarga buscar_por_id(Integer id);  
     
}
