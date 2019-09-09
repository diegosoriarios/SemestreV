/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.ejb;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 20172PF.CC0095
 */
@Stateless
public class BeanHora implements Serializable {
    @EJB
    private BeanContador beanContador;
    
    private List<String> nomes = new ArrayList<>();
    
    public BeanHora() {
        System.out.println("Executou o construtor do bean hora");
        nomes.add("Diego");
        nomes.add("Paulo");
        nomes.add("Daniel");
        nomes.add("Jorge");
    }
    
    public String getDataHoraServidor(){
        beanContador.incrementaContador();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SS");
        return sdf.format(Calendar.getInstance().getTime());
    }
    
    @PostConstruct
    public void iniciar() {
        System.out.println("Utilizou o método iniciar do Bean Hora");
    }
    
    @PreDestroy
    public void destruir(){
        System.out.println("Uso do metodo destruir");
    }

    public BeanContador getBeanContador() {
        return beanContador;
    }

    public void setBeanContador(BeanContador beanContador) {
        this.beanContador = beanContador;
    }

    public List<String> getNomes() {
        return nomes;
    }

    public void setNomes(List<String> nomes) {
        this.nomes = nomes;
    }
    
    
    
}
