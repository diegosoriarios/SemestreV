package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Acessorios;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class TesteAlterarAcessorios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("locadora_veiculos-ModelPU");
        EntityManager em = emf.createEntityManager();
        Acessorios a = em.find(Acessorios.class, 1);
        a.setNome("Mouse");
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
