/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 20172PF.CC0095
 */
@ManagedBean(name = "controleFormulario")
@SessionScoped
public class ControleFormulario implements Serializable {
    private String nome;
    private String funcao;
    private Boolean ativo;

    public ControleFormulario() {
        
    }
    
    public String formulario() {
        return "/forms/formulario?faces-redirect=true";
    }
    
    public String processar() {
        return "dados?faces-redirect=true";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
    
    
}
