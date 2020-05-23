/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBeans;





import ejb.BaseDeDatosLocal;
import entidades.*;
import static entidades.Usuario.Rol.ORGANIZACION;
import excepciones.ApSException;
import excepciones.ContraseniaInvalidaException;
import excepciones.CuentaInexistenteException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *  SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 * usuario Gestor credenciales:
 * email: bd@mail.com
 * pass:bd
 */
@Named(value = "login")
@RequestScoped
public class Login {
   @Inject 
    private BaseDeDatosLocal bbdd;
   
    @Inject
    private controlAutorizacion ctrl;
    
    private Usuario usuario;
    private Organizacion organizacion; //Yo

     /**
     * Creates a new instance of Login
     */
    public Login() {
        usuario = new Usuario();
        organizacion = new Organizacion();
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Organizacion getOrganizacion() {//YO
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {//YO
        this.organizacion = organizacion;
    }
  
    public String registro(){
        return "registro.xhtml";
    }
    
    public String registroONG(){
        return "registroONG.xhtml";
    }
    
    public String createUser(){
      
        if(usuario.getRol().equals(ORGANIZACION)){
            organizacion.setEmail(usuario.getEmail());
            organizacion.setNombreONG(usuario.getNombreONG());
            organizacion.setPassword(usuario.getPassword());
            organizacion.setSede(usuario.getSede());
            organizacion.setRol(usuario.getRol());
            organizacion.setProposito(usuario.getProposito());
            bbdd.aniadirOrganizacion(organizacion);
        }
          bbdd.aniadirUsuario(usuario);
        return "login.xhtml";
    }
    
    
    public String createOrganizacion(){//yo
       
        bbdd.aniadirOrganizacion(organizacion);//Yo
        return "login.xhtml";
    }

    public String autenticar() {
        try {
         
            bbdd.compruebaLogin(usuario);
            ctrl.setUsuario(bbdd.refrescarUsuario(usuario));
           
            
            return "inicio.xhtml";

        } catch (CuentaInexistenteException e) {
            FacesMessage fm = new FacesMessage("La cuenta no existe");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        } catch (ContraseniaInvalidaException e) {
            FacesMessage fm = new FacesMessage("La contraseña no es correcta");
            FacesContext.getCurrentInstance().addMessage("login:pass", fm);
        } catch (ApSException e) {
            FacesMessage fm = new FacesMessage("Error: " + e);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        return null;
    }
  
}
