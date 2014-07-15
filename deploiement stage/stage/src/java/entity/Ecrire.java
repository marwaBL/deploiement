/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER1
 */
@Entity
@Table(name = "ecrire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ecrire.findAll", query = "SELECT e FROM Ecrire e"),
    @NamedQuery(name = "Ecrire.findByIdPub", query = "SELECT e FROM Ecrire e WHERE e.ecrirePK.idPub = :idPub"),
    @NamedQuery(name = "Ecrire.findByIdAut", query = "SELECT e FROM Ecrire e WHERE e.ecrirePK.idAut = :idAut"),
    @NamedQuery(name = "Ecrire.findByRang", query = "SELECT e FROM Ecrire e WHERE e.rang = :rang")})
public class Ecrire implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EcrirePK ecrirePK;
    @Column(name = "rang")
    private Integer rang;
    @JoinColumn(name = "IdPub", referencedColumnName = "IdPub", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Publication publication;
    @JoinColumn(name = "IdAut", referencedColumnName = "IdAut", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Auteur auteur;

    public Ecrire() {
    }

    public Ecrire(EcrirePK ecrirePK) {
        this.ecrirePK = ecrirePK;
    }

    public Ecrire(int idPub, int idAut) {
        this.ecrirePK = new EcrirePK(idPub, idAut);
    }

    public EcrirePK getEcrirePK() {
        return ecrirePK;
    }

    public void setEcrirePK(EcrirePK ecrirePK) {
        this.ecrirePK = ecrirePK;
    }

    public Integer getRang() {
        return rang;
    }

    public void setRang(Integer rang) {
        this.rang = rang;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ecrirePK != null ? ecrirePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecrire)) {
            return false;
        }
        Ecrire other = (Ecrire) object;
        if ((this.ecrirePK == null && other.ecrirePK != null) || (this.ecrirePK != null && !this.ecrirePK.equals(other.ecrirePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return auteur+"";
    }
    
}
