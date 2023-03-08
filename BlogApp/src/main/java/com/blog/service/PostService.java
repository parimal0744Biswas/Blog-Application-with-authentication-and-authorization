package com.blog.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.exception.CategoryException;
import com.blog.exception.UserException;
import com.blog.payloads.PostDTO;

@Service
public interface PostService
{
	PostDTO createPost(PostDTO pDto, Integer userId, Integer categoryId);

	PostDTO updatePost(PostDTO pDtomDto, Integer postId);

	PostDTO deletePost(Integer postId);

	List<PostDTO> getAllPost();

	PostDTO getPostById(Integer postId);

	List<PostDTO> getPostsByCategory(Integer categoryId) throws CategoryException;

	List<PostDTO> getPostsByUser(Integer userId) throws UserException;

	List<PostDTO> searchPostsByKeyword(String keyword);

	List<PostDTO> searchPostsByDates(Date date);

}
