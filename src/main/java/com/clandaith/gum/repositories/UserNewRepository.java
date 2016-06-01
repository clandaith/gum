package com.clandaith.gum.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.clandaith.gum.entities.User;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserNewRepository extends PagingAndSortingRepository<User, Integer> {
	List<User> findByUsername(@Param("username") String username);
}
