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
import javax.validation.constraints.Size;

/**
 *
 * @author USER1
 */
@Embeddable
public class InscriptionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdCh")
    private int idCh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "Code")
    private String code;

    public InscriptionPK() {
    }

    public InscriptionPK(int idCh, String code) {
        this.idCh = idCh;
        this.code = code;
    }

    public int getIdCh() {
        return idCh;
    }

    public void setIdCh(int idCh) {
        this.idCh = idCh;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCh;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscriptionPK)) {
            return false;
        }
        InscriptionPK other = (InscriptionPK) object;
        if (this.idCh != other.idCh) {
            return false;
        }
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.InscriptionPK[ idCh=" + idCh + ", code=" + code + " ]";
    }
    
}
