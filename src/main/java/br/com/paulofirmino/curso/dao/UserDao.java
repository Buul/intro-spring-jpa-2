package br.com.paulofirmino.curso.dao;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.paulofirmino.curso.domain.GenderType;
import br.com.paulofirmino.curso.domain.UserModel;

@Repository
public class UserDao implements IUserDao {

	private static List<UserModel> us;

	public UserDao() {
		createUserList();
	}

	private List<UserModel> createUserList() {
		if (us == null) {
			us = new LinkedList<>();
			us.add(new UserModel(System.currentTimeMillis() + 1L, "Ana", "da Silva", LocalDate.of(1992, 5, 10),
					GenderType.FEMALE));
			us.add(new UserModel(System.currentTimeMillis() + 2L, "Luiz", "dos Santos", LocalDate.of(1990, 8, 11),
					GenderType.MALE));
			us.add(new UserModel(System.currentTimeMillis() + 3L, "Mariana", "Mello", LocalDate.of(1992, 9, 17),
					GenderType.FEMALE));
			us.add(new UserModel(System.currentTimeMillis() + 4L, "Caren", "Pereira"));
			us.add(new UserModel(System.currentTimeMillis() + 5L, "Sonia", "Fagundes"));
			us.add(new UserModel(System.currentTimeMillis() + 6L, "Norberto", "de Souza"));
		}
		return us;
	}

	@Override
	public void save(UserModel user) {
		user.setId(System.currentTimeMillis());
		us.add(user);
	}

	@Override
	public void update(UserModel user) {
		us.stream().filter((u) -> u.getId().equals(user.getId())).forEach((u) -> {
			u.setName(user.getName());
			u.setLastName(user.getLastName());
			u.setBirthday(user.getBirthday());
			u.setGender(user.getGender());
		});
	}

	@Override
	public void delete(Long id) {
		us.removeIf((u) -> u.getId().equals(id));
	}

	@Override
	public UserModel getId(Long id) {
		return us.stream().filter((u) -> u.getId().equals(id)).collect(Collectors.toList()).get(0);
	}

	@Override
	public List<UserModel> getAll() {
		return us;
	}

}
