package com.social.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.models.Story;

@RestController
public class StoryController {

	@GetMapping("/stories")
	public List<Story> getStories() {
		List<Story> stories = new ArrayList<>();

		Story story1 = new Story(1, "Test Story 1");
		Story story2 = new Story(1, "Test Story 2");

		stories.add(story1);
		stories.add(story2);

		return stories;
	}
}
