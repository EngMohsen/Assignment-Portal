package com.segula.portal.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.segula.portal.data.entity.User;
import com.segula.portal.data.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public boolean isAuthenticate(String userName,String password) {
		User user = userRepository.findByUsername(userName);
		return user != null && user.getPassword().equals(password);
	}
}
