package br.com.edifacil.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.edifacil.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByName(String userName);
}
