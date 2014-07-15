/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Auteur;
import entity.Chercheur;
import entity.Ecrire;
import entity.EcrirePK;
import entity.Publication;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class PublicationFacade extends AbstractFacade<Publication> {
    @PersistenceContext(unitName = "stagePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PublicationFacade() {
        super(Publication.class);
    }
   public String ExistePublication(String titre){	
		
		List list=new ArrayList();
		
		try{
                       Query query=  em.createNamedQuery("Publication.findAll");
			    list=query.getResultList();
                            
                        BigInteger bigInt = null;
                        BigInteger bigp = null;
      
           titre= titre.replaceAll(" ", "");
      titre=  titre.toLowerCase();
          MessageDigest m = MessageDigest.getInstance("MD5");
          m.reset();
          
          m.update(titre.getBytes());
          byte[] digest = m.digest();
         bigInt = new BigInteger(1,digest);
         int i=0;
         while(i<list.size())
         { Publication p=(Publication)list.get(i);
         String t=p.getTitre();
         t= t.replaceAll(" ", "");
      t=  t.toLowerCase();
              m.update((t).getBytes());
          byte[] digestp = m.digest();
         bigp = new BigInteger(1,digestp);
         if(bigp.equals(bigInt))
             return ((Publication)list.get(i)).getIdCh().getPrenomCh()+" "+((Publication)list.get(i)).getIdCh().getNomCh();
             //return true;
         i++;
         }
                           return "";
         
      } catch (NoSuchAlgorithmException ex) {
          System.out.println("erreur hashage"+ ex);
          return "inconu";
      }       
                         
			
			catch(Exception e)
			{e.printStackTrace(); return "inconnu";}
			
			
			
}	
public void insert (Publication p)
{
    em.persist(p);
   
}
 public void associerEcrire(ArrayList l,Publication p)
 {
     List listEcrire=new ArrayList();
       
       System.out.println("list aut "+l); 
       System.out.println("pub "+p.getIdPub());
     for(int i=0;i<l.size();i++)
     { Ecrire eid=new Ecrire();
         eid.setAuteur((Auteur) l.get(i));
         eid.setPublication(p);
         eid.setEcrirePK(new EcrirePK(p.getIdPub(), ((Auteur) l.get(i)).getIdAut()));
        
         eid.setRang(i);
         em.persist(eid);
         //listEcrire.add(eid);
         
              }
	//p.setEcrireList(listEcrire);
	
     }
}
