package io.tryinout.sports.service;

import io.tryinout.sports.model.User;

public interface UserService {
	public User findByUserEmail(String email);
	public void saveUser(User user);

}
