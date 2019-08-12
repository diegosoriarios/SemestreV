package br.edu.ifsul.modelo;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, String> nomeUsuario;
	public static volatile SingularAttribute<Usuario, String> senha;
	public static volatile SingularAttribute<Usuario, String> telefonePrincipal;
	public static volatile SingularAttribute<Usuario, String> nome;
	public static volatile SingularAttribute<Usuario, String> telefoneAlternativo;
	public static volatile SingularAttribute<Usuario, Calendar> dataCadastro;
	public static volatile SingularAttribute<Usuario, String> email;

	public static final String NOME_USUARIO = "nomeUsuario";
	public static final String SENHA = "senha";
	public static final String TELEFONE_PRINCIPAL = "telefonePrincipal";
	public static final String NOME = "nome";
	public static final String TELEFONE_ALTERNATIVO = "telefoneAlternativo";
	public static final String DATA_CADASTRO = "dataCadastro";
	public static final String EMAIL = "email";

}

