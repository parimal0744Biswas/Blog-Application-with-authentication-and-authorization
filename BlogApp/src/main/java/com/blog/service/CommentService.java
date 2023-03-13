package com.blog.service;

import org.springframework.stereotype.Service;

import com.blog.exception.CommentException;
import com.blog.exception.PostException;
import com.blog.payloads.CommentDTO;

@Service
public interface CommentService
{
	CommentDTO createComment(CommentDTO commentDTO, Integer postId) throws PostException;

	void deleteComment(Integer commentId) throws CommentException;

}
