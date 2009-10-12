package org.yestech.user;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:/spring.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceIntegrationTest {
	
	@Resource
	private UserService userService;
	
	@Test
	public void testLoadById() {
		long testId = 1;
		User result = userService.loadById(testId);
		assertNotNull(result);
		assertEquals("Issac", result.getFirstname());
		assertEquals("Brock", result.getLastname());
	}
	
	@Test
	public void testSearch() {
		List<User> results = userService.search("jimmy");
		assertNotNull(results);
		assertEquals(1, results.size());
		User jimmy = results.get(0);
		assertNotNull(jimmy);
		assertEquals("Page", jimmy.getLastname());
	}
	
	@Test
	public void testCreate() {
		User user = new User("Stone", "Gossard");
		userService.save(user);
		assertNotNull(user.getId());
		assertTrue(user.getId() > 0);
		assertNotNull(user.getVersion());
	}

}
