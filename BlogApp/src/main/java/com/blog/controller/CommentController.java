package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.exception.CommentException;
import com.blog.exception.PostException;
import com.blog.payloads.CommentDTO;
import com.blog.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController
{
	@Autowired
	private CommentService cService;

	@PostMapping("/post/{postId}")
	public ResponseEntity<CommentDTO> createComments(@RequestBody CommentDTO commentDTO,
			@PathVariable("postId") Integer postId) throws PostException
	{
		CommentDTO createComment = this.cService.createComment(commentDTO, postId);

		return new ResponseEntity<>(createComment, HttpStatus.CREATED);
	}

	@DeleteMapping("/post/{commentId}")
	public ResponseEntity<String> deleteComments(@PathVariable("commentId") Integer commentId)
			throws PostException, CommentException
	{
		this.cService.deleteComment(commentId);

		return new ResponseEntity<>("Post deleted Succsfully", HttpStatus.OK);
	}

}
