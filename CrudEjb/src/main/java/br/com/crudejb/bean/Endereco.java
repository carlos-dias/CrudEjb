package br.com.crudejb.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.crudejb.bean.abstracts.AbstractBean;

@Entity
@Table
public class Endereco extends AbstractBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_endereco")
	@SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco")
	private Integer id;

	private String rua;

	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
