/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBeans;

import ejb.BaseDeDatosLocal;
import entidades.Actividad;
import entidades.ParticipacionEnActividad;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
/**
 *
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 * Esta clase muestra las solicitudes de los alumnos, para formar parte de las 
 * actividades
 */
@Named(value ="ListaSolicitudes")   
@SessionScoped

public class CTRparticipacionActividad implements Serializable{
    
    @Inject 
    private BaseDeDatosLocal bbdd;
      private ParticipacionEnActividad participacion;
    private Actividad a; 
    private List<ParticipacionEnActividad> participantes;
    
    
   
    public CTRparticipacionActividad(){
        participacion = new ParticipacionEnActividad();
        a = new Actividad();
        participantes = new ArrayList<>();
    }
    
  public String inscripciones(Long id){
         a = bbdd.buscarActividad(id);
         
         participantes = bbdd.buscarPorEstado("PENDIENTE", a);
        
        return "inscripciones.xhtml"; 
    }

   public String gestionarInscripcion(Long cod){
       // idParticipacion = cod;
        participacion = bbdd.buscarParticipante(cod);
       
        return "InscripcionGestion.xhtml";
    }
/*
   public ParticipacionEnActividad gestionarInscripcion(Long cod){
        participacion = bbdd.buscarParticipante(cod);
       
        return participacion;
    }*/
    public ParticipacionEnActividad getParticipacion() {
        return participacion;
    }

    public void setParticipacion(ParticipacionEnActividad participacion) {
        this.participacion = participacion;
    }
  public String modificarInscripcion(){
      
     //participacion.setEstado("ACEPTADA");
     //participacion.setEstado("DENEGADA");
        
       bbdd.modificarParticipacion(participacion);
        
        return "CRUDActividades.xhtml";
    }
    public Actividad getA() {
        return a;
    }

    public void setA(Actividad a) {
        this.a = a;
    }

    public List<ParticipacionEnActividad> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<ParticipacionEnActividad> participantes) {
        this.participantes = participantes;
    }
       
    
}