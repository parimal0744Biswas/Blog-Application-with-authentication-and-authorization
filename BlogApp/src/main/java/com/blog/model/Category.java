package com.blog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "catId")
	private Integer categoryId;

	@Column(name = "title", length = 100, nullable = false)
	private String categoryTitle;

	@Column(name = "description")
	private String categoryDescription;

}
