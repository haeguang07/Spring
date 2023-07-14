package com.yedam.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class BootApplicationTests {

	@Test
	void contextLoads() {
		BCryptPasswordEncoder scpwd = new BCryptPasswordEncoder(); 
		String password = scpwd.encode("1111"); 
		System.out.println(password);
	}

}
