/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author USER1
 */
@Embeddable
public class EcrirePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdPub")
    private int idPub;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdAut")
    private int idAut;

    public EcrirePK() {
    }

    public EcrirePK(int idPub, int idAut) {
        this.idPub = idPub;
        this.idAut = idAut;
    }

    public int getIdPub() {
        return idPub;
    }

    public void setIdPub(int idPub) {
        this.idPub = idPub;
    }

    public int getIdAut() {
        return idAut;
    }

    public void setIdAut(int idAut) {
        this.idAut = idAut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPub;
        hash += (int) idAut;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EcrirePK)) {
            return false;
        }
        EcrirePK other = (EcrirePK) object;
        if (this.idPub != other.idPub) {
            return false;
        }
        if (this.idAut != other.idAut) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EcrirePK[ idPub=" + idPub + ", idAut=" + idAut + " ]";
    }
    
}
