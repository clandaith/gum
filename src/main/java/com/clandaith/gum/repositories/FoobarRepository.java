package com.clandaith.gum.repositories;

import org.springframework.data.repository.CrudRepository;

import com.clandaith.gum.entities.Foobar;

public interface FoobarRepository extends CrudRepository<Foobar, Integer> {
}
