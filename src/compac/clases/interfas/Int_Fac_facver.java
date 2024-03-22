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
public interface Int_Fac_facver<ObFac_facver> {
 
    public List<ObFac_facver> listar(); 
    public List<ObFac_facver> listarCnt(int cnt_carga);  
    public void registrar(ObFac_facver obj ); 
    public void actualizar(ObFac_facver obj ); 
    public void eliminar(int id ); 

    public ObFac_facver buscar_por_id(Integer id);  
    public int obtenerId_descripcion(String descripcion);
    public String obtieneDescripcion_id(int id_facver); 
     
}
