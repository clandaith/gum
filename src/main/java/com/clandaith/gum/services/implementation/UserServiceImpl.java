package com.clandaith.gum.services.implementation;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clandaith.gum.entities.User;
import com.clandaith.gum.repositories.UserRepository;
import com.clandaith.gum.services.UserRoleService;
import com.clandaith.gum.services.UserService;
import com.google.common.collect.Lists;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	private UserRepository userRepository;

	@Autowired
	UserRoleService userRoleService;

	@Autowired
	public void setRepository(UserRepository sr) {
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
		return userRepository.findUserByUsername(username);
	}

	@Override
	@Transactional
	public User saveUser(User user) {
		return saveUser(user, false);
	}

	@Override
	public User saveUser(User user, boolean encryptePassword) {
		LOGGER.info("Creating a new user: " + user.getUsername());

		if (encryptePassword) {
			BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
			LOGGER.info("Password: " + user.getPassword() + " :: " + bcryptEncoder.encode(user.getPassword()));
			user.setPassword(bcryptEncoder.encode(user.getPassword()));
		}

		user.setEnabled(true);

		userRepository.save(user);

		LOGGER.info("User created: " + user.getId());

		return user;
	}

	@Override
	public void deleteUser(Integer id) {
		userRepository.delete(id);
	}
}
