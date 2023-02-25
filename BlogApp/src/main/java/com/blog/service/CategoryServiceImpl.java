package com.blog.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

		return this.cRepo.save(mapper.map(cDto, Category.class));
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO cDto, Integer cId)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDTO deleteCategory(Integer cId)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDTO getCategory(Integer cId)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDTO> getAllCategory()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
