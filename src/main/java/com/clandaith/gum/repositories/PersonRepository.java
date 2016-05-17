package com.clandaith.gum.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.clandaith.gum.entities.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
