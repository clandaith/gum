package com.clandaith.gum.controllers.pages.errors;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralErrorController implements ErrorController {
	private static final Logger LOGGER = Logger.getLogger(GeneralErrorController.class);

	@RequestMapping("/error")
	public String error(Model model) {
		try {
			LOGGER.info("We're in here! "
							+ SecurityContextHolder.getContext().getAuthentication().getName());
		} catch (Exception e) {
			LOGGER.error("", e);
		}

		return "errors/general_error";
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub

		LOGGER.info("We might be in here...");

		return "/error";
	}
}
