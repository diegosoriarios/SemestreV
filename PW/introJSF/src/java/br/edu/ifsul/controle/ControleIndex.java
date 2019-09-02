/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import java.io.Serializable;
import java.util.Calendar;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author 20172PF.CC0095
 */
@ManagedBean(name = "controleIndex")
@RequestScoped // ciclo de vida de requisição
//@SessionScoped // ciclo de vida de sessão
//@ApplicationScoped // ciclo de aplicacao
public class ControleIndex implements Serializable{
    
    private String ola;
    private Calendar dataSO;

    public ControleIndex() {
        ola = "Seja bem vindo ao SJF";
        dataSO = Calendar.getInstance();
    }
    
    public String sobre(){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage("Navegando ao arquivo sobre.xhtml");
        context.addMessage(null, message);
        return "/sobre?faces-redirect=true";
    }
    
    public String index() {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage("Navegando ao arquivo index.xhtml");
        context.addMessage(null, message);
        return "/index?faces-redirect=true";
    }

    public String getOla() {
        return ola;
    }

    public void setOla(String ola) {
        this.ola = ola;
    }

    public Calendar getDataSO() {
        return dataSO;
    }

    public void setDataSO(Calendar dataSO) {
        this.dataSO = dataSO;
    }
    
    
}
