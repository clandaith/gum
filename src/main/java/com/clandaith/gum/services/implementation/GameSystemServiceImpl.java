package com.clandaith.gum.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clandaith.gum.entities.GameSystem;
import com.clandaith.gum.repositories.GameSystemRepository;
import com.clandaith.gum.services.GameSystemService;
import com.google.common.collect.Lists;

@Service
public class GameSystemServiceImpl implements GameSystemService {
	private GameSystemRepository gameSystemRepository;

	@Autowired
	public void setRepository(GameSystemRepository sr) {
		this.gameSystemRepository = sr;
	}

	@Override
	public List<GameSystem> getAllGameSystems() {
		return Lists.newArrayList(gameSystemRepository.findAll());
	}

	@Override
	public GameSystem getGameSystemById(Integer id) {
		return gameSystemRepository.findOne(id);
	}

	@Override
	public GameSystem saveGameSystem(GameSystem GameSystem) {
		return null;
	}

	@Override
	public void deleteGameSystem(Integer id) {
		gameSystemRepository.delete(id);
	}
}
