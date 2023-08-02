package org.jsp.SpringBootUserApp.Dao;

import java.util.List;
import java.util.Optional;

import org.jsp.SpringBootUserApp.Repository.UserRepository;
import org.jsp.SpringBootUserApp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private UserRepository repository;

	public User SaveUser(User user) {
		return repository.save(user);
	}

	public User UpdateUser(User user) {
		return repository.save(user);
	}

	public Optional<User> findUser(int id) {
		return repository.findById(id);
	}

	public List<User> FindAll() {
		return repository.findAll();
	}

	public void deleteUser(int id) {
		repository.deleteById(id);
	}
	public Optional<User> VerifyUser(long phone ,String password)
	{
		return repository.verify(phone, password);
	}
	public Optional<User> VerifyUser(String email ,String password)
	{
		return repository.verify(email, password);
	}


}
