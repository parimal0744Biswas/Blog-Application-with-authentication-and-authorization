package com.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.payloads.CategoryDTO;

@Service
public interface CategoryService
{
	public CategoryDTO createCategory(CategoryDTO cDto);

	public CategoryDTO updateCategory(CategoryDTO cDto, Integer cId);

	public CategoryDTO deleteCategory(Integer cId);

	public CategoryDTO getCategory(Integer cId);

	public List<CategoryDTO> getAllCategory();

}
