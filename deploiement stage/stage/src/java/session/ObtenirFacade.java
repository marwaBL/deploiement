/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Obtenir;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author USER1
 */
@Stateless
public class ObtenirFacade extends AbstractFacade<Obtenir> {
    @PersistenceContext(unitName = "stagePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ObtenirFacade() {
        super(Obtenir.class);
    }
    
}
