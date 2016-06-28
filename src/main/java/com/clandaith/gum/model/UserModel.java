package com.clandaith.gum.model;

import org.springframework.web.bind.annotation.RestController;

import com.clandaith.gum.entities.User;
import com.clandaith.gum.entities.UserRole;
import com.clandaith.gum.entities.UserRole.ROLE;
import com.clandaith.gum.services.UserRoleService;
import com.clandaith.gum.services.UserService;

@RestController
public class UserModel {
	public User createNewUser(UserService userService, UserRoleService userRoleService, User user) {

		user.setEnabled(true);
		userService.saveUser(user);

		UserRole userRole = new UserRole();
		userRole.setUsername(user.getUsername());
		userRole.setRole(ROLE.ROLE_USER);
		userRoleService.saveUserRole(userRole);

		return user;
	}
}
