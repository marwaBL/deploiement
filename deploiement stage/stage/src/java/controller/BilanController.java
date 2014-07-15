/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Chercheur;
import entity.Publication;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.type.OrientationEnum;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import session.AuteurFacade;

/**
 *
 * @author USER1
 */
@ManagedBean
@SessionScoped
public class BilanController implements Serializable {
    @EJB
    private AuteurFacade auteurFacade;

    private Chercheur ch;
    public BilanController() {
    }
    
      public void genererBilan()
        {
            
            try {
                FacesContext facesContext = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
       ch=(Chercheur) session.getAttribute("user");
       
        if(ch!=null)
        {
          if(ch.getIdCh().equals(ch.getCode().getIdCh().getIdCh()))
          {    System.out.println("ch est directeur "+ch);
            ArrayList list =new ArrayList();
            list.add(ch.getCode());
            ///list.add(ch.getCode().getChercheurList());
            
            
        
                JRBeanCollectionDataSource jRBeanCollectionDataSource=new JRBeanCollectionDataSource(list,false);
    
            
            String reportpath=   FacesContext.getCurrentInstance().getExternalContext().getRealPath("Bilan.jasper");
       /* String subreportpath=   FacesContext.getCurrentInstance().getExternalContext().getRealPath("Bilan_subreport1.jasper");
       
            JasperReport subreport = (JasperReport) JRLoader.loadObject(subreportpath); */
           
             HashMap hm=new HashMap();
             
             
             
                List listprofesseur=new ArrayList();
        List listmaitreConference=new ArrayList();
        List listmaitreAssistant=new ArrayList();
        List listassistant=new ArrayList();
        List listmaster=new ArrayList();
        List listdoctorant=new ArrayList();
       List l= ch.getCode().getChercheurList();
              System.out.println(" list ch "+l);
       for(int i=0;i<l.size();i++)
       {
           if(((Chercheur)l.get(i)).getGradeCh()!=null)
           {   System.out.println("gr "+((Chercheur)l.get(i)).getGradeCh());
         if(((Chercheur)l.get(i)).getGradeCh().equals("Professeur"))
         {
             listprofesseur.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getGradeCh().equals("Maitre de conference"))
         {
             listmaitreConference.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getGradeCh().equals("Maitre Assistant"))
         {
             listmaitreAssistant.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getGradeCh().equals("Assistant"))
         {
             listassistant.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getTypeCh().equals("Etudiant en Master"))
         {
             listmaster.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getTypeCh().equals("Doctorant"))
         {
             listdoctorant.add((Chercheur)l.get(i));
         }
           }
       }
              System.out.println("prof "+listprofesseur);
      List listtot = new ArrayList();
       List listtot2 = new ArrayList();
       List listtot3 = new ArrayList();
      listtot.addAll(listprofesseur);
      listtot.addAll(listmaitreConference);
     listtot2.addAll(listmaitreAssistant);
      listtot2.addAll(listassistant);
      listtot3.addAll(listdoctorant);
      //listtot.addAll(listmaster);
      hm.put("list", listtot);
            
            // hm.put("subreport", subreport);
             hm.put("Universite",ch.getCode().getCodeEtab().getCodeUniv().getLibUniv());
                hm.put("Etablissement",ch.getCode().getCodeEtab().getLibEtab());
                   hm.put("Denomination",ch.getCode().getDenomination());
                   hm.put("Code",ch.getCode().getCode());
                      hm.put("Discipline",ch.getCode().getDiscipline());
                   hm.put("Responsable",ch.getPrenomCh()+" "+ch.getNomCh());
                      hm.put("Grade",ch.getGradeCh());
                         hm.put("Fonction",ch.getFonctionCh());
                     /* hm.put("Tel",ch.);
                         hm.put("Fax",libetabgrade);*/
                            hm.put("Mobile",ch.getTelCh());
                               hm.put("Email",ch.getEmailCh());
                                  hm.put("Site",ch.getCode().getSite());
                         String[] test={"gradeCh","nomCh","prenomCh","cinCh"};  
                         System.out.println("tot "+listtot2);
             TestJRDataSource jRBeanCollectionDataSources=new TestJRDataSource(listtot2,test);
              System.out.println("data source "+jRBeanCollectionDataSources);
     hm.put("subreport1", jRBeanCollectionDataSources);
    
     
     
     JRBeanCollectionDataSource jRBeanCollectionDataSourcesss=new JRBeanCollectionDataSource(listtot2,false);
    
      hm.put("subreporttest1", jRBeanCollectionDataSourcesss);
     TestJRDataSource jRBeanCollectionDataSources1=new TestJRDataSource(listtot,test);
     hm.put("subreport2", jRBeanCollectionDataSources1);
     
      TestJRDataSource jRBeanCollectionDataSources2=new TestJRDataSource(listtot3,test);
     hm.put("subreport3", jRBeanCollectionDataSources2);
                               System.out.println("path "+reportpath);
            JasperPrint jp= JasperFillManager.fillReport(reportpath,hm ,jRBeanCollectionDataSource);
            
            
               // System.out.println("labo "+ch.getDateNaisCh());
            HttpServletResponse httpServletResponse=(HttpServletResponse)   FacesContext.getCurrentInstance().getExternalContext().getResponse();
         //httpServletResponse.addHeader("Content-disposition",  "attachment;filename=fiche.pdf"); 
          ServletOutputStream servletOutputStream= httpServletResponse.getOutputStream();
           System.out.println("aaa");
              JasperExportManager.exportReportToPdfStream(jp,servletOutputStream); 
               System.out.println("aaa");
              
	       FacesContext.getCurrentInstance().responseComplete();   
	      servletOutputStream.flush();
              servletOutputStream.close();
               FacesContext.getCurrentInstance().renderResponse();
            System.out.println("fin");
            genererFicheChercheur();
        }
        }
        } catch (JRException ex) {
            //Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur jasper"+ ex);
        } catch (Exception ex) {
           // Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur inputoutput"+ex);
        }
        
       
                
        
        }
    
