package com.social.service;

import com.social.models.Post;

public interface PostService {

	Post createNewPost(Post post, int userId) throws Exception;

}
