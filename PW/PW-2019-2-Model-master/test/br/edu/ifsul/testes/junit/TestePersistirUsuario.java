/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 20172PF.CC0095
 */
public class TestePersistirUsuario {
    
    public TestePersistirUsuario() {
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
    public void teste() {
        boolean exception = false;
        try {
            Usuario user = new Usuario();
            user.setNomeUsuario("diegosoriarios");
            user.setEmail("diegosoriarios@gmail.com");
            user.setNome("Diego Soria Rios");
            user.setSenha("123456");
            user.setTelefonePrincipal("54 991907331");
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch(Exception e) {
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
}
