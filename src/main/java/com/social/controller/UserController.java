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
import org.springframework.web.bind.annotation.RequestParam;
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

		User user = userService.findUserById(id);

		return user;
	}

	@PostMapping("/public/create")
	public User createUser(@RequestBody User user) {

		User savedUser = userService.registerUser(user);

		return savedUser;

	}

	@PutMapping("/{userId}")
	public User updateUser(@RequestBody User user, @PathVariable("userId") int id) throws Exception {

		User updatedUser = userService.updateUser(user, id);

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

	// @GetMapping("/search")
	// public User getUsersByEmail(@RequestParam String email) throws Exception {
	//
	// User user = userService.findUserByEmail(email);
	//
	// return user;
	// }

	@PutMapping("/follow/{userId1}/{userId2}")
	public User followUserHandler(@PathVariable int userId1, @PathVariable int userId2) throws Exception {

		User user = userService.followUser(userId1, userId2);

		return user;
	}

	@GetMapping("/search")
	public List<User> searchUser(@RequestParam("query") String query) {

		List<User> users = userService.searchUser(query);

		return users;

	}
}
