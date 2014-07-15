/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Chercheur;
import entity.Inscription;
import entity.Structurerecherche;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author USER1
 */
@Stateless
public class InscriptionFacade extends AbstractFacade<Inscription> {
    @PersistenceContext(unitName = "stagePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InscriptionFacade() {
        super(Inscription.class);
    }
    
    
    
     public List listInscriptionInvalide(Structurerecherche st)
    {
         try
         {Query q=  em.createQuery(" select c FROM Inscription c where c.etat=:etat and  c.structurerecherche.code =:id " );
      
           q.setParameter("etat", "non valide");
             q.setParameter("id", st.getCode());
        //q.setParameter("id", st.getCode());
       
    
             
             List res= q.getResultList();
             
             return res;
            
           
        //q.setParameter("id", st.getCode());
         }catch(Exception e)
         {
             System.out.println("erreur "+e);
             return null;
         
         }
    }
     
     public void validerInscription(Chercheur ch)
     {
         System.out.println("test ");
         Inscription i=new Inscription(ch.getIdCh().intValue(),ch.getCode().getCode());
     Inscription iupdated=em.find(Inscription.class, i.getInscriptionPK());
      em.remove(iupdated);
     }
     
}
