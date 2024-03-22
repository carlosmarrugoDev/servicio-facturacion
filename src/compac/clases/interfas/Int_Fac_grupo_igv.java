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
public interface Int_Fac_grupo_igv<ObFac_grupo_igv> {
 
    public List<ObFac_grupo_igv> listar(); 
    public List<ObFac_grupo_igv> listarCnt(String dato,int cnt_carga);  
    public void registrar(ObFac_grupo_igv obj ); 
    public void actualizar(ObFac_grupo_igv obj ); 
    public void eliminar(int id ); 

    public ObFac_grupo_igv buscar_por_id(Integer id);  
     
    public int obtenerId_descripcion(String descripcion);
    public String obtieneDescripcion_id(int id_fac_grupo_igv); 
    public String obtieneCodigo_id(int id_fac_grupo_igv);  
    public double obtieneIGV_id(int id_fac_grupo_igv);   
    
    
    public void actualizarActivar(int id_fac_grupo_igv); 
    public void actualizarDesactivar(int id_fac_grupo_igv); 
}