     public void genererFicheChercheur()
        {
            
        
                 try {
                FacesContext facesContext = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
       ch=(Chercheur) session.getAttribute("user");
       
        if(ch!=null)
        {
              System.out.println("ch  "+ch);
            ArrayList list =new ArrayList();
            list.add(ch);
                JRBeanCollectionDataSource jRBeanCollectionDataSource=new JRBeanCollectionDataSource(list,false);
    String reportpath=   FacesContext.getCurrentInstance().getExternalContext().getRealPath("report1.jasper");
          
             HashMap hm=new HashMap();
           hm.put("Dénomination du  L.R / U.R",ch.getCode().getDenomination() );
            hm.put("EtablissementStructure",ch.getCode().getCodeEtab().getLibEtab());
             hm.put("UniversiteStructure",ch.getCode().getCodeEtab().getCodeUniv().getLibUniv());
           /* hm.put("Etablissement",ch.getStructurerecherche().getEtablissement() );*/
            // hm.put("Date de Naissance",ch.getDateNaisCh() );
               
                System.out.println("etab grade "+ch.getEtaCodeEtab2().getLibEtab());
               hm.put("Etablissement",ch.getEtaCodeEtab2().getLibEtab());
               
         
           
           /* System.out.println("etab inscri "+etabinscri);
               hm.put("EtablissementInsc",etabinscri);
                UniversiteDao univdao= new UniversiteDao();
           Universite univ= univdao.findUniversiteByEtablissement(eti);
           
             inscuniv=univ.getLibUniv();
           }
             System.out.println("univ inscri "+inscuniv);
               hm.put("UniversitetInsc",inscuniv);*/
               String directeur="";
               if(ch.getCheIdCh()!=null)
               {
                   directeur=ch.getCheIdCh().getPrenomCh()+ch.getCheIdCh().getNomCh();
               }
               hm.put("directeurThese",directeur);
                //System.out.println("directeurlabo "+ch.getStructurerecherche().getChercheur().getNomCh());
            /*   StructureRechercheDao stdao=new StructureRechercheDao();
             Chercheur dir=  stdao.findDirecteurStructure(ch.getStructurerecherche());
              hm.put("DirecteurLabo",dir.getPrenomCh()+" "+dir.getNomCh());*/
              String annee="";
              if(ch.getAnnee().intValue()!=0)
                  annee=ch.getAnnee()+"";
               hm.put("Annee",annee);
              //  hm.put("DirecteurLabo",dir.getPrenomCh()+" "+dir.getNomCh());
            JasperPrint jp= JasperFillManager.fillReport(reportpath,hm ,jRBeanCollectionDataSource);
            
            
                System.out.println("labo "+ch.getDateNaisCh());
            HttpServletResponse httpServletResponse=(HttpServletResponse)   FacesContext.getCurrentInstance().getExternalContext().getResponse();
        // httpServletResponse.addHeader("Content-disposition",  "attachment;filename=fiche.pdf"); 
          ServletOutputStream servletOutputStream= httpServletResponse.getOutputStream();
           System.out.println("aaa");
              JasperExportManager.exportReportToPdfStream(jp,servletOutputStream); 
               System.out.println("aaa");
              
	       FacesContext.getCurrentInstance().responseComplete();   
	      servletOutputStream.flush();
              servletOutputStream.close();
               FacesContext.getCurrentInstance().renderResponse();
            System.out.println("fin");
        }
        } catch (JRException ex) {
            //Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur jasper"+ ex);
        } catch (Exception ex) {
           // Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur inputoutput"+ex);
        }
        
       
                
        
        }
     
     public void subreport()
     {
           try {
                FacesContext facesContext = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
       ch=(Chercheur) session.getAttribute("user");
       
        if(ch!=null)
        {
          if(ch.getIdCh().equals(ch.getCode().getIdCh().getIdCh()))
          {    System.out.println("ch est directeur "+ch);
            /*ArrayList list =new ArrayList();
            list.add(ch.getCode());*/
            ///list.add(ch.getCode().getChercheurList());
        
            
            List listprofesseur=new ArrayList();
        List listmaitreConference=new ArrayList();
        List listmaitreAssistant=new ArrayList();
        List listassistant=new ArrayList();
        List listmaster=new ArrayList();
        List listdoctorant=new ArrayList();
       List l= ch.getCode().getChercheurList();
              System.out.println(" list ch "+l);
       for(int i=0;i<l.size();i++)
       {
           if(((Chercheur)l.get(i)).getGradeCh()!=null)
           {   System.out.println("gr "+((Chercheur)l.get(i)).getGradeCh());
         if(((Chercheur)l.get(i)).getGradeCh().equals("Professeur"))
         {
             listprofesseur.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getGradeCh().equals("Maitre de conference"))
         {
             listmaitreConference.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getGradeCh().equals("Maitre Assistant"))
         {
             listmaitreAssistant.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getGradeCh().equals("Assistant"))
         {
             listassistant.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getTypeCh().equals("Etudiant en Master"))
         {
             listmaster.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getTypeCh().equals("Doctorant"))
         {
             listdoctorant.add((Chercheur)l.get(i));
         }
           }
       }
              System.out.println("prof "+listprofesseur);
      List listtot = new ArrayList();
      listtot.addAll(listprofesseur);
      listtot.addAll(listmaitreConference);
    /* listtot.addAll(listmaitreAssistant);
      listtot.addAll(listassistant);
      listtot.addAll(listdoctorant);
      listtot.addAll(listmaster);*/
                JRBeanCollectionDataSource jRBeanCollectionDataSource=new JRBeanCollectionDataSource(listtot,false);
    
            
            String reportpath=   FacesContext.getCurrentInstance().getExternalContext().getRealPath("Bilan_subreport1.jasper");
          
             HashMap hm=new HashMap();
             
            
             
             hm.put("univG",ch.getCode().getCodeEtab().getCodeUniv().getLibUniv());
                hm.put("etabG",ch.getCode().getCodeEtab().getLibEtab());
                
                               System.out.println("path "+reportpath);
            JasperPrint jp= JasperFillManager.fillReport(reportpath,hm ,jRBeanCollectionDataSource);
            
            
               // System.out.println("labo "+ch.getDateNaisCh());
            HttpServletResponse httpServletResponse=(HttpServletResponse)   FacesContext.getCurrentInstance().getExternalContext().getResponse();
         //httpServletResponse.addHeader("Content-disposition",  "attachment;filename=fiche.pdf"); 
          ServletOutputStream servletOutputStream= httpServletResponse.getOutputStream();
           System.out.println("aaa");
              JasperExportManager.exportReportToPdfStream(jp,servletOutputStream); 
               System.out.println("aaa");
              
	       FacesContext.getCurrentInstance().responseComplete();   
	      servletOutputStream.flush();
              servletOutputStream.close();
               FacesContext.getCurrentInstance().renderResponse();
            System.out.println("fin");
            genererFicheChercheur();
        }
        }
        } catch (JRException ex) {
            //Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur jasper"+ ex);
        } catch (Exception ex) {
           // Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur inputoutput"+ex);
        }
        
       
     }
     
