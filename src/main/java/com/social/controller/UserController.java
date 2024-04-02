package com.social.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.models.User;

@RestController
public class UserController {

	@GetMapping("/users")
	public List<User> getUsers() {

		List<User> users = new ArrayList<>();

		User user1 = new User(1, "John", "Doe", "john.doe@gmail.com", "12345");
		User user2 = new User(2, "Jane", "Doe", "jane.doe@gmail.com", "123456");

		users.add(user1);
		users.add(user2);

		return users;
	}
}
