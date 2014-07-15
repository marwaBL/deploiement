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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER1
 */
@Entity
@Table(name = "chercheur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chercheur.findAll", query = "SELECT c FROM Chercheur c"),
    @NamedQuery(name = "Chercheur.findByIdCh", query = "SELECT c FROM Chercheur c WHERE c.idCh = :idCh"),
    @NamedQuery(name = "Chercheur.findByNomCh", query = "SELECT c FROM Chercheur c WHERE c.nomCh = :nomCh"),
    @NamedQuery(name = "Chercheur.findByPrenomCh", query = "SELECT c FROM Chercheur c WHERE c.prenomCh = :prenomCh"),
    @NamedQuery(name = "Chercheur.findByDateNaisCh", query = "SELECT c FROM Chercheur c WHERE c.dateNaisCh = :dateNaisCh"),
    @NamedQuery(name = "Chercheur.findByLieuNaisCh", query = "SELECT c FROM Chercheur c WHERE c.lieuNaisCh = :lieuNaisCh"),
    @NamedQuery(name = "Chercheur.findBySexeCh", query = "SELECT c FROM Chercheur c WHERE c.sexeCh = :sexeCh"),
    @NamedQuery(name = "Chercheur.findByNomJFCh", query = "SELECT c FROM Chercheur c WHERE c.nomJFCh = :nomJFCh"),
    @NamedQuery(name = "Chercheur.findByCinCh", query = "SELECT c FROM Chercheur c WHERE c.cinCh = :cinCh"),
    @NamedQuery(name = "Chercheur.findByPassCh", query = "SELECT c FROM Chercheur c WHERE c.passCh = :passCh"),
    @NamedQuery(name = "Chercheur.findByTelCh", query = "SELECT c FROM Chercheur c WHERE c.telCh = :telCh"),
    @NamedQuery(name = "Chercheur.findByEmailCh", query = "SELECT c FROM Chercheur c WHERE c.emailCh = :emailCh"),
    @NamedQuery(name = "Chercheur.findByGradeCh", query = "SELECT c FROM Chercheur c WHERE c.gradeCh = :gradeCh"),
    @NamedQuery(name = "Chercheur.findByTypeCh", query = "SELECT c FROM Chercheur c WHERE c.typeCh = :typeCh"),
    @NamedQuery(name = "Chercheur.findBySujetRechCh", query = "SELECT c FROM Chercheur c WHERE c.sujetRechCh = :sujetRechCh"),
    @NamedQuery(name = "Chercheur.findByAvancement", query = "SELECT c FROM Chercheur c WHERE c.avancement = :avancement"),
    @NamedQuery(name = "Chercheur.findByFonctionCh", query = "SELECT c FROM Chercheur c WHERE c.fonctionCh = :fonctionCh"),
    @NamedQuery(name = "Chercheur.findByAnnee", query = "SELECT c FROM Chercheur c WHERE c.annee = :annee"),
    @NamedQuery(name = "Chercheur.findByEtat", query = "SELECT c FROM Chercheur c WHERE c.etat = :etat"),
    @NamedQuery(name = "Chercheur.findByPhoto", query = "SELECT c FROM Chercheur c WHERE c.photo = :photo"),
    @NamedQuery(name = "Chercheur.findByPassword", query = "SELECT c FROM Chercheur c WHERE c.password = :password")})
