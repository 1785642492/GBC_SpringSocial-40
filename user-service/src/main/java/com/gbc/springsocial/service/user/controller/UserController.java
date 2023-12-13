package com.gbc.springsocial.service.user.controller;

import com.gbc.springsocial.shared.model.User;
import com.gbc.springsocial.service.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	private final PostServiceClient postServiceClient;

	@GetMapping("/select")
	public List<User> select() {
		return userService.get();
	}

	/*@GetMapping("/select/{type}/{identifier}")
	public User select(@PathVariable String type, @PathVariable String identifier) {
		return userService.get(type, identifier);
	}*/

	@GetMapping("/select/{type}/{identifier}")
	public User select(@PathVariable String type, @PathVariable String identifier) {
		User user = userService.get(type, identifier);

		// Fetch post details using WebClient
		postServiceClient.getPostDetails(user.getPostId())
				.subscribe(post -> user.setPost(post)); // Assuming a setter for post in User model

		return user;
	}

	@PostMapping("/create")
	public Object create(User user) {
		return userService.create(user);
	}

	@PutMapping("/update")
	public Object update(User user) {
		return userService.update(user);
	}

	@DeleteMapping("/delete/{id}")
	public Object delete(@PathVariable String id) {
		return userService.delete(id);
	}
}
