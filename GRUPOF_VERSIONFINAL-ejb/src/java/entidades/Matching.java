/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */
@Entity
public class Matching implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String InfoTitulacion;
    private String InfoIdiomas;
    private String InfoPreferencias;
    private String InfoCapacidades;
    private String TipoActividad;
    private String AmbitoActividad;
    @ManyToMany
    private List<Actividad> Actividades;
    @ManyToOne
    private Usuario usuarioFiltro;

    public Matching() {
    }

    public Usuario getUsuarioFiltro() {
        return usuarioFiltro;
    }

    public void setUsuarioFiltro(Usuario usuarioFiltro) {
        this.usuarioFiltro = usuarioFiltro;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfoTitulacion() {
        return InfoTitulacion;
    }

    public void setInfoTitulacion(String InfoTitulacion) {
        this.InfoTitulacion = InfoTitulacion;
    }

    public String getInfoIdiomas() {
        return InfoIdiomas;
    }

    public void setInfoIdiomas(String InfoIdiomas) {
        this.InfoIdiomas = InfoIdiomas;
    }

    public String getInfoPreferencias() {
        return InfoPreferencias;
    }

    public void setInfoPreferencias(String InfoPreferencias) {
        this.InfoPreferencias = InfoPreferencias;
    }

    public String getInfoCapacidades() {
        return InfoCapacidades;
    }

    public void setInfoCapacidades(String InfoCapacidades) {
        this.InfoCapacidades = InfoCapacidades;
    }

    public String getTipoActividad() {
        return TipoActividad;
    }

    public void setTipoActividad(String TipoActividad) {
        this.TipoActividad = TipoActividad;
    }

    public String getAmbitoActividad() {
        return AmbitoActividad;
    }

    public void setAmbitoActividad(String AmbitoActividad) {
        this.AmbitoActividad = AmbitoActividad;
    }

    public List<Actividad> getActividades() {
        return Actividades;
    }

    public void setActividades(List<Actividad> Actividades) {
        this.Actividades = Actividades;
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
        if (!(object instanceof Matching)) {
            return false;
        }
        Matching other = (Matching) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupof.Matching[ id=" + id + " ]";
    }
    
}
