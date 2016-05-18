package com.clandaith.gum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clandaith.gum.entity.Product;
import com.clandaith.gum.guru.springframework.services.ProductService;
import com.google.common.collect.Lists;

@RestController
public class Example {

	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping("/example")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

		List<Product> products = Lists.newArrayList(productService.listAllProducts());
		for (Product product : products) {
			System.out.println(product);
		}

		return "example " + name;
	}
}
