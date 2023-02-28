package com.blog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.exception.CategoryException;
import com.blog.model.Category;
import com.blog.payloads.CategoryDTO;
import com.blog.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService
{
	@Autowired
	private CategoryRepo cRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public CategoryDTO createCategory(CategoryDTO cDto)
	{
		Category registerCategory = this.cRepo.save(this.mapper.map(cDto, Category.class));
		return this.mapper.map(registerCategory, CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO cDto, Integer cId) throws CategoryException
	{
		Category category = this.cRepo.findById(cId).orElseThrow(() -> new CategoryException("Category Not Found"));
		return this.mapper.map(category, CategoryDTO.class);
	}

	@Override
	public CategoryDTO deleteCategory(Integer cId) throws CategoryException
	{

		Category category = this.cRepo.findById(cId).get();
		this.cRepo.deleteById(cId);
		return this.mapper.map(category, CategoryDTO.class);
	}

	@Override
	public CategoryDTO getCategory(Integer cId) throws CategoryException
	{
		Category category = this.cRepo.findById(cId).get();

		return this.mapper.map(category, CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> getAllCategory()
	{
		List<Category> categories = this.cRepo.findAll();

		List<CategoryDTO> listofDtos = categories.stream().map(s -> this.mapper.map(s, CategoryDTO.class))
				.collect(Collectors.toList());

		return listofDtos;

	}

}
