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
public interface Int_UsuarioSede<ObUsuarioSede> {

    public List<ObUsuarioSede> listarporUsuario(int usuario);
    public void registrar(ObUsuarioSede obj);
    public void eliminar(int id, int id_usuarios, int id_sedes);
    
}
