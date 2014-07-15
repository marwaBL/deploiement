/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Chercheur;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.ListDataModel;
import javax.validation.Validation;

import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author USER1
 */
public class modeleController extends ListDataModel<Chercheur> implements SelectableDataModel<Chercheur> {


    
    public modeleController( ArrayList<Chercheur> ch) {
        super(ch);
    }
    
    @Override
    public Chercheur getRowData(String rowKey) {
        
       List<Chercheur> chs = (List<Chercheur>) getWrappedData();
        
        for(Chercheur ch : chs) {
            if(ch.getNomCh().equals(rowKey))
                return ch;
        }
        
        
        return null;
    }
    
    @Override  
    public Object getRowKey(Chercheur ch) {
System.out.println("aaaaaaaa"+ch.getNomCh());     
return ch.getNomCh();  
    }  

   
   
  
  
}
