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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER1
 */
@Entity
@Table(name = "auteur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auteur.findAll", query = "SELECT a FROM Auteur a"),
    @NamedQuery(name = "Auteur.findByIdAut", query = "SELECT a FROM Auteur a WHERE a.idAut = :idAut"),
    @NamedQuery(name = "Auteur.findByNomAut", query = "SELECT a FROM Auteur a WHERE a.nomAut = :nomAut"),
    @NamedQuery(name = "Auteur.findByPrenomAut", query = "SELECT a FROM Auteur a WHERE a.prenomAut = :prenomAut")})
public class Auteur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdAut")
    private Integer idAut;
    @Size(max = 254)
    @Column(name = "NomAut")
    private String nomAut;
    @Size(max = 254)
    @Column(name = "PrenomAut")
    private String prenomAut;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auteur", fetch = FetchType.EAGER)
    private List<Ecrire> ecrireList;
    @JoinColumn(name = "IdCh", referencedColumnName = "IdCh")
    @ManyToOne(fetch = FetchType.EAGER )
    private Chercheur idCh;

    public Auteur() {
    }

    public Auteur(Integer idAut) {
        this.idAut = idAut;
    }

    public Integer getIdAut() {
        return idAut;
    }

    public void setIdAut(Integer idAut) {
        this.idAut = idAut;
    }

    public String getNomAut() {
        return nomAut;
    }

    public void setNomAut(String nomAut) {
        this.nomAut = nomAut;
    }

    public String getPrenomAut() {
        return prenomAut;
    }

    public void setPrenomAut(String prenomAut) {
        this.prenomAut = prenomAut;
    }

    @XmlTransient
    public List<Ecrire> getEcrireList() {
        return ecrireList;
    }

    public void setEcrireList(List<Ecrire> ecrireList) {
        this.ecrireList = ecrireList;
    }

    public Chercheur getIdCh() {
        return idCh;
    }

    public void setIdCh(Chercheur idCh) {
        this.idCh = idCh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAut != null ? idAut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auteur)) {
            return false;
        }
        Auteur other = (Auteur) object;
        if(this.nomAut.equals(other.nomAut)&&this.prenomAut.equals(other.prenomAut))
            return true;
        else
            return false;
       /* if ((this.idAut == null && other.idAut != null) || (this.idAut != null && !this.idAut.equals(other.idAut))) {
            return false;
        }
        return true;*/
    }

    @Override
    public String toString() {
        return prenomAut +" "+nomAut;
    }
    
}
