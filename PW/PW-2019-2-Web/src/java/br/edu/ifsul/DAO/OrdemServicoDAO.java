package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.OrdemServico;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Diego Soria Rios
 * @email diegosoriarios@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
@Stateful
public class OrdemServicoDAO extends DAOGenerico<OrdemServico> implements Serializable {
    
    public OrdemServicoDAO(){
        super();
        classePersistente = OrdemServico.class;
        // adicionar as ordenações possiveis
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("pessoaFisica.nome", "Pessoa Fisica", "like"));
        listaOrdem.add(new Ordem("usuario.nome", "Usuário", "like"));
        listaOrdem.add(new Ordem("equipamento.descricao", "Equipamento Descrição",
                "like"));
        listaOrdem.add(new Ordem("equipamento.numeroSerie", "Equipamento Numero Série",
                "like"));
        listaOrdem.add(new Ordem("status", "Status", "like"));
        // definir a ordem padrão
        ordemAtual = listaOrdem.get(0);
        // inicalizar o conversor com a lista de ordens
        converterOrdem = new ConverterOrdem(listaOrdem);               
    }
    
    @Override
    public OrdemServico getObjectById(Object id){
        OrdemServico obj = em.find(OrdemServico.class, id);
        // Deve-se inicializar as coleções para não dar o erro 
        // lazyinicializationException
        obj.getListaServicos().size();
        obj.getContasReceber().size();
        return obj;
    }
    

}
