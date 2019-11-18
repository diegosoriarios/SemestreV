package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.ItemServico;
import br.edu.ifsul.modelo.OrdemServico;
import br.edu.ifsul.modelo.Servico;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Diego
 */
public class TestePersistirItemServicoOS {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirItemServicoOS() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("PW-2019-2-ModelPU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void teste() throws IOException {
        OrdemServico os = em.find(OrdemServico.class, 1);
        ItemServico is = new ItemServico();
        is.setServico(em.find(Servico.class, 1));
        is.setQuantidade(1);
        is.setValorUnitario(is.getServico().getValor());
        is.setValorTotal(is.getValorUnitario() * is.getQuantidade());
        os.adicionarServico(is);            
        em.getTransaction().begin();
        em.persist(is);
        em.getTransaction().commit();
    }

}
