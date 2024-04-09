package com.social.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.models.Post;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

	// @GetMapping()
	// public String getPost() {
	// return "Hello from Post";
	// }

	@PostMapping
	public Post createPost(@RequestBody Post post) {
		return null;
	}

	// deletePost

	// findPostByUserId

	// findAllPosts

	// savedPost

	// likePost
}
