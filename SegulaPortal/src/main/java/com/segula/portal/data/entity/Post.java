package com.segula.portal.data.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String url;
	private String slogan;
	private String client;
	private String description;
	private String position;
	private String location;
	private String portal;
	private String name;
	private String email;
	private String phone_number;
	private Date startDate;
	private Date endDate;
	private Date deadline;
	private String hours;

	@OneToMany(mappedBy = "post")
	private Set<Favorite> favoritePosts;
}