      public void subreport2()
     {
           try {
                FacesContext facesContext = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
       ch=(Chercheur) session.getAttribute("user");
       
        if(ch!=null)
        {
          if(ch.getIdCh().equals(ch.getCode().getIdCh().getIdCh()))
          {    System.out.println("ch est directeur "+ch);
            /*ArrayList list =new ArrayList();
            list.add(ch.getCode());*/
            ///list.add(ch.getCode().getChercheurList());
        
            
            List listprofesseur=new ArrayList();
        List listmaitreConference=new ArrayList();
        List listmaitreAssistant=new ArrayList();
        List listassistant=new ArrayList();
        List listmaster=new ArrayList();
        List listdoctorant=new ArrayList();
       List l= ch.getCode().getChercheurList();
              System.out.println(" list ch "+l);
       for(int i=0;i<l.size();i++)
       {
           if(((Chercheur)l.get(i)).getGradeCh()!=null)
           {   System.out.println("gr "+((Chercheur)l.get(i)).getGradeCh());
         if(((Chercheur)l.get(i)).getGradeCh().equals("Professeur"))
         {
             listprofesseur.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getGradeCh().equals("Maitre de conference"))
         {
             listmaitreConference.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getGradeCh().equals("Maitre Assistant"))
         {
             listmaitreAssistant.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getGradeCh().equals("Assistant"))
         {
             listassistant.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getTypeCh().equals("Etudiant en Master"))
         {
             listmaster.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getTypeCh().equals("Doctorant"))
         {
             listdoctorant.add((Chercheur)l.get(i));
         }
           }
       }
              System.out.println("prof "+listprofesseur);
      List listtot = new ArrayList();
     /* listtot.addAll(listprofesseur);
      listtot.addAll(listmaitreConference);*/
     listtot.addAll(listmaitreAssistant);
      listtot.addAll(listassistant);
     /* listtot.addAll(listdoctorant);
      listtot.addAll(listmaster);*/
                JRBeanCollectionDataSource jRBeanCollectionDataSource=new JRBeanCollectionDataSource(listtot,false);
    
            
            String reportpath=   FacesContext.getCurrentInstance().getExternalContext().getRealPath("Bilan_subreport2.jasper");
          
             HashMap hm=new HashMap();
             
            
             
             hm.put("univG",ch.getCode().getCodeEtab().getCodeUniv().getLibUniv());
                hm.put("etabG",ch.getCode().getCodeEtab().getLibEtab());
                
                               System.out.println("path "+reportpath);
            JasperPrint jp= JasperFillManager.fillReport(reportpath,hm ,jRBeanCollectionDataSource);
            
            
               // System.out.println("labo "+ch.getDateNaisCh());
            HttpServletResponse httpServletResponse=(HttpServletResponse)   FacesContext.getCurrentInstance().getExternalContext().getResponse();
         //httpServletResponse.addHeader("Content-disposition",  "attachment;filename=fiche.pdf"); 
          ServletOutputStream servletOutputStream= httpServletResponse.getOutputStream();
           System.out.println("aaa");
              JasperExportManager.exportReportToPdfStream(jp,servletOutputStream); 
               System.out.println("aaa");
              
	       FacesContext.getCurrentInstance().responseComplete();   
	      servletOutputStream.flush();
              servletOutputStream.close();
               FacesContext.getCurrentInstance().renderResponse();
            System.out.println("fin");
            genererFicheChercheur();
        }
        }
        } catch (JRException ex) {
            //Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur jasper"+ ex);
        } catch (Exception ex) {
           // Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur inputoutput"+ex);
        }
        
       
     }
     
      
       public void subreport3()
     {
           try {
                FacesContext facesContext = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
       ch=(Chercheur) session.getAttribute("user");
       
        if(ch!=null)
        {
          if(ch.getIdCh().equals(ch.getCode().getIdCh().getIdCh()))
          {    System.out.println("ch est directeur "+ch);
            /*ArrayList list =new ArrayList();
            list.add(ch.getCode());*/
            ///list.add(ch.getCode().getChercheurList());
        
            
            List listprofesseur=new ArrayList();
        List listmaitreConference=new ArrayList();
        List listmaitreAssistant=new ArrayList();
        List listassistant=new ArrayList();
        List listmaster=new ArrayList();
        List listdoctorant=new ArrayList();
       List l= ch.getCode().getChercheurList();
              System.out.println(" list ch "+l);
       for(int i=0;i<l.size();i++)
       {
           if(((Chercheur)l.get(i)).getGradeCh()!=null)
           {   System.out.println("gr "+((Chercheur)l.get(i)).getGradeCh());
         if(((Chercheur)l.get(i)).getGradeCh().equals("Professeur"))
         {
             listprofesseur.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getGradeCh().equals("Maitre de conference"))
         {
             listmaitreConference.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getGradeCh().equals("Maitre Assistant"))
         {
             listmaitreAssistant.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getGradeCh().equals("Assistant"))
         {
             listassistant.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getTypeCh().equals("Etudiant en Master"))
         {
             listmaster.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getTypeCh().equals("Doctorant"))
         {
             listdoctorant.add((Chercheur)l.get(i));
         }
           }
       }
              System.out.println("prof "+listprofesseur);
      List listtot = new ArrayList();
     /* listtot.addAll(listprofesseur);
      listtot.addAll(listmaitreConference);
     listtot.addAll(listmaitreAssistant);
      listtot.addAll(listassistant);*/
      listtot.addAll(listdoctorant);
      /*listtot.addAll(listmaster);*/
                JRBeanCollectionDataSource jRBeanCollectionDataSource=new JRBeanCollectionDataSource(listtot,false);
    
            
            String reportpath=   FacesContext.getCurrentInstance().getExternalContext().getRealPath("Bilan_subreport3.jasper");
          
             HashMap hm=new HashMap();
             
            
             
             hm.put("univG",ch.getCode().getCodeEtab().getCodeUniv().getLibUniv());
                hm.put("etabG",ch.getCode().getCodeEtab().getLibEtab());
                
                               System.out.println("path "+reportpath);
            JasperPrint jp= JasperFillManager.fillReport(reportpath,hm ,jRBeanCollectionDataSource);
            
            
               // System.out.println("labo "+ch.getDateNaisCh());
            HttpServletResponse httpServletResponse=(HttpServletResponse)   FacesContext.getCurrentInstance().getExternalContext().getResponse();
         //httpServletResponse.addHeader("Content-disposition",  "attachment;filename=fiche.pdf"); 
          ServletOutputStream servletOutputStream= httpServletResponse.getOutputStream();
           System.out.println("aaa");
              JasperExportManager.exportReportToPdfStream(jp,servletOutputStream); 
               System.out.println("aaa");
              
	       FacesContext.getCurrentInstance().responseComplete();   
	      servletOutputStream.flush();
              servletOutputStream.close();
               FacesContext.getCurrentInstance().renderResponse();
            System.out.println("fin");
            genererFicheChercheur();
        }
        }
        } catch (JRException ex) {
            //Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur jasper"+ ex);
        } catch (Exception ex) {
           // Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur inputoutput"+ex);
        }
        
       
     }
       
