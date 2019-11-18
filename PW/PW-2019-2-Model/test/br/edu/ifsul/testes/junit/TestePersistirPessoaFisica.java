package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Usuario;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
    public void teste(){
        boolean exception = false;
        try {
            PessoaFisica obj = new PessoaFisica();
            obj.setEmail("diegosoriarios@gmail.com");
            obj.setNome("Diego Soria Rios");
            obj.setNomeUsuario("diegosoriariospf");
            obj.setSenha("123456");
            obj.setTelefoneAlternativo("(54)89387-9876");
            obj.setTelefonePrincipal("(54)98773-0987");
            
            obj.setBairro("Centro");
            obj.setCep("99010-290");
            obj.setCidade(em.find(Cidade.class, 2));
            obj.setCpf("986.674.540-60");
            obj.setEndereco("Av Brasil");
            obj.setNascimento(new GregorianCalendar(1979, Calendar.OCTOBER, 25));
            obj.setNumero("500");
            obj.setReferencia("Perto mercado");
            obj.setRg("8452036987");
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }

}