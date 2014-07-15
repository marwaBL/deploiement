/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Chercheur;
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
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import session.ChercheurFacade;

/**
 *
 * @author USER1
 */
@ManagedBean
@SessionScoped
public class encadrementMaster implements Serializable{
    @EJB
    private ChercheurFacade chercheurFacade;

   private Chercheur chselected;
   private String type="En cours";
     List<Chercheur> listeencadmaster = new ArrayList<Chercheur> ();
    private Chercheur ch;
     ArrayList listimage =new ArrayList();
      private StreamedContent image;
    
    
    
    
    public encadrementMaster() {
    }

    public List<Chercheur> getListeencadmaster() {
        return listeencadmaster;
    }

    public void setListeencadmaster(List<Chercheur> listeencadmaster) {
        this.listeencadmaster = listeencadmaster;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
     public ArrayList getListimage() {
        return listimage;
    }

    public void setListimage(ArrayList listimage) {
        this.listimage = listimage;
    }
    
    
    
    
     public void remplirListImage() {
         FacesContext  fc=     FacesContext.getCurrentInstance();
if(fc.getCurrentPhaseId()== PhaseId.RENDER_RESPONSE)
{
   listimage.add(new DefaultStreamedContent());
}
          
byte[] bytes=new byte[1024];
for(int i=0;i<listeencadmaster.size();i++){
        try {FileInputStream fis = new FileInputStream(new File(((Chercheur)listeencadmaster.get(i)).getPhoto()));

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] buf = new byte[1024];

            for (int readNum; (readNum = fis.read(buf)) != -1;) {

                bos.write(buf, 0, readNum);     
           //  System.out.println("read " + readNum + " bytes,");

            }
 bytes = bos.toByteArray();
        } catch (IOException ex) {

        }
         listimage.add( new DefaultStreamedContent(new ByteArrayInputStream(bytes)));
   }

    /*   String path=fc.getExternalContext().getRequestParameterMap().get("photo");
       byte[]photodata=org.apache.commons.io.FileUtils.readFileToByteArray(new File(path));*/
   
        
        
    }

    
    

    public StreamedContent getImage() {
         FacesContext  fc=     FacesContext.getCurrentInstance();
if(fc.getCurrentPhaseId()== PhaseId.RENDER_RESPONSE)
{
    return new DefaultStreamedContent();
}
    System.out.println("selected "+chselected);       
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






    public Chercheur getChselected() {
        return chselected;
    }

    public void setChselected(Chercheur chselected) {
        this.chselected = chselected;
    }




    
    
    @PostConstruct
    public void genererlistEncadrement()
    {
         FacesContext facesContext = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
       ch=(Chercheur) session.getAttribute("user");
        System.out.println("type "+type);
        if(ch!=null)
        {
   listeencadmaster= chercheurFacade.listEncadrementMaster(ch,type);
            System.out.println("liste "+listeencadmaster);
            remplirListImage();
            
    }
    }
   
    public String test ()
    {
        System.out.println("test ");
        return "";
    }
    public void valider()
{
    System.out.println(" valider selected "+chselected);
    if(chselected!=null)
   { System.out.println("selection "+chselected.getAvancement());
chercheurFacade.update(chselected);
  
  
   FacesMessage msg = null; 
         boolean loggedIn = false; 
          RequestContext context = RequestContext.getCurrentInstance();  
     msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Chercheur mis à jour ", "Chercheur mis à jour");
		// pageresult= "/erreur";
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn); 
                
   
        }
else
    
{
    System.out.println("null");
     FacesMessage msg = null; 
         boolean loggedIn = false; 
          RequestContext context = RequestContext.getCurrentInstance();  
     msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur ", "Probleme");
		// pageresult= "/erreur";
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn); 
                      
}
}
     
    
}
