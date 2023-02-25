package com.blog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.exception.UserException;
import com.blog.model.User;
import com.blog.payloads.UserDTO;
import com.blog.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepo uRepo;

	@Autowired
	private ModelMapper modelMapper;

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
	public UserDTO deleteUserByID(Integer id) throws UserException
	{
		User user = this.uRepo.findById(id).orElseThrow(() -> new UserException("User Not found"));

		this.uRepo.deleteById(id);

		return this.userToUserDTO(user);

	}

	private User DTOtoUser(UserDTO userDTO)
	{
		User user = this.modelMapper.map(userDTO, User.class);

//		User user = new User();
//
//		user.setId(userDTO.getId());
//		user.setName(userDTO.getName());
//		user.setAbout(userDTO.getAbout());
//		user.setEmail(userDTO.getEmail());
//		user.setPassword(userDTO.getPassword());

		return user;
	}

	private UserDTO userToUserDTO(User user)
	{
		UserDTO uDto = this.modelMapper.map(user, UserDTO.class);

		return uDto;
	}

}
