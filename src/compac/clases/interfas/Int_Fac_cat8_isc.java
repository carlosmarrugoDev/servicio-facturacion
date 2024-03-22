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
public interface Int_Fac_cat8_isc<ObFac_cat8_isc> {
 
    public List<ObFac_cat8_isc> listar(); 
    public List<ObFac_cat8_isc> listarCnt(String dato,int cnt_carga);  
    public void registrar(ObFac_cat8_isc obj ); 
    public void actualizar(ObFac_cat8_isc obj ); 
    public void eliminar(int id ); 

    public ObFac_cat8_isc buscar_por_id(Integer id);  
     
    public int obtenerId_descripcion(String descripcion);
    public String obtieneDescripcion_id(int id_fac_grupo_igv); 
    public String obtieneCodigo_id(int id_fac_grupo_igv);   
    
    
    public void actualizarActivar(int id_fac_grupo_igv); 
    public void actualizarDesactivar(int id_fac_grupo_igv); 
}
