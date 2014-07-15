/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Auteur;
import entity.Chercheur;
import entity.Ecrire;
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
public class AuteurFacade extends AbstractFacade<Auteur> {
    @PersistenceContext(unitName = "stagePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuteurFacade() {
        super(Auteur.class);
    }
    public List listauteur(List l)
    {
       // List listEcrireAuteur=new ArrayList();
         List listpub=new ArrayList();
        /* Query querylistauteur=  em.createNamedQuery("Auteur.findAll");
       List l=  querylistauteur.getResultList();
        System.out.println("all auteur "+l);
       for(int i=0;i<l.size();i++)
       { if(((Auteur)l.get(i)).getIdCh()!=null)
           if(((Auteur)l.get(i)).getIdCh().getCode().equals(st))
               listEcrireAuteur.add(((Auteur)l.get(i)).getEcrireList());
       }
        for(int i=0;i<listEcrireAuteur.size();i++)
       {
          listpub.add(((Ecrire) listEcrireAuteur.get(i)).getPublication());
       }
       try
         {Query q=  em.createQuery(" select c FROM Publication where IdPub in (:id) order by annee,mois desc" );
       
        q.setParameter("id", listpub);
        q.setMaxResults(5);
     return q.getResultList();
         }catch(Exception e)
         { return null;
         
         }*/
       //return listEcrireAuteur;
         /* List lst=new ArrayList();
         for (int i=0;i<l.size();i++)
             lst.add(((Chercheur)l.get(i)).getIdCh());*/
         System.out.println("list session "+l);
          try
         {//Query q=  em.createQuery(" select c FROM Publication c where c.codeLabUnite =:id order by c.annee desc,c.mois desc" );
      Query q=  em.createQuery(" select c FROM Publication c where c.idCh.idCh  in :id order by c.annee desc,c.mois desc" );
      
            // Query q=  em.createQuery(" select c FROM Publication c where c. =:id order by c.annee desc,c.mois desc" );
       
            // System.out.println("struc "+st.getCode());
              q.setParameter("id", l);
        //q.setParameter("id", st.getCode());
        q.setMaxResults(5);
     return q.getResultList();
         }catch(Exception e)
         {
             System.out.println("erreur "+e);
             return null;
         
         }
         
         
    }
    
     public List listpublicationByChercheur(Chercheur ch)
    {
         try
         {Query q=  em.createQuery(" select c FROM Auteur c where c.idCh.idCh  =:id " );
      
           
              q.setParameter("id", ch.getIdCh());
        //q.setParameter("id", st.getCode());
       
     Auteur a=  (Auteur) q.getSingleResult();
     List l=new ArrayList();
        for(int i=0;i<a.getEcrireList().size();i++)
        {
          l.add(((Ecrire)a.getEcrireList().get(i)).getEcrirePK().getIdPub());
        }
            if(l.size()!=0)
            { Query query=  em.createQuery(" select c FROM Publication c where c.idPub  in :id order by c.annee desc,c.mois desc" );
      
           
              query.setParameter("id",l );
             
             List res= query.getResultList();
             
             return res;
            }
            return null;
        //q.setParameter("id", st.getCode());
         }catch(Exception e)
         {
             System.out.println("erreur "+e);
             return null;
         
         }
    }
     
     
      public List listpublicationByChercheurAnnexe(Chercheur ch,int annee)
    {
         try
         {Query q=  em.createQuery(" select c FROM Auteur c where c.idCh.idCh  =:id " );
      
           
              q.setParameter("id", ch.getIdCh());
        //q.setParameter("id", st.getCode());
       
     Auteur a=  (Auteur) q.getSingleResult();
     List l=new ArrayList();
        for(int i=0;i<a.getEcrireList().size();i++)
        {
          l.add(((Ecrire)a.getEcrireList().get(i)).getEcrirePK().getIdPub());
        }
        if(l.size()!=0)
        { Query query=  em.createQuery(" select c FROM Publication c where c.idPub  in :id and c.annee=:annee order by c.mois desc" );
      
           
              query.setParameter("id",l );
              query.setParameter("annee",annee);
              return query.getResultList();
        }
        return null;
        //q.setParameter("id", st.getCode());
         }catch(Exception e)
         {
             e.printStackTrace();
             System.out.println("erreur "+e);
             return null;
         
         }
    }
     
     public void ajoutNouveauAuteur(ArrayList l,List listauteur)
 {
     System.out.println("l "+l);
     System.out.println("list aut "+listauteur);
   /* ArrayList list=new ArrayList(listauteur);
     System.out.println("nouv "+list);*/
     for(int i=0;i<l.size();i++)
     
     {
         //System.out.println(" test "+l.get(i));
         Auteur a= new Auteur();
         a.setNomAut(((Auteur)l.get(i)).getNomAut());
                 a.setPrenomAut(((Auteur)l.get(i)).getPrenomAut());
                 
         if(!listauteur.contains(a))
         {
            em.persist(a);
             System.out.println(a);
             listauteur.add(a);
         }
     }
     }
}
