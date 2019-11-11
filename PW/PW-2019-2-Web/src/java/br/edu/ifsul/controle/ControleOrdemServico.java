package br.edu.ifsul.controle;

import br.edu.ifsul.dao.EquipamentoDAO;
import br.edu.ifsul.dao.OrdemServicoDAO;
import br.edu.ifsul.dao.EstadoDAO;
import br.edu.ifsul.dao.PessoaFisicaDAO;
import br.edu.ifsul.dao.ProdutoDAO;
import br.edu.ifsul.dao.ServicoDAO;
import br.edu.ifsul.dao.UsuarioDAO;
import br.edu.ifsul.modelo.ItemServico;
import br.edu.ifsul.modelo.OrdemServico;
import br.edu.ifsul.util.Util;
import br.edu.ifsul.util.UtilRelatorios;
import java.io.Serializable;
import java.util.HashMap;
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
    private UsuarioDAO daoUsuario;
    @EJB
    private PessoaFisicaDAO daoPessoaFisica;
    @EJB
    private ServicoDAO daoServico;
    @EJB
    private EquipamentoDAO daoEquipamento;
    @EJB
    private ProdutoDAO daoProduto;
    private ItemServico itemServico;
    private Boolean novoItemServico;
    
    public ControleOrdemServico(){}
    
    public void imprimeProdutos() {
        HashMap parametros = new HashMap();
        UtilRelatorios.imprimeRelatorio("relatorioProdutos", parametros, daoProduto.getListaTodos());
    }
    
    public void atualizaValorUnitarioServico(){
        if (itemServico != null){
            if (itemServico.getServico() != null){
                itemServico.setValorUnitario(itemServico.getServico().getValor());
            }
        }
    }
    
    public void calculaValorTotalServico(){
        if (itemServico.getQuantidade() != null 
                && itemServico.getValorUnitario() != null){
            itemServico.setValorTotal(itemServico.getValorUnitario() 
                    * itemServico.getQuantidade());
        }
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
    
    public void novoItemServico(){
        itemServico = new ItemServico();
        novoItemServico = true;
    }
    
    public void alterarItemServico(int index){
        itemServico = objeto.getListaServicos().get(index);
        novoItemServico = false;
    }
    
    public void salvarItemServico(){
        if (novoItemServico){
            objeto.adicionarServico(itemServico);
        } else {
            atualizaValorTotal();
        }
        Util.mensagemInformacao("Serviço adicionado com sucesso!");
    }
    
    public void atualizaValorTotal(){
        objeto.setValorTotal(0.0);
        Double totalServico = 0.0;
        for (ItemServico is : objeto.getListaServicos()){
            totalServico += is.getValorTotal();
        }
        objeto.setValorTotal(totalServico);
        objeto.setValorServicos(totalServico);
    }
    
    public void removerItemServico(int index){
        objeto.removerServico(index);
        Util.mensagemInformacao("Serviço removido com sucesso!");
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

    public UsuarioDAO getDaoUsuario() {
        return daoUsuario;
    }

    public void setDaoUsuario(UsuarioDAO daoUsuario) {
        this.daoUsuario = daoUsuario;
    }

    public PessoaFisicaDAO getDaoPessoaFisica() {
        return daoPessoaFisica;
    }

    public void setDaoPessoaFisica(PessoaFisicaDAO daoPessoaFisica) {
        this.daoPessoaFisica = daoPessoaFisica;
    }

    public ServicoDAO getDaoServico() {
        return daoServico;
    }

    public void setDaoServico(ServicoDAO daoServico) {
        this.daoServico = daoServico;
    }

    public EquipamentoDAO getDaoEquipamento() {
        return daoEquipamento;
    }

    public void setDaoEquipamento(EquipamentoDAO daoEquipamento) {
        this.daoEquipamento = daoEquipamento;
    }

    public ProdutoDAO getDaoProduto() {
        return daoProduto;
    }

    public void setDaoProduto(ProdutoDAO daoProduto) {
        this.daoProduto = daoProduto;
    }

    public ItemServico getItemServico() {
        return itemServico;
    }

    public void setItemServico(ItemServico itemServico) {
        this.itemServico = itemServico;
    }

    public Boolean getNovoItemServico() {
        return novoItemServico;
    }

    public void setNovoItemServico(Boolean novoItemServico) {
        this.novoItemServico = novoItemServico;
    }


}
