package com.clandaith.gum.services;

import java.util.List;

import com.clandaith.gum.entities.User;

public interface UserService {
	List<User> getAllUsers();

	User getUserById(Integer id);

	User getUserByUsername(String username);

	User saveUser(User user, boolean encryptePassword);

	User saveUser(User user);

	void deleteUser(Integer id);

}
