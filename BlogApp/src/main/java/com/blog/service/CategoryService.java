package com.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.exception.CategoryException;
import com.blog.payloads.CategoryDTO;

@Service
public interface CategoryService
{
	public CategoryDTO createCategory(CategoryDTO cDto);

	public CategoryDTO updateCategory(CategoryDTO cDto, Integer cId) throws CategoryException;

	public CategoryDTO deleteCategory(Integer cId) throws CategoryException;

	public CategoryDTO getCategory(Integer cId) throws CategoryException;

	public List<CategoryDTO> getAllCategory();

}
