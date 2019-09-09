/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controler;

import br.edu.ifsul.ejb.BeanPessoas;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author 20172PF.CC0095
 */
@Named
@SessionScoped
public class ControleBeanPessoas implements Serializable{
    @EJB
    private BeanPessoas beanPessoas;

    public ControleBeanPessoas() {
    }
    
    public String informarPessoas() {
        beanPessoas.setNewPessoa();
        return "index?faces-redirect=true";
    }

    public BeanPessoas getBeanPessoas() {
        return beanPessoas;
    }

    public void setBeanPessoas(BeanPessoas beanPessoas) {
        this.beanPessoas = beanPessoas;
    }
    
    
}