        public void subreport4()
     {
           try {
                FacesContext facesContext = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
       ch=(Chercheur) session.getAttribute("user");
       
        if(ch!=null)
        {
          if(ch.getIdCh().equals(ch.getCode().getIdCh().getIdCh()))
          {    System.out.println("ch est directeur "+ch);
            /*ArrayList list =new ArrayList();
            list.add(ch.getCode());*/
            ///list.add(ch.getCode().getChercheurList());
        
            
            List listprofesseur=new ArrayList();
        List listmaitreConference=new ArrayList();
        List listmaitreAssistant=new ArrayList();
        List listassistant=new ArrayList();
        List listmaster=new ArrayList();
        List listdoctorant=new ArrayList();
       List l= ch.getCode().getChercheurList();
              System.out.println(" list ch "+l);
       for(int i=0;i<l.size();i++)
       {
           if(((Chercheur)l.get(i)).getGradeCh()!=null)
           {   System.out.println("gr "+((Chercheur)l.get(i)).getGradeCh());
         if(((Chercheur)l.get(i)).getGradeCh().equals("Professeur"))
         {
             listprofesseur.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getGradeCh().equals("Maitre de conference"))
         {
             listmaitreConference.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getGradeCh().equals("Maitre Assistant"))
         {
             listmaitreAssistant.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getGradeCh().equals("Assistant"))
         {
             listassistant.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getTypeCh().equals("Etudiant en Master"))
         {
             listmaster.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getTypeCh().equals("Doctorant"))
         {
             listdoctorant.add((Chercheur)l.get(i));
         }
           }
       }
              System.out.println("prof "+listprofesseur);
      List listtot = new ArrayList();
     /* listtot.addAll(listprofesseur);
      listtot.addAll(listmaitreConference);
    /* listtot.addAll(listmaitreAssistant);
      listtot.addAll(listassistant);
      listtot.addAll(listdoctorant);*/
      listtot.addAll(listmaster);
                JRBeanCollectionDataSource jRBeanCollectionDataSource=new JRBeanCollectionDataSource(listtot,false);
    
            
            String reportpath=   FacesContext.getCurrentInstance().getExternalContext().getRealPath("Bilan_subreport4.jasper");
          
             HashMap hm=new HashMap();
             
            
             
             hm.put("univG",ch.getCode().getCodeEtab().getCodeUniv().getLibUniv());
                hm.put("etabG",ch.getCode().getCodeEtab().getLibEtab());
                
                               System.out.println("path "+reportpath);
            JasperPrint jp= JasperFillManager.fillReport(reportpath,hm ,jRBeanCollectionDataSource);
            
            
               // System.out.println("labo "+ch.getDateNaisCh());
            HttpServletResponse httpServletResponse=(HttpServletResponse)   FacesContext.getCurrentInstance().getExternalContext().getResponse();
         //httpServletResponse.addHeader("Content-disposition",  "attachment;filename=fiche.pdf"); 
          ServletOutputStream servletOutputStream= httpServletResponse.getOutputStream();
           System.out.println("aaa");
              JasperExportManager.exportReportToPdfStream(jp,servletOutputStream); 
               System.out.println("aaa");
              
	       FacesContext.getCurrentInstance().responseComplete();   
	      servletOutputStream.flush();
              servletOutputStream.close();
               FacesContext.getCurrentInstance().renderResponse();
            System.out.println("fin");
            genererFicheChercheur();
        }
        }
        } catch (JRException ex) {
            //Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur jasper"+ ex);
        } catch (Exception ex) {
           // Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur inputoutput"+ex);
        }
        
       
     }
      
