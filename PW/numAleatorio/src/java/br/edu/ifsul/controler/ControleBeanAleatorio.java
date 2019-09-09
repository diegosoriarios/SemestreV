/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controler;

import java.io.Serializable;
import javax.ejb.EJB;
import br.edu.ifsul.ejb.BeanAleatorio;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author 20172PF.CC0095
 */
@Named
@RequestScoped
public class ControleBeanAleatorio implements Serializable{
    @EJB
    private BeanAleatorio beanAleatorio;

    public ControleBeanAleatorio() {
    }
    
    public int getNumeroAleatorio() {
        return beanAleatorio.getNumero();
    }

    public BeanAleatorio getBeanAleatorio() {
        return beanAleatorio;
    }

    public void setBeanAleatorio(BeanAleatorio beanAleatorio) {
        this.beanAleatorio = beanAleatorio;
    }
    
    
}
