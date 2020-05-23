/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBeans;

import ejb.BaseDeDatosLocal;
import entidades.Mensaje;
import entidades.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */
@Named(value="ListaMensajes")
@RequestScoped
public class CRMensajesController implements Serializable{
    
    @Inject 
    private BaseDeDatosLocal bbdd;
    private Mensaje m1;
    
     @Inject
    private controlAutorizacion ctrl;
    
    public CRMensajesController(){
     m1 = new Mensaje();
   
    }

    
    public String verMensaje(){
       return "verMensaje.xhtml";
     }

   
  
    
    public List<Mensaje> Mensajes(Usuario u){
        return bbdd.todosMensajes(u);
    }
    
    public String borrarMensaje(Long id){
        bbdd.eliminarMensaje(id);
        return "mensajesRecibidos.xhtml";
    }
    

    public Mensaje getM1() {
        return m1;
    }

    public void setM1(Mensaje m1) {
        this.m1 = m1;
    }
    
    public String crearMensaje(){
        m1.setEmisorA(ctrl.getUsuario().getEmail());
        bbdd.aniadirMensaje(m1);
        return "mensajesRecibidos.xhtml";
    }
    
}
