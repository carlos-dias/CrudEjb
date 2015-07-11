package br.com.crudejb.dao;

import java.io.Serializable;

import javax.ejb.Stateless;

import br.com.crudejb.abstracts.AbstractDao;
import br.com.crudejb.bean.Endereco;

@Stateless
public class EnderecoDao extends AbstractDao<Endereco> implements Serializable{

	private static final long serialVersionUID = 1627056446345539056L;

	public EnderecoDao() {
		super(Endereco.class);
	}
}
