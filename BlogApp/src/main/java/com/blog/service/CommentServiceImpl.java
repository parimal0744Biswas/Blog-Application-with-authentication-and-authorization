package com.blog.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.exception.CommentException;
import com.blog.exception.PostException;
import com.blog.model.Comment;
import com.blog.model.Post;
import com.blog.payloads.CommentDTO;
import com.blog.repository.CommentRepo;
import com.blog.repository.PostRepo;

@Service
public class CommentServiceImpl implements CommentService
{
	@Autowired
	private PostRepo pRepo;

	@Autowired
	private CommentRepo cRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public CommentDTO createComment(CommentDTO commentDTO, Integer postId) throws PostException
	{
		Post post = this.pRepo.findById(postId).orElseThrow(() -> new PostException("Post Not Found"));

		Comment comment = this.mapper.map(commentDTO, Comment.class);
		comment.setPost(post);

		Comment savedComment = this.cRepo.save(comment);

		return this.mapper.map(savedComment, CommentDTO.class);

	}

	@Override
	public void deleteComment(Integer commentId) throws CommentException
	{
		Comment comment = this.cRepo.findById(commentId).orElseThrow(() -> new CommentException("Comment Not FOund"));

		// comment.get

		this.cRepo.delete(comment);

	}

}
