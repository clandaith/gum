package com.clandaith.gum.services;

import java.util.List;

import com.clandaith.gum.entities.GamePlay;

public interface GamePlayService {
	List<GamePlay> getAllGamePlays();

	GamePlay getGamePlayById(Integer id);

	GamePlay saveGamePlay(GamePlay GamePlay);

}
