package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class TestePersistirEstado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estado e = new Estado();
        e.setNome("Rio Grande do Sul");
        e.setUf("RS");
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("PW-2019-2-ModelPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
