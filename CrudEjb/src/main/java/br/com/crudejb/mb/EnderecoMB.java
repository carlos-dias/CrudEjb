package br.com.crudejb.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.crudejb.abstracts.AbstractMB;
import br.com.crudejb.bean.Endereco;
import br.com.crudejb.bean.Pessoa;
import br.com.crudejb.dao.EnderecoDao;
import br.com.crudejb.dao.PessoaDao;

@ManagedBean
@ViewScoped
public class EnderecoMB extends AbstractMB<Endereco>implements Serializable {

	private static final long serialVersionUID = 2361969987374512843L;

	@Inject
	private PessoaDao pessoaDao;
	@Inject
	private EnderecoDao enderecoDao;

	private List<Pessoa> listPessoa;
	private List<Endereco> listEndereco;

	@PostConstruct
	protected void init() {
		novoEndereco();
		carregarEnderecos();
		carregarPessoas();
	}

	public void salvar() {
		if (getSelectedBean().getId() == null) {
			adicionarEndereco(enderecoDao.insert(getSelectedBean()));
		} else {
			removerEndereco(getSelectedBean());
			adicionarEndereco(enderecoDao.update(getSelectedBean()));
		}
		novoEndereco();
	}

	public void deletar() {
		removerEndereco(getSelectedBean());
		enderecoDao.delete(getSelectedBean());
		novoEndereco();
	}

	public void cancelar() {
		novoEndereco();
	}

	private void novoEndereco() {
		setSelectedBean(new Endereco());
		getSelectedBean().setPessoa(new Pessoa());
	}

	private void adicionarEndereco(Endereco e) {
		listEndereco.add(e);
	}

	private void removerEndereco(Endereco e) {
		listEndereco.remove(e);
	}

	private void carregarPessoas() {
		listPessoa = pessoaDao.findAll();
	}

	private void carregarEnderecos() {
		listEndereco = enderecoDao.findAll();
	}

	public List<Pessoa> getListPessoa() {
		return listPessoa;
	}

	public List<Endereco> getListEndereco() {
		return listEndereco;
	}

}
