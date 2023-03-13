package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.CommentDTO;
import com.blog.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController
{
	@Autowired
	private CommentService cService;

	@PostMapping("/post")
	public ResponseEntity<CommentDTO> createComments()
	{
		return null;
	}

}
