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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER1
 */
@Entity
@Table(name = "diplome")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diplome.findAll", query = "SELECT d FROM Diplome d"),
    @NamedQuery(name = "Diplome.findByIdD", query = "SELECT d FROM Diplome d WHERE d.idD = :idD"),
    @NamedQuery(name = "Diplome.findByIntituleD", query = "SELECT d FROM Diplome d WHERE d.intituleD = :intituleD")})
public class Diplome implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_D")
    private Integer idD;
    @Column(name = "Intitule_D")
    private Integer intituleD;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diplome", fetch = FetchType.EAGER)
    private List<Obtenir> obtenirList;

    public Diplome() {
    }

    public Diplome(Integer idD) {
        this.idD = idD;
    }

    public Integer getIdD() {
        return idD;
    }

    public void setIdD(Integer idD) {
        this.idD = idD;
    }

    public Integer getIntituleD() {
        return intituleD;
    }

    public void setIntituleD(Integer intituleD) {
        this.intituleD = intituleD;
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
        hash += (idD != null ? idD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diplome)) {
            return false;
        }
        Diplome other = (Diplome) object;
        if ((this.idD == null && other.idD != null) || (this.idD != null && !this.idD.equals(other.idD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Diplome[ idD=" + idD + " ]";
    }
    
}
