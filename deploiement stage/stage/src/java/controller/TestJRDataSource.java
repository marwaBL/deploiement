/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Chercheur;
import java.io.Serializable;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author USER1
 */
public class TestJRDataSource implements JRDataSource, Serializable
{

    private String[] fields;
    private List list;
    private Chercheur currentValue;
    private String nomCh;
    private int currentRowNumber;

    public TestJRDataSource(List list, String[] fields)
    {
        this.fields = fields;
        this.list = list;
        this.currentRowNumber = 0;
    }

    public Object getFieldValue(JRField field) throws JRException
    {
        Object value = null;
        int index = getFieldIndex(field.getName());
        if (index > -1 && currentValue != null)
        {
            Object values =  currentValue;
            nomCh=currentValue.getNomCh();
            System.out.println("field "+field.getName());
            System.out.println("index "+index);
            System.out.println("curr "+values);
            value=values;
           // value = values.get(index);
        }
        return value;
    }

    public boolean next() throws JRException
    {
        ListIterator iterator = this.list.listIterator(currentRowNumber);
        currentValue = (Chercheur) (iterator.hasNext() ? iterator.next() : null);
        if(currentValue != null)
        {
            this.currentRowNumber++;
        }
        else
        {
        }
        return (currentValue != null);
    }

    private int getFieldIndex(String field)
    {
        int index = -1;
        for (int i = 0; i < fields.length; i++)
        {
            if (fields[i].equals(field))
            {
                index = i;
                break;
            }
        }
        return index;
    }

    public String getNomCh() {
        return nomCh;
    }

    public void setNomCh(String nomCh) {
        this.nomCh = nomCh;
    }
    
} 