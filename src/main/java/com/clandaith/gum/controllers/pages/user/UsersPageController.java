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

	@RequestMapping("/users/user")
	public String user(Model model) {
		LOGGER.info("We're in here! "
						+ SecurityContextHolder.getContext().getAuthentication().getName());

		// model.addAttribute("name", "Some random new user");
		//
		// User user = new User();
		// try {
		// user = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication()
		// .getName());
		//
		// model.addAttribute("name", user.getFirstName() + " " + user.getLastName());
		// } catch (Exception e) {
		// LOGGER.error("", e);
		// }

		model.addAttribute("user", new User());
		return "user/user";
	}

	@RequestMapping(value = "/users/user", method = RequestMethod.POST)
	public String saveUser(User user) {
		userService.saveUser(user);
		return "redirect:/user/user/" + user.getId();
	}

	@RequestMapping("/users/user/{id}")
	public String showProduct(@PathVariable Integer id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "user/user";
	}
}
