/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */
@Entity
public class ValoracionPrivada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer Puntuacion;
    private String ComentariosONG;
    private Usuario u;
 @ManyToOne
 private Usuario usuariovalorado;
 
 @ManyToOne
 private Organizacion valoracionONG;
 
    public ValoracionPrivada(){
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }

    public Usuario getUsuariovalorado() {
        return usuariovalorado;
    }

    public void setUsuariovalorado(Usuario usuariovalorado) {
        this.usuariovalorado = usuariovalorado;
    }

    public Organizacion getValoracionONG() {
        return valoracionONG;
    }

    public void setValoracionONG(Organizacion valoracionONG) {
        this.valoracionONG = valoracionONG;
    }
    
    public ValoracionPrivada(Long id, Integer Puntuacion, String ComentariosONG) {
        this.id = id;
        this.Puntuacion = Puntuacion;
        this.ComentariosONG = ComentariosONG;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentariosONG() {
        return ComentariosONG;
    }

    public void setComentariosONG(String ComentariosONG) {
        this.ComentariosONG = ComentariosONG;
    }

    public Integer getPuntuacion() {
        return Puntuacion;
    }

    public void setPuntuacion(Integer Puntuacion) {
        this.Puntuacion = Puntuacion;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValoracionPrivada)) {
            return false;
        }
        ValoracionPrivada other = (ValoracionPrivada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupof.ValoracionPrivada[ id=" + id + " ]";
    }
    
}