        public void genererBilantest()
        {
            
            try {
                FacesContext facesContext = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
       ch=(Chercheur) session.getAttribute("user");
       
        if(ch!=null)
        {
          if(ch.getIdCh().equals(ch.getCode().getIdCh().getIdCh()))
          {    System.out.println("ch est directeur "+ch);
            ArrayList list =new ArrayList();
            list.add(ch.getCode());
            ///list.add(ch.getCode().getChercheurList());
            
            
        
                JRBeanCollectionDataSource jRBeanCollectionDataSource=new JRBeanCollectionDataSource(list,false);
    
            
            String reportpath=   FacesContext.getCurrentInstance().getExternalContext().getRealPath("P1Bilan.jasper");
          
             HashMap hm=new HashMap();
             
            
             
             hm.put("Universite",ch.getCode().getCodeEtab().getCodeUniv().getLibUniv());
                hm.put("Etablissement",ch.getCode().getCodeEtab().getLibEtab());
                  hm.put("Denomination",ch.getCode().getDenomination());
                   hm.put("Code",ch.getCode().getCode());
                      hm.put("Discipline",ch.getCode().getDiscipline());
                   hm.put("Responsable",ch.getPrenomCh()+" "+ch.getNomCh());
                      hm.put("Grade",ch.getGradeCh());
                         hm.put("Fonction",ch.getFonctionCh());
                     /* hm.put("Tel",ch.);
                         hm.put("Fax",libetabgrade);*/
                            hm.put("Mobile",ch.getTelCh());
                               hm.put("Email",ch.getEmailCh());
                                  hm.put("Site",ch.getCode().getSite());
                            
             
                               System.out.println("path "+reportpath);
            JasperPrint jp= JasperFillManager.fillReport(reportpath,hm ,jRBeanCollectionDataSource);
             List listprofesseur=new ArrayList();
        List listmaitreConference=new ArrayList();
        List listmaitreAssistant=new ArrayList();
        List listassistant=new ArrayList();
        List listmaster=new ArrayList();
        List listdoctorant=new ArrayList();
       List l= ch.getCode().getChercheurList();
              System.out.println(" list ch "+l);
       for(int i=0;i<l.size();i++)
       {
           if(((Chercheur)l.get(i)).getGradeCh()!=null)
           {   System.out.println("gr "+((Chercheur)l.get(i)).getGradeCh());
         if(((Chercheur)l.get(i)).getGradeCh().equals("Professeur"))
         {
             listprofesseur.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getGradeCh().equals("Maitre de conference"))
         {
             listmaitreConference.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getGradeCh().equals("Maitre Assistant"))
         {
             listmaitreAssistant.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getGradeCh().equals("Assistant"))
         {
             listassistant.add((Chercheur)l.get(i));
         }
if(((Chercheur)l.get(i)).getTypeCh()!=null)
{
    if(((Chercheur)l.get(i)).getTypeCh().equals("Etudiant en Master"))
         {
             listmaster.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getTypeCh().equals("Doctorant"))
         {
             listdoctorant.add((Chercheur)l.get(i));
         }
           }
           }   
       }
              System.out.println("prof "+listprofesseur);
      List listtot = new ArrayList();
       List listtot2 = new ArrayList();
        List listtot3 = new ArrayList();
          List listtot4 = new ArrayList();
      listtot.addAll(listprofesseur);
      listtot.addAll(listmaitreConference);
     listtot2.addAll(listmaitreAssistant);
      listtot2.addAll(listassistant);
      listtot3.addAll(listdoctorant);
      listtot4.addAll(listmaster);
                JRBeanCollectionDataSource jRBeanCollectionDataSources=new JRBeanCollectionDataSource(listtot,false);
    
            
            String reportpaths=   FacesContext.getCurrentInstance().getExternalContext().getRealPath("Bilan_subreport2.jasper");
          
             HashMap hms=new HashMap();
             
            
             
             hms.put("univG",ch.getCode().getCodeEtab().getCodeUniv().getLibUniv());
                hms.put("etabG",ch.getCode().getCodeEtab().getLibEtab());
                
                               System.out.println("path "+reportpaths);
            JasperPrint jps= JasperFillManager.fillReport(reportpaths,hms ,jRBeanCollectionDataSources);
            
            List pages = jps .getPages();
            for (int j = 0; j < pages.size(); j++) {
            JRPrintPage object = (JRPrintPage)pages.get(j);
            jp.addPage(object);
            
        
    }
              System.out.println(" list 2 "+ listtot2);
            
             JRBeanCollectionDataSource jRBeanCollectionDataSources2=new JRBeanCollectionDataSource(listtot2,false);
    
            
            String reportpaths2=   FacesContext.getCurrentInstance().getExternalContext().getRealPath("P3Bilan.jasper");
          
             HashMap hms2=new HashMap();
             
            
             
             hms2.put("univG",ch.getCode().getCodeEtab().getCodeUniv().getLibUniv());
                hms2.put("etabG",ch.getCode().getCodeEtab().getLibEtab());
                
                               System.out.println("path "+reportpaths2);
            JasperPrint jps2= JasperFillManager.fillReport(reportpaths2,hms2 ,jRBeanCollectionDataSources2);
            
            List pages2 = jps2 .getPages();
            for (int j = 0; j < pages2.size(); j++) {
            JRPrintPage object = (JRPrintPage)pages2.get(j);
            jp.addPage(object);
            
        
    }
            
            
             System.out.println(" list 3 "+ listtot3);
            
             JRBeanCollectionDataSource jRBeanCollectionDataSources3=new JRBeanCollectionDataSource(listtot3,false);
    
            
            String reportpaths3=   FacesContext.getCurrentInstance().getExternalContext().getRealPath("Bilan_subreport3.jasper");
          
             HashMap hms3=new HashMap();
             
            
             
             hms3.put("univG",ch.getCode().getCodeEtab().getCodeUniv().getLibUniv());
                hms3.put("etabG",ch.getCode().getCodeEtab().getLibEtab());
                
                               System.out.println("path "+reportpaths3);
            JasperPrint jps3= JasperFillManager.fillReport(reportpaths3,hms3 ,jRBeanCollectionDataSources3);
            
            List pages3 = jps3 .getPages();
            for (int j = 0; j < pages2.size(); j++) {
            JRPrintPage object = (JRPrintPage)pages3.get(j);
            jp.addPage(object);
            
        
    }
            
            JRBeanCollectionDataSource jRBeanCollectionDataSources4=new JRBeanCollectionDataSource(listtot4,false);
    
            
            String reportpaths4=   FacesContext.getCurrentInstance().getExternalContext().getRealPath("P4Bilan.jasper");
          
             HashMap hms4=new HashMap();
             
            
             
             hms.put("univG",ch.getCode().getCodeEtab().getCodeUniv().getLibUniv());
                hms.put("etabG",ch.getCode().getCodeEtab().getLibEtab());
                
                               System.out.println("path "+reportpaths4);
            JasperPrint jps4= JasperFillManager.fillReport(reportpaths4,hms4 ,jRBeanCollectionDataSources4);
            
            List pages4 = jps4 .getPages();
            for (int j = 0; j < pages.size(); j++) {
            JRPrintPage object = (JRPrintPage)pages4.get(j);
            jp.addPage(object);
            
        
    }
    //JasperViewer.viewReport(jp,false);

            
            
               // System.out.println("labo "+ch.getDateNaisCh());
          HttpServletResponse httpServletResponse=(HttpServletResponse)   FacesContext.getCurrentInstance().getExternalContext().getResponse();
         //httpServletResponse.addHeader("Content-disposition",  "attachment;filename=fiche.pdf"); 
          ServletOutputStream servletOutputStream= httpServletResponse.getOutputStream();
           System.out.println("aaa");
              JasperExportManager.exportReportToPdfStream(jp,servletOutputStream); 
               System.out.println("aaa");
              
	       FacesContext.getCurrentInstance().responseComplete();   
	      servletOutputStream.flush();
              servletOutputStream.close();
               FacesContext.getCurrentInstance().renderResponse();
            System.out.println("fin");
           // genererFicheChercheur();
        }
        }
        } catch (JRException ex) {
            //Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur jasper"+ ex);
        } catch (Exception ex) {
           // Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur inputoutput "+ex);
                ex.printStackTrace();
        }
        
       
                
        
        }
        
      
        
        
        
