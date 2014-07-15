/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Chercheur;
import entity.Inscription;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import session.ChercheurFacade;
import session.InscriptionFacade;

/**
 *
 * @author USER1
 */
@ManagedBean
@SessionScoped
public class validationController implements Serializable {
    @EJB
    private ChercheurFacade chercheurFacade;
    @EJB
    private InscriptionFacade inscriptionFacade;
    private int nbdemande;
    private boolean  disable;
private List <Chercheur> listValidation=new ArrayList<Chercheur>();
    private Chercheur ch;
    private StreamedContent image;
     private Chercheur chselected;

    public int getNbdemande() {
        return nbdemande;
    }

    public void setNbdemande(int nbdemande) {
        this.nbdemande = nbdemande;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

     
     
     
     
    public List<Chercheur> getListValidation() {
        return listValidation;
    }

    public void setListValidation(List<Chercheur> listValidation) {
        this.listValidation = listValidation;
    }

    public Chercheur getChselected() {
        return chselected;
    }

    public void setChselected(Chercheur chselected) {
        this.chselected = chselected;
    }
    
    
     public StreamedContent getImage() {
      
     FacesContext  fc=     FacesContext.getCurrentInstance();
if(fc.getCurrentPhaseId()== PhaseId.RENDER_RESPONSE)
{
    return new DefaultStreamedContent();
}
       
byte[] bytes=new byte[1024];
if(chselected!=null){
        try {FileInputStream fis = new FileInputStream(new File(chselected.getPhoto()));

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] buf = new byte[1024];

            for (int readNum; (readNum = fis.read(buf)) != -1;) {

                bos.write(buf, 0, readNum);     
           //  System.out.println("read " + readNum + " bytes,");

            }
 bytes = bos.toByteArray();
        } catch (IOException ex) {

        }

}

    /*   String path=fc.getExternalContext().getRequestParameterMap().get("photo");
       byte[]photodata=org.apache.commons.io.FileUtils.readFileToByteArray(new File(path));*/
       return new DefaultStreamedContent(new ByteArrayInputStream(bytes));
        
        
    }

    public void setImage(StreamedContent image) {
        this.image = image;
    }
    
    
    public validationController() {
        
        
        
        
    }
     @PostConstruct
    public void genererListValidation()
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
       ch=(Chercheur) session.getAttribute("user");
        if(ch!=null)
        {
     List <Inscription> l=inscriptionFacade.listInscriptionInvalide(ch.getCode());
            System.out.println("list "+l);
     for(int i=0;i<l.size();i++)
     {
       listValidation.add(((Inscription)l.get(i)).getChercheur());
     }
     nbdemande=listValidation.size();
     if(nbdemande!=0)
     {
         disable=true;
     }
     else
         disable=false;
        }
    }
     
     public void valider()
     {
         if(chselected!=null)
         {
             System.out.println("valider "+chselected);
             inscriptionFacade.validerInscription(chselected);
             listValidation.remove(chselected);
             nbdemande=listValidation.size();
               RequestContext context = RequestContext.getCurrentInstance(); 
  FacesContext facesContext = FacesContext.getCurrentInstance();
    FacesMessage msg = null;  
    boolean loggedIn = false;  
              loggedIn = false; 
         msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Validation", "L'inscription de "+chselected+" a été validé");
         //    res= "welcomePrimefaces";
              FacesContext.getCurrentInstance().addMessage(null, msg);  
    context.addCallbackParam("loggedIn", loggedIn); 
            
         }
     }
     
     public void refuser()
     {
         if(chselected!=null)
         {
             System.out.println("valider "+chselected);
            chercheurFacade.refuserInscription(chselected);
             listValidation.remove(chselected);
             nbdemande=listValidation.size();
              RequestContext context = RequestContext.getCurrentInstance(); 
  FacesContext facesContext = FacesContext.getCurrentInstance();
    FacesMessage msg = null;  
    boolean loggedIn = false;  
              loggedIn = false; 
         msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur de validation", "L'inscrption de "+chselected+" a été refusé");
         //    res= "welcomePrimefaces";
              FacesContext.getCurrentInstance().addMessage(null, msg);  
    context.addCallbackParam("loggedIn", loggedIn); 
            
         }
     }
     
   
     public String redirectionValidation()
     {
         System.out.println("validation");
         return "validation";
     }
}
