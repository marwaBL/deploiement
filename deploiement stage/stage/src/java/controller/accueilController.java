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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import session.AuteurFacade;
import session.ChercheurFacade;

/**
 *
 * @author USER1
 */
@ManagedBean
@SessionScoped
public class accueilController implements Serializable {
    @EJB
    private ChercheurFacade chercheurFacade;
    @EJB
    private AuteurFacade auteurFacade;
    
     private StreamedContent image;
private Chercheur ch;
private List listPub=new ArrayList();
private List listchercheur;
    /**
     * Creates a new instance of accueilController
     */
    public List getListPub() {
        return listPub;
    }

    public void setListPub(List listPub) {
        this.listPub = listPub;
    }

    public List getListchercheur() {
        return listchercheur;
    }

    public void setListchercheur(List listchercheur) {
        this.listchercheur = listchercheur;
    }




    public accueilController()  {
        FacesContext facesContext = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
       ch=(Chercheur) session.getAttribute("user");
        if(ch!=null)
        {
        //  genereraccueil();
           // System.out.println("ss "+ch.getCode());
          
        
        }
        
    }
    @PostConstruct
    public void genereraccueil()
    {
         FacesContext facesContext = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
       ch=(Chercheur) session.getAttribute("user");
        if(ch!=null)
        {
         System.out.println("ss "+ch.getCode());
         List l=new ArrayList();
         for (int i=0;i<ch.getCode().getChercheurList().size();i++)
             l.add(ch.getCode().getChercheurList().get(i).getIdCh());
         System.out.println("list cher "+l);
         listPub=auteurFacade.listauteur(l);
       //  System.out.println("pub "+auteurFacade.listauteur(l));
         listchercheur=chercheurFacade.RecentInscription(ch.getCode().getChercheurList());
         System.out.println("chercheur "+listchercheur);
            System.out.println("list pub de "+ch+auteurFacade.listpublicationByChercheur(ch));
    }
    }   
    
    public String redirectPublication()
    {
       PublicationController pub =new PublicationController();
      // pub.genererlistpublicationtest();
        return "publication";
    }
    
      public StreamedContent getImage() {
       FacesContext  fc=     FacesContext.getCurrentInstance();
if(fc.getCurrentPhaseId()== PhaseId.RENDER_RESPONSE)
{
    return new DefaultStreamedContent();
}
 String chemin;      
byte[] bytes=new byte[1024];
if(ch==null){ chemin="C:/Users/USER1/Desktop/images/profil.png";}
else {
    chemin=ch.getPhoto();
}
        try {
            FileInputStream fis = new FileInputStream(new File(chemin));

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] buf = new byte[1024];

            for (int readNum; (readNum = fis.read(buf)) != -1;) {

                bos.write(buf, 0, readNum);     
           //  System.out.println("read " + readNum + " bytes,");

            }
 bytes = bos.toByteArray();
        } catch (IOException ex) {

        }



    /*   String path=fc.getExternalContext().getRequestParameterMap().get("photo");
       byte[]photodata=org.apache.commons.io.FileUtils.readFileToByteArray(new File(path));*/
       return new DefaultStreamedContent(new ByteArrayInputStream(bytes));
        
    }

    public void setImage(StreamedContent image) {
        this.image = image;
    }
   public String redirectEncadrementMaster()
    {
        return "Master";
    }  
   public String redirectionModifierProfil()
   {
       return "modifierProfile";
   }
    public String redirectionMembreActifCorpsA()
   {
       return "actifCorpsA";
   }
     public String redirectionMembreActifCorpsB()
   {
       return "actifCorpsB";
   }
     public String redirectionMembreActifMaster()
   {
       return "actifMaster";
   }
   public void handleFileUpload( FileUploadEvent event) {
    	 boolean changerphoto=false;
     String path;  
       System.out.println("file upload");
    	 if(event!=null)
         {   // uploadedFile=event.getFile(); 
            
    	path= event.getFile().getFileName();
    		changerphoto=true;
       getImage();
            ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
            
           
            
            File result = new File(path);
            System.out.println(path);

            try {
                FileOutputStream fileOutputStream = new FileOutputStream(result);

                byte[] buffer = new byte[1024];

                int bulk;
                InputStream inputStream = event.getFile().getInputstream();
                while (true) {
                    bulk = inputStream.read(buffer);
                    if (bulk < 0) {
                        break;
                    }
                    fileOutputStream.write(buffer, 0, bulk);
                    fileOutputStream.flush();
                }

                fileOutputStream.close();
                inputStream.close();
ch.setPhoto(path);
                FacesMessage msg = 
                            new FacesMessage("File Uploaded", "photo mise à jour");
                FacesContext.getCurrentInstance().addMessage(null, msg);
               // DaoUpload dao = new DaoUpload();
               // dao.savedatainDB();
                /*UploadController u = new UploadController();
                u.savedatainDB();*/

            } catch (IOException e) {
                e.printStackTrace();

                FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Probléme lors du téléchargement", "");
                FacesContext.getCurrentInstance().addMessage(null, error);
            }
    }
    }
}
