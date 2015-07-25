package br.com.crudejb.facade;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.crudejb.bean.Pessoa;
import br.com.crudejb.dao.PessoaDao;

@Stateless
public class PessoaFacade implements Serializable {
	private static final long serialVersionUID = -7708934719566331898L;

	@Inject
	private PessoaDao pessoaDao;

	public Pessoa insert(Pessoa pessoa) {
		return pessoaDao.insert(pessoa);
	}

	public Pessoa update(Pessoa pessoa) {
		return pessoaDao.update(pessoa);
	}

	public boolean delete(Pessoa pessoa) {
		return pessoaDao.delete(pessoa);
	}

	public List<Pessoa> findAll() {
		return pessoaDao.findAll();
	}
}
