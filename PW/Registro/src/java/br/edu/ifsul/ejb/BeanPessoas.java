/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.ejb;

import br.edu.ifsul.models.Pessoas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author 20172PF.CC0095
 */
@Stateful
public class BeanPessoas implements Serializable{
    private List<Pessoas> nomes = new ArrayList<>();
    private String nome;
    private int idade;

    public BeanPessoas() {
    }

    public List<Pessoas> setNewPessoa(){
        Pessoas p = new Pessoas(nome, idade);
        nomes.add(p);
        return nomes;
    }
    
    public List<Pessoas> getNomes() {
        return nomes;
    }

    public void setNomes(List<Pessoas> nomes) {
        this.nomes = nomes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    
}
