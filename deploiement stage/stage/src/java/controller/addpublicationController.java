/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Auteur;
import entity.Chercheur;
import entity.Editeur;
import entity.Publication;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import session.AuteurFacade;
import session.EditeurFacade;
import session.PublicationFacade;




/**
 *
 * @author USER1
 */
@ManagedBean
@RequestScoped 
//@SessionScoped
public class addpublicationController implements Serializable {
   
    @EJB
    private PublicationFacade publicationFacade;
    @EJB
    private EditeurFacade editeurFacade;
    @EJB
    private AuteurFacade auteurFacade;
   
    private String type;
 private ArrayList champssup=new ArrayList();
  private ArrayList champssup1=new ArrayList();
   private ArrayList champssup2=new ArrayList();
 private ArrayList auteurs;
 private ArrayList <Auteur> testauteur=new ArrayList<Auteur>();
 private List l;
 private List led;
 private String mois;
 private String nomAuteur;
 private String prenomAuteur;
 private String titre;
 private String annee;
 private String cle;
 private String note;
 private String adresseB;
 private String howpubB;
 private String journal;
 private String pagedebA;
 private String pagefinA;
 private String volumeA;
 private String nombreA;
 private String editionI;
 private String chapitreI;
  private String pagedebI;
 private String pagefinI;
 private String volumeI;
 private String serieI;
 private String adresseI;
 private String booktitleC;
 private String editionC;
  private String pagedebC;
 private String pagefinC;
 private String organisationC;
 private String adresseC;
 private String nomed;
 private String prenomed;
private String editionL;
private String adresseL;
private String serieL;
private String volumeL;
private String editionCol;
private String adresseCol;
private String booktitleCol;
private String pagedebCol;
private String pagefinCol;
private String howpubDiv;
private String editionD;
private String adresseD;
private String organisationD;
private String etablissementR;
private String adresseR;
private String typeR;
private Chercheur ch;
    public String getEditionCol() {
        return editionCol;
    }

    public String getTypeR() {
        return typeR;
    }

    public void setTypeR(String typeR) {
        this.typeR = typeR;
    }

    public String getEtablissementR() {
        return etablissementR;
    }

    public void setEtablissementR(String etablissementR) {
        this.etablissementR = etablissementR;
    }

    public String getAdresseR() {
        return adresseR;
    }

    public void setAdresseR(String adresseR) {
        this.adresseR = adresseR;
    }

    public String getHowpubDiv() {
        return howpubDiv;
    }

    public String getEditionD() {
        return editionD;
    }

    public void setEditionD(String editionD) {
        this.editionD = editionD;
    }

    public String getAdresseD() {
        return adresseD;
    }

    public void setAdresseD(String adresseD) {
        this.adresseD = adresseD;
    }

    public String getOrganisationD() {
        return organisationD;
    }

    public void setOrganisationD(String organisationD) {
        this.organisationD = organisationD;
    }

    public void setHowpubDiv(String howpubDiv) {
        this.howpubDiv = howpubDiv;
    }

    public String getPagedebCol() {
        return pagedebCol;
    }

    public void setPagedebCol(String pagedebCol) {
        this.pagedebCol = pagedebCol;
    }

    public String getPagefinCol() {
        return pagefinCol;
    }

    public void setPagefinCol(String pagefinCol) {
        this.pagefinCol = pagefinCol;
    }

    public void setEditionCol(String editionCol) {
        this.editionCol = editionCol;
    }

    public String getAdresseCol() {
        return adresseCol;
    }

    public void setAdresseCol(String adresseCol) {
        this.adresseCol = adresseCol;
    }

    public String getBooktitleCol() {
        return booktitleCol;
    }

    public void setBooktitleCol(String booktitleCol) {
        this.booktitleCol = booktitleCol;
    }



    public String getEditionL() {
        return editionL;
    }

    public void setEditionL(String editionL) {
        this.editionL = editionL;
    }

    public String getAdresseL() {
        return adresseL;
    }

    public void setAdresseL(String adresseL) {
        this.adresseL = adresseL;
    }

    public String getSerieL() {
        return serieL;
    }

    public void setSerieL(String serieL) {
        this.serieL = serieL;
    }

    public String getVolumeL() {
        return volumeL;
    }

