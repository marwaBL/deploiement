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
public class ObtenirPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdCh")
    private int idCh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_D")
    private int idD;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodeEtab")
    private int codeEtab;

    public ObtenirPK() {
    }

    public ObtenirPK(int idCh, int idD, int codeEtab) {
        this.idCh = idCh;
        this.idD = idD;
        this.codeEtab = codeEtab;
    }

    public int getIdCh() {
        return idCh;
    }

    public void setIdCh(int idCh) {
        this.idCh = idCh;
    }

    public int getIdD() {
        return idD;
    }

    public void setIdD(int idD) {
        this.idD = idD;
    }

    public int getCodeEtab() {
        return codeEtab;
    }

    public void setCodeEtab(int codeEtab) {
        this.codeEtab = codeEtab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCh;
        hash += (int) idD;
        hash += (int) codeEtab;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObtenirPK)) {
            return false;
        }
        ObtenirPK other = (ObtenirPK) object;
        if (this.idCh != other.idCh) {
            return false;
        }
        if (this.idD != other.idD) {
            return false;
        }
        if (this.codeEtab != other.codeEtab) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ObtenirPK[ idCh=" + idCh + ", idD=" + idD + ", codeEtab=" + codeEtab + " ]";
    }
    
}
