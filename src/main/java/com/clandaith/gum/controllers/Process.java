package com.clandaith.gum.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Process {

	@RequestMapping("/process")
	String home() {
		return "Process";
	}
}
