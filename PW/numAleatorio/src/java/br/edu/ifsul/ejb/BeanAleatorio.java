/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.ejb;

import java.io.Serializable;
import java.util.Random;
import javax.ejb.Stateless;

/**
 *
 * @author 20172PF.CC0095
 */
@Stateless
public class BeanAleatorio implements Serializable {
    private int numero;

    public BeanAleatorio() {
        numero = 0;
    }
    
    public int getRandomNum() {
        return numero = new Random().nextInt(101);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
}
