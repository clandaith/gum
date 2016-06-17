package com.clandaith.gum.controllers.api.v1;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clandaith.gum.entities.GameSystem;
import com.clandaith.gum.services.GameSystemService;

@RestController
public class GameSystemController {
	private static final Logger LOGGER = Logger.getLogger(GameSystemController.class);

	private GameSystemService gameSystemService;

	@Autowired
	public void setService(GameSystemService gameSystemService) {
		this.gameSystemService = gameSystemService;
	}

	@RequestMapping(value = "/api/v1/gamesystem", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public GameSystem saveGameSystem(@RequestBody GameSystem gameSystem) {
		LOGGER.info("save game system");
		return gameSystemService.saveGameSystem(gameSystem);
	}

	@RequestMapping(value = "/api/v1/gamesystem", method = RequestMethod.GET)
	public List<GameSystem> getAll() {
		LOGGER.info("get all game systems");
		return gameSystemService.getAllGameSystems();
	}

	@RequestMapping(value = "/api/v1/gamesystem/{id}", method = RequestMethod.GET)
	public GameSystem getOne(@PathVariable Integer id) {
		LOGGER.info("get one game system");
		return gameSystemService.getGameSystemById(id);
	}

	@RequestMapping(value = "/api/v1/gamesystem/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		LOGGER.info("delete");
		gameSystemService.deleteGameSystem(id);
	}
}
