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
 * @author Diego
 */
public class TestePersistirOrdemServico {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirOrdemServico() {
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
        OrdemServico obj = new OrdemServico();
        obj.setDataAbertura(Calendar.getInstance());        
        obj.setDataFechamento(Calendar.getInstance());
        obj.setDescricaoProblema("Windows com virus");        
        obj.setEquipamento(em.find(Equipamento.class, 1));
        obj.setFormaPagamento(FormaPagamento.AVISTA);
        obj.setPessoaFisica(em.find(PessoaFisica.class, "diegosoriariospf"));        
        obj.setResolucaoProblema("Formatação");
        obj.setStatus(Status.FECHADA);
        obj.setValorTotal(300.00);
        obj.setQuantidadeParcelas(3);
        obj.setUsuario(em.find(Usuario.class, "diegosoriarios"));        
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();        
    }
    
}
