package com.social.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.models.Post;
import com.social.models.User;
import com.social.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	PostRepository postRepository;
	UserService userService;

	public PostServiceImpl() {
	}

	@Autowired
	public PostServiceImpl(PostRepository postRepository, UserService userService) {
		super();
		this.postRepository = postRepository;
		this.userService = userService;
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
	public String deletePost(int postId, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findPostByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post findPostById(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findAllPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post savedPost(int postId, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post likePost(int postId, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
