/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controler;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author 20172PF.CC0095
 */
@ManagedBean(name = "controleIMC")
@ViewScoped
public class controleIMC implements Serializable {
    private float peso;
    private float altura;
    private float imc;
    private String classificacao;
    private Boolean exibir;
    
    public controleIMC() {
        exibir = true;
    }
    
    public void calculaIMC() {
        imc = peso / (altura * altura);
        
        if(imc < 18.5) {
            classificacao = "Magreza";
        } else {
            if(imc < 24.9) {
                classificacao = "Normal";
            } else {
                if(imc < 29.9) {
                    classificacao = "Sobrepeso";
                } else {
                    if (imc < 39.9) {
                        classificacao = "Obesidade";
                    } else {
                        classificacao = "Obesidade Grave";
                    }
                }
            }
        }
        exibir = false;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Boolean getExibir() {
        return exibir;
    }

    public void setExibir(Boolean exibir) {
        this.exibir = exibir;
    }
    
    
    
    
}
