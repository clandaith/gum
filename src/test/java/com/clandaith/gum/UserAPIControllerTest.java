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

import com.clandaith.gum.controllers.api.UserAPIController;
import com.clandaith.gum.entities.User;
import com.clandaith.gum.services.UserService;

@RunWith(MockitoJUnitRunner.class)
@SpringApplicationConfiguration(SpringBootWebApplication.class)
public class UserAPIControllerTest {
	@Mock
	private UserService userService;

	private UserAPIController userController;

	@Before
	public void setUp() {
		userController = new UserAPIController();
		userController.setService(userService);
	}

	@Test
	public void saveUser() throws Exception {
		final User savedUser = stubServiceToReturnSavedUser();
		final User user = new User();
		user.setUsername("someusername");
		user.setFirstName("firstName");
		user.setLastName("lastName");

		User returnedUser = userController.saveUser(user);
		// verify User was passed to UserService
		verify(userService, times(1)).saveUser(user);
		assertEquals("Returned user should come from the service", savedUser, returnedUser);
	}

	@Test
	public void updateUser() {
		userController.updateUser(null);
	}

	@Test
	public void getAll() {
		userController.getAll();
	}

	@Test
	public void getOne() {
		userController.getOne(1);
	}

	@Test
	public void deleteUser() {
		userController.delete(1);
	}

	private User stubServiceToReturnSavedUser() {
		final User user = new User();
		when(userService.saveUser(any(User.class))).thenReturn(user);
		return user;
	}
}
