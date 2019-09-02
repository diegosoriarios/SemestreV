/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author 20172PF.CC0095
 */
@ManagedBean(name = "controleAjax")
@ViewScoped
public class ControleAjax implements Serializable{
    private String entrada;
    private String saida;
    private Boolean exibir;

    public ControleAjax() {
        exibir = false;
    }
    
    public void processar() {
        saida = "Você digitou: " + entrada;
        entrada = "";
    }
    
    public void mudarExibir() {
        exibir = !exibir;
    }
    
    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }

    public Boolean getExibir() {
        return exibir;
    }

    public void setExibir(Boolean exibir) {
        this.exibir = exibir;
    }
    
    
    
}
