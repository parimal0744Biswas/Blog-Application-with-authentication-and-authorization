package com.blog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.exception.UserException;
import com.blog.model.User;
import com.blog.payloads.UserDTO;
import com.blog.repository.UserRepo;

public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepo uRepo;

	@Override
	public UserDTO createUser(UserDTO userdto)
	{
		User user = this.DTOtoUser(userdto);

		User savedUser = uRepo.save(user);

		return this.userToUserDTO(savedUser);
	}

	@Override
	public UserDTO updateUser(UserDTO userdto, Integer id) throws UserException
	{

		User user = this.uRepo.findById(id).orElseThrow(() -> new UserException("User Not found"));

		user.setName(userdto.getName());
		user.setEmail(userdto.getEmail());
		user.setAbout(userdto.getAbout());
		user.setPassword(userdto.getPassword());

		User updatedUser = this.uRepo.save(user);

		return this.userToUserDTO(updatedUser);
	}

	@Override
	public UserDTO getUserByID(Integer id) throws UserException
	{
		User user = this.uRepo.findById(id).orElseThrow(() -> new UserException("User Not found"));

		return this.userToUserDTO(user);
	}

	@Override
	public List<UserDTO> getAllUser() throws UserException
	{
		List<User> userlist = this.uRepo.findAll();

		List<UserDTO> dtolist = userlist.stream().map(user -> this.userToUserDTO(user)).collect(Collectors.toList());
		return dtolist;
	}

	@Override
	public UserDTO deleteUserByID(Integer id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private User DTOtoUser(UserDTO userDTO)
	{
		User user = new User();

		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setAbout(userDTO.getAbout());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());

		return user;
	}

	private UserDTO userToUserDTO(User user)
	{
		UserDTO uDto = new UserDTO();

		uDto.setAbout(user.getAbout());
		uDto.setEmail(user.getEmail());
		uDto.setId(user.getId());
		uDto.setName(user.getName());
		uDto.setPassword(user.getPassword());

		return uDto;
	}

}
