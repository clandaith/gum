package com.clandaith.gum.services;

import java.util.List;

import com.clandaith.gum.entities.User;

public interface UserService {
	List<User> getAllUsers();

	User getUserById(Integer id);

	// User getUserByUsername(String username);

	User saveUser(User user);

}
