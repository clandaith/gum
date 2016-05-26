package com.clandaith.gum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.clandaith.gum.SpringBootWebApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootWebApplication.class)
@WebIntegrationTest
public class GreetingControllerTest {
	RestTemplate template = new TestRestTemplate();

	@Test
	public void justATest() {
		Assert.assertTrue(true);
	}

	@Test
	public void testRequest() throws Exception {
		String body = template.getForEntity("http://localhost:8080/greeting", String.class).getBody();
		Assert.assertTrue(body.contains("content"));
	}

	@Test
	public void testRequestWithName() throws Exception {
		String body = template.getForEntity("http://localhost:8080/greeting?name=blah", String.class).getBody();
		Assert.assertTrue(body.contains("blah"));
	}
}
