package com.social.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.models.Post;
import com.social.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

	PostService postService;

	public PostController() {
	}

	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@PostMapping("/user/{userId}")
	public ResponseEntity<Post> createPost(@RequestBody Post post, @PathVariable int userId) throws Exception {

		Post createdPost = postService.createNewPost(post, userId);

		return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
	}

	// deletePost

	// findPostByUserId

	// findAllPosts

	// savedPost

	// likePost
}
