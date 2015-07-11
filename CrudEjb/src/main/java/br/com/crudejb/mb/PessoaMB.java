package br.com.crudejb.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.crudejb.abstracts.AbstractMB;
import br.com.crudejb.bean.Pessoa;
import br.com.crudejb.dao.PessoaDao;

@ManagedBean
@ViewScoped
public class PessoaMB extends AbstractMB<Pessoa>implements Serializable {

	private static final long serialVersionUID = -305017905383380165L;

	@Inject
	private PessoaDao pessoaDao;
	private List<Pessoa> listPessoa;

	@PostConstruct
	protected void init() {
		novaPessoa();
		carregarPessoas();
	}

	public void salvar() {
		if (getSelectedBean().getId() == null) {
			adicionarPessoa(pessoaDao.insert(getSelectedBean()));
		} else {
			removerPessoa(getSelectedBean());
			adicionarPessoa(pessoaDao.update(getSelectedBean()));
		}
		novaPessoa();
	}

	public void deletar() {
		removerPessoa(getSelectedBean());
		pessoaDao.delete(getSelectedBean());
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
		listPessoa = pessoaDao.findAll();
	}

	public List<Pessoa> getListPessoa() {
		return listPessoa;
	}

}
