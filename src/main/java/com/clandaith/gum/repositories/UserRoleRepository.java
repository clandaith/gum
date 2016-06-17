package com.clandaith.gum.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.clandaith.gum.entities.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {
	@Query("select ur from UserRole ur where ur.username = :username")
	public UserRole findUserRoleByUsername(@Param("username") String username);

}
