package com.clandaith.gum.controllers;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clandaith.gum.entities.Foobar;

@RestController
public class TestController {
	private final Logger log = Logger.getLogger(TestController.class);

	@RequestMapping(value = "/test", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Foobar test(@RequestBody Foobar foobar) {
		log.info("test");
		log.info("First name : " + foobar.getFirstName());
		log.info("Last name  : " + foobar.getLastName());
		return foobar;
	}
}
