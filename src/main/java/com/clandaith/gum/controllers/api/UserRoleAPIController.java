package com.clandaith.gum.controllers.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clandaith.gum.entities.UserRole;
import com.clandaith.gum.entities.UserRole.ROLE;
import com.clandaith.gum.services.UserRoleService;

@RestController
public class UserRoleAPIController {
	private static final Logger LOGGER = Logger.getLogger(UserRoleAPIController.class);

	private UserRoleService userRoleService;

	@Autowired
	public void setService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	@RequestMapping(value = "/api/userrole", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserRole saveUserRole(@RequestBody UserRole userRole) {
		LOGGER.info("save user role");

		// UserRole userRole = new UserRole();
		// userRole.setUsername(user.getUsername());
		// userRole.setRole(ROLE.ROLE_USER);
		// userRoleService.saveUserRole(userRole);

		return userRoleService.saveUserRole(userRole);
	}

	@RequestMapping(value = "/api/userrole/{username}/{userRole}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserRole saveUserRoleViaUrl(@PathVariable String username, @PathVariable ROLE role) {
		LOGGER.info("save user role");

		UserRole userRole = new UserRole();
		userRole.setUsername(username);
		userRole.setRole(role);

		return userRoleService.saveUserRole(userRole);
	}

	@RequestMapping(value = "/api/userrole/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		LOGGER.info("get one user: " + id);
		userRoleService.deleteUserRole(id);
	}
}
