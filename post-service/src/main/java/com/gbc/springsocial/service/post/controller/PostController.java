package com.gbc.springsocial.service.post.controller;

import com.gbc.springsocial.shared.model.Post;
import com.gbc.springsocial.shared.model.User;
import com.gbc.springsocial.service.post.service.PostService;
import com.gbc.springsocial.service.post.service.UserServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
	private final PostService postService;
	private final UserServiceClient userServiceClient;

	@GetMapping("/select")
	public List<Post> select() {
		List<Post> posts = postService.select();
		posts.forEach(post -> post.setAuthor(getUserDetails(post.getUserId()).getUsername()));
		return posts;
	}

	@GetMapping("/select/user/{username}")
	public List<Post> select(@PathVariable String username) {
		List<Post> posts = postService.select(username);
		posts.forEach(post -> post.setAuthor(username));
		return posts;
	}

	@GetMapping("/select/{type}/{identifier}")
	public Post select(@PathVariable String type, @PathVariable String identifier) {
		Post post = postService.select(type, identifier);
		post.setAuthor(getUserDetails(post.getUserId()).getUsername());
		return post;
	}

	@PostMapping("/create")
	public Post create(Post post) {
		return postService.create(post);
	}

	@PutMapping("/update")
	public Post update(Post post) {
		return postService.update(post);
	}

	@DeleteMapping("/delete/unique/{id}")
	public Post delete(@PathVariable String id) {
		return postService.delete(id);
	}

	@DeleteMapping("/delete/user/{id}")
	public void deleteByUser(@PathVariable String id) {
		postService.deleteByUser(id);
	}
	private User getUserDetails(String userId) {
		return userServiceClient.getUserDetails(userId);
	}
}
