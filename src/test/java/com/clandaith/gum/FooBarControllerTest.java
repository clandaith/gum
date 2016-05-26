package com.clandaith.gum;

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

import com.clandaith.gum.controllers.FoobarController;
import com.clandaith.gum.entities.Foobar;
import com.clandaith.gum.services.FoobarService;

@RunWith(MockitoJUnitRunner.class)
// @RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootWebApplication.class)
public class FooBarControllerTest {
	@Mock
	private FoobarService foobarService;

	private FoobarController foobarController;

	@Before
	public void setUp() {
		foobarController = new FoobarController();
		foobarController.setFoobarService(foobarService);
	}

	@Test
	public void shouldCreateUser() throws Exception {
		final Foobar savedFoobar = stubServiceToReturnStoredFoobar();
		final Foobar foobar = new Foobar();
		foobar.setFirstName("firstName");
		foobar.setLastName("lastName");

		Foobar returnedFoobar = foobarController.saveFoobar(foobar);
		// verify foobar was passed to FoobarService
		verify(foobarService, times(1)).saveFoobar(foobar);
		assertEquals("Returned foobar should come from the service", savedFoobar, returnedFoobar);
	}

	private Foobar stubServiceToReturnStoredFoobar() {
		final Foobar foobar = new Foobar();
		when(foobarService.saveFoobar(any(Foobar.class))).thenReturn(foobar);
		return foobar;
	}

}
