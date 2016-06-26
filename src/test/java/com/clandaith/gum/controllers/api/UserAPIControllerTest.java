package com.clandaith.gum.controllers.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.SpringApplicationConfiguration;

import com.clandaith.gum.SpringBootWebApplication;
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
		User user = new User();
		user.setId(2);
		userController.updateUser(user);
	}

	@Test
	public void getAll() {
		List<User> stubbedUsers = stubServiceToReturnUsers();
		List<User> users = userController.getAll();
		assertEquals("Number of users returned should match", stubbedUsers.size(), users.size());
	}

	@Test
	public void getOne() {
		final User savedUser = stubServiceToReturnUser();
		User returnedUser = userController.getOne(10);

		assertEquals("User ids should match", savedUser.getId(), returnedUser.getId());
		assertEquals("User names should match", savedUser.getUsername(), returnedUser.getUsername());
		assertEquals("Returned user should be null", null, userController.getOne(1));
	}

	@Test
	public void deleteUser() {
		stubServiceToReturnUser();
		userController.delete(10);
		verify(userService, times(1)).deleteUser(10);
	}

	private User stubServiceToReturnSavedUser() {
		final User user = new User();
		when(userService.saveUser(any(User.class))).thenReturn(user);
		return user;
	}

	private List<User> stubServiceToReturnUsers() {
		List<User> users = new ArrayList<>();

		users.add(new User());
		users.add(new User());
		users.add(new User());
		users.add(new User());
		users.add(new User());

		when(userService.getAllUsers()).thenReturn(users);
		return users;
	}

	private User stubServiceToReturnUser() {
		User user = new User();
		user.setId(10);
		user.setUsername("testuser");

		when(userService.getUserById(10)).thenReturn(user);
		return user;
	}
}
