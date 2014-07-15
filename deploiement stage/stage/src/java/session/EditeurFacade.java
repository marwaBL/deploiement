/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Editeur;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author USER1
 */
@Stateless
public class EditeurFacade extends AbstractFacade<Editeur> {
    @PersistenceContext(unitName = "stagePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EditeurFacade() {
        super(Editeur.class);
    }
     public boolean EditeurPub(List l,String nom,String prenom)
 {
     int i=0;
     System.out.println("editeur "+l);
     while(i<l.size())
     {
         if(((Editeur)l.get(i)).getNomEd().equalsIgnoreCase(nom)&&((Editeur)l.get(i)).getPrenomEd().equalsIgnoreCase(prenom))
  return true;
             i++;
             }
     return false;
     
 }
 
 public void ajoutNouveauEditeur(String nom,String prenom)
 {
     
              
        Editeur a=new Editeur();
       a.setNomEd(nom);
       a.setPrenomEd(prenom);
	em.persist(a);
	System.out.println("Data Saved");
       
 }
         
     
     
 
 
 
 



}
