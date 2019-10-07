/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.DAO;

import java.io.Serializable;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author 20172PF.CC0095
 */
@FacesConverter(value = "converterOrdem")
public class ConverterOrdem implements Serializable, Converter{
    
    private List<Ordem> listaOrdem;

    public ConverterOrdem(List<Ordem> listaOrdem) {
        this.listaOrdem = listaOrdem;
    }
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Ordem retorno = null;
        for (Ordem o: listaOrdem) {
            if (o.getAtributo().equals(string)) {
                retorno = o;
            }
        }
        
        return retorno;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if (t == null) {
            return null;
        }
        
        Ordem o = (Ordem) t;
        
        return o.getAtributo();
    }

    public List<Ordem> getListaOrdem() {
        return listaOrdem;
    }

    public void setListaOrdem(List<Ordem> listaOrdem) {
        this.listaOrdem = listaOrdem;
    }
    
    
    
    
}
