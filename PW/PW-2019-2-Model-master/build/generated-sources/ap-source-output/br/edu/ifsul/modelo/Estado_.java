package br.edu.ifsul.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Estado.class)
public abstract class Estado_ {

	public static volatile SingularAttribute<Estado, String> uf;
	public static volatile SingularAttribute<Estado, String> nome;
	public static volatile SingularAttribute<Estado, Integer> id;

	public static final String UF = "uf";
	public static final String NOME = "nome";
	public static final String ID = "id";

}

