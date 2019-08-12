/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author 20172PF.CC0095
 */
@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Usuario implements Serializable {
    @NotBlank(message = "O CPF deve ser informado")
    @Length(max = 14, message = "O CPF não pode ter mais que {max} caracteres")
    @CPF(message = "O CPF pode ser valido")
    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;
    
    @NotBlank(message = "O CPF deve ser informado")
    @Length(max = 14, message = "O CPF não pode ter mais que {max} caracteres")
    @Column(name = "rg", length = 10, nullable = false)
    private String rg;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "O nascimento deve ser informado")
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;
    
    @NotBlank(message = "O endereço deve ser informado")
    @Length(max = 50, message = "O endereço não pode ter mais que {max} caracteres")
    @Column(name = "endereco", length = 50, nullable = false)
    private String endereco;
    
    @NotBlank(message = "O numero deve ser informado")
    @Length(max = 5, message = "O numero não pode ter mais que {max} caracteres")
    @Column(name = "numero", length = 5, nullable = false)
    private String numero;
    
    @Length(max = 10, message = "O complemento não poder ter mais que {max} caracteres")
    @Column(name = "complemento", length = 10)
    private String complemento;
    
    @NotBlank(message = "O CEP deve ser informado")
    @Length(max = 9, message = "O CEP não pode ter mais que {max} caracteres")
    @Column(name = "cep", length = 9, nullable = false)
    private String cep;
    
    @NotBlank(message = "O bairro deve ser informado")
    @Length(max = 30, message = "O bairro não pode ter mais que {max} caracteres")
    @Column(name = "bairro", length = 30, nullable = false)
    private String bairro;
    
    @Length(max = 20, message = "A referencia não poder ter mais que {max} caracteres")
    @Column(name = "referencia", length = 20)
    private String referencia;
    
    @ManyToOne
    @NotNull(message = "A cidade deve ser informada")
    @JoinColumn(name = "cidade", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_pf_cidade"))
    private Cidade cidade;

    public PessoaFisica() {
        
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }  
    
}
