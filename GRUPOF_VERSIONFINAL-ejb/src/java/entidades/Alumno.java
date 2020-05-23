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
public class Alumno extends Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Long UserID;//codAlumno
    @ManyToMany //Relacion Alumno-Asignatura
    @JoinTable(name="jnd_alum_asig",joinColumns=@JoinColumn(name="alumno_fk"),inverseJoinColumns=@JoinColumn(name="asignatura_fk"))
    private List<Asignatura> Asignaturas;

    public Alumno(String nombre, String apellidos) {
        super(nombre, apellidos);
    }
    public Alumno(){
        
    }
    
    public Long getCodUMA() {
        return UserID;
    }

    public void setCodUMA(Long UserID) {
        this.UserID = UserID;
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
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.UserID == null && other.UserID != null) || (this.UserID != null && !this.UserID.equals(other.UserID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupof.Alumno[ id=" + UserID + " ]";
    }   
}
