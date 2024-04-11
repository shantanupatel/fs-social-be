package com.social.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.models.Post;
import com.social.models.User;
import com.social.repository.PostRepository;
import com.social.repository.UserRepository;

@Service
public class PostServiceImpl implements PostService {

	PostRepository postRepository;
	UserService userService;
	UserRepository userRepository;

	public PostServiceImpl() {
	}

	@Autowired
	public PostServiceImpl(PostRepository postRepository, UserService userService, UserRepository userRepository) {
		super();
		this.postRepository = postRepository;
		this.userService = userService;
		this.userRepository = userRepository;
	}

	@Override
	public Post createNewPost(Post post, int userId) throws Exception {

		User user = userService.findUserById(userId);

		Post newPost = new Post();

		newPost.setCaption(post.getCaption());
		newPost.setImage(post.getImage());
		newPost.setVideo(post.getVideo());
		newPost.setUser(post.getUser());
		newPost.setUser(user);
		newPost.setCreatedAt(LocalDateTime.now());

		Post savedPost = postRepository.save(newPost);

		return savedPost;

	}

	@Override
	public String deletePost(int postId, int userId) throws Exception {

		Post post = findPostById(postId);
		User user = userService.findUserById(userId);

		if (post.getUser().getId() != user.getId()) {
			throw new Exception("Deleting another user's post is prohibited!");
		}

		postRepository.delete(post);

		return "Post with id " + postId + " has been deleted successfully";

	}

	@Override
	public List<Post> findPostByUserId(int userId) {

		return postRepository.findPostByUserId(userId);
	}

	@Override
	public Post findPostById(int postId) throws Exception {

		Optional<Post> post = postRepository.findById(postId);

		if (post.isEmpty()) {
			throw new Exception("Post with provided id " + postId + " not found");
		}

		return post.get();

	}

	@Override
	public List<Post> findAllPosts() {

		return postRepository.findAll();
	}

	@Override
	public Post savedPost(int postId, int userId) throws Exception {

		Post post = findPostById(postId);
		User user = userService.findUserById(userId);

		if (user.getSavedPost().contains(post)) {
			user.getSavedPost().remove(post);
		} else {
			user.getSavedPost().add(post);
		}

		userRepository.save(user);

		return post;
	}

	@Override
	public Post likePost(int postId, int userId) throws Exception {

		Post post = findPostById(postId);
		User user = userService.findUserById(userId);

		if (post.getLiked().contains(user)) {
			post.getLiked().remove(user);
		} else {
			post.getLiked().add(user);
		}

		return postRepository.save(post);
	}

}
