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
public interface Int_Fac_cat6_Tipodoc<ObTipodoc> {
    
    public List<ObTipodoc> listar();
     public List<ObTipodoc> listarCnt(String dato,int cnt_carga);  
    public void registrar(ObTipodoc obj ); 
    public void actualizar(ObTipodoc obj ); 
    public void eliminar(int id_tipodoc ); 

    public ObTipodoc buscar_por_id(int id_tipodoc);  
    public int obtenerId_descripcion(String descripcion);
    public String obtieneCodigo_id(int id_tipodoc); 
    public String obtieneSimbolo_id(String descripcion); 
    public String obtieneDescripcion_id(int id_tipodoc);
    
    public void actualizarActivar(int id_tipodoc); 
    public void actualizarDesactivar(int id_tipodocid_tipodoc); 
     
}
