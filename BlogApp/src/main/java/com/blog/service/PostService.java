package com.blog.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.exception.CategoryException;
import com.blog.exception.PostException;
import com.blog.exception.UserException;
import com.blog.payloads.PostDTO;
import com.blog.payloads.PostResponse;

@Service
public interface PostService
{
	PostDTO createPost(PostDTO pDto, Integer userId, Integer categoryId);

	PostDTO updatePost(PostDTO pDtomDto, Integer postId) throws PostException;

	PostDTO deletePost(Integer postId) throws PostException;

	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

	PostDTO getPostById(Integer postId) throws PostException;

	List<PostDTO> getPostsByCategory(Integer categoryId) throws CategoryException;

	List<PostDTO> getPostsByUser(Integer userId) throws UserException;

	List<PostDTO> searchPostsByKeyword(String keyword);

	List<PostDTO> searchPostsByDates(Date date);

}
