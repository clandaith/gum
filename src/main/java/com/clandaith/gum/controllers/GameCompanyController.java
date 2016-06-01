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

import com.clandaith.gum.entities.GameCompany;
import com.clandaith.gum.services.GameCompanyService;

@RestController
public class GameCompanyController {
	private static final Logger LOGGER = Logger.getLogger(GameCompanyController.class);

	private GameCompanyService gameCompanyService;

	@Autowired
	public void setService(GameCompanyService gameCompanyService) {
		this.gameCompanyService = gameCompanyService;
	}

	@RequestMapping(value = "/gamecompany", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public GameCompany saveGameCompany(@RequestBody GameCompany gameCompany) {
		LOGGER.info("save game company");
		return gameCompanyService.saveGameCompany(gameCompany);
	}

	@RequestMapping(value = "/gamecompany", method = RequestMethod.GET)
	public List<GameCompany> getAll() {
		LOGGER.info("get all game companies");
		return gameCompanyService.getAllGameCompanies();
	}

	@RequestMapping(value = "/gamecompany/{id}")
	public GameCompany getOne(@PathVariable Integer id) {
		LOGGER.info("get one game company");

		GameCompany gameCompany = gameCompanyService.getGameCompanyById(id);

		return gameCompany;
	}

}
