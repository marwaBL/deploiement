/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Auteur;
import entity.Chercheur;
import entity.Structurerecherche;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author USER1
 */
@Stateless
public class StructurerechercheFacade extends AbstractFacade<Structurerecherche> {
    @PersistenceContext(unitName = "stagePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StructurerechercheFacade() {
        super(Structurerecherche.class);
    }
    public List<Structurerecherche> findStructureByType(String type)
    {List res=new ArrayList();
        System.out.println("type "+type);
         Query querylabByName=  em.createNamedQuery("Structurerecherche.findByType");
     querylabByName.setParameter("type", type);
     try{
        System.out.println("res "+querylabByName.getResultList());
    // if(querylabByName.getSingleResult()!=null)
        List l=querylabByName.getResultList();
        for (int i=0;i<l.size();i++)
        res.add(((Structurerecherche) l.get(i)));
   return  res;
      //  return l;
   
     }catch (NoResultException e)
     {
         return null;
     }
    }
    
    
    public void top5publications(Structurerecherche st)
    {
        List listchercheur=st.getChercheurList();
        for (int i=0;i<listchercheur.size();i++)
        { Auteur a=new Auteur ();
        a.getIdCh();
            System.out.println(""+((Chercheur)listchercheur.get(i)));
        }
    }
    
    public List findListMembreByStructure(Structurerecherche st)
    {
        List listprofesseur=new ArrayList();
        List listmaitreConference=new ArrayList();
        List listmaitreAssistant=new ArrayList();
        List listassistant=new ArrayList();
        List listmaster=new ArrayList();
        List listdoctorant=new ArrayList();
       List l= st.getChercheurList();
       for(int i=0;i<l.size();i++)
       {
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
       return l;
       
       
    }
}
