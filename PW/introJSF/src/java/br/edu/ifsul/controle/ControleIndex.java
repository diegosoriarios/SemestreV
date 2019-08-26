/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import java.io.Serializable;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author 20172PF.CC0095
 */
@ManagedBean(name = "controleIndex")
@RequestScoped
public class ControleIndex implements Serializable{
    
    private String ola;
    private Calendar dataSO;

    public ControleIndex() {
        ola = "Seja bem vindo ao SJF";
        dataSO = Calendar.getInstance();
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
