package br.com.crudejb.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.crudejb.bean.Endereco;
import br.com.crudejb.bean.Pessoa;
import br.com.crudejb.facade.EnderecoFacade;
import br.com.crudejb.facade.PessoaFacade;
import br.com.crudejb.mb.abstracts.AbstractMB;

@ManagedBean
@ViewScoped
public class EnderecoMB extends AbstractMB<Endereco>implements Serializable {

	private static final long serialVersionUID = 2361969987374512843L;

	@Inject
	private PessoaFacade pessoaFacade;
	@Inject
	private EnderecoFacade enderecoFacade;

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
			adicionarEndereco(enderecoFacade.insert(getSelectedBean()));
		} else {
			removerEndereco(getSelectedBean());
			adicionarEndereco(enderecoFacade.update(getSelectedBean()));
		}
		novoEndereco();
	}

	public void deletar() {
		removerEndereco(getSelectedBean());
		enderecoFacade.delete(getSelectedBean());
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
		listPessoa = pessoaFacade.findAll();
	}

	private void carregarEnderecos() {
		listEndereco = enderecoFacade.findAll();
	}

	public List<Pessoa> getListPessoa() {
		return listPessoa;
	}

	public List<Endereco> getListEndereco() {
		return listEndereco;
	}

}
