package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.Produto;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class TestePersistirProduto {

    public TestePersistirProduto() {
    }
    
    EntityManagerFactory emf = null;
    EntityManager em = null;

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
        boolean exception = false;
        try {
            Marca m1 = new Marca();
            m1.setNome("Acer");
            Produto p = new Produto();
            p.setNome("Notebook Core i7");
            p.setDescricao("Notebook core i1 com 8GB de Ram");
            p.setPreco(2500.00);
            p.setMarca(m1);
            em.getTransaction().begin();
            em.persist(m1);
            em.persist(p);
            em.getTransaction().commit();           
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }

}