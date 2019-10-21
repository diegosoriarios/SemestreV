package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Equipamento;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Diego Soria Rios
 * @email diegosoriarios@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
@Stateful
public class EquipamentoDAO extends DAOGenerico<Equipamento> implements Serializable {
    
    public EquipamentoDAO(){
        super();
        classePersistente = Equipamento.class;
        // adicionar as ordenações possiveis
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("descricao", "Descrição", "like"));
        listaOrdem.add(new Ordem("numeroSerie", "Numero de série", "like"));
        // definir a ordem padrão
        ordemAtual = listaOrdem.get(0);
        // inicalizar o conversor com a lista de ordens
        converterOrdem = new ConverterOrdem(listaOrdem);               
    }
    
}
