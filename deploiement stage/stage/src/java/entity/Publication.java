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
@Table(name = "publication")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publication.findAll", query = "SELECT p FROM Publication p"),
    @NamedQuery(name = "Publication.findByIdPub", query = "SELECT p FROM Publication p WHERE p.idPub = :idPub"),
    @NamedQuery(name = "Publication.findByTitre", query = "SELECT p FROM Publication p WHERE p.titre = :titre"),
    @NamedQuery(name = "Publication.findByAnnee", query = "SELECT p FROM Publication p WHERE p.annee = :annee"),
    @NamedQuery(name = "Publication.findByMois", query = "SELECT p FROM Publication p WHERE p.mois = :mois"),
    @NamedQuery(name = "Publication.findByNote", query = "SELECT p FROM Publication p WHERE p.note = :note"),
    @NamedQuery(name = "Publication.findByCle", query = "SELECT p FROM Publication p WHERE p.cle = :cle"),
    @NamedQuery(name = "Publication.findByHowpub", query = "SELECT p FROM Publication p WHERE p.howpub = :howpub"),
    @NamedQuery(name = "Publication.findByAdresse", query = "SELECT p FROM Publication p WHERE p.adresse = :adresse"),
    @NamedQuery(name = "Publication.findByJournal", query = "SELECT p FROM Publication p WHERE p.journal = :journal"),
    @NamedQuery(name = "Publication.findByPagedeb", query = "SELECT p FROM Publication p WHERE p.pagedeb = :pagedeb"),
    @NamedQuery(name = "Publication.findByPagefin", query = "SELECT p FROM Publication p WHERE p.pagefin = :pagefin"),
    @NamedQuery(name = "Publication.findByVolume", query = "SELECT p FROM Publication p WHERE p.volume = :volume"),
    @NamedQuery(name = "Publication.findByNombre", query = "SELECT p FROM Publication p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Publication.findByEdition", query = "SELECT p FROM Publication p WHERE p.edition = :edition"),
    @NamedQuery(name = "Publication.findByChapitre", query = "SELECT p FROM Publication p WHERE p.chapitre = :chapitre"),
    @NamedQuery(name = "Publication.findBySerie", query = "SELECT p FROM Publication p WHERE p.serie = :serie"),
    @NamedQuery(name = "Publication.findByBooktitle", query = "SELECT p FROM Publication p WHERE p.booktitle = :booktitle"),
    @NamedQuery(name = "Publication.findByOrganisation", query = "SELECT p FROM Publication p WHERE p.organisation = :organisation"),
    @NamedQuery(name = "Publication.findByType", query = "SELECT p FROM Publication p WHERE p.type = :type"),
    @NamedQuery(name = "Publication.findByEtablissement", query = "SELECT p FROM Publication p WHERE p.etablissement = :etablissement"),
    @NamedQuery(name = "Publication.findByTypeRapport", query = "SELECT p FROM Publication p WHERE p.typeRapport = :typeRapport")})
public class Publication implements Serializable {
    @JoinColumn(name = "IdCh", referencedColumnName = "IdCh")
    @ManyToOne(fetch = FetchType.EAGER)
    private Chercheur idCh;
   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdPub")
    private Integer idPub;
    @Size(max = 254)
    @Column(name = "Titre")
    private String titre;
    @Column(name = "annee")
    private Integer annee;
    @Column(name = "mois")
    private Integer mois;
    @Size(max = 254)
    @Column(name = "note")
    private String note;
    @Size(max = 254)
    @Column(name = "cle")
    private String cle;
    @Size(max = 254)
    @Column(name = "howpub")
    private String howpub;
    @Size(max = 254)
    @Column(name = "adresse")
    private String adresse;
    @Size(max = 254)
    @Column(name = "journal")
    private String journal;
    @Column(name = "pagedeb")
    private Integer pagedeb;
    @Column(name = "pagefin")
    private Integer pagefin;
    @Column(name = "volume")
    private Integer volume;
    @Column(name = "nombre")
    private Integer nombre;
    @Size(max = 254)
    @Column(name = "edition")
    private String edition;
    @Size(max = 254)
    @Column(name = "chapitre")
    private String chapitre;
    @Size(max = 254)
    @Column(name = "serie")
    private String serie;
    @Size(max = 254)
    @Column(name = "booktitle")
    private String booktitle;
    @Size(max = 254)
    @Column(name = "organisation")
    private String organisation;
    @Size(max = 254)
    @Column(name = "type")
    private String type;
    @Size(max = 254)
    @Column(name = "etablissement")
    private String etablissement;
    @Size(max = 254)
    @Column(name = "typeRapport")
    private String typeRapport;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publication", fetch = FetchType.EAGER)
    private List<Ecrire> ecrireList;

    public Publication() {
    }

    public Publication(Integer idPub) {
        this.idPub = idPub;
    }

    public Integer getIdPub() {
        return idPub;
    }

    public void setIdPub(Integer idPub) {
        this.idPub = idPub;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Integer getMois() {
        return mois;
    }

    public void setMois(Integer mois) {
        this.mois = mois;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCle() {
        return cle;
    }

    public void setCle(String cle) {
        this.cle = cle;
    }

    public String getHowpub() {
        return howpub;
    }

    public void setHowpub(String howpub) {
        this.howpub = howpub;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public Integer getPagedeb() {
        return pagedeb;
    }

    public void setPagedeb(Integer pagedeb) {
        this.pagedeb = pagedeb;
    }

    public Integer getPagefin() {
        return pagefin;
    }

    public void setPagefin(Integer pagefin) {
        this.pagefin = pagefin;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getNombre() {
        return nombre;
    }

    public void setNombre(Integer nombre) {
        this.nombre = nombre;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getChapitre() {
        return chapitre;
    }

    public void setChapitre(String chapitre) {
        this.chapitre = chapitre;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public String getTypeRapport() {
        return typeRapport;
    }

    public void setTypeRapport(String typeRapport) {
        this.typeRapport = typeRapport;
    }

    @XmlTransient
    public List<Ecrire> getEcrireList() {
        return ecrireList;
    }

    public void setEcrireList(List<Ecrire> ecrireList) {
        this.ecrireList = ecrireList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPub != null ? idPub.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publication)) {
            return false;
        }
        Publication other = (Publication) object;
        if ((this.idPub == null && other.idPub != null) || (this.idPub != null && !this.idPub.equals(other.idPub))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Publication[ idPub=" + idPub + " ]";
    }

   

    public Chercheur getIdCh() {
        return idCh;
    }

    public void setIdCh(Chercheur idCh) {
        this.idCh = idCh;
    }
    
}
