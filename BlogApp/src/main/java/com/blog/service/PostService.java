package com.blog.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.payloads.PostDTO;

@Service
public interface PostService
{
	PostDTO createPost(PostDTO pDto);

	PostDTO updatePost(PostDTO pDtomDto, Integer postId);

	PostDTO deletePost(Integer postId);

	List<PostDTO> getAllPost();

	PostDTO getPostById(Integer postId);

	List<PostDTO> getPostsByCategory(Integer categoryId);

	List<PostDTO> getPostsByUser(Integer userId);

	List<PostDTO> searchPostsByKeyword(String keyword);

	List<PostDTO> searchPostsByDates(Date date);

}
