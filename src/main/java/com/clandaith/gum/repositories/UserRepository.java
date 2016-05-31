package com.clandaith.gum.repositories;

import org.springframework.data.repository.CrudRepository;

import com.clandaith.gum.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
