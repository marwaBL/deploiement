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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "etablissement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etablissement.findAll", query = "SELECT e FROM Etablissement e"),
    @NamedQuery(name = "Etablissement.findByCodeEtab", query = "SELECT e FROM Etablissement e WHERE e.codeEtab = :codeEtab"),
    @NamedQuery(name = "Etablissement.findByLibEtab", query = "SELECT e FROM Etablissement e WHERE e.libEtab = :libEtab")})
public class Etablissement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodeEtab")
    private Integer codeEtab;
    @Size(max = 254)
    @Column(name = "LibEtab")
    private String libEtab;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeEtab", fetch = FetchType.EAGER)
    private List<Structurerecherche> structurerechercheList;
    @OneToMany(mappedBy = "etaCodeEtab", fetch = FetchType.EAGER)
    private List<Chercheur> chercheurList;
    @OneToMany(mappedBy = "etaCodeEtab2", fetch = FetchType.EAGER)
    private List<Chercheur> chercheurList1;
    @OneToMany(mappedBy = "codeEtab", fetch = FetchType.EAGER)
    private List<Chercheur> chercheurList2;
    @JoinColumn(name = "CodeUniv", referencedColumnName = "CodeUniv")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Universite codeUniv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etablissement", fetch = FetchType.EAGER)
    private List<Obtenir> obtenirList;

    public Etablissement() {
    }

    public Etablissement(Integer codeEtab) {
        this.codeEtab = codeEtab;
    }

    public Integer getCodeEtab() {
        return codeEtab;
    }

    public void setCodeEtab(Integer codeEtab) {
        this.codeEtab = codeEtab;
    }

    public String getLibEtab() {
        return libEtab;
    }

    public void setLibEtab(String libEtab) {
        this.libEtab = libEtab;
    }

    @XmlTransient
    public List<Structurerecherche> getStructurerechercheList() {
        return structurerechercheList;
    }

    public void setStructurerechercheList(List<Structurerecherche> structurerechercheList) {
        this.structurerechercheList = structurerechercheList;
    }

    @XmlTransient
    public List<Chercheur> getChercheurList() {
        return chercheurList;
    }

    public void setChercheurList(List<Chercheur> chercheurList) {
        this.chercheurList = chercheurList;
    }

    @XmlTransient
    public List<Chercheur> getChercheurList1() {
        return chercheurList1;
    }

    public void setChercheurList1(List<Chercheur> chercheurList1) {
        this.chercheurList1 = chercheurList1;
    }

    @XmlTransient
    public List<Chercheur> getChercheurList2() {
        return chercheurList2;
    }

    public void setChercheurList2(List<Chercheur> chercheurList2) {
        this.chercheurList2 = chercheurList2;
    }

    public Universite getCodeUniv() {
        return codeUniv;
    }

    public void setCodeUniv(Universite codeUniv) {
        this.codeUniv = codeUniv;
    }

    @XmlTransient
    public List<Obtenir> getObtenirList() {
        return obtenirList;
    }

    public void setObtenirList(List<Obtenir> obtenirList) {
        this.obtenirList = obtenirList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeEtab != null ? codeEtab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etablissement)) {
            return false;
        }
        Etablissement other = (Etablissement) object;
        if ((this.codeEtab == null && other.codeEtab != null) || (this.codeEtab != null && !this.codeEtab.equals(other.codeEtab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
      String []res= libEtab.split(" ");
      String abr="";
      for(int i=0;i<res.length;i++)
      {
          if(!res[i].equals("de")&& !res[i].equals("d'"))
          abr=abr+res[i].charAt(0);
      }
        return  abr+"                    "+codeUniv.getLibUniv();
    }
    
}