public class Chercheur implements Serializable {
    @OneToMany(mappedBy = "idCh", fetch = FetchType.EAGER)
    private List<Publication> publicationList;
    @Column(name = "dateinscription")
    @Temporal(TemporalType.DATE)
    private Date dateinscription;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdCh")
    private Integer idCh;
    @Size(max = 254)
    @Column(name = "NomCh")
    private String nomCh;
    @Size(max = 254)
    @Column(name = "PrenomCh")
    private String prenomCh;
    @Column(name = "DateNaisCh")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaisCh;
    @Size(max = 254)
    @Column(name = "LieuNaisCh")
    private String lieuNaisCh;
    @Size(max = 254)
    @Column(name = "SexeCh")
    private String sexeCh;
    @Size(max = 254)
    @Column(name = "NomJFCh")
    private String nomJFCh;
    @Size(max = 254)
    @Column(name = "CinCh")
    private String cinCh;
    @Size(max = 254)
    @Column(name = "PassCh")
    private String passCh;
    @Size(max = 254)
    @Column(name = "TelCh")
    private String telCh;
    @Size(max = 254)
    @Column(name = "EmailCh")
    private String emailCh;
    @Size(max = 254)
    @Column(name = "GradeCh")
    private String gradeCh;
    @Size(max = 254)
    @Column(name = "TypeCh")
    private String typeCh;
    @Size(max = 254)
    @Column(name = "SujetRechCh")
    private String sujetRechCh;
    @Column(name = "Avancement")
    private Integer avancement;
    @Size(max = 254)
    @Column(name = "FonctionCh")
    private String fonctionCh;
    @Column(name = "Annee")
    private Integer annee;
    @Size(max = 254)
    @Column(name = "Etat")
    private String etat;
    @Size(max = 254)
    @Column(name = "photo")
    private String photo;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCh")
    private List<Structurerecherche> structurerechercheList;
    @JoinColumn(name = "Eta_CodeEtab", referencedColumnName = "CodeEtab")
    @ManyToOne
    private Etablissement etaCodeEtab;
    @JoinColumn(name = "Eta_CodeEtab2", referencedColumnName = "CodeEtab")
    @ManyToOne
    private Etablissement etaCodeEtab2;
    @JoinColumn(name = "CodeEtab", referencedColumnName = "CodeEtab")
    @ManyToOne
    private Etablissement codeEtab;
    @JoinColumn(name = "Code", referencedColumnName = "Code")
    @ManyToOne
    private Structurerecherche code;
    @OneToMany(mappedBy = "cheIdCh")
    private List<Chercheur> chercheurList;
    @JoinColumn(name = "Che_IdCh", referencedColumnName = "IdCh")
    @ManyToOne
    private Chercheur cheIdCh;

    public Chercheur() {
    }

    public Chercheur(Integer idCh) {
        this.idCh = idCh;
    }

    public Integer getIdCh() {
        return idCh;
    }

    public void setIdCh(Integer idCh) {
        this.idCh = idCh;
    }

    public String getNomCh() {
        return nomCh;
    }

    public void setNomCh(String nomCh) {
        this.nomCh = nomCh;
    }

    public String getPrenomCh() {
        return prenomCh;
    }

    public void setPrenomCh(String prenomCh) {
        this.prenomCh = prenomCh;
    }

    public Date getDateNaisCh() {
        return dateNaisCh;
    }

    public void setDateNaisCh(Date dateNaisCh) {
        this.dateNaisCh = dateNaisCh;
    }

    public String getLieuNaisCh() {
        return lieuNaisCh;
    }

    public void setLieuNaisCh(String lieuNaisCh) {
        this.lieuNaisCh = lieuNaisCh;
    }

    public String getSexeCh() {
        return sexeCh;
    }

    public void setSexeCh(String sexeCh) {
        this.sexeCh = sexeCh;
    }

    public String getNomJFCh() {
        return nomJFCh;
    }

    public void setNomJFCh(String nomJFCh) {
        this.nomJFCh = nomJFCh;
    }

    public String getCinCh() {
        return cinCh;
    }

    public void setCinCh(String cinCh) {
        this.cinCh = cinCh;
    }

    public String getPassCh() {
        return passCh;
    }

    public void setPassCh(String passCh) {
        this.passCh = passCh;
    }

    public String getTelCh() {
        return telCh;
    }

    public void setTelCh(String telCh) {
        this.telCh = telCh;
    }

    public String getEmailCh() {
        return emailCh;
    }

