package com.segula.portal.dto;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDto {
		
	private long id;
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
	private String[] links;
	
	
	
}
