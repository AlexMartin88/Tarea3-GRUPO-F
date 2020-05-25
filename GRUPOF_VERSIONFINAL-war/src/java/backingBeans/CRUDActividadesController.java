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
   private Long idParticipacion;
   private Organizacion o;
   //private Long c = o.getUserID();
   
 
   

    public Actividad getA() {
        return a;
    }

    public void setA(Actividad a) {
        this.a = a;
    }

    public CRUDActividadesController(){
        a = new Actividad(); 
       // ong = new Organizacion();
       participacion = new ParticipacionEnActividad();
       
       
    }
  
    public String EvaluarUser(Long cod){
        codigo = cod;
      
        return "evaluaciones.xhtml";
    }
    public List<ParticipacionEnActividad> getParticipantes(){
        return bbdd.buscarActividad(codigo).getParticipantes();
    }
    public String verEvaluarUsuario(Long id){
       idParticipacion = id;
        participacion = bbdd.buscarParticipante(idParticipacion);
        return "evaluacion.xhtml";
    }

    public ParticipacionEnActividad getParticipacion() {
        return participacion;
    }

    public void setParticipacion(ParticipacionEnActividad participacion) {
        this.participacion = participacion;
    }
  
    
    public String modificaEvaluacion(){
        bbdd.modificarParticipacion(participacion);
        return "CRUDActividades.xhtml";
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
        codigo = id;
        o=bbdd.buscarONG(id-1);
        a.setCreadorONG(o);
        a.setCodONG(id-1);
        bbdd.aniadirActividad(a);        
       
        return "ActividadesONG.xhtml";
    }
    public List<Actividad> buscarActividad(){
        if(bbdd.todasActividades().contains(a)==true){
             return bbdd.todasActividades();
        }
        return null;
       
    }
    
  /*  public String modificarActividad(){
        return "modificarActividad.xhtml";
    }*/
 
   public String peticionInscripcion(Usuario u,Actividad a){
       participacion = new ParticipacionEnActividad("1/05/2009","PENDIENTE",a,u);
       bbdd.aniadirParticipante(participacion);
       a.anadirParticipacionLista(participacion);
       bbdd.modificarActividad(a);
       u.anadirParticipacionLista(participacion);
       bbdd.modificarUsuario(u);
       return "verActividad.xhtml";  
   }
    public String verActividad(Long id){
        codigo = id;
        a = bbdd.buscarActividad(codigo);
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
        
        a = bbdd.buscarActividad(cod);
       
        return "gestionarSolicitud.xhtml";
    }
    public String getNombreOrganizacion(Long cod){
        return bbdd.buscarONG(cod).getNombreONG();
    }
    public String modificarSolicitud(){
        
       bbdd.modificarActividad(a);
        
        return "participacionActividad.xhtml";
    }
    public List<Actividad> actRechazadas(Long cod){
      
        return bbdd.actividadesRechazadas(cod-1);
    }

    public String modificarActRechazadas(Long cod){
       
        a = bbdd.buscarActividad(cod);
        return "modificarSolicitud.xhtml";
    }
    public String modificarActRechazada(){
      
        bbdd.modificarActividad(a);
        return "solicitudesDenegadas.xhtml";
    }
}
