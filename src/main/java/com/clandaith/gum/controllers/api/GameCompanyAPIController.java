package com.clandaith.gum.controllers.api;

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
public class GameCompanyAPIController {
	private static final Logger LOGGER = Logger.getLogger(GameCompanyAPIController.class);

	private GameCompanyService gameCompanyService;

	@Autowired
	public void setService(GameCompanyService gameCompanyService) {
		this.gameCompanyService = gameCompanyService;
	}

	@RequestMapping(value = "/api/gamecompany", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public GameCompany saveGameCompany(@RequestBody GameCompany gameCompany) {
		LOGGER.info("save game company");
		return gameCompanyService.saveGameCompany(gameCompany);
	}

	@RequestMapping(value = "/api/gamecompany", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public GameCompany updateGameCompany(@RequestBody GameCompany gameCompany) {
		LOGGER.info("update game company");
		return gameCompanyService.saveGameCompany(gameCompany);
	}

	@RequestMapping(value = "/api/gamecompany")
	public List<GameCompany> getAll() {
		LOGGER.info("get all game companies");
		return gameCompanyService.getAllGameCompanies();
	}

	@RequestMapping(value = "/api/gamecompany/{id}")
	public GameCompany getOne(@PathVariable Integer id) {
		LOGGER.info("get one game company");
		return gameCompanyService.getGameCompanyById(id);
	}

	@RequestMapping(value = "/api/gamecompany/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		LOGGER.info("delete game company");
		gameCompanyService.deleteGameCompany(id);
	}
}
