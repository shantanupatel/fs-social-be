package com.social.service;

import java.util.List;

import com.social.models.User;

public interface UserService {

	public User registerUser(User user);

	public User findUserById(int userId) throws Exception;

	public User findUserByEmail(String email) throws Exception;

	public User followUser(int userId1, int userId2) throws Exception;

	public User updateUser(User user);

	public List<User> searchUser(String query);

}