          public void genererAnnexeBilantest()
        {
            
            try {
                FacesContext facesContext = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
       ch=(Chercheur) session.getAttribute("user");
       
        if(ch!=null)
        {
          if(ch.getIdCh().equals(ch.getCode().getIdCh().getIdCh()))
          {    System.out.println("ch est directeur "+ch);
            ArrayList list =new ArrayList();
            list.add(ch.getCode());
            ///list.add(ch.getCode().getChercheurList());
            
            
        
                JRBeanCollectionDataSource jRBeanCollectionDataSource=new JRBeanCollectionDataSource(list,false);
    
            
            String reportpath=   FacesContext.getCurrentInstance().getExternalContext().getRealPath("P1Bilan.jasper");
          
             HashMap hm=new HashMap();
             
            
             
             hm.put("Universite",ch.getCode().getCodeEtab().getCodeUniv().getLibUniv());
                hm.put("Etablissement",ch.getCode().getCodeEtab().getLibEtab());
                  hm.put("Denomination",ch.getCode().getDenomination());
                   hm.put("Code",ch.getCode().getCode());
                      hm.put("Discipline",ch.getCode().getDiscipline());
                   hm.put("Responsable",ch.getPrenomCh()+" "+ch.getNomCh());
                      hm.put("Grade",ch.getGradeCh());
                         hm.put("Fonction",ch.getFonctionCh());
                     /* hm.put("Tel",ch.);
                         hm.put("Fax",libetabgrade);*/
                            hm.put("Mobile",ch.getTelCh());
                               hm.put("Email",ch.getEmailCh());
                                  hm.put("Site",ch.getCode().getSite());
                            
             
                               System.out.println("path "+reportpath);
            JasperPrint jp= JasperFillManager.fillReport(reportpath,hm ,jRBeanCollectionDataSource);
             List listthesesoutenue=new ArrayList();
        List listtheseencours=new ArrayList();
        List listmastersoutenue=new ArrayList();
        List listmasterencours=new ArrayList();
       
       List l= ch.getCode().getChercheurList();
              System.out.println(" list ch "+l);
       for(int i=0;i<l.size();i++)
       {
           if(((Chercheur)l.get(i)).getTypeCh()!=null)
           {   System.out.println("gr "+((Chercheur)l.get(i)).getGradeCh());
         
         if(((Chercheur)l.get(i)).getTypeCh().equals("Etudiant en Master")&&((Chercheur)l.get(i)).getAvancement().intValue()<99  )
         {
             listmasterencours.add((Chercheur)l.get(i));
         }
          if(((Chercheur)l.get(i)).getTypeCh().equals("Etudiant en Master")&&((Chercheur)l.get(i)).getAvancement().intValue()==99 )
         {
             listmastersoutenue.add((Chercheur)l.get(i));
         }
           if(((Chercheur)l.get(i)).getTypeCh().equals("Doctorant")&&((Chercheur)l.get(i)).getAvancement().intValue()<99  )
         {
             listtheseencours.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getTypeCh().equals("Doctorant")&&((Chercheur)l.get(i)).getAvancement().intValue()==99 )
         {
             listthesesoutenue.add((Chercheur)l.get(i));
         }
           }
       }
              
      List<Publication> listtot = new ArrayList <Publication>();
       List  <Publication>listtot2 = new ArrayList <Publication>();
        List listtot3 = new ArrayList();
          List listtot4 = new ArrayList();
     
     
                JRBeanCollectionDataSource jRBeanCollectionDataSources=new JRBeanCollectionDataSource(listthesesoutenue,false);
    
            
            String reportpaths=   FacesContext.getCurrentInstance().getExternalContext().getRealPath("P2Annexe.jasper");
          
             HashMap hms=new HashMap();
             
            
             
             hms.put("univG",ch.getCode().getCodeEtab().getCodeUniv().getLibUniv());
                hms.put("etabG",ch.getCode().getCodeEtab().getLibEtab());
                
                               System.out.println("path "+reportpaths);
            JasperPrint jps= JasperFillManager.fillReport(reportpaths,hms ,jRBeanCollectionDataSources);
            
           List pages = jps .getPages();
            for (int j = 0; j < pages.size(); j++) {
            JRPrintPage object = (JRPrintPage)pages.get(j);
            jp.addPage(object);
            
        }
            
                   JRBeanCollectionDataSource jRBeanCollectionDataSources1=new JRBeanCollectionDataSource(listmastersoutenue,false);
    
            
            String reportpaths1=   FacesContext.getCurrentInstance().getExternalContext().getRealPath("P3Annexe.jasper");
          
             HashMap hms1=new HashMap();
             
            
             
             hms1.put("univG",ch.getCode().getCodeEtab().getCodeUniv().getLibUniv());
                hms1.put("etabG",ch.getCode().getCodeEtab().getLibEtab());
                
                               System.out.println("path "+reportpaths1);
            JasperPrint jps1= JasperFillManager.fillReport(reportpaths1,hms1 ,jRBeanCollectionDataSources1);
            
           List pages1 = jps1 .getPages();
            for (int j = 0; j < pages1.size(); j++) {
            JRPrintPage object = (JRPrintPage)pages1.get(j);
            jp.addPage(object);
            
        }
          
                   JRBeanCollectionDataSource jRBeanCollectionDataSources2=new JRBeanCollectionDataSource(listtheseencours,false);
    
            
            String reportpaths2=   FacesContext.getCurrentInstance().getExternalContext().getRealPath("P4Annexe.jasper");
          
             HashMap hms2=new HashMap();
             
            
             
             hms2.put("univG",ch.getCode().getCodeEtab().getCodeUniv().getLibUniv());
                hms2.put("etabG",ch.getCode().getCodeEtab().getLibEtab());
                
                               System.out.println("path "+reportpaths2);
            JasperPrint jps2= JasperFillManager.fillReport(reportpaths2,hms2 ,jRBeanCollectionDataSources2);
            
           List pages2 = jps2 .getPages();
            for (int j = 0; j < pages2.size(); j++) {
            JRPrintPage object = (JRPrintPage)pages2.get(j);
            jp.addPage(object);
            
        }
          
                   JRBeanCollectionDataSource jRBeanCollectionDataSources3=new JRBeanCollectionDataSource(listmasterencours,false);
    
            
            String reportpaths3=   FacesContext.getCurrentInstance().getExternalContext().getRealPath("P5Annexe.jasper");
          
             HashMap hms3=new HashMap();
             
            
             
             hms3.put("univG",ch.getCode().getCodeEtab().getCodeUniv().getLibUniv());
                hms3.put("etabG",ch.getCode().getCodeEtab().getLibEtab());
                
                               System.out.println("path "+reportpaths3);
            JasperPrint jps3= JasperFillManager.fillReport(reportpaths3,hms3 ,jRBeanCollectionDataSources3);
            
           List pages3 = jps3 .getPages();
            for (int j = 0; j < pages3.size(); j++) {
            JRPrintPage object = (JRPrintPage)pages3.get(j);
            jp.addPage(object);
            
        }
          
              System.out.println("mastere en cours"+ listmasterencours);
              System.out.println("mastere soutenu "+listmastersoutenue);
           
              
           List listchercheur=   ch.getCode().getChercheurList();
              System.out.println("list chercheur "+listchercheur);
           for(int i=0;i<listchercheur.size();i++)
           {
          listtot= auteurFacade.listpublicationByChercheurAnnexe((Chercheur)listchercheur.get(i),new Date().getYear()+1900);
               System.out.println("list pub complete"+listtot);
               if(listtot!=null)
               {
          for(int j=0;j<listtot.size();j++)
          {
              if(((Publication)listtot.get(j)).getType().equals("Article"))
              {
                if(!listtot2.contains((Publication)listtot.get(j)))
                 listtot2.add((Publication)listtot.get(j));
              }
                if(((Publication)listtot.get(j)).getType().equals("Conference"))
              {
                if(!listtot3.contains((Publication)listtot.get(j)))
                 listtot3.add((Publication)listtot.get(j));
              }
          }
               }
           }
              System.out.println("list pub article "+listtot2);
              System.out.println("list pub conf "+listtot3);
              JRBeanCollectionDataSource jRBeanCollectionDataSources4=new JRBeanCollectionDataSource(listtot2,false);
    
            
            String reportpaths4=   FacesContext.getCurrentInstance().getExternalContext().getRealPath("P6Annexe.jasper");
          
             HashMap hms4=new HashMap();
             
            
             
             hms4.put("univG",ch.getCode().getCodeEtab().getCodeUniv().getLibUniv());
                hms4.put("etabG",ch.getCode().getCodeEtab().getLibEtab());
                
                               System.out.println("path "+reportpaths4);
            JasperPrint jps4= JasperFillManager.fillReport(reportpaths4,hms4 ,jRBeanCollectionDataSources4);
            
           List pages4 = jps4 .getPages();
            for (int j = 0; j < pages4.size(); j++) {
            JRPrintPage object = (JRPrintPage)pages4.get(j);
            jp.addPage(object);
            
        }
          
            JRBeanCollectionDataSource jRBeanCollectionDataSources5=new JRBeanCollectionDataSource(listtot3,false);
    
            
            String reportpaths5=   FacesContext.getCurrentInstance().getExternalContext().getRealPath("P7Annexe.jasper");
          
             HashMap hms5=new HashMap();
             
            
             
             hms5.put("univG",ch.getCode().getCodeEtab().getCodeUniv().getLibUniv());
                hms5.put("etabG",ch.getCode().getCodeEtab().getLibEtab());
                
                               System.out.println("path "+reportpaths5);
            JasperPrint jps5= JasperFillManager.fillReport(reportpaths5,hms5 ,jRBeanCollectionDataSources5);
            
           List pages5 = jps5 .getPages();
            for (int j = 0; j < pages5.size(); j++) {
            JRPrintPage object = (JRPrintPage)pages5.get(j);
            jp.addPage(object);
            
        }
          
              System.out.println("these "+listtheseencours);
             JRBeanCollectionDataSource jRBeanCollectionDataSources6=new JRBeanCollectionDataSource(listtheseencours,false);
    
            
            String reportpaths6=   FacesContext.getCurrentInstance().getExternalContext().getRealPath("P9Annexe.jasper");
          
             HashMap hms6=new HashMap();
             
            
             
             hms5.put("univG",ch.getCode().getCodeEtab().getCodeUniv().getLibUniv());
                hms5.put("etabG",ch.getCode().getCodeEtab().getLibEtab());
                
                               System.out.println("path "+reportpaths6);
            JasperPrint jps6= JasperFillManager.fillReport(reportpaths6,hms6 ,jRBeanCollectionDataSources6);
            jps6.setOrientation(OrientationEnum.LANDSCAPE);
           List pages6 = jps6 .getPages();
            for (int j = 0; j < pages6.size(); j++) {
            JRPrintPage object = (JRPrintPage)pages6.get(j);
            jp.addPage(object);
            
        }
          
              
              
              
               // System.out.println("labo "+ch.getDateNaisCh());
          HttpServletResponse httpServletResponse=(HttpServletResponse)   FacesContext.getCurrentInstance().getExternalContext().getResponse();
         //httpServletResponse.addHeader("Content-disposition",  "attachment;filename=fiche.pdf"); 
          ServletOutputStream servletOutputStream= httpServletResponse.getOutputStream();
           System.out.println("aaa");
              JasperExportManager.exportReportToPdfStream(jp,servletOutputStream); 
               System.out.println("aaa");
              
	       FacesContext.getCurrentInstance().responseComplete();   
	      servletOutputStream.flush();
              servletOutputStream.close();
               FacesContext.getCurrentInstance().renderResponse();
            System.out.println("fin");
          }

        }
            }catch (JRException ex) {
            //Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur jasper"+ ex);
        } catch (Exception ex) {
           // Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.out.println("erreur inputoutput"+ex);
        }
    }
          
          
          
