package br.edu.ifsul.controle;

import br.edu.ifsul.dao.EquipamentoDAO;
import br.edu.ifsul.dao.OrdemServicoDAO;
import br.edu.ifsul.dao.EstadoDAO;
import br.edu.ifsul.dao.PessoaFisicaDAO;
import br.edu.ifsul.dao.ProdutoDAO;
import br.edu.ifsul.dao.ServicoDAO;
import br.edu.ifsul.dao.UsuarioDAO;
import br.edu.ifsul.modelo.OrdemServico;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Diego Soria Rios
 * @email diegosoriarios@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
@Named(value = "controleOrdemServico")
@ViewScoped
public class ControleOrdemServico implements Serializable {

    @EJB
    private OrdemServicoDAO dao;
    private OrdemServico objeto;
    @EJB
    private UsuarioDAO usuarioDAO;
    @EJB
    private PessoaFisicaDAO pessoaFisicaDAO;
    @EJB
    private ServicoDAO servicoDAO;
    @EJB
    private EquipamentoDAO equipamentoDAO;
    @EJB
    private ProdutoDAO produtoDAO;
    
    public ControleOrdemServico(){
        
    }
    
    public String listar(){
        return "/privado/ordemservico/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new OrdemServico();        
    }
    
    public void alterar(Object id){
        try {
            objeto = dao.getObjectById(id);
        } catch (Exception e){
            Util.mensagemErro("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void remover(Object id){
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e){
            Util.mensagemErro("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void salvar(){
        try {
            if (objeto.getId() == null){
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e){
            Util.mensagemErro("Erro ao persistir objeto: " + Util.getMensagemErro(e));
        }
    }

    public OrdemServicoDAO getDao() {
        return dao;
    }

    public void setDao(OrdemServicoDAO dao) {
        this.dao = dao;
    }

    public OrdemServico getObjeto() {
        return objeto;
    }

    public void setObjeto(OrdemServico objeto) {
        this.objeto = objeto;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public PessoaFisicaDAO getPessoaFisicaDAO() {
        return pessoaFisicaDAO;
    }

    public void setPessoaFisicaDAO(PessoaFisicaDAO pessoaFisicaDAO) {
        this.pessoaFisicaDAO = pessoaFisicaDAO;
    }

    public ServicoDAO getServicoDAO() {
        return servicoDAO;
    }

    public void setServicoDAO(ServicoDAO servicoDAO) {
        this.servicoDAO = servicoDAO;
    }

    public EquipamentoDAO getEquipamentoDAO() {
        return equipamentoDAO;
    }

    public void setEquipamentoDAO(EquipamentoDAO equipamentoDAO) {
        this.equipamentoDAO = equipamentoDAO;
    }

    public ProdutoDAO getProdutoDAO() {
        return produtoDAO;
    }

    public void setProdutoDAO(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }


}
