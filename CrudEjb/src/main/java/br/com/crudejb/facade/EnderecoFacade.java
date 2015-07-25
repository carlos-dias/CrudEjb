package br.com.crudejb.facade;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.crudejb.bean.Endereco;
import br.com.crudejb.dao.EnderecoDao;

@Stateless
public class EnderecoFacade implements Serializable {
	private static final long serialVersionUID = 1627056446345539056L;

	@Inject
	private EnderecoDao enderecoDao;

	public Endereco insert(Endereco endereco) {
		return enderecoDao.insert(endereco);
	}

	public Endereco update(Endereco endereco) {
		return enderecoDao.update(endereco);
	}

	public boolean delete(Endereco endereco) {
		return enderecoDao.delete(endereco);
	}

	public List<Endereco> findAll() {
		return enderecoDao.findAll();
	}
}
