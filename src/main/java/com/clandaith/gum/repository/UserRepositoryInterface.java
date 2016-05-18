package com.clandaith.gum.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.clandaith.gum.entity.User;

public interface UserRepositoryInterface extends CrudRepository<User, Long> {

	// Page<User> findAll(Pageable pageable);

	@Override
	List<User> findAll();

	User findByUserName(String userName);

}