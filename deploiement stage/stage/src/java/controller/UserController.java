/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Chercheur;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import session.ChercheurFacade;


/**
 *
 * @author Marwa
 */
@ManagedBean
@SessionScoped
public class UserController implements Serializable {
    @EJB
    private ChercheurFacade chercheurFacade;
   
 private  boolean isloggedin;
    private String login;
    private String password;
    
    
    
    public UserController() {
    
    
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String dologin()
    {
        System.out.println("login....");   
//User u = null; 
       // userFacade.Connexion(login, password);
 RequestContext context = RequestContext.getCurrentInstance(); 
  FacesContext facesContext = FacesContext.getCurrentInstance();
    FacesMessage msg = null;  
    boolean loggedIn = false;  
 /*if(u==null)
    {    System.out.println("user "+login+ password);
      
     
        loggedIn = false; 
         msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur d'authentification", "Login et/ou password invalide");
         //    res= "welcomePrimefaces";
              FacesContext.getCurrentInstance().addMessage(null, msg);  
    context.addCallbackParam("loggedIn", loggedIn);  
    return "failed";
    }
 else
 {
     HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        System.out.println(u.getChercheurList().size());
     if( u.getChercheurList().size()!=0)
        {session.setAttribute("user", u.getChercheurList().get(0));
    //    res="accueil";
        loggedIn = true; 
         msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Authentification", "Login et password valides");
         //    res= "welcomePrimefaces";
              FacesContext.getCurrentInstance().addMessage(null, msg);  
    context.addCallbackParam("loggedIn", loggedIn); 
        }
   return "succes";
 }*/
        return "";
       
    }
    
    
     public String dolog()
    {
        System.out.println("login....");   
//User u= userFacade.Connexion(login, password);
 Chercheur ch=chercheurFacade.login(login, password);
        RequestContext context = RequestContext.getCurrentInstance(); 
  FacesContext facesContext = FacesContext.getCurrentInstance();
    FacesMessage msg = null;  
    boolean loggedIn = false;  
 if(ch==null)
    {    System.out.println("user "+login+ password);
      
     
        loggedIn = false; 
         msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur d'authentification", "Login et/ou password invalide");
         //    res= "welcomePrimefaces";
              FacesContext.getCurrentInstance().addMessage(null, msg);  
    context.addCallbackParam("loggedIn", loggedIn);  
    return "failed";
    }
 else
 {
     if(ch.getEtat().equals("inactive"))
         return "inactive";
      HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
       
     
        session.setAttribute("user", ch);
     isloggedin=true;
   return "succes";
 }
        //return "";
    }
    public String compte()
    {
        System.out.println("compte");
        return "compte";
    }
    
     public String logout() {
   System.out.println("logout appelé");
  
   isloggedin=false;
   FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
  
   return "logout";
  }  
  
    
    
}
