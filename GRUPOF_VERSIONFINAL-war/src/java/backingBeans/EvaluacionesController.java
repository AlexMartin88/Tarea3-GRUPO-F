/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBeans;

/**
 *
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ejb.BaseDeDatosLocal;
import entidades.ParticipacionEnActividad;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
/**
 *
 * @author juanky
 */

@Named(value ="Evaluaciones")
@SessionScoped
public class EvaluacionesController implements Serializable {
    
    @Inject 
    private BaseDeDatosLocal bbdd;
      private List<ParticipacionEnActividad> participantes;
        private ParticipacionEnActividad participacion;
        
    
    
    public EvaluacionesController(){
      // participantes = new ArrayList<>();
         participacion = new ParticipacionEnActividad();
    }
    
    
   public String EvaluarUser(Long cod){
        participantes = new ArrayList<>(); 
        for (ParticipacionEnActividad p : bbdd.buscarActividad(cod).getParticipantes()) {
           if(p.getEstado().equalsIgnoreCase("ACEPTADA")){
               
               participantes.add(p);
           }
       }
     
        return "evaluaciones.xhtml";
    }

    public List<ParticipacionEnActividad> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<ParticipacionEnActividad> participantes) {
        this.participantes = participantes;
    }
   
    public String verEvaluarUsuario(Long id){
     
       participacion = bbdd.buscarParticipante(id);
       
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
    public String   Suspenso(){
        
        participacion.setNota(4);
         bbdd.modificarParticipacion(participacion);
      EvaluarUser(participacion.getParticipantes().getCodActividad());
        return "evaluaciones.xhtml";
        
    }
    
    public String Aprobado(){
      
        participacion.setNota(5);
        bbdd.modificarParticipacion(participacion);
      EvaluarUser(participacion.getParticipantes().getCodActividad());
        return "evaluaciones.xhtml";
        
    }
     public String   Notable(){
       
        participacion.setNota(7);
         bbdd.modificarParticipacion(participacion);
       EvaluarUser(participacion.getParticipantes().getCodActividad());
        return "evaluaciones.xhtml";
        
    }
       public String   Sobresaliente(){
      
        participacion.setNota(9);
         bbdd.modificarParticipacion(participacion);
       EvaluarUser(participacion.getParticipantes().getCodActividad());
        return "evaluaciones.xhtml";
        
    }
}