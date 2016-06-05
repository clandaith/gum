package com.clandaith.gum.controllers.pages.errors;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralErrorController implements ErrorController {
	private static final Logger LOGGER = Logger.getLogger(GeneralErrorController.class);

	@RequestMapping("/error")
	public String error(Model model) {
		LOGGER.info("We're in the error controller");
		return "errors/general_error";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
