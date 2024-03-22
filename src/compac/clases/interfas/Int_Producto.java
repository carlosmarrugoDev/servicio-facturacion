/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.interfas;
 
import compac.clases.modelo.ObProductoView;
import java.util.List;

/**
 *
 * @author LuisT
 */
public interface Int_Producto<ObProducto> {
     
    public List<ObProducto> listar(int id_sedes );  
    public List<ObProductoView> listar(String dato,int cnt_carga, int id_sedes );  
    public List<ObProducto> listarCategorias(int idcategoria,String dato,int cnt_carga, int id_sedes);  
    
    public void registrar(ObProducto obj); 
    public void actualizar(ObProducto obj);   
    
    public void eliminar(int id, int id_usuarios, int id_sedes );  

    public ObProducto buscar_por_id(Integer id);   
    public void actualizarPrecio(int id_producto,double precio);  
    
    public int obtenerId_descripcion(String descripcion);
    public String obtieneDescripcion_id(int id_producto);
    public double obtienePrecio_id(int id_producto);
    public int obtenerId_codigo(String codigo);
     
}
