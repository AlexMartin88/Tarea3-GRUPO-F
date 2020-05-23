/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.*;
import javax.persistence.*;

/**
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */

@Entity
public class PAS extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long UserID;

    public PAS(String nombre, String apellidos) {
        super(nombre, apellidos);
    }

    public Long getCodPAS() {
        return UserID;
    }

    public void setCodPAS(Long UserID) {
        this.UserID = UserID;
    }

    public PAS() {
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
        if (!(object instanceof PAS)) {
            return false;
        }
        PAS other = (PAS) object;
        if ((this.UserID == null && other.UserID != null) || (this.UserID != null && !this.UserID.equals(other.UserID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupof.PAS[ id=" + UserID + " ]";
    } 
}
