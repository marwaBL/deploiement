/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Etablissement;
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
public class EtablissementFacade extends AbstractFacade<Etablissement> {
    @PersistenceContext(unitName = "stagePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EtablissementFacade() {
        super(Etablissement.class);
    }
    public List findListEtablissementByUniv(String univlib)
    { List res=new ArrayList();
          try
         {  Query q=  em.createQuery(" select c FROM Etablissement c where c.codeUniv.libUniv  =:id" );
      
           
              q.setParameter("id", univlib);
        List<Etablissement> l=q.getResultList();
        for(int i=0;i<l.size();i++)
            res.add(((Etablissement)l.get(i)).getLibEtab());
     return res;
         }catch(Exception e)
         {
             System.out.println("erreur "+e);
             return null;
         
         }
         
         
    }
    
    
}
