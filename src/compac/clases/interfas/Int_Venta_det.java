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
public interface Int_Venta_det<ObVenta_det> {
      
    public List<ObVenta_det> listar(int id_venta);  
    public void registrar(ObVenta_det obj );    
   
    public void eliminar(int id_venta); 
     
}
