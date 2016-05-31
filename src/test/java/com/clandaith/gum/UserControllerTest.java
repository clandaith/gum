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

import com.clandaith.gum.controllers.UserController;
import com.clandaith.gum.entities.User;
import com.clandaith.gum.services.UserService;

@RunWith(MockitoJUnitRunner.class)
// @RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootWebApplication.class)
public class UserControllerTest {
	@Mock
	private UserService userService;

	private UserController userController;

	@Before
	public void setUp() {
		userController = new UserController();
		userController.setUserService(userService);
	}

	@Test
	public void shouldCreateUser() throws Exception {
		final User savedUser = stubServiceToReturnStoredUser();
		final User user = new User();
		user.setUsername("someusername");
		user.setFirstName("firstName");
		user.setLastName("lastName");

		User returnedUser = userController.saveUser(user);
		// verify User was passed to FoobarService
		verify(userService, times(1)).saveUser(user);
		assertEquals("Returned user should come from the service", savedUser, returnedUser);
	}

	private User stubServiceToReturnStoredUser() {
		final User user = new User();
		when(userService.saveUser(any(User.class))).thenReturn(user);
		return user;
	}

}
