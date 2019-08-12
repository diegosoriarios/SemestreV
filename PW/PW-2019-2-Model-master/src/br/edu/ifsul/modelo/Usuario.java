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
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author 20172PF.CC0095
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
public class Usuario implements Serializable {
    @Id
    @NotBlank(message = "O nome do usuário deve ser informado")
    @Length(max = 20, message = "O nome do usuário não poder ter mais que {max} caracteres")
    @Column(name = "nome_usuario", length = 20, nullable = false)
    private String nomeUsuario;
    
    @NotBlank(message = "A senha deve ser informada")
    @Length(max = 20, message = "A senha não poder ter mais que {max} caracteres")
    @Column(name = "senha", length = 20, nullable = false)
    private String senha;
    
    @NotNull(message = "A data de cadastro deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro", nullable = false)
    private Calendar dataCadastro;
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não poder ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @NotBlank(message = "O email deve ser informado")
    @Length(max = 60, message = "O email não poder ter mais que {max} caracteres")
    @Column(name = "email", length = 60, nullable = false)
    private String email;
    
    @NotBlank(message = "O telefone principal deve ser informada")
    @Length(max = 14, message = "O telefone principal não poder ter mais que {max} caracteres")
    @Column(name = "telefone_principal", length = 14, nullable = false)
    private String telefonePrincipal;
    
    @Length(max = 14, message = "O telefone alternativo não poder ter mais que {max} caracteres")
    @Column(name = "telefone_alternativo", length = 14)
    private String telefoneAlternativo;

    public Usuario() {
        dataCadastro = Calendar.getInstance();
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuário) {
        this.nomeUsuario = nomeUsuário;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonePrincipal() {
        return telefonePrincipal;
    }

    public void setTelefonePrincipal(String telefonePrincipal) {
        this.telefonePrincipal = telefonePrincipal;
    }

    public String getTelefoneAlternativo() {
        return telefoneAlternativo;
    }

    public void setTelefoneAlternativo(String telefoneAlternativo) {
        this.telefoneAlternativo = telefoneAlternativo;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nomeUsuario);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nomeUsuario, other.nomeUsuario)) {
            return false;
        }
        return true;
    }
    
}
