package br.com.crudejb.dao;

import javax.ejb.Stateless;

import br.com.crudejb.bean.Pessoa;
import br.com.crudejb.dao.abstracts.AbstractDao;

@Stateless
public class PessoaDao extends AbstractDao<Pessoa> {

	public PessoaDao() {
		super(Pessoa.class);
	}

}
