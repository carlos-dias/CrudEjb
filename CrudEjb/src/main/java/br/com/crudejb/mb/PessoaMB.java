package br.com.crudejb.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.crudejb.bean.Pessoa;
import br.com.crudejb.facade.PessoaFacade;
import br.com.crudejb.mb.abstracts.AbstractMB;

@ManagedBean
@ViewScoped
public class PessoaMB extends AbstractMB<Pessoa>implements Serializable {

	private static final long serialVersionUID = -305017905383380165L;

	@Inject
	private PessoaFacade pessoaFacade;
	
	private List<Pessoa> listPessoa;

	@PostConstruct
	protected void init() {
		novaPessoa();
		carregarPessoas();
	}

	public void salvar() {
		if (getSelectedBean().getId() == null) {
			adicionarPessoa(pessoaFacade.insert(getSelectedBean()));
		} else {
			removerPessoa(getSelectedBean());
			adicionarPessoa(pessoaFacade.update(getSelectedBean()));
		}
		novaPessoa();
	}

	public void deletar() {
		removerPessoa(getSelectedBean());
		pessoaFacade.delete(getSelectedBean());
		novaPessoa();
	}

	public void cancelar() {
		novaPessoa();
	}

	private void novaPessoa() {
		setSelectedBean(new Pessoa());
	}

	private void adicionarPessoa(Pessoa p) {
		listPessoa.add(p);
	}

	private void removerPessoa(Pessoa p) {
		listPessoa.remove(p);
	}

	private void carregarPessoas() {
		listPessoa = pessoaFacade.findAll();
	}

	public List<Pessoa> getListPessoa() {
		return listPessoa;
	}

}
