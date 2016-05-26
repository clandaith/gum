package com.clandaith.gum.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clandaith.gum.entities.Foobar;
import com.clandaith.gum.services.FoobarService;

@RestController
public class FoobarController {
	private final Logger log = Logger.getLogger(FoobarController.class);

	private FoobarService foobarService;

	@Autowired
	public void setFoobarService(FoobarService foobarService) {
		this.foobarService = foobarService;
	}

	@RequestMapping(value = "/foobar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Foobar saveFoobar(@RequestBody Foobar foobar) {
		log.info("saveFoobar");
		log.info("First name : " + foobar.getFirstName());
		log.info("Last name : " + foobar.getLastName());
		return foobarService.saveFoobar(foobar);
	}

	@RequestMapping(value = "/foobar", method = RequestMethod.GET)
	public List<Foobar> getAll() {
		log.info("getAll");
		return foobarService.listAllFoobars();
	}

	@RequestMapping(value = "/foobar/{id}")
	public Foobar getOne(@PathVariable Integer id) {
		log.info("getOne");

		Foobar foobar = foobarService.getFoobarById(id);

		return foobar;
	}
}
