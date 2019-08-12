package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Acessorios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class TesteListarAcessorios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("locadora_veiculos-ModelPU");
        EntityManager em = emf.createEntityManager();
        List<Acessorios> lista = 
                em.createQuery("from Acessorios order by nome").getResultList();
        for (Acessorios e : lista){
            System.out.println("ID: " + e.getId() + " Nome: " + e.getNome());
        }
        
        em.close();
        emf.close();
    }

}
