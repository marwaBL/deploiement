/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER1
 */
@Entity
@Table(name = "obtenir")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Obtenir.findAll", query = "SELECT o FROM Obtenir o"),
    @NamedQuery(name = "Obtenir.findByIdCh", query = "SELECT o FROM Obtenir o WHERE o.obtenirPK.idCh = :idCh"),
    @NamedQuery(name = "Obtenir.findByIdD", query = "SELECT o FROM Obtenir o WHERE o.obtenirPK.idD = :idD"),
    @NamedQuery(name = "Obtenir.findByCodeEtab", query = "SELECT o FROM Obtenir o WHERE o.obtenirPK.codeEtab = :codeEtab"),
    @NamedQuery(name = "Obtenir.findByDate", query = "SELECT o FROM Obtenir o WHERE o.date = :date")})
public class Obtenir implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ObtenirPK obtenirPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "IdCh", referencedColumnName = "IdCh", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Chercheur chercheur;
    @JoinColumn(name = "Id_D", referencedColumnName = "Id_D", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Diplome diplome;
    @JoinColumn(name = "CodeEtab", referencedColumnName = "CodeEtab", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Etablissement etablissement;

    public Obtenir() {
    }

    public Obtenir(ObtenirPK obtenirPK) {
        this.obtenirPK = obtenirPK;
    }

    public Obtenir(ObtenirPK obtenirPK, Date date) {
        this.obtenirPK = obtenirPK;
        this.date = date;
    }

    public Obtenir(int idCh, int idD, int codeEtab) {
        this.obtenirPK = new ObtenirPK(idCh, idD, codeEtab);
    }

    public ObtenirPK getObtenirPK() {
        return obtenirPK;
    }

    public void setObtenirPK(ObtenirPK obtenirPK) {
        this.obtenirPK = obtenirPK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Chercheur getChercheur() {
        return chercheur;
    }

    public void setChercheur(Chercheur chercheur) {
        this.chercheur = chercheur;
    }

    public Diplome getDiplome() {
        return diplome;
    }

    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (obtenirPK != null ? obtenirPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Obtenir)) {
            return false;
        }
        Obtenir other = (Obtenir) object;
        if ((this.obtenirPK == null && other.obtenirPK != null) || (this.obtenirPK != null && !this.obtenirPK.equals(other.obtenirPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Obtenir[ obtenirPK=" + obtenirPK + " ]";
    }
    
}
