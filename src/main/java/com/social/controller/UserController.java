package com.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.models.User;
import com.social.repository.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping
	public List<User> getUsers() {

		List<User> users = userRepository.findAll();

		return users;
	}

	@GetMapping("/{userId}")
	public User getUsersById(@PathVariable("userId") int id) {
		User user1 = new User(1, "John", "Doe", "john.doe@gmail.com", "12345");

		return user1;
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		User savedUser = userRepository.save(user);

		return savedUser;
	}

	@PutMapping
	public User updateUser(@RequestBody User user) {
		User user1 = new User(1, "John", "Doe", "john.doe@gmail.com", "12345");

		if (user.getFirstName() != null) {
			user1.setFirstName(user.getFirstName());
		}

		if (user.getLastName() != null) {
			user1.setLastName(user.getLastName());
		}

		if (user.getEmail() != null) {
			user1.setEmail(user.getEmail());
		}

		if (user.getPassword() != null) {
			user1.setPassword(user.getPassword());
		}

		return user1;
	}

	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable int userId) {
		return "User deleted successfully with id: " + userId;
	}
}
