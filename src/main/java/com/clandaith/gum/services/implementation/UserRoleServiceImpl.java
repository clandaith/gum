package com.clandaith.gum.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clandaith.gum.entities.UserRole;
import com.clandaith.gum.repositories.UserRoleRepository;
import com.clandaith.gum.services.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	private UserRoleRepository userRoleRepository;

	@Autowired
	public void setRepository(UserRoleRepository urr) {
		this.userRoleRepository = urr;
	}

	@Override
	public UserRole getUserRoleById(Integer id) {
		return userRoleRepository.findOne(id);
	}

	@Override
	public UserRole getUserRoleByUsername(String username) {
		return userRoleRepository.findUserRoleByUsername(username);
	}

	@Override
	public UserRole saveUserRole(UserRole userRole) {
		return userRoleRepository.save(userRole);
	}

	@Override
	public void deleteUserRole(Integer id) {
		userRoleRepository.delete(id);

	}
}
