package io.tryinout.sports.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.tryinout.sports.model.User;

public interface UserRepositories extends JpaRepository<User, Long>{
	public User findByEmail(String email);
	

	
}
