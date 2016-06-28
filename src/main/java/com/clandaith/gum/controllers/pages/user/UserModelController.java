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
import com.clandaith.gum.model.UserModel;
import com.clandaith.gum.services.UserRoleService;
import com.clandaith.gum.services.UserService;

@Controller
public class UserModelController {
	private static final Logger LOGGER = Logger.getLogger(UserModelController.class);

	@Autowired
	UserService userService;

	@Autowired
	UserRoleService userRoleService;

	// Gets currently logged in user
	@RequestMapping("/users/user")
	public String loggedInUser(Model model) {
		LOGGER.info("We're in here! " + SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("user", new User());

		User user = new User();
		try {
			user = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

			model.addAttribute("user", user);
		} catch (Exception e) {
			LOGGER.error("", e);
		}

		LOGGER.info("Who are we: " + user.getFirstName());

		return "users/user";
	}

	// Gets currently logged in user
	@RequestMapping("/users")
	public String allUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());

		return "users/users";
	}

	@RequestMapping(value = "/users/user", method = RequestMethod.POST)
	public String saveUser(User user) {
		user = new UserModel().createNewUser(userService, userRoleService, user);
		return "redirect:/users/user/" + user.getId();
	}

	// gets user by id
	@RequestMapping("/users/user/{id}")
	public String showUser(@PathVariable Integer id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "users/user";
	}

	// +++++++++++++++++++++++++++

	@RequestMapping("/createuser")
	public String createUser(Model model) {
		model.addAttribute("user", new User());
		return "createuser";
	}

	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	public String saveCreateUser(User user) {

		userService.saveUser(user);

		return "redirect:/login?created";
	}

}
