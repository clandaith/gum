package com.clandaith.gum.flyway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.clandaith.gum.repositories.PersonRepository;

@SpringBootApplication
public class SampleFlywayApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository repository;

	@Override
	public void run(String... args) throws Exception {
		System.err.println("jh gjhg jhg    " + this.repository.findAll());
	}
}
