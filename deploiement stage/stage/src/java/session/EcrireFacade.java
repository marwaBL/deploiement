/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Ecrire;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author USER1
 */
@Stateless
public class EcrireFacade extends AbstractFacade<Ecrire> {
    @PersistenceContext(unitName = "stagePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EcrireFacade() {
        super(Ecrire.class);
    }
    
}
