package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
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
 * @author Diego Soria Rios
 * @email diegosoriarios@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
@Entity
@Table(name = "estado")
public class Estado implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_estado", sequenceName = "seq_estado_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_estado", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "O nome não pode ser branco")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")    
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @NotBlank(message = "A UF não pode ser branco")
    @Length(max = 2, message = "A UF não pode ter mais que {max} caracteres")    
    @Column(name = "uf", length = 2, nullable = false)
    private String uf;
    
    public Estado(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

}
