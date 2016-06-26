package com.clandaith.gum.controllers.api;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clandaith.gum.entities.User;
import com.clandaith.gum.services.UserService;

@RestController
public class UserAPIController {
	private static final Logger LOGGER = Logger.getLogger(UserAPIController.class);

	private UserService userService;

	@Autowired
	public void setService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/api/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User saveUser(@RequestBody User user) {
		LOGGER.info("save user");
		return userService.saveUser(user);
	}

	@RequestMapping(value = "/api/user", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@RequestBody User user) {
		LOGGER.info("save user");
		return userService.saveUser(user);
	}

	@RequestMapping(value = "/api/user", method = RequestMethod.GET)
	public List<User> getAll() {
		LOGGER.info("get all users");
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/api/user/{id}")
	public User getOne(@PathVariable Integer id) {
		LOGGER.info("get one user: " + id);
		return userService.getUserById(id);
	}

	@RequestMapping(value = "/api/user/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		LOGGER.info("delete user: " + id);
		userService.deleteUser(id);
	}
}
