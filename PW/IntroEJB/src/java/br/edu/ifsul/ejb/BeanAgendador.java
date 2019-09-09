/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.ejb;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author 20172PF.CC0095
 */
@Singleton
@Startup
public class BeanAgendador implements Serializable {
    @EJB
    BeanContador beanContador;

    public BeanAgendador() {
    }
    
    @Schedule(hour="*", minute="*", second = "*/30", persistent = false)
    public void zerarContador() {
        System.out.println("Vai zerar contador");
        beanContador.setContador(0);
    }
    
}
