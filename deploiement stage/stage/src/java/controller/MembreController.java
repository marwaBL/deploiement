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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpSession;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author USER1
 */
@ManagedBean
@SessionScoped
public class MembreController implements Serializable{

   private Chercheur ch;
   private List <Chercheur> membreActifsCorpsA=new ArrayList <Chercheur>();
    private StreamedContent image;
    private Chercheur chselected;
    private String color;
    private List <Chercheur> membreActifsCorpsB=new ArrayList <Chercheur>();
    private StreamedContent imageb;
    private Chercheur chselectedb;

      
    private List <Chercheur> membreActifsMaster=new ArrayList <Chercheur>();
    private StreamedContent imagem;
    private Chercheur chselectedm;

    public String getColor() {
        for(int i=0;i<membreActifsMaster.size();i++)
        {
            if(((Chercheur)membreActifsMaster.get(i)).getAvancement().intValue()==99)
                return "bleucolor";
            else
                return "griscolor";
        }
        
        return "griscolor";
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Chercheur> getMembreActifsMaster() {
        return membreActifsMaster;
    }

    public void setMembreActifsMaster(List<Chercheur> membreActifsMaster) {
        this.membreActifsMaster = membreActifsMaster;
    }

    public Chercheur getChselectedm() {
        return chselectedm;
    }

    public void setChselectedm(Chercheur chselectedm) {
        this.chselectedm = chselectedm;
    }
    
    
    
    
    public List<Chercheur> getMembreActifsCorpsB() {
        return membreActifsCorpsB;
    }

    public void setMembreActifsCorpsB(List<Chercheur> membreActifsCorpsB) {
        this.membreActifsCorpsB = membreActifsCorpsB;
    }

    public Chercheur getChselectedb() {
        return chselectedb;
    }

    public void setChselectedb(Chercheur chselectedb) {
        this.chselectedb = chselectedb;
    }

    
    
    
    public Chercheur getChselected() {
        return chselected;
    }

    public void setChselected(Chercheur chselected) {
        this.chselected = chselected;
    }

    public List<Chercheur> getMembreActifsCorpsA() {
        return membreActifsCorpsA;
    }

    public void setMembreActifsCorpsA(List<Chercheur> membreActifsCorpsA) {
        this.membreActifsCorpsA = membreActifsCorpsA;
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
    
   
      public StreamedContent getImagem() {
      
     FacesContext  fc=     FacesContext.getCurrentInstance();
if(fc.getCurrentPhaseId()== PhaseId.RENDER_RESPONSE)
{
    return new DefaultStreamedContent();
}
       
byte[] bytes=new byte[1024];
if(chselectedm!=null){
        try {FileInputStream fis = new FileInputStream(new File(chselectedm.getPhoto()));

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

    public void setImagem(StreamedContent image) {
        this.image = image;
    }
    
    
    
    
    
    
     public StreamedContent getImageb() {
      
     FacesContext  fc=     FacesContext.getCurrentInstance();
if(fc.getCurrentPhaseId()== PhaseId.RENDER_RESPONSE)
{
    return new DefaultStreamedContent();
}
       
byte[] bytes=new byte[1024];
if(chselectedb!=null){
        try {FileInputStream fis = new FileInputStream(new File(chselectedb.getPhoto()));

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

    public void setImageb(StreamedContent image) {
        this.image = image;
    }
    
    
    
   public MembreController() {
       //membreActifsCorpsA();
    }
    
 @PostConstruct
      public void membreActifsCorpsA()
        {
            
           List listprof =new ArrayList();
           List listMC=new ArrayList();
           List listMA =new ArrayList();
           List listA=new ArrayList();
           
                FacesContext facesContext = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
       ch=(Chercheur) session.getAttribute("user");
       
        if(ch!=null)
        {
          if(ch.getIdCh().equals(ch.getCode().getIdCh().getIdCh()))
          {    System.out.println("ch est directeur "+ch);
           
        List l= ch.getCode().getChercheurList();
        
        for (int i=0;i<l.size();i++)
        {
            if(((Chercheur)l.get(i)).getGradeCh()!=null)
            {
                 if((((Chercheur)l.get(i)).getEtat().equals("active"))&&(((Chercheur)l.get(i)).getGradeCh().equals("Professeur")))
                 {
                   listprof.add(((Chercheur)l.get(i)));
                 }
                   if((((Chercheur)l.get(i)).getEtat().equals("active"))&&( ((Chercheur)l.get(i)).getGradeCh().equals("Maitre de conference")))
                 {
                    listMC.add(((Chercheur)l.get(i)));
                 }
                      if((((Chercheur)l.get(i)).getEtat().equals("active"))&&( ((Chercheur)l.get(i)).getGradeCh().equals("Maitre assistant")))
                 {
                    listMA.add(((Chercheur)l.get(i)));
                 }
                         if((((Chercheur)l.get(i)).getEtat().equals("active"))&&( ((Chercheur)l.get(i)).getGradeCh().equals("Assistant")))
                 {
                    listA.add(((Chercheur)l.get(i)));
                 }
            }
            if(((Chercheur)l.get(i)).getTypeCh()!=null)
            {
               if((((Chercheur)l.get(i)).getEtat().equals("active"))&&( ((Chercheur)l.get(i)).getTypeCh().equals("Etudiant en Master")))
                 {
                    membreActifsMaster.add(((Chercheur)l.get(i)));
                 }  
            }
            }
         membreActifsCorpsA.addAll(listprof);
          membreActifsCorpsA.addAll(listMC);
          membreActifsCorpsB.addAll(listMA);
          membreActifsCorpsB.addAll(listA);
         System.out.println("corp a "+membreActifsCorpsA);
              System.out.println("corps b "+membreActifsCorpsB);
              System.out.println("master "+ membreActifsMaster);
        }
         
          }
        }
        
    public void Miseajour()
    {
        if(chselectedm!=null)
        {
            System.out.println("avanc "+chselectedm.getAvancement());
        }
    }
    
}
