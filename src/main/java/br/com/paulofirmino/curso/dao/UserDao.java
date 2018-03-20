package br.com.paulofirmino.curso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserModel getId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public List<UserModel> getAll() {
		String jpql = "from UserModel u";
		TypedQuery<UserModel> query = entityManager.createQuery(jpql, UserModel.class);
		return query.getResultList();
	}


}
