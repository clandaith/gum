package com.clandaith.gum.controllers.pages.gamesystem;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clandaith.gum.entities.GameSystem;
import com.clandaith.gum.entities.User;
import com.clandaith.gum.services.GameSystemService;
import com.clandaith.gum.services.UserService;

@Controller
public class SystemController {
	private static final Logger LOGGER = LogManager.getLogger(SystemController.class);

	@Autowired
	UserService userService;

	@Autowired
	GameSystemService gameSystemService;

	@RequestMapping("/gamesystems/gamesystem")
	public String gamesystem(Model model) {
		LOGGER.info("We're in here! asdffasdfasdf" + SecurityContextHolder.getContext().getAuthentication().getName());

		User user = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

		model.addAttribute("gameSystems", gameSystemService.getAllGameSystems());
		model.addAttribute("name", user.getFirstName() + " " + user.getLastName());
		return "gamesystems/gamesystem";
	}

	@RequestMapping("/gamesystems/gamesystem/addedit/{gameSystemId}")
	public String addEdit(@PathVariable Integer gameSystemId, Model model) {
		try {
			LOGGER.info("gameSystemId = " + gameSystemId);

			if (gameSystemId > -1) {
				model.addAttribute("gameSystem", gameSystemService.getGameSystemById(gameSystemId));
			} else {
				model.addAttribute("gameSystem", new GameSystem());
			}

			return "gamesystems/addEdit";
		} catch (Exception e) {
			LOGGER.error("", e);
			return "";
		}
	}

	@RequestMapping(value = "/gamesystems/gamesystem/addedit", method = RequestMethod.POST)
	public String persistGameSystem(GameSystem gameSystem) {
		LOGGER.info(gameSystem.getId() + " :: " + gameSystem.getName());

		if (gameSystem.getId() == null) {
			gameSystem.setDateAdded(new Date());
		}

		gameSystem.setDateUpdated(new Date());

		gameSystemService.saveGameSystem(gameSystem);

		return "redirect:/gamesystems/gamesystem?created";
	}

	@RequestMapping(value = "/gamesystems/gamesystem/delete/{gamesystemId}")
	public String deleteGameSystem(@PathVariable Integer gameSystemId) {

		gameSystemService.deleteGameSystem(gameSystemId);

		return "redirect:/gamesystems/gamesystem?deleted";
	}
}
