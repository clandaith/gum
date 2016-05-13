package com.clandaith.gum;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example {

	@RequestMapping("/example")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "example " + name;
	}
}
