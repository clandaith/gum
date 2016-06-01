package com.clandaith.gum.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clandaith.gum.entities.GameCompany;
import com.clandaith.gum.repositories.GameCompanyRepository;
import com.clandaith.gum.services.GameCompanyService;
import com.google.common.collect.Lists;

@Service
public class GameCompanyServiceImpl implements GameCompanyService {
	private GameCompanyRepository gameCompanyRepository;

	@Autowired
	public void setRepository(GameCompanyRepository sr) {
		this.gameCompanyRepository = sr;
	}

	@Override
	public List<GameCompany> getAllGameCompanies() {
		return Lists.newArrayList(gameCompanyRepository.findAll());
	}

	@Override
	public GameCompany getGameCompanyById(Integer id) {
		return gameCompanyRepository.findOne(id);
	}

	@Override
	public GameCompany saveGameCompany(GameCompany gameCompany) {
		return gameCompanyRepository.save(gameCompany);
	}
}
