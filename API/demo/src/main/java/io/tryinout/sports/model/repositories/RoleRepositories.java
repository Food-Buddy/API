package io.tryinout.sports.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.tryinout.sports.model.Role;

public interface RoleRepositories extends JpaRepository<Role, Integer>{

	public Role findByRole(String role);
}
