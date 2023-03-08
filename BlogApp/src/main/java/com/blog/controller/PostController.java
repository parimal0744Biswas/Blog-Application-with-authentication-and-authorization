package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.exception.CategoryException;
import com.blog.exception.UserException;
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

	@GetMapping("/bycategory/{categoryId}")
	public ResponseEntity<List<PostDTO>> getPostsByCategory(@PathVariable("categoryId") Integer categoryId)
			throws CategoryException
	{
		List<PostDTO> listPostDTOs = this.pService.getPostsByCategory(categoryId);

		return new ResponseEntity<>(listPostDTOs, HttpStatus.ACCEPTED);
	}

	@GetMapping("/byuser/{userId}")
	public ResponseEntity<List<PostDTO>> getPostsByUserHandler(@PathVariable("userId") Integer userId)
			throws UserException
	{
		List<PostDTO> createdPost = this.pService.getPostsByUser(userId);

		return new ResponseEntity<>(createdPost, HttpStatus.ACCEPTED);
	}

}
