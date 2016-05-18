package com.clandaith.gum.guru.springframework.services;

import com.clandaith.gum.entity.Product;

public interface ProductService {
	Iterable<Product> listAllProducts();

	Product getProductById(Integer id);

	Product saveProduct(Product product);
}
