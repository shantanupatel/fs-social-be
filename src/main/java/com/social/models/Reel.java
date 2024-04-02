package com.social.models;

public class Reel {

	public int id;
	public String reelLink;

	public Reel() {
	}

	public Reel(int id, String reelLink) {
		super();
		this.id = id;
		this.reelLink = reelLink;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReelLink() {
		return reelLink;
	}

	public void setReelLink(String reelLink) {
		this.reelLink = reelLink;
	}

}
