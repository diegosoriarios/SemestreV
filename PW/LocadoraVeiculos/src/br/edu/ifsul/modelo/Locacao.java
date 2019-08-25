/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author diego.rios
 */

@Entity
@Table(name = "locacao")
public class Locacao implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_locacao", sequenceName = "seq_locacao_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_locacao", strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de locação deve ser informada")
    @Column(name = "data_locacao", nullable = false)
    private Calendar dataLocacao;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de devolução deve ser informada")
    @Column(name = "data_devolucao", nullable = false)
    private Calendar dataDevolucao;
    
    @Column(name = "valor_diaria", nullable = false)
    private double valorDiaria;
    
    @Column(name = "km_inicial", nullable = false)
    private int kmInicial;
    
    @Column(name = "km_final", nullable = false)
    private int kmFinal;
    
    @Column(name = "valor_total", nullable = false)
    private double valorTotal;

    public Locacao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Calendar dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Calendar getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Calendar dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public int getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(int kmInicial) {
        this.kmInicial = kmInicial;
    }

    public int getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(int kmFinal) {
        this.kmFinal = kmFinal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Locacao other = (Locacao) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
