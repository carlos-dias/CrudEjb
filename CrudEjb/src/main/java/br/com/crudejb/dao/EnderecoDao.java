package br.com.crudejb.dao;

import javax.ejb.Stateless;

import br.com.crudejb.bean.Endereco;
import br.com.crudejb.dao.abstracts.AbstractDao;

@Stateless
public class EnderecoDao extends AbstractDao<Endereco> {

	public EnderecoDao() {
		super(Endereco.class);
	}
}
