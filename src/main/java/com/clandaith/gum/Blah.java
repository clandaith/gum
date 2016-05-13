package com.clandaith.gum;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Blah {

	@RequestMapping("/blah")
	String home() {
		return "blah";
	}
}
