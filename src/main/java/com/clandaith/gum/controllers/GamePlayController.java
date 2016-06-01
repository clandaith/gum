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

import com.clandaith.gum.entities.GamePlay;
import com.clandaith.gum.services.GamePlayService;

@RestController
public class GamePlayController {
	private static final Logger LOGGER = Logger.getLogger(GamePlayController.class);

	private GamePlayService gamePlayService;

	@Autowired
	public void setService(GamePlayService gamePlayService) {
		this.gamePlayService = gamePlayService;
	}

	@RequestMapping(value = "/gameplay", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public GamePlay saveGamePlay(@RequestBody GamePlay gameCompany) {
		LOGGER.info("save game play");
		return gamePlayService.saveGamePlay(gameCompany);
	}

	@RequestMapping(value = "/gameplay", method = RequestMethod.GET)
	public List<GamePlay> getAll() {
		LOGGER.info("getAll");
		return gamePlayService.getAllGamePlays();
	}

	@RequestMapping(value = "/gameplay/{id}")
	public GamePlay getOne(@PathVariable Integer id) {
		LOGGER.info("getOne");

		GamePlay gameCompany = gamePlayService.getGamePlayById(id);

		return gameCompany;
	}

}
