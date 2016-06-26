package com.clandaith.gum.controllers.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.SpringApplicationConfiguration;

import com.clandaith.gum.SpringBootWebApplication;
import com.clandaith.gum.entities.GameCompany;
import com.clandaith.gum.services.GameCompanyService;

@RunWith(MockitoJUnitRunner.class)
@SpringApplicationConfiguration(SpringBootWebApplication.class)
public class GameCompanyAPIControllerTest {
	@Mock
	private GameCompanyService gameCompanyService;

	private GameCompanyAPIController gameCompanyController;

	@Before
	public void setUp() {
		gameCompanyController = new GameCompanyAPIController();
		gameCompanyController.setService(gameCompanyService);
	}

	@Test
	public void saveUser() throws Exception {
		final GameCompany savedGameCompany = stubServiceToReturnSavedGameCompany();
		final GameCompany gameCompany = new GameCompany();

		GameCompany returnedGameCompany = gameCompanyController.saveGameCompany(gameCompany);
		// verify GameCompany was passed to GameCompanyService
		verify(gameCompanyService, times(1)).saveGameCompany(gameCompany);
		assertEquals("Returned game company should come from the service", savedGameCompany, returnedGameCompany);
	}

	private GameCompany stubServiceToReturnSavedGameCompany() {
		final GameCompany gameCompany = new GameCompany();
		when(gameCompanyService.saveGameCompany(any(GameCompany.class))).thenReturn(gameCompany);
		return gameCompany;
	}

}
