package org.yestech.user;

import static org.junit.Assert.*;

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
	}

}
