package br.edu.ifsul.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cidade.class)
public abstract class Cidade_ {

	public static volatile SingularAttribute<Cidade, Estado> estado;
	public static volatile SingularAttribute<Cidade, String> nome;
	public static volatile SingularAttribute<Cidade, Integer> id;

	public static final String ESTADO = "estado";
	public static final String NOME = "nome";
	public static final String ID = "id";

}

