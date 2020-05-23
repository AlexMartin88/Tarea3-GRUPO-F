/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */


@Entity
@NamedQueries({
    @NamedQuery(name="findAllNoticias",query="select n from Noticia n"),
     //@NamedQuery(name="modificarNoticia",query="update noticia n  set n.titulo=:Titulo,n.descripcion=:Descripcion,n.Fecha=:fecha where n.codnoticia=:id"),
   
   
})

public class Noticia implements Serializable {

    private static final long serialVersionUID = 1L;
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CodNoticia;
    private String Titulo;
    private String Descripcion;
    private String fecha;
    @ManyToOne (cascade = {CascadeType.PERSIST})
    private Organizacion ong;
    @ManyToOne (cascade = {CascadeType.PERSIST})
    private Organizacion creadorNoticia;
  
   
    public Noticia(){
        
    }
    public Noticia(Long CodNoticia, String Titulo, String Descripcion, String fecha){
        this.CodNoticia= CodNoticia;
        this.Titulo = Titulo;
        this.Descripcion = Descripcion;
        this.fecha = fecha;
    }

    public Organizacion getCreadorNoticia() {
        return creadorNoticia;
    }

    public void setCreadorNoticia(Organizacion creadorNoticia) {
        this.creadorNoticia = creadorNoticia;
    }

    public Organizacion getOng() {
        return ong;
    }

    public void setOng(Organizacion ong) {
        this.ong = ong;
    }
    
public void crearNoticia(Noticia n, int tam){
    
    n.setCodNoticia(new Long(tam));
    n.setTitulo(n.Titulo);
    n.setDescripcion(n.Descripcion);
    n.setFecha(n.fecha);
    
}
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public Long getCodNoticia() {
        return CodNoticia;
    }

    public void setCodNoticia(Long CodNoticia) {
        this.CodNoticia = CodNoticia;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (CodNoticia != null ? CodNoticia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Noticia)) {
            return false;
        }
        Noticia other = (Noticia) object;
        if ((this.CodNoticia == null && other.CodNoticia != null) || (this.CodNoticia != null && !this.CodNoticia.equals(other.CodNoticia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupof.Noticia[ id=" + CodNoticia + " ]";
    }
    
}
