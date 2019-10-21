package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.PessoaFisica;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Diego Soria Rios
 * @email diegosoriarios@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
@Stateful
public class PessoaFisicaDAO extends DAOGenerico<PessoaFisica> implements Serializable {
    
    public PessoaFisicaDAO(){
        super();
        classePersistente = PessoaFisica.class;
        // adicionar as ordenações possiveis
        listaOrdem.add(new Ordem("nomeUsuario", "Nome Usuário", "like"));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));  
        // definir a ordem padrão
        ordemAtual = listaOrdem.get(1);
        // inicalizar o conversor com a lista de ordens'
        converterOrdem = new ConverterOrdem(listaOrdem);               
    }

    @Override
    public PessoaFisica getObjectById(Object id) {
        PessoaFisica obj = em.find(PessoaFisica.class, id);
        
        obj.getPermissoes().size();
        return obj;
    }

    
}
