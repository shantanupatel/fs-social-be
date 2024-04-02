package com.social.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.models.Post;

@RestController
public class PostController {

	@GetMapping("/posts")
	public List<Post> getPosts() {
		List<Post> posts = new ArrayList<>();

		Post post1 = new Post(1, "Test Post 1");
		Post post2 = new Post(1, "Test Post 2");

		posts.add(post1);
		posts.add(post2);

		return posts;
	}
}
