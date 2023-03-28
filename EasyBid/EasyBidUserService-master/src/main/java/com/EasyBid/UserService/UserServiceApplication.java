package com.EasyBid.UserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);

	}

/*	@GetMapping("/")
	public String welcome() {
		return "Welcome to EasyBid. Please Login or Register.";
	}*/

}
