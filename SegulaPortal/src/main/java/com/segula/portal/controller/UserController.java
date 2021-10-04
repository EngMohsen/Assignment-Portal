package com.segula.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.segula.portal.dto.UserDto;
import com.segula.portal.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping(path = "/login", consumes = { "application/json" })
	private ResponseEntity<UserDto> saveAdvertisment(@RequestBody UserDto user) {
		if(userService.isAuthenticate(user.getUserName(), user.getPassword())) {
			return new ResponseEntity<UserDto>(user, HttpStatus.OK);
		}
		return new ResponseEntity<UserDto>(user, HttpStatus.UNAUTHORIZED);
	}

}
