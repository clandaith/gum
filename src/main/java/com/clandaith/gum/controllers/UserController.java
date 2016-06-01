package com.clandaith.gum.controllers;

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
public class UserController {
	private final Logger log = Logger.getLogger(UserController.class);

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User saveUser(@RequestBody User user) {
		log.info("saveUser");
		return userService.saveUser(user);
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> getAll() {
		log.info("getAll");
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/user/{id}")
	public User getOne(@PathVariable Integer id) {
		log.info("getOne");

		User user = userService.getUserById(id);

		return user;
	}
}
