package br.com.crudejb.bean.abstracts;

public abstract class AbstractMB<E> {
	private E selectedBean;

	protected abstract void init();

	public E getSelectedBean() {
		return selectedBean;
	}

	public void setSelectedBean(E selectedBean) {
		this.selectedBean = selectedBean;
	}

}
