/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBeans;


import ejb.BaseDeDatosLocal;
import entidades.*;
import static entidades.Usuario.Rol.ORGANIZACION;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */

@Named(value = "controlAutorizacion")
@SessionScoped
public class controlAutorizacion implements Serializable {

    @Inject 
    private BaseDeDatosLocal bbdd;
    
    private Usuario usuario;
      
    private Organizacion ong;

    public Organizacion getOng() {
        return ong;
    }

    public void setOng(Organizacion ong) {
        this.ong = ong;
    }

    public String modificarUser(){
        if(usuario.getRol().equals(ORGANIZACION)){
            ong.setEmail(usuario.getEmail());
            ong.setNombreONG(usuario.getNombreONG());
            ong.setPassword(usuario.getPassword());
            ong.setSede(usuario.getSede());
            ong.setProposito(usuario.getProposito());
            ong.setUserID(usuario.getUserID()-1);
            bbdd.modificarONG(ong);
       
        }
       
        bbdd.modificarUsuario(usuario);   
        return "miPerfilUsuario.xhtml";
    }
  
    public String borrarPerfilUsuario(Long cod){
      if(usuario.getRol().equals(ORGANIZACION)){
          bbdd.eliminarONG(cod-1);
      }
      bbdd.eliminarUsuario(cod);
      return "login.xhtml";
  }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Long getID(){
        return usuario.getUserID();
    }

    public Usuario getUsuario() {
        return usuario;
    }
   
   
    public String CRUDActividades(){
        return "CRUDActividades.xhtml";
    }
    
    public String ParticipacionActividad(){
        return "participacionActividad.xhtml";
    }
    
    public String Noticias(){
        return "noticias.xhtml";
    }
    
    public String ApS(){
        return "ApS.xhtml";
    }
    
    public String perfilUsuario(){
        return "miPerfilUsuario.xhtml";
    }

    public String modificarParticipacion(){
        return "CRUDActividades.xhtml";
    }
    
    public String EvaluarUser(){
        return "evaluaciones.xhtml";
    }
    public String Propuesta(){
        return "crearPropuestaAct.xhtml";
    }
    public String porRealizar(){
        return "inicio.xhtml";
    }
    
    public String valoracionesPrivadas(){
        return "valoracionesPrivadas.xhtml";
    }
     
    public String home() {
        // Devuelve la página Home dependiendo del rol del usuario
        if(getUsuario()==null){
            return "login.xhtml";
        }
        
       
        if(getUsuario().getRol().equals(getUsuario().getRol().ALUMNO)){
            return "inicio.xhtml";
        }
        
        if(getUsuario().getRol().equals(getUsuario().getRol().PDI)){
            return "inicio.xhtml";
        }
        
        if(getUsuario().getRol().equals(getUsuario().getRol().PAS)){
            return "inicio.xhtml";
        }
        
        if(getUsuario().getRol().equals(getUsuario().getRol().ORGANIZACION)){
            return "inicio.xhtml";
        }
        return null;
    }
    
    public String logout()
    {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public controlAutorizacion() {
        ong = new Organizacion();
    }
}
