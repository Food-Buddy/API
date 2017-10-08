package io.tryinout.sports.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.tryinout.sports.model.Role;
import io.tryinout.sports.model.User;
import io.tryinout.sports.model.repositories.RoleRepositories;
import io.tryinout.sports.model.repositories.UserRepositories;

@Service("userservice")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositories userRepositories;
	@Autowired
	private RoleRepositories roleRepositories;
	@Autowired
	private BCryptPasswordEncoder bcryptpasswordEncoder;
	
	@Override
	public User findByUserEmail(String email) {
		
		return userRepositories.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		
		user.setPassword(bcryptpasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		 Role userRole = roleRepositories.findByRole("ADMIN");
	        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
			userRepositories.save(user);
	}
	

}
