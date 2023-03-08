package com.blog.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.catalog.CatalogException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.exception.CategoryException;
import com.blog.exception.PostException;
import com.blog.exception.UserException;
import com.blog.model.Category;
import com.blog.model.Post;
import com.blog.model.User;
import com.blog.payloads.PostDTO;
import com.blog.repository.CategoryRepo;
import com.blog.repository.PostRepo;
import com.blog.repository.UserRepo;

@Service
public class PostServiceImpl implements PostService
{
	@Autowired
	private PostRepo pRepo;

	@Autowired
	private UserRepo uRepo;

	@Autowired
	private CategoryRepo cRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public PostDTO createPost(PostDTO pDto, Integer userId, Integer categoryId)
	{
		Category existCategory = this.cRepo.findById(categoryId)
				.orElseThrow(() -> new CatalogException("Category Not Found"));

		User existUser = null;
		try
		{
			existUser = this.uRepo.findById(userId).orElseThrow(() -> new UserException("User Not Found"));
		}
		catch (UserException e)
		{
			e.printStackTrace();
		}

		Post mapping = this.mapper.map(pDto, Post.class);
		mapping.setImageName("defaultImage.png");
		mapping.setAddedDate(new Date());
		mapping.setCategory(existCategory);
		mapping.setUser(existUser);

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
		List<Post> posts = this.pRepo.findAll();

		return posts.stream().map(s -> this.mapper.map(s, PostDTO.class)).collect(Collectors.toList());
	}

	@Override
	public PostDTO getPostById(Integer postId) throws PostException
	{
		Post post = this.pRepo.findById(postId).orElseThrow(() -> new PostException("Post Not Found"));
		return this.mapper.map(post, PostDTO.class);
	}

	@Override
	public List<PostDTO> getPostsByCategory(Integer categoryId) throws CategoryException
	{
		Category category = this.cRepo.findById(categoryId).orElseThrow(() -> new CategoryException());

		List<Post> posts = category.getPosts();

		List<PostDTO> postDTOs = posts.stream().map(s -> this.mapper.map(s, PostDTO.class))
				.collect(Collectors.toList());

		return postDTOs;
	}

	@Override
	public List<PostDTO> getPostsByUser(Integer userId) throws UserException
	{
		User user = this.uRepo.findById(userId).orElseThrow(() -> new UserException("User Not Found"));
		List<Post> posts = user.getPosts();
		List<PostDTO> postDTOs = posts.stream().map(s -> this.mapper.map(s, PostDTO.class))
				.collect(Collectors.toList());

		return postDTOs;
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
