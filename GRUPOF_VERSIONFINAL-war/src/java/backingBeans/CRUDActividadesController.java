/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBeans;

import entidades.*;
import ejb.BaseDeDatosLocal;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *Hay que modificar el actualizar
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */
@Named(value ="ListaActividades")
@RequestScoped

public class CRUDActividadesController implements Serializable{
    @Inject 
    private BaseDeDatosLocal bbdd;
    private ParticipacionEnActividad participacion;
    private Actividad a; 
    private Long codigo;
   // private Organizacion ong;
 
   

    public Actividad getA() {
        return a;
    }

    public void setA(Actividad a) {
        this.a = a;
    }

    public CRUDActividadesController(){
        a = new Actividad(); 
       // ong = new Organizacion();
       
       
    }
  
    public List<Actividad> Actividades(){
        return bbdd.todasActividades();
    }
    
    public List<Actividad> actividadesong(Long id){
        return bbdd.todasActividadesONG(id-1);
    }

    public String borrarActividad(Long cod){
        bbdd.eliminarActividad(cod);
        return "CRUDActividades.xhtml";
    }
    public String inscripciones(){
        return "inscripciones.xhtml"; 
    }

    public String createPropuesta(Long id){
        Organizacion o=bbdd.buscarONG(id-1);
        a.setCreadorONG(o);
        bbdd.aniadirActividad(a);        
       
        return "ActividadesONG.xhtml";
    }
    
  /*  public String modificarActividad(){
        return "modificarActividad.xhtml";
    }*/
 
   public String peticionInscripcion(Actividad act,Usuario u){
       participacion = new ParticipacionEnActividad("1/05/2009","PENDIENTE",act,u);
       bbdd.aniadirParticipante(participacion);
       act.anadirParticipacionLista(participacion);
       bbdd.modificarActividad(act);
       u.anadirParticipacionLista(participacion);
       bbdd.modificarUsuario(u);
       return "verActividad.xhtml";  
   }
    public String verActividad(){
        return "verActividad.xhtml";
     }
     
    public String crearActividad(){
       return "crearActividad.xhtml";
    }
    
    public String modifica(){
        bbdd.modificarActividad(a);
        return "verActividad.xhtml";
    }
    
    public String modificarActividad(Long cod){
        codigo = cod;
        a = bbdd.buscarActividad(codigo);
        return "modificarActividad.xhtml";
    }
    
    public String modificar(){
        bbdd.modificarActividad(a);
        return "CRUDActividades.xhtml";
    }
    
    public List<Actividad> gestionarSolicitudes(){
        return bbdd.todasGestionesSolicitudes();
    }
    
    public String gestionar(Long cod){
        codigo = cod;
        a = bbdd.buscarActividad(codigo);
       //ong = a.getCreadorONG();
    
   
        return "gestionarSolicitud.xhtml";
    }
    
    public String modificarSolicitud(){
       Organizacion o=bbdd.buscarONG(codigo);
       a.setCreadorONG(o);
        bbdd.modificarActividad(a);
        return "participacionActividad.xhtml";
    }
    public List<Actividad> actRechazadas(Long cod){
        //ong = bbdd.buscarONG(cod-1);
        return bbdd.actividadesRechazadas(cod-1);
    }

    public String modificarActRechazadas(Long cod){
        codigo = cod;
        a = bbdd.buscarActividad(codigo);
        return "modificarSolicitud.xhtml";
    }
    public String modificarActRechazada(){
      //  a.setCreadorONG(ong);
        bbdd.modificarActividad(a);
        return "solicitudesDenegadas.xhtml";
    }
}
