/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER1
 */
@Entity
@Table(name = "structurerecherche")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Structurerecherche.findAll", query = "SELECT s FROM Structurerecherche s"),
    @NamedQuery(name = "Structurerecherche.findByCode", query = "SELECT s FROM Structurerecherche s WHERE s.code = :code"),
    @NamedQuery(name = "Structurerecherche.findByDenomination", query = "SELECT s FROM Structurerecherche s WHERE s.denomination = :denomination"),
    @NamedQuery(name = "Structurerecherche.findByType", query = "SELECT s FROM Structurerecherche s WHERE s.type = :type"),
    @NamedQuery(name = "Structurerecherche.findByDiscipline", query = "SELECT s FROM Structurerecherche s WHERE s.discipline = :discipline"),
    @NamedQuery(name = "Structurerecherche.findBySite", query = "SELECT s FROM Structurerecherche s WHERE s.site = :site"),
    @NamedQuery(name = "Structurerecherche.findByDateDeb", query = "SELECT s FROM Structurerecherche s WHERE s.dateDeb = :dateDeb"),
    @NamedQuery(name = "Structurerecherche.findByDateFin", query = "SELECT s FROM Structurerecherche s WHERE s.dateFin = :dateFin")})
public class Structurerecherche implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "Code")
    private String code;
    @Size(max = 254)
    @Column(name = "Denomination")
    private String denomination;
    @Size(max = 254)
    @Column(name = "Type")
    private String type;
    @Size(max = 254)
    @Column(name = "Discipline")
    private String discipline;
    @Size(max = 254)
    @Column(name = "Site")
    private String site;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateDeb")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    @JoinColumn(name = "CodeEtab", referencedColumnName = "CodeEtab")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Etablissement codeEtab;
    @JoinColumn(name = "IdCh", referencedColumnName = "IdCh")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Chercheur idCh;
    @OneToMany(mappedBy = "code", fetch = FetchType.EAGER)
    private List<Chercheur> chercheurList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "structurerecherche", fetch = FetchType.EAGER)
    private List<Inscription> inscriptionList;

    public Structurerecherche() {
    }

    public Structurerecherche(String code) {
        this.code = code;
    }

    public Structurerecherche(String code, Date dateDeb, Date dateFin) {
        this.code = code;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Date getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(Date dateDeb) {
        this.dateDeb = dateDeb;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Etablissement getCodeEtab() {
        return codeEtab;
    }

    public void setCodeEtab(Etablissement codeEtab) {
        this.codeEtab = codeEtab;
    }

    public Chercheur getIdCh() {
        return idCh;
    }

    public void setIdCh(Chercheur idCh) {
        this.idCh = idCh;
    }

    @XmlTransient
    public List<Chercheur> getChercheurList() {
        return chercheurList;
    }

    public void setChercheurList(List<Chercheur> chercheurList) {
        this.chercheurList = chercheurList;
    }

    @XmlTransient
    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Structurerecherche)) {
            return false;
        }
        Structurerecherche other = (Structurerecherche) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
       /* if(!this.denomination.equals(((Structurerecherche)object).denomination))
            return false;
        else return true;*/
    }

    @Override
    public String toString() {
        return   denomination;
    }
    
}
