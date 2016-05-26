package com.clandaith.gum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.SpringApplicationConfiguration;

import com.clandaith.gum.controllers.TestController;
import com.clandaith.gum.entities.Foobar;

@RunWith(MockitoJUnitRunner.class)
// @RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootWebApplication.class)
public class Blork {

	private final TestController testController = new TestController();

	@Test
	public void willFail() {
		Assert.fail();
	}

	@Test
	public void blah() {
		Foobar foobar = new Foobar();
		foobar.setFirstName("first");
		foobar.setLastName("last");

		testController.test(foobar);
	}
}
