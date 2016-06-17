package com.clandaith.gum.controllers.pages.company;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clandaith.gum.entities.GameCompany;
import com.clandaith.gum.entities.User;
import com.clandaith.gum.services.GameCompanyService;
import com.clandaith.gum.services.UserService;

@Controller
public class CompanyController {
	private static final Logger LOGGER = Logger.getLogger(CompanyController.class);

	@Autowired
	UserService userService;

	@Autowired
	GameCompanyService gameCompanyService;

	@RequestMapping("/companies/company")
	public String company(Model model) {
		LOGGER.info("We're in here! " + SecurityContextHolder.getContext().getAuthentication().getName());

		User user = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

		model.addAttribute("companies", gameCompanyService.getAllGameCompanies());
		model.addAttribute("name", user.getFirstName() + " " + user.getLastName());
		return "companies/company";
	}

	@RequestMapping("/companies/company/addedit/{companyId}")
	public String addEdit(@PathVariable Integer companyId, Model model) {
		try {
			LOGGER.info("companyId = " + companyId);

			if (companyId > -1) {
				model.addAttribute("gameCompany", gameCompanyService.getGameCompanyById(companyId));
			} else {
				model.addAttribute("gameCompany", new GameCompany());
			}

			return "companies/addEdit";
		} catch (Exception e) {
			LOGGER.error("", e);
			return "";
		}
	}

	@RequestMapping(value = "/companies/company/addedit", method = RequestMethod.POST)
	public String persistCompany(GameCompany gameCompany) {
		LOGGER.info(gameCompany.getId() + " :: " + gameCompany.getName());

		if (gameCompany.getId() == null) {
			gameCompany.setDateAdded(new Date());
		}

		gameCompany.setDateUpdated(new Date());

		gameCompanyService.saveGameCompany(gameCompany);

		return "redirect:/companies/company?created";
	}

	@RequestMapping(value = "/companies/company/delete/{companyId}")
	public String deleteCompany(@PathVariable Integer companyId) {

		gameCompanyService.deleteGameCompany(companyId);

		return "redirect:/companies/company?deleted";
	}
}
