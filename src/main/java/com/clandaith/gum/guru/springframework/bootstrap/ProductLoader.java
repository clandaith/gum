package com.clandaith.gum.guru.springframework.bootstrap;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.clandaith.gum.entity.Product;
import com.clandaith.gum.guru.springframework.repositories.ProductRepository;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

	private ProductRepository productRepository;

	private final Logger log = Logger.getLogger(ProductLoader.class);

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Product shirt = new Product();
		shirt.setDescription("asdfasfdasdffdsa");
		shirt.setPrice(new BigDecimal("18.95"));
		shirt.setImageUrl("blahsadfasdf.jpg");
		shirt.setProductId("1234");
		productRepository.save(shirt);

		log.info("Saved Shirt - id: " + shirt.getId());

		Product mug = new Product();
		mug.setDescription("dsffdsfds");
		mug.setImageUrl("blorkaadsf.jpg");
		mug.setProductId("4567");
		mug.setPrice(new BigDecimal("11.95"));
		productRepository.save(mug);

		log.info("Saved Mug - id:" + mug.getId());
	}
}
