/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBeans;

import ejb.BaseDeDatosLocal;
import entidades.*;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */

@Named ( value = "ValoracionesPublicas")
@RequestScoped
public class valoracionController implements Serializable {
    
    @Inject 
    private BaseDeDatosLocal bbdd;
    
   
    private ValoracionPublica v;
    private Actividad a;
   private Long codActividad;
    
    
    public valoracionController() {
        //valoraciones = new ArrayList<>();
        //valoraciones.add(new ValoracionPublica(new Long (1), 7, "Buena actividad"));
        v = new ValoracionPublica();
        //actividadValoracion = new Actividad();
        a = new Actividad();
    }

    

    public Actividad getA() {
        return a;
    }

    public void setA(Actividad a) {
        this.a = a;
    }
    
    public String crear(Usuario u){
        
        v.setCreador(u);
        bbdd.modificarValPub(v);
        return "CRUDActividades.xhtml";
    }
    
    public ValoracionPublica getV() {
        return v;
    }

    public void setV(ValoracionPublica v) {
        this.v = v;
    }

    public String Valorar(Long cod){
      
        codActividad = cod;
        v.setCodActividad(cod);
        bbdd.aniadirValPub(v);
       
       
        return "valoracionesPublicas.xhtml";
    }
    public String ValoracionesOtrosUsuarios(Long cod){
           codActividad = cod;
        a = bbdd.buscarActividad(codActividad);
        return "ValoracionesOtrosUsuarios.xhtml";
    }
    public List<ValoracionPublica> valoraciones(){
        return bbdd.todasValPublicas(codActividad);
    }
   
}
