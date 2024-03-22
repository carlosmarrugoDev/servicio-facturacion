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
public interface Int_Categoria<ObCategoria> {
     
    public List<ObCategoria> listar( int id_sedes ); 
    public List<ObCategoria> listarCnt(String dato,int cnt_carga, int id_sedes );  
    public void registrar(ObCategoria obj ); 
    public void actualizar(ObCategoria obj ); 
    public void eliminar(int id, int id_usuarios, int id_sedes ); 

    public ObCategoria buscar_por_id(Integer id);  
    public int obtenerId_descripcion(String descripcion);
    public String obtieneDescripcion_id(int id_categoria);
     
}
