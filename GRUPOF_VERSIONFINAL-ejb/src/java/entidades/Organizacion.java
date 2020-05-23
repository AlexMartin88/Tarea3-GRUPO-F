/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */


@Entity
public class Organizacion extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long UserID;//ID DEL USUARIO ASOCIADO
    private String Nombre;
    private String Sede;
    private String proposito;
    @OneToMany(mappedBy="creadorONG")
    private List<Actividad> Actividades;
    @OneToMany(mappedBy="valoracionONG")
    private List<ValoracionPrivada> valoraciones;
    @OneToMany (cascade = {CascadeType.PERSIST})
    private List<Noticia> noticias;

     @OneToMany(mappedBy="creadorNoticia",cascade = {CascadeType.PERSIST})
    private List<Noticia> noticiasCreadas;
     
     
    public Organizacion(){
        
    }
    
    public Organizacion(String nombre){
        this.Nombre = nombre;
    }
    
    public Organizacion(Long CodProyecto, String nombre, String sede, String proposito){
        setNombre(nombre);
        setSede(sede);
        setProposito(proposito);
    }
    
    
     
    public List<Noticia> getNoticias() {
        return noticias;
    }

    public List<Noticia> getNoticiasCreadas() {
        return noticiasCreadas;
    }

    public void setNoticiasCreadas(List<Noticia> noticiasCreadas) {
        this.noticiasCreadas = noticiasCreadas;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.Nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Organizacion other = (Organizacion) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Organizacion{" + "Nombre=" + Nombre + ", Sede=" + Sede + ", proposito=" + proposito + ", Actividades=" + Actividades + ", valoraciones=" + valoraciones + ", noticias=" + noticias + ", noticiasCreadas=" + noticiasCreadas + '}';
    }
    
    

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getSede() {
        return Sede;
    }

    public void setSede(String Sede) {
        this.Sede = Sede;
    }

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public List<Actividad> getActividades() {
        return Actividades;
    }

    public void setActividades(List<Actividad> Actividades) {
        this.Actividades = Actividades;
    }

    public List<ValoracionPrivada> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(List<ValoracionPrivada> valoraciones) {
        this.valoraciones = valoraciones;
    }
    
    public void añadiractividadlista(Actividad a){
        Actividades.add(a);
    }
    
    

   
}
