/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Auteur;
import entity.Chercheur;
import entity.Inscription;
import entity.Structurerecherche;
import java.util.ArrayList;
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
public class ChercheurFacade extends AbstractFacade<Chercheur> {
    @PersistenceContext(unitName = "stagePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ChercheurFacade() {
        super(Chercheur.class);
    }
    public Chercheur login(String id,String mdp)
    {
         try
         {Query q=  em.createQuery(" select c FROM Chercheur c WHERE c.emailCh = :chemail and c.password= :pass " );
        q.setParameter("chemail", id);
        q.setParameter("pass", mdp);
       return (Chercheur) q.getSingleResult();
         }catch(Exception e)
         { return null;
         
         }
       
    }
    
    public void insert(String email,String pass,String nom,String prenom,String typeCh,Structurerecherche st)
    {
        Chercheur ch=new Chercheur();
        ch.setEmailCh(email);
        ch.setPassword(pass);
        ch.setNomCh(nom);
        ch.setPhoto("C:/Users/USER1/Desktop/images/profil.png");
        ch.setPrenomCh(prenom);
        ch.setCode(st);
        ch.setTypeCh(typeCh);
        ch.setEtat("inactive");
        em.persist(ch);
        Auteur a=new Auteur();
        a.setIdCh(ch);
        a.setNomAut(nom);
        a.setPrenomAut(prenom);
        em.persist(a);
        
    }
    public List RecentInscription(List listChercheur)
    {
        List l=new ArrayList();
        for(int i=0;i<listChercheur.size();i++)
        {
          l.add(((Chercheur)listChercheur.get(i)).getIdCh());
        }
         try
         {Query q=  em.createQuery(" select c FROM Chercheur c where c.idCh  in :id order by c.dateinscription desc" );
       System.out.println("struc "+listChercheur);
        q.setParameter("id", l);
        q.setMaxResults(5);
     return q.getResultList();
         }catch(Exception e)
         {
             System.out.println("erreur "+e);
             return null;
         
         }
         
    }
    
    public List listEncadrementMaster(Chercheur ch,String type)
   { List l ;
         
       try
         {
             Query q;
             if(type.equals("En cours"))
         {   q=  em.createQuery(" select c FROM Chercheur c where  c.cheIdCh.idCh=:id and c.typeCh =:type and c.avancement < 99" );
       
        q.setParameter("id", ch.getIdCh());
        q.setParameter("type", "Etudiant en Master");
         }
         else
         {
              q=  em.createQuery(" select c FROM Chercheur c where  c.cheIdCh.idCh=:id and c.typeCh =:type and c.avancement = 99" );
       
        q.setParameter("id", ch.getIdCh());
        q.setParameter("type", "Etudiant en Master");
         }
  l=q.getResultList();
             System.out.println("session res "+l);
         }catch(Exception e)
         {
             System.out.println("erreur "+e);
             return null;
         
         }
         
        return  l;
   }
    public void update (Chercheur ch)
    {
        em.merge(ch);
    }
    
    public void refuserInscription(Chercheur ch)
     {
         System.out.println("test refus ");
       //  Inscription i=new Inscription(ch.getIdCh().intValue(),ch.getCode().getCode());
    Chercheur chupdated=em.find(Chercheur.class, ch.getIdCh());
     Inscription i=new Inscription(chupdated.getIdCh().intValue(),chupdated.getCode().getCode());
     Inscription iupdated=em.find(Inscription.class, i.getInscriptionPK());
      em.remove(iupdated);
    Query q=  em.createQuery(" select c FROM Auteur c where c.idCh.idCh  =:id " );
      
           
              q.setParameter("id", chupdated.getIdCh());
        //q.setParameter("id", st.getCode());
       
     Auteur a=  (Auteur) q.getSingleResult();
    
      
     Auteur aupdated=em.find(Auteur.class, a.getIdAut());
      em.remove(aupdated);
    
      em.remove(chupdated);
     }
     
}
