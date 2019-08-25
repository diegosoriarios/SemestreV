/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author diego.rios
 */

@Entity
@Table(name = "tipo_adicional")
public class TipoAdicional implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_tipo_adicional", sequenceName = "seq_tipo_adicional_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_tipo_adicional", strategy = GenerationType.SEQUENCE)
    private int id;
    
    @NotBlank(message = "O nome não pode ser branco")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @Column(name = "valor", nullable = false)
    private double valor;

    public TipoAdicional() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
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
        final TipoAdicional other = (TipoAdicional) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
