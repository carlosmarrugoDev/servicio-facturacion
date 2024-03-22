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
public interface Int_Sede<ObSedes> {
 
    public List<ObSedes> listar();
    public List<ObSedes> listarCnt(String dato, int cnt_carga);
    public void registrar(ObSedes obj );
    public void actualizar(ObSedes obj );
    public void eliminar(int id ); 
    
    public void actualizarFoto(String descripcion,int id_sedes);
    
    public ObSedes buscar_por_id(Integer id);
    public int obtenerId_descripcion(String descripcion);  
    public String obtieneDescripcion_id(int id_sedes);  
    
    public String obtieneEmail_origen(int id_sedes);
    public String obtieneEmail_destino(int id_sedes);
    public String obtieneEmail_clave(int id_sedes);

}
