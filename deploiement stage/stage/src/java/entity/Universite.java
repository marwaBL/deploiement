/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER1
 */
@Entity
@Table(name = "universite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Universite.findAll", query = "SELECT u FROM Universite u"),
    @NamedQuery(name = "Universite.findByCodeUniv", query = "SELECT u FROM Universite u WHERE u.codeUniv = :codeUniv"),
    @NamedQuery(name = "Universite.findByLibUniv", query = "SELECT u FROM Universite u WHERE u.libUniv = :libUniv")})
public class Universite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodeUniv")
    private Integer codeUniv;
    @Size(max = 254)
    @Column(name = "LibUniv")
    private String libUniv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeUniv", fetch = FetchType.EAGER)
    private List<Etablissement> etablissementList;

    public Universite() {
    }

    public Universite(Integer codeUniv) {
        this.codeUniv = codeUniv;
    }

    public Integer getCodeUniv() {
        return codeUniv;
    }

    public void setCodeUniv(Integer codeUniv) {
        this.codeUniv = codeUniv;
    }

    public String getLibUniv() {
        return libUniv;
    }

    public void setLibUniv(String libUniv) {
        this.libUniv = libUniv;
    }

    @XmlTransient
    public List<Etablissement> getEtablissementList() {
        return etablissementList;
    }

    public void setEtablissementList(List<Etablissement> etablissementList) {
        this.etablissementList = etablissementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeUniv != null ? codeUniv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Universite)) {
            return false;
        }
        Universite other = (Universite) object;
        if ((this.codeUniv == null && other.codeUniv != null) || (this.codeUniv != null && !this.codeUniv.equals(other.codeUniv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return   libUniv ;
    }
    
}
