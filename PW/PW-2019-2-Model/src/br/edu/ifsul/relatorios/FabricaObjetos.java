package br.edu.ifsul.relatorios;

import br.edu.ifsul.modelo.Equipamento;
import br.edu.ifsul.modelo.FormaPagamento;
import br.edu.ifsul.modelo.ItemServico;
import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.OrdemServico;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Produto;
import br.edu.ifsul.modelo.Servico;
import br.edu.ifsul.modelo.Status;
import br.edu.ifsul.modelo.Usuario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Diego Soria Rios
 * @email diegosoriarios@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
public class FabricaObjetos {
    
    public static List<Produto> carregaProdutos(){
        List<Produto> lista = new ArrayList<>();
        Marca m = new Marca();
        m.setNome("Dell");
        Produto p = new Produto();
        p.setNome("Notebook Gamer");
        p.setMarca(m);
        p.setPreco(3000.00);
        lista.add(p);
        Produto p1 = new Produto();
        p1.setNome("Mouse Laser");
        p1.setMarca(m);
        p1.setPreco(80.00);
        lista.add(p1);        
        return lista;
    }
    
    public static List<OrdemServico> carregaOrdem() {
        List<OrdemServico> lista = new ArrayList<>();
        OrdemServico ordem = new OrdemServico();
        lista.add(ordem);
        ordem.setDataAbertura(Calendar.getInstance());
        ordem.setDataFechamento(Calendar.getInstance());
        ordem.setDescricaoProblema("Netbeans não abre");
        ordem.setFormaPagamento(FormaPagamento.APRAZO);
        ordem.setId(1);
        ordem.setQuantidadeParcelas(3);
        ordem.setResolucaoProblema("Reinstalar o software");
        ordem.setStatus(Status.ABERTA);
        
        Equipamento e = new Equipamento();
        e.setNumeroSerie("123456");
        e.setDescricao("Notebook Acer");
        ordem.setEquipamento(e);
        
        PessoaFisica pf = new PessoaFisica();
        pf.setNome("Eu Mesmo");
        pf.setCpf("123.456.789-00");
        ordem.setPessoaFisica(pf);
        
        Usuario u = new Usuario();
        u.setNome("Diego");
        u.setNomeUsuario("diegosoriarios");
        ordem.setUsuario(u);
        
        Servico s = new Servico();
        s.setNome("Instalação de software");
        
        ItemServico is = new ItemServico();
        is.setServico(s);
        is.setQuantidade(1);
        is.setValorUnitario(100.00);
        is.setValorTotal(100.00);
        ordem.adicionarServico(is);
        
        return lista;
    }

}