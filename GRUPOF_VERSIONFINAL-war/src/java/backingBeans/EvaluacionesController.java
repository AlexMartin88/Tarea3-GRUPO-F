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
import entidades.Actividad;
import entidades.ParticipacionEnActividad;
import entidades.Usuario;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
/**
 *
 * @author juanky
 */

@Named(value ="Evaluaciones")
@RequestScoped
public class EvaluacionesController implements Serializable {
    
    @Inject 
    private BaseDeDatosLocal bbdd;
      private List<ParticipacionEnActividad> participantes;
        private ParticipacionEnActividad participacion;
        
    
    
    public EvaluacionesController(){
        participantes = new ArrayList<>();
         participacion = new ParticipacionEnActividad();
    }
    
    
   public String EvaluarUser(Long cod){
        //codigo = cod;
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
}