package br.edu.ifsul.converters;

import br.edu.ifsul.modelo.PessoaFisica;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diego Soria Rios
 * @email diegosoriarios@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
@Named(value = "converterPessoaFisica")
@RequestScoped
public class ConverterPessoaFisica implements Serializable, Converter {
    
    @PersistenceContext(unitName = "PW-2019-2-WebPU")
    private EntityManager em;

    // converte da tela para o objeto
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("Selecione um registro")){
            return null;
        }
        return em.find(PessoaFisica.class, string);
    }

    // converte do objeto para a tela
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if (t == null){
            return null;
        }
        PessoaFisica obj = (PessoaFisica) t;
        return obj.getNomeUsuario();
    }

}
