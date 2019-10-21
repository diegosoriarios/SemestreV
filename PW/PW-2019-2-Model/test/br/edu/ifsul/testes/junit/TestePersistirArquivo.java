package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Arquivo;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.Produto;
import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Diego Soria Rios
 * @email diegosoriarios@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
public class TestePersistirArquivo {

    public TestePersistirArquivo() {
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
            Produto p1 = em.find(Produto.class, 1);
            Arquivo a = new Arquivo();
            a.setNomeArquivo("manual_iwr_3000_portugues_01-18_site_0.pdf");
            a.setDescricao("Manual");
            Path path = 
                    Paths.get("/home/Diego/Downloads/manual_iwr_3000_portugues_01-18_site_0.pdf");
            // No Windows Escreve-se desta maneira
            //Paths.get("c:\\home\\Diego\\Downloads\\manual_iwr_3000_portugues_01-18_site_0.pdf");
            a.setArquivo(Files.readAllBytes(path));
            p1.adicionarArquivo(a);
            
            
            em.getTransaction().begin();
            em.persist(p1);            
            em.getTransaction().commit();           
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }

}