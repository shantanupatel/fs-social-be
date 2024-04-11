package com.social.service;

import java.util.List;

import com.social.models.Post;

public interface PostService {

	Post createNewPost(Post post, int userId) throws Exception;

	String deletePost(int postId, int userId) throws Exception;

	List<Post> findPostByUserId(int userId);

	Post findPostById(int postId) throws Exception;

	List<Post> findAllPosts();

	Post savedPost(int postId, int userId) throws Exception;

	Post likePost(int postId, int userId) throws Exception;

}
