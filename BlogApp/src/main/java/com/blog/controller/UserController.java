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

import com.blog.exception.UserException;
import com.blog.payloads.UserDTO;
import com.blog.service.UserService;

@RestController
@RequestMapping("user")
public class UserController
{
	@Autowired
	private UserService uService;

	@PostMapping("/create")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto)
	{
		UserDTO uDto = this.uService.createUser(userDto);

		return new ResponseEntity<UserDTO>(uDto, HttpStatus.CREATED);
	}

	@PutMapping("/{uid}")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO uDto, @PathVariable("uid") Integer uid)
			throws UserException
	{
		UserDTO updateUser = this.uService.updateUser(uDto, uid);

		return new ResponseEntity<UserDTO>(updateUser, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{uid}")
	public ResponseEntity<UserDTO> deleteUser(@RequestBody UserDTO uDto, @PathVariable("uid") Integer uid)
			throws UserException
	{
		UserDTO updateUser = this.uService.updateUser(uDto, uid);

		return new ResponseEntity<UserDTO>(updateUser, HttpStatus.ACCEPTED);
	}

	@GetMapping("/{uid}")
	public ResponseEntity<UserDTO> viewUser(@PathVariable("uid") Integer uid) throws UserException
	{
		UserDTO user = this.uService.getUserByID(uid);

		return new ResponseEntity<UserDTO>(user, HttpStatus.ACCEPTED);
	}

	@GetMapping("/all")
	public ResponseEntity<UserDTO> viewAllUser() throws UserException
	{
		List<UserDTO> allUser = this.uService.getAllUser();

		return new ResponseEntity<List>(allUser, HttpStatus.ACCEPTED);
	}

}
