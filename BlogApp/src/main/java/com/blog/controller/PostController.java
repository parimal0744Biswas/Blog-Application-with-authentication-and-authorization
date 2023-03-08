package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.PostDTO;
import com.blog.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController
{
	@Autowired
	private PostService pService;

	// create
	@PostMapping("/create/{userId}/{categoryId}")
	public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO, @PathVariable("userId") Integer userId,
			@PathVariable("categoryId") Integer categoryId)
	{
		PostDTO createdPost = this.pService.createPost(postDTO, userId, categoryId);

		return new ResponseEntity<>(createdPost, HttpStatus.ACCEPTED);
	}

}
