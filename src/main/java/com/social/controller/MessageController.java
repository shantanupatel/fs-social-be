package com.social.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.models.Message;

@RestController
public class MessageController {

	@GetMapping("/messages")
	public List<Message> getMessages() {
		List<Message> messages = new ArrayList<>();

		Message message1 = new Message(1, "Test Message 1");
		Message message2 = new Message(2, "Test Message 2");

		messages.add(message1);
		messages.add(message2);

		return messages;
	}
}
