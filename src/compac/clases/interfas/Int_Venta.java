/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compac.clases.interfas;
  
import compac.clases.modelo.ObVentaView;
import java.util.List;

/**
 *
 * @author LuisT
 */
public interface Int_Venta<ObVenta> {
      
    public List<ObVentaView> listarCnt(String dato,int cnt_carga, int id_sedes );  
    public void registrar(ObVenta obj ); 
    public void actualizar(ObVenta obj );  

    public ObVenta buscar_por_id(int id);   
     
}
