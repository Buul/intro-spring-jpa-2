package br.com.paulofirmino.curso.dao;

import java.util.List;

import br.com.paulofirmino.curso.domain.UserModel;

public interface IUserDao {
	
	void save(UserModel user);
	
	void update(UserModel user);
	
	void delete(Long id);
	
	UserModel getId(Long id);
	
	List<UserModel> getAll();
}
