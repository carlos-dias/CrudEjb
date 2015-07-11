package br.com.crudejb.dao;

import java.io.Serializable;

import javax.ejb.Stateless;

import br.com.crudejb.abstracts.AbstractDao;
import br.com.crudejb.bean.Pessoa;

@Stateless
public class PessoaDao extends AbstractDao<Pessoa> implements Serializable {

	private static final long serialVersionUID = -7708934719566331898L;

	public PessoaDao() {
		super(Pessoa.class);
	}

}
