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
public interface Int_Fac_cat3_umedida<ObFac_cat3_umedida> {
 
    public List<ObFac_cat3_umedida> listar(); 
    public List<ObFac_cat3_umedida> listarCnt(String dato,int cnt_carga);  
    public void registrar(ObFac_cat3_umedida obj ); 
    public void actualizar(ObFac_cat3_umedida obj ); 
    public void eliminar(int id ); 

    public ObFac_cat3_umedida buscar_por_id(Integer id);  
     
    public int obtenerId_descripcion(String descripcion);
    public String obtieneDescripcion_id(int id_fac_cat7_igv); 
    public String obtieneCodigo_id(int id_fac_cat7_igv);  
    
    
    public void actualizarActivar(int id_fac_cat7_igv); 
    public void actualizarDesactivar(int id_fac_cat7_igv); 
}
