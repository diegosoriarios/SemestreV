package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Equipamento;
import br.edu.ifsul.modelo.FormaPagamento;
import br.edu.ifsul.modelo.OrdemServico;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Status;
import br.edu.ifsul.modelo.Usuario;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Jorge
 */
public class TestePersistirContaReceber {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirContaReceber() {
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
    public void teste(){
        OrdemServico obj = em.find(OrdemServico.class, 4);
        obj.gerarParcelas();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit(); 
    }
    
}
