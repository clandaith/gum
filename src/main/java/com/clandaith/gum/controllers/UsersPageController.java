package com.clandaith.gum.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clandaith.gum.entities.User;
import com.clandaith.gum.services.UserService;

@Controller
public class UsersPageController {
	private static final Logger LOGGER = Logger.getLogger(UsersPageController.class);

	@Autowired
	UserService userService;

	@RequestMapping("/users/user")
	public String greeting(Model model) {
		LOGGER.info("We're in here! "
						+ SecurityContextHolder.getContext().getAuthentication().getName());

		User user = userService.getUserByUsername(SecurityContextHolder.getContext()
						.getAuthentication().getName());

		model.addAttribute("name", user.getFirstName() + " " + user.getLastName());
		return "user/user";
	}
}