             public void genererAnnexeBilantestsujetThese()
        {
            
            try {
                FacesContext facesContext = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
       ch=(Chercheur) session.getAttribute("user");
       
        if(ch!=null)
        {
          if(ch.getIdCh().equals(ch.getCode().getIdCh().getIdCh()))
          {    System.out.println("ch est directeur "+ch);
            ArrayList list =new ArrayList();
            list.add(ch.getCode());
            ///list.add(ch.getCode().getChercheurList());
            
                List listthesesoutenue=new ArrayList();
        List listtheseencours=new ArrayList();
        List listmastersoutenue=new ArrayList();
        List listmasterencours=new ArrayList();
       
       List l= ch.getCode().getChercheurList();
              System.out.println(" list ch "+l);
       for(int i=0;i<l.size();i++)
       {
           if(((Chercheur)l.get(i)).getTypeCh()!=null)
           {   System.out.println("gr "+((Chercheur)l.get(i)).getGradeCh());
         
         if(((Chercheur)l.get(i)).getTypeCh().equals("Etudiant en Master")&&((Chercheur)l.get(i)).getAvancement().intValue()<99  )
         {
             listmasterencours.add((Chercheur)l.get(i));
         }
          if(((Chercheur)l.get(i)).getTypeCh().equals("Etudiant en Master")&&((Chercheur)l.get(i)).getAvancement().intValue()==99 )
         {
             listmastersoutenue.add((Chercheur)l.get(i));
         }
           if(((Chercheur)l.get(i)).getTypeCh().equals("Doctorant")&&((Chercheur)l.get(i)).getAvancement().intValue()<99  )
         {
             listtheseencours.add((Chercheur)l.get(i));
         }
         if(((Chercheur)l.get(i)).getTypeCh().equals("Doctorant")&&((Chercheur)l.get(i)).getAvancement().intValue()==99 )
         {
             listthesesoutenue.add((Chercheur)l.get(i));
         }
           }
       }
        
                JRBeanCollectionDataSource jRBeanCollectionDataSource=new JRBeanCollectionDataSource(listtheseencours,false);
    
            
            String reportpath=   FacesContext.getCurrentInstance().getExternalContext().getRealPath("P8Annexe.jasper");
          
             HashMap hm=new HashMap();
             
             
             
             
             
             
    
     
     
    
    
            JasperPrint jp= JasperFillManager.fillReport(reportpath,hm ,jRBeanCollectionDataSource);
            
            
               // System.out.println("labo "+ch.getDateNaisCh());
            HttpServletResponse httpServletResponse=(HttpServletResponse)   FacesContext.getCurrentInstance().getExternalContext().getResponse();
         //httpServletResponse.addHeader("Content-disposition",  "attachment;filename=fiche.pdf"); 
          ServletOutputStream servletOutputStream= httpServletResponse.getOutputStream();
           System.out.println("aaa");
              JasperExportManager.exportReportToPdfStream(jp,servletOutputStream); 
               System.out.println("aaa");
              
	       FacesContext.getCurrentInstance().responseComplete();   
	      servletOutputStream.flush();
              servletOutputStream.close();
               FacesContext.getCurrentInstance().renderResponse();
            System.out.println("fin");
            genererFicheChercheur();
             
          }
        }
            }catch (JRException ex) {
            //Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur jasper"+ ex);
        } catch (Exception ex) {
           // Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.out.println("erreur inputoutput"+ex);
        }
        }
     
}
        