    public void setVolumeL(String volumeL) {
        this.volumeL = volumeL;
    }
   

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public String getNomAuteur() {
        return nomAuteur;
    }

    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }

    public String getPrenomAuteur() {
        return prenomAuteur;
    }

    public void setPrenomAuteur(String prenomAuteur) {
        this.prenomAuteur = prenomAuteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getCle() {
        return cle;
    }

    public void setCle(String cle) {
        this.cle = cle;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAdresseB() {
        return adresseB;
    }

    public void setAdresseB(String adresseB) {
        this.adresseB = adresseB;
    }

    public String getHowpubB() {
        return howpubB;
    }

    public void setHowpubB(String howpubB) {
        this.howpubB = howpubB;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getPagedebA() {
        return pagedebA;
    }

    public void setPagedebA(String pagedebA) {
        this.pagedebA = pagedebA;
    }

    public String getPagefinA() {
        return pagefinA;
    }

    public void setPagefinA(String pagefinA) {
        this.pagefinA = pagefinA;
    }

    public String getVolumeA() {
        return volumeA;
    }

    public void setVolumeA(String volumeA) {
        this.volumeA = volumeA;
    }

    public String getNombreA() {
        return nombreA;
    }

    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
    }

    public String getEditionI() {
        return editionI;
    }

    public void setEditionI(String editionI) {
        this.editionI = editionI;
    }

    public String getChapitreI() {
        return chapitreI;
    }

    public void setChapitreI(String chapitreI) {
        this.chapitreI = chapitreI;
    }

    public String getPagedebI() {
        return pagedebI;
    }

    public void setPagedebI(String pagedebI) {
        this.pagedebI = pagedebI;
    }

    public String getPagefinI() {
        return pagefinI;
    }

    public void setPagefinI(String pagefinI) {
        this.pagefinI = pagefinI;
    }

    public String getVolumeI() {
        return volumeI;
    }

    public void setVolumeI(String volumeI) {
        this.volumeI = volumeI;
    }

    public String getSerieI() {
        return serieI;
    }

    public void setSerieI(String serieI) {
        this.serieI = serieI;
    }

    public String getAdresseI() {
        return adresseI;
    }

    public void setAdresseI(String adresseI) {
        this.adresseI = adresseI;
    }

    public String getBooktitleC() {
        return booktitleC;
    }

    public void setBooktitleC(String booktitleC) {
        this.booktitleC = booktitleC;
    }

    public String getEditionC() {
        return editionC;
    }

    public void setEditionC(String editionC) {
        this.editionC = editionC;
    }

    public String getPagedebC() {
        return pagedebC;
    }

    public void setPagedebC(String pagedebC) {
        this.pagedebC = pagedebC;
    }

    public String getPagefinC() {
        return pagefinC;
    }

    public void setPagefinC(String pagefinC) {
        this.pagefinC = pagefinC;
    }

    public String getOrganisationC() {
        return organisationC;
    }

    public void setOrganisationC(String organisationC) {
        this.organisationC = organisationC;
    }

    public String getAdresseC() {
        return adresseC;
    }

    public void setAdresseC(String adresseC) {
        this.adresseC = adresseC;
    }

    public String getNomed() {
        return nomed;
    }

    public void setNomed(String nomed) {
        this.nomed = nomed;
    }

    public String getPrenomed() {
        return prenomed;
    }

    public void setPrenomed(String prenomed) {
        this.prenomed = prenomed;
    }
 
 
 
    public ArrayList getChampssup() {
        return champssup;
    }

    public void setChampssup(ArrayList champssup) {
        this.champssup = champssup;
    }

    public ArrayList getChampssup1() {
        return champssup1;
    }

    public ArrayList getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(ArrayList auteurs) {
        this.auteurs = auteurs;
    }

    public ArrayList<Auteur> getTestauteur() {
        return testauteur;
    }

    public void setTestauteur(ArrayList<Auteur> testauteur) {
        this.testauteur = testauteur;
    }

    public void setChampssup1(ArrayList champssup1) {
        this.champssup1 = champssup1;
    }

    public ArrayList getChampssup2() {
        return champssup2;
    }

    public void setChampssup2(ArrayList champssup2) {
        this.champssup2 = champssup2;
    }
    
    
    
    
    
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
    public addpublicationController() {
        
          auteurs=new ArrayList();
        
          testauteur.add(new Auteur() );
   
       
    }
    @PostConstruct
    public void initialisation(){
    l=auteurFacade.findAll();
     led=editeurFacade.findAll();
       FacesContext facesContext = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
       ch=(Chercheur) session.getAttribute("user");
}
    public List<String> completeNomAuteur(String query) {  
        List<String> results = new ArrayList<String>();  
         
       
       for(int i=0; i<l.size() ;i++)
       {
           results.add(((Auteur)l.get(i)).getNomAut());
       }
       
            
          List<String> suggestions = new ArrayList<String>();  
         int i=0; 
          System.out.println("query "+query);
        while(i<results.size()) {  
            if(((String)results.get(i)).startsWith(query))  
            {  System.out.println("nom "+results.get(i));
                suggestions.add(results.get(i)); 
            
            }
            i++;
        }  
          
        return suggestions; 
          
         
    }  
    
     public List<String> completePrenomAuteur(String query) {  
        List<String> results = new ArrayList<String>();  
          
       
       for(int i=0; i<l.size() ;i++)
       {
           results.add(((Auteur)l.get(i)).getPrenomAut());
       }
       
            
          List<String> suggestions = new ArrayList<String>();  
         int i=0; 
          System.out.println("query "+query);
        while(i<results.size()) {  
            if(((String)results.get(i)).startsWith(query))  
            {  System.out.println("prenom "+results.get(i));
                suggestions.add(results.get(i)); 
            
            }
            i++;
        }  
          
        return suggestions; 
          
         
    } 
       public List<String> completeNomEditeur(String query) {  
        List<String> results = new ArrayList<String>();  
          
       
       for(int i=0; i<led.size() ;i++)
       {
           results.add(((Editeur)led.get(i)).getNomEd());
       }
       
            
          List<String> suggestions = new ArrayList<String>();  
         int i=0; 
          System.out.println("query "+query);
        while(i<results.size()) {  
            if(((String)results.get(i)).startsWith(query))  
            {  System.out.println("nom "+results.get(i));
                suggestions.add(results.get(i)); 
            
            }
            i++;
        }  
          
        return suggestions; 
          
         
    }  
       
        public List<String> completePrenomEditeur(String query) {  
        List<String> results = new ArrayList<String>();  
          
       
       for(int i=0; i<led.size() ;i++)
       {
           results.add(((Editeur)led.get(i)).getPrenomEd());
       }
       
            
          List<String> suggestions = new ArrayList<String>();  
         int i=0; 
          System.out.println("query "+query);
        while(i<results.size()) {  
            if(((String)results.get(i)).startsWith(query))  
            {  System.out.println("prenom "+results.get(i));
                suggestions.add(results.get(i)); 
            
            }
            i++;
        }  
          
        return suggestions; 
          
         
    } 
     public boolean displayPanelEditeur()
    { System.out.println("type "+type);
        if(type==null)
            return false;
        else
        { 
            if(type.equals("Inbook")||type.equals("Conference")||type.equals("Livre")||type.equals("Collection"))
                return true;
            else
                return false;
        }
    }
    
     public boolean displayPanelArticle()
    { System.out.println("type "+type);
        if(type==null)
            return false;
        else
        { 
            if(type.equals("Article"))
                return true;
            else
                return false;
        }
    }
     public boolean displayPanelBrochure()
    { System.out.println("type "+type);
        if(type==null)
            return false;
        else
        { 
            if(type.equals("Brochure"))
                return true;
            else
                return false;
        }
    }
      public boolean displayPanelInbook()
    { System.out.println("type "+type);
        if(type==null)
            return false;
        else
        { 
            if(type.equals("Inbook"))
                return true;
            else
                return false;
        }
    }
       public boolean displayPanelConference()
    { System.out.println("type "+type);
        if(type==null)
            return false;
        else
        { 
            if(type.equals("Conference"))
                return true;
            else
                return false;
        }
    }
        public boolean displayPanelLivre()
    { System.out.println("type "+type);
        if(type==null)
            return false;
        else
        { 
            if(type.equals("Livre"))
                return true;
            else
                return false;
        }
    }
         public boolean displayPanelCollection()
    { System.out.println("type "+type);
        if(type==null)
            return false;
        else
        { 
            if(type.equals("Collection"))
                return true;
            else
                return false;
        }
    }
          public boolean displayPanelDivers()
    { System.out.println("type "+type);
        if(type==null)
            return false;
        else
        { 
            if(type.equals("Divers"))
                return true;
            else
                return false;
        }
    }
           public boolean displayPanelDoc()
    { System.out.println("type "+type);
        if(type==null)
            return false;
        else
        { 
            if(type.equals("Doc"))
                return true;
            else
                return false;
        }
    }
            public boolean displayPanelRapport()
    { System.out.println("type "+type);
        if(type==null)
            return false;
        else
        { 
            if(type.equals("Rapport"))
                return true;
            else
                return false;
        }
    }
            public void testmethode()
            {
                System.out.println("test methode");
                displayPanelArticle();
                displayPanelBrochure();
                displayPanelCollection();
                displayPanelConference();
                displayPanelDivers();
                displayPanelDoc();
                displayPanelEditeur();
                displayPanelInbook();
                displayPanelLivre();
                displayPanelRapport();
            }
    public void autrechamps()
    {
        System.out.println("champs sup");
       for(int i=0;i<champssup.size();i++)
       {
           System.out.println(champssup.get(i));
       }
       for(int i=0;i<champssup1.size();i++)
       {
           System.out.println(champssup1.get(i));
       }
       for(int i=0;i<champssup2.size();i++)
       {
           System.out.println(champssup2.get(i));
       }
    }
    
     public void addPanelAuteur()
     {   
         //testauteur.set(testauteur.size()-1, null);
         testauteur.add(new Auteur());
         System.out.println ("test "+testauteur);
        /* auteurs.set(auteurs.size()-1, autdao.AuteurPub(l,nomAuteur, prenomAuteur));
         auteurs.add(autdao.AuteurPub(l,"", ""));*/
          /* Auteur a=new Auteur();
     auteurs.add(autdao.AuteurPub(l,a.getNomAut(), a.getPrenomAut()));*/
         System.out.println("size "+ auteurs);
     }
     public void removePanelAuteur()
     {
          if(testauteur.size()==1)
         {
           FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_WARN, "Vous devez indiquer un auteur", "Vous devez indiquer un auteur");
                FacesContext.getCurrentInstance().addMessage(null, error);
           
         }
          else
         testauteur.remove(testauteur.size()-1);
         
         
     }
     public String insert()
    { 
        System.out.println("titre "+titre);
        
          if(type==null)
        {
            
             FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_WARN, "Vous devez indiquer le type de la publication", "Vous devez indiquer le type de la publication");
                FacesContext.getCurrentInstance().addMessage(null, error);
        return "";
        }
         
        
        
       
            System.out.println("insertion");
            int v=0,n=0,pd=0,pf=0;
            if(volumeA!=null)
                
                if(!volumeA.equals(""))
                v=new Integer(volumeA);
            if(nombreA!=null)
            if(!nombreA.equals(""))
                n=new Integer(nombreA);
            if(pagedebA!=null)
                
                if(!pagedebA.equals(""))
                pd=new Integer(pagedebA);
            if(pagefinA!=null)
            { 
                if(!pagefinA.equals(""))
                pf=new Integer(pagefinA);
            }
              if(volumeI!=null)
                
                if(!volumeI.equals(""))
                v=new Integer(volumeI);
            
            if(pagedebC!=null)
                
                if(!pagedebC.equals(""))
                pd=new Integer(pagedebC);
            if(pagefinC!=null)
            { 
                if(!pagefinC.equals(""))
                pf=new Integer(pagefinC);
            }
              if(volumeL!=null)
                
                if(!volumeL.equals(""))
                v=new Integer(volumeL);
            
            if(pagedebCol!=null)
                
                if(!pagedebCol.equals(""))
                pd=new Integer(pagedebCol);
            if(pagefinCol!=null)
            { 
                if(!pagefinCol.equals(""))
                pf=new Integer(pagefinCol);
            }
             
            if(pagedebI!=null)
                
                if(!pagedebI.equals(""))
                pd=new Integer(pagedebI);
            if(pagefinI!=null)
            { 
                if(!pagefinI.equals(""))
                pf=new Integer(pagefinI);
            }
            if(pd>pf)
            {
              FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_WARN, "Pages invalides", "Pages invalides");
                FacesContext.getCurrentInstance().addMessage(null, error);
       return "";   
            }
          String existe=  publicationFacade.ExistePublication(titre);
          System.out.println("existe "+existe);
          if(!existe.equals("")&&!existe.equals("inconnu"))
          {
              FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_WARN, "La publication a été déjà inserée par "+existe, "La publication a été déjà inserée par "+existe);
                FacesContext.getCurrentInstance().addMessage(null, error);
       return "";
          }
          Publication p=new Publication();
          p.setTitre(titre);
          p.setMois(Integer.parseInt(mois));
          p.setAnnee(Integer.parseInt(annee));
          p.setIdCh(ch);
          p.setType(type);
          if(type.equals("Article"))
          {
              p.setJournal(journal);
              p.setVolume(v);
              p.setNombre(n);
              p.setPagedeb(pd);
              p.setPagefin(pf);
          }
           if(type.equals("Rapport"))
          {
              p.setEtablissement(etablissementR);
              p.setAdresse(adresseR);
              p.setTypeRapport(typeR);
          }
            if(type.equals("Doc"))
          {
              p.setEdition(editionD);
              p.setAdresse(adresseD);
              p.setOrganisation(organisationD);
          }
             if(type.equals("Divers"))
          {
              p.setHowpub(howpubDiv);
          }
              if(type.equals("Collection"))
          {
              p.setEdition(editionCol);
              p.setAdresse(adresseCol);
              p.setBooktitle(booktitleCol);
              p.setPagedeb(pd);
              p.setPagefin(pf);
          }
               if(type.equals("Livre"))
                   
          {
              p.setEdition(editionL);
              p.setAdresse(adresseL);
              p.setSerie(serieL);
              p.setVolume(v);
          }
                if(type.equals("Conference"))
          {
              p.setEdition(editionC);
              p.setAdresse(adresseC);
              p.setOrganisation(organisationC);
              p.setBooktitle(booktitleC);
              p.setPagedeb(pd);
              p.setPagefin(pf);
          }
                 if(type.equals("Inbook"))
          {
              p.setEdition(editionI);
              p.setAdresse(adresseI);
              p.setSerie(serieI);
              p.setVolume(v);
              p.setChapitre(chapitreI);
               p.setPagedeb(pd);
              p.setPagefin(pf);
          }
                  if(type.equals("Brochure"))
          {
           p.setAdresse(adresseB);
                 p.setHowpub(howpubB);
          }
          else{
            System.out.println("avant indertion");
         
        System.out.println("titre "+titre);
        /*if(((Auteur)auteurs.get(auteurs.size()-1)).getNomAut().equals("") &&!nomAuteur.equals("") )
              //auteurs.remove(auteurs.size()-1);
             auteurs.set(auteurs.size()-1, autdao.AuteurPub(l,nomAuteur, prenomAuteur));*/
        auteurFacade.ajoutNouveauAuteur(testauteur,  l);
        if(nomed!=null&&prenomed!=null)
        {if(!editeurFacade.EditeurPub( led, nomed, prenomed))
         editeurFacade.ajoutNouveauEditeur(nomed, prenomed);
        }
                      //System.out.println("l "+l);
                      System.out.println("test aut"+l);
      for(int i=0;i<testauteur.size();i++)
      {  System.out.println("id aut "+((Auteur)l.get(l.indexOf(testauteur.get(i)))).getIdAut());
      testauteur.get(i).setIdAut(((Auteur)l.get(l.indexOf(testauteur.get(i)))).getIdAut());
      }
      // publicationFacade.associerEcrire(testauteur, p);
                   //   System.out.println("ecrire "+ p.getEcrireList());
              publicationFacade.insert(p);
       publicationFacade.associerEcrire(testauteur, p);
                     System.out.println("list publication "+auteurFacade.listpublicationByChercheur(ch));
        FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_INFO, "La publication a été enregistré ", "La publication a été enregistré");
                FacesContext.getCurrentInstance().addMessage(null, error);
                /*RequestContext context = RequestContext.getCurrentInstance();
                context.update("panellist");*/
                ///PublicationController pubcontroller=new PublicationController();
                //pubcontroller.miseAJourListPub(p);
               /* List pubupdate=pubcontroller.getListpublication();
                      System.out.println("list "+pubupdate);
                      System.out.println("test pub "+((Publication)pubupdate.get(0)).getAnnee());
                int i=0;
                while (i<pubupdate.size()&&((Publication)pubupdate.get(i)).getAnnee().intValue()>p.getAnnee().intValue())
                {
                    i++;
                }
                if(p.getAnnee().intValue()>((Publication)pubupdate.get(i)).getAnnee().intValue())
                pubupdate.add(i, p);
                else
                {
                    while (((Publication)pubupdate.get(i)).getAnnee().intValue()==p.getAnnee().intValue()&&((Publication)pubupdate.get(i)).getMois().intValue()>p.getMois().intValue())
                {
                 i++;   
                }
                 pubupdate.add(i, p);
                }
                pubcontroller.setListpublication(pubupdate);
                      System.out.println("pubupdate "+pubcontroller.getListpublication());*/
               /* pubcontroller.genererlistpublication();*/
    return "";
                // return "Succes";
          }
                  return "";
                       
    }
     
}
