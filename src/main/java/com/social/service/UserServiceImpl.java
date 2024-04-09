package com.social.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.models.User;
import com.social.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User registerUser(User user) {

		User newUser = new User();

		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());

		User savedUser = userRepository.save(newUser);

		return savedUser;

	}

	@Override
	public User findUserById(int userId) throws Exception {

		Optional<User> user = userRepository.findById(userId);

		if (user.isPresent()) {
			return user.get();
		}

		throw new Exception("User with specified id " + userId + " doesn't exist.");
	}

	@Override
	public User findUserByEmail(String email) throws Exception {

		Optional<User> user = userRepository.findByEmail(email);

		if (user.isPresent()) {
			return user.get();
		}

		throw new Exception("User with specified email doesn't exist");
	}

	@Override
	public User followUser(int userId1, int userId2) throws Exception {
		User user1 = findUserById(userId1);
		User user2 = findUserById(userId2);

		// list of followers for user2 should get updated with addition of id of user1
		user2.getFollowers().add(user1.getId());
		// list of followings for user1 should get updated with addition of id of user2
		user1.getFollowings().add(user2.getId());

		userRepository.save(user1);
		userRepository.save(user2);

		return user1;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> searchUser(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
