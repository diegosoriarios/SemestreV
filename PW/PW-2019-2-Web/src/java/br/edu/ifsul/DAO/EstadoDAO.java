package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Estado;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Diego Soria Rios
 * @email diegosoriarios@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
@Stateful
public class EstadoDAO extends DAOGenerico<Estado> implements Serializable {
    
    public EstadoDAO(){
        super();
        classePersistente = Estado.class;
        // adicionar as ordenações possiveis
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        // definir a ordem padrão
        ordemAtual = listaOrdem.get(1);
        // inicalizar o conversor com a lista de ordens
        converterOrdem = new ConverterOrdem(listaOrdem);        
    }

}
