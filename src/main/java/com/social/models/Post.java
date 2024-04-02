package com.social.models;

public class Post {

	public int id;
	public String postTitle;

	public Post() {}

	public Post(int id, String postTitle) {
		super();
		this.id = id;
		this.postTitle = postTitle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

}
