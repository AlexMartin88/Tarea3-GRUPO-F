/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBeans;

import ejb.BaseDeDatosLocal;
import entidades.*;
import java.io.Serializable;
import java.util.ArrayList;
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
    
    //private List<ValoracionPublica> valoraciones ;
    private ValoracionPublica v;
    private Long codActividad;
  private Actividad actividadValoracion;
    private Actividad a;
    //private Long ID = new Long(1);
    
    public valoracionController() {
        //valoraciones = new ArrayList<>();
        //valoraciones.add(new ValoracionPublica(new Long (1), 7, "Buena actividad"));
        v = new ValoracionPublica();
        //actividadValoracion = new Actividad();
        a = new Actividad();
    }

   public Actividad getActividadValoracion() {
        return actividadValoracion;
    }

    public void setActividadValoracion(Actividad actividadValoracion) {
        this.actividadValoracion = actividadValoracion;
    }

    public Actividad getA() {
        return a;
    }

    public void setA(Actividad a) {
        this.a = a;
    }
    
    public String crear(Usuario u){
        //v.setAct(actividadValoracion);
        //Actividad a = bbdd.buscarActividad(v.getAct().getCodActividad());
        //v.setAct(a);
        v.setCreador(u);
        bbdd.aniadirValPub(v);
        return "CRUDActividades.xhtml";
    }
    
    public ValoracionPublica getV() {
        return v;
    }

    public void setV(ValoracionPublica v) {
        this.v = v;
    }

    public String Valorar(){
        //actividadValoracion = a;
       // codActividad = cod;
        //actividadValoracion = bbdd.buscarActividad(codActividad);
        return "valoracionesPublicas.xhtml";
    }
    /*public void setValoraciones(List<ValoracionPublica> valoraciones) {
        this.valoraciones = valoraciones;
    }

    public List<ValoracionPublica> getValoraciones() {
        return valoraciones;
    }*/
}
