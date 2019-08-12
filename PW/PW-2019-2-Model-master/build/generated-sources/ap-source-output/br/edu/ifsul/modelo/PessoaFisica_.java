package br.edu.ifsul.modelo;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PessoaFisica.class)
public abstract class PessoaFisica_ extends br.edu.ifsul.modelo.Usuario_ {

	public static volatile SingularAttribute<PessoaFisica, Calendar> nascimento;
	public static volatile SingularAttribute<PessoaFisica, Cidade> cidade;
	public static volatile SingularAttribute<PessoaFisica, String> complemento;
	public static volatile SingularAttribute<PessoaFisica, String> endereco;
	public static volatile SingularAttribute<PessoaFisica, String> numero;
	public static volatile SingularAttribute<PessoaFisica, String> rg;
	public static volatile SingularAttribute<PessoaFisica, String> bairro;
	public static volatile SingularAttribute<PessoaFisica, String> cpf;
	public static volatile SingularAttribute<PessoaFisica, String> referencia;
	public static volatile SingularAttribute<PessoaFisica, String> cep;

	public static final String NASCIMENTO = "nascimento";
	public static final String CIDADE = "cidade";
	public static final String COMPLEMENTO = "complemento";
	public static final String ENDERECO = "endereco";
	public static final String NUMERO = "numero";
	public static final String RG = "rg";
	public static final String BAIRRO = "bairro";
	public static final String CPF = "cpf";
	public static final String REFERENCIA = "referencia";
	public static final String CEP = "cep";

}

