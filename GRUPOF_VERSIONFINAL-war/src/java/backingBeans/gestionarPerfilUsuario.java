/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBeans;

import ejb.BaseDeDatosLocal;
import entidades.Organizacion;
import entidades.Usuario;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */

@Named(value ="PerfilUsuario")
@RequestScoped
public class gestionarPerfilUsuario implements Serializable{
    
    @Inject 
    private BaseDeDatosLocal bbdd;
    
    private Usuario usuario;
    
   
    public gestionarPerfilUsuario() {
    }
  
  public void borrarPerfilOrganizacion(Organizacion org){
      /*
      bbdd.eliminarONG(org.getUserID);
       logout();
      */
  }
    public String logout()
    {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }

}