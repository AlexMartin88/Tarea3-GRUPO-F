/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.*;
import java.util.*;
import javax.persistence.*;

/**
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */
@Entity
public class PDI extends Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    private Long UserID;
    private String Departamento;
    private String Titulacion;
    private Long CodActividad;
    @ManyToMany(mappedBy ="PDI")
    private List<Asignatura> Asignaturas;
    @OneToMany(mappedBy="revisar")
    private List<Actividad> ActividadesRevisadas;

    public Long getUserID() {
        return UserID;
    }

    public void setUserID(Long UserID) {
        this.UserID = UserID;
    }

    public List<Actividad> getActividadesRevisadas() {
        return ActividadesRevisadas;
    }

    public void setActividadesRevisadas(List<Actividad> ActividadesRevisadas) {
        this.ActividadesRevisadas = ActividadesRevisadas;
    }

    public PDI() {
    }
   

    public Long getCodPDI() {
        return UserID;
    }

    public void setCodPDI(Long UserID) {
        this.UserID = UserID;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public String getTitulacion() {
        return Titulacion;
    }

    public void setTitulacion(String Titulacion) {
        this.Titulacion = Titulacion;
    }

    public Long getCodActividad() {
        return CodActividad;
    }

    public void setCodActividad(Long CodActividad) {
        this.CodActividad = CodActividad;
    }

    public List<Asignatura> getAsignaturas() {
        return Asignaturas;
    }

    public void setAsignaturas(List<Asignatura> Asignaturas) {
        this.Asignaturas = Asignaturas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (UserID != null ? UserID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PDI)) {
            return false;
        }
        PDI other = (PDI) object;
        if ((this.UserID == null && other.UserID != null) || (this.UserID != null && !this.UserID.equals(other.UserID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupof.PDI[ id=" + UserID + " ]";
    }
}
