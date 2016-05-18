package com.clandaith.gum.guru.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends
				CrudRepository<com.clandaith.gum.entity.Product, Integer> {
}
