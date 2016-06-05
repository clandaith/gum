package com.clandaith.gum.controllers.pages.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clandaith.gum.entities.User;
import com.clandaith.gum.services.UserService;

@Controller
public class UsersPageController {
	private static final Logger LOGGER = Logger.getLogger(UsersPageController.class);

	@Autowired
	UserService userService;

	// Gets currently logged in user
	@RequestMapping("/users/user")
	public String loggedInUser(Model model) {
		LOGGER.info("We're in here! "
						+ SecurityContextHolder.getContext().getAuthentication().getName());

		model.addAttribute("user", new User());

		User user = new User();
		try {
			user = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication()
							.getName());

			model.addAttribute("user", user);
		} catch (Exception e) {
			LOGGER.error("", e);
		}

		LOGGER.info("Who are we: " + user.getFirstName());

		return "users/user";
	}

	@RequestMapping("/users/userform")
	public String userForm(Model model) {
		model.addAttribute("user", new User());
		return "users/userform";
	}

	@RequestMapping(value = "/users/user", method = RequestMethod.POST)
	public String saveUser(User user) {
		userService.saveUser(user);
		return "redirect:/users/user/" + user.getId();
	}

	// gets user by id
	@RequestMapping("/users/user/{id}")
	public String showUser(@PathVariable Integer id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "users/user";
	}
}
