/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */
@Entity
@NamedQueries({
    @NamedQuery(name="findAllMensajes",query="select m from Mensaje m where m.receptor=:email"),
    //@NamedQuery(name="modificarNoticia",query="update noticia set titulo=:Titulo,descripcion=:Descripcion,Fecha=:fecha where codnoticia=:id"),
   
   
})
public class Mensaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IDMensaje;
    private String Texto;
    private String Asunto;
    private String emisorA;
    private String receptor;
  
    
    @OneToMany(mappedBy="receptor")
    private List<Usuario> Usuarios;
    
    @ManyToOne
    private Usuario emisor;

    public String getEmisorA() {
        return emisorA;
    }

    public void setEmisorA(String emisorA) {
        this.emisorA = emisorA;
    }

    public Usuario getEmisor() {
        return emisor;
    }

    public void setEmisor(Usuario emisor) {
        this.emisor = emisor;
    }

  
    

    public Long getIDMensaje() {
        return IDMensaje;
    }

    public void setIDMensaje(Long IDMensaje) {
        this.IDMensaje = IDMensaje;
    }
  

    public List<Usuario> getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(List<Usuario> Usuarios) {
        this.Usuarios = Usuarios;
    }
    
    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Texto) {
        this.Texto = Texto;
    }

    public String getAsunto() {
        return Asunto;
    }

    public void setAsunto(String Asunto) {
        this.Asunto = Asunto;
    }

  
    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }
    
    public Mensaje(String r,String a,String txt){
         setReceptor(r);
    setAsunto(a);
    setTexto(txt);
    }
public Mensaje(Long id,String e,String r,String a,String txt){
    setIDMensaje(id);
    setEmisorA(e);
    setReceptor(r);
    setAsunto(a);
    setTexto(txt);
}
public Mensaje(){
    
}
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (IDMensaje != null ? IDMensaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensaje)) {
            return false;
        }
        Mensaje other = (Mensaje) object;
        if ((this.IDMensaje == null && other.IDMensaje != null) || (this.IDMensaje != null && !this.IDMensaje.equals(other.IDMensaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupof.Mensaje[ id=" + IDMensaje + " ]";
    }
    
}
