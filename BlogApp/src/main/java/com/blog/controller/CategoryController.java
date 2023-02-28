package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.exception.CategoryException;
import com.blog.payloads.CategoryDTO;
import com.blog.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController
{
	@Autowired
	private CategoryService cService;

	@PostMapping("/create")
	public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categorydDto)
	{
		CategoryDTO cDto = cService.createCategory(categorydDto);

		return new ResponseEntity<CategoryDTO>(cDto, HttpStatus.CREATED);
	}

	@PutMapping("/update/{cid}")
	public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categorydDto,
			@PathVariable("cid") Integer catId) throws CategoryException
	{
		CategoryDTO cDto = cService.updateCategory(categorydDto, catId);

		return new ResponseEntity<CategoryDTO>(cDto, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{cid}")
	public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable("cid") Integer catId) throws CategoryException
	{
		CategoryDTO cDto = cService.deleteCategory(catId);

		return new ResponseEntity<CategoryDTO>(cDto, HttpStatus.ACCEPTED);
	}

	@GetMapping("/view/{cid}")
	public ResponseEntity<CategoryDTO> viewCategory(@PathVariable("cid") Integer catId) throws CategoryException
	{
		CategoryDTO cDto = cService.getCategory(catId);

		return new ResponseEntity<CategoryDTO>(cDto, HttpStatus.OK);
	}

	@GetMapping("/viewall")
	public ResponseEntity<List<CategoryDTO>> viewAllCategory()
	{
		List<CategoryDTO> cDtos = cService.getAllCategory();

		return new ResponseEntity<List<CategoryDTO>>(cDtos, HttpStatus.OK);
	}

}
