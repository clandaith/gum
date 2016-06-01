package com.clandaith.gum.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clandaith.gum.entities.GamePlay;
import com.clandaith.gum.repositories.GamePlayRepository;
import com.clandaith.gum.services.GamePlayService;
import com.google.common.collect.Lists;

@Service
public class GamePlayServiceImpl implements GamePlayService {
	private GamePlayRepository gamePlayRepository;

	@Autowired
	public void setRepository(GamePlayRepository sr) {
		this.gamePlayRepository = sr;
	}

	@Override
	public List<GamePlay> getAllGamePlays() {
		return Lists.newArrayList(gamePlayRepository.findAll());
	}

	@Override
	public GamePlay getGamePlayById(Integer id) {
		return gamePlayRepository.findOne(id);
	}

	@Override
	public GamePlay saveGamePlay(GamePlay gamePlay) {
		return gamePlayRepository.save(gamePlay);
	}
}
