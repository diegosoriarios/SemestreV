package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Usuario;
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
public class TestePersistirPermissaoUsuario {

    public TestePersistirPermissaoUsuario() {
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
            Usuario u = em.find(Usuario.class, "diegosoriarios");   
            
            Permissao p1 = em.find(Permissao.class,"ADMINISTRADOR");
            
            Permissao p2 = em.find(Permissao.class, "USUARIO");
            
            u.getPermissoes().add(p1);
            u.getPermissoes().add(p2);
            
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }

}