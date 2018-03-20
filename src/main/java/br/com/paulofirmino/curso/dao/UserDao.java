package br.com.paulofirmino.curso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.paulofirmino.curso.domain.GenderType;
import br.com.paulofirmino.curso.domain.UserModel;

@Repository
@Transactional
public class UserDao implements IUserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void save(UserModel user) {
		entityManager.persist(user);	
	}

	@Override
	public void update(UserModel user) {
		entityManager.merge(user);
	}

	@Override
	public void delete(Long id) {
		entityManager.remove(entityManager.getReference(UserModel.class, id));	
	}

	@Transactional(readOnly = true)
	@Override
	public UserModel getId(Long id) {
		String jpql = "from UserModel u where u.id = :id";
		TypedQuery<UserModel> query = entityManager.createQuery(jpql, UserModel.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Transactional(readOnly = true)
	@Override
	public List<UserModel> getAll() {
		String jpql = "from UserModel u";
		TypedQuery<UserModel> query = entityManager.createQuery(jpql, UserModel.class);
		return query.getResultList();
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<UserModel> getByGenderType(GenderType gender) {
		String jpql = "from UserModel u where u.gender = :gender";
		TypedQuery<UserModel> query = entityManager.createQuery(jpql, UserModel.class);
		query.setParameter("gender", gender);
		return query.getResultList();
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<UserModel> getByName(String name) {
		String jpql = "from UserModel u where u.name like :name or u.lastName like :lastName";
		TypedQuery<UserModel> query = entityManager.createQuery(jpql, UserModel.class);
		query.setParameter("name", "%"+name+"%");
		query.setParameter("lastName", "%"+name+"%");
		return query.getResultList();
	}
}
