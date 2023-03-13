package com.blog.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "post")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Post
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;

	@Column(length = 1000, nullable = false)
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;

	@ManyToOne
	private Category category;

	@ManyToOne
	private User user;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "post", fetch = FetchType.EAGER)
	private Set<Comment> comments = new HashSet<>();

}
