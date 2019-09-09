/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsul.edu.controle;

import br.edu.ifsul.ejb.BeanContador;
import br.edu.ifsul.ejb.BeanHora;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author 20172PF.CC0095
 */
@Named
@RequestScoped
public class ControleBeanHora implements Serializable {
    @EJB
    private BeanHora beanHora;
    
    @Inject
    private ControleUsuario controleUsuario;
    
    public ControleBeanHora() {
        
    }

    public String getUsuario() {
        return controleUsuario.getBeanUsuario().getUsuario() != null ?
                controleUsuario.getBeanUsuario().getUsuario() : "Usuário não informado!";
    }
    
    public BeanHora getBeanHora() {
        return beanHora;
    }

    public void setBeanHora(BeanHora beanHora) {
        this.beanHora = beanHora;
    }

    public ControleUsuario getControleUsuario() {
        return controleUsuario;
    }

    public void setControleUsuario(ControleUsuario controleUsuario) {
        this.controleUsuario = controleUsuario;
    }
    
    
    
}
