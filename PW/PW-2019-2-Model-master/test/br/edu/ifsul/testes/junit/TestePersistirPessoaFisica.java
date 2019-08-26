/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.PessoaFisica;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class TestePersistirPessoaFisica {
    
    public TestePersistirPessoaFisica() {
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
            PessoaFisica user = new PessoaFisica();
            user.setNomeUsuario("diegosoriariospf");
            user.setEmail("diegosoriarios@gmail.com");
            user.setNome("Diego Soria Rios");
            user.setSenha("123456");
            user.setTelefonePrincipal("54 991907331");
            user.setBairro("Centro");
            user.setCep("99010-060");
            user.setCpf("986.674.540-60");
            user.setEndereco("Capitao Eleuterio");
            user.setNumero("337");
            user.setComplemento("Apt 804");
            user.setReferencia("Caixa Economica");
            user.setRg("1123456742");
            user.setNascimento(new GregorianCalendar(1995, Calendar.DECEMBER, 11));
            user.setCidade(em.find(Cidade.class, 2));
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
