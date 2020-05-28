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
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *Hay que modificar el actualizar
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */
@Named
@SessionScoped

public class buscador implements Serializable{
    @Inject 
    private BaseDeDatosLocal bbdd;
    //private Actividad a; 
   //private Long codigo;
   private Actividad busqueda;
   private String cadena;
   private List<Actividad> actividades;
  

   public buscador(){
       busqueda = new Actividad();
     //  a = new Actividad();
   }
    public Actividad getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(Actividad busqueda) {
        this.busqueda = busqueda;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }
  
       public String buscar() {
           cadena="";
           int contTipo=0;
            int contLocal=0;
            int contCapaci=0;
            if(busqueda.getTipoActividad().length()>0){
                contTipo++;
            }if(busqueda.getLocalizacion().length()>0){
                contLocal++;
            } if(busqueda.getCapacidadesNecesarias().length()>0){
                contCapaci++;
            }

            if(contTipo==1){

             cadena += "  a.TipoActividad = '".concat(busqueda.getTipoActividad())+"'";
            }
             if(contLocal==1){
                 if(contTipo==1){
                     cadena+=" and a.Localizacion =  '".concat(busqueda.getLocalizacion())+"'";
                 }
                 else{
                      cadena+=" a.Localizacion  =  '".concat(busqueda.getLocalizacion())+"'";

                 }

            }
              if(contCapaci==1){
                  if(contTipo==1 || contLocal==1){
                      cadena+=" and  a.CapacidadesNecesarias = '".concat(busqueda.getCapacidadesNecesarias())+"'";
                  }else{
                        cadena+=" a.CapacidadesNecesarias = '".concat(busqueda.getCapacidadesNecesarias())+"'";
                  }

            }

           
            actividades = bbdd.BuscarActividadBusqueda(cadena);
           return "ActividadesBuscadas.xhtml";
       }
   
      
}
