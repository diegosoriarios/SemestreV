package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
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
public class TesteListarEstados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("PW-2019-2-ModelPU");
        EntityManager em = emf.createEntityManager();
        List<Estado> lista = 
                em.createQuery("from Estado order by nome").getResultList();
        for (Estado e : lista){
            System.out.println("ID: " + e.getId() + " Nome: " + e.getNome() + 
                    " UF: " + e.getUf());
        }
        
        em.close();
        emf.close();
    }

}
