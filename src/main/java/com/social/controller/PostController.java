package com.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.models.Post;
import com.social.response.ApiResponse;
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

	@DeleteMapping("/{postId}/user/{userId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable int postId, @PathVariable int userId) throws Exception {

		String message = postService.deletePost(postId, userId);

		ApiResponse res = new ApiResponse(message, true);

		return new ResponseEntity<ApiResponse>(res, HttpStatus.OK);
	}

	@GetMapping("/{postId}")
	public ResponseEntity<Post> findPostByIdHandler(@PathVariable int postId) throws Exception {

		Post post = postService.findPostById(postId);

		return new ResponseEntity<Post>(post, HttpStatus.ACCEPTED);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Post>> findUsersPost(@PathVariable int userId) {

		List<Post> posts = postService.findPostByUserId(userId);

		return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Post>> findAllPosts() {

		List<Post> posts = postService.findAllPosts();

		return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
	}

	@PutMapping("/{postId}/user/{userId}")
	public ResponseEntity<Post> savedPostHandler(@PathVariable int postId, @PathVariable int userId) throws Exception {

		Post post = postService.savedPost(postId, userId);

		return new ResponseEntity<Post>(post, HttpStatus.ACCEPTED);
	}

	@PutMapping("/like/{postId}/user/{userId}")
	public ResponseEntity<Post> likePostHandler(@PathVariable int postId, @PathVariable int userId) throws Exception {

		Post post = postService.likePost(postId, userId);

		return new ResponseEntity<Post>(post, HttpStatus.ACCEPTED);
	}
}
