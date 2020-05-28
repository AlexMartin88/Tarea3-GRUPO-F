/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBeans;

import entidades.*;
import ejb.BaseDeDatosLocal;
import java.io.Serializable;
import java.util.ArrayList;
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
   private List<ParticipacionEnActividad> participantes;
   private List<ParticipacionEnActividad> participantesONG;
   private Usuario u;
   private Actividad aBusqueda;
   //private Long c = o.getUserID();

    public Actividad getaBusqueda() {
        return aBusqueda;
    }

    public void setaBusqueda(Actividad aBusqueda) {
        this.aBusqueda = aBusqueda;
    }
   
 
   

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
       participantes = new ArrayList<>();
       participantesONG = new ArrayList<>();
       aBusqueda = new Actividad();
       
       
    }

    public List<ParticipacionEnActividad> getParticipantesONG() {
        return participantesONG;
    }

    public void setParticipantesONG(List<ParticipacionEnActividad> participantesONG) {
        this.participantesONG = participantesONG;
    }
    
    public String participantesONG(Long cod){
        //codigo = cod;
        participantes = bbdd.buscarActividad(cod).getParticipantes();
        for (ParticipacionEnActividad p : participantes) {
            if(p.getEstado().equalsIgnoreCase("ACEPTADA")){
            participantesONG.add(p);
        }
            
        }
        return "participantesActividadONG.xhtml";
    }
   
    public List<ParticipacionEnActividad> getParticipantes(){
       // bbdd.buscarActividad(codigo).getParticipantes();
        return participantes;
    }
   
public ParticipacionEnActividad getParticipanteAct(){
    u = bbdd.buscarParticipante(idParticipacion).getParticipaciones();
    return bbdd.buscarParticipante(idParticipacion);
}
    public ParticipacionEnActividad getParticipacion() {
        return participacion;
    }

    public void setParticipacion(ParticipacionEnActividad participacion) {
        this.participacion = participacion;
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
  
    public String createPropuesta(Long id){
        codigo = id;
        o=bbdd.buscarONG(id-1);
        a.setCreadorONG(o);
        a.setCodONG(id-1);
        bbdd.aniadirActividad(a);        
       
        return "ActividadesONG.xhtml";
    }
    public List<Actividad> buscarActividad(){
     int contTipo=0;
      int contLocal=0;
      int contCapaci=0;
      String cadena= "";
      if(aBusqueda.getTipoActividad().length()>0){
          contTipo++;
      }if(aBusqueda.getLocalizacion().length()>0){
          contLocal++;
      } if(aBusqueda.getCapacidadesNecesarias().length()>0){
          contCapaci++;
      }
      
      if(contTipo==1){
          
       cadena += "  a.TipoActividad = '".concat(aBusqueda.getTipoActividad())+"'";
      }
       if(contLocal==1){
           if(contTipo==1){
               cadena+=" and a.Localizacion =  '".concat(aBusqueda.getLocalizacion())+"'";
           }
           else{
                cadena+=" a.Localizacion  =  '".concat(aBusqueda.getLocalizacion())+"'";
               
           }
            
      }
        if(contCapaci==1){
            if(contTipo==1 || contLocal==1){
                cadena+=" and  a.CapacidadesNecesarias = '".concat(aBusqueda.getCapacidadesNecesarias())+"'";
            }else{
                  cadena+=" a.CapacidadesNecesarias = '".concat(aBusqueda.getCapacidadesNecesarias())+"'";
            }
          
      }
      return bbdd.BuscarActividadBusqueda(cadena);
      
     
    }
    
  
    
   public String peticionInscripcion(Usuario u){
       participacion = new ParticipacionEnActividad("1/05/2009","PENDIENTE",a,u);
       bbdd.aniadirParticipante(participacion);
       a.anadirParticipacionLista(participacion);
       bbdd.modificarActividad(a);
       u.anadirParticipacionLista(participacion);
       bbdd.modificarUsuario(u);
       return "CRUDActividades.xhtml";  
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
