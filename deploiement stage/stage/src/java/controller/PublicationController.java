/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Chercheur;
import entity.Publication;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import session.AuteurFacade;

/**
 *
 * @author USER1
 */
@ManagedBean
@SessionScoped
public class PublicationController implements Serializable{
    @EJB
    private AuteurFacade auteurFacade;

    /**
     * Creates a new instance of PublicationController
     */
    private List<Publication> listpublication=new ArrayList<Publication>(); 
    private Chercheur ch;
private List listanneepubrendered=new ArrayList();
    public List<Publication> getListpublication() {
        return listpublication;
    }

    public void setListpublication(List<Publication> listpublication) {
        this.listpublication = listpublication;
    }

    public Chercheur getCh() {
        return ch;
    }

    public void setCh(Chercheur ch) {
        this.ch = ch;
    }

    public List getListanneepubrendered() {
        return listanneepubrendered;
    }

    public void setListanneepubrendered(List listanneepubrendered) {
        this.listanneepubrendered = listanneepubrendered;
    }
    
    
    
    
    
    
    
    
    public PublicationController() {
    }
    
    
     @PostConstruct
    public void genererlistpublication()
    {
         FacesContext facesContext = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
       ch=(Chercheur) session.getAttribute("user");
        if(ch!=null)
        {
         listpublication=auteurFacade.listpublicationByChercheur(ch);
            System.out.println("list pub de "+ch+listpublication);
           /* int i=0;int k=0;
            while(i<listpublication.size())
            {
                
                if(((Publication)listpublication.get(i)).getAnnee()==((Publication)listpublication.get(i+1)).getAnnee())
                { listanneepubrendered.add(k,true);
                    listanneepubrendered.add(k+1,false);
                k=k+2;}
                else
                {  listanneepubrendered.add(k,true );k++;}
                i++;
             
            }*/
             int k=0;
              listanneepubrendered.add(true);
              if(listpublication!=null)
              { while(k<listpublication.size())
           {
               int j=k+1;
               while(j<listpublication.size()&&((Publication)listpublication.get(k)).getAnnee().equals(((Publication)listpublication.get(j)).getAnnee()))
               {
                   //((Publication)listpub.get(j)).setNombre(0);
                   listanneepubrendered.add(false);
                   j++;
               }
               k=j;
               listanneepubrendered.add(true);
           }
              }
           System.out.println("renderedsize "+listanneepubrendered.size());
            System.out.println("rendered "+listanneepubrendered);
            
    }
    }   
     
     
     
     
      public void genererlistpublicationtest()
    {
         FacesContext facesContext = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
       ch=(Chercheur) session.getAttribute("user");
        if(ch!=null)
        {
         listpublication=auteurFacade.listpublicationByChercheur(ch);
            System.out.println("list pub de "+ch+listpublication);
           /* int i=0;int k=0;
            while(i<listpublication.size())
            {
                
                if(((Publication)listpublication.get(i)).getAnnee()==((Publication)listpublication.get(i+1)).getAnnee())
                { listanneepubrendered.add(k,true);
                    listanneepubrendered.add(k+1,false);
                k=k+2;}
                else
                {  listanneepubrendered.add(k,true );k++;}
                i++;
             
            }*/
             int k=0;
              listanneepubrendered.add(true);
              if(listpublication!=null)
              { while(k<listpublication.size())
           {
               int j=k+1;
               while(j<listpublication.size()&&((Publication)listpublication.get(k)).getAnnee().equals(((Publication)listpublication.get(j)).getAnnee()))
               {
                   //((Publication)listpub.get(j)).setNombre(0);
                   listanneepubrendered.add(false);
                   j++;
               }
               k=j;
               listanneepubrendered.add(true);
           }
              }
           System.out.println("renderedsize "+listanneepubrendered.size());
            System.out.println("rendered "+listanneepubrendered);
            
    }
    }   
     
    public String redirectAddPublication()
    {
        return "ajoutPublication";
    } 
    
    public void miseAJourListPub(Publication p)
    { 
            System.out.println("list "+listpublication);
                      System.out.println("test pub "+((Publication)listpublication.get(0)).getAnnee());
                int i=0;
                while (i<listpublication.size()&&((Publication)listpublication.get(i)).getAnnee().intValue()>p.getAnnee().intValue())
                {
                    i++;
                }
                if(p.getAnnee().intValue()>((Publication)listpublication.get(i)).getAnnee().intValue())
                listpublication.add(i, p);
                else
                {
                    while (((Publication)listpublication.get(i)).getAnnee().intValue()==p.getAnnee().intValue()&&((Publication)listpublication.get(i)).getMois().intValue()>p.getMois().intValue())
                {
                 i++;   
                }
                 listpublication.add(i, p);
                }
              
    }
    
}
