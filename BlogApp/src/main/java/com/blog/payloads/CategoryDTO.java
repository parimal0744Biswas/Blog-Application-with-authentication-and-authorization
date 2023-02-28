package com.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDTO
{

	private Integer categoryId;

	@NotBlank
	@Size(min = 4, max = 10, message = "Title min 10 and max should be 10")
	private String categoryTitle;

	@NotBlank
	@Size(min = 10, message = "Description min should be 10")
	private String categoryDescription;

}
