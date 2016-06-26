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
import com.clandaith.gum.entities.GamePlay;
import com.clandaith.gum.services.GamePlayService;

@RunWith(MockitoJUnitRunner.class)
@SpringApplicationConfiguration(SpringBootWebApplication.class)
public class GamePlayAPIControllerTest {
	@Mock
	private GamePlayService gamePlayService;

	private GamePlayAPIController gamePlayController;

	@Before
	public void setUp() {
		gamePlayController = new GamePlayAPIController();
		gamePlayController.setService(gamePlayService);
	}

	@Test
	public void saveUser() throws Exception {
		final GamePlay savedGamePlay = stubServiceToReturnSavedGamePlay();
		final GamePlay gamePlay = new GamePlay();

		GamePlay returnedGamePlay = gamePlayController.saveGamePlay(gamePlay);
		// verify GamePlay was passed to GamePlayService
		verify(gamePlayService, times(1)).saveGamePlay(gamePlay);
		assertEquals("Returned game play should come from the service", savedGamePlay, returnedGamePlay);
	}

	private GamePlay stubServiceToReturnSavedGamePlay() {
		final GamePlay gamePlay = new GamePlay();
		when(gamePlayService.saveGamePlay(any(GamePlay.class))).thenReturn(gamePlay);
		return gamePlay;
	}
}
