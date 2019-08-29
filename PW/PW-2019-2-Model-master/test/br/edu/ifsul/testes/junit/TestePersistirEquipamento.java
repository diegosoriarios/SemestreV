package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Equipamento;
import br.edu.ifsul.modelo.Marca;
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
public class TestePersistirEquipamento {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirEquipamento() {
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
        Equipamento obj = new Equipamento();
        obj.setDescricao("Notebook Dell Vostro 3550");
        obj.setNumeroSerie("123456789");
        obj.setMarca(em.find(Marca.class,1));
        em.getTransaction().begin();
        em.persist(obj);        
        em.getTransaction().commit();        
    }
    
}
