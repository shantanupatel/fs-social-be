package com.social.service;

import java.util.List;

import com.social.models.Post;

public interface PostService {

	Post createNewPost(Post post, int userId) throws Exception;

	String deletePost(int postId, int userId);

	List<Post> findPostByUserId(int userId);

	Post findPostById(int postId);

	List<Post> findAllPosts();

	Post savedPost(int postId, int userId);

	Post likePost(int postId, int userId);

}
