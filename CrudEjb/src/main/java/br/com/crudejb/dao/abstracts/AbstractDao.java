package br.com.crudejb.dao.abstracts;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.crudejb.bean.abstracts.AbstractBean;

public abstract class AbstractDao<T extends AbstractBean> {
	private Class<T> entityClass;
	
	@PersistenceContext(unitName="crudEjb")
	protected EntityManager entityManager;

	public AbstractDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public T insert(T entidade) {
		try {
			entityManager.persist(entidade);
			entityManager.flush();;
			return entidade;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public T update(T entidade) {
		try {
			entityManager.merge(entidade);
			entityManager.flush();
			return entidade;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public T findByPk(Serializable id) {
		try {
			return entityManager.find(entityClass, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean delete(T entidade) {
		try {
			entidade = entityManager.find(entityClass, entidade.getId());
			entityManager.remove(entidade);
			entityManager.flush();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return entityManager.createQuery("FROM " + entityClass.getName()).getResultList();
	}
}
