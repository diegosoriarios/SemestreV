/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author 20172PF.CC0095
 */
@Embeddable
public class ContaReceberID implements Serializable {
    @NotNull(message = "O numero da parcela deve ser informada")
    @Column(name = "numero_parcela", nullable = false)
    private Integer numeroParcela;
    
    @NotNull(message = "A ordem de serviço deve ser informada")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordem_servico", nullable = false, referencedColumnName = "id")
    private OrdemServico ordemServico;

    public ContaReceberID() {
    }
    
    public Integer getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(Integer numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.numeroParcela);
        hash = 23 * hash + Objects.hashCode(this.ordemServico);
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
        final ContaReceberID other = (ContaReceberID) obj;
        if (!Objects.equals(this.numeroParcela, other.numeroParcela)) {
            return false;
        }
        if (!Objects.equals(this.ordemServico, other.ordemServico)) {
            return false;
        }
        return true;
    }
    
    
}
