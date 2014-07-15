/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Structurerecherche;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import session.ChercheurFacade;
import session.StructurerechercheFacade;

/**
 *
 * @author Marwa
 */
@ManagedBean
@SessionScoped
public class compteController implements Serializable {
    @EJB
    private ChercheurFacade chercheurFacade;
    @EJB
    private StructurerechercheFacade structurerechercheFacade;
    
private String email;
    private String pass1;
    private String pass2;
private String type;
private String nom;
private String prenom;
    private String structure;
private List <Structurerecherche>  listlaboUnite;
private String typeCh;

    public String getTypeCh() {
        return typeCh;
    }

    public void setTypeCh(String typeCh) {
        this.typeCh = typeCh;
    }




    public String getEmail() {
        return email;
    }

   

   

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public List<Structurerecherche> getListlaboUnite() {
        return listlaboUnite;
    }

    public void setListlaboUnite(List<Structurerecherche> listlaboUnite) {
        this.listlaboUnite = listlaboUnite;
    }

    







   

public String getPass1() {
        return pass1;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    
    
    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }
    
    
    
    
    public compteController() {
       
    }
   
     public String findStructureByType()
    {
    listlaboUnite=structurerechercheFacade.findStructureByType(type);
        
        return "";
    }
    public void confirmermotdepasse()
    {
        System.out.println(pass1+"||"+pass2);
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null; 
        boolean loggedIn = false;
       if (!pass1.equals(pass2))
       {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur :mot de passe non comformes ", "mot de passe non comformes");
		// pageresult= "/erreur";
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);
        pass1="";pass2="";
        
       }
    }
    
    public String ajouter()
    {
        System.out.println("st "+structure);
       
       // System.out.println("st "+denomination); 
        Structurerecherche st =new Structurerecherche();
        st.setDenomination(structure);
        System.out.println("res  "+listlaboUnite.get(listlaboUnite.indexOf(st)).getCode());
        Structurerecherche labounite=listlaboUnite.get(listlaboUnite.indexOf(st));
        
        chercheurFacade.insert(email, pass1, nom, prenom,typeCh, labounite);
         RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null; 
        boolean loggedIn = false;
      
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Félicitation  ", "Vous etes bien inscrit");
		// pageresult= "/erreur";
                  FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);
        return "comptecree";
    }
    
    public String connexion()
    {
        return "connexion";
    }
}
