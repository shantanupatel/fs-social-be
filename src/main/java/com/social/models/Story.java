package com.social.models;

public class Story {

	public int id;
	public String storyDescription;

	public Story() {
	}

	public Story(int id, String storyDescription) {
		super();
		this.id = id;
		this.storyDescription = storyDescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStoryDescription() {
		return storyDescription;
	}

	public void setStoryDescription(String storyDescription) {
		this.storyDescription = storyDescription;
	}

}
