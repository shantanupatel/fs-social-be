package com.social.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.models.Reel;

@RestController
public class ReelController {

	@GetMapping("/reels")
	public List<Reel> getReels() {
		List<Reel> reels = new ArrayList<>();

		Reel reel1 = new Reel(1, "https://www.youtube.com/shorts/EAhiVKmzeIA");
		Reel reel2 = new Reel(2, "https://www.youtube.com/shorts/3TPlGZWS1pE");

		reels.add(reel1);
		reels.add(reel2);

		return reels;
	}
}
