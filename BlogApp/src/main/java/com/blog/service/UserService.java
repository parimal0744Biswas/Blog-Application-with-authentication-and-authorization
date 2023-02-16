package com.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.exception.UserException;
import com.blog.payloads.UserDTO;

@Service
public interface UserService
{

	public UserDTO createUser(UserDTO userdto);

	public UserDTO updateUser(UserDTO userdto, Integer id) throws UserException;

	public UserDTO getUserByID(Integer id) throws UserException;

	public List<UserDTO> getAllUser() throws UserException;

	public UserDTO deleteUserByID(Integer id) throws UserException;

}