    public void setEmailCh(String emailCh) {
        this.emailCh = emailCh;
    }

    public String getGradeCh() {
        return gradeCh;
    }

    public void setGradeCh(String gradeCh) {
        this.gradeCh = gradeCh;
    }

    public String getTypeCh() {
        return typeCh;
    }

    public void setTypeCh(String typeCh) {
        this.typeCh = typeCh;
    }

    public String getSujetRechCh() {
        return sujetRechCh;
    }

    public void setSujetRechCh(String sujetRechCh) {
        this.sujetRechCh = sujetRechCh;
    }

    public Integer getAvancement() {
        return avancement;
    }

    public void setAvancement(Integer avancement) {
        this.avancement = avancement;
    }

    public String getFonctionCh() {
        return fonctionCh;
    }

    public void setFonctionCh(String fonctionCh) {
        this.fonctionCh = fonctionCh;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<Structurerecherche> getStructurerechercheList() {
        return structurerechercheList;
    }

    public void setStructurerechercheList(List<Structurerecherche> structurerechercheList) {
        this.structurerechercheList = structurerechercheList;
    }

    public Etablissement getEtaCodeEtab() {
        return etaCodeEtab;
    }

    public void setEtaCodeEtab(Etablissement etaCodeEtab) {
        this.etaCodeEtab = etaCodeEtab;
    }

    public Etablissement getEtaCodeEtab2() {
        return etaCodeEtab2;
    }

    public void setEtaCodeEtab2(Etablissement etaCodeEtab2) {
        this.etaCodeEtab2 = etaCodeEtab2;
    }

    public Etablissement getCodeEtab() {
        return codeEtab;
    }

    public void setCodeEtab(Etablissement codeEtab) {
        this.codeEtab = codeEtab;
    }

    public Structurerecherche getCode() {
        return code;
    }

    public void setCode(Structurerecherche code) {
        this.code = code;
    }

    @XmlTransient
    public List<Chercheur> getChercheurList() {
        return chercheurList;
    }

    public void setChercheurList(List<Chercheur> chercheurList) {
        this.chercheurList = chercheurList;
    }

    public Chercheur getCheIdCh() {
        return cheIdCh;
    }

    public void setCheIdCh(Chercheur cheIdCh) {
        this.cheIdCh = cheIdCh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCh != null ? idCh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chercheur)) {
            return false;
        }
        Chercheur other = (Chercheur) object;
        if ((this.idCh == null && other.idCh != null) || (this.idCh != null && !this.idCh.equals(other.idCh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
       /* if(etaCodeEtab2!=null)
        { String [] etab= etaCodeEtab2.getLibEtab().split(" ");
       String res="";
       for (int i=0;i<etab.length;i++)
       {
           if(!etab[i].equals("de"))
           res=res+etab[i].charAt(0);
       }
       String [] univ= etaCodeEtab2.getCodeUniv().getLibUniv().split(" ");
       String resuniv="";
       for (int i=0;i<univ.length;i++)
       {
            if(!univ[i].equals("de"))
           resuniv=resuniv+univ[i].charAt(0);
       }
        return gradeCh+"          "+nomCh +" "+prenomCh+"              "+cinCh+"                 " +res+"                                   "+etaCodeEtab2.getCodeUniv().getLibUniv();
        }
        else
             return nomCh +" "+prenomCh+"    "+cinCh;*/
       if(gradeCh==null)
        return nomCh+" "+prenomCh;
        else
            return nomCh+" "+prenomCh+"             "+gradeCh+"             "+etaCodeEtab2;
        
    }

    public Date getDateinscription() {
        return dateinscription;
    }

    public void setDateinscription(Date dateinscription) {
        this.dateinscription = dateinscription;
    }

    @XmlTransient
    public List<Publication> getPublicationList() {
        return publicationList;
    }

    public void setPublicationList(List<Publication> publicationList) {
        this.publicationList = publicationList;
    }

   
    
}
