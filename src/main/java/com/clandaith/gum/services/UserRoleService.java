package com.clandaith.gum.services;

import com.clandaith.gum.entities.UserRole;

public interface UserRoleService {

	UserRole getUserRoleById(Integer id);

	UserRole getUserRoleByUsername(String username);

	UserRole saveUserRole(UserRole userRole);

	void deleteUserRole(Integer id);
}
