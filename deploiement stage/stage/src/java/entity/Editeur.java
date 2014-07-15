/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER1
 */
@Entity
@Table(name = "editeur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Editeur.findAll", query = "SELECT e FROM Editeur e"),
    @NamedQuery(name = "Editeur.findByIdEd", query = "SELECT e FROM Editeur e WHERE e.idEd = :idEd"),
    @NamedQuery(name = "Editeur.findByNomEd", query = "SELECT e FROM Editeur e WHERE e.nomEd = :nomEd"),
    @NamedQuery(name = "Editeur.findByPrenomEd", query = "SELECT e FROM Editeur e WHERE e.prenomEd = :prenomEd")})
public class Editeur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdEd")
    private Integer idEd;
    @Size(max = 254)
    @Column(name = "NomEd")
    private String nomEd;
    @Size(max = 254)
    @Column(name = "PrenomEd")
    private String prenomEd;

    public Editeur() {
    }

    public Editeur(Integer idEd) {
        this.idEd = idEd;
    }

    public Integer getIdEd() {
        return idEd;
    }

    public void setIdEd(Integer idEd) {
        this.idEd = idEd;
    }

    public String getNomEd() {
        return nomEd;
    }

    public void setNomEd(String nomEd) {
        this.nomEd = nomEd;
    }

    public String getPrenomEd() {
        return prenomEd;
    }

    public void setPrenomEd(String prenomEd) {
        this.prenomEd = prenomEd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEd != null ? idEd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Editeur)) {
            return false;
        }
        Editeur other = (Editeur) object;
        if ((this.idEd == null && other.idEd != null) || (this.idEd != null && !this.idEd.equals(other.idEd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Editeur[ idEd=" + idEd + " ]";
    }
    
}
