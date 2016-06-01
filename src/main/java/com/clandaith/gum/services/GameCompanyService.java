package com.clandaith.gum.services;

import java.util.List;

import com.clandaith.gum.entities.GameCompany;

public interface GameCompanyService {
	List<GameCompany> getAllGameCompanies();

	GameCompany getGameCompanyById(Integer id);

	GameCompany saveGameCompany(GameCompany gameCompany);
}
