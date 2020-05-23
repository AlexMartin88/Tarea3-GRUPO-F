/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */
@Entity
public class Asignatura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CodAsignatura;
    private String NombreAsignatura;
    private Integer CursoImpartida;
    @ManyToMany(mappedBy ="Asignaturas")
    private List<Alumno> Alumnos;
    @ManyToMany
    @JoinTable(name="asig_pdi",joinColumns=@JoinColumn(name="pdi_fk"),inverseJoinColumns=@JoinColumn(name="asignatura_fk"))
    private List<PDI> PDI;
    @ManyToOne
    private Actividad a;

    
    public Actividad getA() {
        return a;
    }

    public void setA(Actividad a) {
        this.a = a;
    }
    
    public Long getCodAsignatura() {
        return CodAsignatura;
    }

    public void setCodAsignatura(Long CodAsignatura) {
        this.CodAsignatura = CodAsignatura;
    }

    public String getNombreAsignatura() {
        return NombreAsignatura;
    }

    public void setNombreAsignatura(String NombreAsignatura) {
        this.NombreAsignatura = NombreAsignatura;
    }

    public Integer getCursoImpartida() {
        return CursoImpartida;
    }

    public void setCursoImpartida(Integer CursoImpartida) {
        this.CursoImpartida = CursoImpartida;
    }

    public List<Alumno> getAlumnos() {
        return Alumnos;
    }

    public void setAlumnos(List<Alumno> Alumnos) {
        this.Alumnos = Alumnos;
    }

    public List<PDI> getPDI() {
        return PDI;
    }

    public void setPDI(List<PDI> PDI) {
        this.PDI = PDI;
    }

    public Asignatura() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (CodAsignatura != null ? CodAsignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.CodAsignatura == null && other.CodAsignatura != null) || (this.CodAsignatura != null && !this.CodAsignatura.equals(other.CodAsignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupof.Asignatura[ id=" + CodAsignatura + " ]";
    }
    
}
