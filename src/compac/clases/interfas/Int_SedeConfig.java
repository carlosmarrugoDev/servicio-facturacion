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
public interface Int_SedeConfig<ObSedeConfig> {
      
    public List<ObSedeConfig> listarCnt(String dato,int cnt_carga );  
    public void registrar(ObSedeConfig obj ); 
    public void actualizar(ObSedeConfig obj );  
    public void eliminar(int id); 

    public ObSedeConfig buscar_por_id(Integer id);   
     
}
