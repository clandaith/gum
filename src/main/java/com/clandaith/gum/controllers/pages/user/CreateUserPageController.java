package com.clandaith.gum.controllers.pages.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clandaith.gum.entities.User;
import com.clandaith.gum.entities.UserRole;
import com.clandaith.gum.entities.UserRole.ROLE;
import com.clandaith.gum.services.UserRoleService;
import com.clandaith.gum.services.UserService;

@Controller
public class CreateUserPageController {
	private static final Logger LOGGER = Logger.getLogger(CreateUserPageController.class);

	@Autowired
	UserService userService;

	@Autowired
	UserRoleService userRoleService;

	@RequestMapping("/createuser")
	public String userForm(Model model) {
		model.addAttribute("user", new User());
		return "createuser";
	}

	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	public String saveUser(User user) {
		BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();

		LOGGER.info("Creating a new user: " + user.getUsername());
		user.setEnabled(true);

		LOGGER.info("Password: " + user.getPassword() + " :: "
						+ bcryptEncoder.encode(user.getPassword()));

		user.setPassword(bcryptEncoder.encode(user.getPassword()));

		userService.saveUser(user);

		UserRole userRole = new UserRole();
		userRole.setUsername(user.getUsername());
		userRole.setRole(ROLE.ROLE_USER);
		userRoleService.saveUserRole(userRole);

		LOGGER.info("User and role created: " + user.getId() + " :: " + userRole.getId());

		return "redirect:/login?created";
	}
}
