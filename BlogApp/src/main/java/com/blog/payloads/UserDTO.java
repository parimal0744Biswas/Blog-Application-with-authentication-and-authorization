package com.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO
{

	private Integer id;

	@NotEmpty
	@Size(min = 4, message = "Username must be 4 charecter !!")
	private String name;

	@Email(message = "please type proper email !!")
	private String email;

	@NotEmpty
	@Size(min = 4, max = 10, message = "minimum length should be 4 and maximum 10")
	private String password;

	@NotEmpty
	private String about;
}
