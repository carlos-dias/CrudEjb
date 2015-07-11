package br.com.crudejb.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.crudejb.abstracts.AbstractBean;

@Entity
@Table
public class Pessoa extends AbstractBean implements Serializable {

	private static final long serialVersionUID = 125113693073535671L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_pessoa")
	@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa")
	private Integer id;

	private String nome;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa", cascade = CascadeType.ALL)
	private List<Endereco> listEndereco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Endereco> getListEndereco() {
		return listEndereco;
	}

	public void setListEndereco(List<Endereco> listEndereco) {
		this.listEndereco = listEndereco;
	}

}