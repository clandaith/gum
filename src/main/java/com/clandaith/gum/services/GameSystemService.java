package com.clandaith.gum.services;

import java.util.List;

import com.clandaith.gum.entities.GameSystem;

public interface GameSystemService {
	List<GameSystem> getAllGameSystems();

	GameSystem getGameSystemById(Integer id);

	GameSystem saveGameSystem(GameSystem GameSystem);

	void deleteGameSystem(Integer id);

}
