package com.fa.FinanceAssistant;

import com.fa.FinanceAssistant.model.User;
import com.fa.FinanceAssistant.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {
	@Autowired
	private UserService userService;
	@Test
	public void create() {
		User  user=new User();
		user.setUsername("18938848717");
		user.setPassword("asamdldas");
		user.setNickname("afeng");
		userService.create(user);
	}

}
