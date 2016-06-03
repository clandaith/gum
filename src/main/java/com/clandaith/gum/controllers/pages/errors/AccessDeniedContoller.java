package com.clandaith.gum.controllers.pages.errors;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccessDeniedContoller {
	private static final Logger LOGGER = Logger.getLogger(AccessDeniedContoller.class);

	@RequestMapping("/Access_Denied")
	public String accessDenied(Model model) {

		try {
			LOGGER.info("We're in here! "
							+ SecurityContextHolder.getContext().getAuthentication().getName());
		} catch (Exception e) {
			LOGGER.error("", e);
		}

		return "errors/access_denied";
	}
}
