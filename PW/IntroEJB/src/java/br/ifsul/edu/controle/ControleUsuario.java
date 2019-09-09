/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsul.edu.controle;

import br.edu.ifsul.ejb.BeanUsuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author 20172PF.CC0095
 */
@Named(value = "controleUsuario")
@SessionScoped
public class ControleUsuario implements Serializable {
    @EJB
    private BeanUsuario beanUsuario;

    public ControleUsuario() {
    }
    
    public String informarUsuario() {
        return "index?faces-redirect=true";
    }

    public BeanUsuario getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(BeanUsuario beanUsuario) {
        this.beanUsuario = beanUsuario;
    }
    
    
}
