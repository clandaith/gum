package com.clandaith.gum.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Blah {

	@RequestMapping("/blah")
	String home() {
		System.out.println("blah message");

		return "blah";
	}
}
