/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Chercheur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import session.EtablissementFacade;
import session.UniversiteFacade;

/**
 *
 * @author USER1
 */
@ManagedBean
@SessionScoped
public class modifierProfileController implements Serializable {
    @EJB
    private EtablissementFacade etablissementFacade;
    @EJB
    private UniversiteFacade universiteFacade;
private String nomDirecteur;
private String prenomDirecteur;
    private Chercheur ch;
private String univG;
private String etabG;
private  List listUnivG;
private  List listEtabG;
private  List listEtabF;
private String univF;
private String etabF;
    public String getUnivG() {
        return univG;
    }

    public String getUnivF() {
        return univF;
    }

    public void setUnivF(String univF) {
        this.univF = univF;
    }

    public String getEtabF() {
        return etabF;
    }

    public void setEtabF(String etabF) {
        this.etabF = etabF;
    }

    public List getListUnivG() {
        return listUnivG;
    }

    public List getListEtabF() {
        return listEtabF;
    }

    public void setListEtabF(List listEtabF) {
        this.listEtabF = listEtabF;
    }

    public void setListUnivG(List listUnivG) {
        this.listUnivG = listUnivG;
    }

    public List getListEtabG() {
        return listEtabG;
    }

    public void setListEtabG(List listEtabG) {
        this.listEtabG = listEtabG;
    }

    public void setUnivG(String univG) {
        this.univG = univG;
    }

    public String getEtabG() {
        return etabG;
    }

    public void setEtabG(String etabG) {
        this.etabG = etabG;
    }



    public Chercheur getCh() {
        return ch;
    }

    public void setCh(Chercheur ch) {
        this.ch = ch;
    }

    public String getNomDirecteur() {
        return nomDirecteur;
    }

    public void setNomDirecteur(String nomDirecteur) {
        this.nomDirecteur = nomDirecteur;
    }

    public String getPrenomDirecteur() {
        return prenomDirecteur;
    }

    public void setPrenomDirecteur(String prenomDirecteur) {
        this.prenomDirecteur = prenomDirecteur;
    }
   
    
    
    public modifierProfileController() {
    }
    
     @PostConstruct
    public void genererlistpublication()
    {
         FacesContext facesContext = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
       ch=(Chercheur) session.getAttribute("user");
        if(ch!=null)
        {
            listUnivG=universiteFacade.findAll();
            System.out.println("etab grade "+ ch.getEtaCodeEtab2().getLibEtab());
            if(ch.getEtaCodeEtab2()!=null)
            { 
            univG=ch.getEtaCodeEtab2().getCodeUniv().getLibUniv();
            findEtablissementByCodeUniv();
            etabG=ch.getEtaCodeEtab2().getLibEtab();}
            System.out.println("univG "+univG);
             if(ch.getEtaCodeEtab()!=null)
            { 
            univF=ch.getEtaCodeEtab().getCodeUniv().getLibUniv();
            findEtablissementByCodeUniv();
            etabF=ch.getEtaCodeEtab().getLibEtab();}
            System.out.println("univF "+univF);
            if(ch.getCheIdCh()!=null)
            {
                nomDirecteur=ch.getCheIdCh().getNomCh();
                prenomDirecteur=ch.getCheIdCh().getPrenomCh();
            }
        }
    }
      public boolean displaypanel()
    { System.out.println("sexe "+ch.getSexeCh());
        if(ch.getSexeCh()==null)
        return false;
       // System.out.println(sexe);
        if(ch.getSexeCh().equals("Femme"))
        {   //System.out.println("activer ");
        return true;}
        else
            return false;
    }
   public void findEtablissementByCodeUniv()
    {
        System.out.println("univ "+ univF);
        if(univF==null)
            listEtabF=new ArrayList();
        else{
       
           listEtabF=etablissementFacade.findListEtablissementByUniv(univF);
     
         System.out.println(listEtabF);
        
        }
        
        
        if(univG==null)
        {
            listEtabG=new ArrayList();
        }
       
           
        else{
       listEtabG=etablissementFacade.findListEtablissementByUniv(univG);
            System.out.println("etab grade "+listEtabG);
        }
        
        
      
    } 
    public boolean displaypanelSupp()
    { System.out.println("sexe "+ch.getTypeCh());
        if(ch.getTypeCh()==null)
        return false;
       // System.out.println(sexe);
        if(ch.getTypeCh().equals("Etudiant en Master")||ch.getTypeCh().equals("Doctorant"))
        {   //System.out.println("activer ");
        return true;}
        else
            return false;
    }
        
}
