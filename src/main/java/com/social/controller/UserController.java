package com.social.controller;

import java.util.List;
import java.util.Optional;

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
import com.social.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@GetMapping
	public List<User> getUsers() {

		List<User> users = userRepository.findAll();

		return users;
	}

	@GetMapping("/{userId}")
	public User getUsersById(@PathVariable("userId") int id) throws Exception {
		Optional<User> user = userRepository.findById(id);

		if (user.isPresent()) {
			return user.get();
		}

		throw new Exception("User with specified id doesn't exist");
	}

	@PostMapping
	public User createUser(@RequestBody User user) {

		User savedUser = userService.registerUser(user);

		return savedUser;

	}

	@PutMapping("/{userId}")
	public User updateUser(@RequestBody User user, @PathVariable("userId") int id) throws Exception {

		Optional<User> matchingUser = userRepository.findById(id);

		if (matchingUser.isEmpty()) {
			throw new Exception("User with specified id " + id + " doesn't exist.");
		}

		User oldUser = matchingUser.get();

		if (user.getFirstName() != null) {
			oldUser.setFirstName(user.getFirstName());
		}

		if (user.getLastName() != null) {
			oldUser.setLastName(user.getLastName());
		}

		if (user.getEmail() != null) {
			oldUser.setEmail(user.getEmail());
		}

		if (user.getPassword() != null) {
			oldUser.setPassword(user.getPassword());
		}

		User updatedUser = userRepository.save(oldUser);

		return updatedUser;
	}

	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable int userId) throws Exception {

		Optional<User> user = userRepository.findById(userId);

		if (user.isEmpty()) {
			throw new Exception("User with specified id " + userId + " doesn't exist.");
		}

		userRepository.deleteById(userId);

		return "User with specified id " + userId + " has been deleted successfully.";

	}
}
