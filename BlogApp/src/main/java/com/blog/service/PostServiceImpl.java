package com.blog.service;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.model.Post;
import com.blog.payloads.PostDTO;
import com.blog.repository.PostRepo;

@Service
public class PostServiceImpl implements PostService
{
	@Autowired
	private PostRepo pRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public PostDTO createPost(PostDTO pDto)
	{
		Post mapping = this.mapper.map(pDto, Post.class);
		mapping.setImageName("defaultImage.png");
		mapping.setAddedDate(new Date());

		Post savedPost = pRepo.save(mapping);
		return this.mapper.map(savedPost, PostDTO.class);
	}

	@Override
	public PostDTO updatePost(PostDTO pDtomDto, Integer postId)
	{

		return null;
	}

	@Override
	public PostDTO deletePost(Integer postId)
	{

		return null;
	}

	@Override
	public List<PostDTO> getAllPost()
	{

		return null;
	}

	@Override
	public PostDTO getPostById(Integer postId)
	{

		return null;
	}

	@Override
	public List<PostDTO> getPostsByCategory(Integer categoryId)
	{

		return null;
	}

	@Override
	public List<PostDTO> getPostsByUser(Integer userId)
	{

		return null;
	}

	@Override
	public List<PostDTO> searchPostsByKeyword(String keyword)
	{

		return null;
	}

	@Override
	public List<PostDTO> searchPostsByDates(Date date)
	{

		return null;
	}

}
