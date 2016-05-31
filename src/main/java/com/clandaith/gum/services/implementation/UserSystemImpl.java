package com.clandaith.gum.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.clandaith.gum.entities.User;
import com.clandaith.gum.repositories.UserRepository;
import com.clandaith.gum.services.UserService;
import com.google.common.collect.Lists;

public class UserSystemImpl implements UserService {
	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository sr) {
		this.userRepository = sr;
	}

	@Override
	public List<User> getAllUsers() {
		return Lists.newArrayList(userRepository.findAll());
	}

	@Override
	public User getUserById(Integer id) {
		return userRepository.findOne(id);
	}

	@Override
	public User getUserByUsername(String username) {
		return null;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

}
